/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mappings.model.source;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author nefre
 */
@Data
public class Persona {
    String tipoDoc;
    Integer nroDoc;
    String nombre;
    String apellido;
    Date fechaNac;
}
