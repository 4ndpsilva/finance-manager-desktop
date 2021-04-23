package aps.spreadsheetimporter.service;


import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;


public class ImporterService {
    public void execute() throws Exception{
        final String fileName = "C:\\Despesas.xls";

        final FileInputStream fis = new FileInputStream(new File(fileName));
        
        final Workbook wb = new HSSFWorkbook(fis);
        
        System.out.println(wb.getNumberOfSheets());
    }
}