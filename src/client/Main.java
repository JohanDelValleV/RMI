package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;

import Api.Score;


public class Main {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", Registry.REGISTRY_PORT);

        Score score = (Score) registry.lookup("verbs");
        score.incrementarPuntaje();
        System.out.println(score.obtenerPuntaje());
    }
}