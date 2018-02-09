/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mappings.mappers;

import com.mycompany.mappings.model.source.Persona;
import com.mycompany.mappings.model.target.Person;

/**
 *
 * @author nefre
 */
public interface ExampleMapper {
    public Persona fromPerson(Person person);
    public Person fromPersona(Persona persona);
}
