package com.mycompany.mappings.model.util;

/**
 *
 * @author David <david.perez@hospitalitaliano.org.ar>
 */
public class NombreCompletoService {

    public String juntar(String nombre, String apellido) {
        return nombre + " " + apellido;
    }
    
    public String[] separar(String nombreCompleto){
        return nombreCompleto.split(" ");
    }
}
