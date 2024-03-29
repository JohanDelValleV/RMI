package server;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Decrementador extends Thread {
    private final Semaphore mutex;
    private final Puntaje puntaje;

    public Decrementador(Semaphore mutex, Puntaje puntaje) {
        this.mutex = mutex;
        this.puntaje = puntaje;
    }

    @Override
    public void run() {
        try {
            mutex.acquire();
            puntaje.decrementarPuntaje();
            mutex.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Decrementador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}