module com.javafx.demofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens com.javafx.demofx to javafx.fxml;
    exports com.javafx.demofx;
    exports com.javafx.demofx.Controllers;
    exports com.javafx.demofx.Controllers.Client;
    exports com.javafx.demofx.Controllers.Admin;
    exports com.javafx.demofx.Models;
    exports com.javafx.demofx.Views;
}