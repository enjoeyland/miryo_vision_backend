package com.example.miryo_vision_backend.service.project;


import com.example.miryo_vision_backend.controller.dto.CodeDto;
import com.example.miryo_vision_backend.service.project.dto.*;
import com.example.miryo_vision_backend.entity.Project;
import com.example.miryo_vision_backend.repository.ProjectRepository;
import com.example.miryo_vision_backend.service.CrudService;
import com.example.miryo_vision_backend.service.project.enums.*;
import com.example.miryo_vision_backend.utils.ModelMapperWrapper;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;


//todo : 모델 맵핑이 무언가 잘못됨

@Service
public class ProjectService implements CrudService<ProjectResponseDto, ProjectCreateRequestDto,ProjectRequestDto,ProjectRequestDto, ProjectSearchRequestDto> {
    private ProjectRepository           projectRepository;
    private ProjectEntityConverter  projectEntityConverter;

    @Autowired
    public ProjectService(ProjectRepository projectRepository,
                          ProjectEntityConverter projectEntityConverter) {
        this.projectRepository = projectRepository;
        this.projectEntityConverter = projectEntityConverter;
    }


    @Override
    public void create(ProjectCreateRequestDto projectCreateRequestDto) {
        // todo: 이벤트 처리
        Project project = projectEntityConverter.toCompleteEntity(projectCreateRequestDto);
        this.projectRepository.save(project);

    }

    @Override
    public void createAll(List<ProjectCreateRequestDto> projectCreateRequestDto) {
        for (ProjectCreateRequestDto dto: projectCreateRequestDto) {
            create(dto);
        }
    }


    // todo: JPA에서 @ID를 보고 update를 해줄지 확인 필요
    @Override
    public void update(ProjectRequestDto projectRequestDto) {

    }

    @Override
    public void updateAll(List<ProjectRequestDto> projectRequestDto) {

    }


    @Override
    public void delete(ProjectRequestDto projectRequestDto) {
    }

    @Override
    public void deleteAll(List<ProjectRequestDto> projectRequestDto) {
    }

    @Override
    public List<ProjectResponseDto> search(ProjectSearchRequestDto projectSearchRequestDto) {
        Predicate predicate = ProjectPredicate.search(projectSearchRequestDto);
        return projectEntityConverter.toProjectDto(projectRepository.findAll(predicate));
    }

    @Override
    public List<ProjectResponseDto> getAll() {
        return this.projectEntityConverter.toProjectDto(this.projectRepository.findAll());
    }

    public ProjectCreateInitDataDto getProjectCreateInitData() {

        ModelMapperWrapper.mapAll(Arrays.asList(SeasonEnum.values()), CodeDto.class);

        return projectEntityConverter.toProjectCreateInitDataDto();
    }

    public ProjectSearchInitDataDto getProjectSearchInitData() {


        return projectEntityConverter.toProjectSearchInitDataDto();
    }

}
