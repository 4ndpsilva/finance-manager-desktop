package aps.financemanagerdesktop.controller;

import aps.financemanagerdesktop.dto.EntryDTO;
import aps.financemanagerdesktop.dto.ResponseDTO;
import aps.financemanagerdesktop.service.ImporterService;
import aps.financemanagerdesktop.util.MessageUtil;
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