package com.Ashish.wayachal;

import javax.swing.*;
import java.awt.*;

public class checkpackage extends JFrame {

    public checkpackage(String username)
    {
//        this.username=username;
        setTitle("TRAVEL AND TOURISM MANAGEMENT SYSTEM");

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/LOGO.png"));
        setIconImage(icon.getImage()); // Add logo to the window icon

        setResizable(false);
        setBounds(500,200,850,550);
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0, 0, 425, 550);
        p1.setLayout(null);
        add(p1);


        setVisible(true);
    }

    public static void main(String[] args) {
        new checkpackage("");

    }
}
