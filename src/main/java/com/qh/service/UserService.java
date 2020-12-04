/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qh.service;

import com.qh.pojo.User;
import com.mycompany.coffeeshop.HibernateUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Dinh Quang
 */
public class UserService {

    private final static SessionFactory factory = HibernateUtil.getSessionFactory();

    public boolean addUser(User u) {
        try ( Session session = factory.openSession()) {
            try {
                session.getTransaction().begin();

                u.setPassword(DigestUtils.md5Hex(u.getPassword()));
                session.save(u);
                session.getTransaction().commit();
                return true;
            } catch (Exception ex) {
                session.getTransaction().rollback();
            }
        }
        return false;
    }
}
