package aps.financemanagerdesktop.controller;

import aps.financemanagerdesktop.LauncherApp;
import aps.financemanagerdesktop.domain.Category;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CategoryController {
	@FXML
    private TableView<Category> table;

    @FXML
    private TableColumn<Category, String> columnId;

    @FXML
    private TableColumn<Category, String> columnDescription;

    @FXML
    private Button btnFilter;
    
    @FXML
    private Button btnNew;
    
    @FXML
    private Button btnDelete;
    
    @FXML
    private Button btnEdit;

    private LauncherApp launcherApp;

    private boolean isNew;
}