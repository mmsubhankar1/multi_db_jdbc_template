package com.ey.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    @Bean(name = "univdb")
    @Primary
    @ConfigurationProperties(prefix = "spring.univ-datasource")
    public DataSource univDataSource() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "jdbcTemplateUniv")
    public JdbcTemplate jdbcTemplateUniv(@Qualifier("univdb") DataSource ds) {
        return new JdbcTemplate(ds);
    }
    @Bean(name = "swdb")
    @ConfigurationProperties(prefix = "spring.sw-datasource")
    public DataSource swDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jdbcTemplateSw")
    public JdbcTemplate jdbcTemplateSw(@Qualifier("swdb") DataSource ds) {
        return new JdbcTemplate(ds);
    }





    @Bean(name = "univTransactionManager")
    public PlatformTransactionManager univTransactionManager(@Qualifier("univdb") DataSource ds) {
        JdbcTransactionManager transactionManager
                = new JdbcTransactionManager();
        transactionManager.setDataSource(ds);
        return transactionManager;
    }
    @Bean(name = "swTransactionManager")
    public PlatformTransactionManager swTransactionManager(@Qualifier("swdb") DataSource ds) {
        JdbcTransactionManager transactionManager
                = new JdbcTransactionManager();
        transactionManager.setDataSource(ds);
        return transactionManager;
    }
}
