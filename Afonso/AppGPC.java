package trabalho;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;



/*
import Medico;
import Utente;
import Medicamento;
import Enfermeiro;                         // FALTA CRIAR UMA CENA PARA AS ESTATÍSTICAS
import Farmaceutico;
import APIGestorFarmaceuticos;
import APIGestorMedicamentos;
import APIGestorEnfermeiro;
import APIGestorMedicos;
import APIGestorUtentes;
import APIGestorFarmaceuticos;*/

import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class AppGPC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {


            APIGestorEnfermeiro enfer = null;
            enfer = (APIGestorEnfermeiro)Naming.lookup("rmi://localhost:50001/GE");
            APIGestorFarmaceuticos farma = null;
            farma = (APIGestorFarmaceuticos) Naming.lookup("rmi://localhost:50001/GF");
            APIGestorMedicos medic = null;
            medic = (APIGestorMedicos)Naming.lookup("rmi://localhost:50001/GM");
            APIGestorUtentes utent = null;
            utent = (APIGestorUtentes) Naming.lookup("rmi://localhost:50001/GUT");
            APIGestorMedicamentos meds = null;
            meds = (APIGestorMedicamentos) Naming.lookup("rmi://localhost:50001/GMED");





            // Criar 5 enfermeiros
            enfer.createEnfermeiro("Ana Silva", "912345678", "Pediatria");
            enfer.createEnfermeiro("Carlos Santos", "913456789", "Urgências");
            enfer.createEnfermeiro("Maria Oliveira", "914567890", "Oncologia");
            enfer.createEnfermeiro("João Almeida", "915678901", "Cardiologia");
            enfer.createEnfermeiro("Sofia Costa", "916789012", "Neurologia");

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


            /*
            // Criar 5 utentes
            ArrayList<String> medicacao1 = new ArrayList<>();
            medicacao1.add("Paracetamol");
            medicacao1.add("Ibuprofeno");

            ArrayList<String> condicoes1 = new ArrayList<>();
            condicoes1.add("Diabetes");
            condicoes1.add("Hipertensão");

            utent.createUtente("UT001", "Joana Neves", "Feminino", LocalDate.of(1985, 3, 14), medicacao1, condicoes1);

            ArrayList<String> medicacao2 = new ArrayList<>();
            medicacao2.add("Amoxicilina");

            ArrayList<String> condicoes2 = new ArrayList<>();
            condicoes2.add("Alergia a pólen");

            utent.createUtente("UT002", "Miguel Nunes", "Masculino", LocalDate.of(1990, 7, 22), medicacao2, condicoes2);

            ArrayList<String> medicacao3 = new ArrayList<>();
            medicacao3.add("Losartana");

            ArrayList<String> condicoes3 = new ArrayList<>();
            condicoes3.add("Pressão Alta");

            utent.createUtente("UT003", "Patrícia Rocha", "Feminino", LocalDate.of(1978, 11, 5), medicacao3, condicoes3);

            ArrayList<String> medicacao4 = new ArrayList<>();
            medicacao4.add("Omeprazol");

            ArrayList<String> condicoes4 = new ArrayList<>();
            condicoes4.add("Refluxo");

            utent.createUtente("UT004", "Bruno Lima", "Masculino", LocalDate.of(2001, 9, 18), medicacao4, condicoes4);

            ArrayList<String> medicacao5 = new ArrayList<>();
            medicacao5.add("Vitamina D");

            ArrayList<String> condicoes5 = new ArrayList<>();
            condicoes5.add("Anemia");

            utent.createUtente("UT005", "Carla Mendes", "Feminino", LocalDate.of(1995, 2, 27), medicacao5, condicoes5);
            */


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
                System.out.println("5- Pedir medicamento");
                System.out.println("6- Realizar Acto Médico");
                int menu = scanner.nextInt();
                if(menu == 1) {
                    System.out.println("Por que nome deseja procurar? :");
                    String nome = scanner.nextLine();
                    List<String> l = enfer.procuraEnfermeiro(nome);
                    for(String id:l){
                        System.out.println(enfer.getEnfermeiro(id));
                    }
                }
                else if(menu == 2) {
                    System.out.println("Por que contacto deseja procurar? :");
                    String telefone = scanner.nextLine();
                    List<String> l= enfer.procuraEnfermeiroTelefone(telefone);
                    for(String id:l){
                        System.out.println(enfer.getEnfermeiro(id));
                    }
                }
                else if(menu == 3) {
                    System.out.println("Por que nome deseja procurar? :");
                    String nome = scanner.nextLine();
                    List<String> l= farma.procuraFarmaceutico(nome);
                    for(String id:l){
                        System.out.println(farma.getFarmaceutico(id));
                    }
                }
                else if(menu == 4) {
                    System.out.println("Por que nome deseja procurar? :");
                    String nome = scanner.nextLine();
                    List<String> l= utent.procuraUtente(nome);
                    for(String id:l){
                        System.out.println(utent.getUtente(id));
                    }
                }
                else if(menu == 5) {
                    return;    // dispensa de medicamento a um utente. aqui atualiza a medicacao do utente e depois faz atuaizacao no GLM
                }                               // Faltam estes dois
                else if(menu == 6) {
                    return;
                }

            }
            else if (Objects.equals(log, "enf") && Objects.equals(pass, "enf")) {
                System.out.println("1- Procurar Médico Nome");
                System.out.println("2- Procurar Medicamento");
                System.out.println("3- Altera Stock Medicamento");
                System.out.println("4- Procurar Utente Nome");
                int menu = scanner.nextInt();
                if(menu == 1) {
                    System.out.println("Por que nome deseja procurar? :");
                    String nome = scanner.nextLine();
                    List<String> l= medic.procuraMedico(nome);
                    for(String id:l){
                        System.out.println(medic.getMedico(id));
                    }
                }
                else if(menu == 2) {
                    System.out.println("Por que medicamento deseja procurar? :");
                    String nome = scanner.nextLine();
                    List<String> l= meds.procuraMedicamento(nome);
                    for(String id:l){
                        System.out.println(meds.getMedicamento(id));
                    }
                }
                else if(menu == 3) {
                    return;                                        // falta este
                }
                else if(menu == 4) {
                    System.out.println("Por que nome deseja procurar? :");
                    String nome = scanner.nextLine();
                    List<String> l= utent.procuraUtente(nome);
                    for(String id:l){
                        System.out.println(utent.getUtente(id));
                    }
                }

            }
            else if (Objects.equals(log, "ut") && Objects.equals(pass, "ut")) {
                System.out.println("1- Procurar Medico Nome");
                System.out.println("2- Procurar por Especialidade");
                System.out.println("3- Procurar Farmaceutico Nome");
                System.out.println("4- Procurar Farmaceutico Telefone");
                System.out.println("5- Procurar Utente Nome");
                System.out.println("6- Alterar Medicação Utente");
                int menu = scanner.nextInt();
                if(menu == 1) {
                    System.out.println("Por que nome deseja procurar? :");
                    String nome = scanner.nextLine();
                    List<String> l= medic.procuraMedico(nome);
                    for(String id:l){
                        System.out.println(medic.getMedico(id));
                    }
                }
                else if(menu == 2) {
                    System.out.println("Por que especialidade deseja procurar? :");
                    String esp = scanner.nextLine();
                    List<String> l= medic.procuraEspecialidade(esp);
                    for(String id:l){
                        System.out.println(medic.getMedico(id));
                    }
                }
                else if(menu == 3) {
                    System.out.println("Por que nome deseja procurar? :");
                    String nome = scanner.nextLine();
                    List<String> l= farma.procuraFarmaceutico(nome);
                    for(String id:l){
                        System.out.println(farma.getFarmaceutico(id));
                    }
                }
                else if(menu == 4) {
                    System.out.println("Por que contacto deseja procurar? :");
                    String telefone = scanner.nextLine();
                    List<String> l= farma.procuraFarmaceuticoTelefone(telefone);
                    for(String id:l){
                        System.out.println(farma.getFarmaceutico(id));
                    }
                }
                else if(menu == 5) {
                    System.out.println("Por que nome deseja procurar? :");
                    String nome = scanner.nextLine();
                    List<String> l= utent.procuraUtente(nome);
                    for(String id:l){
                        System.out.println(utent.getUtente(id));
                    }
                }
                else if(menu == 6) {
                    return;                        // falta este
                }
            }

        }catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}










