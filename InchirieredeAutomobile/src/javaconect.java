/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stroescu Andrei
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class javaconect {
    Connection conn;
    
    public static Connection getConnection(){
        Connection conn=null;
        
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost/masini","root","");
            //JOptionPane.showMessageDialog(null,"Conectat!");
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(AdaugatiAutomobil.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(null,"Deconectat!");
            return null;
        }
    }
}