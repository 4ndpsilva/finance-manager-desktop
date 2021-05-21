module spreadsheet.importer {
    requires static lombok;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
	requires org.apache.poi.poi;
	requires java.sql;

    opens aps.financemanagerdesktop;
    opens aps.financemanagerdesktop.controller;
}