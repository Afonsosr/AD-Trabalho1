package Trabalho;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;



public class AppGLM {
    public static void main(String[] args) {
        try {
            GestorMedicamentos gestor = (GestorMedicamentos) Naming.lookup("rmi://localhost:50001/GestorMedicamentos");

            APIGestorEnfermeiro enfer = (APIGestorEnfermeiro) Naming.lookup("rmi://localhost:50001/GE");
            APIGestorFarmaceuticos farma = (APIGestorFarmaceuticos) Naming.lookup("rmi://localhost:50001/GF");
            APIGestorMedicos medic = (APIGestorMedicos) Naming.lookup("rmi://localhost:50001/GM");
            APIGestorUtentes utent = (APIGestorUtentes) Naming.lookup("rmi://localhost:50001/GUT");

            // Cria alguns medicamentos
            gestor.createMedicamento("Paracetamol", "FornecedorA", 50);
            gestor.createMedicamento("Ibuprofeno", "FornecedorD", 40);
            gestor.createMedicamento("Vitamina C", "FornecedorA", 110);
            gestor.createMedicamento("Vitamina C", "FornecedorE", 450);
            gestor.createMedicamento("Antibiótico", "FornecedorB", 10);
            gestor.createMedicamento("Strepsils", "FornecedorD", 100);

            Scanner scanner = new Scanner(System.in);

            System.out.println("1- Adicionar Novo Medicamento");
            System.out.println("2- Procurar Medicamento ID");
            System.out.println("3- Procurar Medicamento Nome");
            System.out.println("4- Alterar Fornecedor");
            System.out.println("5- Listar Medicamentos e Stock");
            System.out.println("6- Aumentar o Stock de um Medicamento");
            System.out.println("7- Informar Consumo de Medicamento");
            int menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1: // Criar um novo medicamento
                    System.out.print("Nome do medicamento: ");
                    String nome = scanner.nextLine();
                    System.out.print("Fornecedor: ");
                    String fornecedor = scanner.nextLine();
                    System.out.print("Quantidade de stock: ");
                    int stock = scanner.nextInt();
                    gestor.createMedicamento(nome, fornecedor, stock);
                    System.out.println("Medicamento adicionado com sucesso!");
                    break;

                case 2: // Procurar medicamento por ID
                    System.out.print("ID do medicamento: ");
                    String id = scanner.nextLine();
                    Medicamento medicamento = gestor.getMedicamento(String.valueOf(id));

                    if (medicamento != null) {
                        System.out.println("Medicamento encontrado:");
                        System.out.println("Nome: " + medicamento.getNome());
                        System.out.println("Fornecedor: " + medicamento.getFornecedor());
                        System.out.println("Stock: " + medicamento.getStock());
                    } else {
                        System.out.println("Medicamento com ID " + id + " não encontrado.");
                    }
                    break;

                case 3: // Procurar por nome
                    System.out.print("Nome do medicamento a procurar: ");
                    String nomeMedicamento = scanner.nextLine();
                    List<String> idsMedicamentos = gestor.procuraMedicamento(nomeMedicamento);

                    if (!idsMedicamentos.isEmpty()) {
                        System.out.println("Medicamentos encontrados com o nome '" + nomeMedicamento + "':");
                        for (String idMedicamento : idsMedicamentos) {
                            System.out.println("ID: " + idMedicamento);
                        }
                    } else {
                        System.out.println("Nenhum medicamento encontrado com o nome '" + nomeMedicamento + "'.");
                    }
                    break;


                case 4: //Alterar o fornecedor
                    System.out.print("ID do medicamento a alterar o fornecedor: ");
                    String idMedicamento = scanner.nextLine();

                    System.out.print("Novo nome do fornecedor: ");
                    String novoFornecedor = scanner.nextLine();

                    gestor.alteraFornecedor(idMedicamento, novoFornecedor);
                    System.out.println("Fornecedor do medicamento com ID " + idMedicamento + " alterado para " + novoFornecedor);
                    break;

                case 5:    // Listar todos os medicamentos com o stock de cada um
                    System.out.println("Lista de Medicamentos e Respetivos Stocks:");
                    List<String> listaMedicamentos = gestor.listarMedicamentosComStock();
                    for (String info : listaMedicamentos) {
                        System.out.println(info);
                    }

                case 6: //Aumententar a quantidade de um medicamento
                    System.out.print("ID do medicamento: ");
                    idMedicamento = scanner.nextLine();
                    System.out.print("Quantidade a aumentar: ");
                    int quantidadeAumentar = scanner.nextInt();
                    gestor.aumentaStock(idMedicamento, quantidadeAumentar);
                    System.out.println("Stock do medicamento aumentado com sucesso!");
                    break;

                case 7:  // Reduzir stock de um medicamento
                    System.out.print("ID do medicamento: ");
                    String idMedicamentoReduzir = scanner.nextLine();
                    System.out.print("Quantidade consumida: ");
                    int quantidadeReduzir = scanner.nextInt();
                    gestor.reduzStock(idMedicamentoReduzir, quantidadeReduzir);
                    System.out.println("Stock do medicamento reduzido com sucesso!");
                    break;


            }


        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
