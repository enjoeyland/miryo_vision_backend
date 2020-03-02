package com.example.miryo_vision_backend.service.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class ProjectResponseDto extends ProjectCodeNameDto {
    private String barcode;
    private String plantCode;
    private String name;
    private String startDatetime;
    private String fairStatus;
    private String fairResultDatetime;

    private String customerCompany;

    @JsonProperty(value = "businessDepartTeam")
    private String salesDepartEmployeeInCharge;
    private String logisticsDepartEmployeeInCharge;
    private String productionDepartEmployeeInCharge;
    private String designDepartEmployeeInCharge;
    private String accountingDepartEmployeeInCharge;

    // ant vue design 에서 table 만들때 필요한 것
    private String key;
}
