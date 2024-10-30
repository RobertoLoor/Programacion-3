
package es.ua.dlsi.prog3.p3.lowlevel;

import java.nio.BufferUnderflowException;

/**
 * Clase que representa un dispositivo de salida.
 * Extiende la clase IODevice.
 */
public class OutputDevice extends IODevice {

	/**
	 * Constructor de la clase OutputDevice.
	 * 
	 * @param bufferSize El tamaño del búfer del dispositivo.
	 */
	protected OutputDevice(int bufferSize) {
		super(bufferSize);
	}

	/**
	 * Obtiene un número específico de bytes del dispositivo de salida.
	 * 
	 * @param num_bytes El número de bytes a obtener.
	 * @return Un array de bytes con los datos obtenidos.
	 * @throws IllegalArgumentException Si el número de bytes es menor o igual a 0 o mayor que el tamaño del búfer.
	 */
	protected byte[] get(int num_bytes) {
		if (num_bytes <= 0 || num_bytes > getBufferSize()) {
            throw new IllegalArgumentException("num_bytes must be greater than 0 and less than or equal to the buffer size");
        }

        byte[] data = new byte[num_bytes];
        int bytesRead = 0;

        try {
            for (int i = 0; i < num_bytes; i++) {
                data[i] = receiveFromChannel();
                bytesRead++;
            }
        } catch (BufferUnderflowException e) {
            // No más datos disponibles, devolver los bytes leídos hasta ahora
        }

        if (bytesRead < num_bytes) {
            // Si se leyeron menos bytes de los solicitados, crear un nuevo array con el tamaño correcto
            byte[] truncatedData = new byte[bytesRead];
            System.arraycopy(data, 0, truncatedData, 0, bytesRead);
            data = truncatedData;
        }

        return data.clone();
	}

	/**
	 * Recibe un byte del canal de salida.
	 * 
	 * @return El byte recibido.
	 */
    protected byte receiveFromChannel() {
        return getChannel().output();
    }

	/**
	 * DON'T TOUCH THIS METHOD!!! The earth will collapse on itself if you ever think of doing it!
	 * 
	 * Reads a string from the channel. 
	 * 
	 * The channel MUST contain a string of characteres encoded as
	 * 
	 * 
	 * [length][A-Ba-b0-9]+
	 * 
	 * which means that the first byte is the string length, and the rest of bytes are the actual string 
	 * 
	 * 
	 * @return the string read, as an String object, or an empty if there is no data in the channel 
	 * @throws BufferUnderflowException if the channel becomes empty before the whole string is read, i.e. the data in the channel is corrupted
	 * @throws IllegalStateException if there is no channel associated to this device 
	 */
	protected String readStoredString() {
		byte[] data = null;
		char[] string = null;
		data = get(1);
		if (data.length != 1) 
			return "";
		int string_length = data[0];		
		data = get(string_length);
		if (data.length != string_length)
			throw new BufferUnderflowException();
		string = new char[string_length];
		for (int i=0; i < string_length; i++)
			string[i] = (char) data[i];
		return String.valueOf(string);
	}
}


