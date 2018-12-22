/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.Point;

/**
 *
 * @author ASUS
 */
public class Tank {
    public Point pos=new Point();
    public String ImagePath;
    public Bullet Rocket=new Bullet();
    public int speed;
    public Tank (String ImagePath)
    {
        speed=5;
        this.ImagePath=ImagePath;
        Rocket.imgPath="C:\\Users\\DELL\\Desktop\\rocket.gif";
    }

    void mover() {
        if(this.pos.x<450){
        this.pos.x+=speed;
        }
    }
      void movel() {
          if(this.pos.x>15){
        this.pos.x-=speed;
          }
    }

    public void fireBullet() {
        Rocket.pos.x=this.pos.x+60;
        Rocket.pos.y=this.pos.y;
        Thread t1=new Thread (Rocket);
        t1.start();
    }
}
