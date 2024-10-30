package es.ua.dlsi.prog3.p3.highlevel;

import es.ua.dlsi.prog3.p3.lowlevel.*;

/**
 * Esta clase representa un teclado como dispositivo de entrada.
 */
public class Keyboard extends InputDevice {

    /**
     * Constructor por defecto de la clase Keyboard.
     */
    public Keyboard() {
        super();
    }

    /**
     * Envía un carácter al canal de comunicación.
     * 
     * @param c El carácter a enviar.
     */
    public void put(char c) {
        sendToChannel((byte) c);
    }
}
