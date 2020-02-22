package com.example.miryo_vision_backend.service.project;


import com.example.miryo_vision_backend.service.project.dto.CodeDto;
import com.example.miryo_vision_backend.service.project.dto.ProjectCodeDto;
import com.example.miryo_vision_backend.service.project.dto.ProjectCodeNameDto;
import com.example.miryo_vision_backend.service.project.dto.ProjectSelectDataDto;
import com.example.miryo_vision_backend.entity.Project;
import com.example.miryo_vision_backend.repository.CustomerCompanyRepository;
import com.example.miryo_vision_backend.repository.ProjectRepository;
import com.example.miryo_vision_backend.repository.project_select.*;
import com.example.miryo_vision_backend.service.CrudService;
import com.example.miryo_vision_backend.utils.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


import java.util.Collection;
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

    private ProjectEntityConverter projectEntityConverter;
    private ProjectInfoCreator      projectInfoCreator;

    private Logger logger = LoggerFactory.getLogger(ProjectService.class);


    @Autowired
    public ProjectService(CustomerClassificationCodeRepository customerClassificationCodeRepository,
                          YearCodeRepository yearCodeRepository,
                          CustomerCompanyRepository customerCompanyRepository,
                          GenderCodeRepository genderCodeRepository,
                          SeasonCodeListRepository seasonCodeListRepository,
                          ProductTypeCodeRepository productTypeCodeRepository,
                          ProjectRepository projectRepository) {
        this.customerClassificationCodeRepository = customerClassificationCodeRepository;
        this.yearCodeRepository = yearCodeRepository;
        this.customerCompanyRepository = customerCompanyRepository;
        this.genderCodeRepository = genderCodeRepository;
        this.seasonCodeListRepository = seasonCodeListRepository;
        this.productTypeCodeRepository = productTypeCodeRepository;
        this.projectRepository = projectRepository;
    }


    @Override
    public void create(ProjectCodeNameDto projectCodeNameDto) {
//        이벤트 처리
        Project project = ObjectMapper.map(projectCodeNameDto, Project.class);

        Long id = customerCompanyRepository.findByName(projectCodeNameDto.getCustomerCompanyName()).getId();
        project.getCustomerCompany().setId(id);

        project.setStartDatetime(projectInfoCreator.getCurrentDatetime());

        project = this.projectRepository.save(project);

        project.setBarcode(generateProjectBarcode(this.nameToCode(projectCodeNameDto)) + String.format("%03d", project.getId()).substring(0, 3));
        this.projectRepository.save(project);
    }

    @Override
    public void createAll(List<ProjectCodeNameDto> projectCodeNameDtoList) {

    }


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
        return toDto(projectRepository.findAll(ProjectPredicate.search(projectCodeNameDto)));
    }

    @Override
    public List<ProjectCodeNameDto> getAll() {
        return this.toDto(this.projectRepository.findAll());
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

    // todo: JPA에서 @ID를 보고 update를 해줄지 확인 필요
    public void editProjectData(Project project) {
        this.projectRepository.save(project);
    }








    private Project toEntity(ProjectCodeNameDto projectCodeNameDto) {
//        return projectCodeNameDto.toEntity();
        // 바코드 안만들어짐 ㅜㅜ
        Project project = ObjectMapper.map(projectCodeNameDto, Project.class);
        project.setBarcode(generateProjectBarcode(this.nameToCode(projectCodeNameDto)) + String.format("%03d", project.getId()).substring(0, 3));
        return project;
    }

    private List<ProjectCodeNameDto> toDto(Collection<Project> projectList) {
        return ObjectMapper.mapAll(projectList, ProjectCodeNameDto.class);
    }

    // todo: 다른 방법찾기
    private ProjectCodeDto nameToCode(ProjectCodeNameDto projectCodeNameDto) {
        ProjectCodeDto projectCodeDto = new ProjectCodeDto();
        projectCodeDto.setYearCode(yearCodeRepository.findByName(projectCodeNameDto.getYearCodeName()).getCode());
        projectCodeDto.setCustomerClassificationCode(customerClassificationCodeRepository.findByName(projectCodeNameDto.getCustomerClassificationCodeName()).getCode());
        projectCodeDto.setCustomerCompanyCode(customerCompanyRepository.findByName(projectCodeNameDto.getCustomerCompanyName()).getCode());
        projectCodeDto.setSeasonCode(seasonCodeListRepository.findByName(projectCodeNameDto.getSeasonCodeName()).getCode());
        projectCodeDto.setProductTypeCode(productTypeCodeRepository.findByName(projectCodeNameDto.getProductTypeCodeName()).getCode());
        projectCodeDto.setGenderCode(genderCodeRepository.findByName(projectCodeNameDto.getGenderCodeName()).getCode());
        return projectCodeDto;
    }


    private String generateProjectBarcode(ProjectCodeDto projectCodeDto) {
        return projectCodeDto.getCustomerClassificationCode() +
                projectCodeDto.getYearCode() +
                String.format("%02d",  Integer.parseInt(projectCodeDto.getCustomerCompanyCode())).substring(0, 2) +
                projectCodeDto.getGenderCode() +
                projectCodeDto.getSeasonCode() +
                projectCodeDto.getProductTypeCode();
    }
}
