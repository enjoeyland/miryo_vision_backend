package com.example.miryo_vision_backend.service.customerCompany;

import com.example.miryo_vision_backend.controller.dto.UiDto;
import com.example.miryo_vision_backend.entity.CustomerCompany;
import com.example.miryo_vision_backend.utils.Converter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring",uses = {Converter.class})
public abstract class CustomerCompanyEntityConverter {
    @Mappings({
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "name", target = "sort"),
        @Mapping(source = "name", target = "disassemble",qualifiedByName = "toDisassemble"),
    })
    public abstract UiDto.Option.WithIdAndCode toUiOptionWithIdAndCode(CustomerCompany customerCompany);
    public abstract List<UiDto.Option.WithIdAndCode> toUiOptionWithIdAndCode(List<CustomerCompany> customerCompany);
}
