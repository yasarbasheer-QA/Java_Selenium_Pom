package com.framework.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    private Workbook workbook;
    private  Sheet sheet;

    public ExcelUtils(String filepath,String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filepath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        fis.close();
    }

    public int getRowCount(){
        return sheet.getPhysicalNumberOfRows();
    }
    public int getColCount(){
        Row row = sheet.getRow(0);
        return row.getPhysicalNumberOfCells();
    }


    public String getCellData(int rowNum,int colNum){
        Row row = sheet.getRow(rowNum);
        if(row == null) return "";
        Cell cell = row.getCell(colNum);
        if(cell == null) return "";
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }

    public void closeFile() throws IOException {
        if(workbook != null){
            workbook.close();
        }
    }
}
