package aps.spreadsheetimporter.controller;

import aps.spreadsheetimporter.dto.EntryDTO;
import aps.spreadsheetimporter.dto.ResponseDTO;
import aps.spreadsheetimporter.service.ImporterService;
import aps.spreadsheetimporter.util.MessageUtil;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ImportController {
    @FXML
    private TextField txtFile;

    private ImporterService importerService;

    @FXML
    private void initialize(){
        importerService = new ImporterService();
    }

    @FXML
    private void handleOpenFile(){
    }
    
    @FXML
    private void handleImport(){
    	txtFile.setText("C:\\Despesas.xls");
    	importerService.setFileName(txtFile.getText().trim());
    	
        try {
        	if(!txtFile.getText().isEmpty()) {
        		if(importerService.existsFile()) {        			
        			final ResponseDTO<EntryDTO> dto = importerService.execute();
        		}
        		else {
        			MessageUtil.showWarning("Erro na Importação", "O arquivo informado não existe");
        		}
        	}
        	else {
        		MessageUtil.showWarning("Erro na Importação", "O arquivo deve ser informado");
        	}
		} 
        catch (Exception e) {
        	MessageUtil.showError("Erro na importação", e.getMessage());
		}
    }
}