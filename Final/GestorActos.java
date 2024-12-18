package trabalho;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
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

    public Acto createActo(String id_utente, String id_profissional, LocalDate data_acto, String descricao) {
        Acto na = new Acto(id_utente,id_profissional,data_acto,descricao);
        actos.put(na.getId(), na);
        return na;
    }


    public int totalActos() {
        return actos.size();
    }
}
