package com.mycompany.mappings.mappers.dozer;

import com.mycompany.mappings.model.UrlService;
import org.dozer.CustomConverter;

/**
 *
 * @author David <david.perez@hospitalitaliano.org.ar>
 */
public class UrlToStringConverter implements CustomConverter {

    @Override
    public Object convert(Object destination, Object source, Class destClass, Class sourceClass) {
        if (source == null) {
            return null;
        }

        UrlService servicio = new UrlService();
        return servicio.getStringByUrl((String) source);
    }

}
