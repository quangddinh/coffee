package com.qh.service;

import com.qh.pojo.Payment;
import com.qh.pojo.PaymentDetail;
import com.mycompany.coffeeshop.HibernateUtil;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

    public List<PaymentDetail> getPayments() {
        try ( Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<PaymentDetail> query = builder.createQuery(PaymentDetail.class);
            Root<PaymentDetail> root = query.from(PaymentDetail.class);
            query.select(root);

            return session.createQuery(query).getResultList();

        }
    }

    public PaymentDetail getPaymentDetailById(int capID) {
        try ( Session session = factory.openSession()) {
            return session.get(PaymentDetail.class, capID);
        }
    }

}
