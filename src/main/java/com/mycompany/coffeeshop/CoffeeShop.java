package com.mycompany.coffeeshop;

import com.qh.pojo.Category;
import com.qh.pojo.Product;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;

public class CoffeeShop {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF8"));
// B1: tạo session để truy vấn
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            /*
            Query<Category> query = session.createQuery("FROM Category");
            List<Category> cats = query.list();
            cats.forEach(c -> System.out.println(c.getName()));
            ĐỌC DỮ LIỆU
             */

//B2: nếu sửa hoặc ghi thì thêm TRANSACTION
            /*
            session.getTransaction().begin();
            Category c = session.get(Category.class, 2);
            Product p = new Product();
            p.setName("Dell Alienware M15 R3");
            p.setDescription("Dark side of the Moon");
            p.setPrice(new BigDecimal(50000000));
            p.setCategory(c);

            session.getTransaction().commit();
            session.save(p);
             */
        }

    }
}
