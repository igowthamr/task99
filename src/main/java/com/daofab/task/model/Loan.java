package com.daofab.task.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Loan {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String sender;
    private String receiver;
    private Long totalAmount;
//    @Transient
//    private Long amountPaid;
}
