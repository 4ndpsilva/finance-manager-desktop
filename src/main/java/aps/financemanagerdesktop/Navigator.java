package aps.financemanagerdesktop;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public final class Navigator {
    private static FXMLLoader staticLoader;

    public static <T extends Pane> Pane loadView(final Class<?> clazz, final String fxmlFile) throws Exception{
        final FXMLLoader loader = new FXMLLoader();
        staticLoader = loader;
        loader.setLocation(clazz.getResource(String.format("/view/%s.fxml", fxmlFile)));
        return loader.load();
    }

    public static <T> T getController(){
        return staticLoader.getController();
    }
}