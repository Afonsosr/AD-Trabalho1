package rmi.model;

import java.rmi.RemoteException;
import java.util.List;

public interface APIGestorEnfermeiro {
    public Enfermeiro createEnfermeiro(String nome, String telefone, String especialidade) throws RemoteException;

    public Enfermeiro getMedicos(String id) throws RemoteException;

    public Enfermeiro removeMedico(String id) throws RemoteException;

    public List<String> procuraEnfemeiro(String nome) throws RemoteException;

    public List<String> procuraEnfermeiroTelefone(String telefone) throws RemoteException;

    public void alteraTelefone(String id, String telefone) throws RemoteException;

}
