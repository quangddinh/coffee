package com.qh.service;

import com.mycompany.coffeeshop.HibernateUtil;
import com.qh.pojo.Booking;
import com.qh.pojo.PaymentDetail;
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
            System.out.println(rs);

            return rs;
        }
    }

//    public List<PaymentDetail> getTonghop() {
//        try ( Session session = factory.openSession()) {
//
//            Query<PaymentDetail> query = session.createQuery(
//                    "SELECT SUM(P.price * P.count) , SUM(P.count) , P.datcre "
//                    + "FROM PaymentDetail P "
//                    + "GROUP BY P.datcre "
//                    + "ORDER BY P.datcre DESC");
//
//            List<PaymentDetail> rs = query.list();
//            System.out.println(rs);
//            return rs;
//        }
//    }
    public List<PaymentDetail> getTotal() {
        try ( Session session = factory.openSession()) {

            Query<PaymentDetail> query = session.createQuery(
                    "SELECT SUM(P.price * P.count) "
                    + "FROM PaymentDetail P "
                    + "GROUP BY datcre "
                    + "ORDER BY datcre DESC");

            List<PaymentDetail> rs = query.list();
            System.out.println(rs);
            return rs;
        }
    }

    public List<PaymentDetail> getCountProduct() {
        try ( Session session = factory.openSession()) {
            Query<PaymentDetail> query = session.createQuery(
                    "SELECT SUM(P.count)"
                    + "FROM PaymentDetail P "
                    + "GROUP BY datcre "
                    + "ORDER BY datcre DESC");
            List<PaymentDetail> rs = query.list();

            return rs;
        }
    }

    public List<PaymentDetail> getDatcre() {
        try ( Session session = factory.openSession()) {
            Query<PaymentDetail> query = session.createQuery(
                    "SELECT P.datcre "
                    + "FROM PaymentDetail P "
                    + "GROUP BY datcre "
                    + "ORDER BY datcre DESC");
            List<PaymentDetail> rs = query.list();

            return rs;
        }
    }

    public List<PaymentDetail> getQuarter() {
        try ( Session session = factory.openSession()) {
            Query<PaymentDetail> query = session.createQuery(
                    "SELECT QUARTER(datcre) "
                    + "FROM PaymentDetail "
                    + "WHERE YEAR(datcre) = 2020 "
                    + "GROUP BY QUARTER(datcre) "
                    + "ORDER BY QUARTER(datcre) ");
            List<PaymentDetail> rs = query.list();

            return rs;
        }
    }

    public List<PaymentDetail> getQuarterTotal() {
        try ( Session session = factory.openSession()) {
            Query<PaymentDetail> query = session.createQuery(
                    "SELECT SUM(P.price * P.count) "
                    + "FROM PaymentDetail P "
                    + "WHERE YEAR(P.datcre) = 2020 "
                    + "GROUP BY QUARTER(datcre) "
                    + "ORDER BY QUARTER(datcre)  ");
            List<PaymentDetail> rs = query.list();

            return rs;
        }
    }

    public List<PaymentDetail> getProductQuarter() {
        try ( Session session = factory.openSession()) {
            Query<PaymentDetail> query = session.createQuery(
                    "SELECT SUM(P.count) "
                    + "FROM PaymentDetail P "
                    + "WHERE YEAR(P.datcre) = 2020 "
                    + "GROUP BY QUARTER(datcre) "
                    + "ORDER BY QUARTER(datcre) ");
            List<PaymentDetail> rs = query.list();

            return rs;
        }
    }

    public List<PaymentDetail> getMonth() {
        try ( Session session = factory.openSession()) {
            Query<PaymentDetail> query = session.createQuery(
                    "SELECT MONTH(datcre) "
                    + "FROM PaymentDetail "
                    + "GROUP BY MONTH(datcre) "
                    + "ORDER BY MONTH(datcre) DESC");
            List<PaymentDetail> rs = query.list();

            return rs;
        }
    }

    public List<PaymentDetail> getMonthTotal() {
        try ( Session session = factory.openSession()) {
            Query<PaymentDetail> query = session.createQuery(
                    "SELECT SUM(P.price * P.count) "
                    + "FROM PaymentDetail P "
                    + "GROUP BY MONTH(datcre) "
                    + "ORDER BY MONTH(datcre) DESC ");
            List<PaymentDetail> rs = query.list();

            return rs;
        }
    }

    public List<PaymentDetail> getProductMonth() {
        try ( Session session = factory.openSession()) {
            Query<PaymentDetail> query = session.createQuery(
                    "SELECT SUM(P.count) "
                    + "FROM PaymentDetail P "
                    + "GROUP BY MONTH(datcre) "
                    + "ORDER BY MONTH(datcre) DESC ");
            List<PaymentDetail> rs = query.list();

            return rs;
        }
    }

    public List<PaymentDetail> getYearTotal() {
        try ( Session session = factory.openSession()) {
            Query<PaymentDetail> query = session.createQuery(
                    "SELECT SUM(P.price * P.count) "
                    + "FROM PaymentDetail P "
                    + "GROUP BY YEAR(datcre)");
            List<PaymentDetail> rs = query.list();

            return rs;
        }
    }

    public List<PaymentDetail> getProductYear() {
        try ( Session session = factory.openSession()) {
            Query<PaymentDetail> query = session.createQuery(
                    "SELECT SUM(P.count) "
                    + "FROM PaymentDetail P "
                    + "GROUP BY YEAR(datcre) "
                    + "ORDER BY YEAR(datcre) DESC");
            List<PaymentDetail> rs = query.list();

            return rs;
        }
    }

    public List<PaymentDetail> getYear() {
        try ( Session session = factory.openSession()) {
            Query<PaymentDetail> query = session.createQuery(
                    "SELECT YEAR(datcre) "
                    + "FROM PaymentDetail "
                    + "GROUP BY YEAR(datcre) ");
            List<PaymentDetail> rs = query.list();

            return rs;
        }
    }

}
