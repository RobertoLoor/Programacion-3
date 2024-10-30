/**
DNI/PASAPORTE: A8590323
APELLIDOS: Loor Tamayo
NOMBRE: Roberto Carlos
@author Roberto Loor
*/

package es.ua.dlsi.prog3.p2.model;

import es.ua.dlsi.prog3.p2.exceptions.NoTyreTypeException;
import es.ua.dlsi.prog3.p2.exceptions.PressureWheelException;

/**
 * Representa una rueda de un vehículo.
 */
public class Wheel {
    private double pressure;
    private TyreType tyreType;

    /**
     * Constructor por defecto.
     * Inicializa la presión a 0 y el tipo de neumático a null.
     */
    public Wheel() {
        this.pressure = 0;
        this.tyreType = null;
    }

    /**
     * Constructor que recibe el tipo de neumático.
     * Inicializa la presión a 0 y asigna el tipo de neumático especificado.
     * @param tyreType El tipo de neumático.
     */
    public Wheel(TyreType tyreType) {
        this.pressure = 0;
        this.tyreType = tyreType;
    }

    /**
     * Constructor de copia.
     * Crea una nueva rueda con los mismos valores de presión y tipo de neumático que la rueda especificada.
     * @param wheel La rueda a copiar.
     */
    public Wheel(Wheel wheel) {
        this.pressure = wheel.pressure;
        this.tyreType = wheel.tyreType;
    }

    /**
     * Establece el tipo de neumático.
     * @param tyreType El tipo de neumático.
     */
    public void setTyreType(TyreType tyreType) {
        this.tyreType = tyreType;
    }

    /**
     * Obtiene el tipo de neumático.
     * @return El tipo de neumático.
     */
    public TyreType getTyreType() {
        return tyreType;
    }

    /**
     * Infla la rueda con la presión especificada.
     * @param pressure La presión a inflar.
     * @throws NoTyreTypeException Si no se ha especificado un tipo de neumático.
     * @throws PressureWheelException Si la presión está fuera del rango permitido para el tipo de neumático.
     */
    public void inflate(double pressure) throws NoTyreTypeException, PressureWheelException {
        if (pressure < 0) {
            throw new IllegalArgumentException("La presión no puede ser negativa.");
        }
        if (tyreType == null) {
            throw new NoTyreTypeException();
        }
        if (pressure < tyreType.getMinPressure() || pressure > tyreType.getMaxPressure()) {
            throw new PressureWheelException(pressure);
        }
        this.pressure = pressure;
    }

    /**
     * Compara dos ruedas para determinar si son iguales.
     * @param o La rueda con la que comparar.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wheel)) return false;
        Wheel wheel = (Wheel) o;
        return Double.compare(wheel.pressure, pressure) == 0;
    }
}



