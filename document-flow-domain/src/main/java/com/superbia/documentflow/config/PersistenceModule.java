package com.superbia.documentflow.config;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by dmorozov on 6/19/15.
 */
@Configuration
@ComponentScan(basePackages = {
    "com.superbia.documentflow.domain",
    "com.superbia.documentflow.repository"
})
@EntityScan(basePackages = {"com.superbia.documentflow.domain"})
@EnableJpaRepositories(basePackages = {"com.superbia.documentflow.repository"})
public class PersistenceModule {

  public static void main(String[] args) {

  }
}
