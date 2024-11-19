package trabalho;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorUtentes extends UnicastRemoteObject implements APIGestorUtentes, Serializable {

    private Map<String, Utente> utentes;


    public GestorUtentes() throws RemoteException {
        super();
        utentes = new HashMap<>();
    }

    public Utente createUtente(String nome, String genero, LocalDate dataNascimento,  ArrayList<String> medicacao, ArrayList<String> condicoes) {
        Utente nu = new Utente(nome, genero, dataNascimento, medicacao, condicoes);
        utentes.put(nu.getId(), nu);
        return nu;
    }

    public Utente getUtente(String id) {return utentes.get(id);}

    public Utente removeUtente(String id) {
        return utentes.remove(id);
    }

    public List<String> procuraUtente(String nome) {
        List<String> res = new ArrayList<>();
        for(Utente u : this.utentes.values()) {
            if (u.getNome().contains(nome)) {
                res.add(u.getId());
            }
        }
        return res;
    }

    public void alteraMedicacao(String id, ArrayList<String> medicacao) {
        if(utentes.containsKey(id)) {
            utentes.get(id).setMedicacao(medicacao);
        }
    }
}