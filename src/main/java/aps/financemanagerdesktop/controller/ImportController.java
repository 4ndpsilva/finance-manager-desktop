package aps.financemanagerdesktop.controller;

import aps.financemanagerdesktop.dto.ImportDTO;
import aps.financemanagerdesktop.dto.ResponseDTO;
import aps.financemanagerdesktop.service.ImporterService;
import aps.financemanagerdesktop.util.AlertUtil;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lombok.Setter;

import java.util.ResourceBundle;

public class ImportController {
    @FXML
    private TextField txtFile;

	@Setter
	private ResourceBundle i18n;

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
        			final ResponseDTO<ImportDTO> dto = importerService.execute();
        		}
        		else {
        			AlertUtil.showWarning(i18n.getString("TIT-003"), i18n.getString("MSG-006"));
        		}
        	}
        	else {
        		AlertUtil.showWarning(i18n.getString("TIT-003"), i18n.getString("MSG-007"));
        	}
		} 
        catch (Exception ex) {
        	AlertUtil.showError(i18n.getString("TIT-004"), ex.getMessage());
		}
    }
}