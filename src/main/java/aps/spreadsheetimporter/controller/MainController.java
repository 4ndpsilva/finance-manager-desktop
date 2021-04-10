package aps.spreadsheetimporter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label label;

    @FXML
    private void showText(ActionEvent event){
        label.setText("Executou!!!");
    }
}