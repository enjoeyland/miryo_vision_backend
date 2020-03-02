package com.example.miryo_vision_backend.service.project.dto;

import com.example.miryo_vision_backend.controller.dto.BasicUiDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;

import java.util.List;

@JsonRootName(value = "projectCreateInitDataDto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class ProjectCreateInitDataDto extends ProjectInitDataDto {
    @JsonProperty(value = "salesDepartEmployeeInCharge")
    private List<BasicUiDto> salesDepartEmployeeInChargeList;

    @JsonProperty(value = "logisticsDepartEmployeeInCharge")
    private List<BasicUiDto> logisticsDepartEmployeeInChargeList;

    @JsonProperty(value = "productionDepartEmployeeInCharge")
    private List<BasicUiDto> productionDepartEmployeeInChargeList;

    @JsonProperty(value = "designDepartEmployeeInCharge")
    private List<BasicUiDto> designDepartEmployeeInChargeList;

    @JsonProperty(value = "accountingDepartEmployeeInCharge")
    private List<BasicUiDto> accountingDepartEmployeeInChargeList;
}
