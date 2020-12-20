package com.qh.service;

import com.mycompany.coffeeshop.HibernateUtil;
import com.qh.pojo.Booking;
import com.qh.pojo.Timetable;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class SelectService {

    private final static SessionFactory factory = HibernateUtil.getSessionFactory();

    public static List<Booking> callStore() {
        try ( Session session = factory.openSession()) {

//            CriteriaBuilder builder = session.getCriteriaBuilder();
//            CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
//            Root<Booking> bRoot = query.from(Booking.class);
//            Root<Timetable> tRoot = query.from(Timetable.class);
//
//            query.multiselect(bRoot.get("date"),
//                    bRoot.get("name").as(String.class),
//                    bRoot.get("phone").as(String.class));
//            query.select(bRoot.get("date"));
//            query.select(bRoot.get("name"));
            // show dc
//            query.where(builder.equal(bRoot.get("timetable"), tRoot.get("id")));
//
//            query.groupBy(bRoot.get("date"));
//
//            query.orderBy(builder.asc(bRoot.get("date")));
//
//            //
//            Query<Object[]> q1 = session.createQuery(query);
//            List<Object[]> rs = q1.getResultList();
//            rs.forEach(obj -> {
//                System.out.printf("%s: %d - %.2f",
//                        obj[0], obj[1], obj[2],
//                        obj[3]);
//            });
//            for (Object[] obj : rs) {
//                System.out.println("object 1" + obj[1]);
//
//            }
            Query<Booking> query = session.createQuery("FROM Booking ORDER BY DATE ASC");
            List<Booking> rs = query.list();
            System.out.println("So luong sp: " + rs);
            return rs;
        }
    }

//    public static List<Booking> callStore1() {
//        try ( Session session = factory.openSession()) {
//            Date fromDate = new Date();
//            CriteriaBuilder builder = session.getCriteriaBuilder();
//            CriteriaQuery<Booking> query = builder.createQuery(Booking.class);
//            Root<Booking> root = query.from(Booking.class);
//            query.select(root);
//
//            Predicate p1 = builder.greaterThanOrEqualTo(
//                    root.get("date").as(Date.class), fromDate);
//
//            Predicate p2 = builder.lessThanOrEqualTo(
//                    root.get("date").as(Date.class), toDate);
//
//            query = query.where(builder.and(p1, p2));
//
//            List<Booking> rs1 = session.createQuery(query).getResultList();
//
//            return rs1;
//        }
//    }
}
