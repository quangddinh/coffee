/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qh.service;

import com.mycompany.coffeeshop.HibernateUtil;
import com.qh.pojo.Timetable;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TimetableService {

    private final static SessionFactory factory = HibernateUtil.getSessionFactory();

    public List<Timetable> getTimetable() {
        try ( Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Timetable> query = builder.createQuery(Timetable.class);
            Root<Timetable> root = query.from(Timetable.class);
            query.select(root);

            return session.createQuery(query).getResultList();

        }
    }

    public Timetable getTimetableById(int timeID) {
        try ( Session session = factory.openSession()) {
            return session.get(Timetable.class, timeID);
        }
    }

}
