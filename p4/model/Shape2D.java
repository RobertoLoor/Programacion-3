/**
DNI/PASAPORTE: A8590323
APELLIDOS: Loor Tamayo
NOMBRE: Roberto Carlos
@author Roberto Loor
*/

package es.ua.dlsi.prog3.p4.model;

/**
 * Representa una figura 2D abstracta.
 */
public abstract class Shape2D {
    private Coordinate position;

    /**
     * Constructor por defecto. Inicializa la posición a (0, 0).
     */
    protected Shape2D() {
        this.position = new Coordinate();
    }

    /**
     * Constructor parametrizado. Inicializa la posición a la coordenada especificada.
     * @param pos La posición inicial de la figura.
     */
    protected Shape2D(Coordinate pos) {
        this.position = new Coordinate(pos);
    }

    /**
     * Constructor de copia. Crea una nueva figura con la misma posición que la figura especificada.
     * @param other La figura a ser copiada.
     */
    protected Shape2D(Shape2D other) {
        this.position = new Coordinate(other.position);
    }

    /**
     * Obtiene la posición de la figura.
     * @return La posición de la figura.
     */
    public Coordinate getPosition() {
        return position;
    }

    /**
     * Mueve la figura a la posición especificada.
     * @param newPosition La nueva posición de la figura.
     * @return La antigua posición de la figura.
     */
    public Coordinate move(Coordinate newPosition) {
        if (newPosition == null) return position;
        Coordinate oldPosition = position;
        position = newPosition;
        return oldPosition;
    }
    
    /**
     * Crea un clon de la figura y la mueve a la posición especificada.
     * @param co La nueva posición de la figura clonada.
     * @return La figura clonada con la nueva posición.
     */
    public Shape2D clone(Coordinate co) {
        Shape2D cloned = this.clone(); // Aquí se llama al método clone() abstracto, que debe ser implementado por las subclase
        cloned.move(co);
        return cloned;
    }

    /**Oráculo P
     * Verifica si la figura es igual al objeto especificado.
     * @param obj El objeto a comparar.
     * @return true si la figura es igual al objeto, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
    	if(obj instanceof Shape2D) {
    		Shape2D shape2D = (Shape2D) obj;
    		return position.equals(shape2D.position);
    	}
        return false;
    }

    /**
     * Devuelve una representación en cadena de la figura.
     * @return La representación en cadena de la figura.
     */
    @Override
    public String toString() {
        return "(" + position.getX() + "," + position.getY() + ")";
    }
    
    /**
     * Escala la figura por el porcentaje especificado.
     * @param percentage El porcentaje por el cual escalar la figura.
     */
    public abstract void scale(double percentage);
    
    /**
     * Crea un clon de la figura.
     * @return La figura clonada.
     */
    @Override
    public abstract Shape2D clone();
}