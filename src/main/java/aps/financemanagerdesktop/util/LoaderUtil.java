package aps.financemanagerdesktop.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class LoaderUtil {
    private static FXMLLoader LOADER;
    private static String fxmlFile;

    static {
       LOADER = new FXMLLoader();
    }

    public static Parent load(final Class<?> mainClass, final String fxmlFileName){
        try{
            fxmlFile = String.format("/view/%s.fxml", fxmlFileName);
            return LOADER.load(mainClass.getResource(fxmlFile));
        }
        catch (IOException ex){
            return null;
        }
    }

    public static <T> T getController(final Class<T> controller){
        return LOADER.getController();
    }
}