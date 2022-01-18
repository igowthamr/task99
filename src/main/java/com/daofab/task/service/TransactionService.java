package com.daofab.task.service;

import com.daofab.task.dao.InstallmentResult;
import com.daofab.task.dto.InstallmentDTO;
import com.daofab.task.dto.LoanDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TransactionService {

    public List<LoanDTO> summaryLoans(Pageable pageable);

    public List<InstallmentResult> summaryInstallments();
}
