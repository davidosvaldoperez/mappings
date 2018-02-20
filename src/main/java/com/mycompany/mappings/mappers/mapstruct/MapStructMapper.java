/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mappings.mappers.mapstruct;

import com.mycompany.mappings.mappers.ExampleMapper;
import com.mycompany.mappings.model.source.Persona;
import com.mycompany.mappings.model.target.Person;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author nefre
 */
public class MapStructMapper implements ExampleMapper {

    private final PersonaPersonMapper mapper;

    public MapStructMapper() {
        mapper = Mappers.getMapper(PersonaPersonMapper.class);
    }

    @Override
    public Persona fromPerson(Person person) {
        return mapper.personToPersona(person);
    }

    @Override
    public Person fromPersona(Persona persona) {
        return mapper.personaToPerson(persona);
    }

}
