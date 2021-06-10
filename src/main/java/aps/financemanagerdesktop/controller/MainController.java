package aps.financemanagerdesktop.controller;

import aps.financemanagerdesktop.util.AlertUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.Setter;

import java.util.ResourceBundle;

public class MainController {
    @FXML
    private MenuBar mnbMain;

    @Setter
    private ResourceBundle i18n;

    @Setter
    private Stage stageOwner;

    private Stage stage;

    private FXMLLoader loader;

    @FXML
    public void initialize(){
        loader = new FXMLLoader();
        stage = new Stage();
    }

    @FXML
    private void loadCategory(){
        try{
            loader.setLocation(getClass().getResource("/view/category.fxml"));
            final BorderPane pane = (BorderPane) loader.load();

            final CategoryController controller = loader.getController();
            controller.setStage(stage);
            controller.configBundle(i18n);

            final Scene scene = new Scene(pane);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(stageOwner);
            stage.show();
        }
        catch (Exception ex){
            AlertUtil.showError(i18n.getString("TIT-004"), ex.getMessage());
        }
    }

    @FXML
    private void loadImporter(){
        try{
            loader.setLocation(getClass().getResource("/view/importer.fxml"));
            final AnchorPane pane = (AnchorPane) loader.load();

            final ImportController controller = loader.getController();

            final Scene scene = new Scene(pane);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(stageOwner);
            stage.show();
        }
        catch (Exception ex){
            AlertUtil.showError(i18n.getString("TIT-004"), ex.getMessage());
        }
    }
}