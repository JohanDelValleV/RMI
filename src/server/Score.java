package server;

import java.rmi.*;

public interface Score extends Remote {
    public void incrementarPuntaje() throws RemoteException;

    public void decrementarPuntaje() throws RemoteException;

    public int obtenerPuntaje() throws RemoteException;
}