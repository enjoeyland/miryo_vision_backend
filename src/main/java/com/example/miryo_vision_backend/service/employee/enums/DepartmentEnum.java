package com.example.miryo_vision_backend.service.employee.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum DepartmentEnum {
    SALES("영업부"),
    LOGISTICS("물류부"),
    PRODUCTION("생산부"),
    DESIGN("디자인부"),
    ACCOUNTING("경리부");

    private String name;

    DepartmentEnum(String name_ko) {
        this.name = name_ko;
    }

    private static final Map<String, DepartmentEnum> BY_NAME = new HashMap<>();

    static {
        for (DepartmentEnum e: values()) {
            BY_NAME.put(e.name, e);
        }
    }

    public static DepartmentEnum findByName(String name){
        return BY_NAME.get(name);
    }
}
