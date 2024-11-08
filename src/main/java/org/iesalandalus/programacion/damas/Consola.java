package org.iesalandalus.programacion.damas;

import org.iesalandalus.programacion.damas.modelo.Color;
import org.iesalandalus.programacion.damas.modelo.Direccion;
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

    // Apartado 5.5.
    // Método para elegir un color
    public static Color elegirColor(){
        String cadenaColor;
        Color color = null;
        boolean colorValido = false;

        do {
            System.out.println("Por favor, introduce un color válido (Blanco/Negro):");
            cadenaColor = Entrada.cadena();

            if (cadenaColor.equalsIgnoreCase("Blanco")){
                color = Color.BLANCO;
                colorValido = true;
            }else if (cadenaColor.equalsIgnoreCase("Negro")){
                color = Color.NEGRO;
                colorValido = true;
            } else System.out.println("Color no válido. Inténtelo de nuevo.");

        } while (!colorValido);
        return color;
    }

    // Apartado 5.6.
    // Método para mostrar el menú de direcciones
    public static void mostrarMenuDirecciones(){
        System.out.println("""
                -----------------------------------
                ||      MENÚ DE DIRECCIONES      ||
                -----------------------------------
                    1.- Noreste.
                    2.- Sureste.
                    3.- Suroeste.
                    4.- Noroeste.
                -----------------------------------   \s
                ||                               ||
                -----------------------------------
                """);
    }

    // Apartado 5.7.
    // Método para elegir una dirección del método anterior
    public static Direccion elegirDireccion(){
        int opcion = 0;
        do {
            try{
                System.out.println("Por favor, escoge una dirección del menú anterior:");
                opcion = Entrada.entero();
            } catch (Exception e){
                System.out.println("Error: Introduce un número entero válido.");
            }

        } while (opcion <1 || opcion>4 );

        return switch (opcion) {
            case 1 -> Direccion.NORESTE;
            case 2 -> Direccion.SURESTE;
            case 3 -> Direccion.SUROESTE;
            case 4 -> Direccion.NOROESTE;
            default -> null;
        };
    }

    // Apartado 5.8.
    // Método para elegir los pasos
    public static int elegirPasos(){
        int pasos = 0;
        do {
            try{
                System.out.println("Introduce el número de casillas que deseas mover la ficha " +
                        "(Nº entero mayor o igual a 1): ");
                pasos = Entrada.entero();
            } catch (Exception e){
                System.out.println("Error: Introduce un número entero válido.");
            }
        } while (pasos < 1);
        return pasos;
    }

    // Apartado 5.9.
    // Método para despedirse
    public static String despedirse(){
        return "Saliendo de la aplicación...\n...¡Gracias por usarla!\n!BYE BYE¡";
    }

}
