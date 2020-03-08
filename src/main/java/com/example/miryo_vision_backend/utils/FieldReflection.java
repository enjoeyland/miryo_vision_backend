package com.example.miryo_vision_backend.utils;

import com.example.miryo_vision_backend.controller.dto.UiDto;
import com.example.miryo_vision_backend.utils.dto.tmp.ExcelDataDto;

import java.lang.reflect.Field;
import java.util.*;

public class FieldReflection {
    // 사용하지 말 것  hint : 상속을 잘 못 사용하는 가능성이 높다.
    public static <T> List<Field> getFieldListFromParentToChild(Class<T> c) {
        List<Class> classList = getClassListFromParentToChild(c);

        List<Field> fields = new ArrayList<>();
        for (Class cls : classList) {
            fields.addAll(Arrays.asList(cls.getDeclaredFields()));
        }
        return fields;
    }

    // 사용하지 말 것  hint : 상속을 잘 못 사용하는 가능성이 높다.
    public static <T> List<Class> getClassListFromParentToChild(Class<T> c) {
        List<Class> classList = new ArrayList<>();

        for (Class j = c;
             j != null && j != ExcelDataDto.class;
             j = j.getSuperclass()) {
            classList.add(j);
        }
        Collections.reverse(classList);
        return classList;
    }
}
