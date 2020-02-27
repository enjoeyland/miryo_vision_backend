package com.example.miryo_vision_backend.service.project.dto;

import com.example.miryo_vision_backend.entity.Project;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProjectCodeNameDto {

    private String customerClassification;

    private String year;

    private String customerCompanyName;

    private String gender;

    private String season;

    private String productType;
}
