package com.example.miryo_vision_backend.service.project.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum ProductTypeEnum {

   OFFICE("근무복",'O'),
   WORK("작업복",'W'),
   SUMMER("성하복",'S'),
   HEAVY("방한복",'H'),
   PLAN("기획", 'P'),
   WELL_BEING("복지품",'B');


    @JsonValue
    private String name;
    private char code;

    ProductTypeEnum(String productType_ko, char code) {
        this.name = productType_ko;
        this.code = code;
    }

    private static final Map<String, ProductTypeEnum> BY_NAME = new HashMap<>();

    static {
        for (ProductTypeEnum e: values()) {
            BY_NAME.put(e.name, e);
        }
    }

    @JsonCreator
    public static ProductTypeEnum findByName(String name){
        return BY_NAME.get(name);
    }
}
