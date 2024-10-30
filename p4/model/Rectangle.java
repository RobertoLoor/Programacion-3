/**
DNI/PASAPORTE: A8590323
APELLIDOS: Loor Tamayo
NOMBRE: Roberto Carlos
@author Roberto Loor
*/

package es.ua.dlsi.prog3.p4.model;

/**
 * Representa una figura rectangular.
 */
public class Rectangle extends AbstractPolygon {
    private double length;
    private double width;

    /**
     * Construye un nuevo objeto Rectangle con valores por defecto.
     */
    public Rectangle() {
        super();
        this.length = 0;
        this.width = 0;
    }

    /**
     * Construye un nuevo objeto Rectangle con la posición, ángulo, longitud y ancho especificados.
     *
     * @param position la posición del rectángulo
     * @param angle el ángulo del rectángulo
     * @param length la longitud del rectángulo
     * @param width el ancho del rectángulo
     * @throws IllegalArgumentException si la longitud o el ancho son negativos
     */
    public Rectangle(Coordinate position, double angle, double length, double width) {
        super(position, angle);
        if (length < 0 || width < 0) throw new IllegalArgumentException("La longitud y el ancho no pueden ser negativos.");
        this.length = length;
        this.width = width;
    }

    /**
     * Construye un nuevo objeto Rectangle que es una copia del objeto Rectangle especificado.
     *
     * @param other el objeto Rectangle a copiar
     */
    public Rectangle(Rectangle other) {
        super(other);
        this.length = other.length;
        this.width = other.width;
    }

    /**
     * Obtiene la longitud del rectángulo.
     *
     * @return la longitud del rectángulo
     */
    public double getLength() { return length; }

    /**
     * Obtiene el ancho del rectángulo.
     *
     * @return el ancho del rectángulo
     */
    public double getWidth() { return width; }

    /**
     * Escala el rectángulo por el porcentaje especificado.
     *
     * @param percentage el porcentaje por el cual escalar el rectángulo
     * @throws IllegalArgumentException si el porcentaje no es positivo
     */
    @Override
    public void scale(double percentage) {
        if (percentage <= 0) throw new IllegalArgumentException("El porcentaje debe ser positivo.");
        length *= (percentage / 100);
        width *= (percentage / 100);
    }

    /**
     * Crea y devuelve una copia del rectángulo.
     *
     * @return una copia del rectángulo
     */
    @Override
    public Rectangle clone() {
        return new Rectangle(this);
    }

    /**
     * Devuelve una representación en cadena del rectángulo.
     *
     * @return una representación en cadena del rectángulo
     */
    @Override
    public String toString() {
        return super.toString() + ",length=" + length + ",width=" + width;
    }

    /**
     * Verifica si el rectángulo es igual al objeto especificado.
     *
     * @param obj el objeto a comparar con el rectángulo
     * @return true si el rectángulo es igual al objeto, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Rectangle rectangle = (Rectangle) obj;
        return Double.compare(rectangle.length, length) == 0 && Double.compare(rectangle.width, width) == 0;
    }
}