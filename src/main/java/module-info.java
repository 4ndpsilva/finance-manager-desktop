module spreadsheet.importer {
    requires static lombok;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
	requires org.apache.poi.poi;

    opens aps.spreadsheetimporter;
    opens aps.spreadsheetimporter.controller;
}