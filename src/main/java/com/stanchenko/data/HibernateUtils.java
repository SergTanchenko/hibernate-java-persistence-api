package com.stanchenko.data;

import com.stanchenko.data.entities.Account;
import com.stanchenko.data.entities.Credential;
import com.stanchenko.data.entities.Transaction;
import com.stanchenko.data.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

@Slf4j
public class HibernateUtils {
    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Account.class);
            configuration.addAnnotatedClass(Credential.class);
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Transaction.class);
            return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
        } catch (Exception e) {
            throw new RuntimeException("Can't initialize session factory", e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}
