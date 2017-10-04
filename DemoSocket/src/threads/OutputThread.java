/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JTextArea;

/**
 *
 * @author Phat
 */
public class OutputThread extends Thread {
    Socket socket;
    JTextArea txt;
    BufferedReader br;
    String sender;
    String receiver;

    public OutputThread() {
    }

    public OutputThread(Socket socket, JTextArea txt, String sender, String receiver) {
        this.socket = socket;
        this.txt = txt;
        this.sender = sender;
        this.receiver = receiver;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (socket != null) {
                    String message = "";
                    if ((message = br.readLine()) != null && message.length() > 0) {
                        txt.append(receiver + ": " + message + "\n");
                    }
                }
                sleep(500);
            }
        } catch (Exception e) {
        }
    }
}
