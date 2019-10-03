package server;

import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;

import Api.Score;

public class Main {
    public static void main(String[] args) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);

        Server server = new Server();
        Score score = (Score) UnicastRemoteObject.exportObject(server, 0);

        registry.rebind("verbs", score);
        System.out.println("Server is running in PORT: " + Registry.REGISTRY_PORT);
    }
}