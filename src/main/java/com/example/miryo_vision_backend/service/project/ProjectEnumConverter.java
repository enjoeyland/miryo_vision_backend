package com.example.miryo_vision_backend.service.project;

import com.example.miryo_vision_backend.controller.ControllerDtoConverter;
import com.example.miryo_vision_backend.controller.dto.BasicUiDto;
import com.example.miryo_vision_backend.controller.dto.CodeDto;
import com.example.miryo_vision_backend.service.project.enums.*;
import lombok.NonNull;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel="spring")
public abstract class ProjectEnumConverter {
    @Autowired
    ControllerDtoConverter controllerDtoConverter;


    public CustomerClassificationEnum toCustomerClassificationEnum(String name) {
        return CustomerClassificationEnum.findByName(name);
    }
    public GenderEnum toGenderEnum(String name) {
        return GenderEnum.findByName(name);
    }
    public ProductTypeEnum toProductTypeEnum(String name) {
        return ProductTypeEnum.findByName(name);
    }
    public SeasonEnum toSeasonEnum(String name) {
        return SeasonEnum.findByName(name);
    }
    public YearEnum toYearEnum(String name) {
        return YearEnum.findByName(name);
    }

    public String toName(CustomerClassificationEnum e){
        return e.getName();
    }
    public String toName(GenderEnum e){
        return e.getName();
    }
    public String toName(YearEnum e) {
        return e.getName();
    }
    public String toName(SeasonEnum e) {
        return e.getName();
    }
    public String toName(ProductTypeEnum e) {
        return e.getName();
    }


    public CodeDto toCodeDto(@NonNull SeasonEnum seasonEnum) {
        return getCodeDto(seasonEnum.getCode(), seasonEnum.getName(), seasonEnum.ordinal(), seasonEnum.name());
    }
    public CodeDto toCodeDto(@NonNull YearEnum yearEnum) {
        return getCodeDto(yearEnum.getCode(), yearEnum.getName(), yearEnum.ordinal(), yearEnum.name());
    }
    public CodeDto toCodeDto(@NonNull CustomerClassificationEnum customerClassificationEnum) {
        return getCodeDto(customerClassificationEnum.getCode(), customerClassificationEnum.getName(), customerClassificationEnum.ordinal(), customerClassificationEnum.name());
    }
    public CodeDto toCodeDto(@NonNull GenderEnum genderEnum) {
        return getCodeDto(genderEnum.getCode(), genderEnum.getName(), genderEnum.ordinal(), genderEnum.name());
    }
    public CodeDto toCodeDto(@NonNull ProductTypeEnum productTypeEnum) {
        return getCodeDto(productTypeEnum.getCode(), productTypeEnum.getName(), productTypeEnum.ordinal(), productTypeEnum.name());
    }

    public BasicUiDto toBasicUiDto (@NonNull FairStatusEnum fairStatusEnum) {
        return getBasicUiDto(fairStatusEnum.name(), fairStatusEnum.ordinal(), fairStatusEnum.name());
    }

    public abstract List<CodeDto> toCodeDto(SeasonEnum[] seasonEnumList);
    public abstract List<CodeDto> toCodeDto(YearEnum[] yearEnumList);
    public abstract List<CodeDto> toCodeDto(CustomerClassificationEnum[] customerClassificationEnumList);
    public abstract List<CodeDto> toCodeDto(GenderEnum[] genderEnumList);
    public abstract List<CodeDto> toCodeDto(ProductTypeEnum[] productTypeEnumList);
    public abstract List<BasicUiDto> toBasicUiDto(FairStatusEnum[] fairStatusEnumList);


    private CodeDto getCodeDto(char code, String name, int ordinal, String note) {
        CodeDto dto = controllerDtoConverter.toCodeDto(getBasicUiDto(name, ordinal, note));
        dto.setCode(String.valueOf(code));
        return dto;
    }

    private BasicUiDto getBasicUiDto(String name, int ordinal, String note) {
        BasicUiDto dto = new BasicUiDto();
        dto.setName(name);
        dto.setSort(String.valueOf(ordinal));
        dto.setNote(note);
        return dto;
    }

}
