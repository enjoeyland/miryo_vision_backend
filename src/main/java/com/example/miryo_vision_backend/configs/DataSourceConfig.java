package com.example.miryo_vision_backend.configs;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import static com.example.miryo_vision_backend._private._Connection.*;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/"+ datasource_db +"?serverTimezone=Asia/Seoul");
        dataSourceBuilder.username(datasource_username);
        dataSourceBuilder.password(datasource_password);
        return dataSourceBuilder.build();
    }
}
