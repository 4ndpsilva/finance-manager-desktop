package aps.financemanagerdesktop.controller;

import aps.financemanagerdesktop.controller.navigation.Navigator;
import aps.financemanagerdesktop.entity.Category;
import aps.financemanagerdesktop.model.CategoryModel;
import aps.financemanagerdesktop.service.CategoryService;
import aps.financemanagerdesktop.util.AlertUtil;
import aps.financemanagerdesktop.util.DialogUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.List;

public class CategoryController extends AbstractController {
	@FXML
    private TableView<CategoryModel> dataTable;

    @FXML
    private TableColumn<CategoryModel, String> columnId;

    @FXML
    private TableColumn<CategoryModel, String> columnDescription;

    @FXML
    private Button btnNew;

    private Stage stage;

    private CategoryService service;

    @FXML
    public void initialize(){
        stage = new Stage();
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
            final AnchorPane pane = (AnchorPane) Navigator.loadView(getClass(), "category_form");
            final CategoryFormController controller = Navigator.getController();
            controller.loadForm(model);
            controller.setService(service);

            DialogUtil.showModal(pane, stage, i18n.getString("TIT-007"));
            return controller.isOkClicked();
        }
        catch (Exception ex){
            AlertUtil.showError(i18n.getString("TIT-006"), ex.getMessage());
            return false;
        }
    }
}