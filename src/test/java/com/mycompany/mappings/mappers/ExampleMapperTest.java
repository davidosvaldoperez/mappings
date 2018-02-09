/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mappings.mappers;

import com.mycompany.mappings.model.source.Persona;
import com.mycompany.mappings.model.target.Identifier;
import com.mycompany.mappings.model.target.Person;
import java.util.Date;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.Before;

/**
 *
 * @author nefre
 */
public abstract class ExampleMapperTest {
    
    private ExampleMapper mapper;
    
    protected abstract ExampleMapper getMapperImplementation();
    
    @Before
    public void setUp(){
        mapper = getMapperImplementation();
    }

    @Test
    public void testFromPerson() {
        
        Person person = new Person();
        person.setNombreCompleto("David Perez");
        person.setEdad(30);
        Identifier id = new Identifier();
        person.setIdentifier(id);
        id.setTipoDocUrl("http://documentos/dni");
        id.setDoc(33149453L);
        
        Persona persona = mapper.fromPerson(person);
        
        assertThat(persona.getNombre(),is("David"));
        assertThat(persona.getApellido(),is("Perez"));
        assertThat(persona.getTipoDoc(),is("DNI"));
        assertThat(persona.getNroDoc(),is(33149453));
        assertThat(persona.getFechaNac(),is(new Date(87,6,13)));
    }

    /**
     *
     */
    @Test
    public void testFromPersona() {
        Persona persona = new Persona();
        persona.setNombre("David");
        persona.setApellido("Perez");
        persona.setTipoDoc("DNI");
        persona.setNroDoc(33149453);
        persona.setFechaNac(new Date(87,6,13));
        
        Person person = mapper.fromPersona(persona);
        
         assertThat(person.getNombreCompleto(),is("David Perez"));
         assertThat(person.getEdad(),is(30));
         assertThat(person.getIdentifier().getTipoDocUrl(),is("http://documentos/dni"));
         assertThat(person.getIdentifier().getDoc(),is(33149453L));

    }

    
}
