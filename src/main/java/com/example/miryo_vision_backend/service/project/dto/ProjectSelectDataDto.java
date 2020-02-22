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
    @JsonProperty(value = "customerClassificationCode")
    private List<CodeDto> customerClassificationCode;

    @JsonProperty(value = "yearCode")
    private List<CodeDto> yearCode;


    @JsonProperty(value = "customerNameCode")
    private List<CodeDto> customerCompany;

    @JsonProperty(value = "genderCode")
    private List<CodeDto> genderCode;

    @JsonProperty(value = "seasonCode")
    private List<CodeDto> seasonCode;

    @JsonProperty(value = "productTypeCode")
    private List<CodeDto> productTypeCode;

}
