package trabalho;

import java.rmi.Naming;
import java.util.Scanner;

public class Central {
    private static Thread gpcrmiThread;
    private static Thread glmRmiThread;



    public static void main(String[] args) {
        try {



            // Inicia os servidores RMI automaticamente
            startServers();



            // menu app principal
            showMenu();

        } catch (Exception e) {
            System.err.println("Erro ao iniciar o sistema: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void startServers() {
        gpcrmiThread = new Thread(() -> {
            try {
                GPCRMIServer.main(null);
            } catch (Exception e) {
                System.err.println("Erro ao iniciar GPCRMIServer: " + e.getMessage());
                e.printStackTrace();
            }
        });
        gpcrmiThread.start();


        glmRmiThread = new Thread(() -> {
            try {
                GLMRMIServer.main(null);
            } catch (Exception e) {
                System.err.println("Erro ao iniciar GLMRMIServer: " + e.getMessage());
                e.printStackTrace();
            }
        });
        glmRmiThread.start();
    }

    private static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Entrar na AppGPC");
            System.out.println("2. Entrar na AppGLM");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("\nA iniciar AppGPC...");
                    startAppGPC();
                    break;

                case "2":
                    System.out.println("\nA iniciar AppGLM...");
                    startAppGLM();
                    break;

                case "0":
                    System.out.println("\nObrigado por utilizar a nossa aplicação!");
                    stopServers();
                    scanner.close();
                    System.exit(0); // Fecha o programa completamente
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void startAppGPC() {
        try {
            AppGPC.main(null); // Chama o main da AppGPC
        } catch (Exception e) {
            System.err.println("Erro ao iniciar AppGPC: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void startAppGLM() {
        try {
            AppGLM.main(null); // Chama o main da AppGLM
        } catch (Exception e) {
            System.err.println("Erro ao iniciar AppGLM: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void stopServers() {
        try {
            // Interrompe as threads dos servidores
            if (gpcrmiThread != null && gpcrmiThread.isAlive()) {
                gpcrmiThread.interrupt();
                System.out.println("GPCRMIServer encerrado.");
            }

            if (glmRmiThread != null && glmRmiThread.isAlive()) {
                glmRmiThread.interrupt();
                System.out.println("GLMRMIServer encerrado.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao encerrar os servidores: " + e.getMessage());
        }
    }
}
