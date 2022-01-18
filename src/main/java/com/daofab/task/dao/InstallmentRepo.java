package com.daofab.task.dao;

import com.daofab.task.model.Installment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstallmentRepo extends JpaRepository<Installment, Long> {

}
