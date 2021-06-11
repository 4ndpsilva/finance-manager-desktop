package aps.financemanagerdesktop.controller;

import aps.financemanagerdesktop.controller.navigation.Navigator;
import aps.financemanagerdesktop.util.AlertUtil;
import aps.financemanagerdesktop.util.DialogUtil;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lombok.Setter;

public class MainController extends AbstractController{
    @Setter
    private Stage stageOwner;

    @FXML
    private void initialize(){
        super.configBundle(i18n);
    }

    @FXML
    private void loadCategory(){
        try{
            final BorderPane pane = (BorderPane) Navigator.loadView(getClass(), "category");
            final CategoryController controller = Navigator.getController();
            DialogUtil.showModal(pane, stageOwner, i18n.getString("TIT-007"));
        }
        catch (Exception ex){
            AlertUtil.showError(i18n.getString("TIT-004"), ex.getMessage());
        }
    }

    @FXML
    private void loadImporter(){
        try{
            final AnchorPane pane = (AnchorPane) Navigator.loadView(getClass(), "importer");
            DialogUtil.showModal(pane, stageOwner, i18n.getString("TIT-009"));
        }
        catch (Exception ex){
            AlertUtil.showError(i18n.getString("TIT-004"), ex.getMessage());
        }
    }
}