package trabalho;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
//import java.time.LocalDateTime;
import java.util.ArrayList;


//******************************************
//******************************************

// FALTA CRIAR UM MENU E FUNCOES PARA AS ESTATÍSTICAS

//******************************************
//******************************************





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




            // Criar 5 enfermeiros
            enfer1.createEnfermeiro("Ana Silva", "912345678", "Pediatria");
            enfer1.createEnfermeiro("Carlos Santos", "913456789", "Urgências");
            enfer1.createEnfermeiro("Maria Oliveira", "914567890", "Oncologia");
            enfer1.createEnfermeiro("João Almeida", "915678901", "Cardiologia");
            enfer1.createEnfermeiro("Sofia Costa", "916789012", "Neurologia");




            // Criar 5 farmacêuticos
            farma.createFarmaceutico("Pedro Rodrigues", "917890123");
            farma.createFarmaceutico("Rita Ferreira", "918901234");
            farma.createFarmaceutico("Tiago Sousa", "919012345");
            farma.createFarmaceutico("Helena Martins", "920123456");
            farma.createFarmaceutico("Bruno Mendes", "921234567");

            // Criar 5 médicos
            medic.createMedico("Luís Pereira", "922345678", "Cirurgia");
            medic.createMedico("Sara Fonseca", "923456789", "Dermatologia");
            medic.createMedico("Fernando Costa", "924567890", "Ortopedia");
            medic.createMedico("Clara Lopes", "925678901", "Psiquiatria");
            medic.createMedico("Ricardo Monteiro", "926789012", "Ginecologia");




                                            // *******************************************
            // Criar 5 utentes              // falta arranjar aqui as coisas das datas
                                            // *******************************************

            ArrayList<String> medicacao1 = new ArrayList<>();
            medicacao1.add("Paracetamol");
            medicacao1.add("Ibuprofeno");
            medicacao1.add("Strepsils");
            ArrayList<String> condicoes1 = new ArrayList<>();
            condicoes1.add("Diabetes");
            condicoes1.add("Hipertensão");
            utent.createUtente("Joana Neves", "Feminino", LocalDate.of(1985,3,14), medicacao1, condicoes1);

            ArrayList<String> medicacao2 = new ArrayList<>(); // Sem medicamentos
            ArrayList<String> condicoes2 = new ArrayList<>();
            condicoes2.add("Alergia a pólen");
            condicoes2.add("Asma");
            utent.createUtente("Miguel Nunes", "Masculino", LocalDate.of(1990, 7, 22), medicacao2, condicoes2);

            ArrayList<String> medicacao3 = new ArrayList<>();
            medicacao3.add("Losartana");
            ArrayList<String> condicoes3 = new ArrayList<>();
            condicoes3.add("Pressão Alta");
            utent.createUtente("Patrícia Rocha", "Feminino",LocalDate.of(1978, 11, 5), medicacao3, condicoes3);

            ArrayList<String> medicacao4 = new ArrayList<>();
            medicacao4.add("Omeprazol");
            ArrayList<String> condicoes4 = new ArrayList<>();
            condicoes4.add("Refluxo");
            condicoes4.add("Gastroentrite");
            utent.createUtente("Bruno Lima", "Masculino", LocalDate.of(2001,9, 18), medicacao4, condicoes4);

            ArrayList<String> medicacao5 = new ArrayList<>();
            medicacao5.add("Vitamina D");
            medicacao5.add("Ferro");
            ArrayList<String> condicoes5 = new ArrayList<>();
            condicoes5.add("Anemia");
            utent.createUtente("Carla Mendes", "Feminino", LocalDate.of(1995,2,27), medicacao5, condicoes5);







            System.out.println("------Login------");
            System.out.println("Utilizador: ");
            String log = scanner.nextLine();
            System.out.println("Password: ");
            String pass = scanner.nextLine();


            if (Objects.equals(log, "med") && Objects.equals(pass, "med")) {
                System.out.println("1- Procurar Enfermeiro Nome");
                System.out.println("2- Procurar Enfermeiro Telefone");
                System.out.println("3- Procurar Farmaceutico Nome");
                System.out.println("4- Procurar Utente Nome");
                System.out.println("5- Administração de medicamento");
                System.out.println("6- Realizar Acto Médico");
                System.out.println("0- Sair");
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
                        for (String id : l) {
                            System.out.println("ID: " + id);
                        }
                    } else if (menu == 3) {
                        System.out.println("Por que nome deseja procurar? :");
                        String nome = scanner.nextLine();
                        List<String> l = farma.procuraFarmaceutico(nome);
                        for (String id : l) {
                            System.out.println("ID: "+ id);
                        }
                    } else if (menu == 4) {
                        System.out.println("Por que nome deseja procurar? :");
                        String nome = scanner.nextLine();
                        List<String> l = utent.procuraUtente(nome);            // por bonito
                        for (String id : l) {
                            System.out.println(utent.getUtente(id));
                        }
                    } else if (menu == 5) {
                        //Aumententar a quantidade de um medicamento
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
                    System.out.println("1- Procurar Enfermeiro Nome");
                    System.out.println("2- Procurar Enfermeiro Telefone");
                    System.out.println("3- Procurar Farmaceutico Nome");
                    System.out.println("4- Procurar Utente Nome");
                    System.out.println("5- Administração de medicamento");
                    System.out.println("6- Realizar Acto Médico");
                    System.out.println("0- Sair");
                    menu = scanner.nextInt();
                    scanner.nextLine();
                }

            }
            else if (Objects.equals(log, "enf") && Objects.equals(pass, "enf")) {
                System.out.println("1- Procurar Médico Nome");
                System.out.println("2- Procurar Medicamento");
                System.out.println("3- Utilizar Medicamento");
                System.out.println("4- Procurar Utente Nome");
                System.out.println("0- Sair");
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
                            System.out.println("Utentes encontrados com o nome '" + nome + "':");
                            for (String id : l) {
                                System.out.println(utent.getUtente(id));
                            }
                        } else {
                            System.out.println("Nenhum utente encontrado com o nome '" + nome + "'.");
                        }
                    }
                    System.out.println("1- Procurar Médico Nome");
                    System.out.println("2- Procurar Medicamento");
                    System.out.println("3- Utilizar Medicamento");
                    System.out.println("4- Procurar Utente Nome");
                    System.out.println("0- Sair");
                    menu = scanner.nextInt();
                    scanner.nextLine();

                }
            }
            else if (Objects.equals(log, "ut") && Objects.equals(pass, "ut")) {
                System.out.println("1- Procurar Medico Nome");
                System.out.println("2- Procurar por Especialidade");
                System.out.println("3- Procurar Farmaceutico Nome");
                System.out.println("4- Procurar Farmaceutico Telefone");
                System.out.println("5- Procurar Utente Nome");
                System.out.println("0- Sair");
                int menu = scanner.nextInt();
                scanner.nextLine();
                while (menu != 0) {
                    if (menu == 1) {
                        System.out.println("Por que nome deseja procurar? :");
                        String nome = scanner.nextLine();                           // Por bonito
                        List<String> l = medic.procuraMedico(nome);
                        for (String id : l) {
                            System.out.println(medic.getMedico(id));
                        }
                    } else if (menu == 2) {
                        System.out.println("Por que especialidade deseja procurar? :");
                        String esp = scanner.nextLine();
                        List<String> l = medic.procuraEspecialidade(esp);           // por bonito
                        for (String id : l) {
                            System.out.println(id);
                        }
                    } else if (menu == 3) {
                        System.out.println("Por que nome deseja procurar? :");
                        String nome = scanner.nextLine();
                        List<String> l = farma.procuraFarmaceutico(nome);
                        for (String id : l) {
                            System.out.println("ID: "+ id);
                        }
                    } else if (menu == 4) {
                        System.out.println("Por que contacto deseja procurar? :");
                        String telefone = scanner.nextLine();
                        List<String> l = farma.procuraFarmaceuticoTelefone(telefone);    // por bonito
                        for (String id : l) {
                            System.out.println(farma.getFarmaceutico(id));
                        }
                    } else if (menu == 5) {
                        System.out.println("Por que nome deseja procurar? :");
                        String nome = scanner.nextLine();
                        List<String> l = utent.procuraUtente(nome);
                        for (String id : l) {
                            System.out.println(utent.getUtente(id));
                        }
                    }
                    System.out.println("1- Procurar Medico Nome");
                    System.out.println("2- Procurar por Especialidade");
                    System.out.println("3- Procurar Farmaceutico Nome");
                    System.out.println("4- Procurar Farmaceutico Telefone");
                    System.out.println("5- Procurar Utente Nome");
                    System.out.println("0- Sair");
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










