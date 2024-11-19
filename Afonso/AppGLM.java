package trabalho;



import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class AppGLM {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {

            APIGestorEnfermeiros enfer = null;
            enfer = (APIGestorEnfermeiros)Naming.lookup("rmi://localhost:50001/GE");
            APIGestorFarmaceuticos farma = null;
            farma = (APIGestorFarmaceuticos) Naming.lookup("rmi://localhost:50001/GF");
            APIGestorMedicos medic = null;
            medic = (APIGestorMedicos)Naming.lookup("rmi://localhost:50001/GM");
            APIGestorUtentes utent = null;
            utent = (APIGestorUtentes) Naming.lookup("rmi://localhost:50001/GUT");
            APIGestorMedicamentos meds = null;
            meds = (APIGestorMedicamentos) Naming.lookup("rmi://localhost:50001/GMED");

            // Cria alguns medicamentos
            meds.createMedicamento("Paracetamol", "FornecedorA", 50);
            meds.createMedicamento("Ibuprofeno", "FornecedorD", 40);
            meds.createMedicamento("Vitamina C", "FornecedorA", 110);
            meds.createMedicamento("Vitamina C", "FornecedorE", 450);
            meds.createMedicamento("Antibiótico", "FornecedorB", 10);
            meds.createMedicamento("Strepsils", "FornecedorD", 100);



            System.out.println("------Login------");
            System.out.println("Utilizador: ");
            String log = scanner.nextLine();
            System.out.println("Password: ");
            String pass = scanner.nextLine();

            if (Objects.equals(log, "gestor") && Objects.equals(pass, "gestor")) {


                System.out.println("1- Adicionar Novo Medicamento");
                System.out.println("2- Procurar Medicamento ID");
                System.out.println("3- Procurar Medicamento Nome");
                System.out.println("4- Alterar Fornecedor");
                System.out.println("5- Listar Medicamentos e Stock");
                System.out.println("6- Aumentar o Stock de um Medicamento");
                System.out.println("7- Informar Consumo de Medicamento");
                System.out.println("8- Remover Medicamento");
                System.out.println("0- Sair");
                int menu = scanner.nextInt();
                scanner.nextLine();

                while (menu != 0) {

                    if (menu == 1) {
                        // Criar um novo medicamento
                        System.out.print("Nome do medicamento: ");
                        String nome = scanner.nextLine();
                        System.out.print("Fornecedor: ");
                        String fornecedor = scanner.nextLine();
                        System.out.print("Quantidade de stock: ");
                        int stock = scanner.nextInt();
                        meds.createMedicamento(nome, fornecedor, stock);
                        System.out.println("Medicamento adicionado com sucesso!");


                    } else if (menu == 2) {
                        // Procurar medicamento por ID
                        System.out.print("ID do medicamento: ");
                        String id = scanner.nextLine();
                        Medicamento medicamento = meds.getMedicamento(String.valueOf(id));

                        if (medicamento != null) {
                            System.out.println("Medicamento encontrado:");
                            System.out.println("Nome: " + medicamento.getNome());
                            System.out.println("Fornecedor: " + medicamento.getFornecedor());
                            System.out.println("Stock: " + medicamento.getStock());
                        } else {
                            System.out.println("Medicamento com ID " + id + " não encontrado.");
                        }


                    } else if (menu == 3) {
                        // Procurar por nome
                        System.out.print("Nome do medicamento a procurar: ");
                        String nomeMedicamento = scanner.nextLine();
                        List<String> idsMedicamentos = meds.procuraMedicamento(nomeMedicamento);

                        if (!idsMedicamentos.isEmpty()) {
                            System.out.println("Medicamentos encontrados com o nome '" + nomeMedicamento + "':");
                            for (String idMedicamento : idsMedicamentos) {
                                System.out.println("ID: " + idMedicamento);
                            }
                        } else {
                            System.out.println("Nenhum medicamento encontrado com o nome '" + nomeMedicamento + "'.");
                        }


                    } else if (menu == 4) {

                        System.out.print("ID do medicamento a alterar o fornecedor: ");
                        String idMedicamento = scanner.nextLine();

                        System.out.print("Novo nome do fornecedor: ");
                        String novoFornecedor = scanner.nextLine();

                        meds.alteraFornecedor(idMedicamento, novoFornecedor);
                        System.out.println("Fornecedor do medicamento com ID " + idMedicamento + " alterado para " + novoFornecedor);

                    } else if (menu == 5) {
                        // Listar todos os medicamentos com o stock de cada um
                        System.out.println("Lista de Medicamentos e Respetivos Stocks:");
                        List<String> listaMedicamentos = meds.listarMedicamentosComStock();
                        for (String info : listaMedicamentos) {
                            System.out.println(info);
                        }
                    } else if (menu == 6) {
                        //Aumententar a quantidade de um medicamento
                        System.out.print("ID do medicamento: ");
                        String idMedicamento = scanner.nextLine();
                        System.out.print("Quantidade a aumentar: ");
                        int quantidadeAumentar = scanner.nextInt();
                        meds.aumentaStock(idMedicamento, quantidadeAumentar);
                        System.out.println("Stock do medicamento aumentado com sucesso!");

                    } else if (menu == 7) {

                        // Reduzir stock de um medicamento
                        System.out.print("ID do medicamento: ");
                        String idMedicamentoReduzir = scanner.nextLine();
                        System.out.print("Quantidade consumida: ");
                        int quantidadeReduzir = scanner.nextInt();
                        meds.reduzStock(idMedicamentoReduzir, quantidadeReduzir);
                        System.out.println("Stock do medicamento reduzido com sucesso!");
                    } else if (menu == 8) {
                        System.out.print("ID do medicamento a eliminar: ");
                        String idMedicamento = scanner.nextLine();
                        meds.removeMedicamento(idMedicamento);
                        System.out.print("Medicamento eliminado com sucesso!");


                    }


                    System.out.println("1- Adicionar Novo Medicamento");
                    System.out.println("2- Procurar Medicamento ID");
                    System.out.println("3- Procurar Medicamento Nome");
                    System.out.println("4- Alterar Fornecedor");
                    System.out.println("5- Listar Medicamentos e Stock");
                    System.out.println("6- Aumentar o Stock de um Medicamento");
                    System.out.println("7- Informar Consumo de Medicamento");
                    System.out.println("8- Remover Medicamento");
                    System.out.println("0- Sair");
                    menu = scanner.nextInt();
                    scanner.nextLine();



                }
                System.out.println("GLM encerrado com sucesso!");
            }
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }
}