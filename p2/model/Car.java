/**
DNI/PASAPORTE: A8590323
APELLIDOS: Loor Tamayo
NOMBRE: Roberto Carlos
@author Roberto Loor
*/

package es.ua.dlsi.prog3.p2.model;

import es.ua.dlsi.prog3.p2.exceptions.TooManyWheelsException;
import es.ua.dlsi.prog3.p2.exceptions.WrongTyreTypeException;
import es.ua.dlsi.prog3.p2.exceptions.PressureWheelException;

import java.util.ArrayList;

/**
 * Representa un coche.
 */
public class Car {
    private ArrayList<Wheel> wheels;

    /**
     * Constructor por defecto.
     */
    public Car() {
        this.wheels = new ArrayList<>();
    }

    /**
     * Constructor de copia.
     * @param car El coche a copiar.
     */
    public Car(Car car) {   
        this.wheels = new ArrayList<>();
        for (Wheel w : car.wheels) {
           this.wheels.add(new Wheel(w));
        }
    }

    /**
     * Agrega una rueda al coche.
     * @param wheel La rueda a agregar.
     * @throws TooManyWheelsException Si ya hay 4 ruedas en el coche.
     * @throws WrongTyreTypeException Si la nueva rueda tiene un tipo de neumático diferente a las ruedas existentes.
     */
    public void addWheel(Wheel wheel) throws TooManyWheelsException, WrongTyreTypeException {
        if (wheels.size() == 4) {
            throw new TooManyWheelsException();
        }

        if (!wheels.isEmpty()) {
            TyreType existingTyreType = wheels.get(0).getTyreType();
            TyreType newTyreType = wheel.getTyreType();
            
            if (existingTyreType != null && !existingTyreType.equals(newTyreType)) {
                throw new WrongTyreTypeException();
            }
        }

        wheels.add(new Wheel(wheel));
    }

    /**
     * Devuelve una copia de las ruedas del coche.
     * @return La copia de las ruedas.
     */
    public ArrayList<Wheel> getWheels() {
        ArrayList<Wheel> wheelCopies = new ArrayList<>();
        for (Wheel w : wheels) {
            wheelCopies.add(new Wheel(w));  // Use the copy constructor of Wheel
        }
        return wheelCopies;
    }

    /**
     * Cambia los neumáticos de todas las ruedas del coche.
     * @param tyreType El nuevo tipo de neumático.
     * @param pressure La presión de los neumáticos.
     * @throws PressureWheelException Si hay un error con la presión de los neumáticos.
     * @throws IllegalArgumentException Si el tipo de neumático es null.
     * @throws RuntimeException Si no se ha asignado el tipo de neumático a alguna rueda.
     */
    public void changeTyres(TyreType tyreType, double pressure) throws PressureWheelException {
        if (tyreType == null) {
            throw new IllegalArgumentException("El tipo de neumático no puede ser null.");
        }

        for (Wheel w : wheels) {
            try {
                w.setTyreType(tyreType);
                w.inflate(pressure);
            } catch (PressureWheelException e) {
                System.out.println("Error al cambiar los neumáticos: Presión incorrecta");
                throw e;
            } catch (Exception e) {
                throw new RuntimeException("Error al cambiar los neumáticos: Tipo de neumático no asignado");
            }
        }
    }
}