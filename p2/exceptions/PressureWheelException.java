/**
DNI/PASAPORTE: A8590323
APELLIDOS: Loor Tamayo
NOMBRE: Roberto Carlos
@author Roberto Loor
*/

package es.ua.dlsi.prog3.p2.exceptions;

/**
 * Excepción para representar un error relacionado con la presión de una rueda.
 */
public class PressureWheelException extends java.lang.Exception  {
    private double pressure;

    /**
     * Constructor de la excepción.
     * @param pressure La presión de la rueda.
     */
    public PressureWheelException(double pressure) {
        this.pressure = pressure;
    }

    /**
     * Devuelve un mensaje con la presión de la rueda.
     * @return El mensaje.
     */
    @Override
    public String getMessage() {
        return "Presión de " + pressure + " BAR";
    }
}

