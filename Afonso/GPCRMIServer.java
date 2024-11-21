package trabalho;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

public class GPCRMIServer {
    public static void main(String[] args) {
        try {
            // Criação das instâncias
            GestorEnfermeiros ge = new GestorEnfermeiros();
            GestorFarmaceuticos gf = new GestorFarmaceuticos();
            GestorMedicamentos gmed = new GestorMedicamentos();
            GestorMedicos gm = new GestorMedicos();
            GestorUtentes gut = new GestorUtentes();
            GestorActos gac = new GestorActos();


            // Registrar no RMI Registry
            Naming.rebind("rmi://localhost:50001/GE", ge);
            Naming.rebind("rmi://localhost:50001/GF", gf);
            Naming.rebind("rmi://localhost:50001/GMED", gmed);
            Naming.rebind("rmi://localhost:50001/GM", gm);
            Naming.rebind("rmi://localhost:50001/GUT", gut);
            Naming.rebind("rmi://localhost:50001/GACT", gac);



            // Criar 5 enfermeiros
            ge.createEnfermeiro("Ana Silva", "912345678", "Pediatria");
            ge.createEnfermeiro("Carlos Santos", "913456789", "Urgências");
            ge.createEnfermeiro("Maria Oliveira", "914567890", "Oncologia");
            ge.createEnfermeiro("João Almeida", "915678901", "Cardiologia");
            ge.createEnfermeiro("Sofia Costa", "916789012", "Cardiologia");
            ge.createEnfermeiro("Pedro Mendes", "917890123", "Pediatria");
            ge.createEnfermeiro("Inês Ferreira", "918901234", "Neurologia");
            ge.createEnfermeiro("Rui Costa", "919012345", "Urgências");
            ge.createEnfermeiro("Cláudia Rocha", "920123456", "Oncologia");
            ge.createEnfermeiro("Miguel Pereira", "921234567", "Psiquiatria");



            // Criar 5 farmacêuticos
            gf.createFarmaceutico("Pedro Rodrigues", "917890123");
            gf.createFarmaceutico("Rita Ferreira", "918901234");
            gf.createFarmaceutico("Tiago Sousa", "919012345");
            gf.createFarmaceutico("Helena Martins", "920123456");
            gf.createFarmaceutico("Bruno Mendes", "921234567");
            gf.createFarmaceutico("Ana Carvalho", "922345678");
            gf.createFarmaceutico("Miguel Costa", "923456789");
            gf.createFarmaceutico("Cláudia Pereira", "924567890");
            gf.createFarmaceutico("João Silva", "925678901");
            gf.createFarmaceutico("Sofia Gomes", "926789012");



            
            // Criar 5 médicos
            gm.createMedico("Luís Pereira", "922345678", "Cirurgia");
            gm.createMedico("Sara Fonseca", "923456789", "Dermatologia");
            gm.createMedico("Fernando Costa", "924567890", "Ortopedia");
            gm.createMedico("Clara Lopes", "925678901", "Psiquiatria");
            gm.createMedico("Ricardo Monteiro", "926789012", "Ginecologia");
            gm.createMedico("Ana Martins", "927890123", "Pediatria");
            gm.createMedico("João Oliveira", "928901234", "Cardiologia");
            gm.createMedico("Rita Mendes", "929012345", "Dermatologia");
            gm.createMedico("Carlos Santos", "930123456", "Ortopedia");
            gm.createMedico("Beatriz Ferreira", "931234567", "Neurologia");





            ArrayList<String> medicacao1 = new ArrayList<>();
            medicacao1.add("Paracetamol");
            medicacao1.add("Ibuprofeno");
            medicacao1.add("Strepsils");
            ArrayList<String> condicoes1 = new ArrayList<>();
            condicoes1.add("Diabetes");
            condicoes1.add("Hipertensão");
            gut.createUtente("Joana Neves", "Feminino", LocalDate.of(1985,3,14), medicacao1, condicoes1);

            ArrayList<String> medicacao2 = new ArrayList<>(); // Sem medicamentos
            ArrayList<String> condicoes2 = new ArrayList<>();
            condicoes2.add("Alergia a pólen");
            condicoes2.add("Asma");
            gut.createUtente("Fernanda Rodrigues", "Feminino", LocalDate.of(1990, 7, 22), medicacao2, condicoes2);

            ArrayList<String> medicacao3 = new ArrayList<>();
            medicacao3.add("Losartana");
            ArrayList<String> condicoes3 = new ArrayList<>();
            condicoes3.add("Pressão Alta");
            gut.createUtente("Patrícia Rocha", "Feminino",LocalDate.of(1978, 11, 5), medicacao3, condicoes3);

            ArrayList<String> medicacao4 = new ArrayList<>();
            medicacao4.add("Omeprazol");
            ArrayList<String> condicoes4 = new ArrayList<>();
            condicoes4.add("Refluxo");
            condicoes4.add("Gastroentrite");
            gut.createUtente("Bruno Lima", "Masculino", LocalDate.of(2001,9, 18), medicacao4, condicoes4);

            ArrayList<String> medicacao5 = new ArrayList<>();
            medicacao5.add("Vitamina D");
            medicacao5.add("Ferro");
            ArrayList<String> condicoes5 = new ArrayList<>();
            condicoes5.add("Anemia");
            gut.createUtente("Carla Mendes", "Feminino", LocalDate.of(1995,2,27), medicacao5, condicoes5);

            ArrayList<String> medicacao6 = new ArrayList<>();
            medicacao1.add("Paracetamol");
            medicacao1.add("Ibuprofeno");
            ArrayList<String> condicoes6 = new ArrayList<>();
            condicoes1.add("Febre");
            condicoes1.add("Dor de cabeça");
            gut.createUtente("João Silva", "Masculino", LocalDate.of(1987, 6, 15), medicacao6, condicoes6);

            ArrayList<String> medicacao7 = new ArrayList<>();
            medicacao2.add("Insulina");
            medicacao2.add("Metformina");
            ArrayList<String> condicoes7 = new ArrayList<>();
            condicoes2.add("Diabetes Tipo 2");
            gut.createUtente("Ana Santos", "Feminino", LocalDate.of(1975, 11, 8), medicacao7, condicoes7);

            ArrayList<String> medicacao8 = new ArrayList<>();
            medicacao3.add("Omeprazol");
            ArrayList<String> condicoes8 = new ArrayList<>();
            condicoes3.add("Refluxo gástrico");
            gut.createUtente("Carlos Nunes", "Masculino", LocalDate.of(1990, 3, 20), medicacao8, condicoes8);

            ArrayList<String> medicacao9 = new ArrayList<>();
            medicacao4.add("Cetirizina");
            ArrayList<String> condicoes9 = new ArrayList<>();
            condicoes4.add("Alergia sazonal");
            gut.createUtente("Mariana Costa", "Feminino", LocalDate.of(2000, 7, 12), medicacao9, condicoes9);

            ArrayList<String> medicacao10 = new ArrayList<>();
            medicacao6.add("Amoxicilina");
            ArrayList<String> condicoes10 = new ArrayList<>();
            condicoes6.add("Infecção bacteriana");
            gut.createUtente("Ricardo Almeida", "Masculino", LocalDate.of(1982, 1, 25), medicacao10, condicoes10);



        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}