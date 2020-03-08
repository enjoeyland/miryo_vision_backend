package com.example.miryo_vision_backend.service.project;


import com.example.miryo_vision_backend.entity.Project;
import com.example.miryo_vision_backend.repository.ProjectRepository;
import com.example.miryo_vision_backend.service.CrudService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


//todo : 모델 맵핑이 무언가 잘못됨

@Service
public class ProjectService implements CrudService<ProjectDto.Response, ProjectDto.Request.Create,ProjectDto.Request.Update,ProjectDto.Request.Delete, ProjectDto.Request.Search> {
    private ProjectRepository       projectRepository;
    private ProjectEntityConverter  projectEntityConverter;
    private ProjectInfoCreator      projectInfoCreator;

    @Autowired
    public ProjectService(ProjectRepository projectRepository,
                          ProjectEntityConverter projectEntityConverter, ProjectInfoCreator projectInfoCreator) {
        this.projectRepository = projectRepository;
        this.projectEntityConverter = projectEntityConverter;
        this.projectInfoCreator = projectInfoCreator;
    }


    @Override
    public void create(ProjectDto.Request.Create projectCreateRequest) {
        // todo: 이벤트 처리
        Project project = projectEntityConverter.toSavableEntity(projectCreateRequest);
        project = this.projectRepository.save(project);
        projectEntityConverter.updateToCompleteEntity(project);
        this.projectRepository.save(project);
    }

    @Override
    public void createAll(List<ProjectDto.Request.Create> projectCreateRequest) {
        for (ProjectDto.Request.Create dto: projectCreateRequest) {
            create(dto);
        }
    }


    // todo: JPA에서 @ID를 보고 update를 해줄지 확인 필요
    @Override
    public void update(ProjectDto.Request.Update projectUpdateRequest) {

    }

    @Override
    public void updateAll(List<ProjectDto.Request.Update> projectUpdateRequest) {

    }


    @Override
    public void delete(ProjectDto.Request.Delete projectDeleteRequest) {
    }

    @Override
    public void deleteAll(List<ProjectDto.Request.Delete> projectDeleteRequest) {
    }

    @Override
    public List<ProjectDto.Response> search(ProjectDto.Request.Search projectSearchRequest) {
        Predicate predicate = ProjectPredicate.search(projectSearchRequest);
        return projectEntityConverter.toProjectResponse(projectRepository.findAll(predicate));
    }

    @Override
    public List<ProjectDto.Response> getAll() {
        return this.projectEntityConverter.toProjectResponse(this.projectRepository.findAll());
    }

    public ProjectDto.UiSelect.Create getProjectCreateInitData() {
        return projectEntityConverter.toUiSelectForProjectCreate(projectInfoCreator.getUiSelectForProject());
    }

    public ProjectDto.UiSelect.Search getProjectSearchInitData() {
        return projectEntityConverter.toUiSelectForProjectSearch(projectInfoCreator.getUiSelectForProject());
    }

}
