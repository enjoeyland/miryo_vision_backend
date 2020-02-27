package com.example.miryo_vision_backend.service.project.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum SeasonEnum {

    SUMMER("하계", '1'),
    WINTER("동계", '2'),
    SPRING_AUTUMN("춘추", '3'),
    FOUR_SEASON("사계절", '4'),
    ETC("기타", '5');

    private final String name;
    private final char code;

    SeasonEnum(String season_ko, char code) {
        this.name = season_ko;
        this.code = code;
    }

    private static final Map<String, SeasonEnum> BY_NAME = new HashMap<>();

    static {
        for (SeasonEnum e: values()) {
            BY_NAME.put(e.name, e);
        }
    }

    public static SeasonEnum findByName(String name){
        return BY_NAME.get(name);
    }


}
