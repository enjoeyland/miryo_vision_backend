package com.example.miryo_vision_backend.service.project;


import com.example.miryo_vision_backend.entity.Project;
import com.example.miryo_vision_backend.exception.DuplicateException;
import com.example.miryo_vision_backend.exception.WrongIdException;
import com.example.miryo_vision_backend.repository.ProjectRepository;
import com.example.miryo_vision_backend.service.CrudService;
import com.querydsl.core.types.Predicate;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


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
    @SneakyThrows(DuplicateException.class)
    public void create(ProjectDto.Request.Create request) {
        if (isProjectAlreadyExist(request)){
            throw new DuplicateException("같은 프로젝트를 여러번 생성할 수 없습니다.");
        }

        Project project = projectEntityConverter.toSavableEntity(request);
        project = this.projectRepository.save(project);
        projectEntityConverter.updateToCompleteEntity(project);
        this.projectRepository.save(project);

        // todo: 이벤트 처리

    }

    @Override
    @SneakyThrows(WrongIdException.class) // fixme : 만약 updateAll에서 에러가 나면??
    public void update(ProjectDto.Request.Update projectUpdateRequest) {
        Project project = projectRepository.findById(projectUpdateRequest.getId()).orElseThrow(()->new WrongIdException("wrong id"));
        projectEntityConverter.updateFairResultDatetime(projectUpdateRequest, project);
        projectEntityConverter.updateProject(projectUpdateRequest, project);
        this.projectRepository.save(project);

        // todo: 이벤트 처리
        //       win시 -> activate project
    }


    @Override
    public void delete(ProjectDto.Request.Delete request) {
        projectRepository.deleteById(request.id);
    }

    @Override
    public List<ProjectDto.Response> search(ProjectDto.Request.Search request) { // NonMatchException
        Predicate predicate = ProjectPredicate.search(request);
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

    public ProjectDto.UiSelect.Update getProjectUpdateInitData() {
        return projectEntityConverter.toUiSelectForProjectUpdate(projectInfoCreator.getUiSelectForProject());
    }


    private boolean isProjectAlreadyExist(ProjectDto.Request.Create request) {
        return search(projectEntityConverter.toProjectSearchRequest(request)).size() != 0;
    }
}
