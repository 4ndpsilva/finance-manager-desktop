package aps.financemanagerdesktop.controller;

import aps.financemanagerdesktop.model.CategoryModel;
import aps.financemanagerdesktop.service.CategoryService;
import aps.financemanagerdesktop.util.AlertUtil;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lombok.Getter;
import lombok.Setter;

import java.util.ResourceBundle;

public class CategoryFormController extends AbstractController{
    @FXML
    private TextField txtDescription;

    @Setter
    private CategoryService service;

    private CategoryModel model;

    @Setter
    private ResourceBundle i18n;

    @Getter
    private boolean okClicked = false;

    @FXML
    private void initialize(){
        txtDescription.requestFocus();
        txtDescription.selectAll();
    }

    @FXML
    private void handleSave(){
        try{
            if(isValid()){
                model.description(txtDescription.getText());
                service.save(model.getEntity());
                okClicked = true;
            }
        }
        catch (Exception ex){
            AlertUtil.showError(i18n.getString("TIT-004"), ex.getMessage());
        }
    }

    @FXML
    private void handleCancel(){
    }

    @FXML
    private void handleClear(){
        txtDescription.clear();
        txtDescription.requestFocus();
    }

    private boolean isValid() {
        final StringBuilder sbErrors = new StringBuilder();

        if(txtDescription.getText() == null || txtDescription.getText().isEmpty()){
            sbErrors.append(i18n.getString("LBL-002"));
        }

        if(sbErrors.length() > 0){
            AlertUtil.showWarning(i18n.getString("MSG-010"), sbErrors.toString());
            return false;
        }

        return true;
    }

    public void loadModel(final CategoryModel model){
        this.model = model;
        txtDescription.setText(this.model.description());
    }
}