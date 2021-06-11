package aps.financemanagerdesktop.util;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public final class DialogUtil {
    public static void showModal(final Pane pane, final Stage owner, final String title){
        final Scene scene = new Scene(pane);
        final Stage dialog = new Stage();
        dialog.setScene(scene);
        dialog.setTitle(title);
        dialog.setResizable(false);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.initOwner(owner);
        dialog.showAndWait();
    }

    public static void show(final Pane pane, final String title){
        final Scene scene = new Scene(pane);
        final Stage dialog = new Stage();
        dialog.setScene(scene);
        dialog.setTitle(title);
        dialog.show();
    }
}