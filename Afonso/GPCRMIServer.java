/*
package trabalho;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class GPCRMIServer {
    public static void main(String[] args) {

        try {
            APIGestorEnfermeiros ge = new GestorEnfermeiros();
            APIGestorFarmaceuticos gf = new GestorFarmaceuticos();
            APIGestorMedicamentos gmed = new GestorMedicamentos();
            APIGestorMedicos gm = new GestorMedicos();
            APIGestorUtentes gut = new GestorUtentes();
            APIGestorActos gac = new GestorActos();

            Naming.rebind("rmi://localhost:50001/GE",ge);
            Naming.rebind("rmi://localhost:50001/GF",gf);
            Naming.rebind("rmi://localhost:50001/GMED",gmed);
            Naming.rebind("rmi://localhost:50001/GM",gm);
            Naming.rebind("rmi://localhost:50001/GUT",gut);
            Naming.rebind("rmi://localhost:50001/GACT",gac);
            System.out.println("Running");

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}


*/

package trabalho;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

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

            // Inicializar os dados
            inicializarEnfermeiros(ge);

            inicializarMedicamentos(gmed);
            inicializarMedicos(gm);

            // Registrar no RMI Registry
            Naming.rebind("rmi://localhost:50001/GE", ge);
            Naming.rebind("rmi://localhost:50001/GF", gf);
            Naming.rebind("rmi://localhost:50001/GMED", gmed);
            Naming.rebind("rmi://localhost:50001/GM", gm);
            Naming.rebind("rmi://localhost:50001/GUT", gut);
            Naming.rebind("rmi://localhost:50001/GACT", gac);

            System.out.println("Servidor RMI rodando...");

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    // Métodos para inicializar os dados de cada gestor
    private static void inicializarEnfermeiros(GestorEnfermeiros ge) throws RemoteException {
        ge.createEnfermeiro("Ana Silva", "912345678", "Pediatria");
        ge.createEnfermeiro("Carlos Santos", "913456789", "Urgências");
        ge.createEnfermeiro("Maria Oliveira", "914567890", "Oncologia");
        ge.createEnfermeiro("João Almeida", "915678901", "Cardiologia");
        ge.createEnfermeiro("Sofia Costa", "916789012", "Neurologia");
        System.out.println("Enfermeiros inicializados.");
    }


    private static void inicializarMedicamentos(GestorMedicamentos gmed) throws RemoteException {
        gmed.createMedicamento("Paracetamol", "Analgésico", 500);
        gmed.createMedicamento("Ibuprofeno", "Antiinflamatório", 200);
        System.out.println("Medicamentos inicializados.");
    }

    private static void inicializarMedicos(GestorMedicos gm) throws RemoteException {
        gm.createMedico("Dr. Pedro Costa", "Cardiologia", "912123123");
        gm.createMedico("Dra. Inês Ferreira", "Pediatria", "913234234");
        System.out.println("Médicos inicializados.");
    }



}
