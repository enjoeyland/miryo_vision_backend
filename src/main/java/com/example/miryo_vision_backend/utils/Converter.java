package com.example.miryo_vision_backend.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.*;

@Component
@Mapper(componentModel = "spring")
public class Converter {
    @Named("toDisassemble")
    public static String toDisassemble(String s){
        return HangulDivider.hangulDivide(s);
    }

    // filter에 적용
    @Named("toEachFieldToSet")
    public static <T> Map<String, Set<String>> eachFieldToSet(List<T> TList){
        if (TList == null || TList.size() == 0) {
            return null;
        }
        Map<String,Set<String>> map = new HashMap<>();

        Class<?> c = TList.get(0).getClass();
        Field[] fieldList = c.getDeclaredFields();

        for (Field f: fieldList) {
            f.setAccessible(true);
            HashSet<String> s = new HashSet<>();
            for (T t:TList) {
                try {
                    Object v = f.get(t);
                    if (v instanceof Enum<?>) {
                        // todo: 좀더 깔끔한 방법 있으면 적용
                        s.add(new ObjectMapper().writeValueAsString(v).replaceAll("\"", ""));
                    } else {
                        s.add(String.valueOf(v));
                    }

                } catch (IllegalAccessException | JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
            map.put(f.getName() + "Filter", s);
        }
        return map;
    }
}
