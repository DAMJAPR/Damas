package org.iesalandalus.programacion.damas.modelo;

/**
 *
 * @author japr
 */

// Apartado 3.1.
public class Posicion {

    // Atributos
    private int fila;
    private char columna;

    // Apartado 3.2.
    // Métodos GET y SET para los atributos.

    // Método GETTER para la FILA
    public int getFila(){
        return fila;
    }

    // Método SETTER para la FILA
    public void setFila(int fila){
        if (fila >= 1 && fila <= 8) this.fila=fila;
        else
            throw new IllegalArgumentException("ERROR: Fila no válida.");
    }

    // Método GETTER para la COLUMNA
    public char getColumna() {
        return columna;
    }

    // Método SETTER para la COLUMNA
    public void setColumna(char columna) {
        if (columna >= 'a' && columna <= 'h') this.columna=columna;
        else
            throw new IllegalArgumentException("ERROR: Columna no válida.");
    }


}
