module com.mso.ph.programhelper {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    //requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires com.google.gson;
    requires annotations;

    opens com.mso.ph.programhelper to javafx.fxml;
    opens com.mso.ph.programhelper.settings.model to com.google.gson;
    exports com.mso.ph.programhelper;
}