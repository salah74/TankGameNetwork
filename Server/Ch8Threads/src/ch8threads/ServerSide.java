/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch8threads;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author john
 */
public class ServerSide {
    private ServerSocket serverSocket;
    private Socket socket;
    private OutputStream os;
    private PrintWriter pwtoClient;
    static final int port_number =3000;
    int result;
    public ServerSide() throws IOException{     
    serverSocket=new ServerSocket(3000);
    }
    
    public void run() throws IOException{
    socket = serverSocket.accept();
    pwtoClient=new PrintWriter(socket.getOutputStream(),true);
    pwtoClient.println(result);
    pwtoClient.close();
    socket.close();
    
    
    }
    
    
}
