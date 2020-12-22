package com.qh.bean;

import com.qh.pojo.Category;
import com.qh.pojo.Product;
import com.qh.service.ProductService;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dinh Quang
 */
@ManagedBean
@Named(value = "productBean")
@RequestScoped
public class ProductBean {

    private int productId;
    private String name;
    private String description;
    private String img;
    private BigDecimal price;
    private Category category;

    private final static ProductService proService = new ProductService();

    public ProductBean() {
        if (!FacesContext.getCurrentInstance().isPostback()) {

            String proId = FacesContext.getCurrentInstance().getExternalContext()
                    .getRequestParameterMap().get("product_id");

            if (proId != null && !proId.isEmpty()) {

                Product p = proService.getProductById(Integer.parseInt(proId));
                this.productId = p.getId();
                this.name = p.getName();
                this.description = p.getDescription();
                this.price = p.getPrice();
                this.category = p.getCategory();
                this.img = p.getImg();
            }
        }
    }

    public List<Product> getProducts() {
        List<Product> products = proService.getProducts(null);
        return products;
    }
//------------------------------------------thêm sp

    public String addProduct() {
        Product p;
        if (this.productId > 0) {
            p = proService.getProductById(this.productId);
        } else {
            p = new Product();
        }

        p.setName(this.name);
        p.setDescription(this.description);
        p.setImg(this.img);
        p.setPrice(this.price);
        p.setCategory(this.category);

        if (proService.addOrSaveProduct(p) == true) {
            return "product-list?faces-redirect=true";
        }

        return "products";
    }
//-------------------------------------------delete

    public String deleteProduct(Product p) throws Exception {
        if (proService.deleteProduct(p)) {
            return "successful";
        }
        throw new Exception("Sai roi");
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
