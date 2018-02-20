/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mappings.mappers.dozer;

import com.mycompany.mappings.mappers.ExampleMapper;
import com.mycompany.mappings.model.source.Persona;
import com.mycompany.mappings.model.target.Person;
import com.mycompany.mappings.model.util.NombreCompletoService;
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
        
        //no encontre manera de meter esto en dozer (String -> String) sin pisar los mapeos xml
        NombreCompletoService service = new NombreCompletoService();
        String[] nombres = service.separar(person.getNombreCompleto());
        persona.setNombre(nombres[0]);
        persona.setApellido(nombres[1]);
        
        return persona;
    }

    @Override
    public Person fromPersona(Persona persona) {
        Person person = mapper.map(persona, Person.class);
        
        //no encontre manera de meter esto en dozer (String -> String) sin pisar los mapeos xml
        NombreCompletoService service = new NombreCompletoService();
        person.setNombreCompleto(service.juntar(persona.getNombre(), persona.getApellido()));
        
        return person;
    }
    
}
