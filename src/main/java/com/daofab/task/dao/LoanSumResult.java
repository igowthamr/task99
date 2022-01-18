package com.daofab.task.dao;

import com.daofab.task.model.Loan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanSumResult {
    //private Loan loan;
    private Long id;
    private Long paidAmount;
}
