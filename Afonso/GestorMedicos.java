package trabalho;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorMedicos extends UnicastRemoteObject implements APIGestorMedicos, Serializable {

    private Map<String, Medico> medicos;


    public GestorMedicos() throws RemoteException {
        super();
        medicos = new HashMap<>();
    }

    public Medico createMedico(String nome, String telefone, String especialidade) {
        Medico nm = new Medico(nome,telefone, especialidade);
        medicos.put(nm.getId(), nm);
        return nm;
    }

    public Medico removeMedico(String id) {
        return medicos.remove(id);
    }

    public Medico getMedico(String id){
        return medicos.get(id);
    }

    public List<String> procuraMedico(String nome){
        List<String> res = new ArrayList<>();
        for (Medico m : this.medicos.values()) {
            if (m.getNome().contains(nome)) {
                res.add(m.getId());
            }
        }
        return res;
    }


    public void alteraTelefone(String id, String telefone){
        if (medicos.containsKey(id)) {
            medicos.get(id).setTelefone(telefone);
        }
    }

    public int totalMedicos() {
        return medicos.size();
    }

    public List<String> procuraEspecialidade(String especialidade){
        List<String> res = new ArrayList<>();
        for (Medico m : this.medicos.values()) {
            if (m.getEspecialidade().contains(especialidade)) {
                res.add(m.getId());
            }
        }
        return res;
    }

}