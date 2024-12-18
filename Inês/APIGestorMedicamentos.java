package trabalho;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface APIGestorMedicamentos extends Remote {
    public Medicamento createMedicamento(String nome, String fornecedor, Integer stock) throws RemoteException;

    public Medicamento getMedicamento(String id) throws RemoteException;

    public List<String> procuraMedicamento(String nome) throws RemoteException;

    public void alteraFornecedor(String id, String fornecedor) throws RemoteException;

    public List<String> listarMedicamentosComStock() throws RemoteException;

    public String reduzStock(String id, Integer quantidade)  throws RemoteException;

    public void aumentaStock(String id, Integer quantidade) throws RemoteException;

    public Medicamento removeMedicamento(String id) throws RemoteException;


}