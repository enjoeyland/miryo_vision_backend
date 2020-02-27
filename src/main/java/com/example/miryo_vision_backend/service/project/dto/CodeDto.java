package com.example.miryo_vision_backend.service.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CodeDto {
    @JsonProperty(value = "value")
    protected String name;

    @JsonProperty(value = "code")
    protected String code;

    @JsonProperty(value = "key")
    protected String sort;

    @JsonProperty(value = "note")
    protected String note;
}
