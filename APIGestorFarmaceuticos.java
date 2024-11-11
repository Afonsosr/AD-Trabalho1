package rmi.model;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface APIGestorFarmaceuticos {
    public Farmaceutico createFarmaceutico(String nome, String telefone) throws RemoteException;

    public Farmaceutico removeFarmaceutico(String id) throws RemoteException;

    public Farmaceutico getFarmaceutico(String id) throws RemoteException;

    public List<String> procuraFarmaceuticoTelefone(String telefone) throws RemoteException;

    public void alteraTelefone(String id, String telefone) throws RemoteException;
}
