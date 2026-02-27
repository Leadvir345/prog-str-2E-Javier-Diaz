package com.example.demo_java.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class FormsController {

    @FXML
    private TextField TxtNombre;
    @FXML
    private TextField TxtCorreo;
    @FXML
    private TextField TxtEdad;
    @FXML
    private TextField lblValidacion;

    public void onValidate(ActionEvent event) {
        String nombre = TxtNombre.getText() == null ? "" : TxtNombre.getText();
        String correo = TxtCorreo.getText() == null ? "" : TxtCorreo.getText();
        String edad = TxtEdad.getText() == null ? "" : TxtEdad.getText();

        List<String> errores = new ArrayList<>();
        if (nombre.trim().isEmpty() || nombre.length()<3) {
            errores.add("Nombre incorrecto");
        }
        if (correo.trim().isEmpty() || correo.contains("@") || correo.contains(".")) {
            errores.add("Correo incorrecto");
        }
        int edadValida=0;
        try {
            edadValida = Integer.parseInt(edad);
            if (edadValida<=0 || edadValida>=120) {
                errores.add("Edad incorrecto");
            }
        } catch (NumberFormatException e) {
            errores.add("El dato de edad no es numerico");
        }
        if (errores.isEmpty()) {
            lblValidacion.setText("Los datos son correctos");
            lblValidacion.setStyle("-fx-border-color: green;");
        } else {
            String erroresLabel="";
            for (String string : errores) {
                erroresLabel+=string;
            }
            lblValidacion.setText(erroresLabel);
            lblValidacion.setStyle("-fx-border-color: red;");
        }
    }
}
