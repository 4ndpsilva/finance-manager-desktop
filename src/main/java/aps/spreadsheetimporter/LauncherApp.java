package aps.spreadsheetimporter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class LauncherApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        URL viewPath = getClass().getResource("/view/main.fxml");
        Parent root = FXMLLoader.load(viewPath);
        Scene scene = new Scene(root, 800, 600);

        stage.setTitle("Spreadsheet Importer");
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}