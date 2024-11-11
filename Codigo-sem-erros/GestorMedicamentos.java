package Trabalho;

import javax.print.attribute.standard.Media;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorMedicamentos extends UnicastRemoteObject implements Serializable{

    private Map<String, Medicamento> medicamentos;

    public GestorMedicamentos() throws RemoteException {
        super();
        medicamentos = new HashMap<>();
    }

    public Medicamento createMedicamento(String id, String nome, String fornecedor) {
        Medicamento nm = new Medicamento(nome, fornecedor);
        medicamentos.put(nm.getId(), nm);
        return nm;
    }

    public Medicamento getMedicamento(String id) {return medicamentos.get(id);}

    public List<String> procuraMedicamento(String nome) {
        List<String> res = new ArrayList<>();
        for(Medicamento m : this.medicamentos.values()) {
            if (m.getNome().contains(nome)) {
                res.add(m.getId());
            }
        }
        return res;
    }

    public void alteraFornecedor(String id, String fornecedor) {
        if(medicamentos.containsKey(id)) {
            medicamentos.get(id).setFornecedor(fornecedor);
        }
    }

    public void alteraStock(String id, Integer stock) {
        if(medicamentos.containsKey(id)) {                         // aqui usamos tanto quando há dispensa/uso como quando ha aquisicao
            medicamentos.get(id).setStock(stock);
        }
    }



}
