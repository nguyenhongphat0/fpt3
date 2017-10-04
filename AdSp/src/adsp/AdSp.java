/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsp;

/**
 *
 * @author Phat
 */
public class AdSp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Champion ezreal = new Champion("Ezreal");
        Champion sona = new Champion("Sona");
        ezreal.sp = sona;
        sona.sp = ezreal;
        ezreal.start();
        sona.start();
    }
    
}
