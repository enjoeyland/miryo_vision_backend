package com.example.miryo_vision_backend.controller.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TableWithFilterDto {

    private Object dataSource;
    private Object filtersData;
}
