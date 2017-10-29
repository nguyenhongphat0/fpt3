package controller;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguyenhongphat0
 */
public class Logs {
    public static File logsFile = new File("asset/logs");
    
    public static void push(String message) { // push message to logs
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream(logsFile, true));
        } catch (FileNotFoundException ex) {
            try {
                logsFile.createNewFile();
                pw = new PrintWriter(new FileOutputStream(logsFile, true));
            } catch (IOException ex1) {
                System.out.println("Error writing logs, permission denied!");
                return;
            }
        } finally {
            pw.println(message);
            pw.close();
        }
    }
    
    public static void push(String user, String dowhat) { // push user do something to logs
        push("["+user+"]" + new Date() + " -> " + dowhat);
    }
    
    public static void pop(String user, JLabel label) { // get message from logs
        String s = "<html>";
        try {
            BufferedReader br = new BufferedReader(new FileReader(logsFile));
            String line;
            while ((line = br.readLine()) != null) {    
                if (line.startsWith("["+user+"]")) {
                    s += line.substring(user.length() + 2) + "<br>";
                }
            }
        } catch (Exception ex) {
            System.out.println("No logs was found!");
        }
        label.setText(s);
    }
}
