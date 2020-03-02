package com.example.miryo_vision_backend.controller.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class FilterDto extends BasicUiDto {
    private Object disassemble;
}
