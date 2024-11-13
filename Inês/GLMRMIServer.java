package Trabalho;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class GLMRMIServer {
    public static void main(String[] args) {

        try {
            // Criação dos objetos gestores
            APIGestorEnfermeiro ge = new GestorEnfermeiros();
            APIGestorFarmaceuticos gf = new GestorFarmaceuticos();
            APIGestorMedicamentos gmed = new GestorMedicamentos();
            APIGestorMedicos gm = new GestorMedicos();
            APIGestorUtentes gut = new GestorUtentes();

            // Registra os objetos RMI
            Naming.rebind("rmi://localhost:50001/GE", (Remote) ge);
            Naming.rebind("rmi://localhost:50001/GF", (Remote) gf);
            Naming.rebind("rmi://localhost:50001/GMED", (Remote) gmed);
            Naming.rebind("rmi://localhost:50001/GM", (Remote) gm);
            Naming.rebind("rmi://localhost:50001/GUT", (Remote) gut);

            System.out.println("Servidor RMI em execução...");

        } catch (RemoteException e) {
            throw new RuntimeException("Erro de RMI: ", e);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Erro na URL do RMI: ", e);
        }
    }
}
