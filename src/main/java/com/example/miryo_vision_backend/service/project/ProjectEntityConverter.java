package com.example.miryo_vision_backend.service.project;

import com.example.miryo_vision_backend.controller.dto.BasicUiDto;
import com.example.miryo_vision_backend.controller.dto.CodeDto;
import com.example.miryo_vision_backend.entity.Project;
import com.example.miryo_vision_backend.repository.CustomerCompanyRepository;
import com.example.miryo_vision_backend.repository.EmployeeRepository;
import com.example.miryo_vision_backend.repository.ProjectRepository;
import com.example.miryo_vision_backend.service.employee.EmployeeEntityConverter;
import com.example.miryo_vision_backend.service.employee.enums.DepartmentEnum;
import com.example.miryo_vision_backend.service.employee.enums.JobDutyEnum;
import com.example.miryo_vision_backend.service.project.dto.*;
import com.example.miryo_vision_backend.service.project.enums.*;
import com.example.miryo_vision_backend.utils.ModelMapperWrapper;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel="spring",
        uses = {ProjectEnumConverter.class},
        injectionStrategy = InjectionStrategy.FIELD)
public abstract class ProjectEntityConverter {

    @Autowired
    private ProjectInfoCreator projectInfoCreator;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private CustomerCompanyRepository customerCompanyRepository;
    @Autowired
    private ProjectEnumConverter projectEnumConverter;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeEntityConverter employeeEntityConverter;

    @Mappings({
        @Mapping(source = "customerCompany.name", target = "customerCompany"),
        @Mapping(source = "salesDepartEmployeeInCharge.name", target = "salesDepartEmployeeInCharge"),
        @Mapping(source = "logisticsDepartEmployeeInCharge.name", target = "logisticsDepartEmployeeInCharge"),
        @Mapping(source = "productionDepartEmployeeInCharge.name", target = "productionDepartEmployeeInCharge"),
        @Mapping(source = "designDepartEmployeeInCharge.name", target = "designDepartEmployeeInCharge"),
        @Mapping(source = "accountingDepartEmployeeInCharge.name", target = "accountingDepartEmployeeInCharge")
    })
    public abstract ProjectResponseDto toProjectDto(Project project);
    public abstract List<ProjectResponseDto> toProjectDto(List<Project> projectList);


    public abstract Project toSearchEntity(ProjectCodeNameDto projectCodeNameDto);
    @Mappings({
        @Mapping(source = "customerCompanyId", target = "customerCompany.id"),
        @Mapping(source = "salesDepartEmployeeInChargeId", target = "salesDepartEmployeeInCharge.id"),
        @Mapping(source = "logisticsDepartEmployeeInChargeId", target = "logisticsDepartEmployeeInCharge.id"),
        @Mapping(source = "productionDepartEmployeeInChargeId", target = "productionDepartEmployeeInCharge.id"),
        @Mapping(source = "designDepartEmployeeInChargeId", target = "designDepartEmployeeInCharge.id"),
        @Mapping(source = "accountingDepartEmployeeInChargeId", target = "accountingDepartEmployeeInCharge.id")
    })
    public abstract Project toSearchEntity(ProjectCreateRequestDto projectCreateRequestDto);


    public Project toCompleteEntity(ProjectCreateRequestDto projectCreateRequestDto) {
        Project project = this.toSearchEntity(projectCreateRequestDto);

        project.setCustomerCompany(
                projectInfoCreator.getCustomerCompany(
                        project.getCustomerCompany().getId()
                )
        );

        project.setName(projectInfoCreator.getProjectName(project));

        project.setStartDatetime(projectInfoCreator.getCurrentDatetime());
        project.setFairStatus(FairStatusEnum.WAITING);


        // todo : 좀 문제 있음. save를 해야지 id가 나오는지 다시 확인
        //        Service쪽에서 save를 해야지 정상임
        project = projectRepository.save(project);

        ProjectCodeDto projectCodeDto= toProjectCodeDto(project);
        project.setBarcode(projectInfoCreator.getProjectBarcode(projectCodeDto,project.getId()));
        project.setPlantCode(projectInfoCreator.getProjectPlantCode(projectCodeDto, project.getId()));

        return project;
    }

    public ProjectCodeDto toProjectCodeDto(Project project){
        return ModelMapperWrapper.map(project, ProjectCodeDto.class);
    }

    public ProjectCreateInitDataDto toProjectCreateInitDataDto (){
        ProjectCreateInitDataDto dto = new ProjectCreateInitDataDto();
        setProjectCodeInitData(dto);
        setInChargeInitData(dto);
        return dto;
    }

    public ProjectSearchInitDataDto toProjectSearchInitDataDto (){
        ProjectSearchInitDataDto dto = new ProjectSearchInitDataDto();
        setProjectCodeInitData(dto);
        setInChargeInitData(dto);
        dto.setFairStatusList(this.projectEnumConverter.toBasicUiDto(FairStatusEnum.values()));
        return dto;
    }


    public void setKey(List<ProjectResponseDto> projectResponseDtoList) {
        for (int i = 0; i < projectResponseDtoList.size() ; i++) {
            projectResponseDtoList.get(i).setKey(String.valueOf(i+1));
        }
    }

    private void setInChargeInitData(ProjectCreateInitDataDto dto) {
        dto.setSalesDepartEmployeeInChargeList(getBasicUiDto(DepartmentEnum.SALES));
        dto.setLogisticsDepartEmployeeInChargeList(getBasicUiDto(DepartmentEnum.LOGISTICS));
        dto.setProductionDepartEmployeeInChargeList(getBasicUiDto(DepartmentEnum.PRODUCTION));
        dto.setDesignDepartEmployeeInChargeList(getBasicUiDto(DepartmentEnum.DESIGN));
        dto.setAccountingDepartEmployeeInChargeList(getBasicUiDto(DepartmentEnum.ACCOUNTING));
    }

    private void setInChargeInitData(ProjectSearchInitDataDto dto) {
        dto.setSalesDepartEmployeeInChargeList(getBasicUiDto(DepartmentEnum.SALES));
        dto.setLogisticsDepartEmployeeInChargeList(getBasicUiDto(DepartmentEnum.LOGISTICS));
        dto.setProductionDepartEmployeeInChargeList(getBasicUiDto(DepartmentEnum.PRODUCTION));
        dto.setDesignDepartEmployeeInChargeList(getBasicUiDto(DepartmentEnum.DESIGN));
        dto.setAccountingDepartEmployeeInChargeList(getBasicUiDto(DepartmentEnum.ACCOUNTING));
    }

    private List<BasicUiDto> getBasicUiDto(DepartmentEnum departmentEnum) {
        return this.employeeEntityConverter.toBasicUiDto(this.employeeRepository.findByDepartmentAndJobDuty(departmentEnum, JobDutyEnum.TEAM_MANAGER));
    }

    private void setProjectCodeInitData(ProjectInitDataDto dto) {
        dto.setCustomerCompanyList(ModelMapperWrapper.mapAll(this.customerCompanyRepository.findAll(), CodeDto.class));

        dto.setCustomerClassificationCode(this.projectEnumConverter.toCodeDto(CustomerClassificationEnum.values()));
        dto.setYearList(this.projectEnumConverter.toCodeDto(YearEnum.values()));
        dto.setSeasonList(this.projectEnumConverter.toCodeDto(SeasonEnum.values()));
        dto.setGenderList(this.projectEnumConverter.toCodeDto(GenderEnum.values()));
        dto.setProductTypeList(this.projectEnumConverter.toCodeDto(ProductTypeEnum.values()));
    }



}
