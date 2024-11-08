package rmi.model;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface APIGestorMedicos extends Remote {
    public Medicos createMedico(String nome, String telefone, String especialidade) throws RemoteException;

    public Medicos getMedicos(String id) throws RemoteException;

    public Medico removeMedico(String nome) throws RemoteException;

    public List<String> procuraMedico(String nome) throws RemoteException;

    public void alteraTelefone(String id, String telefone) throws RemoteException;

}
