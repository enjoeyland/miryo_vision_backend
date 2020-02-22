package com.example.miryo_vision_backend.service.project.dto;

import com.example.miryo_vision_backend.entity.project_select.CustomerClassificationCode;
import com.example.miryo_vision_backend.entity.project_select.YearCode;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProjectCodeDto {

    private String customerClassificationCode;

    private String yearCode;

    @JsonProperty(value = "customerCompanyCode")
    private String customerCompanyCode;

    private String genderCode;

    private String seasonCode;

    private String productTypeCode;
}
