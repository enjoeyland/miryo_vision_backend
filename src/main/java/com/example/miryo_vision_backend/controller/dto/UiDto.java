package com.example.miryo_vision_backend.controller.dto;

import com.example.miryo_vision_backend.utils.HangulDivider;
import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import java.util.Set;


public enum UiDto {;
    private interface DataSource {Object getDataSource();}
    private interface FilterData {Map<String, Set<Option.Filterable>> getFilterData();}

    public enum TableRow{;
        public interface ListIndex {
            @JsonGetter("key")
            Integer getListIndex();
            void setListIndex(Integer listIndex);
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    @EqualsAndHashCode
    public static class TableWithFilter<T extends TableRow.ListIndex> implements DataSource,FilterData{
        List<T> dataSource;
        Map<String, Set<Option.Filterable>> filterData;
    }

    public enum Option{;
        private interface Name {
            @JsonGetter("value")
            @NotEmpty
            String getName();
        }
        private interface Sort {
            @JsonGetter("key")
            @NotNull
            Object getSort();
        }
        private interface Id {@NotNull Long getId();}
        private interface Code {@NotEmpty String getCode();}
        private interface Disassemble {@NotNull String getDisassemble();}
        private interface Note {@JsonGetter("text") Object getNote();}

        @NoArgsConstructor
        @Getter
        @Setter
        @ToString
        @EqualsAndHashCode
        public static class KoreanSearchable implements Name,Sort,Disassemble,Note {
            String name;
            Object sort;
            String disassemble;
            Object note;

//            public KoreanSearchable(String name, Object sort, Object not e){
//                this.name = name;
//                this.sort = sort;
//                this.not e = not e;
//                this.disassemble = HangulDivider.hangulDivide(name);
//            }

        }

        @NoArgsConstructor
        @AllArgsConstructor
        @Getter
        @Setter
        @ToString
        @EqualsAndHashCode
        public static class WithId implements Id,Name,Sort,Disassemble,Note{
            Long id;
            String name;
            Object sort;
            String disassemble;
            Object note;
        }

        @NoArgsConstructor
        @AllArgsConstructor
        @Getter
        @Setter
        @ToString
        @EqualsAndHashCode
        public static class WithCode implements Name,Sort,Code,Disassemble,Note{
            String name;
            Object sort;
            String code;
            String disassemble;
            Object note;
        }

        @NoArgsConstructor
        @AllArgsConstructor
        @Getter
        @Setter
        @ToString
        @EqualsAndHashCode
        public static class WithIdAndCode implements Id,Name,Sort,Code,Disassemble,Note{
            Long id;
            String name;
            Object sort;
            String code;
            String disassemble;
            Object note;
        }

        @NoArgsConstructor
        @AllArgsConstructor
        @Getter
        @Setter
        @ToString
        @EqualsAndHashCode
        public static class Filterable implements Name,Disassemble,Note{
            String name;
            String disassemble;
            Object note;
        }
    }
}
