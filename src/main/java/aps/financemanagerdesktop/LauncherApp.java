package aps.financemanagerdesktop;

import aps.financemanagerdesktop.controller.MainController;
import aps.financemanagerdesktop.controller.navigation.Navigator;
import aps.financemanagerdesktop.util.AlertUtil;
import aps.financemanagerdesktop.util.DialogUtil;
import aps.financemanagerdesktop.util.I18NUtil;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
        resourceBundle = I18NUtil.getResourceBundle(new Locale("pt", "BR"));
        this.stage = stage;
        initApp();
    }

    private void initApp() {
        try{
            pane = Navigator.loadView(getClass(),"main");
            final MainController controller = Navigator.getController();
            controller.setStageOwner(stage);
            controller.configBundle(resourceBundle);
            DialogUtil.show(pane, resourceBundle.getString("TIT-008"));
        }
        catch (Exception ex){
            AlertUtil.showError(resourceBundle.getString("TIT-004"), ex.getMessage());
        }
    }
}