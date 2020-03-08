package com.example.miryo_vision_backend.controller;

import com.example.miryo_vision_backend.controller.dto.ListWrapper;
import com.example.miryo_vision_backend.service.project.ProjectDto;
import com.example.miryo_vision_backend.controller.dto.ServerResponse;
import com.example.miryo_vision_backend.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid; // todo : @Valid에서 inValid되면 어떻게 되는지 확인
import java.util.*;

@RestController
@RequestMapping(value = "/project")
public class ProjectController {
    private ProjectService projectService;
    private ControllerDtoConverter controllerDtoConverter;

    @Autowired
    public ProjectController(ProjectService projectService, ControllerDtoConverter controllerDtoConverter) {
        this.projectService = projectService;
        this.controllerDtoConverter = controllerDtoConverter;
    }

    @RequestMapping(value = "/create/initData", method = RequestMethod.GET)
    public ServerResponse getCreateInitData() {
        ProjectDto.UiSelect.Create projectCreateInitData = this.projectService.getProjectCreateInitData();
        return new ServerResponse(true, projectCreateInitData);
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ServerResponse createProject(@RequestBody @Valid ProjectDto.Request.Create projectCreateRequest) {
        this.projectService.create(projectCreateRequest);
        return new ServerResponse(true, "");
    }

    @RequestMapping(value = "/get_all", method = RequestMethod.GET)
    public ServerResponse getAllProjects() {
        List<ProjectDto.Response> projectResponseList = this.projectService.getAll();
        return new ServerResponse(true, projectResponseList);
    }

    @RequestMapping(value = "/search/initData", method = RequestMethod.GET)
    public ServerResponse getSearchInitData() {
        ProjectDto.UiSelect.Search projectSearchInitData = this.projectService.getProjectSearchInitData();
        return new ServerResponse(true, projectSearchInitData);
    }

    //fixme: search해서 찾은것이 없으면 500 에러남
    @RequestMapping(value = {"/search", "/projectRecord/queryProjects"})
    public ServerResponse getProject(@RequestBody ProjectDto.Request.Search projectSearchRequest) {
        List<ProjectDto.Response> projectResponseList = this.projectService.search(projectSearchRequest);
        return new ServerResponse(true, controllerDtoConverter.toUiTableWithFilter(new ListWrapper<>(projectResponseList)));
    }



}
