package com.stanchenko.data.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "account")
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_ID", insertable = false, nullable = false)
    private Long accountId;

    @Column(name = "BANK_ID")
    private Long bankId;

    @Column(name = "ACCOUNT_TYPE")
    private String accountType;

    @Column(name = "NAME")
    private String NAME;

    @Column(name = "INITIAL_BALANCE", nullable = false)
    private BigDecimal initialBalance;

    @Column(name = "CURRENT_BALANCE", nullable = false)
    private BigDecimal currentBalance;

    @Column(name = "OPEN_DATE", nullable = false)
    private Date openDate;

    @Column(name = "CLOSE_DATE", nullable = false)
    private Date closeDate;

    @Column(name = "LAST_UPDATED_BY", nullable = false)
    private String lastUpdatedBy;

    @Column(name = "LAST_UPDATED_DATE")
    private Timestamp lastUpdatedDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DATE")
    private Timestamp createdDate;

    
}