package com.example.miryo_vision_backend.service.employee.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum Department {
    SALES("영업부"),
    LOGISTICS("물류부"),
    PRODUCTION("생산부"),
    DESIGN("디자인부"),
    ACCOUNTING("경리부");

    @JsonValue
    private String name;

    Department(String name_ko) {
        this.name = name_ko;
    }

    private static final Map<String, Department> BY_NAME = new HashMap<>();

    static {
        for (Department e: values()) {
            BY_NAME.put(e.name, e);
        }
    }

    @JsonCreator
    public static Department findByName(String name){
        return BY_NAME.get(name);
    }
}
