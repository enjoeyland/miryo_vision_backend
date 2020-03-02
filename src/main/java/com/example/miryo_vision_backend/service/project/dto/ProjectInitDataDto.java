package com.example.miryo_vision_backend.service.project.dto;

import com.example.miryo_vision_backend.controller.dto.CodeDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;

import java.util.List;

@JsonRootName(value = "projectInitDataDto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProjectInitDataDto {
    @JsonProperty(value = "customerClassification")
    private List<CodeDto> customerClassificationCode;

    @JsonProperty(value = "year")
    private List<CodeDto> yearList;

    @JsonProperty(value = "customerCompany")
    private List<CodeDto> customerCompanyList;

    @JsonProperty(value = "gender")
    private List<CodeDto> genderList;

    @JsonProperty(value = "season")
    private List<CodeDto> seasonList;

    @JsonProperty(value = "productType")
    private List<CodeDto> productTypeList;
}
