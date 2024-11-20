package trabalho;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class GLMRMIServer {
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


        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}