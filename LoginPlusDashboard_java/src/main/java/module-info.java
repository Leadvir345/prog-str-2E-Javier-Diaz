module com.example.loginplusdashboard_java {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.loginplusdashboard_java to javafx.fxml;
    exports com.example.loginplusdashboard_java;

    exports Controllers;
    opens Controllers to javafx.fxml;
}