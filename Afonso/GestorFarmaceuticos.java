package trabalho;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorFarmaceuticos extends UnicastRemoteObject implements APIGestorFarmaceuticos, Serializable {

    private Map<String, Farmaceutico> farmaceuticos;

    public GestorFarmaceuticos() throws RemoteException {
        super();
        farmaceuticos = new HashMap<>();
    }

    public Farmaceutico createFarmaceutico(String nome, String telefone) {
        Farmaceutico nm = new Farmaceutico(nome,telefone);
        farmaceuticos.put(nm.getId(), nm);
        return nm;
    }

    public Farmaceutico removeFarmaceutico(String id) {
        return farmaceuticos.remove(id);
    }

    public Farmaceutico getFarmaceutico(String id) {
        return farmaceuticos.get(id);
    }

    public List<String> procuraFarmaceutico(String nome) {
        List<String> res = new ArrayList<>();
        for (Farmaceutico m : this.farmaceuticos.values()) {
            if (m.getNome().contains(nome)) {
                res.add(m.getId());
            }
        }
        return res;
    }

    public List<String> procuraFarmaceuticoTelefone(String telefone) {
        List<String> res = new ArrayList<>();
        for (Farmaceutico m : this.farmaceuticos.values()) {
            if (m.getTelefone().contains(telefone)) {
                res.add(m.getId());
            }
        }
        return res;
    }

    public void alteraTelefone(String id, String telefone) {
        Farmaceutico farmaceutico = farmaceuticos.get(id);
        if (farmaceutico != null) {
            farmaceutico.setTelefone(telefone);
        }
    }

    public int totalFarmaceuticos() {
        return farmaceuticos.size();
    }


}