package aps.financemanagerdesktop.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;
import java.util.ResourceBundle;

public class AlertUtil {
    private static ResourceBundle bundle;

    public static void configBundle(final ResourceBundle resourceBundle){
        bundle = resourceBundle;
    }

    public static void showError(final String header, final String details){
        final Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(bundle.getString("TIT-004"));
        show(alert, header, details);
    }

    public static void showInfo(final String header, final String details){
        final Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(bundle.getString("TIT-005"));
        show(alert, header, details);
    }

    public static void showWarning(final String header, final String details){
        final Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(bundle.getString("TIT-006"));
        show(alert, header, details);
    }

    private static Optional<ButtonType> show(final Alert alert, final String header, final String details){
        alert.setHeaderText(header);
        alert.setContentText(details);
        return alert.showAndWait();
    }

    public static boolean showConfirm(final String header, final String details){
        final Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(bundle.getString("TIT-006"));
        final Optional<ButtonType> result = show(alert, header, details);
        return result.get() == ButtonType.OK ? true : false;
    }
}