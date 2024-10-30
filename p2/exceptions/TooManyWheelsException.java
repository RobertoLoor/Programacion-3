/**
DNI/PASAPORTE: A8590323
APELLIDOS: Loor Tamayo
NOMBRE: Roberto Carlos
@author Roberto Loor
*/

package es.ua.dlsi.prog3.p2.exceptions;

/**
 * Excepción lanzada cuando un vehículo tiene demasiadas ruedas.
 */
public class TooManyWheelsException extends java.lang.Exception  {
	/**
	 * Constructor de la excepción.
	 * Imprime un mensaje indicando que el vehículo tiene demasiadas ruedas.
	 */
	public TooManyWheelsException() {
	   System.out.println("El vehículo tiene demasiadas ruedas.");
	}
}

