package com.ey.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionSynchronization;

@Configuration
public class MultipleDatasourceTransactionManagerConfig {
    @Bean(name = "iitbTransactionManager")
    public ChainedTransactionManager chainedTransactionManager(
            @Qualifier("univTransactionManager")
            PlatformTransactionManager accountingTransactionManager,
            @Qualifier("swTransactionManager")
            PlatformTransactionManager warehouseTransactionManager){

        return new ChainedTransactionManager(accountingTransactionManager,warehouseTransactionManager);
    }


}
