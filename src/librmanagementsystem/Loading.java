/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librmanagementsystem;
import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;
//import java.sql.*;

/**
 *
 * @author janha
 */
public class Loading extends JFrame implements  Runnable{
    
    private JPanel panel;
    private JProgressBar progressBar;
    //Connection c;//interfcae hai Connection
    int s;
    Thread th;
    public static void main(String[] args) {
        new Loading().setVisible(true);
    }
    public void setUploading(){
        
        th.start();
        
    }
    public void run(){
        try{
            for(int i=0;i<100;i++){
                //s=s+1;
                int m=progressBar.getMaximum();
                int v=progressBar.getValue();
                if(v<m){
                    progressBar.setValue(progressBar.getValue()+1);
                    Thread.sleep(30);
                }
            }
                //else{
                    //i=101;
                    
                    new Home().setVisible(true);
                    this.setVisible(false);
                //}
                
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public Loading(){
        super("Loading");
        th=new Thread((this));
        
        setBounds(600, 300, 600, 400);
        panel=new JPanel();
        setContentPane(panel);
        panel.setLayout(null);
        
            JLabel libraryManagement = new JLabel("Smart Library");
            libraryManagement.setForeground(new Color(72, 209, 204));
            libraryManagement.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
            libraryManagement.setBounds(170, 46, 500, 35);
            panel.add(libraryManagement);
            
            progressBar = new JProgressBar();
            progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
            progressBar.setStringPainted(true); //needs explanation
            progressBar.setBounds(130, 135, 300, 25);
            panel.add(progressBar);
            
            JLabel lblNewLabel_2 = new JLabel("Please Wait....");
            lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
            lblNewLabel_2.setForeground(new Color(160, 82, 45));
            lblNewLabel_2.setBounds(200, 165, 150, 20);
            panel.add(lblNewLabel_2);
            
            setUploading();
        
            
    }
    
    
}
