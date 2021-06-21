package aps.financemanagerdesktop;

import aps.financemanagerdesktop.controller.CategoryController;
import aps.financemanagerdesktop.controller.ImportController;
import aps.financemanagerdesktop.controller.MainController;
import aps.financemanagerdesktop.util.DialogUtil;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.Setter;

import java.util.ResourceBundle;

public class ViewLoader {
    private static Stage rootStage;
    private static Stage stageOwner;
    private Stage dialog;

    @Setter
    private ResourceBundle i18n;

    public void loadMain() throws Exception{
        final Pane pane = Navigator.loadView(getClass(),"main");
        final MainController controller = Navigator.getController();
        controller.configBundle(i18n);
        DialogUtil.show(pane, i18n.getString("TIT-008"));
    }

    public void loadCategory() throws Exception{
        final BorderPane pane = (BorderPane) Navigator.loadView(getClass(), "category");
        final CategoryController controller = Navigator.getController();
        controller.configBundle(i18n);
        showModal(pane, i18n.getString("TIT-007"));
    }

    public void loadImporter() throws Exception{
        final AnchorPane pane = (AnchorPane) Navigator.loadView(getClass(), "importer");
        final ImportController controller = Navigator.getController();
        controller.configBundle(i18n);
        showModal(pane, i18n.getString("TIT-009"));
    }

    public void showModal(final Pane pane, final String title){
        final Scene scene = new Scene(pane);
        dialog = getStage();
        dialog.setScene(scene);
        dialog.setTitle(title);
        dialog.setResizable(false);
        dialog.initOwner(stageOwner);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.showAndWait();
    }

    private Stage getStage(){
        if(dialog == null && !dialog.isShowing()){
            dialog = new Stage();
        }

        return dialog;
    }
}