package com.qh.service;

import com.qh.pojo.Payment;
import com.qh.pojo.PaymentDetail;
import com.mycompany.coffeeshop.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PaymentService {

    private final static SessionFactory factory = HibernateUtil.getSessionFactory();

    public boolean addPayment(Payment payment, List<PaymentDetail> details) {
        try ( Session session = factory.openSession()) {
            try {
                session.getTransaction().begin();
                session.save(payment);
                for (PaymentDetail detail : details) {
                    session.save(detail);
                }
                session.getTransaction().commit();
                return true;
            } catch (Exception ex) {
                session.getTransaction().rollback();
                return false;
            }
        }
    }

}
