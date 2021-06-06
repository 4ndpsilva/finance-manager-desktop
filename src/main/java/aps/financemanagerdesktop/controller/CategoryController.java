package aps.financemanagerdesktop.controller;

import aps.financemanagerdesktop.entity.Category;
import aps.financemanagerdesktop.model.CategoryModel;
import aps.financemanagerdesktop.service.CategoryService;
import aps.financemanagerdesktop.util.AlertUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.Setter;

import java.util.List;
import java.util.ResourceBundle;

public class CategoryController {
	@FXML
    private TableView<CategoryModel> dataTable;

    @FXML
    private TableColumn<CategoryModel, String> columnId;

    @FXML
    private TableColumn<CategoryModel, String> columnDescription;

    @FXML
    private Button btnNew;

    @Setter
    private Stage stage;

    private CategoryService service;

    private ResourceBundle i18n;

    public void configBundle(final ResourceBundle resourceBundle){
        i18n = resourceBundle;
        AlertUtil.configBundle(i18n);
    }

    @FXML
    public void initialize(){
        service = new CategoryService();
        loadTable();
    }

    @FXML
    private void handleForm(ActionEvent event){
        if(event.getSource() == btnNew){
            final CategoryModel model = new CategoryModel();
            showForm(model);
        }
        else {
            final CategoryModel model = dataTable.getSelectionModel().getSelectedItem();

            if(model != null){
                showForm(model);
            }
            else{
                AlertUtil.showWarning(i18n.getString("TIT-001"), i18n.getString("MSG-001"));
            }
        }
    }

    @FXML
    private void handleDelete(){
        try{
            final CategoryModel model = dataTable.getSelectionModel().getSelectedItem();

            if(model != null){
                final boolean op = AlertUtil.showConfirm(i18n.getString("TIT-002"), i18n.getString("MSG-002"));

                if(op){
                    service.delete(Long.parseLong(model.id()));
                    loadTable();
                }
            }
            else{
                AlertUtil.showWarning(i18n.getString("TIT-002"), i18n.getString("MSG-001"));
            }
        }
        catch (Exception ex){
            AlertUtil.showError(i18n.getString("TIT-004"), ex.getMessage());
        }
    }

    private void showForm(final CategoryModel model){
        final boolean okClicked = showFormDialog(model);

        if(okClicked){
            loadTable();
        }
    }

    private void loadTable(){
        try{
            final ObservableList<CategoryModel> observableList = FXCollections.observableArrayList();
            observableList.clear();
            List<Category> list = service.listAll();
            list.forEach(c -> observableList.add(new CategoryModel(c)));
            dataTable.setItems(observableList);

            columnId.setCellValueFactory(c -> c.getValue().getPropId());
            columnDescription.setCellValueFactory(c -> c.getValue().getPropDescription());
        }
        catch (Exception ex){
            AlertUtil.showError(i18n.getString("TIT-004"), ex.getMessage());
        }
    }

    private boolean showFormDialog(final CategoryModel model){
        try{
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/category_form.fxml"));
            final AnchorPane pane = (AnchorPane) loader.load();
            final Scene scene = new Scene(pane);

            final Stage dialogStage = new Stage();
            final CategoryFormController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.loadForm(model);
            controller.setService(service);
            controller.setI18n(i18n);

            dialogStage.setTitle(i18n.getString("TIT-007"));
            dialogStage.setMaximized(false);
            dialogStage.setResizable(false);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();

            return controller.isOkClicked();
        }
        catch (Exception ex){
            AlertUtil.showError(i18n.getString("TIT-006"), ex.getMessage());
            return false;
        }
    }
}