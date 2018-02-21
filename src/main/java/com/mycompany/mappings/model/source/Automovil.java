package com.mycompany.mappings.model.source;

import lombok.Data;

/**
 *
 * @author David <david.perez@hospitalitaliano.org.ar>
 */
@Data
public class Automovil {
    String marca;
    String modelo;
    String patente;
    Persona chofer;
}
