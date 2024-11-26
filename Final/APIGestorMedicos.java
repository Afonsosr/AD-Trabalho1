package trabalho;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface APIGestorMedicos extends Remote {
    public Medico createMedico(String nome, String telefone, String especialidade) throws RemoteException;

    public List<String> procuraMedico(String nome) throws RemoteException;

    public List<String> procuraEspecialidade(String especialidade) throws RemoteException;

    public int totalMedicos() throws RemoteException;

    public List<String> listarMedicos() throws RemoteException;

    public boolean existeMedico(String idMedico) throws RemoteException;

    public Map<String, Integer> distribuicaoPorEspecialidades() throws RemoteException;
}