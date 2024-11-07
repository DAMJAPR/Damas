package org.iesalandalus.programacion.damas.modelo;

import java.util.Objects;

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


    public Posicion (int fila, char columna){
        if (fila < 1 || fila > 8){
            throw new IllegalArgumentException("ERROR: Fila no válida.");
        } else if (columna < 'a' || columna > 'h') {
            throw new IllegalArgumentException("ERROR: Columna no válida.");
        }
        setFila(fila);
        setColumna(columna);
    }

    // Apartado 3.4.
    // Constructor copia
    public Posicion (Posicion otraPosicion){
        if (otraPosicion == null) throw new NullPointerException("ERROR: No es posible copiar una posición nula.");
        this.fila = otraPosicion.getFila();
        this.columna = otraPosicion.getColumna();
    }

    // Apartado 3.5
    // Método EQUAL
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicion posicion = (Posicion) o;
        return fila == posicion.fila && columna == posicion.columna;
    }

    // Método HASHCODE
    @Override
    public int hashCode() {
        return Objects.hash(fila, columna);
    }

    // Apartado 3.6
    // Método toString()
    @Override
    public String toString() {
        return "fila=" + fila + ", columna=" + columna;
    }
}
