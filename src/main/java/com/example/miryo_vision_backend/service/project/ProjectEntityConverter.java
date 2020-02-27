package com.example.miryo_vision_backend.service.project;

import com.example.miryo_vision_backend.entity.Project;
import com.example.miryo_vision_backend.repository.CustomerCompanyRepository;
import com.example.miryo_vision_backend.repository.ProjectRepository;
import com.example.miryo_vision_backend.service.project.dto.CodeDto;
import com.example.miryo_vision_backend.service.project.dto.ProjectCodeDto;
import com.example.miryo_vision_backend.service.project.dto.ProjectCodeNameDto;
import com.example.miryo_vision_backend.service.project.dto.ProjectSelectDataDto;
import com.example.miryo_vision_backend.service.project.enums.*;
import com.example.miryo_vision_backend.utils.ModelMapperWrapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel="spring", uses = {ProjectInfoCreator.class, ProjectInfoCreator.class},injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class ProjectEntityConverter {
    public static ProjectEntityConverter INSTANCE = Mappers.getMapper(ProjectEntityConverter.class);

    private ProjectInfoCreator projectInfoCreator;
    private ProjectRepository projectRepository;
    private CustomerCompanyRepository customerCompanyRepository;
    private ProjectSelectConverter projectSelectConverter;

    @Autowired
    public void setProjectInfoCreator(ProjectInfoCreator projectInfoCreator) {
        this.projectInfoCreator = projectInfoCreator;
    }

    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Autowired
    public void setCustomerCompanyRepository(CustomerCompanyRepository customerCompanyRepository) {
        this.customerCompanyRepository = customerCompanyRepository;
    }

    @Autowired
    public void setProjectSelectConverter(ProjectSelectConverter projectSelectConverter) {
        this.projectSelectConverter = projectSelectConverter;
    }


    @Mapping(source = "customerCompany.name", target = "customerCompanyName")
    public abstract ProjectCodeNameDto toProjectCodeNameDto(Project project);
    public abstract List<ProjectCodeNameDto> toProjectCodeNameDto(List<Project> projectList);


    @Mapping(source = "customerCompanyName", target = "customerCompany.name")
    public abstract Project toSearchEntity(ProjectCodeNameDto projectCodeNameDto);



    public Project toCompleteEntity(ProjectCodeNameDto projectCodeNameDto) {
        Project project = this.toSearchEntity(projectCodeNameDto);

        project.setCustomerCompany(
                projectInfoCreator.getCustomerCompany(
                        projectCodeNameDto.getCustomerCompanyName()
                )
        );
        project.setStartDatetime(projectInfoCreator.getCurrentDatetime());


        // todo : 좀 문제 있음. save를 해야지 id가 나오는지 다시 확인
        //        Service쪽에서 save를 해야지 정상임
        project = projectRepository.save(project);
        project.setBarcode(projectInfoCreator.getProjectBarcode(toProjectCodeDto(project),project.getId()));

        return project;
    }

    public ProjectCodeDto toProjectCodeDto(Project project){
        return ModelMapperWrapper.map(project, ProjectCodeDto.class);
    }

    public ProjectSelectDataDto toProjectSelectDataDto (CustomerClassificationEnum[] customerClassificationEnums,
                                                                 YearEnum[] yearEnums,
                                                                 SeasonEnum[] seasonEnums,
                                                                 GenderEnum[] genderEnums,
                                                                 ProductTypeEnum[] productTypeEnums){
        ProjectSelectDataDto projectSelectDataDto = new ProjectSelectDataDto();
        projectSelectDataDto.setCustomerCompany(ModelMapperWrapper.mapAll(this.customerCompanyRepository.findAll(), CodeDto.class));

        projectSelectDataDto.setCustomerClassificationCode(this.projectSelectConverter.toCodeDto(customerClassificationEnums));
        projectSelectDataDto.setYearCode(this.projectSelectConverter.toCodeDto(yearEnums));
        projectSelectDataDto.setSeasonCode(this.projectSelectConverter.toCodeDto(seasonEnums));
        projectSelectDataDto.setGenderCode(this.projectSelectConverter.toCodeDto(genderEnums));
        projectSelectDataDto.setProductTypeCode(this.projectSelectConverter.toCodeDto(productTypeEnums));
        return projectSelectDataDto;
    }

    protected CustomerClassificationEnum toCustomerClassificationEnum(String name) {
        return CustomerClassificationEnum.findByName(name);
    }
    protected GenderEnum toGenderEnum(String name) {
        return GenderEnum.findByName(name);
    }
    protected ProductTypeEnum toProductTypeEnum(String name) {
        return ProductTypeEnum.findByName(name);
    }
    protected SeasonEnum toSeasonEnum(String name) {
        return SeasonEnum.findByName(name);
    }
    protected YearEnum toYearEnum(String name) {
        return YearEnum.findByName(name);
    }


}
