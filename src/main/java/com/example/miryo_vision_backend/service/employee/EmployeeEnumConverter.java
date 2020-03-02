package com.example.miryo_vision_backend.service.employee;

import com.example.miryo_vision_backend.controller.dto.BasicUiDto;
import com.example.miryo_vision_backend.service.employee.enums.DepartmentEnum;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel="spring")
public abstract class EmployeeEnumConverter {
    public BasicUiDto toBasicUiDto(@NonNull DepartmentEnum departmentEnum) {
        return getBasicUiDto(departmentEnum.getName(), departmentEnum.ordinal(), departmentEnum.name());
    }

    public abstract List<BasicUiDto> toBasicUiDto(DepartmentEnum[] departmentEnumList);


    private BasicUiDto getBasicUiDto(String name, int ordinal, String note) {
        BasicUiDto dto = new BasicUiDto();
        dto.setName(name);
        dto.setSort(String.valueOf(ordinal));
        dto.setNote(note);
        return dto;
    }
}
