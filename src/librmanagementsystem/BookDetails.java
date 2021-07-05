/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librmanagementsystem;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author janha
 */
public class BookDetails extends JFrame implements ActionListener{
    
    private JPanel contentPane;
    private JTable table;
    private JTextField search;
    private JButton b1,b2,b3;
    
     public static void main(String[] args) {
	new BookDetails().setVisible(true);
    }
     public void Book() {
	try {
            conn con = new conn();
            String sql = "select * from book";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
            
            catch (Exception e) {
                e.printStackTrace();
	}
    }
    public BookDetails(){
        setBounds(350, 200, 970, 600);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(79, 133, 771, 282);
	contentPane.add(scrollPane);
        
        table=new JTable();
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me){
                int row=table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 1).toString()+table.getModel().getValueAt(row,0).toString());
            }
        });
        
        table.setBackground(new Color(240, 248, 255));
	table.setForeground(Color.DARK_GRAY);
	table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
	scrollPane.setViewportView(table);
        
        
        b1=new JButton("Search");
        b1.addActionListener(this);
        b1.setBorder(new LineBorder(new Color(255,20,147),2,true));
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("librmanagementsystem/icons/eight.png"));
        Image i2=i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        b1.setIcon(i3);
        b1.setForeground(new Color(199, 21, 133));
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
	b1.setBounds(564, 89, 138, 33);
	contentPane.add(b1);
        
        b2 = new JButton("Delete");
	b2.addActionListener(this);
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("librmanagementsystem/icons/nineth.png"));
        Image i5=i4.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i6= new ImageIcon(i5);
        b2.setIcon(i6);
        b2.setForeground(new Color(199, 21, 133));
	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
	b2.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));
	b2.setBounds(712, 89, 138, 33);
	contentPane.add(b2);
        
        JLabel l1 = new JLabel("Book Details");
	l1.setForeground(new Color(107, 142, 35));
	l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
	l1.setBounds(300, 15, 400, 47);
	contentPane.add(l1);

        //JLabel l2=new JLabel("search");
	search = new JTextField();
	search.setBackground(new Color(255, 240, 245));
	search.setBorder(new LineBorder(new Color(255, 105, 180), 2, true));
	search.setForeground(new Color(47, 79, 79));
	search.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
	search.setBounds(189, 89, 357, 33);
	contentPane.add(search);
	//search.setColumns(10);
        
        b3 = new JButton("Back");
	b3.addActionListener(this);
        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("librmanagementsystem/icons/tenth.png"));
        Image i8=i7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i9= new ImageIcon(i8);
        b3.setIcon(i9);
        b3.setForeground(new Color(199, 21, 133));
	b3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
	b3.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));
	b3.setBounds(90, 89, 88, 33);
	contentPane.add(b3);
        
        JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 128), 3, true), "Book-Details",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
	panel.setBounds(67, 54, 793, 368);
	contentPane.add(panel);
        panel.setBackground(Color.WHITE);
        
	Book();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            conn con=new conn();
            int rs=0;
            if(ae.getSource()==b1){
                String sql="select * from book where concat(name,book_id) like ?";
                PreparedStatement st=con.c.prepareStatement(sql);
                st.setString(1,"%"+search.getText()+"%");
                //st.setString(1, search.getText());
                ResultSet res = st.executeQuery();

		table.setModel(DbUtils.resultSetToTableModel(res));
            }
            if(ae.getSource()==b2){
                String sql="delete from book where concat(name,book_id) like ?";
                PreparedStatement st=con.c.prepareStatement(sql);
                st.setString(1,"%"+search.getText()+"%");
                
                int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
                 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                
		 if (response == JOptionPane.YES_OPTION) {
                    rs = st.executeUpdate();
                    /*String sql2="select * from book";
                    PreparedStatement st2=con.c.prepareStatement(sql2);
                    ResultSet res= st2.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(res));*/
                    Book();
                    if(rs>0){
                        JOptionPane.showMessageDialog(null, "Successfully Deleted !!");
                    }
                else{
                    JOptionPane.showMessageDialog(null,"Could not delete, try again");
                }
                 }
                    
            }
            if(ae.getSource()==b3){
                this.setVisible(false);
                new Home().setVisible(true);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
}
