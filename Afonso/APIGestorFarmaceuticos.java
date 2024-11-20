package trabalho;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface APIGestorFarmaceuticos extends Remote {
    public Farmaceutico createFarmaceutico(String nome, String telefone) throws RemoteException;

    public Farmaceutico removeFarmaceutico(String id) throws RemoteException;

    public Farmaceutico getFarmaceutico(String id) throws RemoteException;

    public List<String> procuraFarmaceutico(String nome) throws RemoteException;

    public List<String> procuraFarmaceuticoTelefone(String telefone) throws RemoteException;

    int totalFarmaceuticos() throws RemoteException;

    public List<String> listarFarmaceuticos() throws RemoteException;

    public void alteraTelefone(String id, String telefone) throws RemoteException;
}