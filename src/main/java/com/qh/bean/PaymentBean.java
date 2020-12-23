package com.qh.bean;

import com.qh.pojo.Payment;
import com.qh.pojo.PaymentDetail;
import com.qh.pojo.Product;
import com.qh.service.PaymentService;
import com.qh.service.ProductService;
import com.qh.service.SelectService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
@Named(value = "paymentBean")
@RequestScoped
public class PaymentBean {

    private static final ProductService productService = new ProductService();
    private static final PaymentService paymentService = new PaymentService();
    private final static SelectService selectSerice = new SelectService();

    private String img;

    public PaymentBean() {
    }

    public String add() {
        Map<Integer, Object> cart = (Map<Integer, Object>) FacesContext.getCurrentInstance()
                .getExternalContext()
                .getSessionMap().get("cart");

        if (cart != null) {
            Payment p = new Payment();
            p.setCreatedDate(new Date());
            Date da = new Date();

            List<PaymentDetail> details = new ArrayList<>();
            List<Map<String, Object>> kq = new ArrayList<>();
            for (Object o : cart.values()) {
                Map<String, Object> d = (Map<String, Object>) o;

                Product product = productService
                        .getProductById(Integer.parseInt(d.get("productId").toString()));

                PaymentDetail detail = new PaymentDetail();
                detail.setPayment(p);
                detail.setDatcre(da);
                detail.setProduct(product);
                detail.setImg(img);
                detail.setPrice(product.getPrice());
                detail.setCount(Integer.parseInt(d.get("count").toString()));
                details.add(detail);
            }
            if (paymentService.addPayment(p, details) == true) {
                FacesContext.getCurrentInstance()
                        .getExternalContext()
                        .getSessionMap()
                        .remove("cart");
                return "index?faces-redirect-true";
            }
        }
        return "payment";

    }

//    public List<PaymentDetail> getSelects() {
//        List<PaymentDetail> selects = selectSerice.callStore1();
//        return selects;
//    }
    public List<PaymentDetail> getTotal() {
        return selectSerice.getTotal();
    }

    public List<PaymentDetail> getCount() {
        return selectSerice.getCountProduct();
    }

    public List<PaymentDetail> getDatcre() {
        return selectSerice.getDatcre();
    }

    public List<PaymentDetail> getQuarter() {
        return selectSerice.getQuarter();
    }

    public List<PaymentDetail> getMonth() {
        return selectSerice.getMonth();
    }

    public List<PaymentDetail> getYears() {
        return selectSerice.getYear();
    }

    public List<PaymentDetail> getYearTotal() {
        return selectSerice.getYearTotal();
    }

    public List<PaymentDetail> getYearProduct() {
        return selectSerice.getProductYear();
    }

    public List<PaymentDetail> getQuarterTotal() {
        return selectSerice.getQuarterTotal();
    }

    public List<PaymentDetail> getQuarterProduct() {
        return selectSerice.getProductQuarter();
    }

    public List<PaymentDetail> getMonthTotal() {
        return selectSerice.getMonthTotal();
    }

    public List<PaymentDetail> getMonthProduct() {
        return selectSerice.getProductMonth();
    }

}
