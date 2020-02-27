package com.example.miryo_vision_backend.service.project.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum GenderEnum {

    MALE("남성", 'M'),
    FEMALE("여성", 'F'),
    UNISEX("공용", 'U');

    private String name;
    private char code;


    GenderEnum(String gender_ko, char code) {
        this.name = gender_ko;
        this.code = code;
    }

    private static final Map<String, GenderEnum> BY_NAME = new HashMap<>();

    static {
        for (GenderEnum e: values()) {
            BY_NAME.put(e.name, e);
        }
    }

    public static GenderEnum findByName(String name){
        return BY_NAME.get(name);
    }
}
