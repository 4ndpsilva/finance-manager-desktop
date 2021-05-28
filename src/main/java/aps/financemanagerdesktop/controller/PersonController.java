package aps.financemanagerdesktop.controller;

import aps.financemanagerdesktop.LauncherApp;
import aps.financemanagerdesktop.domain.Person;
import aps.financemanagerdesktop.util.DateUtil;
import aps.financemanagerdesktop.util.MessageUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PersonController {
    @FXML
    private TableView<Person> table;

    @FXML
    private TableColumn<Person, String> columnName;

    @FXML
    private TableColumn<Person, String> columnLastName;

    @FXML
    private Label lblName;

    @FXML
    private Label lblLastName;

    @FXML
    private Label lblBirthday;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnEdit;

    private LauncherApp launcherApp;

    private boolean isNew;

    @FXML
    private void initialize(){
        columnName.setCellValueFactory(cell -> cell.getValue().getNameProperty());
        columnLastName.setCellValueFactory(cell -> cell.getValue().getLastNameProperty());

        showDetails(null);

        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showDetails(newValue));
    }

    private void showDetails(final Person person) {
        final boolean existsPerson = person != null;
        lblName.setText(existsPerson ? person.name() : "");
        lblLastName.setText(existsPerson ? person.lastName() : "");
        lblBirthday.setText(existsPerson ? DateUtil.format(person.birthday()) : "");
    }

    public void setLauncherApp(final LauncherApp launcherApp){
        this.launcherApp = launcherApp;
        this.table.setItems(launcherApp.getDataSet());
    }

    @FXML
    private void handleForm(ActionEvent event){
        if(event.getSource() == btnNew){
            isNew = true;
            final Person person = new Person();
            showForm(person);
        }
        else {
            isNew = false;
            final Person person = table.getSelectionModel().getSelectedItem();

            if(person != null){
                showForm(person);
            }
            else{
                MessageUtil.showWarning("Operação incompleta", "Nenhum contato selecionado");
            }
        }
    }

    @FXML
    private void handleDelete(){
        final int selectedIndex = table.getSelectionModel().getSelectedIndex();

        if(selectedIndex >= 0){
            final boolean op = MessageUtil.showConfirm("Operação de Exclusão", "Deseja excluir o contato selecionado?");

            if(op){
                table.getItems().remove(selectedIndex);
            }
        }
        else{
            MessageUtil.showWarning("Operação incompleta", "Nenhum contato selecionado");
        }
    }

    private void showForm(final Person person){
        final boolean okClicked = launcherApp.showFormDialog(person);

        if(okClicked){
            if (isNew){
                launcherApp.getDataSet().add(person);
            }
            else{
                final int selectedIndex = table.getSelectionModel().getSelectedIndex();
                launcherApp.getDataSet().set(selectedIndex, person);
            }
        }
    }
}