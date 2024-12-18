package Trabalho;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorMedicamentos extends UnicastRemoteObject implements Serializable {

    private Map<String, Medicamento> medicamentos;

    public GestorMedicamentos() throws RemoteException {
        super();
        medicamentos = new HashMap<>();
    }

    // Criação de medicamento com ID gerado automaticamente
    public Medicamento createMedicamento(String nome, String fornecedor, Integer stock) {
        Medicamento nm = new Medicamento(nome, fornecedor, stock);
        medicamentos.put(nm.getId(), nm);
        return nm;
    }

    public Medicamento getMedicamento(String id) {
        return medicamentos.get(id);
    }

    public List<String> procuraMedicamento(String nome) {
        List<String> res = new ArrayList<>();
        for (Medicamento m : this.medicamentos.values()) {
            if (m.getNome().contains(nome)) {
                res.add(m.getId());
            }
        }
        return res;
    }

    public void alteraFornecedor(String id, String fornecedor) {
        if (medicamentos.containsKey(id)) {
            medicamentos.get(id).setFornecedor(fornecedor);
        }
    }

    // Método para aumentar o stock de um medicamento
    public void aumentaStock(String id, Integer quantidade) {
        if (medicamentos.containsKey(id)) {
            Medicamento med = medicamentos.get(id);
            med.setStock(med.getStock() + quantidade);
        }
    }

    // Método para reduzir o stock de um medicamento (para consumo/uso)
    public void reduzStock(String id, Integer quantidade) {
        if (medicamentos.containsKey(id)) {
            Medicamento med = medicamentos.get(id);
            int novoStock = med.getStock() - quantidade;
            if (novoStock >= 0) {
                med.setStock(novoStock);
            } else {
                System.out.println("Erro: Quantidade insuficiente em estoque.");
            }
        }
    }
}




}
