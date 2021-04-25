package aps.spreadsheetimporter.service;


import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import aps.spreadsheetimporter.domain.Entry;
import aps.spreadsheetimporter.dto.EntryDTO;


public class ImporterService {
    public void execute() throws Exception{
        final String fileName = "C:\\Despesas.xls";

        try(final FileInputStream fis = new FileInputStream(new File(fileName))){
        	
        	final Workbook workbook = new HSSFWorkbook(fis);
        	final HSSFSheet sheet = (HSSFSheet) workbook.getSheetAt(0);
        	Iterator<Row> iterator = sheet.iterator();
        	
        	final List<EntryDTO> entries = new ArrayList<>();
        	
        	while(iterator.hasNext()) {
        		final Row rowIterator = iterator.next();
        		
        		if(rowIterator.getRowNum() > 1) {        		
        			final Iterator<Cell> cellIterator = rowIterator.cellIterator();
        			
        			final EntryDTO dto = new EntryDTO();
        			
        			while(cellIterator.hasNext()) {
        				final Cell cell = cellIterator.next();
        				
        				switch(cell.getColumnIndex()) {
        				case 0:
        					dto.setCategory(cell.getStringCellValue());
        					break;
        				case 1:
        					dto.setAccount(cell.getStringCellValue());
        				}
        			}
        		}
        	}
        }
        
        
    }
}