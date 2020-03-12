package com.example.miryo_vision_backend.service.project;

import com.example.miryo_vision_backend.entity.Employee;
import com.example.miryo_vision_backend.entity.Project;
import com.example.miryo_vision_backend.service.project.enums.*;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel="spring",nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class ProjectEntityConverter {

    @Autowired
    private ProjectInfoCreator projectInfoCreator;

    @Mappings({
        @Mapping(source = "customerCompany.name", target = "customerCompany"),
        @Mapping(source = "salesDepartEmployeeInCharge.name", target = "salesDepartEmployeeInCharge"),
        @Mapping(source = "logisticsDepartEmployeeInCharge.name", target = "logisticsDepartEmployeeInCharge"),
        @Mapping(source = "productionDepartEmployeeInCharge.name", target = "productionDepartEmployeeInCharge"),
        @Mapping(source = "designDepartEmployeeInCharge.name", target = "designDepartEmployeeInCharge"),
        @Mapping(source = "accountingDepartEmployeeInCharge.name", target = "accountingDepartEmployeeInCharge"),
        @Mapping(target = "listIndex", ignore = true)
    })
    public abstract ProjectDto.Response toProjectResponse(Project project);
    public abstract List<ProjectDto.Response> toProjectResponse(List<Project> projectList);

    @Mapping(target = "fairStatus", ignore = true)
    public abstract ProjectDto.Request.Search toProjectSearchRequest(ProjectDto.Request.Create projectCreateRequest);

    @Mappings({
        @Mapping(source = "customerCompanyId", target = "customerCompany.id"),
        @Mapping(source = "salesDepartEmployeeInChargeId", target = "salesDepartEmployeeInCharge.id"),
        @Mapping(source = "logisticsDepartEmployeeInChargeId", target = "logisticsDepartEmployeeInCharge.id"),
        @Mapping(source = "productionDepartEmployeeInChargeId", target = "productionDepartEmployeeInCharge.id"),
        @Mapping(source = "designDepartEmployeeInChargeId", target = "designDepartEmployeeInCharge.id"),
        @Mapping(source = "accountingDepartEmployeeInChargeId", target = "accountingDepartEmployeeInCharge.id")
    })
    public abstract Project toSavableEntity(ProjectDto.Request.Create projectCreateRequest);

    // note: use after save project, so Project can have id
    public void updateToCompleteEntity(Project project) {
        project.setCustomerCompany(
                projectInfoCreator.getCustomerCompany(
                        project.getCustomerCompany().getId()
                )
        );
        project.setName(projectInfoCreator.getProjectName(project));

        project.setStartDatetime(projectInfoCreator.getCurrentDatetime());
        project.setFairStatus(FairStatusEnum.WAITING);

        project.setBarcode(projectInfoCreator.getProjectBarcode(project));
        project.setPlantCode(projectInfoCreator.getProjectPlantCode(project));
    }

    @Mappings({
            @Mapping(source = "salesDepartEmployeeInChargeId", target = "salesDepartEmployeeInCharge", qualifiedByName = "setNewEmploy"),
            @Mapping(source = "logisticsDepartEmployeeInChargeId", target = "logisticsDepartEmployeeInCharge", qualifiedByName = "setNewEmploy"),
            @Mapping(source = "productionDepartEmployeeInChargeId", target = "productionDepartEmployeeInCharge", qualifiedByName = "setNewEmploy"),
            @Mapping(source = "designDepartEmployeeInChargeId", target = "designDepartEmployeeInCharge", qualifiedByName = "setNewEmploy"),
            @Mapping(source = "accountingDepartEmployeeInChargeId", target = "accountingDepartEmployeeInCharge", qualifiedByName = "setNewEmploy"),
    })
    public abstract void updateProject(ProjectDto.Request.Update projectUpdateRequest, @MappingTarget Project asIsProject);

    // note: updateProject를 실행하기 전에 실행
    public void updateFairResultDatetime(ProjectDto.Request.Update projectUpdateRequest, Project asIsProject){
        if (asIsProject.getFairStatus() == FairStatusEnum.WAITING &&
                projectUpdateRequest.getFairStatus()!= FairStatusEnum.WAITING){
            asIsProject.setFairResultDatetime(projectInfoCreator.getCurrentDatetime());
        }
    }
    @Named("setNewEmploy")
    protected Employee setNewEmploy(Long id){
        Employee employee = new Employee();
        employee.setId(id);
        return employee;
    }

    public abstract ProjectDto.UiSelect.Create toUiSelectForProjectCreate(ProjectDto.UiSelect.All uiSelectForProject);
    public abstract ProjectDto.UiSelect.Search toUiSelectForProjectSearch(ProjectDto.UiSelect.All uiSelectForProject);
    public abstract ProjectDto.UiSelect.Update toUiSelectForProjectUpdate(ProjectDto.UiSelect.All uiSelectForProject);
}
