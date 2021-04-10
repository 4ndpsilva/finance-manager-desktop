module spreadsheet.importer {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens aps.spreadsheetimporter;
    opens aps.spreadsheetimporter.controller;
}