/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author john
 */
public class JavaApplication6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        JFrame jf=new JFrame();
        JButton newGame = new JButton("New Game");
       
        jf.setSize(600, 600);
        jf.setTitle("Client Side");
        MovingBalls mb=new MovingBalls();
        mb.Balls.add(new Ball(130,130,5,Color.BLACK));
        mb.Balls.add(new Ball(100,100,20,Color.ORANGE));
        mb.Balls.add(new Ball(160,160,15,Color.red));
        mb.Balls.add(new Ball(180,180,10,Color.CYAN));
        
        
 
        jf.add(mb,BorderLayout.CENTER);
        mb.setFocusable(true);
        Thread t1=new Thread(mb);
        
        t1.start();
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }
    
}
