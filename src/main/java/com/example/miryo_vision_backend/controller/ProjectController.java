package com.example.miryo_vision_backend.controller;

import com.example.miryo_vision_backend.controller.dto.FilterDto;
import com.example.miryo_vision_backend.controller.dto.TableWithFilterDto;
import com.example.miryo_vision_backend.service.project.ProjectEntityConverter;
import com.example.miryo_vision_backend.service.project.dto.*;
import com.example.miryo_vision_backend.controller.dto.ResponseDto;
import com.example.miryo_vision_backend.service.project.ProjectService;
import com.example.miryo_vision_backend.utils.FieldReflection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value = "/project")
public class ProjectController {
    private ProjectService projectService;
    private ControllerDtoConverter controllerDtoConverter;
    private ProjectEntityConverter projectEntityConverter;

    @Autowired
    public ProjectController(ProjectService projectService, ControllerDtoConverter controllerDtoConverter, ProjectEntityConverter projectEntityConverter) {
        this.projectService = projectService;
        this.controllerDtoConverter = controllerDtoConverter;
        this.projectEntityConverter = projectEntityConverter;
    }

    @RequestMapping(value = "/create/initData", method = RequestMethod.GET)
    public ResponseDto getCreateInitData() {
        ProjectCreateInitDataDto projectCreateInitData = this.projectService.getProjectCreateInitData();

        return new ResponseDto(true, projectCreateInitData);
    }

    // todo : @Valid에서 inValid되면 어떻게 되는지 확인
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseDto createProject(@RequestBody ProjectCreateRequestDto projectCreateRequestDto) {
        this.projectService.create(projectCreateRequestDto);
        return new ResponseDto(true, "");
    }

    @RequestMapping(value = "/get_all", method = RequestMethod.GET)
    public ResponseDto getAllProjects() {
        List<ProjectResponseDto> ProjectResponseDtoList = this.projectService.getAll();
        return new ResponseDto(true, ProjectResponseDtoList);
    }

    @RequestMapping(value = "/search/initData", method = RequestMethod.GET)
    public ResponseDto getSearchInitData() {
        // todo: 바꾸기
        ProjectSearchInitDataDto projectSearchInitData = this.projectService.getProjectSearchInitData();

        return new ResponseDto(true, projectSearchInitData);
    }

    //fixme: search해서 찾은것이 없으면 500 에러남
    @RequestMapping(value = {"/search", "/projectRecord/queryProjects"})
    public ResponseDto getProject(@RequestBody ProjectSearchRequestDto projectSearchRequestDto) {
        List<ProjectResponseDto> projectResponseDtoList = this.projectService.search(projectSearchRequestDto);

        // todo: annotation으로 쉽게 만들수 있는지 확인
        projectEntityConverter.setKey(projectResponseDtoList);
        Map<String, Set<FilterDto>> filterMap = FieldReflection.eachFieldToSet(projectResponseDtoList, FilterDto.class);
        controllerDtoConverter.setDisassemble(filterMap);
        TableWithFilterDto tableWithFilterDto = new TableWithFilterDto(projectResponseDtoList, filterMap);
        return new ResponseDto(true, tableWithFilterDto);
    }

}
