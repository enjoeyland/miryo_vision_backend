package com.example.miryo_vision_backend.controller.dto; // fixme: controller 밑에 가 잘못됨 -> utils로 가기

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ListWrapper<T> {
    private List<T> list;
}
