package com.daofab.task.dao;

import com.daofab.task.dto.LoanDTO;
import com.daofab.task.model.Installment;
import com.daofab.task.model.Loan;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface TransactionRepo extends JpaRepository<Loan, Long> {

    @Query("select new com.daofab.task.dao.LoanSumResult(I.parentId,sum(I.paidAmount)) " +
            "from Installment I " +
            "where I.parentId in :list " +
            "group by I.parentId")
    List<LoanSumResult> aggregate(List<Long> list);

    @Query("select new com.daofab.task.dao.InstallmentResult(I.id,L.sender,L.receiver,L.totalAmount,I.paidAmount) " +
            "from Installment I LEFT JOIN Loan L " +
            "on I.parentId = L.id " )
    List<InstallmentResult> aggregateInstallments();


}

