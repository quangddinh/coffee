package com.qh.service;

import com.mycompany.coffeeshop.HibernateUtil;
import com.qh.pojo.Booking;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class SelectService {

    private final static SessionFactory factory = HibernateUtil.getSessionFactory();

    public static List<Booking> callStore() {
        try ( Session session = factory.openSession()) {

            Query<Booking> query = session.createQuery("FROM Booking ORDER BY DATE ASC");

            List<Booking> rs = query.list();

            return rs;
        }
    }

}
