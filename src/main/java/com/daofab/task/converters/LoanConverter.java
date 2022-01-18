package com.daofab.task.converters;

import com.daofab.task.dto.LoanDTO;
import com.daofab.task.model.Loan;
import org.springframework.stereotype.Component;

@Component
public class LoanConverter implements GenericConverter<Loan, LoanDTO> {
    @Override
    public Loan createFromDTO(LoanDTO dto) {
        Loan loan = new Loan();
        loan.setId(dto.getId());
        return loan;
    }

    @Override
    public LoanDTO createFrom(Loan entity) {
        LoanDTO dto = new LoanDTO();
        dto.setId(entity.getId());
        dto.setSender(entity.getSender());
        dto.setReceiver(entity.getReceiver());
        dto.setTotalAmount(entity.getTotalAmount());
        return dto;
    }

    @Override
    public Loan updateEntity(Loan entity, LoanDTO dto) {
        return null;
    }
}
