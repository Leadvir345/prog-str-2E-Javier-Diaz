package com.example.demopracticaexam3.controllers;

import com.example.demopracticaexam3.services.ContactoService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class ContactoController {

    @FXML private TextField        txtNombre;
    @FXML private TextField        txtTelefono;
    @FXML private ComboBox<String> cmbParentesco;
    @FXML private Label            lblMsg;
    @FXML private ListView<String> listView;

    private final ObservableList<String> data = FXCollections.observableArrayList();
    private final ContactoService service = new ContactoService();

    @FXML
    public void initialize() {
        cmbParentesco.getItems().addAll(ContactoService.PARENTESCOS);
        cmbParentesco.setPromptText("Seleccione parentesco");
        listView.setItems(data);
        listView.setOnMouseClicked(e -> onSelectFromList());
        recargarLista();
    }

    @FXML
    public void onReloaded() {
        recargarLista();
        mostrarMensaje("Lista actualizada.");
    }

    @FXML
    public void onAdd() {
        try {
            service.addContacto(
                txtNombre.getText().trim(),
                txtTelefono.getText().trim(),
                cmbParentesco.getValue()
            );
            mostrarMensaje("Contacto agregado correctamente.");
            limpiarCampos();
            recargarLista();
        } catch (IllegalArgumentException e) {
            mostrarMensaje("Error: " + e.getMessage());
        }
    }

    @FXML
    public void onSearch() {
        String[] datos = service.findContacto(txtNombre.getText().trim());
        if (datos == null) {
            mostrarMensaje("No se encontró el contacto.");
        } else {
            txtNombre.setText(datos[0]);
            txtTelefono.setText(datos[1]);
            cmbParentesco.setValue(datos[2]);
            mostrarMensaje("Contacto encontrado.");
        }
    }

    @FXML
    public void onUpdate() {
        try {
            service.updateContacto(
                txtNombre.getText().trim(),
                txtTelefono.getText().trim(),
                cmbParentesco.getValue()
            );
            mostrarMensaje("Contacto actualizado.");
            limpiarCampos();
            recargarLista();
        } catch (IllegalArgumentException e) {
            mostrarMensaje("Error: " + e.getMessage());
        }
    }

    @FXML
    public void onDelete() {
        String nombre = txtNombre.getText().trim();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "¿Deseas eliminar a " + nombre + "?", ButtonType.YES, ButtonType.NO);
        alert.setHeaderText(null);
        alert.showAndWait().ifPresent(resp -> {
            if (resp == ButtonType.YES) {
                try {
                    service.deleteContacto(nombre);
                    mostrarMensaje("Contacto eliminado.");
                    limpiarCampos();
                    recargarLista();
                } catch (IllegalArgumentException e) {
                    mostrarMensaje("Error: " + e.getMessage());
                }
            }
        });
    }

    @FXML
    public void onClear() {
        limpiarCampos();
        mostrarMensaje("");
    }

    private void recargarLista() {
        List<String> items = service.loadDataForListView();
        data.setAll(items);
    }

    private void onSelectFromList() {
        String sel = listView.getSelectionModel().getSelectedItem();
        if (sel == null) return;
        String[] partes = sel.split(" \\| ");
        if (partes.length == 3) {
            txtNombre.setText(partes[0].trim());
            txtTelefono.setText(partes[1].trim());
            cmbParentesco.setValue(partes[2].trim());
            mostrarMensaje("Contacto cargado desde la lista.");
        }
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtTelefono.clear();
        cmbParentesco.setValue(null);
        cmbParentesco.setPromptText("Seleccione parentesco");
        listView.getSelectionModel().clearSelection();
    }

    private void mostrarMensaje(String msg) {
        lblMsg.setText(msg);
    }
}
