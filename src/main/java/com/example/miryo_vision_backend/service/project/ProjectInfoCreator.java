package com.example.miryo_vision_backend.service.project;

import com.example.miryo_vision_backend.controller.dto.UiDto;
import com.example.miryo_vision_backend.entity.CustomerCompany;
import com.example.miryo_vision_backend.entity.Project;
import com.example.miryo_vision_backend.repository.CustomerCompanyRepository;
import com.example.miryo_vision_backend.repository.EmployeeRepository;
import com.example.miryo_vision_backend.service.DateInfoCreator;
import com.example.miryo_vision_backend.service.employee.EmployeeEntityConverter;
import com.example.miryo_vision_backend.service.employee.enums.Department;
import com.example.miryo_vision_backend.service.employee.enums.JobDuty;
import com.example.miryo_vision_backend.service.project.enums.*;
import com.example.miryo_vision_backend.utils.ModelMapperWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectInfoCreator extends DateInfoCreator {

    private CustomerCompanyRepository customerCompanyRepository;
    private ProjectEnumConverter projectEnumConverter;
    private EmployeeRepository employeeRepository;
    private EmployeeEntityConverter employeeEntityConverter;

    @Autowired
    public ProjectInfoCreator(CustomerCompanyRepository customerCompanyRepository, ProjectEnumConverter projectEnumConverter, EmployeeRepository employeeRepository, EmployeeEntityConverter employeeEntityConverter) {
        this.customerCompanyRepository = customerCompanyRepository;
        this.projectEnumConverter = projectEnumConverter;
        this.employeeRepository = employeeRepository;
        this.employeeEntityConverter = employeeEntityConverter;
    }

    public String getProjectName(Project project) {
        return  project.getYear().getName() + "년도 " +
                project.getCustomerCompany().getName() + " " +
                project.getSeason().getName() + " " +
                project.getGender().getName() + "복 ";

    }


    public CustomerCompany getCustomerCompany(Long customerCompanyID) {
        return customerCompanyRepository.findById(customerCompanyID).orElse(null);
    }

    public String getProjectBarcode(Project project) {
        StringBuilder builder = new StringBuilder()
            .append(project.getYear().getCode())
            .append(project.getCustomerClassification().getCode())
            .append(String.format("%02d",  Integer.parseInt(project.getCustomerCompany().getCode())).substring(0, 2))
            .append(project.getGender().getCode())
            .append(project.getSeason().getCode())
            .append(project.getProductType().getCode())
            .append(String.format("%03d", project.getId()).substring(0, 3));
        return builder.toString();

    }

    public String getProjectPlantCode(Project project) {
        return  project.getYear().getCode() +
                "-" +
                String.format("%03d", project.getId()).substring(0, 3);

    }

    public ProjectDto.UiSelect.All getUiSelectForProject (){
        ProjectDto.UiSelect.All dto = new ProjectDto.UiSelect.All();
        dto.setCustomerCompanyList(ModelMapperWrapper.mapAll(this.customerCompanyRepository.findAll(), UiDto.Option.WithIdAndCode.class));
        dto.setCustomerClassificationList(this.projectEnumConverter.toUiOptionWithCode(CustomerClassificationEnum.values()));
        dto.setYearList(this.projectEnumConverter.toUiOptionWithCode(YearEnum.values()));
        dto.setSeasonList(this.projectEnumConverter.toUiOptionWithCode(SeasonEnum.values()));
        dto.setGenderList(this.projectEnumConverter.toUiOptionWithCode(GenderEnum.values()));
        dto.setProductTypeList(this.projectEnumConverter.toUiOptionWithCode(ProductTypeEnum.values()));
        dto.setSalesDepartEmployeeInChargeList(getUiOption(Department.SALES));
        dto.setLogisticsDepartEmployeeInChargeList(getUiOption(Department.LOGISTICS));
        dto.setProductionDepartEmployeeInChargeList(getUiOption(Department.PRODUCTION));
        dto.setDesignDepartEmployeeInChargeList(getUiOption(Department.DESIGN));
        dto.setAccountingDepartEmployeeInChargeList(getUiOption(Department.ACCOUNTING));
        dto.setFairStatusList(this.projectEnumConverter.toUiOption(FairStatusEnum.values()));

        return dto;
    }
    private List<UiDto.Option.WithId> getUiOption(Department department) {
        return this.employeeEntityConverter.toUiOption(this.employeeRepository.findByDepartmentAndJobDuty(department, JobDuty.TEAM_MANAGER));
    }
}
