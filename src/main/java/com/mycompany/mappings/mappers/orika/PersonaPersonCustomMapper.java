package com.mycompany.mappings.mappers.orika;

import com.mycompany.mappings.model.source.Persona;
import com.mycompany.mappings.model.target.Person;
import com.mycompany.mappings.model.util.FechaEdadService;
import com.mycompany.mappings.model.util.NombreCompletoService;
import com.mycompany.mappings.model.util.UrlService;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

/**
 *
 * @author David <david.perez@hospitalitaliano.org.ar>
 */
public class PersonaPersonCustomMapper extends CustomMapper<Persona, Person> {

    private final UrlService urlService;
    private final NombreCompletoService nombreService;
    private final FechaEdadService fechaService;

    public PersonaPersonCustomMapper() {
        urlService = new UrlService();
        nombreService = new NombreCompletoService();
        fechaService = new FechaEdadService();
    }

    @Override
    public void mapAtoB(Persona persona, Person person, MappingContext context) {
        person.getIdentifier().setTipoDocUrl(urlService.getUrlByString(persona.getTipoDoc()));

        person.setNombreCompleto(nombreService.juntar(persona.getNombre(), persona.getApellido()));

        person.setEdad(fechaService.getEdad(persona.getFechaNac()));
    }

    @Override
    public void mapBtoA(Person person, Persona persona, MappingContext context) {
        persona.setTipoDoc(urlService.getStringByUrl(person.getIdentifier().getTipoDocUrl()));

        String[] nombres = nombreService.separar(person.getNombreCompleto());
        persona.setNombre(nombres[0]);
        persona.setApellido(nombres[1]);
    }

}
