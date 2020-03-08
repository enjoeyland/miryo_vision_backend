package com.example.miryo_vision_backend.service.employee;

import com.example.miryo_vision_backend.controller.dto.UiDto;
import com.example.miryo_vision_backend.entity.Employee;
import com.example.miryo_vision_backend.utils.Converter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel="spring",uses = {Converter.class})
public abstract class EmployeeEntityConverter {
    @Mappings({
        @Mapping(source = "name", target = "sort"),
        @Mapping(target = "note", ignore = true),
        @Mapping(source = "name", target = "disassemble", qualifiedByName = "toDisassemble")
    })
    public abstract UiDto.Option.WithId toUiOption(Employee employee);
    public abstract List<UiDto.Option.WithId> toUiOption(List<Employee> employeeList);
}
