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
            @Mapping(source = "name",target = "note", qualifiedByName = "toNote"), //hint : https://stackoverflow.com/questions/60586737/mapstruct-error-occur-when-using-target-field-type-as-object/60588174#60588174
            @Mapping(source = "name",target = "disassemble",qualifiedByName = "toDisassemble")
    })
    public abstract UiDto.Option.Filterable toUiFilterableOption(String name);
    public abstract Set<UiDto.Option.Filterable> toUiFilterableOption(Set<String> uiOption);
    @Named("toUiFilterableOption")
    public abstract Map<String, Set<UiDto.Option.Filterable>> toUiFilterableOption(Map<String, Set<String>> uiOption);


    // todo: list로는 못 받는지 물어보기
    // todo: generic type 어떻게
//    @Mappings({
//            @Mapping(source = "list", target = "dataSource"),
//            @Mapping(source = "list", target = "filterData", qualifiedByName = {"toEachFieldToSet","toUiFilterableOption"})
//    })
//    public abstract UiDto.TableWithFilter toUiTableWithFilter(ListWrapper<? extends UiDto.TableRow.ListIndex> listWrapper);
    public <T extends UiDto.TableRow.ListIndex> UiDto.TableWithFilter<T> toUiTableWithFilter(ListWrapper<T> listWrapper){
        setListIndex(listWrapper);
        UiDto.TableWithFilter<T> tableWithFilter= new UiDto.TableWithFilter<>();
        tableWithFilter.setDataSource(listWrapper.getList());
        tableWithFilter.setFilterData( toUiFilterableOption(Converter.eachFieldToSet(listWrapper.getList())));
        return tableWithFilter;
    }

    @BeforeMapping
    protected void setListIndex(ListWrapper<? extends UiDto.TableRow.ListIndex> listWrapper) {
        IntStream.range(0, listWrapper.getList().size())
                .forEach(i -> listWrapper.getList().get(i).setListIndex(i + 1));
    }

    @Named("toNote")
    protected Object toNote(String name) {
        return name;
    }
}
