package com.example.miryo_vision_backend.configs;

import com.example.miryo_vision_backend._private.MyConnection;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource() {
        Connection connection= new MyConnection();
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/" + connection.getDBSchemaName() + "?serverTimezone=Asia/Seoul");
        dataSourceBuilder.username(connection.getDatasourceUsername());
        dataSourceBuilder.password(connection.getDatasourcePassword());
        return dataSourceBuilder.build();
    }
}
