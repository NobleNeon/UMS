module com.example.ums {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires org.apache.poi.ooxml;

    opens com.example.ums to javafx.fxml;
    exports com.example.ums;
}