package aps.financemanagerdesktop.controller;

import aps.financemanagerdesktop.model.Person;
import aps.financemanagerdesktop.util.DateUtil;
import aps.financemanagerdesktop.util.MessageUtil;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

public class PersonEditController {
    @FXML
    private TextField txtName;

    @FXML
    private TextField txtLastName;

    @FXML
    private DatePicker txtBirthday;

    @Setter
    private Stage dialogStage;

    private Person person;

    @Getter
    private boolean okClicked = false;

    @FXML
    private void initialize(){
        txtName.requestFocus();
        txtName.selectAll();
    }

    @FXML
    private void handleSave(){
        if(isValid()){
            person.name(txtName.getText());
            person.lastName(txtLastName.getText());
            person.birthday(DateUtil.parse(txtBirthday.getEditor().getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel(){
        this.dialogStage.close();
    }

    private boolean isValid() {
        final StringBuilder sbErrors = new StringBuilder();

        if(txtName.getText() == null || txtName.getText().isEmpty()){
            sbErrors.append("Informe o Nome\n");
        }

        if(txtLastName.getText() == null || txtLastName.getText().isEmpty()){
            sbErrors.append("Informe o Sobrenome\n");
        }

        final String dataNascimento = txtBirthday.getEditor().getText();

        if(dataNascimento == null || dataNascimento.isEmpty()){
            sbErrors.append("Informe a Data de Nascimento\n");
        }
        else{
            if(!DateUtil.validDate(dataNascimento)){
                sbErrors.append("Data de Nascimento inválida\n");
            }
        }

        if(sbErrors.length() > 0){
            MessageUtil.showError("Por favor, corrija as informações a seguir", sbErrors.toString());
            return false;
        }

        return true;
    }

    public void setPerson(final Person person){
        this.person = person;
        loadPerson(person);
    }

    private void loadPerson(final Person person){
        final boolean isNotNull = person != null;
        txtName.setText(isNotNull ? person.name() : "");
        txtLastName.setText(isNotNull ? person.lastName() : "");
        txtBirthday.getEditor().setText(isNotNull ? DateUtil.format(person.birthday()) : "");
    }
}