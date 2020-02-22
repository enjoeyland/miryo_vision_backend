package com.example.miryo_vision_backend.service.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CodeDto {
    @JsonProperty(value = "text")
    protected String name;

    @JsonProperty(value = "value")
    protected String code;

    @JsonProperty(value = "key")
    protected String sort;

    @JsonProperty(value = "note")
    protected String note;
}
