package com.stanchenko.data;

import com.stanchenko.data.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class Application {

    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        try {
            User user = new User();
            user.setFirstName("Serhii");
            user.setLastName("Tanchenko");
            user.setAge(28);
            user.setCreatedBy("Serhii Tanchenko");
            user.setCreatedDate(new Date());
            user.setEmailAddress("mail@stanchenko.com");
            user.setBirthDate(new Date());
            user.setLastUpdatedBy("ST");
            user.setLastUpdatedDate(new Date());
            user.setUserAddressLine1("street");
            user.setUserAddressLine2("K");
            user.setCity("Kyiv");
            user.setState("ST");
            user.setZipCode("54321");


            session.save(user);
            transaction.commit();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtils.getSessionFactory().close();
        }
    }
}
