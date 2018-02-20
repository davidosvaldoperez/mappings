/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mappings.mappers;

import com.mycompany.mappings.mappers.dozer.DozerMapper;
import com.mycompany.mappings.mappers.mapstruct.MapStructMapper;
import com.mycompany.mappings.mappers.orika.OrikaMapper;
import com.mycompany.mappings.model.source.Persona;
import com.mycompany.mappings.model.target.Identifier;
import com.mycompany.mappings.model.target.Person;
import java.util.Arrays;
import java.util.Date;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author nefre
 */
@RunWith(Parameterized.class)
public class ExampleMapperTest {

    private final ExampleMapper mapper;

    public ExampleMapperTest(String nombre, ExampleMapper mapper) {
        this.mapper = mapper;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Iterable<Object[]> getMappers() {
        return Arrays.asList(
                new Object[][]{
                    {"Dozer",new DozerMapper()},
                    {"MapStruct",new MapStructMapper()},
                    {"Orika",new OrikaMapper()}   
                });
    }

    @Test
    public void testFromTarget() {

        Person person = new Person();
        person.setNombreCompleto("David Perez");
        person.setEdad(30);
        Identifier id = new Identifier();
        person.setIdentifier(id);
        id.setTipoDocUrl("http://documentos/dni");
        id.setDoc(33149453L);

        Persona persona = mapper.fromPerson(person);

        assertThat(persona.getNombre(), is("David"));
        assertThat(persona.getApellido(), is("Perez"));
        assertThat(persona.getTipoDoc(), is("DNI"));
        assertThat(persona.getNroDoc(), is(33149453));
    }

    @Test
    public void testFromSource() {
        Persona persona = new Persona();
        persona.setNombre("David");
        persona.setApellido("Perez");
        persona.setTipoDoc("DNI");
        persona.setNroDoc(33149453);
        persona.setFechaNac(new Date(87, 6, 13));

        Person person = mapper.fromPersona(persona);

        assertThat(person.getNombreCompleto(), is("David Perez"));
        assertThat(person.getEdad(), is(30));
        assertThat(person.getIdentifier().getTipoDocUrl(), is("http://documentos/dni"));
        assertThat(person.getIdentifier().getDoc(), is(33149453L));

    }

}
