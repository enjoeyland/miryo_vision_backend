package com.example.miryo_vision_backend.controller;

import com.example.miryo_vision_backend.controller.dto.ListWrapper;
import com.example.miryo_vision_backend.controller.dto.UiDto;
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
@RequestMapping(value = "/api/project")
public class ProjectController {
    private ProjectService projectService;
    private ControllerDtoConverter controllerDtoConverter;

    @Autowired
    public ProjectController(ProjectService projectService, ControllerDtoConverter controllerDtoConverter) {
        this.projectService = projectService;
        this.controllerDtoConverter = controllerDtoConverter;
    }

    @RequestMapping(value = "/create/initData", method = RequestMethod.GET)
    public ServerResponse<ProjectDto.UiSelect.Create> getCreateInitData() {
        ProjectDto.UiSelect.Create projectCreateInitData = this.projectService.getProjectCreateInitData();
        return new ServerResponse<>(true, projectCreateInitData);
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ServerResponse<Object> createProject(@RequestBody @Valid ProjectDto.Request.Create request) {
        try {
            this.projectService.create(request);
            return new ServerResponse<>(true, "");
        } catch (Exception e) {
            return new ServerResponse<>(false, "" , e.getMessage());
        }
    }

    @RequestMapping(value = "/get_all", method = RequestMethod.GET)
    public ServerResponse<List<ProjectDto.Response>> getAllProjects() {
        List<ProjectDto.Response> projectResponseList = this.projectService.getAll();
        return new ServerResponse<>(true, projectResponseList);
    }

    @RequestMapping(value = "/update/initData", method = RequestMethod.GET)
    public ServerResponse<ProjectDto.UiSelect.Update> getUpdateInitData() {
        ProjectDto.UiSelect.Update projectUpdateInitData = this.projectService.getProjectUpdateInitData();
        return new ServerResponse<>(true, projectUpdateInitData);
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ServerResponse<Object> updateProject(@RequestBody @Valid ProjectDto.Request.Update request) {
        try {
            this.projectService.update(request);
            return new ServerResponse<>(true, "");
        } catch (Exception e) {
            return new ServerResponse<>(false, "", e.getMessage());
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ServerResponse<Object> deleteProject(@RequestBody @Valid ProjectDto.Request.Delete request) {
        this.projectService.delete(request);
        return new ServerResponse<>(true, "");
    }

    @RequestMapping(value = "/search/initData", method = RequestMethod.GET)
    public ServerResponse<ProjectDto.UiSelect.Search> getSearchInitData() {
        ProjectDto.UiSelect.Search projectSearchInitData = this.projectService.getProjectSearchInitData();
        return new ServerResponse<>(true, projectSearchInitData);
    }

    @RequestMapping(value = {"/search"}, method = {RequestMethod.GET,RequestMethod.POST})
    public ServerResponse<UiDto.TableWithFilter<ProjectDto.Response>> getProject(@RequestBody ProjectDto.Request.Search request) {
        List<ProjectDto.Response> projectResponseList = this.projectService.search(request);
        if (foundResult(projectResponseList)) {
            return new ServerResponse<>(true, controllerDtoConverter.toUiTableWithFilter(new ListWrapper<>(projectResponseList)));
        } else {
            return new ServerResponse<>(false, new UiDto.TableWithFilter<>(), "결과를 못 찾았습니다.");
        }
    }

    private boolean foundResult(List<ProjectDto.Response> projectResponseList) {
        return projectResponseList.size() != 0;
    }


}
