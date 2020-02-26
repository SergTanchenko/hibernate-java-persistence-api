package com.stanchenko.data;

import com.stanchenko.data.entities.Account;
import com.stanchenko.data.entities.Credential;
import com.stanchenko.data.entities.Transaction;
import com.stanchenko.data.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.util.Date;

;

@Slf4j
public class Application {

    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        org.hibernate.Transaction transaction = session.beginTransaction();

        try {
            Account account = createNewAccount();
            account.getTransactionList().add(createShoePurchase());
            account.getTransactionList().add(createNewBeltPurchase());

            session.save(account);
            transaction.commit();

            Transaction dbTransaction = (Transaction) session.get(Transaction.class, account.getTransactionList().get(0).getTransactionId());
            log.info("Db transaction title: {}", dbTransaction.getTitle());
        } catch (Exception e) {
            log.error("Failed during save", e);
        } finally {
            session.close();
            HibernateUtils.getSessionFactory().close();
        }
    }

    private static Transaction createNewBeltPurchase() {
        Transaction beltPurchase = new Transaction();
        beltPurchase.setTitle("Dress Belt");
        beltPurchase.setAmount(new BigDecimal("50.00"));
        beltPurchase.setClosingBalance(new BigDecimal("0.00"));
        beltPurchase.setCreatedBy("Serhii Tanchenko");
        beltPurchase.setCreatedDate(new Date());
        beltPurchase.setInitialBalance(new BigDecimal("0.00"));
        beltPurchase.setLastUpdatedBy("Serhii Tanchenko");
        beltPurchase.setLastUpdatedDate(new Date());
        beltPurchase.setNotes("New Dress Belt");
        beltPurchase.setTransactionType("Debit");
        return beltPurchase;
    }

    private static Transaction createShoePurchase() {
        Transaction shoePurchase = new Transaction();
        shoePurchase.setTitle("Work Shoes");
        shoePurchase.setAmount(new BigDecimal("100.00"));
        shoePurchase.setClosingBalance(new BigDecimal("0.00"));
        shoePurchase.setCreatedBy("Serhii Tanchenko");
        shoePurchase.setCreatedDate(new Date());
        shoePurchase.setInitialBalance(new BigDecimal("0.00"));
        shoePurchase.setLastUpdatedBy("Serhii Tanchenko");
        shoePurchase.setLastUpdatedDate(new Date());
        shoePurchase.setNotes("Nice Pair of Shoes");
        shoePurchase.setTransactionType("Debit");
        return shoePurchase;
    }

    private static Account createNewAccount() {
        Account account = new Account();
        account.setCloseDate(new Date());
        account.setOpenDate(new Date());
        account.setCreatedBy("Serhii Tanchenko");
        account.setInitialBalance(new BigDecimal("50.00"));
        account.setName("Savings Account");
        account.setCurrentBalance(new BigDecimal("100.00"));
        account.setLastUpdatedBy("Serhii Tanchenko");
        account.setLastUpdatedDate(new Date());
        account.setCreatedDate(new Date());
        return account;
    }


    private static Credential createCredential() {
        Credential credential = new Credential();
        credential.setUsername("user2");
        credential.setPassword("pass1");
        return credential;
    }

    private static User createUser() {
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
        return user;
    }
}
