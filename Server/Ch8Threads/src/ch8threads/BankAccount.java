/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

/**
 *
 * @author ASUS
 */
public class BankAccount {
    private int ammount;
    public BankAccount()
    {
        ammount=0;
    }
    public  synchronized void Es7ab(int i,int value) throws InterruptedException
    {
        System.out.println("Sa7b " + value);
        int newbalance=ammount - value;
        //Thread.sleep(10);
        //ammount-=value;
        ammount=newbalance;
        System.out.println("3amlit sa7b rakm "+i+" Ma3ak " + ammount);
    }
    public synchronized void Eida3(int i,int value) throws InterruptedException
    {
        System.out.println("Eida3 " + value);
        int newbalance=ammount + value;
        Thread.sleep(10);
        //ammount-=value;
        ammount=newbalance;
        System.out.println("3amalit eida3 rakm "+i+" Ma3ak " + ammount);
    }
}
