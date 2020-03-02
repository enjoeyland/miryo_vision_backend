package com.example.miryo_vision_backend.utils;

import lombok.NonNull;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.*;

@Component
public class InsertExcelDataToDTOHandler {
    public static <T> List<T> insertSheetDataToDTO(@NonNull Sheet sheet, Class<T> Dto) throws Exception {
        List<T> insertedDTOList = new ArrayList<T>();

        for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (ExcelHandler.isDataRow(i) & ExcelHandler.isFirstColumnNotEmpty(row)) {
                insertedDTOList.add(insertRowDataToDTO(row, Dto));
            }
        }
        return insertedDTOList;
    }
    // type casting 방법 : https://stackoverflow.com/questions/450807/how-do-i-make-the-method-return-type-generic

    public static <T> T insertRowDataToDTO(Row row, Class<T> Dto) throws Exception {
        List<Field> fields = FieldReflection.getFieldListFromParentToChild(Dto);

        T dtoChildImp = Dto.newInstance();
        ListIterator<Field> it = fields.listIterator();
        while (it.hasNext()) {
            insertCellDataToDTO(row.getCell(it.nextIndex()), dtoChildImp, it.next());
        }
        return dtoChildImp;
    }

    public static <T> void insertCellDataToDTO(Cell cell, T dtoChildImp, Field f) throws Exception {
        String cellData = ExcelHandler.getCellData(cell);

        f.setAccessible(true);
        try {
            f.set(dtoChildImp, cellData);
        } catch (IllegalAccessException e) {
            throw new Exception("fields 밖으로 access하였습니다.\n" +
                    "\n fields는" + f.toString() +
                    "\n cellData는 " + cellData + "입니다.");
        }
    }
//
}
