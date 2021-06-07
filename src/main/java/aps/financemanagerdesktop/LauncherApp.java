package aps.financemanagerdesktop;

import aps.financemanagerdesktop.controller.CategoryController;
import aps.financemanagerdesktop.util.AlertUtil;
import aps.financemanagerdesktop.util.I18NUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class LauncherApp extends Application {
    private Stage stage;
    private Pane pane;
    private ResourceBundle resourceBundle;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        resourceBundle = I18NUtil.getResourceBundle(new Locale("en", "US"));
        this.stage = stage;
        this.stage.setTitle(resourceBundle.getString("TIT-008"));

        initApp();
    }

    private void initApp() {
        try{
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/category.fxml"));
            this.pane = (BorderPane) loader.load();

            final CategoryController controller = loader.getController();
            controller.setStage(stage);
            controller.configBundle(resourceBundle);

            final Scene scene = new Scene(pane);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException ex){
            AlertUtil.showError(ex.getMessage(), ex.getCause().getMessage());
        }
    }
}