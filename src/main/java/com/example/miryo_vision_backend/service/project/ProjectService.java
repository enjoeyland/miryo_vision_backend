package com.example.miryo_vision_backend.service.project;


import com.example.miryo_vision_backend.service.project.dto.CodeDto;
import com.example.miryo_vision_backend.service.project.dto.ProjectCodeNameDto;
import com.example.miryo_vision_backend.service.project.dto.ProjectSelectDataDto;
import com.example.miryo_vision_backend.entity.Project;
import com.example.miryo_vision_backend.repository.CustomerCompanyRepository;
import com.example.miryo_vision_backend.repository.ProjectRepository;
import com.example.miryo_vision_backend.repository.project_select.*;
import com.example.miryo_vision_backend.service.CrudService;
import com.example.miryo_vision_backend.utils.ObjectMapper;
import com.querydsl.core.types.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


//todo : 모델 맵핑이 무언가 잘못됨

@Service
public class ProjectService implements CrudService<ProjectCodeNameDto> {
    private CustomerClassificationCodeRepository customerClassificationCodeRepository;
    private YearCodeRepository          yearCodeRepository;
    private CustomerCompanyRepository   customerCompanyRepository;
    private GenderCodeRepository        genderCodeRepository;
    private SeasonCodeListRepository    seasonCodeListRepository;
    private ProductTypeCodeRepository   productTypeCodeRepository;

    private ProjectRepository           projectRepository;

    private ProjectEntityConverter  projectEntityConverter;

    private Logger logger = LoggerFactory.getLogger(ProjectService.class);


    @Autowired
    public ProjectService(CustomerClassificationCodeRepository customerClassificationCodeRepository,
                          YearCodeRepository yearCodeRepository,
                          CustomerCompanyRepository customerCompanyRepository,
                          GenderCodeRepository genderCodeRepository,
                          SeasonCodeListRepository seasonCodeListRepository,
                          ProductTypeCodeRepository productTypeCodeRepository,
                          ProjectRepository projectRepository, ProjectEntityConverter projectEntityConverter, ProjectInfoCreator projectInfoCreator) {
        this.customerClassificationCodeRepository = customerClassificationCodeRepository;
        this.yearCodeRepository = yearCodeRepository;
        this.customerCompanyRepository = customerCompanyRepository;
        this.genderCodeRepository = genderCodeRepository;
        this.seasonCodeListRepository = seasonCodeListRepository;
        this.productTypeCodeRepository = productTypeCodeRepository;
        this.projectRepository = projectRepository;
        this.projectEntityConverter = projectEntityConverter;
    }


    @Override
    public void create(ProjectCodeNameDto projectCodeNameDto) {
        // todo: 이벤트 처리
        Project project = projectEntityConverter.toCompleteEntity(projectCodeNameDto);
        this.projectRepository.save(project);

    }

    @Override
    public void createAll(List<ProjectCodeNameDto> projectCodeNameDtoList) {

    }


    // todo: JPA에서 @ID를 보고 update를 해줄지 확인 필요
    @Override
    public void update(ProjectCodeNameDto projectCodeNameDto) {

    }

    @Override
    public void updateAll(List<ProjectCodeNameDto> projectCodeNameDtoList) {

    }


    @Override
    public void delete(ProjectCodeNameDto projectCodeNameDto) {
    }

    @Override
    public void deleteAll(List<ProjectCodeNameDto> projectCodeNameDtoList) {
    }

    @Override
    public List<ProjectCodeNameDto> search(ProjectCodeNameDto projectCodeNameDto) {
        Predicate predicate = ProjectPredicate.search(projectCodeNameDto);
        return projectEntityConverter.toProjectCodeNameDto(projectRepository.findAll(predicate));
    }

    @Override
    public List<ProjectCodeNameDto> getAll() {
        return this.projectEntityConverter.toProjectCodeNameDto(this.projectRepository.findAll());
    }

    public ProjectSelectDataDto getProjectSelectData() {

        ProjectSelectDataDto projectSelectDataDto = new ProjectSelectDataDto();
        projectSelectDataDto.setCustomerClassificationCode(ObjectMapper.mapAll(this.customerClassificationCodeRepository.findAll(), CodeDto.class));
        projectSelectDataDto.setYearCode(ObjectMapper.mapAll(this.yearCodeRepository.findAll(), CodeDto.class));
        projectSelectDataDto.setCustomerCompany(ObjectMapper.mapAll(this.customerCompanyRepository.findAll(), CodeDto.class));
        projectSelectDataDto.setGenderCode(ObjectMapper.mapAll(this.genderCodeRepository.findAll(), CodeDto.class));
        projectSelectDataDto.setSeasonCode(ObjectMapper.mapAll(this.seasonCodeListRepository.findAll(), CodeDto.class));
        projectSelectDataDto.setProductTypeCode(ObjectMapper.mapAll(this.productTypeCodeRepository.findAll(), CodeDto.class));

        return projectSelectDataDto;
    }

}
