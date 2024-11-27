package es.ua.dlsi.prog3.p6.algorithms;

/**
 * Generic interface to define operations for edge weights
 * @param <T> The type of the edge label
 */
public interface ICostOperators<T> {
    /**
     * Returns the zero value for the type
     * @return Zero value
     */
    T zero();

    /**
     * Returns the maximum value for the type (e.g., infinity)
     * @return Maximum value
     */
    T maximumValue();

    /**
     * Adds two values of type T
     * @param a First value
     * @param b Second value
     * @return Sum of the two values
     */
    T add(T a, T b);
}