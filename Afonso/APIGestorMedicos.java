package trabalho;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface APIGestorMedicos extends Remote {
    public Medico createMedico(String nome, String telefone, String especialidade) throws RemoteException;

    public Medico getMedico(String id) throws RemoteException;

    public Medico removeMedico(String id) throws RemoteException;

    public List<String> procuraMedico(String nome) throws RemoteException;

    public void alteraTelefone(String id, String telefone) throws RemoteException;

    public List<String> procuraEspecialidade(String especialidade) throws RemoteException;

}