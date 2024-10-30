package es.ua.dlsi.prog3.p3.highlevel;

import java.nio.BufferUnderflowException;

import es.ua.dlsi.prog3.p3.lowlevel.*;

/**
 * Clase que representa una pantalla de visualización.
 */
public class Display extends OutputDevice {
    private int pixel_rows;
    private byte[][] display;

    /**
     * Constructor de la clase Display.
     * 
     * @param N El tamaño de la pantalla en número de filas y columnas.
     */
    public Display(int N) {
        super(N * N * 2);  // Tamaño del buffer: dos bytes por cada pixel
        this.pixel_rows = N;
        this.display = new byte[N][N];
    }

    /**
     * Método que devuelve el tamaño de la pantalla.
     * 
     * @return El tamaño de la pantalla en número de filas y columnas.
     */
    public int getDisplaySize() {
        return pixel_rows;
    }

    /**
     * Método que actualiza el contenido de la pantalla.
     * 
     * @return Una copia del contenido actual de la pantalla.
     */
    public byte[][] refresh() {
        while (getChannel().hasData()) {
            try {
                byte x = receiveFromChannel();
                byte y = receiveFromChannel();

                if (x < 0 || x >= pixel_rows || y < 0 || y >= pixel_rows) {
                    throw new IndexOutOfBoundsException("Coordenadas del píxel fuera de los límites: (" + x + ", " + y + ")");
                }

                display[y][x] = 1;
            } catch (BufferUnderflowException e) {
                throw new BufferUnderflowException();
            }
        }

        byte[][] copy = new byte[pixel_rows][];
        for (int i = 0; i < pixel_rows; i++) {
            copy[i] = display[i].clone();
        }

        return copy;
    }

    /**
     * Método para limpiar la pantalla, estableciendo todos los píxeles a 0.
     */
    public void clear() {
        for (int i = 0; i < pixel_rows; i++) {
            for (int j = 0; j < pixel_rows; j++) {
                display[i][j] = 0;
            }
        }
    }
}