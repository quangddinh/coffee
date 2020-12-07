package com.qh.service;

import com.mycompany.coffeeshop.HibernateUtil;
import com.qh.pojo.Capacity;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CapacityService {

    private final static SessionFactory factory = HibernateUtil.getSessionFactory();

    public List<Capacity> getCapacities() {
        try ( Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Capacity> query = builder.createQuery(Capacity.class);
            Root<Capacity> root = query.from(Capacity.class);
            query.select(root);

            return session.createQuery(query).getResultList();

        }
    }

    public Capacity getCapacityById(int capID) {
        try ( Session session = factory.openSession()) {
            return session.get(Capacity.class, capID);
        }
    }

}
