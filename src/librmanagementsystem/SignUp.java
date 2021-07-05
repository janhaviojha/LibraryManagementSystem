/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;

/**
 *
 * @author janha
 */
public class SignUp extends JFrame implements ActionListener{
    
    private JPanel panel;
    private JTextField textField1,textField2,textField3,textField4;
    private JComboBox comboBox;
    private JButton button1,button2;
    
    public static void main(String[] args) {
        new SignUp().setVisible(true);
    }
    public SignUp(){
        setBounds(600, 250, 606, 406);
	panel = new JPanel();
	panel.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(panel);
        panel.setBackground(Color.WHITE);
	panel.setLayout(null);

	JLabel lblUsername = new JLabel("Username :");
	lblUsername.setForeground(Color.DARK_GRAY);
	lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblUsername.setBounds(99, 86, 92, 26);
	panel.add(lblUsername);

	JLabel lblName = new JLabel("Name :");
	lblName.setForeground(Color.DARK_GRAY);
	lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblName.setBounds(99, 123, 92, 26);
	panel.add(lblName);

	JLabel lblPassword = new JLabel("Password :");
	lblPassword.setForeground(Color.DARK_GRAY);
	lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblPassword.setBounds(99, 160, 92, 26);
	panel.add(lblPassword);

	JLabel lblAnswer = new JLabel("Answer :");
	lblAnswer.setForeground(Color.DARK_GRAY);
	lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblAnswer.setBounds(99, 234, 92, 26);
	panel.add(lblAnswer);
        
        JLabel lblSecurityQuestion = new JLabel("Security Question :");
	lblSecurityQuestion.setForeground(Color.DARK_GRAY);
	lblSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblSecurityQuestion.setBounds(99, 197, 140, 26);
	panel.add(lblSecurityQuestion);
        
        comboBox=new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"Choose your security question","Your nickname?", "Your lucky number?",
            "Your chilhood superhero?","Your childhood name?"}));
        comboBox.setBounds(265,202,148,20);
        panel.add(comboBox);
        
        textField1 = new JTextField();
	textField1.setBounds(265, 91, 148, 20);
	panel.add(textField1);
	textField1.setColumns(10);
        
        textField2 = new JTextField();
	textField2.setColumns(10);
	textField2.setBounds(265, 128, 148, 20);
	panel.add(textField2);

        textField3 = new JTextField();
	textField3.setColumns(10);
	textField3.setBounds(265, 165, 148, 20);
	panel.add(textField3);

	textField4= new JTextField();
	textField4.setColumns(10);
	textField4.setBounds(265, 239, 148, 20);
	panel.add(textField4);
        
        button1 = new JButton("Create");
	button1.addActionListener(this);
	button1.setFont(new Font("Tahoma", Font.BOLD, 13));
	button1.setBounds(140, 289, 100, 30);
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
	panel.add(button1);

	button2 = new JButton("Back");
	button2.addActionListener(this);
	button2.setFont(new Font("Tahoma", Font.BOLD, 13));
	button2.setBounds(300, 289, 100, 30);
	button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
	panel.add(button2);
        
        JPanel panel2=new JPanel();
        panel2.setBorder(new TitledBorder(new LineBorder(new Color(128,128,0),2),"Create-Account",
        TitledBorder.LEADING,TitledBorder.TOP,null,new Color(34,139,34))); //2 is width of border, null is formatting
        
        panel2.setBounds(60,29,476,296);
        panel2.setBackground(Color.WHITE);
        panel.add(panel2);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       try{
           conn con=new conn();
           
           if(ae.getSource()==button1){
               String sql="insert into account(username,name,password,sec_q,sec_ans) values(?,?,?,?,?)";
               
               PreparedStatement st= con.c.prepareStatement(sql);
               
               st.setString(1, textField1.getText());
               st.setString(2, textField2.getText());
               st.setString(3, textField3.getText());
               st.setString(4, (String) comboBox.getSelectedItem());
               st.setString(5, textField4.getText());
               
               int i=st.executeUpdate(); //returns 0 or 1 if update was succesful
               if(i >0){
                   JOptionPane.showMessageDialog(null,"Account succesfully created");
               }
               textField1.setText("");
               textField2.setText("");
               textField3.setText("");
               textField4.setText("");
            }
               
               if(ae.getSource()==button2){
                   this.setVisible(false);
                   new LoginFrame().setVisible(true);
                }
           }
       
       catch(Exception ex){
           ex.printStackTrace();
       }
    }
    
    
    
    
}
