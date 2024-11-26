package trabalho;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.*;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;



public class AppGPC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {


            APIGestorEnfermeiros enfer1 = null;
            enfer1 = (APIGestorEnfermeiros)Naming.lookup("rmi://localhost:50001/GE");
            APIGestorFarmaceuticos farma = null;
            farma = (APIGestorFarmaceuticos) Naming.lookup("rmi://localhost:50001/GF");
            APIGestorMedicos medic = null;
            medic = (APIGestorMedicos)Naming.lookup("rmi://localhost:50001/GM");
            APIGestorUtentes utent = null;
            utent = (APIGestorUtentes) Naming.lookup("rmi://localhost:50001/GUT");
            APIGestorMedicamentos meds = null;
            meds = (APIGestorMedicamentos) Naming.lookup("rmi://localhost:50001/GMED");
            APIGestorActos acts = null;
            acts = (APIGestorActos) Naming.lookup("rmi://localhost:50001/GACT");


            System.out.println("------Login------");
            System.out.println("Utilizador: ");
            String log = scanner.nextLine();
            System.out.println("Password: ");
            String pass = scanner.nextLine();


            if (Objects.equals(log, "med") && Objects.equals(pass, "med")) {
                System.out.println("---------- MENU MÉDICO ----------");
                System.out.println("1- Procurar Enfermeiro Nome");
                System.out.println("2- Procurar Enfermeiro Telefone");
                System.out.println("3- Procurar Farmaceutico Nome");
                System.out.println("4- Procurar Utente Nome");
                System.out.println("5- Administração de medicamento");
                
                System.out.println("0- Sair");
                System.out.print("Escolha uma opção: ");
                int menu = scanner.nextInt();
                scanner.nextLine();
                while (menu != 0) {
                    if (menu == 1) {
                        System.out.println("Por que nome deseja procurar? :");
                        String nomeEn = scanner.nextLine();
                        List<String> l = enfer1.procuraEnfermeiro(nomeEn);
                        if (!l.isEmpty()) {
                            System.out.println("Enfermeiros encontrados com o nome '" + nomeEn + "':");
                            for (String ide : l) {
                                System.out.println("ID: " + ide);
                            }
                        } else {
                            System.out.println("Nenhum enfermeiro encontrado com o nome '" + nomeEn + "'.");
                        }
                    } else if (menu == 2) {
                        System.out.println("Por que contacto deseja procurar? :");
                        String telefone = scanner.nextLine();
                        List<String> l = enfer1.procuraEnfermeiroTelefone(telefone);
                        if (l.isEmpty()) {
                            System.out.println("Não foram encontrados enfermeiros com o contacto fornecido.");
                        } else {
                            for (String id : l) {
                                System.out.println("ID: " + id);
                            }
                        }
                    } else if (menu == 3) {
                        System.out.println("Por que nome deseja procurar? :");
                        String nome = scanner.nextLine();
                        List<String> l = farma.procuraFarmaceutico(nome);
                        if (l.isEmpty()) {
                            System.out.println("Não foram encontrados farmaceuticos com o nome fornecido.");
                        } else {
                            for (String id : l) {
                                System.out.println("ID: " + id);
                            }
                        }
                    } else if (menu == 4) {
                        System.out.println("Por que nome deseja procurar? :");
                        String nome = scanner.nextLine();
                        List<String> l = utent.procuraUtente(nome);
                        if (!l.isEmpty()) {
                            System.out.println("Utentes encontrados para " + nome + ":");
                            for (String id : l) {
                                Utente utente = utent.getUtente(id);
                                System.out.println("Nome: " + utente.getNome());
                                System.out.println("Género: " + utente.getGenero());
                                System.out.println("Data de Nascimento: " + utente.getDataNascimento());
                                System.out.println("Medicação: " + String.join(", ", utente.getMedicacao()));
                                System.out.println("Condições: " + String.join(", ", utente.getCondicoes()));
                            }
                        }
                    } else if (menu == 5) {
                        System.out.print("ID do medicamento: ");
                        String idMedicamento = scanner.nextLine();
                        System.out.print("Quantidade a administrar(valor de diminuição de stock): ");
                        int quantidadeDiminuir = scanner.nextInt();
                        meds.reduzStock(idMedicamento, quantidadeDiminuir);
                        System.out.println("Atualização efetuada, tem autorização para utilizar medicamento!");
                    } else if (menu == 6) {
                        System.out.print("ID do utente: ");
                        String idut = scanner.nextLine();
                        System.out.print("ID do profissional: ");
                        String idprof = scanner.nextLine();
                        System.out.print("Descrição: ");
                        String desc = scanner.nextLine();
                        System.out.print("Ano do acto: ");
                        Integer year = scanner.nextInt();
                        System.out.print("Mês do acto: ");
                        Integer month = scanner.nextInt();
                        System.out.print("Dia do acto: ");
                        Integer day = scanner.nextInt();


                        LocalDate data = LocalDate.of(year, month, day);

                        acts.createActo(idut, idprof,data, desc);
                        System.out.println("Acto médico realizado com sucesso!");
                    }
                    System.out.println("---------- MENU MÉDICO ----------");
                    System.out.println("1- Procurar Enfermeiro Nome");
                    System.out.println("2- Procurar Enfermeiro Telefone");
                    System.out.println("3- Procurar Farmaceutico Nome");
                    System.out.println("4- Procurar Utente Nome");
                    System.out.println("5- Administração de medicamento");
                    System.out.println("6- Realizar Acto Médico");
                    System.out.println("0- Sair");
                    System.out.print("Escolha uma opção: ");
                    menu = scanner.nextInt();
                    scanner.nextLine();
                }

            }
            else if (Objects.equals(log, "enf") && Objects.equals(pass, "enf")) {
                System.out.println("-------- MENU ENFERMEIRO --------");
                System.out.println("1- Procurar Médico Nome");
                System.out.println("2- Procurar Medicamento");
                System.out.println("3- Utilizar Medicamento");
                System.out.println("4- Procurar Utente Nome");
                System.out.println("5- Listar Médicos");
                System.out.println("0- Sair");
                System.out.print("Escolha uma opção: ");
                int menu = scanner.nextInt();
                scanner.nextLine();
                while (menu != 0) {
                    if (menu == 1) {
                        System.out.println("Por que nome deseja procurar? :");
                        String nome = scanner.nextLine();
                        List<String> l = medic.procuraMedico(nome);

                        if (!l.isEmpty()) {
                            System.out.println("Médicos encontrados com o nome '" + nome + "':");
                            for (String id : l) {
                                System.out.println("ID: " + id);
                            }
                        } else {
                            System.out.println("Nenhum médico encontrado com o nome '" + nome + "'.");
                        }
                    } else if (menu == 2) {
                        System.out.println("Por que medicamento deseja procurar? :");
                        String nome = scanner.nextLine();
                        List<String> l = meds.procuraMedicamento(nome);
                        if (!l.isEmpty()) {
                            System.out.println("Medicamentos encontrados com o nome '" + nome + "':");
                            for (String id : l) {
                                System.out.println("ID: " + id);
                            }
                        } else {
                            System.out.println("Nenhum medicamento encontrado com o nome '" + nome + "'.");
                        }
                    } else if (menu == 3) {
                        System.out.print("ID do medicamento: ");
                        String idMedicamentoReduzir = scanner.nextLine();
                        System.out.print("Quantidade consumida: ");
                        int quantidadeReduzir = scanner.nextInt();
                        meds.reduzStock(idMedicamentoReduzir, quantidadeReduzir);
                        System.out.println("Permissão concedida, pode utilizar medicamento!");
                    } else if (menu == 4) {
                        System.out.println("Por que nome deseja procurar? :");
                        String nome = scanner.nextLine();
                        List<String> l = utent.procuraUtente(nome);
                        if (!l.isEmpty()) {
                            System.out.println("Utentes encontrados para " + nome + ":");
                            for (String id : l) {
                                Utente utente = utent.getUtente(id);
                                System.out.println("Nome: " + utente.getNome());
                                System.out.println("Género: " + utente.getGenero());
                                System.out.println("Data de Nascimento: " + utente.getDataNascimento());
                                System.out.println("Medicação: " + String.join(", ", utente.getMedicacao()));
                                System.out.println("Condições: " + String.join(", ", utente.getCondicoes()));
                            }
                        } else {
                            System.out.println("Nenhum utente encontrado com o nome '" + nome + "'.");
                        }
                    } else if (menu == 5) {
                        System.out.println("Lista de Medicos:");
                        List<String> listaMedicos = medic.listarMedicos();
                        for (String info : listaMedicos) {
                            System.out.println(info);
                        }
                    }

                    System.out.println("-------- MENU ENFERMEIRO --------");
                    System.out.println("1- Procurar Médico Nome");
                    System.out.println("2- Procurar Medicamento");
                    System.out.println("3- Utilizar Medicamento");
                    System.out.println("4- Procurar Utente Nome");
                    System.out.println("5- Listar Médicos");
                    System.out.println("0- Sair");
                    System.out.print("Escolha uma opção: ");
                    menu = scanner.nextInt();
                    scanner.nextLine();
                }
            }
            else if (Objects.equals(log, "ut") && Objects.equals(pass, "ut")) {
                System.out.println("---------- MENU UTENTE ----------");
                System.out.println("1- Procurar Medico Nome");
                System.out.println("2- Procurar por Especialidade");
                System.out.println("3- Procurar Farmaceutico Nome");
                System.out.println("4- Procurar Farmaceutico Telefone");
                System.out.println("5- Procurar Utente Nome");
                System.out.println("0- Sair");
                System.out.print("Escolha uma opção: ");
                int menu = scanner.nextInt();
                scanner.nextLine();

                while (menu != 0) {
                    if (menu == 1) {
                        System.out.println("Por que nome deseja procurar? :");
                        String nome = scanner.nextLine();
                        List<String> l = medic.procuraMedico(nome);

                        if (!l.isEmpty()) {
                            System.out.println("Médicos encontrados com o nome '" + nome + "':");
                            for (String id : l) {
                                System.out.println("ID: " + id);
                            }
                        } else {
                            System.out.println("Nenhum médico encontrado com o nome '" + nome + "'.");}

                    } else if (menu == 2) {
                        System.out.println("Por que especialidade deseja procurar? :");
                        String esp = scanner.nextLine();
                        List<String> l = medic.procuraEspecialidade(esp);           // por bonito
                        if (!l.isEmpty()) {
                            System.out.println("Médicos encontrados para " + esp + "':");
                            for (String id : l) {
                                System.out.println("ID: " + id);
                            }
                        } else {
                            System.out.println("Nenhum médico encontrado para a especialidade: '" + esp + "'.");}
                    } else if (menu == 3) {
                        System.out.println("Por que nome deseja procurar? :");
                        String nome = scanner.nextLine();
                        List<String> l = farma.procuraFarmaceutico(nome);
                        if (!l.isEmpty()) {
                            System.out.println("Farmaceuticos encontrados com o nome '" + nome + "':");
                            for (String id : l) {
                                System.out.println("ID: " + id);
                            }
                        } else {
                            System.out.println("Nenhum farmaceutico encontrado com o nome '" + nome + "'.");}
                    } else if (menu == 4) {
                        System.out.println("Por que contacto deseja procurar? :");
                        String telefone = scanner.nextLine();
                        List<String> l = farma.procuraFarmaceuticoTelefone(telefone);    // por bonito
                        if (!l.isEmpty()) {
                            System.out.println("Farmaceuticos encontrados com o telefone '" + telefone + "':");
                            for (String id : l) {
                                System.out.println("ID: " + id);
                            }
                        } else {
                            System.out.println("Nenhum farmaceutico encontrado com o telefone '" + telefone + "'.");}
                    } else if (menu == 5) {
                        System.out.println("Por que nome deseja procurar? :");
                        String nome = scanner.nextLine();
                        List<String> l = utent.procuraUtente(nome);
                        if (!l.isEmpty()) {
                            System.out.println("Utentes encontrados para " + nome + ":");
                            for (String id : l) {
                                Utente utente = utent.getUtente(id);
                                System.out.println("Nome: " + utente.getNome());
                                System.out.println("Género: " + utente.getGenero());
                                System.out.println("Data de Nascimento: " + utente.getDataNascimento());
                                System.out.println("Medicação: " + String.join(", ", utente.getMedicacao()));
                                System.out.println("Condições: " + String.join(", ", utente.getCondicoes()));
                            }
                        } else {
                            System.out.println("Nenhum utente encontrado.");
                        }
                    }
                    System.out.println("---------- MENU UTENTE ----------");
                    System.out.println("1- Procurar Medico Nome");
                    System.out.println("2- Procurar por Especialidade");
                    System.out.println("3- Procurar Farmaceutico Nome");
                    System.out.println("4- Procurar Farmaceutico Telefone");
                    System.out.println("5- Procurar Utente Nome");
                    System.out.println("0- Sair");
                    System.out.print("Escolha uma opção: ");
                    menu = scanner.nextInt();
                    scanner.nextLine();
                }
            }
            else if (Objects.equals(log, "gestor") && Objects.equals(pass, "gestor")) {
                System.out.println("-------- MENU ESTATÍSTICO --------");
                System.out.println("1- Estatísticas gerais");
                System.out.println("2- Estatísticas dos utentes");
                System.out.println("3- Estatísticas de especialidades médicos");
                System.out.println("4. Estatísticas de especialidades enfermeiros");
                System.out.println("0- Sair");
                System.out.print("Escolha uma opção: ");
                int menu = scanner.nextInt();
                scanner.nextLine();

                while (menu != 0) {
                    if (menu == 1) {
                        System.out.println("\n--- Estatísticas Gerais ---");
                        System.out.println("Número total de utentes: " + utent.totalUtentes());
                        System.out.println("Número total de médicos: " + medic.totalMedicos());
                        System.out.println("Número total de enfermeiros: " + enfer1.totalEnfermeiros());
                        System.out.println("Número total de farmacêuticos: " + farma.totalFarmaceuticos());
                        System.out.println("Número total de atos médicos: " + acts.totalActos());
                    } else if (menu == 2) {
                        System.out.println("\n--- Estatísticas dos Utentes ---");

                        System.out.println("Distribuição etária:");
                        Map<String, Integer> ageDistribution = utent.getAgeDistribution();
                        for (Map.Entry<String, Integer> entry : ageDistribution.entrySet()) {
                            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
                        }
                        System.out.println("Número de utentes por género:");
                        Map<String, Integer> genderDistribution = utent.getGenderDistribution();
                        for (Map.Entry<String, Integer> entry : genderDistribution.entrySet()) {
                            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
                        }
                    } else if (menu == 3) {
                        System.out.println("Distribuição de médicos por especialidade:");
                        Map<String, Integer> especialidadesmed = medic.distribuicaoPorEspecialidades();
                        especialidadesmed.forEach((especialidade, count) ->
                                System.out.println(especialidade + ": " + count)
                        );
                    } else if (menu == 4) {
                        System.out.println("Distribuição de enfermeiros por especialidade:");
                        Map<String, Integer> especialidadesEnfermeiros = enfer1.distribuicaoPorEspecialidades();
                        especialidadesEnfermeiros.forEach((especialidade, count) ->
                                System.out.println(especialidade + ": " + count)
                        );
                    }
                    System.out.println("-------- MENU ESTATÍSTICO --------");
                    System.out.println("1- Estatísticas gerais");
                    System.out.println("2- Estatísticas dos utentes");
                    System.out.println("3- Estatísticas de especialidades médicos");
                    System.out.println("4. Estatísticas de especialidades enfermeiros");
                    System.out.println("0- Sair");
                    System.out.print("Escolha uma opção: ");
                    menu = scanner.nextInt();
                    scanner.nextLine();
                }
            }
            System.out.print("GPC encerrado com sucesso!");

        }catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }
}



