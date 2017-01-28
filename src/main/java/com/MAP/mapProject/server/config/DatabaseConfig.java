package com.MAP.mapProject.server.config;

import com.sun.deploy.Environment;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.activation.DataSource;
import javax.annotation.Resource;

@Configuration
@EnableJpaRepositories("com.MAP.mapProject.server.repository")
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
@ComponentScan("com.MAP.mapProject.server")
public class DatabaseConfig
{

    @Resource
    private Environment env;

    @Bean
    private DataSource data()
    {
        BasicDataSource ds=new BasicDataSource();
        return null;
    }
}
