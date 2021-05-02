package aps.spreadsheetimporter;

import java.io.IOException;
import java.time.LocalDate;

import aps.spreadsheetimporter.controller.PersonEditController;
import aps.spreadsheetimporter.domain.Person;
import aps.spreadsheetimporter.util.MessageUtil;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.Getter;

public class LauncherApp extends Application {
    private Stage stage;
    private AnchorPane principal;

    @Getter
    private ObservableList<Person> dataSet;

    public LauncherApp(){
        dataSet = FXCollections.observableArrayList();
        dataSet.add(new Person("Kelvin", "Albuquerque", LocalDate.of(1985, 5, 12)));
        dataSet.add(new Person("Aline", "Fernandes", LocalDate.of(1990, 5, 10)));
        dataSet.add(new Person("Júlia", "Oliveira", LocalDate.of(1986, 12, 12)));
        dataSet.add(new Person("José", "Costa", LocalDate.of(1980, 10, 2)));
        dataSet.add(new Person("Matilda", "Menezes", LocalDate.of(1970, 3, 7)));
        dataSet.add(new Person("Carlos", "Silva", LocalDate.of(1989, 6, 20)));
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        this.stage.setTitle("AgendaApp");

        initMainStage();
    }

    private void initMainStage() {
        try{
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/importer_form.fxml"));
            this.principal = (AnchorPane) loader.load();
            final Scene scene = new Scene(principal);

//            final PersonController controller = loader.getController();
  //          controller.setLauncherApp(this);

            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex){
            MessageUtil.showError(ex.getMessage(), ex.getCause().getMessage());
        }
    }

    public boolean showFormDialog(Person person){
        try{
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/contact_edit.fxml"));
            final AnchorPane pane = (AnchorPane) loader.load();
            final Scene scene = new Scene(pane);

            final Stage dialogStage = new Stage();
            final PersonEditController controller = loader.getController();
            controller.setPerson(person);
            controller.setDialogStage(dialogStage);

            dialogStage.setTitle("Cadastro de Contatos");
            dialogStage.setMaximized(false);
            dialogStage.setResizable(false);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();

            return controller.isOkClicked();
        }
        catch (IOException ex){
            MessageUtil.showError(ex.getMessage(), ex.getCause().getMessage());
            return false;
        }
    }
}