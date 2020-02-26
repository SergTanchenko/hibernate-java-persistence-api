package com.stanchenko.data.entities;

import lombok.Data;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Date;

@Table(name = "finances_user")
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", insertable = false, nullable = false)
    private Long userId;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "BIRTH_DATE", nullable = false)
    private Date birthDate;

    @Column(name = "EMAIL_ADDRESS", nullable = false)
    private String emailAddress;

    @Column(name = "LAST_UPDATED_BY", nullable = false)
    private String lastUpdatedBy;

    @Column(name = "LAST_UPDATED_DATE", nullable = false)
    private java.util.Date lastUpdatedDate;

    @Column(name = "CREATED_BY", updatable = false)
    private String createdBy;

    @Column(name = "CREATED_DATE", updatable = false)
    private Date createdDate;

    @Column(name = "USER_ADDRESS_LINE_1")
    private String userAddressLine1;

    @Column(name = "USER_ADDRESS_LINE_2")
    private String userAddressLine2;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    @Formula("lower(datediff(curdate(), birth_date)/365)")
    private int age;
}