package com.example.demopracticaexam3.repositories;

import com.example.demopracticaexam3.model.Contacto;

import java.util.ArrayList;
import java.util.List;

public class ContactoRepository {

    private final List<Contacto> contactos = new ArrayList<>();

    public List<Contacto> findAll() {
        return new ArrayList<>(contactos);
    }

    public Contacto findByNombre(String nombre) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) return c;
        }
        return null;
    }

    public void save(Contacto contacto) {
        contactos.add(contacto);
    }

    public boolean delete(Contacto contacto) {
        return contactos.remove(contacto);
    }
}
