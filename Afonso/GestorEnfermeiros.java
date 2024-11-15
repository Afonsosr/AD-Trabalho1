package trabalho;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GestorEnfermeiros extends UnicastRemoteObject implements APIGestorEnfermeiros, Serializable {

    private Map<String, Enfermeiro> enfermeiros;

    public GestorEnfermeiros() throws RemoteException {
        super();
        enfermeiros = new HashMap<>();
    }

    public Enfermeiro createEnfermeiro(String nome, String telefone, String especialidade) {
        Enfermeiro nm = new Enfermeiro(nome,telefone,especialidade);
        enfermeiros.put(nm.getId(), nm);
        return nm;
    }

    public Enfermeiro removeEnfermeiro(String id) {
        return enfermeiros.remove(id);
    }


    public List<String> procuraEnfermeiro(String nome) throws RemoteException {
        return List.of();
    }

    public Enfermeiro getEnfermeiro(String id) {
        return enfermeiros.get(id);
    }

    public List<String> procuraEnfemeiro(String nome) {
        List<String> res = new ArrayList<>();
        for (Enfermeiro m : this.enfermeiros.values()) {
            if (m.getNome().contains(nome)) {
                res.add(m.getId());
            }
        }
        return res;
    }

    public List<String> procuraEnfermeiroTelefone(String telefone) {
        List<String> res = new ArrayList<>();
        for (Enfermeiro m : this.enfermeiros.values()) {
            if (m.getTelefone().contains(telefone)) {
                res.add(m.getId());
            }
        }
        return res;
    }

    public void alteraTelefone(String id, String telefone) {
        Enfermeiro enfermeiro = enfermeiros.get(id);
        if (enfermeiro != null) {
            enfermeiro.setTelefone(telefone);
        }
    }

    public int totalEnfermeiros() {
        return enfermeiros.size();
    }
}