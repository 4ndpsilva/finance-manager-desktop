package aps.financemanagerdesktop;

import aps.financemanagerdesktop.util.AlertUtil;
import aps.financemanagerdesktop.util.I18NUtil;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class LauncherApp extends Application {
    private ViewLoader viewLoader;
    private ResourceBundle resourceBundle;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        resourceBundle = I18NUtil.getResourceBundle(new Locale("en", "US"));
        initApp(stage);
    }

    private void initApp(final Stage stage) {
        try{
            viewLoader = new ViewLoader();
            viewLoader.setI18n(resourceBundle);
            viewLoader.loadMain();
        }
        catch (Exception ex){
            AlertUtil.showError(resourceBundle.getString("TIT-004"), ex.getMessage());
        }
    }
}