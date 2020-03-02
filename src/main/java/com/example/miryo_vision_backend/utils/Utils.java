package com.example.miryo_vision_backend.utils;

import lombok.NonNull;

public class Utils {
    public static String firstCharToLowerCase(@NonNull String str) {
        if (str.length() == 1)
            return str.toLowerCase();

        char[] chArr = str.toCharArray();
        chArr[0] = Character.toLowerCase(chArr[0]);

        return new String(chArr);
    }

    public static boolean isNotNull(Object o) {
        return o!= null;
    }
//    public static <T, D> List<D> cast2Dto(final Collection<T> entityList, Class<D> outCLass) {
//        return entityList.stream()
//                .map(entity -> outCLass.fromEntity(entity))
//                .collect(Collectors.toList());
//    }
}
