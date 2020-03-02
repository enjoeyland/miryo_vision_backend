package com.example.miryo_vision_backend.service.employee;

import com.example.miryo_vision_backend.controller.dto.BasicUiDto;
import com.example.miryo_vision_backend.entity.Employee;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel="spring")
public abstract class EmployeeEntityConverter {
    public BasicUiDto toBasicUiDto(@NonNull Employee employee) {
        return new BasicUiDto(employee.getName(), employee.getId(), employee.getName(),"");
    }

    public abstract List<BasicUiDto> toBasicUiDto(List<Employee> employeeList);
}
