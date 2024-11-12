package Trabalho;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface APIGestorUtentes extends Remote {
    public Utente createUtente(String nome, String genero, LocalDate dataNascimento, ArrayList<String> medicacao) throws RemoteException;

    public Utente getUtente(String id) throws RemoteException;

    public List<String> procuraUtente(String nome) throws RemoteException;

    public void alteraMedicacao(String id, ArrayList<String> medicacao) throws RemoteException;

}
