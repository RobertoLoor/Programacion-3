package es.ua.dlsi.prog3.p3.lowlevel;

/**
 * Representa un dispositivo de entrada en el canal de comunicación.
 */
public class InputDevice extends IODevice {

    /**
     * Constructor de la clase InputDevice.
     */
    protected InputDevice() {
        super();
    }

    /**
     * Envía un solo byte al canal.
     * @param dato el byte a enviar
     */
    protected void sendToChannel(byte dato) {
        getChannel().input(dato);
    }

    /**
     * Coloca un array de bytes en el búfer del canal.
     * @param datos el array de bytes a colocar en el canal
     */
    protected void put(byte[] datos) {
        for(int i = 0; i < datos.length; i++) {
            sendToChannel(datos[i]);
        }
    }

}