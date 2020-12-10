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

public class PPEgloves extends JFrame implements ActionListener {

    

    private JButton gloves_1;
    private JButton gowns_2;
    private JButton footwear_3;
   
    private String username;
    private JLabel pic;

   
    private JLabel l1;
    private JPanel topJPanel;
   
    private JMenuItem i1_menu, i2_menu, i3_menu, i4_menu, i5_menu;
    private JMenuItem i1_menuOptions, i2_menuOptions, i3_menuOptions;
    private JMenuItem i1_menuQuit;
//2nd menu option goves,gowns and shoe covers...
    public PPEgloves(String username) {

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
        
        ImageIcon ii = new ImageIcon(ClassLoader.getSystemResource("ppeOnline/images/gloves.jpeg"));
        JLabel label1=new JLabel(ii);

        Icon icon = new ImageIcon(ClassLoader.getSystemResource("ppeOnline/images/gowns.jpg"));
        JLabel label2 = new JLabel(icon);
        
        Icon icon2 = new ImageIcon(ClassLoader.getSystemResource("ppeOnline/images/shoes.jpg"));
        JLabel label3 = new JLabel(icon2);
        
        gloves_1 = new JButton("Protective Gloves");
        gowns_2 = new JButton("Disposable gowns");
        footwear_3 = new JButton("Disposable Shoe covers");
        
        GridBagConstraints c = new GridBagConstraints();
        JPanel pContainer = new JPanel(new GridBagLayout());
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(30,30,30,30);
        pContainer.add(label1,c);
        c.gridx = 1;
        c.gridy = 0;
        pContainer.add(gloves_1,c);
        c.gridx = 0;
        c.gridy = 1;
        pContainer.add(label2,c);
        c.gridx = 1;
        c.gridy = 1;
        pContainer.add(gowns_2,c);
        c.gridx = 0;
        c.gridy = 2;
        pContainer.add(label3,c);
        c.gridx = 1;
        c.gridy = 2;
        pContainer.add(footwear_3,c);
        
        JScrollPane jsp=new JScrollPane(pContainer);
        add(jsp);

        setSize(800, 800);
        setResizable(false);
        this.setLocationRelativeTo(null);
        setVisible(true);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == i1_menu) {
            System.out.println("you clicked item 2");
        }
        if (e.getSource() == i1_menuQuit) {
            dispose();
        }
    }

    /*public void setImageSize(int i) {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("ppeOnline/images/" + list[i]));
        Image img = icon.getImage();
        Image newImage = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImage);
        pic.setIcon(newImc);
    } // setImageSize*/
}