package com.example.demopracticaexam3.services;

import com.example.demopracticaexam3.model.Contacto;
import com.example.demopracticaexam3.repositories.ContactoRepository;

import java.util.ArrayList;
import java.util.List;

public class ContactoService {

    public static final String[] PARENTESCOS = {
        "Padre", "Madre", "Hermano", "Hermana",
        "Abuelo", "Abuela", "Tío", "Tía"
    };

    private final ContactoRepository repo = new ContactoRepository();

    public List<String> loadDataForListView() {
        List<Contacto> todos = repo.findAll();
        List<String> result  = new ArrayList<>();
        for (Contacto c : todos) {
            result.add(c.toString());
        }
        return result;
    }

    public void addContacto(String nombre, String telefono, String parentesco) {
        validar(nombre, telefono, parentesco);
        if (repo.findByNombre(nombre) != null)
            throw new IllegalArgumentException("Ya existe un contacto con ese nombre.");
        repo.save(new Contacto(nombre, telefono, parentesco));
    }

    public String[] findContacto(String nombre) {
        Contacto c = repo.findByNombre(nombre);
        if (c == null) return null;
        return new String[]{ c.getNombre(), c.getTelefono(), c.getParentesco() };
    }

    public void updateContacto(String nombre, String telefono, String parentesco) {
        validar(nombre, telefono, parentesco);
        Contacto c = repo.findByNombre(nombre);
        if (c == null) throw new IllegalArgumentException("No existe un contacto con ese nombre.");
        c.setTelefono(telefono);
        c.setParentesco(parentesco);
    }

    public void deleteContacto(String nombre) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        Contacto c = repo.findByNombre(nombre);
        if (c == null) throw new IllegalArgumentException("No existe un contacto con ese nombre.");
        repo.delete(c);
    }

    private void validar(String nombre, String telefono, String parentesco) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        if (telefono == null || telefono.isBlank())
            throw new IllegalArgumentException("El teléfono no puede estar vacío.");
        if (!telefono.matches("\\d{10}"))
            throw new IllegalArgumentException("El teléfono debe tener exactamente 10 dígitos.");
        if (parentesco == null || parentesco.isBlank())
            throw new IllegalArgumentException("Debes seleccionar un parentesco.");
    }
}
