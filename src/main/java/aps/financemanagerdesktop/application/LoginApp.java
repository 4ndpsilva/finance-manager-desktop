package aps.financemanagerdesktop.application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginApp {
    private Stage stage;

    public LoginApp(final Stage stage){
        this.stage = stage;
    }

    public void show() throws Exception{
        final Parent root = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
        root.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, blue 0%, silver 100%);");
        final Scene scene = new Scene(root, 450, 250);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.show();
    }
}