/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import sun.security.util.Password;




/**
 *
 * @author janha
 */
public class LoginFrame extends JFrame implements  ActionListener{
    private JPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton b1,b2,b3;
    
    public LoginFrame(){
        setLayout(null);
        setBackground(new Color(169,169,169));
        setBounds(600, 300, 600, 400);
        
        panel=new JPanel();
        panel.setBackground(new Color(176,224,230));
        setContentPane(panel);
        //to cover full frame
        panel.setLayout(null);
        
        JLabel label1=new JLabel("Username : ");
        label1.setBounds(124, 89, 95, 24);
        panel.add(label1);
        
        JLabel label2=new JLabel("Password : ");
        label2.setBounds(124, 124, 95, 24);
        panel.add(label2);
        
        textField= new JTextField();
        textField.setBounds(210, 93, 157, 20);
        panel.add(textField);
        
        passwordField=new JPasswordField();
        passwordField.setBounds(210, 128, 157, 20);
        panel.add(passwordField);
                
         b1=new JButton("Login");
         b1.addActionListener(this);
         b1.setForeground(new Color(46,139,7)); //text colour
         b1.setBackground(new Color(250,250,210));
         b1.setBounds(149,181,113,39);
         panel.add(b1);
         
         b2=new JButton("SignUp");
         b2.addActionListener(this);
         b2.setForeground(new Color(46,139,7)); //text colour
         b2.setBackground(new Color(250,250,210));
         b2.setBounds(289,181,113,39);
         panel.add(b2);
         
         b3=new JButton("Forgot Password");
         b3.addActionListener(this);
         b3.setForeground(new Color(46,139,7)); //text colour
         b3.setBackground(new Color(250,250,210));
         b3.setBounds(199,231,179,39);
         panel.add(b3);
         
         JLabel l3=new JLabel("Trouble in Login?");
         l3.setFont(new Font("Tahoma",Font.PLAIN, 15));
         l3.setForeground(new Color(255,0,0));
         l3.setBounds(70, 240, 130, 20);
         panel.add(l3);
         
        
    }
         @Override
         public void actionPerformed(ActionEvent ae){
             if(ae.getSource()==b1){
                 boolean status=false;
                 try{
                    conn con=new conn();
                    // ? to check if input matches uname pass in table
                    String sql="select * from account where username=? and password=?";
                    PreparedStatement st=con.c.prepareStatement(sql);
                    
                    st.setString(1, textField.getText());
                    st.setString(2, new String(passwordField.getPassword()));
                    
                    ResultSet rs= st.executeQuery();
                    if(rs.next()){
                        this.setVisible(false);//this is the login frame, to close it and open loading frame
                         new Loading().setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Invalid Login credentials.");
                        //null for formatting like warning or soemthing (doubt)
                    }
                 }
                 catch (Exception e){
                     e.printStackTrace();
                 }
                 
                 
                 
             }
             if(ae.getSource()==b2){
                 this.setVisible(false);
                 new SignUp().setVisible(true);
             }
             if(ae.getSource()==b3){
                 this.setVisible(false);
                 new ForgotPassword().setVisible(true);
             }
        }
         public static void main(String[] args) {
                new LoginFrame().setVisible(true);
    }
}
