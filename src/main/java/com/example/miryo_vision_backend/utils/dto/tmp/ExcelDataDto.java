package com.example.miryo_vision_backend.utils.dto.tmp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class ExcelDataDto {
    @JsonIgnore
    protected List<String> koNameList;

    public ExcelDataDto() {
        this.koNameList = new ArrayList<String>();
    }

    public List<String> getKoNameList() {
        return koNameList;
    }

    public void setKoNameList(List<String> koNameList) {
        this.koNameList = koNameList;
    }
}
