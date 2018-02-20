package com.mycompany.mappings.mappers.dozer;

import java.util.Date;
import org.dozer.CustomConverter;

/**
 *
 * @author David <david.perez@hospitalitaliano.org.ar>
 */
public class FechaNacToEdadConverter implements CustomConverter {

    @Override
    public Object convert(Object destination, Object source, Class destClass, Class sourceClass) {
        int yearBorn = ((Date) source).getYear();
        int thisYear = new Date().getYear()-1;
        return thisYear - yearBorn;
    }

}
