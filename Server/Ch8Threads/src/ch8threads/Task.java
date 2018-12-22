/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Task extends Thread{
    
    int id;
    public Task(int id)
    {
        this.id=id;
    }
    public void run()
    {
        for (int i=0;i<150;i++)
        {
            Date d=new Date();
            System.out.println(d.getTime()+" : I am thread " + this.id + " Printing " + i);
        }
    }
    
    
}
