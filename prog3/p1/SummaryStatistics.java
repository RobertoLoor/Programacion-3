package es.ua.dlsi.prog3.p1;

/**
DNI/PASAPORTE: A8590323
APELLIDOS: Loor Tamayo
NOMBRE: Roberto Carlos
@author Roberto Loor
 */

import java.util.ArrayList;

/**
El objetivo de esta clase es almacenar un conjunto de valores enteros y realizar operaciones sobre ellos.
Entre estas operaciones podemos encontrar: obtener el promedio, el valor máximo, el valor mínimo y la cantidad de valores almacenados.
Además, se puede obtener la cantidad de instancias de la clase que han sido creadas.
Esta clase tiene tres constructores: uno sin parámetros que se encarga de inicializar el identificador y la lista de valores a vacío;
otro que recibe una lista de valores y los almacena en la lista de valores de la instancia creada;
y finalmente otro que recibe un objeto de la misma clase y realiza una copia profunda de los valores almacenados en la instancia recibida.
 */

public class SummaryStatistics{
    /**-----------ATRIBUTOS-----------*/
    private int id;     /**Es el identificador de clase, para identificar los valores con los que se trabaja. Es un atributo de instancia.*/
    private ArrayList<Integer> values;    /**Es la lista de valores enteros con los que se trabaja. Es un atributo de instancia.*/
    private static int NEXT_ID = 0;     /**Es el número de instancias que han sido creadas. Además sirve para saber cual será el ID del siguiente objeto creado. Es un atributo de clase.*/
    /**-----------MÉTODOS-----------*/
    /**
     * Constructor por defecto.
     * Inicializa el identificador y la lista de valores a vacío.
     */
    public SummaryStatistics(){
        this.id = NEXT_ID;
        NEXT_ID++;
        this.values = new ArrayList<Integer>();
    }
    /**
     * Constructor sobrecargado. 
     * Recibe una lista de valores y los almacena en la lista de valores de la instancia creada.
     * @param values La lista de valores a almacenar.
     */
    public SummaryStatistics(ArrayList<Integer> values){
        this.id = NEXT_ID;
        NEXT_ID++;
        this.values = new ArrayList<Integer>(values);
    }

    /**
     * Constructor de copia. 
     * Realiza una copia profunda de los valores almacenados en la instancia recibida.
     * @param s La instancia de SummaryStatistics a copiar.
     */
    public SummaryStatistics(SummaryStatistics s){
        this.id = NEXT_ID;
        NEXT_ID++;
        this.values = new ArrayList<Integer>(s.values); /**Se realiza una copia profunda de la lista de valores, ya que al ser de tipo primitivo, se copia el valor y no la referencia, siendo así inmutables por defecto.*/
    }

    /**
     * Añade un valor entero a la lista de valores.
     * @param value El valor a añadir.
     */
    public void add(int value){
        this.values.add(value); /** Hay un boxing implícito, ya que el valor entero se convierte automáticamente a un objeto Integer antes de ser añadido a la lista. */
    }

    /**
     * Devuelve el identificador de la instancia.
     * @return El identificador de la instancia.
     */
    public int getId(){
        return this.id;
    }

    /**
     * Devuelve el promedio de los valores almacenados en la lista.
     * @return El promedio de los valores almacenados, o null si la lista está vacía.
     */
    public Integer getAverage(){
        if(this.values.size() == 0){return null;}
        int sum = 0;
        for(int i = 0; i < this.values.size(); i++){
            sum += this.values.get(i); /** Hay un unboxing implícito, ya que el objeto Integer obtenido de la lista se convierte automáticamente a un valor entero antes de sumarse a 'sum'. */
        }
        return sum / this.values.size();
    }

    /**
     * Devuelve el valor máximo de los valores almacenados en la lista.
     * @return El valor máximo de los valores almacenados, o null si la lista está vacía.
     */
    public Integer getMax(){
        if(this.values.size() == 0){return null;}
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < this.values.size(); i++){
            max = Math.max(max, this.values.get(i)); /** Hay un unboxing implícito, ya que el objeto Integer obtenido de la lista se convierte automáticamente a un valor entero antes de compararse con 'max'.*/
        }
        return max;
    }

    /**
     * Devuelve el valor mínimo de los valores almacenados en la lista.
     * @return El valor mínimo de los valores almacenados, o null si la lista está vacía.
     */
    public Integer getMin(){
        if(this.values.size() == 0){return null;}
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < this.values.size(); i++){
            min = Math.min(min, this.values.get(i)); /** Hay un unboxing implícito, ya que el objeto Integer obtenido de la lista se convierte automáticamente a un valor entero antes de compararse con 'min'.*/
        }
        return min;
    }

    /**
     * Devuelve la cantidad de valores almacenados en la lista.
     * @return La cantidad de valores almacenados.
     */
    public int getSize(){
        return this.values.size();
    }

    /**
     * Devuelve la cantidad de instancias de la clase que han sido creadas.
     * @return La cantidad de instancias creadas.
     */
    public static int COUNT_INSTANCES(){
        return NEXT_ID;
    }
}

