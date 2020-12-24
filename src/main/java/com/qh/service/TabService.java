package com.qh.service;

import com.mycompany.coffeeshop.HibernateUtil;
import com.qh.pojo.TableSeat;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TabService {

    private final static SessionFactory factory = HibernateUtil.getSessionFactory();

    public List<TableSeat> getTabs() {
        try ( Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<TableSeat> query = builder.createQuery(TableSeat.class);
            Root<TableSeat> root = query.from(TableSeat.class);
            query.select(root);

            return session.createQuery(query).getResultList();

        }
    }

    public TableSeat getTabById(int tabID) {
        try ( Session session = factory.openSession()) {
            return session.get(TableSeat.class, tabID);
        }
    }

}
