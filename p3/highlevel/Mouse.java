package es.ua.dlsi.prog3.p3.highlevel;

import es.ua.dlsi.prog3.p3.lowlevel.*;

/**
 * Representa un dispositivo de entrada de ratón.
 */
public class Mouse extends InputDevice {

    /**
     * Construye un nuevo objeto Mouse.
     */
    public Mouse() {
        super();
    }

    /**
     * Envía las coordenadas x e y al canal.
     * 
     * @param x La coordenada x
     * @param y La coordenada y
     */
    public void put(byte x, byte y) {
        sendToChannel(x);
        sendToChannel(y);
    }
}