
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phat
 */
public interface MathService extends Remote {
    double add(double num1, double num2) throws RemoteException;
    double sub(double num1, double num2) throws RemoteException;
}
