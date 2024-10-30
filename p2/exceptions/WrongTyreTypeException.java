/**
DNI/PASAPORTE: A8590323
APELLIDOS: Loor Tamayo
NOMBRE: Roberto Carlos
@author Roberto Loor
*/

package es.ua.dlsi.prog3.p2.exceptions;

/**
 * Excepción lanzada cuando se intenta utilizar un tipo de neumático incorrecto para un vehículo.
 */
public class WrongTyreTypeException extends java.lang.Exception  {
	/**
	 * Constructor de la excepción.
	 */
	public WrongTyreTypeException() {
		System.out.println("Tipo de neumático incorrecto para este vehículo.");
	}
}

