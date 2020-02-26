package com.stanchenko.data;

import com.stanchenko.data.entities.Credential;
import com.stanchenko.data.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

@Slf4j
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

            Credential credential = new Credential();
            credential.setUsername("user2");
            credential.setPassword("pass1");

            credential.setUser(user);
            user.setCredential(credential);

            session.save(credential);

            transaction.commit();

            User dbUser = (User) session.get(User.class, credential.getUser().getUserId());
            log.info("User name from DB: {}", dbUser.getFirstName());
        } catch (Exception e) {
            log.error("Failed during save", e);
        } finally {
            session.close();
            HibernateUtils.getSessionFactory().close();
        }
    }
}
