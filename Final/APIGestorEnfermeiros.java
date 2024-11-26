package trabalho;

import java.rmi.RemoteException;
import java.util.List;
import java.rmi.Remote;
import java.util.Map;

public interface APIGestorEnfermeiros extends Remote{
    public Enfermeiro createEnfermeiro(String nome, String telefone, String especialidade) throws RemoteException;

    int totalEnfermeiros() throws RemoteException;

    public List<String> procuraEnfermeiro(String nome) throws RemoteException;

    public List<String> procuraEnfermeiroTelefone(String telefone) throws RemoteException;

    public Map<String, Integer> distribuicaoPorEspecialidades() throws RemoteException;

    public List<String> listarEnfermeiros() throws RemoteException;
}