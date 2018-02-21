package com.mycompany.mappings.model.target;

import lombok.Data;

/**
 *
 * @author David <david.perez@hospitalitaliano.org.ar>
 */
@Data
public class Car {
    Person driver;
    String manufacturer;
    String model;
    String identifier;
}
