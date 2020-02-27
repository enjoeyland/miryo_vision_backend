package com.example.miryo_vision_backend.service;

import com.example.miryo_vision_backend.service.project.dto.ProjectCodeNameDto;
import com.example.miryo_vision_backend.entity.Project;
import com.example.miryo_vision_backend.repository.ProjectRepository;
import com.example.miryo_vision_backend.service.project.ProjectService;
import com.example.miryo_vision_backend.utils.ModelMapperWrapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProjectServiceTest {
    private Logger logger = LoggerFactory.getLogger(ProjectServiceTest.class);


    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectRepository projectRepository;


    @Test
    void getAllProjects() {
        List<Project> projectList = projectRepository.findAll();
        List<ProjectCodeNameDto> expectedProjectCodeNameDtoList = ModelMapperWrapper.mapAll(projectList, ProjectCodeNameDto.class);
        List<ProjectCodeNameDto> testingProjectCodeNameDtoList = projectService.getAll();

        // hint: org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: entity.Project.itemList, could not initialize proxy - no Session
        //       문제상황: @OneToMany를 하고 fetch를 lazy로 한 상태로 lombok에서 toString를 하면 에러 발생
        //       해결방법: @OneToMany 위에 @ToString.Exclude 추가

        // assertThat(testingProjectCodeNameDtoList.get(0).toString() , not(projectList.get(0).toString()));

        assertThat(testingProjectCodeNameDtoList.toString(), is(expectedProjectCodeNameDtoList.toString()));
    }

    @Test
    void search() {
        ProjectCodeNameDto projectCodeNameDto = new ProjectCodeNameDto();
        projectCodeNameDto.setYear("2019");
        projectCodeNameDto.setCustomerCompanyName("한국가스공사");
        List<ProjectCodeNameDto> testingProjectCodeNameDtoList = projectService.search(projectCodeNameDto);
        ProjectCodeNameDto expectedProjectCodeNameDto = ModelMapperWrapper.map(projectRepository.findById(29L).get(), ProjectCodeNameDto.class);

        assertThat(testingProjectCodeNameDtoList.get(0).toString(), is(expectedProjectCodeNameDto.toString()));
    }

}
