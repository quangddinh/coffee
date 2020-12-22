package com.qh.service;

import com.qh.pojo.Booking;
import com.mycompany.coffeeshop.HibernateUtil;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BookingService {

    private final static SessionFactory factory = HibernateUtil.getSessionFactory();

    public List<Booking> getBookings(String kw) {
        try ( Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Booking> query = builder.createQuery(Booking.class);
            Root<Booking> root = query.from(Booking.class);
            query.select(root);

            if (kw != null && !kw.isEmpty()) {
                String p = String.format("%%s%%", kw);

                Predicate p1 = builder.like(root.get("name").as(String.class), p);
                Predicate p2 = builder.like(root.get("description").as(String.class), p);

                query = query.where(builder.or(p1, p2));
            }

            return session.createQuery(query).getResultList();
        }
    }

    public boolean addOrSaveBooking(Booking p) {
        System.out.println("hello" + p.getTimetable());
        try ( Session session = factory.openSession()) {
            try {
                session.getTransaction().begin();
                session.saveOrUpdate(p);
                session.getTransaction().commit();
            } catch (Exception ex) {
                session.getTransaction().rollback();
                return false;
            }
        }
        return true;
    }

    public boolean deleteBooking(Booking b) {
        try ( Session session = factory.openSession()) {
            try {
                session.getTransaction().begin();
                session.delete(b);
                session.getTransaction().commit();
            } catch (Exception ex) {
                session.getTransaction().rollback();
                return false;
            }
        }
        return true;
    }

    public Booking getBookingyId(int bookId) {
        try ( Session session = factory.openSession()) {
            return session.get(Booking.class, bookId);
        }
    }
}
