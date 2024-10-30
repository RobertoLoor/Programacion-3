/**
DNI/PASAPORTE: A8590323
APELLIDOS: Loor Tamayo
NOMBRE: Roberto Carlos
@author Roberto Loor
*/

package es.ua.dlsi.prog3.p4.model;

/**
 * Representa un círculo en un espacio bidimensional.
 */
public class Circle extends Shape2D {
    private double radius;

    /**
     * Construye un círculo con un radio de 0 y una coordenada central por defecto.
     */
    public Circle() {
        super();
        this.radius = 0;
    }

    /**
     * Construye un círculo con la coordenada central y el radio especificados.
     * 
     * @param center La coordenada central del círculo.
     * @param radius El radio del círculo.
     * @throws IllegalArgumentException si el radio es negativo.
     */
    public Circle(Coordinate center, double radius) {
        super(center);
        if (radius < 0) throw new IllegalArgumentException("El radio no puede ser negativo.");
        this.radius = radius;
    }

    /**
     * Construye un círculo que es una copia del círculo especificado.
     * 
     * @param other El círculo a ser copiado.
     */
    public Circle(Circle other) {
        super(other);
        this.radius = other.radius;
    }

    /**
     * Devuelve el radio del círculo.
     * 
     * @return El radio del círculo.
     */
    public double getRadius() { return radius; }

    /**
     * Escala el círculo por el porcentaje especificado.
     * 
     * @param percentage El porcentaje por el cual escalar el círculo.
     * @throws IllegalArgumentException si el porcentaje no es positivo.
     */
    @Override
    public void scale(double percentage) {
        if (percentage <= 0) throw new IllegalArgumentException("El porcentaje debe ser positivo.");
        radius *= (percentage / 100);
    }

    /**
     * Crea y devuelve una copia del círculo.
     * 
     * @return Un nuevo círculo que es una copia de este círculo.
     */
    @Override
    public Circle clone() {
        return new Circle(this);
    }

    /**
     * Devuelve una representación en cadena del círculo.
     * 
     * @return Una representación en cadena del círculo.
     */
    @Override
    public String toString() {
        return super.toString() + ",radius=" + radius;
    }

    /**
     * Verifica si el círculo es igual al objeto especificado.
     * 
     * @param obj El objeto a comparar con el círculo.
     * @return true si el círculo es igual al objeto, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Circle circle = (Circle) obj;
        return Double.compare(circle.radius, radius) == 0;
    }
}