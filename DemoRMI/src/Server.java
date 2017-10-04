
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phat
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String serviceName = "rmi://localhost:1098/TestMath";
        MyMath server;
        try {
            server = new MyMath();
//            Runtime rt = Runtime.getRuntime();
//            rt.exec("rmiregistry.exe");
            LocateRegistry.createRegistry(1098);
            Naming.rebind(serviceName, server);
            System.out.println("Service " + serviceName + " is running...");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error running services");
            return;
        }
    }
    
}
