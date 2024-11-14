/**
DNI/PASAPORTE: A8590323
APELLIDOS: Loor Tamayo
NOMBRE: Roberto Carlos
@author Roberto Loor
*/

package es.ua.dlsi.prog3.p4.model;

/**
* Representa una forma cuadrada.
*/
public class Square extends AbstractPolygon {
    private double side;

    /**
    * Construye un nuevo objeto Square con valores predeterminados.
    */
    public Square() {
        super();
        this.side = 0;
    }

    /**
    * Construye un nuevo objeto Square con la posición, ángulo y longitud del lado especificados.
    * @param position La posición del cuadrado.
    * @param angle El ángulo del cuadrado.
    * @param side La longitud del lado del cuadrado.
    * @throws IllegalArgumentException si la longitud del lado es negativa.
    */
    public Square(Coordinate position, double angle, double side) {
        super(position, angle);
        if (side < 0) throw new IllegalArgumentException("Side length cannot be negative.");
        this.side = side;
    }

    /**
    * Construye un nuevo objeto Square que es una copia del objeto Square especificado.
    * @param other El objeto Square a copiar.
    */
    public Square(Square other) {
        super(other);
        this.side = other.side;
    }
    /**
    * Obtiene la longitud del lado del cuadrado.
    * @return La longitud del lado del cuadrado.
    */
    public double getSide() { return side; }

    /**
    * Escala el cuadrado por el porcentaje especificado.
    * @param percentage El porcentaje por el cual escalar el cuadrado.
    * @throws IllegalArgumentException si el porcentaje no es positivo.
    */
    @Override
    public void scale(double percentage) {
        if (percentage <= 0) throw new IllegalArgumentException("Percentage must be positive.");
            side *= (percentage / 100);
    }

    /**
    * Crea y devuelve una copia de este objeto Square.
    * @return Un nuevo objeto Square que es una copia de este objeto Square.
    */
    @Override
    public Square clone() {
        return new Square(this);
    }

    /**
    * Devuelve una representación en cadena de este objeto Square.
    * @return Una representación en cadena de este objeto Square.
    */
    @Override
    public String toString() {
        return super.toString() + ",side=" + side;
    }

    /**
    * Verifica si este objeto Square es igual al objeto especificado.
    * @param obj El objeto a comparar.
    * @return true si los objetos son iguales, false en caso contrario.
    */
    @Override
    public boolean equals(Object obj) {
        if(obj  instanceof Square){
            Square square = (Square) obj;
            return Double.compare(square.side, side) == 0
            		&& this.getPosition().equals(square.getPosition())
            		&& this.getAngle() == square.getAngle();
        }
        return false;
    }
}