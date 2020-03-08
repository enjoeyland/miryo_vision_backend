package com.example.miryo_vision_backend.controller;

import com.example.miryo_vision_backend.controller.dto.*;
import com.example.miryo_vision_backend.utils.Converter;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

@Component
@Mapper(componentModel="spring", uses = {Converter.class})
public abstract class ControllerDtoConverter {
    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "name", target = "disassemble", qualifiedByName = "toDisassemble")
    })
    public abstract UiDto.Option.KoreanSearchable toUiOption(String name, Object sort, Object note);

    @Mappings({
            @Mapping(source = "uiOption.name",target = "name"),
            @Mapping(source = "uiOption.sort",target = "sort"),
            @Mapping(source = "uiOption.note",target = "note"),
            @Mapping(source = "uiOption.disassemble",target = "disassemble"),
    })
    public abstract UiDto.Option.WithCode toUiOptionWithCode(UiDto.Option.KoreanSearchable uiOption, String code);

    @Mappings({
            @Mapping(source = "name",target = "name"),
            @Mapping(target = "note",expression = "java(name)"), // todo: Object type로 Mapping이 안됨(stackoverflow에 질문함)
            @Mapping(source = "name",target = "disassemble",qualifiedByName = "toDisassemble")
    })
    public abstract UiDto.Option.Filterable toUiFilterableOption(String name);
    public abstract Set<UiDto.Option.Filterable> toUiFilterableOption(Set<String> uiOption);
    @Named("toUiFilterableOption")
    public abstract Map<String, Set<UiDto.Option.Filterable>> toUiFilterableOption(Map<String, Set<String>> uiOption);

    @Mappings({
        @Mapping(source = "list", target = "dataSource"),
        @Mapping(source = "list", target = "filterData", qualifiedByName = {"toEachFieldToSet","toUiFilterableOption"})
    })
    // todo: list로는 못 받는지 물어보기
    public abstract UiDto.TableWithFilter toUiTableWithFilter(ListWrapper<? extends UiDto.TableRow.ListIndex> listWrapper);


    @BeforeMapping
    protected void setListIndex(ListWrapper<? extends UiDto.TableRow.ListIndex> listWrapper) {
        IntStream.range(0, listWrapper.getList().size())
                .forEach(i -> listWrapper.getList().get(i).setListIndex(i + 1));
    }


}
