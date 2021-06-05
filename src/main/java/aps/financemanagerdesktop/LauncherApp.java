package aps.financemanagerdesktop;

import aps.financemanagerdesktop.controller.CategoryController;
import aps.financemanagerdesktop.controller.PersonEditController;
import aps.financemanagerdesktop.model.CategoryModel;
import aps.financemanagerdesktop.util.AlertUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class LauncherApp extends Application {
    private Stage stage;
    private Pane principal;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        this.stage.setTitle("Finance Manager");

        initMainStage();
    }

    private void initMainStage() {
        try{
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/category.fxml"));
            this.principal = (BorderPane) loader.load();
            final Scene scene = new Scene(principal);

            final CategoryController controller = loader.getController();
            controller.setLauncherApp(this);

            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex){
            AlertUtil.showError(ex.getMessage(), ex.getCause().getMessage());
        }
    }

    public boolean showFormDialog(final CategoryModel model){
        try{
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/category_edit.fxml"));
            final AnchorPane pane = (AnchorPane) loader.load();
            final Scene scene = new Scene(pane);

            final Stage dialogStage = new Stage();
            final PersonEditController controller = loader.getController();
            //controller.setPerson(entity);
            controller.setDialogStage(dialogStage);

            dialogStage.setTitle("Cadastro de Categorias");
            dialogStage.setMaximized(false);
            dialogStage.setResizable(false);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();

            return controller.isOkClicked();
        }
        catch (IOException ex){
            AlertUtil.showError(ex.getMessage(), ex.getCause().getMessage());
            return false;
        }
    }
}