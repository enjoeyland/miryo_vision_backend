package com.example.miryo_vision_backend.utils;

import com.example.miryo_vision_backend.dto.tmp.ExcelDataDto;
import lombok.NonNull;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@Component
public class InsertExcelData2DTOHandler {
    private static final Logger logger = Logger.getLogger(InsertExcelData2DTOHandler.class.getName());

    public static <T extends ExcelDataDto> List<T> insertSheetData2DTO(@NonNull Sheet sheet, Class<T> excelDataDto) throws Exception {
        List<T> insertedDTOList = new ArrayList<T>();

        for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (ExcelHandler.isDataRow(i) & ExcelHandler.isFirstColumnNotEmpty(row)) {
                T dtoChildImp = insertRowData2DTO(row, excelDataDto);
                insertedDTOList.add(dtoChildImp);
            }
        }
        return insertedDTOList;
    }
    // type casting 방법 : https://stackoverflow.com/questions/450807/how-do-i-make-the-method-return-type-generic

    public static <T extends ExcelDataDto> T insertRowData2DTO(Row row, Class<T> excelDataDto) throws Exception {
//        Class<? extends ExcelDataDto> dtoChildClass = getDtoChildClass(excelDataDto);
        T dtoChildImp = excelDataDto.newInstance();
        Field[] fields = excelDataDto.getFields();

        int columnNum = fields.length;
        if (columnNum == 0) {
            throw new Exception("fied 숫자 적음 : " + fields.length);
        }
        for (int i = 0; i < columnNum; i++) {
            insertCellData2DTO(row.getCell(i), dtoChildImp, i);
        }
        return dtoChildImp;
    }

    public static <T extends ExcelDataDto> void insertCellData2DTO(Cell cell, T dtoChildImp, int j) throws Exception {
        String cellData = ExcelHandler.getCellData(cell);

        List<Field> fields = new ArrayList<Field>();
        List<Class> classList = new ArrayList<Class>();

        for (Class cls = dtoChildImp.getClass();
             cls != null && cls != ExcelDataDto.class;
             cls = cls.getSuperclass()) {
            classList.add(cls);
        }
        Collections.reverse(classList);

        for (Class cls : classList) {
            fields.addAll(Arrays.asList(cls.getFields()));
        }

        // getDeclaredField private까지 다볼수 있다.
        // getField public만 보인다.
        try {
            fields.get(j).set(dtoChildImp, cellData);
//            logger.info(fields.get(j).toString());
        } catch (IllegalAccessException e) {
            throw new Exception("fields 밖으로 access하였습니다.\n" +
                    "j = " + j + "\n fields는" + fields.get(j).toString() +
                    "\n cellData는 " + cellData + "입니다.");
        }
    }

//    private static Class<? extends ExcelDataDto> getDtoChildClass(@NonNull ExcelDataDto excelDataDto) {
//        return excelDataDto.getClass();
//    }
}
