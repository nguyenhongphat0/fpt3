
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phat
 */
public class MyMath extends UnicastRemoteObject implements MathService {

    public MyMath() throws RemoteException {
    }
    
    @Override
    public double add(double num1, double num2) throws RemoteException {
        return num1+num2;
    }

    @Override
    public double sub(double num1, double num2) throws RemoteException {
        return num1-num2;
    }
    
    
}
