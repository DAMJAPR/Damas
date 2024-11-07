package org.iesalandalus.programacion.damas.modelo;

import java.util.Random;

/**
 *
 * @author japr
 */

// Apartado 4.1.
public class Dama {

    // Atributos con visibilidad privada que almacenarán un color,
    // una posición y si es o no una Dama Especial.
    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;

    // Apartado 4.2.
    // Método GET y SET para los atributos.

    // Método GETTER para el color
    public Color getColor(){
        return color;
    }
    // Método SETTER para el color
    public void setColor(Color color){
        if (color == null) {
            throw new IllegalArgumentException("ERROR: El color no puede ser nulo.");
        }
        this.color = color;
    }

    // Método GETTER para la posición
    public Posicion getPosicion(){
        return posicion;
    }
    // Método SETTER para la posición
    public void setPosicion(Posicion posicion){
        if (posicion == null){
            throw new IllegalArgumentException("ERROR: La posición no puede ser nula.");
        }
        this.posicion = posicion;
    }

    // Método GETTER para la Dama Especial
    public boolean isEsDamaEspecial(){
        return esDamaEspecial;
    }
    // Método SETTER para la Dama Especial
    public void setEsDamaEspecial(boolean esDamaEspecial) {
        this.esDamaEspecial = esDamaEspecial;
    }

    // Apartado 4.3.
    // Constructor por defecto
    public Dama(){
        this.color = Color.BLANCO;
        this.posicion = crearPosicionInicial();
        this.esDamaEspecial = false;
    }

    // Apartado 4.4.
    // Constructor que acepta como parámetro un Color
    public Dama (Color color){
        if (color == null){
            throw new NullPointerException("ERROR: El color no puede ser nulo.");
        }
        this.color = Color.BLANCO;
        this.posicion = crearPosicionInicial();
        this.esDamaEspecial = false;
    }

    // Apartado 4.4.1.
    // Método para crear una posición aleatoria inicial
    public Posicion crearPosicionInicial(){
        Random random = new Random();
        int filaInicial;
        char columnaInicial = ' ';

        // Creamos dos arrays para almacenar las columnas correctas según la fila incial en la que se ubique la ficha
        char [] columnaEnFilaImpar = {'a', 'c', 'e', 'g'};
        char [] columnaEnFilaPar = {'b', 'd', 'f', 'h'};

        // Si el color es Blanco, la fila inicial estará entre las tres primeras del tablero
        if (color == Color.BLANCO){
            filaInicial = random.nextInt(3)+1; // Filas 1,2 o 3
        } // Si el color es Negro, la fila inicial estará entre las tres últimas del tablero
        else filaInicial = random.nextInt(3)+6; // Filas 6,7 o 8

        // Según la fila inicial asignada, se establecerá la columna inicial
        columnaInicial = switch (filaInicial) {
            case 1, 3, 7 -> columnaEnFilaImpar[random.nextInt(columnaEnFilaImpar.length)];
            case 2, 6, 8 -> columnaEnFilaPar[random.nextInt(columnaEnFilaPar.length)];
            default -> columnaInicial;
        };
        return new Posicion(filaInicial, columnaInicial);
    }
}
