package com.daofab.task;

import com.daofab.task.dao.TransactionRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransactionTests {

	@Autowired
	private TransactionRepo transactionRepo;

	@Test
	void contextLoads() {
	}

}
