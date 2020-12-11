/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qh.bean;

import com.qh.pojo.Payment;
import com.qh.pojo.PaymentDetail;
import com.qh.pojo.Product;
import com.qh.service.PaymentService;
import com.qh.service.ProductService;
import java.text.SimpleDateFormat;
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

//            SimpleDateFormat datefor = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
//            String stringDate = datefor.format(p.getCreatedDate());
//
//            System.out.println(stringDate);
//            System.out.println("hello");
//            System.out.println("Test Date Payment" + p.getCreatedDate());
            List<PaymentDetail> details = new ArrayList<>();
            List<Map<String, Object>> kq = new ArrayList<>();
            for (Object o : cart.values()) {
                Map<String, Object> d = (Map<String, Object>) o;

                Product product = productService
                        .getProductById(Integer.parseInt(d.get("productId").toString()));

                PaymentDetail detail = new PaymentDetail();
                detail.setPayment(p);
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
}
