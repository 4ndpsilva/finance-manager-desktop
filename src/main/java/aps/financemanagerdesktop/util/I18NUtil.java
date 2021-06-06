package aps.financemanagerdesktop.util;

import java.util.Locale;
import java.util.ResourceBundle;

public final class I18NUtil {
    private static ResourceBundle resourceBundle;

    public static ResourceBundle getResourceBundle(final Locale locale){
        Locale.setDefault(locale);
        return getResourceBundle();
    }

    public static ResourceBundle getResourceBundle(){
        if(resourceBundle == null){
            resourceBundle = ResourceBundle.getBundle("messages", Locale.getDefault());
        }

        return resourceBundle;
    }
}