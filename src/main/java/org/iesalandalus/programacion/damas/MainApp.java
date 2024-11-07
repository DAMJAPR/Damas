package org.iesalandalus.programacion.damas;

import org.iesalandalus.programacion.damas.modelo.Color;
import org.iesalandalus.programacion.damas.modelo.Dama;
import org.iesalandalus.programacion.damas.modelo.Direccion;

import javax.naming.OperationNotSupportedException;

/**
 *
 * @author japr
 */

// Apartado 6.
public class MainApp {

    // Apartado 6.1.
    // Atributo de clase dama
    private static Dama dama;

    // Apartado 6.2.
    // Método Ejecutar Opción
    private static void ejecutarOpcion(int opcion) {
        switch (opcion){
            case 1:
                crearDamaDefecto();
                break;
            case 2:
                crearDamaColor();
                break;
            case 3:
                mover();
                break;
            case 4:
                System.out.println(Consola.despedirse());
                break;
        }
    }

    // Apartado 6.3.
    // Método crearDamaDefecto
    private static void crearDamaDefecto(){
        System.out.println("...Creando Dama por defecto...");
        dama = new Dama();
        System.out.println("Dama creada por defecto.");
        mostrarDama();
    }

    // Apartado 6.4.
    // Método crearDamaColor
    private static void crearDamaColor(){
        Color color = Consola.elegirColor();
        System.out.println("...Creando Dama eligiendo color...");
        dama = new Dama(color);
        System.out.println("Dama creada con el color elegido.");
        mostrarDama();
    }

    // Apartado 6.5.
    // Método mover
    private static void mover() {

        if (dama == null) {
            System.out.println("Primero debes crear una dama antes de moverla.");
            return;
        }
        System.out.println("...Mostrando el menú de direcciones disponibles...");
        Consola.mostrarMenuDirecciones();

        Direccion direccion = Consola.elegirDireccion();
        int pasos = 1;

        // Si la dama es especial, pediremos el número de pasos
        if (dama.isEsDamaEspecial()) {
            pasos = Consola.elegirPasos();
        }

        try {
            dama.mover(direccion, pasos);
            System.out.println("Dama movida con éxito.");
        } catch (OperationNotSupportedException e) {
            System.out.println("Movimiento no permitido: " + e.getMessage());
        }

        mostrarDama();
    }

    // Apartado 6.6.
    // Método para mostrar la información de la dama
    private static void mostrarDama() {
        if (dama != null) {
            System.out.println("Información de la dama: " + dama);
        } else {
            System.out.println("No hay ninguna dama creada actualmente.");
        }
    }

    // Apartado 6.7.
    // Método principal
    public static void main(String[] args){
        int opcion;

        System.out.println("""
                
                ¡Bienvenido al programa de las Damas!

                Por favor, escoja una opción del siguiente menú ->""");
        System.out.println();

        do {
            Consola.mostrarMenu();

            opcion = Consola.elegirOpcionMenu();

            ejecutarOpcion(opcion);
        } while (opcion != 4);
    }
}
