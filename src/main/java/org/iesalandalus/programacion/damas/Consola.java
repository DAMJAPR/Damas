package org.iesalandalus.programacion.damas;

/**
 *
 * @author japr
 */

// Apartado 5.1.
public class Consola {

    // Apartado 5.2.
    // Constructor privado
    private Consola () {}

    // Apartado 5.3.
    // Método para mostrar el Menú
    public static void mostrarMenu(){
        System.out.println("""
                -----------------------------------
                ||       MENÚ DE OPCIONES        ||
                -----------------------------------
                    1.- Crear Dama por defecto.
                    2.- Crear Dama eligiendo color.
                    3.- Mover.
                    4.- Salir.
                -----------------------------------   \s
                ||                               ||
                -----------------------------------   \s
                """);
    }

}
