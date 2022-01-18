package com.daofab.task.helper;

import com.daofab.task.model.Installment;
import com.daofab.task.model.Loan;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class JsonReader {

    public static ObjectMapper objectMapper = new ObjectMapper();

    public List<Loan> getLoans(String loanFile) throws IOException {
        ClassPathResource res = new ClassPathResource(loanFile);
        return objectMapper.readValue(res.getFile(), new TypeReference<LoanWrapper>(){}).getData();
    }

    public List<Installment> getInstallments(String installmentFile) throws IOException {
        ClassPathResource res = new ClassPathResource(installmentFile);
        return objectMapper.readValue(res.getFile(), new TypeReference<InstallmentWrapper>(){}).getData();
    }

    @Getter
    @Setter
    static class LoanWrapper{
        private List<Loan> data;
    }

    @Getter
    @Setter
    static class InstallmentWrapper{
        private List<Installment> data;
    }
}
