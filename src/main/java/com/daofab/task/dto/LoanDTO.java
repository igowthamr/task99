package com.daofab.task.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanDTO {

    private Long id;
    private String sender;
    private String receiver;
    private Long totalAmount;
    private Long amtPaid;
}
