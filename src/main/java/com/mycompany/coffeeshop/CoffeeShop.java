package com.mycompany.coffeeshop;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;

public class CoffeeShop {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF8"));

        Date date = new Date();
        System.out.println(date);
        System.out.println("hello");
//        callStore();

    }
}
