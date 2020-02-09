package com.stanchenko.data;

import org.hibernate.Session;

public class Application {
    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        session.beginTransaction();
        session.close();
    }
}
