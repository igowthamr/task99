package com.daofab.task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InstallmentDTO {

    private Long id;
    private String sender;
    private String receiver;
    private Long totalAmount;
    private Long amtPaid;
}
