package com.mycompany.mappings.mappers.dozer;

import com.mycompany.mappings.model.util.FechaEdadService;
import java.util.Date;
import org.dozer.CustomConverter;

/**
 *
 * @author David <david.perez@hospitalitaliano.org.ar>
 */
public class FechaNacToEdadConverter implements CustomConverter {

    @Override
    public Object convert(Object destination, Object source, Class destClass, Class sourceClass) {
        return new FechaEdadService().getEdad(((Date) source));
    }

}
