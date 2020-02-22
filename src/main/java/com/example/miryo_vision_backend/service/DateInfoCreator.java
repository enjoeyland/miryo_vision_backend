package com.example.miryo_vision_backend.service;

import java.sql.Timestamp;
import java.util.Date;

public class DateInfoCreator {
    public Timestamp getCurrentDatetime() {
        return new Timestamp(new Date().getTime());
    }

    public java.sql.Date getCurrentDate() {
        return new java.sql.Date(new Date().getTime());
    }
}
