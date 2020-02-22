package com.example.miryo_vision_backend.service.project;

import com.example.miryo_vision_backend.entity.Project;
import com.example.miryo_vision_backend.repository.ProjectRepository;
import com.example.miryo_vision_backend.service.project.dto.ProjectCodeNameDto;
import com.example.miryo_vision_backend.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class ProjectEntityConverter {
    private ProjectInfoCreator projectInfoCreator;
    private ProjectRepository projectRepository;

    @Autowired
    public ProjectEntityConverter(ProjectInfoCreator projectInfoCreator, ProjectRepository projectRepository) {
        this.projectInfoCreator = projectInfoCreator;
        this.projectRepository = projectRepository;
    }


    public Project toCompleteEntity(ProjectCodeNameDto projectCodeNameDto) {
        Project project = this.toSearchEntity(projectCodeNameDto);

        project.getCustomerCompany().setId(
                projectInfoCreator.getCustomerCompanyId(
                        projectCodeNameDto.getCustomerCompanyName()
                )
        );
        project.setStartDatetime(projectInfoCreator.getCurrentDatetime());


        // todo : 좀 문제 있음. save를 해야지 id가 나오는지 다시 확인
        //        Service쪽에서 save를 해야지 정상임
        project = this.projectRepository.save(project);
        project.setBarcode(projectInfoCreator.getProjectBarcode(project));

        return project;
    }

    public Project toSearchEntity(ProjectCodeNameDto projectCodeNameDto) {
        return ObjectMapper.map(projectCodeNameDto, Project.class);
    }

    List<ProjectCodeNameDto> toProjectCodeNameDto(Collection<Project> projectList) {
        return ObjectMapper.mapAll(projectList, ProjectCodeNameDto.class);
    }
}
