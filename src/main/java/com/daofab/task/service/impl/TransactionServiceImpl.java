package com.daofab.task.service.impl;

import com.daofab.task.converters.LoanConverter;
import com.daofab.task.dao.*;
import com.daofab.task.dto.InstallmentDTO;
import com.daofab.task.dto.LoanDTO;
import com.daofab.task.model.Installment;
import com.daofab.task.model.Loan;
import com.daofab.task.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private LoanRepo loanRepo;

    @Autowired
    private InstallmentRepo installmentRepo;

    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private LoanConverter loanConverter;

    @Override
    public List<LoanDTO> summaryLoans(Pageable pageable) {
        List<Loan> pagedLoans = loanRepo.findAll(pageable)
                .getContent()
                .stream()
                .collect(Collectors.toList());
        //.collect(Collectors.toMap(loan -> loan.getId(),loan -> loan));
        Map<Long, LoanSumResult> sumResults = transactionRepo.aggregate(
                        pagedLoans
                                .stream()
                                .map(entry -> {
                                    return entry.getId();
                                })
                                .collect(Collectors.toList()))
                .stream()
                .collect(Collectors.toMap(loan -> loan.getId(), loan -> loan));
        return pagedLoans.stream().map(result -> {
            LoanDTO dto = loanConverter.createFrom(result);
            if (sumResults.get(result.getId()) != null) {
                dto.setAmtPaid(sumResults.get(result.getId()).getPaidAmount());
            }
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<InstallmentResult> summaryInstallments() {
        return transactionRepo.aggregateInstallments();
    }
}
