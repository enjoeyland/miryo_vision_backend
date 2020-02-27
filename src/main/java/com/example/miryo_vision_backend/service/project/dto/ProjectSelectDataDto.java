package com.example.miryo_vision_backend.service.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;

import java.util.List;

@JsonRootName(value = "project_select_data")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProjectSelectDataDto {
    @JsonProperty(value = "customerClassification")
    private List<CodeDto> customerClassificationCode;

    @JsonProperty(value = "year")
    private List<CodeDto> yearCode;

    @JsonProperty(value = "customerCompany")
    private List<CodeDto> customerCompany;

    @JsonProperty(value = "gender")
    private List<CodeDto> genderCode;

    @JsonProperty(value = "season")
    private List<CodeDto> seasonCode;

    @JsonProperty(value = "productType")
    private List<CodeDto> productTypeCode;


    private List<String> businessDepartTeam;

    private List<String> winStatus; // 진행중, win lose
}
