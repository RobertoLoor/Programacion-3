package es.ua.dlsi.prog3.p3.highlevel;

import es.ua.dlsi.prog3.p3.lowlevel.*;
import es.ua.dlsi.prog3.p3.highlevel.exceptions.*;

/**
 * Clase que representa una impresora de líneas.
 */
public class LinePrinter extends OutputDevice {
    private static final int MAX_LINE_LENGTH = 80;

    /**
     * Constructor de la clase LinePrinter.
     */
    public LinePrinter() {
        super(MAX_LINE_LENGTH + 1);
    }

    /**
     * Imprime una línea.
     * @return La línea impresa.
     * @throws NoLineForPrintingException Si no hay ninguna línea para imprimir.
     */
    public String printLine() throws NoLineForPrintingException {
        String line = readStoredString();
        if (line.isEmpty()) {
            throw new NoLineForPrintingException();
        }
        return line;
    }
}