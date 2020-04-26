package com.stanchenko.data.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "budget")
public class Budget implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, name = "BUDGET_ID", nullable = false)
    private Long budgetId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "GOAL_AMOUNT", nullable = false)
    private BigDecimal goalAmount;

    @Column(name = "PERIOD", nullable = false)
    private String period;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "BUDGET_TRANSACTION", joinColumns = @JoinColumn(name = "BUDGET_ID"),
            inverseJoinColumns = @JoinColumn(name = "TRANSACTION_ID"))
    private List<Transaction> transactions = new ArrayList<>();
}