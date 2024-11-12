package trabalho;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Medico;
import Utente;
import Medicamento;
import Enfermeiro;
import Farmaceutico;
import APIGestorFarmaceuticos;
import APIGestorMedicamentos;
import APIGestorEnfermeiro;
import APIGestorMedicos;
import APIGestorUtentes;
import APIGestorFarmaceuticos;

import java.util.Scanner;


public class AppGPC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // **********     falta esta parte aplicada a este problema     **********
            //APIGestorContactos gestor = null;
            //gestor = (APIGestorContactos)
            //        Naming.lookup("rmi://localhost:50001/GC");   // falta esta parte do Naming.lookup

            APIGestorEnfermeiro enfer = null;
            enfer = (APIGestorEnfermeiro);
            Naming.lookup("rmi://localhost:50001/GE",ge);
            APIGestorFarmaceuticos farma = null;
            farma = (APIGestorFarmaceuticos) ;
            Naming.lookup("rmi://localhost:50001/GF",gf);
            APIGestorMedicos medic = null;
            medic = (APIGestorMedicos);
            Naming.lookup("rmi://localhost:50001/GM",gm);
            APIGestorUtentes utent = null;
            utent = (APIGestorUtentes);
            Naming.lookup("rmi://localhost:50001/GUT",gut);
            APIGestorMedicamentos meds = null;
            meds = (APIGestorMedicamentos);
            Naming.lookup("rmi://localhost:50001/GMED",gmed);



            System.out.println("------Login------\n");
            String log = scanner.nextLine();
            String pass = scanner.nextLine();

            if (log == "med" && pass == "med") {
                System.out.println("1- Procurar Enfermeiro Nome\n");
                System.out.println("2- Procurar Enfermeiro Telefone\n");
                System.out.println("3- Procurar Farmaceutico Nome\n");
                System.out.println("4- Procurar Utente Nome\n");
                System.out.println("5- Alterar Medicação Utente\n");
                System.out.println("6- Realizar Acto Médico\n");
                int menu = scanner.nextInt();
                if(menu == 1) {
                    System.out.println("Por que nome deseja procurar? :");
                    String nome = scanner.nextLine();
                    l= enfer.procuraEnfermeiro(nome);
                    for(String id:l){
                        System.out.println(enfer.getEnfermeiro(id));
                    }
                }
                else if(menu == 2) {
                    System.out.println("Por que contacto deseja procurar? :");
                    String telefone = scanner.nextLine();
                    l= enfer.procuraEnfermeiroTelefone(telefone);
                    for(String id:l){
                        System.out.println(enfer.getEnfermeiroTelefone(id));
                    }
                }
                else if(menu == 3) {
                    System.out.println("Por que nome deseja procurar? :");
                    String nome = scanner.nextLine();
                    l= farma.procuraFarmaceutico(nome);
                    for(String id:l){
                        System.out.println(farma.getFarmaceutico(id));
                    }
                }
                else if(menu == 4) {
                    System.out.println("Por que nome deseja procurar? :");
                    String nome = scanner.nextLine();
                    l= utent.procuraUtente(nome);
                    for(String id:l){
                        System.out.println(utent.getUtente(id));
                    }
                }
                else if(menu == 5) {
                    return;
                }                               // Faltam estes dois
                else if(menu == 6) {
                    return;
                }

            }
            else if (log == "enf" && pass == "enf") {
                System.out.println("1- Procurar Médico Nome\n");
                System.out.println("2- Procurar Medicamento\n");
                System.out.println("3- Altera Stock Medicamento\n");
                System.out.println("4- Procurar Utente Nome\n");
                int menu = scanner.nextInt();
                if(menu == 1) {
                    System.out.println("Por que nome deseja procurar? :");
                    String nome = scanner.nextLine();
                    l= medic.procuraMedico(nome);
                    for(String id:l){
                        System.out.println(medic.getMedico(id));
                    }
                }
                else if(menu == 2) {
                    System.out.println("Por que medicamento deseja procurar? :");
                    String nome = scanner.nextLine();
                    l= meds.procuraMedicamento(nome);
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
                    l= utent.procuraUtente(nome);
                    for(String id:l){
                        System.out.println(utent.getUtente(id));
                    }
                }

            }
            else if (log == "ut" && pass == "ut") {
                System.out.println("1- Procurar Medico Nome\n");
                System.out.println("2- Procurar por Especialidade\n");
                System.out.println("3- Procurar Farmaceutico Nome\n");
                System.out.println("4- Procurar Farmaceutico Telefone\n");
                System.out.println("5- Procurar Utente Nome\n");
                System.out.println("6- Alterar Medicação Utente\n");
                int menu = scanner.nextInt();
                if(menu == 1) {
                    System.out.println("Por que nome deseja procurar? :");
                    String nome = scanner.nextLine();
                    l= medic.procuraMedico(nome);
                    for(String id:l){
                        System.out.println(medic.getMedico(id));
                    }
                }
                else if(menu == 2) {
                    System.out.println("Por que especialidade deseja procurar? :");
                    String esp = scanner.nextLine();
                    l= medic.procuraEspecialidade(esp);
                    for(String id:l){
                        System.out.println(medic.getMedico(id));
                    }
                }
                else if(menu == 3) {
                    System.out.println("Por que nome deseja procurar? :");
                    String nome = scanner.nextLine();
                    l= farma.procuraFarmaceutico(nome);
                    for(String id:l){
                        System.out.println(farma.getFarmaceutico(id));
                    }
                }
                else if(menu == 4) {
                    System.out.println("Por que contacto deseja procurar? :");
                    String telefone = scanner.nextLine();
                    l= farma.procuraFarmaceuticoTelefone(telefone);
                    for(String id:l){
                        System.out.println(farma.getFarmaceuticoTelefone(id));
                    }
                }
                else if(menu == 5) {
                    System.out.println("Por que nome deseja procurar? :");
                    String nome = scanner.nextLine();
                    l= utent.procuraUtente(nome);
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













/*public class AppGPC {

    public static void main(String[] args) {
        try {
            APIGestorContactos gestor = null;
            gestor = (APIGestorContactos)
                    Naming.lookup("rmi://localhost:50001/GC");


            gestor.createContacto("Antonio", "Sousa","123456");
            gestor.createContacto("Antonio", "Sousa","1234568");
            gestor.createContacto("Antonio", "Silva","1234567");
            gestor.createContacto("Jose", "Silva","1234565");

            List<String> l = gestor.procuraContacto("Antonio");
            System.out.println("Procura por nome");
            for(String id:l){
                System.out.println(id);
            }
            for(String id:l){
                Contacto c = gestor.getContacto(id);
                System.out.println(c);
            }
            System.out.println("Procura por apleidp");
            l= gestor.procuraContactoApelido("Silva");
            for(String id:l){
                System.out.println(gestor.getContacto(id));
            }
            System.out.println("Procura por nome e apelido");
            l= gestor.procuraContacto("Antonio", "Sousa");
            for(String id:l){
                System.out.println(gestor.getContacto(id));
            }

        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }


    }
}
*/