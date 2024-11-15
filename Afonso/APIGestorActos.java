package trabalho;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.List;

public interface APIGestorActos extends Remote{
    public Acto createActo(String id_utente, String id_profissional, LocalDateTime data_acto, String descricao) throws RemoteException;

    public Acto removeActo(String id) throws RemoteException;

    public Acto getActo(String id) throws RemoteException;




}
