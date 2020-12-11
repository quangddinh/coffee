package com.mycompany.coffeeshop;

import com.qh.pojo.Booking;
import com.qh.pojo.Capacity;
import com.qh.pojo.Category;
import com.qh.pojo.Payment;
import com.qh.pojo.PaymentDetail;
import com.qh.pojo.Product;
import com.qh.pojo.Timetable;
import com.qh.pojo.User;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static final SessionFactory FACTORY;

    static {
        Configuration configure = new Configuration();

        Properties pros = new Properties();
        pros.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        pros.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        pros.put(Environment.URL, "jdbc:mysql://localhost:3306/coffee");
        pros.put(Environment.USER, "root");
        pros.put(Environment.PASS, "85362378");
        pros.put(Environment.SHOW_SQL, true);
        //pros.put(Environment.VALIDATE_QUERY_PARAMETERS,true);

        configure.setProperties(pros);

        configure.addAnnotatedClass(Category.class);
        configure.addAnnotatedClass(Product.class);
        configure.addAnnotatedClass(User.class);
        configure.addAnnotatedClass(Payment.class);
        configure.addAnnotatedClass(PaymentDetail.class);
        configure.addAnnotatedClass(Capacity.class);
        configure.addAnnotatedClass(Timetable.class);
        configure.addAnnotatedClass(Booking.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(configure.getProperties()).build();

        FACTORY = configure
                .buildSessionFactory(registry);
    }

    public static SessionFactory getSessionFactory() {
        return FACTORY;
    }
}
