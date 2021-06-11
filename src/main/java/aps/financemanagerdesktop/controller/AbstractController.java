package aps.financemanagerdesktop.controller;

import aps.financemanagerdesktop.util.AlertUtil;

import java.util.ResourceBundle;

public abstract class AbstractController {
    protected ResourceBundle i18n;

    public void configBundle(final ResourceBundle resourceBundle){
        i18n = resourceBundle;
        AlertUtil.configBundle(i18n);
    }
}