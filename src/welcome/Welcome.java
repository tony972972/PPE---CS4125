/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package welcome;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
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

public class Welcome extends JFrame implements ActionListener {

    // String array for holding the locations of the images
    private String[] list = {
        "0.png"

    };

    private JButton new_game;
    private JButton join_game;
    private JButton showMyGame;
    private JButton showLeaderBoards;
    private String user_id;
    private String username;
    private JLabel pic;

    private Image img;
    private JLabel l1;
    private JPanel topJPanel;
    private JPanel centerJPanel;
    private JPanel bottomJPanel;
    private JMenuItem i1_menu, i2_menu, i3_menu, i4_menu, i5_menu;
    private JMenuItem i1_menuOptions, i2_menuOptions, i3_menuOptions;
    private JMenuItem i1_menuQuit;

    public Welcome(String username) {

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
        setImageSize(0);
        // create and position panels onto JFrame
        topJPanel = new JPanel(new BorderLayout());
        centerJPanel = new JPanel(new GridLayout(1, 0, 0, 0));
        bottomJPanel = new JPanel(new GridLayout(1, 0, 0, 0));
        // add panels to JFrame
        add(topJPanel, BorderLayout.NORTH);
        add(centerJPanel, BorderLayout.CENTER);
        add(bottomJPanel, BorderLayout.SOUTH);
        // add Buttons
        //bottomJPanel.add(new_game);
        //bottomJPanel.add(join_game);
        topJPanel.add(l1);
        //bottomJPanel.add(showLeaderBoards);
        //bottomJPanel.add(showMyGame);
        centerJPanel.add(pic);

        topJPanel.setBorder(new LineBorder(Color.BLUE, 1));
        centerJPanel.setBorder(new LineBorder(Color.BLUE, 1));
        bottomJPanel.setBorder(new LineBorder(Color.BLUE, 1));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Welcome " + username);

        setSize(800, 800);
        setResizable(false);
        this.setLocationRelativeTo(null);

        JMenu menu, menuOptions, menuQuit, submenu;

        // features of the menu
        JMenuBar mb = new JMenuBar();
        menu = new JMenu("orders");
        menuOptions = new JMenu("Purchase PPE");
        menuQuit = new JMenu("Logout/Quit");
        submenu = new JMenu("Sub Menu");
        i1_menu = new JMenuItem("Item 1");
        i2_menu = new JMenuItem("Item 2");
        i3_menu = new JMenuItem("Item 3");
        i4_menu = new JMenuItem("Item 4");
        i5_menu = new JMenuItem("Item 5");
        i1_menuOptions = new JMenuItem("Item 1");
        i2_menuOptions = new JMenuItem("Item 2");
        i3_menuOptions = new JMenuItem("Item 3");
        i1_menuQuit = new JMenuItem("Logout/Quit");
        i1_menu.addActionListener(this);
        i1_menuQuit.addActionListener(this);
        menu.add(i1_menu);
        menu.add(i2_menu);
        menu.add(i3_menu);
        submenu.add(i4_menu);
        submenu.add(i5_menu);
        menuOptions.add(i1_menuOptions);
        menuOptions.add(i2_menuOptions);
        menuOptions.add(i3_menuOptions);
        menuQuit.add(i1_menuQuit);
        menu.add(submenu);
        mb.add(menu);
        mb.add(menuOptions);
        mb.add(menuQuit);
        setJMenuBar(mb);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == i1_menu) {
            System.out.println("you clicked item 1");
        }
        if (e.getSource() == i1_menuQuit) {
            dispose();
        }
    }

    public void setImageSize(int i) {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("ppeOnline/images/" + list[i]));
        Image img = icon.getImage();
        Image newImage = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImage);
        pic.setIcon(newImc);
    } // setImageSize
}
