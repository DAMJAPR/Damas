package org.iesalandalus.programacion.damas.modelo;

/**
 *
 * @author japr
 */

// Apartado 2.1.
public enum Color {

    BLANCO("Blanco"),
    NEGRO("Negro");

    // Apartado 2.2.  Atributo privado para almacenar la representación en cadena del literal
    private final String cadenaAMostrar;

    // Apartado 2.3. Constructor privado que inicializa el atributo con la cadena pasada por parámetro
    Color (String cadenaAMostrar){
        this.cadenaAMostrar = cadenaAMostrar;
    }

    // Apartado 2.4. Método toString que devuelve la representación en forma de cadena del literal
    public String toString(){
        return cadenaAMostrar;
    }
}
