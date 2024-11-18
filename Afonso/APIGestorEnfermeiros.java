package trabalho;

import java.rmi.RemoteException;
import java.util.List;
import java.rmi.Remote;

public interface APIGestorEnfermeiros extends Remote{
    public void createEnfermeiro(String nome, String telefone, String especialidade) throws RemoteException;

    public Enfermeiro getEnfermeiro(String id) throws RemoteException;

    public Enfermeiro removeEnfermeiro(String id) throws RemoteException;

    public List<String> procuraEnfermeiro(String nome) throws RemoteException;

    public List<String> procuraEnfermeiroTelefone(String telefone) throws RemoteException;

    public void alteraTelefone(String id, String telefone) throws RemoteException;

}
