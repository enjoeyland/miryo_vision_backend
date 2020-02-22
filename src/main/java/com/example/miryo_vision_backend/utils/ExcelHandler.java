package com.example.miryo_vision_backend.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class ExcelHandler {
    /*
     *   Use Case
     *   Sheet sheet = parseExcel("project", ['이름','코드번호','날짜'])
     *   List<Object> result = insertData2DTO(sheet, new SeasonCode)
     */
    public static Sheet parseExcel(String excelFileName, List<String> koNameList) throws Exception {
        Sheet sheet = getSheet(excelFileName);
        checkIsColumnFormRight(excelFileName, koNameList, sheet);
        return sheet;
    }

    public static Sheet getSheet(String excelFileName) throws Exception {
        String filePath = getFilePath(excelFileName);
        Workbook wbs = WorkbookFactory.create(new FileInputStream(filePath));
        Sheet sheet = (Sheet) wbs.getSheetAt(0);
        return sheet;
    }

    // excel column 양식 확인하기
    public static void checkIsColumnFormRight(String excelFileName, List<String> koNameList, Sheet sheet) throws Exception {
        int columnNum = koNameList.size();

        Row row = sheet.getRow(0);
        List<String> rowData = getRowData(row);

        int lastCellNum = row.getLastCellNum();

        if (lastCellNum != columnNum || !rowData.equals(koNameList)) {
            throw new Exception(excelFileName +
                    "의 양식이 잘못되었습니다.\n" +
                    "엑셀양식은 " + rowData.toString() + "입니다.\n" +
                    "주어진 데이터는 " + koNameList.toString() + "입니다.");
        }
    }//    출처: https://cofs.tistory.com/256 [CofS]

    public static List<String> getRowData(Row row) {
        int lastCellNum = row.getLastCellNum();
        List<String> rowData = new ArrayList<String>();
        for (int i = 0; i < lastCellNum; i++) {
            rowData.add(getCellData(row.getCell(i)));
        }
        return rowData;
    }

    public static String getCellData(Cell cell) {

        String value = null;
        if (cell == null) value = "";
        else {
            switch (cell.getCellType()) { //cell 타입에 따른 데이타 저장
                case FORMULA:
                    value = cell.getCellFormula();
                    break;
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        //you should change this to your application date format
                        SimpleDateFormat objSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        value = "" + objSimpleDateFormat.format(cell.getDateCellValue());
                    } else {
                        value = "" + String.format("%.0f", cell.getNumericCellValue());
                    }
                    break;
                case STRING:
                    value = "" + cell.getStringCellValue();
                    break;
                case BLANK:
                    //value=""+cell.getBooleanCellValue();
                    value = "";
                    break;
                case ERROR:
                    value = "" + cell.getErrorCellValue();
                    break;
                default:
            }
        }
        assert value != null;
        return value.trim();
    }//    출처: https://cofs.tistory.com/256 [CofS]

    public static boolean isDataRow(int i) {
        return i != 0;
    }

    public static boolean isFirstColumnNotEmpty(Row row) {
        return StringUtils.isNotEmpty(getCellData(row.getCell(0)));
    }

    private static String getFilePath(String excelFileName) throws Exception {
        String filePath = new FileHandler().findFilePath(excelFileName, new String[]{"xlsx"});
        return filePath;
    }
}
