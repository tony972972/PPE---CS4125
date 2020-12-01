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
    private JLabel l1, l2, l3, l4, l5;
    private JTextField usernameField;
    private JButton btn1;
    private JPasswordField passwordField;
    private JTextField nameField;
    private JTextField surnameField;
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
        l2 = new JLabel("Name");
        l3 = new JLabel("Surname");
        l4 = new JLabel("User-name");
        l5 = new JLabel("Password");
        // JTextFields for entering in user details to register
        nameField = new JTextField();
        surnameField = new JTextField();
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        // add Button and ActionListener
        btn1 = new JButton("submit");
        btn1.addActionListener(this);
        // set positions of JLabels
        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        l4.setBounds(80, 150, 200, 30);
        l5.setBounds(80, 190, 200, 30);
        // set positions of JTextFields
        nameField.setBounds(300, 70, 200, 30);
        surnameField.setBounds(300, 110, 200, 30);
        usernameField.setBounds(300, 150, 200, 30);
        passwordField.setBounds(300, 190, 200, 30);
        // set position of JButton to Register
        btn1.setBounds(300, 230, 200, 30);
        // add the components to the JFrame
        add(l1);
        add(l2);
        add(nameField);
        add(l3);
        add(surnameField);
        add(l4);
        add(usernameField);
        add(l5);
        add(passwordField);
        add(btn1);
        // set size and show JFrame to user
        setSize(550, 330);
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // get reference to the Button pressed
        JButton source = (JButton) e.getSource();
        // get String from name TextField
        String name = nameField.getText();
        // get String from surname TextField
        String surname = surnameField.getText();
        // get String from user name TextField
        String userName = usernameField.getText();
        @SuppressWarnings("deprecation")
        // get String from password TextField
        String password = passwordField.getText();
   
        String registerAccount;

        if (source == btn1) {
            String err_msg = "";
            
            MySQLdata test = new MySQLdata();
            try {
                test.registerToDatabase(name, surname, userName, password);
                JOptionPane.showMessageDialog(this, "registered");
                this.setVisible(false);
                
                
            } catch (Exception ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
