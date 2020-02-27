package com.example.miryo_vision_backend.service.project;

import com.example.miryo_vision_backend.service.project.dto.CodeDto;
import com.example.miryo_vision_backend.service.project.enums.*;
import lombok.NonNull;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel="spring")
public abstract class ProjectSelectConverter {

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
    public abstract List<CodeDto> toCodeDto(SeasonEnum[] seasonEnumList);
    public abstract List<CodeDto> toCodeDto(YearEnum[] yearEnumList);
    public abstract List<CodeDto> toCodeDto(CustomerClassificationEnum[] customerClassificationEnumList);
    public abstract List<CodeDto> toCodeDto(GenderEnum[] genderEnumList);
    public abstract List<CodeDto> toCodeDto(ProductTypeEnum[] productTypeEnumList);


    private CodeDto getCodeDto(char code, String name, int ordinal, String note) {
        CodeDto codeDto = new CodeDto();
        codeDto.setCode(String.valueOf(code));
        codeDto.setName(name);
        codeDto.setSort(String.valueOf(ordinal));
        codeDto.setNote(note);
        return codeDto;
    }

}
