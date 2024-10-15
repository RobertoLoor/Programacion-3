package es.ua.dlsi.prog3.p1;

/**
DNI/PASAPORTE: A8590323
APELLIDOS: Loor Tamayo
NOMBRE: Roberto Carlos
@author Roberto Loor
*/

import java.util.Arrays; /**Importamos la clase Arrays para poder utilizar sus métodos.*/

/**
La clase Coordinate se encarga de almacenar un conjunto de componentes, y realizar comparaciones sobre ellos, 
así como también de obtener la cantidad de componentes almacenados, y el valor de los componentes.
Así mismo, cabe resaltar que al ser una clase creada para ser inmutable, una vez creada, no se puede modificar.
*/
final class Coordinate {
    private final double[] components;
  
    public Coordinate(double[] components) { 
        if (components == null) {
            this.components = new double[0];} 
        else {
            this.components = Arrays.copyOf(components, components.length);
        }
    }

    public Coordinate(Coordinate c) {
    	this(c.getComponents());
    }

    public double[] getComponents() {
        return this.components.clone();
    }

    public int getDimensions() {
        return this.components.length;
    }

    public int hashCode(){
        return Arrays.hashCode(this.components); 
    }

    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || this.getClass() != o.getClass()) {return false;}
        Coordinate c = (Coordinate) o;
        if (this.hashCode() != c.hashCode()) {return false;}
        return Arrays.equals(this.components, c.components);
    }


    public static void main(String[] args) {
        double[] numbers2 = { 2.0, 3.4 };
        double[] numbers3 = { 2.0, 3.4, -4.9 };
        double[] numbers4 = { 2.3, 8.4 };
        double[] numbers6 = { 2.3, 8.4 };
        Coordinate c1 = new Coordinate(numbers2);
        Coordinate c2 = new Coordinate(numbers3);
        Coordinate c4 = new Coordinate(numbers4);
        Coordinate c5 = new Coordinate(c4);
        Coordinate c6 = new Coordinate(numbers6);

        System.out.println("c1 : " + c1.getDimensions());
        System.out.println("c2 : " + c2.getDimensions());
        System.out.println("c4 : " + c4.getDimensions());
        System.out.println("c5 : " + c5.getDimensions());
        System.out.println("c6 : " + c6.getDimensions());

        double[] comps = c1.getComponents();

        System.out.print("c1 components: ");
        for (int i = 0; i < c1.getDimensions(); i++) {
            System.out.print(comps[i] + " ");
        }
        System.out.println();

        System.out.println("c1 == c1 ? " + (c1.equals(c1)));
        System.out.println("c1 == c2 ? " + (c1.equals(c2)));
        System.out.println("c1 == c4 ? " + (c1.equals(c4)));
        System.out.println("c4 == c5 ? " + (c4.equals(c5)));
       }
}