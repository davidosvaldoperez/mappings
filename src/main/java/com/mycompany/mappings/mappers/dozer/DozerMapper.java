/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mappings.mappers.dozer;

import com.mycompany.mappings.mappers.ExampleMapper;
import com.mycompany.mappings.model.source.Persona;
import com.mycompany.mappings.model.target.Person;
import java.util.Arrays;
import org.dozer.DozerBeanMapper;

/**
 *
 * @author nefre
 */
public class DozerMapper implements ExampleMapper{
    
    private final DozerBeanMapper mapper;

    public DozerMapper() {
       mapper = new DozerBeanMapper();
       mapper.setMappingFiles(Arrays.asList("dozer.xml"));
    }
    
    @Override
    public Persona fromPerson(Person person) {
        Persona persona = mapper.map(person, Persona.class);
        persona.setNombre(person.getNombreCompleto().substring(0, person.getNombreCompleto().indexOf(" ")));
        persona.setApellido(person.getNombreCompleto().substring(person.getNombreCompleto().indexOf(" ")+1));
        return persona;
    }

    @Override
    public Person fromPersona(Persona persona) {
        Person person = mapper.map(persona, Person.class);
        person.setNombreCompleto(String.format("%s %s", persona.getNombre(), persona.getApellido()));
        return person;
    }
    
}
