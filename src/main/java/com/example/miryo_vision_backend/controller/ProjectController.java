package com.example.miryo_vision_backend.controller;

import com.example.miryo_vision_backend.service.project.dto.ProjectCodeNameDto;
import com.example.miryo_vision_backend.service.project.dto.ProjectSelectDataDto;
import com.example.miryo_vision_backend.dto.for_controller.ResponseDto;
import com.example.miryo_vision_backend.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/project")
public class ProjectController {
    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(value = "/init_data", method = RequestMethod.GET)
    public ResponseDto getInitData() {
        ProjectSelectDataDto projectSelectDataDto = this.projectService.getProjectSelectData();

        return new ResponseDto(true, projectSelectDataDto);
    }

    // todo : @Valid에서 inValid되면 어떻게 되는지 확인
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    // todo: ProjectCodeNameDto->projectDto 만들어 바꾸기
    public ResponseDto createProject(@RequestBody ProjectCodeNameDto projectCodeNameDto) {
        // note: projectDto의 toEntity구현 안됨
        this.projectService.create(projectCodeNameDto);
        return new ResponseDto(true, "");
    }

    @RequestMapping(value = "/get_all", method = RequestMethod.GET)
    public ResponseDto getAllProjects() {
        // todo: ProjectCodeNameDto를 상속받은 필요한 데이터만 갖도록 하는 Dto만들기
        //  즉 service로 내려보내는 dto와 service에서 올라오는 dto 구별하여 만들기
        List<ProjectCodeNameDto> projectCodeNameDtoList = this.projectService.getAll();
        return new ResponseDto(true, projectCodeNameDtoList);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseDto getProject(@RequestBody ProjectCodeNameDto projectCodeNameDto) {
        List<ProjectCodeNameDto> projectCodeNameDtoList = this.projectService.search(projectCodeNameDto);
        return new ResponseDto(true, projectCodeNameDtoList);
    }
}
