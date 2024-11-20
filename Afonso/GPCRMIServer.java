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


            // Registrar no RMI Registry
            Naming.rebind("rmi://localhost:50001/GE", ge);
            Naming.rebind("rmi://localhost:50001/GF", gf);
            Naming.rebind("rmi://localhost:50001/GMED", gmed);
            Naming.rebind("rmi://localhost:50001/GM", gm);
            Naming.rebind("rmi://localhost:50001/GUT", gut);
            Naming.rebind("rmi://localhost:50001/GACT", gac);


        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}