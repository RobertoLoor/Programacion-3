/**
DNI/PASAPORTE: A8590323
APELLIDOS: Loor Tamayo
NOMBRE: Roberto Carlos
@author Roberto Loor
*/

package es.ua.dlsi.prog3.p2.exceptions;

/**
 * Excepción lanzada cuando no se encuentra un tipo de neumático para un vehículo.
 */
public class NoTyreTypeException extends java.lang.Exception {
	/**
	 * Constructor de la excepción.
	 */
	public NoTyreTypeException() {
		System.out.println("No se encontró un tipo de neumático para este vehículo.");
	}
}

