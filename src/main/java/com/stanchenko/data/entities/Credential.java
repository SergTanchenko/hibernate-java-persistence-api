package com.stanchenko.data.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "credential")
public class Credential implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, name = "CREDENTIAL_ID", nullable = false)
    private Long credentialId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;


}