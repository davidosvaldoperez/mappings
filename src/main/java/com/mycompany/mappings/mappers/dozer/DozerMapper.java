/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mappings.mappers.dozer;

import com.mycompany.mappings.mappers.ExampleMapper;
import com.mycompany.mappings.model.source.Persona;
import com.mycompany.mappings.model.target.Person;

/**
 *
 * @author nefre
 */
public class DozerMapper implements ExampleMapper{

    @Override
    public Persona fromPerson(Person person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person fromPersona(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
