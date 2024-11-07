package org.iesalandalus.programacion.damas.modelo;

/**
 *
 * @author japr
 */

// Apartado 1.1
public enum Direccion {

    NORESTE("Noreste"),
    SURESTE("Sureste"),
    SUROESTE("Suroeste"),
    NOROESTE("Noroeste");

    // Apartado 1.2. Atributo privado que almacenará la cadena pasada por parámetro
    private final String cadenaAmostrar;

    // Apartado 1.3. Constructor con visibilidad privada que asigna la cadena al atributo
    Direccion (String cadenaAmostrar){
        this.cadenaAmostrar = cadenaAmostrar;
    }

}
