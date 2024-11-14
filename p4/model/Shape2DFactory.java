/**
DNI/PASAPORTE: A8590323
APELLIDOS: Loor Tamayo
NOMBRE: Roberto Carlos
@author Roberto Loor
*/

package es.ua.dlsi.prog3.p4.model;

/**
 * A factory class for creating instances of Shape2D objects.
 */
public class Shape2DFactory{
    /**
     * Creates a Shape2D object based on the given type.
     *
     * @param type the type of the shape to create (circle, rectangle, square)
     * @return a Shape2D object of the specified type
     * @throws IllegalArgumentException if the given type is unknown
     */
    public static Shape2D createShape2D(String type) {
    	if(type == null) throw new IllegalArgumentException("Shape cannot be null");
        switch (type) {
            case "Circle":
                return new Circle();
            case "Rectangle":
                return new Rectangle();
            case "Square":
                return new Square();
            default:
                throw new IllegalArgumentException("Unknown shape type: " + type);
        }
    }
}