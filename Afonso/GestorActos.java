package trabalho;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorActos extends UnicastRemoteObject implements APIGestorActos, Serializable {
    private Map<String, Acto> actos;


    public GestorActos() throws RemoteException {
        super();
        actos = new HashMap<>();
    }

    public Acto createActo(String id_utente, String id_profissional, LocalDateTime data_acto, String descricao) {
        Acto na = new Acto(id_utente,id_profissional,data_acto,descricao);
        actos.put(na.getId(), na);
        return na;
    }

    public Acto removeActo(String id) {
        return actos.remove(id);
    }

    public Acto getActo(String id){
        return actos.get(id);
    }


    public int totalActos() {
        return actos.size();
    }
}
