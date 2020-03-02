package com.example.miryo_vision_backend.service.project.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class ProjectSearchRequestDto extends ProjectCodeNameDto{
    private String customerCompanyId;

    private String salesDepartEmployeeInChargeId;
    private String logisticsDepartEmployeeInChargeId;
    private String productionDepartEmployeeInChargeId;
    private String designDepartEmployeeInChargeId;
    private String accountingDepartEmployeeInChargeId;
}
