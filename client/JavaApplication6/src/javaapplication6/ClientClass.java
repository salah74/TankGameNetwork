/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author john
 */
public class ClientClass {
    private Socket socket;
    private InputStream is;
    private BufferedReader fromServer;
    static final int Server_Port_Number=3000;
    public int Score;
    public int myScore;
    public void run() throws IOException{
    
        socket = new Socket("127.0.0.1",Server_Port_Number);
        fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String Server = fromServer.readLine();
        Score = Integer.valueOf(Server);
        System.out.println("Server Score " + Score);
        System.out.println("Client Score "+ myScore);
        
        if (Score>myScore){
//        System.out.println("Client Winner");
 JOptionPane.showMessageDialog(null, "Client Winner");
        }
        else if (Score<myScore) {
//            System.out.println("Server Winner");
             JOptionPane.showMessageDialog(null, "Server Winner");
        }
        else {
        
//        System.out.println("Draw");
JOptionPane.showMessageDialog(null, "Draw");
        }
        
        
    }
    
    
}
