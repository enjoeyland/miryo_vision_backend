package com.example.miryo_vision_backend.configs;

// caution : you have to implement this interface

public interface Connection {
    default String getDriverClassName() {
        return "com.mysql.cj.jdbc.Driver";
    }

    default String getDataBaseName() {
        return "mysql";
    }
    default String getUrlDomain() {
        return "localhost";
    }
    default String getPort() {
        return "3306";
    }

    String getDatasourceUsername();
    String getDatasourcePassword();

    // ex) miryo_vision_project_db
    String getDBSchemaName();
}
