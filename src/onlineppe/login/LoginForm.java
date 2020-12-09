/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineppe.login;

import database.MySQLdata;

/**
 *
 * @author tony and Jon
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JFrame implements ActionListener {

    private JLabel l1, l2, l3;
    private JTextField usernameField;
    private JButton btn1;
    private JButton btn2;
    private JPasswordField passwordField;

    /**
     * Login Constructor to show JFrame to the user to Login to Game
     */
    public LoginForm() {
        super("Login Form");
        l1 = new JLabel("Login Form");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));

        l2 = new JLabel("Username");
        l3 = new JLabel("Password");
        usernameField = new JTextField("tony");
        passwordField = new JPasswordField("123");
        btn1 = new JButton("Login");
        btn1.addActionListener(this);
        btn2 = new JButton("Register");
        btn2.addActionListener(this);

        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        usernameField.setBounds(300, 70, 200, 30);
        passwordField.setBounds(300, 110, 200, 30);
        btn1.setBounds(150, 160, 100, 30);
        btn2.setBounds(270, 160, 100, 30);

        add(l1);
        add(l2);
        add(usernameField);
        add(l3);
        add(passwordField);
        add(btn1);
        add(btn2);

        setSize(550, 270);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // actionperformed method 
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String uname = usernameField.getText();
        @SuppressWarnings("deprecation")
        String pass = passwordField.getText();
        MySQLdata login = new MySQLdata();
        // new comment
        if (source == btn1) {
            if (uname.equals("") || pass.equals("")) {
                JOptionPane.showMessageDialog(this, "please supply login and password",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    login.verifyLogin(uname, pass);
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        } else if (source == btn2) {
            new Register();
      }
   }

} // class

