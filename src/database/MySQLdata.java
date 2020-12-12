/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import welcome.Welcome;

/**
 *
 * @author tonys
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MySQLdata{
    
    // Instance Variables
    
    private JButton btnGuessButton;
    private JButton btnPlayButton;
    private JLabel pic;
    private JLabel livesLeft;
    private JLabel correctWord;
    private JLabel guessWord;
    private JTextField enter_a_letter;
    private int livesRemaining = 8;
    private Connection connect = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private char[] usersGuess;
    private String correctWordReturned = "";
    private String letterReceived = "";
    private Timer tm;
    private int tmCounter = 0;
    
    
    public void registerToDatabase(int customer_id, String username, String lastName, String firstName, String pass, String phone, String address) throws Exception {
        try {
            //"jdbc:mysql://localhost/hangman"
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/CLASSICMODELS", "root", "");
            
            String query = " insert into customers (customerNumber, customerName, contactLastName, contactFirstName, Password, phone, addressLine1)"
                    + " values (?, ?, ?, ?, ?, ?, ?)";
            
             preparedStatement = connect
          .prepareStatement(query);
      // "myuser, webpage, datum, summery, COMMENTS from FEEDBACK.COMMENTS");
      // Parameters start with 1
      preparedStatement.setInt(1, customer_id);
      preparedStatement.setString(2, username);
      preparedStatement.setString(3, lastName);
      preparedStatement.setString(4, firstName);
      preparedStatement.setString(5, pass);
      preparedStatement.setString(6, phone);
      preparedStatement.setString(7, address);
      preparedStatement.executeUpdate();
      
           

        } catch (ClassNotFoundException | SQLException e) {
      throw e;
    } finally {
      close();
    }

    } // connectToDatabase
    
    @SuppressWarnings("empty-statement")
    public void verifyLogin(String username, String password) throws SQLException, ClassNotFoundException{
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
             // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/CLASSICMODELS", "root", "");
            
             preparedStatement = connect
          .prepareStatement("select customerName, Password from classicmodels.CUSTOMERS where customerName=? and Password=?");
             preparedStatement.setString(1,username);
             preparedStatement.setString(2,password);
             ResultSet rs = preparedStatement.executeQuery();
             if(rs.next()){
                 Welcome screen = new Welcome(username);
                 screen.setVisible(true);
               
                 
             }else{
                 JOptionPane.showMessageDialog(btnPlayButton,"You have entered wrong information...try again!!");
             }
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLdata.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }finally{
            close();
        }
           
    }
    
        private void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

     

      if (connect != null) {
        connect.close();
      }
    } catch (SQLException e) {

    }
  }
}




