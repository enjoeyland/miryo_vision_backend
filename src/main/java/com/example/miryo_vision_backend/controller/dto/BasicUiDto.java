package com.example.miryo_vision_backend.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BasicUiDto {
    @JsonProperty(value = "value")
    private Object name;

    @JsonProperty(value = "id")
    private Object id;

    @JsonProperty(value = "key")
    private Object sort;

    @JsonProperty(value = "text")
    private Object note;
}
