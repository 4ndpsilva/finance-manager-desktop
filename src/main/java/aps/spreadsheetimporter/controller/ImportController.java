package aps.spreadsheetimporter.controller;

import aps.spreadsheetimporter.util.MessageUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ImportController {
    @FXML
    private TextField txtFile;

    @FXML
    private Button btnOpenFile;

    @FXML
    private Button btnImport;

    private void initialize(){
        System.out.println("INICIAR");
    }

    @FXML
    private void handleOpenFile(){
        MessageUtil.showInfo("Teste", "Testando botão "+btnOpenFile.getText());
    }

    @FXML
    private void handleImport(){
        MessageUtil.showInfo("Teste", "Testando botão "+btnImport.getText());
    }
}