package org.iesalandalus.programacion.damas;

import org.iesalandalus.programacion.damas.modelo.Dama;

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



}
