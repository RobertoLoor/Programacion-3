/**
DNI/PASAPORTE: A8590323
APELLIDOS: Loor Tamayo
NOMBRE: Roberto Carlos
@author Roberto Loor
*/

package es.ua.dlsi.prog3.p4.model;

import java.util.ArrayList;

/**
 * Representa un lienzo que puede contener formas 2D.
 */
public class Canvas{
    /**
     * Tamaño predeterminado del lienzo en píxeles.
     */
    public static final float DEFAULT_SIZE = 1000;

    /**
     * Título del lienzo.
     */
    private String title;

    /**
     * Anchura del lienzo en píxeles.
     */
    private double width;

    /**
     * Altura del lienzo en píxeles.
     */
    private double height;

    /**
     * Lista de formas 2D que se han dibujado en el lienzo.
     */
    private ArrayList<Shape2D> shapes;


    /**
     * Construye un lienzo por defecto con el título "default canvas" y el tamaño por defecto.
     */
    public Canvas() {
        this.title = "default canvas";
        this.width = DEFAULT_SIZE;
        this.height = DEFAULT_SIZE;
        this.shapes = new ArrayList<>();
    }
    
    /**
     * Construye un nuevo lienzo que es una copia del lienzo dado.
     * 
     * @param other El lienzo a ser copiado.
     */
    public Canvas(Canvas other) {
        this.title = other.title;
        this.width = other.width;
        this.height = other.height;
        this.shapes = new ArrayList<>();
        for (Shape2D shape : other.shapes) {
            this.addShape(shape);
        }
    }

    /**
     * Construye un nuevo lienzo con el título, ancho y alto dados.
     * 
     * @param title El título del lienzo.
     * @param width El ancho del lienzo.
     * @param height La altura del lienzo.
     * @throws IllegalArgumentException si el ancho o la altura es negativo.
     */
    public Canvas(String title, double width, double height) {
        if (width < 0 || height < 0) throw new IllegalArgumentException("El ancho y la altura deben ser positivos.");
        this.title = title;
        this.width = width;
        this.height = height;
        this.shapes = new ArrayList<>();
    }
    
    /**
     * Añade una forma al lienzo.
     * 
     * @param shape La forma a ser añadida.
     */
    public void addShape(Shape2D shape) {
		shapes.add(shape.clone());
    }
    
    /**
     * Crea y devuelve una copia del lienzo.
     * 
     * @return Un nuevo lienzo que es una copia de este lienzo.
     */
    @Override
    public Canvas clone() {
        return new Canvas(this);
    }
    
    /**
     * Devuelve la forma en el índice especificado.
     * 
     * @param index El índice de la fAorma a recuperar.
     * @return La forma en el índice especificado.
     * @throws IndexOutOfBoundsException si el índice está fuera de rango.
     */
    public Shape2D getShape(int index) {
        if(index < 1 || index > shapes.size()) {throw new IndexOutOfBoundsException();}
        return shapes.get(index - 1);
    }
    
    /**
     * Devuelve el ancho del lienzo.
     * 
     * @return El ancho del lienzo.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Devuelve la altura del lienzo.
     * 
     * @return La altura del lienzo.
     */
    public double getHeight() {
        return height;
    }
    
    
    /**
     * Devuelve el número de formas en el lienzo.
     * 
     * @return El número de formas en el lienzo.
     */
    public int getNumShapes() {
        return shapes.size();
    }

    /**
     * Elimina la forma en el índice especificado del lienzo.
     * 
     * @param index El índice de la forma a eliminar.
     */
    public void removeShape(int index) {
    	 if(index < 1 || index > shapes.size()) {throw new IndexOutOfBoundsException();}
        shapes.remove(index -1);
    }

    /**
     * Devuelve una representación en cadena del lienzo.
     * 
     * @return Una representación en cadena del lienzo.
     */
    @Override
    public String toString() {
        return title + " (" + 
                this.width + "," + 
                this.height +
                ") with " +
                this.getNumShapes() +
                " shapes";
    }
}