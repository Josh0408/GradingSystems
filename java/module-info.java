module com.josh.gradingsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires mysql.connector.j;

    opens com.josh.gradingsystem to javafx.fxml;
    exports com.josh.gradingsystem;
    exports com.josh.gradingsystem.student;
    opens com.josh.gradingsystem.student to javafx.base;
}