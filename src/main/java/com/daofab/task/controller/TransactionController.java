package com.daofab.task.controller;

import com.daofab.task.dao.InstallmentResult;
import com.daofab.task.dto.InstallmentDTO;
import com.daofab.task.dto.LoanDTO;
import com.daofab.task.service.TransactionService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    /*
    This API should have been GET but the stateless nature of REST is preferred so body is sent everytime.
     */
    @PostMapping("/loan/summary")
    public List<LoanDTO> summary(@RequestBody RequestWrapper requestWrapper) {
        Pagination pagination = requestWrapper.getPagination();
        if(pagination == null || pagination.getPage() < 0){
            pagination.setPage(0);
        }
        Pageable pageable = PageRequest.of(pagination.getPage(),2, Sort.by("id").ascending());
        return transactionService.summaryLoans(pageable);
    }

    @GetMapping("/installment/summary")
    public List<InstallmentResult> summaryInstallments() {
        return transactionService.summaryInstallments();
    }

    @Getter
    @Setter
    static class RequestWrapper {
        private Pagination pagination;
    }

    @Getter
    @Setter
    static class Pagination {
        private int page;
        private int pageSize;
    }
	

}
