package com.stanchenko.data.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "bank")
@Data
@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BANK_ID", insertable = false, nullable = false)
    private Long bankId;

    @Column(name = "NAME", nullable = false)
    private String NAME;

    @Column(name = "ADDRESS_LINE_1", nullable = false)
    private String addressLine1;

    @Column(name = "ADDRESS_LINE_2", nullable = false)
    private String addressLine2;

    @Column(name = "CITY", nullable = false)
    private String CITY;

    @Column(name = "STATE", nullable = false)
    private String STATE;

    @Column(name = "ZIP_CODE", nullable = false)
    private String zipCode;

    @Column(name = "IS_INTERNATIONAL", nullable = false)
    private Integer international;

    @Column(name = "LAST_UPDATED_BY", nullable = false)
    private String lastUpdatedBy;

    @Column(name = "LAST_UPDATED_DATE", nullable = false)
    private Timestamp lastUpdatedDate;

    @Column(name = "CREATED_BY", nullable = false)
    private String createdBy;

    @Column(name = "CREATED_DATE", nullable = false)
    private Timestamp createdDate;

    @Column(name = "ADDRESS_TYPE")
    private String addressType;

    
}