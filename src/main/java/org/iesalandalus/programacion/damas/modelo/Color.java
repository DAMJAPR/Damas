package org.iesalandalus.programacion.damas.modelo;

/**
 *
 * @author japr
 */

// Apartado 2.1.
public enum Color {

    BLANCO("Blanco"),
    NEGRO("Negro");

    // Apartado 2.2.
    private final String cadenaAMostrar;

    // Apartado 2.3.
    Color (String cadenaAMostrar){
        this.cadenaAMostrar = cadenaAMostrar;
    }




}
