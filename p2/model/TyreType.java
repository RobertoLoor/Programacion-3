/**
DNI/PASAPORTE: A8590323
APELLIDOS: Loor Tamayo
NOMBRE: Roberto Carlos
@author Roberto Loor
*/

package es.ua.dlsi.prog3.p2.model;

/**
 * Representa un tipo de neumático.
 */
final class TyreType {
    private final String description;
    private final double minPressure;
    private final double maxPressure;

    /**
     * Construye un objeto TyreType con la descripción, presión mínima y presión máxima especificadas.
     * @param description La descripción del tipo de neumático.
     * @param minPressure La presión mínima del tipo de neumático.
     * @param maxPressure La presión máxima del tipo de neumático.
     * @throws IllegalArgumentException Si la descripción es nula o vacía, o si las presiones son inválidas.
     */
    public TyreType(String description, double minPressure, double maxPressure){
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Descripción no puede ser nula o vacía.");
        }
        if (minPressure < 0 || maxPressure < 0 || minPressure > maxPressure) {
            throw new IllegalArgumentException("Presiones inválidas: presión mínima mayor que la máxima o negativa.");
        }
        this.description = description;
        this.minPressure = minPressure;
        this.maxPressure = maxPressure;
    }

    /**
     * Construye un objeto TyreType a partir de otro objeto TyreType.
     * @param t El objeto TyreType a copiar.
     */
    public TyreType(TyreType t) {
        this(t.description, t.minPressure, t.maxPressure);
    }

    /**
     * Devuelve la presión mínima del tipo de neumático.
     * @return La presión mínima.
     */
    public double getMinPressure() {
        return minPressure;
    }

    /**
     * Devuelve la presión máxima del tipo de neumático.
     * @return La presión máxima.
     */
    public double getMaxPressure() {
        return maxPressure;
    }

    /**
     * Devuelve la descripción del tipo de neumático.
     * @return La descripción.
     */
    @Override
    public String toString() {
        return "TyreType " + description + " [" + minPressure + "," + maxPressure + "]";
    }

    /**
     * Comprueba si dos objetos TyreType son iguales.
     * @param o El objeto con el que comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TyreType tyreType = (TyreType) o;
        return Double.compare(tyreType.minPressure, minPressure) == 0 &&
                Double.compare(tyreType.maxPressure, maxPressure) == 0 &&
                description.equals(tyreType.description);
    }
}

