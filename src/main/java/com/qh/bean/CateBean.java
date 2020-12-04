/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qh.bean;

import com.qh.pojo.Category;
import com.qh.pojo.Product;
import com.qh.service.CategoryService;
import com.qh.service.ProductService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Dinh Quang
 */
@ManagedBean
@Named(value = "cateBean")
@SessionScoped
public class CateBean implements Serializable {

    private final static CategoryService cateService = new CategoryService();

    public CateBean() {
    }

    public List<Category> getCategories() {
        return cateService.getCategories();
    }

}
