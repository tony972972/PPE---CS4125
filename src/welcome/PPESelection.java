/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package welcome;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.nio.file.Files.list;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.border.LineBorder;

public class PPESelection extends JFrame implements ActionListener{

     // String array for holding the locations of the images
    private String[] list = {
        "0.png",
        "1.png",
        "2.png",
        "3.png",
        "4.png",
        "5.png",
        "6.png",
        "7.png",
        "8.png"
    };

    private JButton mask_1;
    private JButton mask_2;
    private JButton mask_3;
   
    private String username;
    private JLabel pic;

   
    private JLabel l1;
    private JPanel topJPanel;
   
    private JMenuItem i1_menu, i2_menu, i3_menu, i4_menu, i5_menu;
    private JMenuItem i1_menuOptions, i2_menuOptions, i3_menuOptions;
    private JMenuItem i1_menuQuit;

    public PPESelection(String username) {

        this.username = username;

        topJPanel = new JPanel();
        pic = new JLabel();

        l1 = new JLabel("Welcome to the Online Store " + username, SwingConstants.CENTER);
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l1.setBounds(100, 30, 300, 50);
        pic.setBounds(40, 30, 800, 750);

        // create image to display
        //ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/welcome1.png"));
        //Image img = icon.getImage();
        //Image newImage = img.getScaledInstance(469, 450, Image.SCALE_SMOOTH);
        //ImageIcon newImc = new ImageIcon(newImage);
        //pic.setIcon(newImc);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Welcome " + username);
        
        ImageIcon ii = new ImageIcon(ClassLoader.getSystemResource("ppeOnline/images/mask_1.png"));
        JLabel label1=new JLabel(ii);

        Icon icon = new ImageIcon(ClassLoader.getSystemResource("ppeOnline/images/mask_2.jpg"));
        JLabel label2 = new JLabel(icon);
        
        Icon icon2 = new ImageIcon(ClassLoader.getSystemResource("ppeOnline/images/mask_3.png"));
        JLabel label3 = new JLabel(icon2);
        
        mask_1 = new JButton("Standard Mask");
        mask_2 = new JButton("Custom Mask");
        mask_3 = new JButton("Shield");
        
        GridBagConstraints c = new GridBagConstraints();
        JPanel pContainer = new JPanel(new GridBagLayout());
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(30,30,30,30);
        pContainer.add(label1,c);
        c.gridx = 1;
        c.gridy = 0;
        pContainer.add(mask_1,c);
        c.gridx = 0;
        c.gridy = 1;
        pContainer.add(label2,c);
        c.gridx = 1;
        c.gridy = 1;
        pContainer.add(mask_2,c);
        c.gridx = 0;
        c.gridy = 2;
        pContainer.add(label3,c);
        c.gridx = 1;
        c.gridy = 2;
        pContainer.add(mask_3,c);
        
        JScrollPane jsp=new JScrollPane(pContainer);
        add(jsp);

        setSize(800, 800);
        setResizable(false);
        this.setLocationRelativeTo(null);
        setVisible(true);
        

    }

   
    
    
 @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == mask_1) {
            JOptionPane.showMessageDialog(null, "You added standard mask to cart", "Added to cart!" , JOptionPane.INFORMATION_MESSAGE);
        }
         if (e.getSource() == mask_2) {
            JOptionPane.showMessageDialog(null, "You added Custom mask to cart", "Added to cart!" , JOptionPane.INFORMATION_MESSAGE);
            
         }
        if (e.getSource() == mask_3) {
           JOptionPane.showMessageDialog(null, "You added shield mask to cart", "Added to cart!" , JOptionPane.INFORMATION_MESSAGE);
             
        }
        
    }

    public void setImageSize(int i) {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("ppeOnline/images/" + list[i]));
        Image img = icon.getImage();
        Image newImage = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImage);
        pic.setIcon(newImc);
    }

    
}
