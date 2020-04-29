package com.example.miryo_vision_backend.configs;

public interface Connection {
    default String getDatasourceUsername() { return "<your datasource user name>";}
    default String getDatasourcePassword() {return "<your datasource password>";}
    default String getDBName() {return "<your datasource db name>";}
}
