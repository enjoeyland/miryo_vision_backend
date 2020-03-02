package com.example.miryo_vision_backend.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class CodeDto extends BasicUiDto {
    @JsonProperty(value = "code")
    private String code;
}
