package aps.financemanagerdesktop.controller;

import aps.financemanagerdesktop.LauncherApp;
import aps.financemanagerdesktop.controller.model.CategoryModel;
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

    private boolean isNew;

    @FXML
    public void initialize(){
        try{
            service = new CategoryService();

            final ObservableList<CategoryModel> observableList = FXCollections.observableArrayList();
            List<Category> list = service.listAll();
            list.forEach(c -> observableList.add(new CategoryModel(c)));
            dataTable.setItems(observableList);

            columnId.setCellValueFactory(c -> c.getValue().getPropId());
            columnDescription.setCellValueFactory(c -> c.getValue().getPropDescription());
        }
        catch (Exception ex){
            AlertUtil.showError(ex.getMessage(), ex.getCause().getMessage());
        }
    }

    public void setLauncherApp(final LauncherApp launcherApp){
        this.launcherApp = launcherApp;
    }

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
                AlertUtil.showWarning("Operação incompleta", "Nenhuma categoria selecionada");
            }
        }
    }

    private void handleDelete(){
        final int selectedIndex = dataTable.getSelectionModel().getSelectedIndex();

        if(selectedIndex >= 0){
            final boolean op = AlertUtil.showConfirm("Operação de Exclusão", "Deseja excluir a categoria selecionada?");

            if(op){
                dataTable.getItems().remove(selectedIndex);
            }
        }
        else{
            AlertUtil.showWarning("Operação incompleta", "Nenhuma categoria selecionada");
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
}