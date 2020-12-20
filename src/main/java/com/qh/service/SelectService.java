package com.qh.service;

import com.mycompany.coffeeshop.HibernateUtil;
import com.qh.pojo.Booking;
import com.qh.pojo.Timetable;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class SelectService {

    private final static SessionFactory factory = HibernateUtil.getSessionFactory();

    public static void callStore() {
        try ( Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
            Root<Booking> bRoot = query.from(Booking.class);
            Root<Timetable> tRoot = query.from(Timetable.class);

//            query.multiselect(builder.count(root.get("id")),
//                    builder.max(root.get("capacity")).as(String.class));
            query.where(builder.equal(bRoot.get("timetable"), tRoot.get("id")));
            query.multiselect(bRoot.get("date").as(String.class));
            query.multiselect(tRoot.get("time").as(String.class));
            query.multiselect(bRoot.get("name").as(String.class));
            query.multiselect(bRoot.get("phone").as(String.class));

            query.groupBy(bRoot.get("date").as(String.class));
            query.orderBy(builder.asc(bRoot.get("date").as(String.class)));

            Query<Object[]> q1 = session.createQuery(query);
            List<Object[]> rs = q1.getResultList();

            rs.forEach(obj -> {
                System.out.printf("Ngay: %s\nThoi gian: %d\n"
                        + "Ten: %s\nSo dien thoai: %d\n",
                        obj[0], obj[1], obj[2],
                        obj[3]);
            });

//            for (Object[] obj : rs) {
//                System.out.printf("Ngay: %s\nThoi gian: %d\n"
//                        + "Ten: %s\nSo dien thoai: %d\n"
//                        + obj[0], obj[1], obj[2], obj[3]);
//
//            }
//            System.out.println("So luong sp: " + r[1]);
        }

    }
}
