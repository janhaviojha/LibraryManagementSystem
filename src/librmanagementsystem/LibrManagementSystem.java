
  
package librmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LibrManagementSystem extends JFrame implements ActionListener{

        JLabel l1;
        JButton b1;
        
        public LibrManagementSystem() {
		
                setSize(1366,390);
                setLayout(null);
                setLocation(300,300);

		l1 = new JLabel("");
                b1 = new JButton("Next");
                
                b1.setBackground(new Color(165,42,42));
                b1.setForeground(Color.WHITE);
				
                
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("librmanagementsystem/icons/first.jpg"));
                Image i3 = i1.getImage().getScaledInstance(1366, 390,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                l1 = new JLabel(i2);
                
                b1.setBounds(1050,250,200,60);
		l1.setBounds(0, 0, 1366, 390);
                
                l1.add(b1);
		add(l1);
                
                b1.addActionListener(this);
	}
        
        public void actionPerformed(ActionEvent ae){
                new LoginFrame().setVisible(true);
                this.setVisible(false);
                
        }
        
        public static void main(String[] args) {
                LibrManagementSystem window = new LibrManagementSystem();
                window.setVisible(true);			
	}
}
