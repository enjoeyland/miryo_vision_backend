package com.example.miryo_vision_backend.utils;

import com.example.miryo_vision_backend.dto.tmp.ExcelDataDto;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

public class DataGetter {
    public static <T extends ExcelDataDto> List<T> getDtoListWithInExcelData(String excelFileName, T excelDataDto) throws Exception {
        Sheet sheet = ExcelHandler.parseExcel(excelFileName, excelDataDto.getKoNameList());
        return (List<T>) InsertExcelDataToDTOHandler.insertSheetDataToDTO(sheet, excelDataDto.getClass());
    }
}
