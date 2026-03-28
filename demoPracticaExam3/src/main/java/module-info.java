module com.example.demopracticaexam3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.demopracticaexam3              to javafx.fxml;
    opens com.example.demopracticaexam3.controllers  to javafx.fxml;
    opens com.example.demopracticaexam3.services     to javafx.fxml;
    opens com.example.demopracticaexam3.repositories to javafx.fxml;
    opens com.example.demopracticaexam3.model        to javafx.fxml;

    exports com.example.demopracticaexam3;
    exports com.example.demopracticaexam3.controllers;
    exports com.example.demopracticaexam3.services;
    exports com.example.demopracticaexam3.repositories;
    exports com.example.demopracticaexam3.model;
}
