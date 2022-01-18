package com.daofab.task.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InstallmentResult {
    //private Loan loan;
    private Long id;
    private String sender;
    private String receiver;
    private Long totalAmount;
    private Long paidAmount;
}
