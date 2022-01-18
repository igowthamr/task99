package com.daofab.task.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "installment",
        indexes = {@Index(name = "parent_idx",  columnList="parentId", unique = false)})
public class Installment {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private Long parentId;
    private Long paidAmount;

}
