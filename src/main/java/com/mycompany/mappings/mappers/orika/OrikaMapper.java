/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mappings.mappers.orika;

import com.mycompany.mappings.mappers.ExampleMapper;
import com.mycompany.mappings.model.source.Persona;
import com.mycompany.mappings.model.target.Person;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 *
 * @author nefre
 */
public class OrikaMapper implements ExampleMapper {

    private final MapperFacade mapper;

    public OrikaMapper() {
        MapperFactory factory = new DefaultMapperFactory.Builder().build();
        factory.classMap(Persona.class, Person.class)
                .field("nroDoc", "identifier.doc")
                .byDefault()
                .customize(new PersonaPersonCustomMapper())
                .register();
        //Se puede usar "getMapperFacade(PersonSource.class, PersonDest.class)" para obtener un mapper especifico
        mapper = factory.getMapperFacade();
    }

    @Override
    public Persona fromPerson(Person person) {
        return mapper.map(person, Persona.class);
    }

    @Override
    public Person fromPersona(Persona persona) {
        return mapper.map(persona, Person.class);
    }

}
