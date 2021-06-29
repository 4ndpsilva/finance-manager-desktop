package aps.financemanagerdesktop.controller;

import aps.financemanagerdesktop.ViewLoader;
import aps.financemanagerdesktop.util.AlertUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends AbstractController implements Initializable {
    private ViewLoader viewLoader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        viewLoader = new ViewLoader();
    }

    @FXML
    private void loadCategory(){
        try{
            viewLoader.loadCategory();
        }
        catch (Exception ex){
            AlertUtil.showError(i18n.getString("TIT-004"), ex.getMessage());
        }
    }

    @FXML
    private void loadImporter(){
        try{
            viewLoader.loadImporter();
        }
        catch (Exception ex){
            AlertUtil.showError(i18n.getString("TIT-004"), ex.getMessage());
        }
    }

    @FXML
    private void close(){
        System.exit(0);
    }
}