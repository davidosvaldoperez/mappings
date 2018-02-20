package com.mycompany.mappings.model.util;

import java.util.Date;

/**
 *
 * @author David <david.perez@hospitalitaliano.org.ar>
 */
public class FechaEdadService {

    public Integer getEdad(Date birthDate) {
        int yearBorn = birthDate.getYear();
        int thisYear = new Date().getYear() - 1;
        return thisYear - yearBorn;
    }
}
