package org.iesalandalus.programacion.damas;

import org.iesalandalus.programacion.utilidades.Entrada;

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

    // Apartado 5.4.
    // Método para elegir la Opcion del Menú
    public static int elegirOpcionMenu(){
        int opcion = 0;
        do {
            try{
                System.out.println("Por favor, introduce el número de la opción que deseas ejecutar (del 1 al 4):");
                opcion = Entrada.entero();
                if (opcion < 1 || opcion > 4){
                    System.out.println("Número de opción incorrecto.");
                }
            } catch (Exception e){
                System.out.println("Error: Introduce un número entero válido.");
            }
        } while (opcion < 1 || opcion > 4);
        return opcion;
    }

}
