package trabalho;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorMedicamentos extends UnicastRemoteObject implements APIGestorMedicamentos, Serializable {

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

    // Método para reduzir o stock de um medicamento - quando uma quantidade de medicamento é consumida reduz o stock
    public void reduzStock(String id, Integer quantidade) {
        if (medicamentos.containsKey(id)) {
            Medicamento med = medicamentos.get(id);
            int novoStock = med.getStock() - quantidade;

            if (novoStock >= 0) {
                med.setStock(novoStock);

                // Alerta caso o estoque fique abaixo de 10
                if (novoStock < 10) {
                    System.out.println("O stock do medicamento está abaixo de 10!");
                }
            } else {
                System.out.println("Quantidade insuficiente em stock.");
            }
        } else {
            System.out.println("Medicamento não encontrado.");
        }
    }

    // Método para listar todos os medicamentos e o stock de cada um
    public List<String> listarMedicamentosComStock() {
        List<String> lista = new ArrayList<>();
        for (Medicamento medicamento : medicamentos.values()) {
            String info = "ID: " + medicamento.getId() + ", Nome: " + medicamento.getNome() +
                    ", Fornecedor: " + medicamento.getFornecedor() +
                    ", Stock: " + medicamento.getStock();
            lista.add(info);
        }
        return lista;
    }

    // Método para remover um medicamento
    public boolean removeMedicamento(String id) {
        if (medicamentos.containsKey(id)) {
            medicamentos.remove(id);
            return true; // Indica que o medicamento foi removido com sucesso
        } else {
            System.out.println("Erro: Medicamento com ID " + id + " não encontrado.");
            return false; // Indica que o medicamento não foi encontrado
        }
    }

}