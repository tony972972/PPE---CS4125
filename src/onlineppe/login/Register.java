/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineppe.login;
import database.MySQLdata;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 *
 * @author tony
 */
public class Register extends JFrame implements ActionListener {

    // Instance Variables
    private JLabel l1, l2, l3, l4, l5,l6,l7,l8,l9;
    private JTextField usernameField;
    private JButton btn1;
    private JPasswordField passwordField;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField customer_ID;
    private JTextField phoneNumber;
    private JTextField address;
    
    private int uid, gid;
    private String word;

    /**
     * Register Constructor used to show JFrame for Registering an Account 
     */
    public Register() {

        super("Registation");
        l1 = new JLabel("Register Here to access store");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        // JLabels for name, Surname, User-Name and Password
        l2 = new JLabel("Customer-ID");
        l3 = new JLabel("Username");
        l4 = new JLabel("Last-Name");
        l5 = new JLabel("First-Name");
        l6 = new JLabel("Password");
        l7 = new JLabel("Phone Number");
        l8 = new JLabel("Address");
        
        
        // JTextFields for entering in user details to register
        customer_ID = new JTextField();
        usernameField = new JTextField();
        surnameField = new JTextField();
        nameField = new JTextField();
        passwordField = new JPasswordField();
        phoneNumber = new JTextField();
        address = new JTextField();
        // add Button and ActionListener
        btn1 = new JButton("submit");
        btn1.addActionListener(this);
        // set positions of JLabels
        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        l4.setBounds(80, 150, 200, 30);
        l5.setBounds(80, 190, 200, 30);
        l6.setBounds(80, 230, 200, 30);
        l7.setBounds(80, 270, 200, 30);
        l8.setBounds(80, 310, 200, 30);
        
        // set positions of JTextFields
        customer_ID.setBounds(300, 70, 200, 30);
        usernameField.setBounds(300, 110, 200, 30);
        surnameField.setBounds(300, 150, 200, 30);
        nameField.setBounds(300, 190, 200, 30);
        passwordField.setBounds(300, 230, 200, 30);
        phoneNumber.setBounds(300,270, 200,30);
        address.setBounds(300, 310, 200, 30);
        // set position of JButton to Register
        btn1.setBounds(300, 350, 200, 30);
        // add the components to the JFrame
        add(l1);
        add(l2);
        add(customer_ID);
        
        add(l3);
        add(usernameField);
        add(l4);
        add(surnameField);
        add(l5);
        add(nameField);
        add(l6);
        add(passwordField);
        add(l7);
        add(phoneNumber);
        add(l8);
        add(address);
        add(btn1);
        // set size and show JFrame to user
        setSize(600, 500);
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // get reference to the Button pressed
        JButton source = (JButton) e.getSource();
        // get String from name TextField
        int customerID = Integer.parseInt(customer_ID.getText());
        String userName = usernameField.getText();
        String surname = surnameField.getText();
        String name = nameField.getText();
        @SuppressWarnings("deprecation")
        // get String from password TextField
        String password = passwordField.getText();
        String phoneNum = phoneNumber.getText();
        String address1 = address.getText();
        // get String from surname TextField
        
        // get String from user name TextField
        
        
   
        String registerAccount;

        if (source == btn1) {
            String err_msg = "";
            
            MySQLdata test = new MySQLdata();
            try {
                test.registerToDatabase(customerID, userName, surname, name, password,phoneNum, address1);
                JOptionPane.showMessageDialog(this, "registered");
                this.setVisible(false);
                
                
            } catch (Exception ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
