package com.example.miryo_vision_backend.utils;

import com.example.miryo_vision_backend.controller.dto.BasicUiDto;
import com.example.miryo_vision_backend.dto.tmp.ExcelDataDto;

import java.lang.reflect.Field;
import java.util.*;

public class FieldReflection {
    // filter에 적용
    public static <T,S extends BasicUiDto> Map<String, Set<S>> eachFieldToSet(List<T> TList, Class<S> targetC){
        if (TList == null) {
            return null;
        }
        Map<String,Set<S>> map = new HashMap<>();

        Class<?> c = TList.get(0).getClass();
        List<Field> fieldList = getFieldListFromParentToChild(c);

        for (Field f: fieldList) {
            f.setAccessible(true);
            HashSet<S> s = new HashSet<>();
            for (T t:TList) {
                try {
                    String data = (String) f.get(t);
                    S dto = targetC.newInstance();
                    dto.setName(data);
                    dto.setNote(data);
                    s.add(dto);
                } catch (IllegalAccessException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
            map.put(f.getName() + "Filter", s);
        }
        return map;
    }


    public static <T> List<Field> getFieldListFromParentToChild(Class<T> c) {
        List<Class> classList = getClassListFromParentToChild(c);

        List<Field> fields = new ArrayList<>();
        for (Class cls : classList) {
            fields.addAll(Arrays.asList(cls.getDeclaredFields()));
        }
        return fields;
    }

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
