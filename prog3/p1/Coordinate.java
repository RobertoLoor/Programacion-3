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
    /**-----------ATRIBUTOS-----------*/
    private final double[] components; /**Es el conjunto de componentes que se almacenan en la instancia de la clase.*/
    /**-----------MÉTODOS-----------*/
    /**
     * Constructor por defecto.
     * Inicializa el conjunto de componentes a vacío en caso de que el parámetro sea nulo.
     * En caso de que se reciba un arreglo de componentes con datos, se realiza una copia de los mismos.
     * @param components El arreglo de componentes a copiar.
     */
    public Coordinate(double[] components) { 
        if (components == null) {
            this.components = new double[0];
        } else {
            this.components = new double[components.length];
            System.arraycopy(components, 0, this.components, 0, components.length);
        }
    }

    /**
     * Constructor de copia. 
     * Realiza una copia profunda de los componentes almacenados en la instancia recibida.
     * @param c La instancia de Coordinate a copiar.
     */
    public Coordinate(Coordinate c) {
        this.components = new double[c.components.length];
        System.arraycopy(c.components, 0, this.components, 0, c.components.length);
    }

    /**
     * Método que devuelve una copia de los componentes almacenados en la instancia.
     * @return Una copia del arreglo de componentes.
     */
    public double[] getComponents() {
        return this.components.clone();
    }

    /**
     * Método que devuelve la cantidad de componentes almacenados en la instancia.
     * @return La cantidad de componentes almacenados.
     */
    public int getDimensions() {
        return this.components.length;
    }

    /**
     * Método que devuelve el hashcode de la instancia.
     * El hashcode se calcula a partir de los componentes almacenados en la instancia y se devuelve como un entero.
     * Sirve para poder comparar instancias de la clase.
     * @return El hashcode calculado a partir de los componentes.
     */
    public int hashCode(){
        return Arrays.hashCode(this.components); 
    }

    /**
     * Método que compara dos instancias de la clase.
     * Devuelve true si los componentes de ambas instancias son iguales, y false en caso contrario.
     * @param o El objeto a comparar con la instancia actual.
     * @return true si los componentes son iguales, false en caso contrario.
     */
    public boolean equals(Object o){
        if(this == o){return true;}
        if(o == null){return false;}
        if(this.getClass() != o.getClass()){return false;}
        Coordinate c = (Coordinate) o;
        return Arrays.equals(this.components, c.components);
    }

    /**
     * Método main que se encarga de probar la clase Coordinate.
     * @param args Los argumentos de la línea de comandos.
     */
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