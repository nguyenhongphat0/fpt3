
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.tree.DefaultMutableTreeNode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phat
 */
public class TreeModel {
    
    public boolean loadData(DefaultMutableTreeNode root, File file) {
        DefaultMutableTreeNode dNode = null;
        String line;
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (line.trim().endsWith(":")) {
                    dNode = new DefaultMutableTreeNode(new Department(line.split("-")[0], line.split("-")[1]));
                    root.add(dNode);
                } else {
                    dNode.add(new DefaultMutableTreeNode(new Employee(line.split("-")[0], line.split("-")[1], Integer.parseInt(line.split("-")[2]))));
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Error happed");
            return false;
        }
        return true;
    }
    
    public boolean saveData(DefaultMutableTreeNode root, File file) {
        try (PrintWriter pw = new PrintWriter(file)) {
            Enumeration ds = root.children();
            while (ds.hasMoreElements()) {
                DefaultMutableTreeNode d = (DefaultMutableTreeNode) ds.nextElement();
                pw.println(d + ":");
                Enumeration es = d.children();
                while (es.hasMoreElements()) {
                    pw.println(es.nextElement());
                }
            }
            
            return true;
        } catch (FileNotFoundException ex) {
            return false;            
        }
    }
}
