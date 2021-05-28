package aps.financemanagerdesktop.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class MessageUtil {
    public static void showError(final String header, final String details){
        final Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Mensagem de Erro");
        show(alert, header, details);
    }

    public static void showInfo(final String header, final String details){
        final Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informativo");
        show(alert, header, details);
    }

    public static void showWarning(final String header, final String details){
        final Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Atenção");
        show(alert, header, details);
    }

    private static Optional<ButtonType> show(final Alert alert, final String header, final String details){
        alert.setHeaderText(header);
        alert.setContentText(details);
        return alert.showAndWait();
    }

    public static boolean showConfirm(final String header, final String details){
        final Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Atenção");
        final Optional<ButtonType> result = show(alert, header, details);
        return result.get() == ButtonType.OK ? true : false;
    }
}