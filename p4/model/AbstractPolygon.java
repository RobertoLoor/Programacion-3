/**
DNI/PASAPORTE: A8590323
APELLIDOS: Loor Tamayo
NOMBRE: Roberto Carlos
@author Roberto Loor
*/

package es.ua.dlsi.prog3.p4.model;

/**
 * Representa una forma de polígono abstracto en un espacio 2D.
 * Esta clase extiende la clase Shape2D.
 */
public abstract class AbstractPolygon extends Shape2D {
    private double angle;

    /**
     * Construye una nueva instancia de la clase AbstractPolygon con valores predeterminados.
     * La posición se establece en (Double.NaN, Double.NaN) y el ángulo se establece en 0.
     */
    public AbstractPolygon() {
        super();
        this.angle = 0;
    }

    /**
     * Construye una nueva instancia de la clase AbstractPolygon con la posición y el ángulo especificados.
     * @param position La posición del polígono.
     * @param angle El ángulo de rotación en grados.
     * @throws IllegalArgumentException si el ángulo no está dentro del rango [0, 360).
     */
    public AbstractPolygon(Coordinate position, double angle) {
        super(position);
        if (angle < 0.0 || angle >= 360.0) throw new IllegalArgumentException("Ángulo inválido.");
        this.angle = angle;
    }

    /**
     * Construye una nueva instancia de la clase AbstractPolygon que es una copia del polígono especificado.
     * @param other El polígono a copiar.
     */
    public AbstractPolygon(AbstractPolygon other) {
        super(other);
        this.angle = other.angle;
    }

    /**
     * Obtiene el ángulo de rotación del polígono.
     * @return El ángulo en grados.
     */
    public double getAngle() {
        return angle;
    }

    /**
     * Rota el polígono por el número de grados especificado.
     * @param degrees El número de grados a rotar.
     * @throws IllegalArgumentException if the rotation is not within the range [-360, 360).
     */
    public void rotate(double degrees) {
        if (degrees < -360.0 || degrees >= 360.0) throw new IllegalArgumentException("Rotation out of bounds.");
        angle = (angle + degrees);
        if (angle < 0) angle += 360.0;
        if (angle > 360) angle -= 360;
    }

    /**
     * SReturns a string representation of the polygon.
     * @return A string representation of the polygon.
     */
    @Override
    public String toString() {
        return super.toString() + ",angle=" + angle;
    }

    /**
     * Checks if the polygon is equal to the specified object.
     * Two polygons are considered equal if they have the same position and angle.
     * @param obj The object to compare.
     * @return {@code true} if the polygons are equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        AbstractPolygon that = (AbstractPolygon) obj;
        return Double.compare(that.angle, angle) == 0;
    }

    /**
     * Creates a copy of the polygon.
     * @return A new instance of the polygon with the same properties.
     */
    @Override
    public abstract AbstractPolygon clone();

    /**
     * Scales the polygon by the specified percentage.
     * @param percentage The percentage to scale by.
     */
    @Override
    public abstract void scale(double percentage);
}
