package com.example.miryo_vision_backend.controller;

import com.example.miryo_vision_backend.controller.dto.BasicUiDto;
import com.example.miryo_vision_backend.controller.dto.CodeDto;
import com.example.miryo_vision_backend.controller.dto.FilterDto;
import com.example.miryo_vision_backend.utils.HangulDivider;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
@Mapper(componentModel="spring")
public abstract class ControllerDtoConverter {
    public abstract CodeDto toCodeDto(BasicUiDto basicUiDto);

    public abstract FilterDto toFilterDto(BasicUiDto basicUiDto);
    public abstract void update(FilterDto filterDtoS, @MappingTarget FilterDto filterDtoT);

    public void setDisassemble(Map<String, Set<FilterDto>> filterMap) {
        for (String key: filterMap.keySet()){
            for (FilterDto dto:filterMap.get(key)) {
                dto.setDisassemble(HangulDivider.hangulDivide((String) dto.getName()));
            }
        }
    }
}
