package com.example.java;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class Reader {
    XSSFWorkbook workbook;


    public Reader(File file) throws IOException, InvalidFormatException {
        this.workbook = new XSSFWorkbook(file);
    }

    public String[] readData(int num) {
        XSSFSheet sheet = workbook.getSheetAt(num);
        String[]  arr   = new String[sheet.getLastRowNum() + 1];
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            if (sheet.getRow(i).getCell(0) != null) {
                arr[i] = sheet.getRow(i).getCell(0).getStringCellValue();
            }
        }
        return arr;
    }

    public void close() throws IOException {
        workbook.close();
    }

}
