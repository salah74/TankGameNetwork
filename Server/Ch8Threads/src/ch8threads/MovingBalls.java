/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public class MovingBalls extends JPanel implements Runnable{

   public ArrayList<Ball>Balls=new ArrayList<Ball>(5);
   public Tank BlueTank=new Tank("C:\\Users\\DELL\\Desktop\\TankBlueS.jpg");
   JLabel label =new JLabel();
   JLabel label2 = new JLabel();
   long start;    
   int highScore;
   String sCurrentLine;
   public int counter=0; 
   JButton newScore = new JButton("Reset High Score");
     ServerSide Server;
   BufferedWriter writer;
          
    public MovingBalls() throws IOException
    {
        
       
        start = System.nanoTime();
        setSize(600,600);
        
        Server = new ServerSide();
        label2.setText("High Score");
//        this.add(label2);
//        this.add(label);
//        this.add(newScore);
        BlueTank.pos.x=220;
        BlueTank.pos.y=340;
       
        this.addKeyListener(new keylist());
        
        
    }
  

    private class keylist implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e) {
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
            if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                
                BlueTank.mover();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                
                BlueTank.movel();
                //repaint();
            }
            if (e.getKeyCode()==KeyEvent.VK_SPACE)
            {
                
                BlueTank.fireBullet();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
           
        }
    }
    public void  paintComponent(Graphics g)
    {
//         try (BufferedReader br = new BufferedReader(new FileReader("/Users/john/BestResult.txt"))) {
//         while ((sCurrentLine = br.readLine()) != null) {
//            
//            highScore = Integer.valueOf(sCurrentLine);
//            label.setText(sCurrentLine);
//         }
//         br.close();
//      } catch (IOException e) {
//         e.printStackTrace();
//      }
                 
        g.clearRect(0, 0, 600, 600);
        
        try
        {
           
        BufferedImage imgtank = ImageIO.read(new File(BlueTank.ImagePath));
        BufferedImage imgrocket = ImageIO.read(new File(BlueTank.Rocket.imgPath));
        g.drawImage(imgtank, BlueTank.pos.x, BlueTank.pos.y,null);
        g.drawImage(imgrocket, BlueTank.Rocket.pos.x, BlueTank.Rocket.pos.y,null);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        
        
        for (Ball OneBall: Balls)
        
        {
            g.setColor(OneBall.CurrentColor);
            g.fillOval(OneBall.x,OneBall.y, 50, 50);
            if (BlueTank.Rocket.pos.distance(OneBall.x, OneBall.y)<=50)
            {
                counter++;
                System.out.println("Hit Occurs" + OneBall.CurrentColor.toString());
                Balls.remove(OneBall);
                if(counter==4){
                long elapsedTime = System.nanoTime() - start;
                elapsedTime=elapsedTime/1000000000;
                String eltime=Long.toString(elapsedTime);
                Server.result = Integer.valueOf(eltime);
                JOptionPane.showMessageDialog(null, "Server Score is " +eltime );
                    try {
                        Server.run();
                    } catch (IOException ex) {
                        Logger.getLogger(MovingBalls.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        if(Integer.valueOf(eltime)<highScore||highScore==0){
                        writer = new BufferedWriter(new FileWriter("D:/BestResult.txt"));
//                        writer.write(eltime);
//                        label.setText(eltime);
//                        writer.close();
//                        JOptionPane.showMessageDialog(null, "HIGH SCORE "+eltime); 
                        counter=0;
                             start = System.nanoTime();
                             this.Balls.add(new Ball(130,130,5,Color.BLACK));
                             this.Balls.add(new Ball(100,100,20,Color.ORANGE));
                             this.Balls.add(new Ball(160,160,15,Color.red));
                             this.Balls.add(new Ball(180,180,10,Color.CYAN));
                           repaint();
                        
                        }
                        else{
                            
                            JOptionPane.showMessageDialog(null, "YOUR SCORE "+eltime);
                             counter=0;
                             start = System.nanoTime();
                            
                         
                           MovingBalls x = new MovingBalls();
                           this.Balls.add(new Ball(130,130,5,Color.BLACK));
                           this.Balls.add(new Ball(100,100,20,Color.ORANGE));
                            this.Balls.add(new Ball(160,160,15,Color.red));
                              
                           this.Balls.add(new Ball(180,180,10,Color.CYAN));
                           repaint();
                        
                        }
                        
                    } catch (IOException ex) {
                        Logger.getLogger(MovingBalls.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                
                break;
                
                
            }
            
        }
        
    }
    @Override
    public void run() {
    try
    {
    while(true)
    {
        for (Ball OneBall: Balls)
        {
            OneBall.move(this.getWidth());
        }    
        
        //y+=10;
        Thread.sleep(50);
        repaint();
    }
    }
    catch (InterruptedException e)
    {}
    }
    
}
