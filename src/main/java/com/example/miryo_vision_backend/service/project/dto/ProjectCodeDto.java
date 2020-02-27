package com.example.miryo_vision_backend.service.project.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProjectCodeDto {

    private String customerClassificationCode;

    private String yearCode;

    private String customerCompanyCode;

    private String genderCode;

    private String seasonCode;

    private String productTypeCode;
}
