package Trabalho;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface APIGestorMedicamentos extends Remote {
    public Medicamento createMedicamento(String id, String nome, String fornecedor) throws RemoteException;

    public Medicamento getMedicamento(String id) throws RemoteException;

    public List<String> procuraMedicamento(String nome) throws RemoteException;

    public void alteraFornecedor(String id, String fornecedor) throws RemoteException;

    public void alteraStock(String id, Integer stock) throws RemoteException;

    public List<String> listarMedicamentosComStock() throws RemoteException;

    public void reduzStock(String id, Integer quantidade) throws RemoteException;

    public void aumentaStock(String id, Integer quantidade) throws RemoteException;


}
