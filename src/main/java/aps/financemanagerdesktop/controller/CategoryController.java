package aps.financemanagerdesktop.controller;

import aps.financemanagerdesktop.LauncherApp;
import aps.financemanagerdesktop.model.CategoryModel;
import aps.financemanagerdesktop.entity.Category;
import aps.financemanagerdesktop.service.CategoryService;
import aps.financemanagerdesktop.util.AlertUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class CategoryController {
	@FXML
    private TableView<CategoryModel> dataTable;

    @FXML
    private TableColumn<CategoryModel, String> columnId;

    @FXML
    private TableColumn<CategoryModel, String> columnDescription;

    @FXML
    private TextField txtSearch;

    @FXML
    private Button btnFilter;
    
    @FXML
    private Button btnNew;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnDelete;

    private CategoryService service;

    private LauncherApp launcherApp;

    private ResourceBundle bundle;

    private boolean isNew;

    @FXML
    public void initialize(){
        Locale locale = new Locale("pt", "BR");
        bundle = ResourceBundle.getBundle("messages", locale);
        AlertUtil.configBundle(bundle);
        service = new CategoryService();
        loadTable();
    }

    public void setLauncherApp(final LauncherApp launcherApp){
        this.launcherApp = launcherApp;
    }

    @FXML
    private void handleForm(ActionEvent event){
        if(event.getSource() == btnNew){
            isNew = true;
            final CategoryModel model = new CategoryModel();
            showForm(model);
        }
        else {
            isNew = false;
            final CategoryModel model = dataTable.getSelectionModel().getSelectedItem();

            if(model != null){
                showForm(model);
            }
            else{
                AlertUtil.showWarning(bundle.getString("TIT-001"), bundle.getString("MSG-001"));
            }
        }
    }

    @FXML
    private void handleDelete(){
        final int selectedIndex = dataTable.getSelectionModel().getSelectedIndex();

        if(selectedIndex >= 0){
            final boolean op = AlertUtil.showConfirm(bundle.getString("TIT-002"), bundle.getString("MSG-002"));

            if(op){
                dataTable.getItems().remove(selectedIndex);
            }
        }
        else{
            AlertUtil.showWarning(bundle.getString("TIT-002"), bundle.getString("MSG-001"));
        }
    }

    private void showForm(final CategoryModel model){
        final boolean okClicked = launcherApp.showFormDialog(model);

        if(okClicked){
            if (isNew){

            }
            else{
                final int selectedIndex = dataTable.getSelectionModel().getSelectedIndex();
            }
        }
    }

    private void loadTable(){
        try{
            final ObservableList<CategoryModel> observableList = FXCollections.observableArrayList();
            List<Category> list = service.listAll();
            list.forEach(c -> observableList.add(new CategoryModel(c)));
            dataTable.setItems(observableList);

            columnId.setCellValueFactory(c -> c.getValue().getPropId());
            columnDescription.setCellValueFactory(c -> c.getValue().getPropDescription());
        }
        catch (Exception ex){
            AlertUtil.showError(bundle.getString("TIT-004"), ex.getMessage());
        }
    }
}