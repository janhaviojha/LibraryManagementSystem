/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librmanagementsystem;
import java.sql.*;

/**
 *
 * @author janha
 */
public class conn {
     Connection c;
     Statement s;
     public conn(){
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
                     //class is a java class with static method forName (registering driver class)
             c= DriverManager.getConnection("jdbc:mysql:///librarymanagement","root","12345");
             //databaselib is the database where ill store my tables, root is username and then password (creating connection)
             s=c.createStatement();
             // creating statement, used to execute sql queries
         }
         catch(Exception e){
             System.out.println(e);
         }
     }
    
}
