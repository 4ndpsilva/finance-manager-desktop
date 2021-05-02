package aps.spreadsheetimporter.service;


import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import aps.spreadsheetimporter.domain.Operation;
import aps.spreadsheetimporter.dto.EntryDTO;
import aps.spreadsheetimporter.util.DateUtil;


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
        					break;
        				case 2:
        					dto.setEntryDate(DateUtil.parse(cell.getStringCellValue()));
        					break;
        				case 3:
        					dto.setOperation(Operation.valueOf(cell.getStringCellValue()));
        					break;
        				case 4:
        					dto.setValue(new BigDecimal(cell.getStringCellValue().replace("R$", "").replace(",", ".").trim()));
        					break;
        				}
        				
        				entries.add(dto);
        			}
        		}
        	}
        }  
    }
}