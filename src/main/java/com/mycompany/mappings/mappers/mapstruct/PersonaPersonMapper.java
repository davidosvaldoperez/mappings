package com.mycompany.mappings.mappers.mapstruct;

import com.mycompany.mappings.model.source.Persona;
import com.mycompany.mappings.model.target.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author David <david.perez@hospitalitaliano.org.ar>
 */
@Mapper()
public interface PersonaPersonMapper {
    
    @Mapping(source = "nroDoc", target = "identifier.doc")
    Person personaToPerson(Persona persona);
    
    Persona personToPersona(Person person);
}
