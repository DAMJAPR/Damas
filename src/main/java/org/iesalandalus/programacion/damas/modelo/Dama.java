package org.iesalandalus.programacion.damas.modelo;

import javax.naming.OperationNotSupportedException;
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
    private Posicion crearPosicionInicial(){
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

    // Apartado 4.5.
    // Método mover
    private void mover (Direccion direccion, int pasos) throws OperationNotSupportedException{
        // Si la dirección es nula, lanzará una excepción
        if (direccion == null) {
            throw new NullPointerException("ERROR: La dirección no puede ser nula.");
        }
        // Si los pasos son menores que uno, lanzará una excepción
        if (pasos < 1) {
            throw new IllegalArgumentException("El número de pasos debe ser mayor o igual a 1.");
        }
        // Si la dama no es especial, solo puede moverse un paso
        if (!esDamaEspecial && pasos > 1) {
            throw new OperationNotSupportedException("ERROR: Las damas normales solo se pueden mover 1 casilla.");
        }
        // Validación de movimiento en función del color y la dirección permitida para una dama normal
        if (!esDamaEspecial) {
            if (color == Color.BLANCO && (direccion == Direccion.SUROESTE || direccion == Direccion.SURESTE)) {
                throw new OperationNotSupportedException("ERROR: Movimiento no permitido.");
            } else if (color == Color.NEGRO && (direccion == Direccion.NORESTE || direccion == Direccion.NOROESTE)) {
                throw new OperationNotSupportedException("ERROR: Movimiento no permitido.");
            }
        }
        // Cálculo de la nueva posición en función de la dirección
        int nuevaFila = posicion.getFila();
        char nuevaColumna = posicion.getColumna();
        // Según la dirección actualizamos la fila y la columna por la cantidad de pasos
        switch (direccion) {
            case NORESTE:
                nuevaFila += pasos;
                nuevaColumna += (char) pasos;
                break;
            case SURESTE:
                nuevaFila -= pasos;
                nuevaColumna += (char) pasos;
                break;
            case SUROESTE:
                nuevaFila -= pasos;
                nuevaColumna -= (char) pasos;
                break;
            case NOROESTE:
                nuevaFila += pasos;
                nuevaColumna -= (char) pasos;
                break;
        }
        // Comprobación de los límites del tablero
        if (nuevaFila < 1 || nuevaFila > 8 || nuevaColumna < 'a' || nuevaColumna > 'h') {
            throw new OperationNotSupportedException("ERROR: El movimiento sale fuera del tablero.");
        }
        // Si la dama llega a la última fila, se convierte en dama especial
        if ((color == Color.BLANCO && nuevaFila == 8) || (color == Color.NEGRO && nuevaFila == 1)) {
            setEsDamaEspecial(true);
        }
        // Establecemos la nueva posición si el movimiento es válido
        posicion.setFila(nuevaFila);
        posicion.setColumna(nuevaColumna);
    }

}
