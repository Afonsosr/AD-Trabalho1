package trabalho;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface APIGestorUtentes extends Remote {
    public void createUtente(String nome, String genero, LocalDate dataNascimento, ArrayList<String> medicacao, ArrayList<String> condicoes) throws RemoteException;

    public Utente getUtente(String id) throws RemoteException;

    public List<String> procuraUtente(String nome) throws RemoteException;

    public void alteraMedicacao(String id, ArrayList<String> medicacao) throws RemoteException;

    public Map<String, Integer> getGenderDistribution() throws RemoteException;

    public Map<String, Integer> getAgeDistribution() throws RemoteException;

    public Utente removeUtente(String id) throws RemoteException;

    public int totalUtentes() throws RemoteException;
}