package com.example.miryo_vision_backend.service.project;


import com.example.miryo_vision_backend.entity.CustomerCompany;
import com.example.miryo_vision_backend.service.project.dto.CodeDto;
import com.example.miryo_vision_backend.service.project.dto.ProjectCodeNameDto;
import com.example.miryo_vision_backend.service.project.dto.ProjectSelectDataDto;
import com.example.miryo_vision_backend.entity.Project;
import com.example.miryo_vision_backend.repository.CustomerCompanyRepository;
import com.example.miryo_vision_backend.repository.ProjectRepository;
import com.example.miryo_vision_backend.service.CrudService;
import com.example.miryo_vision_backend.service.project.enums.*;
import com.example.miryo_vision_backend.utils.ModelMapperWrapper;
import com.querydsl.core.types.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;


//todo : 모델 맵핑이 무언가 잘못됨

@Service
public class ProjectService implements CrudService<ProjectCodeNameDto> {
    private ProjectRepository           projectRepository;
    private ProjectEntityConverter  projectEntityConverter;

    private Logger logger = LoggerFactory.getLogger(ProjectService.class);


    @Autowired
    public ProjectService(ProjectRepository projectRepository,
                          ProjectEntityConverter projectEntityConverter) {
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
        for (ProjectCodeNameDto dto:projectCodeNameDtoList) {
            create(dto);
        }
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

        ModelMapperWrapper.mapAll(Arrays.asList(SeasonEnum.values()), CodeDto.class);

        return projectEntityConverter.toProjectSelectDataDto(
                CustomerClassificationEnum.values(),
                YearEnum.values(),
                SeasonEnum.values(),
                GenderEnum.values(),
                ProductTypeEnum.values());
    }

}
