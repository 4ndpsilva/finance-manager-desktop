package aps.financemanagerdesktop.service;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import aps.financemanagerdesktop.enums.Operation;
import aps.financemanagerdesktop.enums.PaymentType;
import aps.financemanagerdesktop.dto.ImportDTO;
import aps.financemanagerdesktop.dto.ResponseDTO;
import aps.financemanagerdesktop.util.DateUtil;
import lombok.Setter;

@Setter
public class ImporterService {
	private String fileName;

	public ResponseDTO<ImportDTO> execute() throws Exception {
		final ResponseDTO<ImportDTO> responseDTO = new ResponseDTO<>();

		try (final FileInputStream fis = new FileInputStream(new File(fileName))) {

			final Workbook workbook = new HSSFWorkbook(fis);
			final HSSFSheet sheet = (HSSFSheet) workbook.getSheetAt(0);
			Iterator<Row> iterator = sheet.iterator();

			final List<ImportDTO> entries = new LinkedList<>();
			
			while (iterator.hasNext()) {
				final Row rowIterator = iterator.next();

				if (rowIterator.getRowNum() > 0) {
					if(!rowIterator.getCell(0).getStringCellValue().isEmpty()) {
						final Iterator<Cell> cellIterator = rowIterator.cellIterator();

						final ImportDTO dto = new ImportDTO();

						while (cellIterator.hasNext()) {
							final Cell cell = cellIterator.next();
							
							switch (cell.getColumnIndex()) {
							case 0:
								dto.setCategory(getStringCellValue(cell));
								break;
							case 1:
								dto.setAccount(getStringCellValue(cell));
								break;
							case 2:
								dto.setEntryDate(DateUtil.toLocalDate(cell.getDateCellValue()));
								break;
							case 3:
								dto.setOperation(Operation.valueOf(cell.getStringCellValue().toUpperCase()));
								break;
							case 4:
								dto.setValue(new BigDecimal(cell.getNumericCellValue()));
								break;
							case 5:
								dto.setPaymentType(PaymentType.valueOf(cell.getStringCellValue().toUpperCase().replace("-", "_")));
								break;
							}
						}
						
						entries.add(dto);
					}
				} 
			}

			responseDTO.setDataSet(entries);
		}

		return responseDTO;
	}

	private String getStringCellValue(final Cell cell) {
		if (cell.getCellType() == CellType.STRING) {
			return cell.getStringCellValue().toUpperCase();
		}
		if (cell.getCellType() == CellType.NUMERIC) {
			return String.valueOf(cell.getNumericCellValue());
		}

		return "";
	}

	public boolean existsFile() {
		return Files.exists(Paths.get(fileName));
	}
}