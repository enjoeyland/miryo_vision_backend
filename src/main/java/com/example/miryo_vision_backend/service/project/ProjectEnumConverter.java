package com.example.miryo_vision_backend.service.project;

import com.example.miryo_vision_backend.controller.ControllerDtoConverter;
import com.example.miryo_vision_backend.controller.dto.UiDto;
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

    public UiDto.Option.WithCode toUiOptionWithCode(@NonNull SeasonEnum seasonEnum) {
        return getUiOptionWithCode(seasonEnum.getName(), seasonEnum.ordinal(), seasonEnum.name(), seasonEnum.getCode());
    }
    public UiDto.Option.WithCode toUiOptionWithCode(@NonNull YearEnum yearEnum) {
        return getUiOptionWithCode(yearEnum.getName(), yearEnum.ordinal(), yearEnum.name(), yearEnum.getCode());
    }
    public UiDto.Option.WithCode toUiOptionWithCode(@NonNull CustomerClassificationEnum customerClassificationEnum) {
        return getUiOptionWithCode(customerClassificationEnum.getName(), customerClassificationEnum.ordinal(), customerClassificationEnum.name(), customerClassificationEnum.getCode());
    }
    public UiDto.Option.WithCode toUiOptionWithCode(@NonNull GenderEnum genderEnum) {
        return getUiOptionWithCode(genderEnum.getName(), genderEnum.ordinal(), genderEnum.name(), genderEnum.getCode());
    }
    public UiDto.Option.WithCode toUiOptionWithCode(@NonNull ProductTypeEnum productTypeEnum) {
        return getUiOptionWithCode(productTypeEnum.getName(), productTypeEnum.ordinal(), productTypeEnum.name(), productTypeEnum.getCode());
    }

    public UiDto.Option.KoreanSearchable toUiOption(@NonNull FairStatusEnum fairStatusEnum) {
        return getUiOption(fairStatusEnum.name(), fairStatusEnum.ordinal(), fairStatusEnum.name());
    }

    public abstract List<UiDto.Option.WithCode> toUiOptionWithCode(SeasonEnum[] seasonEnumList);
    public abstract List<UiDto.Option.WithCode> toUiOptionWithCode(YearEnum[] yearEnumList);
    public abstract List<UiDto.Option.WithCode> toUiOptionWithCode(CustomerClassificationEnum[] customerClassificationEnumList);
    public abstract List<UiDto.Option.WithCode> toUiOptionWithCode(GenderEnum[] genderEnumList);
    public abstract List<UiDto.Option.WithCode> toUiOptionWithCode(ProductTypeEnum[] productTypeEnumList);
    public abstract List<UiDto.Option.KoreanSearchable> toUiOption(FairStatusEnum[] fairStatusEnumList);


    private UiDto.Option.WithCode getUiOptionWithCode(String name, int ordinal, String note, char code) {
        return controllerDtoConverter.toUiOptionWithCode(getUiOption(name, ordinal, note), String.valueOf(code));
    }

    private UiDto.Option.KoreanSearchable getUiOption(String name, int ordinal, String note) {
        return controllerDtoConverter.toUiOption(name, String.valueOf(ordinal), note);
    }

}
