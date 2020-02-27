package com.example.miryo_vision_backend.service.project.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum CustomerClassificationEnum {
    KOREA("공기업",'K'),
    BANK("금융권",'B'),
    GENERAL("일반사",'G');

    private String name;
    private char code;

    CustomerClassificationEnum(String classification_ko, char code) {
        this.name = classification_ko;
        this.code = code;
    }

    private static final Map<String, CustomerClassificationEnum> BY_NAME = new HashMap<>();

    static {
        for (CustomerClassificationEnum e: values()) {
            BY_NAME.put(e.name, e);
        }
    }

    public static CustomerClassificationEnum findByName(String name){
        return BY_NAME.get(name);
    }
}
