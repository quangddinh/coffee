/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qh.service;

import com.qh.pojo.Category;
import com.mycompany.coffeeshop.HibernateUtil;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

/**
 *
 * @author Dinh Quang
 */
public class CategoryService {

    private final static SessionFactory factory = HibernateUtil.getSessionFactory();

    public List<Category> getCategories() {
        try ( Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Category> query = builder.createQuery(Category.class);
            Root<Category> root = query.from(Category.class);
            query.select(root);

            return session.createQuery(query).getResultList();

        }
    }

    public Category getCategoryById(int catId) {
        try ( Session session = factory.openSession()) {
            return session.get(Category.class, catId);
        }
    }

}
