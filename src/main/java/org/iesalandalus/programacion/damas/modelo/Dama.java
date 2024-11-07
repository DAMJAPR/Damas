package org.iesalandalus.programacion.damas.modelo;

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

}
