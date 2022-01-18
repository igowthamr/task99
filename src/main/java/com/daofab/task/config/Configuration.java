package com.daofab.task.config;

import com.daofab.task.dao.InstallmentRepo;
import com.daofab.task.dao.LoanRepo;
import com.daofab.task.helper.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    private static String LOAN_FILE = "Parent.json";
    private static String INSTALLMENT_FILE = "Child.json";

    @Autowired
    private LoanRepo loanRepo;

    @Autowired
    private InstallmentRepo installmentRepo;

    @Bean
    public ApplicationRunner initMembers() {
        //Insert commands in case for manual testing
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                // Add all the data in json to DB using repo on startup
                JsonReader jsonReader = new JsonReader();
                loanRepo.saveAll(jsonReader.getLoans(LOAN_FILE));
                installmentRepo.saveAll(jsonReader.getInstallments(INSTALLMENT_FILE));
            }
        };
    }
}
