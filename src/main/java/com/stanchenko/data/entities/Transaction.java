package com.stanchenko.data.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "transaction")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID", insertable = false, nullable = false)
    private Long transactionId;

    @Column(name = "ACCOUNT_ID", nullable = false, insertable = false, updatable = false)
    private Long accountId;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID", nullable = false, insertable = false, updatable = false)
    private Account account;

    @Column(name = "TRANSACTION_TYPE", nullable = false)
    private String transactionType;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount;

    @Column(name = "INITIAL_BALANCE", nullable = false)
    private BigDecimal initialBalance;

    @Column(name = "CLOSING_BALANCE", nullable = false)
    private BigDecimal closingBalance;

    @Column(name = "NOTES")
    private String notes;

    @Column(name = "LAST_UPDATED_BY", nullable = false)
    private String lastUpdatedBy;

    @Column(name = "LAST_UPDATED_DATE", nullable = false)
    private Date lastUpdatedDate;

    @Column(name = "CREATED_BY", nullable = false)
    private String createdBy;

    @Column(name = "CREATED_DATE", nullable = false)
    private Date createdDate;
}