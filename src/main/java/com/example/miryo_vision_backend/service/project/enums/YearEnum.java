package com.example.miryo_vision_backend.service.project.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum YearEnum {

    Y2015("2015",'A'),
    Y2016("2016",'B'),
    Y2017("2017",'C'),
    Y2018("2018",'D'),
    Y2019("2019",'E'),
    Y2020("2020",'F'),
    Y2021("2021",'G'),
    Y2022("2022",'H'),
    Y2023("2023",'I'),
    Y2024("2024",'J'),
    Y2025("2025",'K'),
    Y2026("2026",'L'),
    Y2027("2027",'M'),
    Y2028("2028",'N'),
    Y2029("2029",'O'),
    Y2030("2030",'P'),
    Y2031("2031",'Q'),
    Y2032("2032",'R'),
    Y2033("2033",'S'),
    Y2034("2034",'T'),
    Y2035("2035",'U'),
    Y2036("2036",'V'),
    Y2037("2037",'W'),
    Y2038("2038",'X'),
    Y2039("2039",'Y'),
    ETC("-1",'Z');

    @JsonValue
    private String name;
    private char code;

    YearEnum(String year, char code) {
        this.name = year;
        this.code = code;
    }

    private static final Map<String, YearEnum> BY_NAME = new HashMap<>();

    static {
        for (YearEnum e: values()) {
            BY_NAME.put(e.name, e);
        }
    }

    @JsonCreator
    public static YearEnum findByName(String name){
        return BY_NAME.get(name);
    }
}
