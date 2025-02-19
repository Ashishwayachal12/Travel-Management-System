package com.Ashish.wayachal;

import javax.swing.*;
import javax.swing.JButton;
//import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JRadioButton;
//import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
//import javax.swing.border.Border;
//import javax.swing.border.LineBorder;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.sql.Statement;

public class ViewCustomer extends JFrame implements ActionListener {
    JButton back;
    JPanel panel;

    public ViewCustomer(String username) {
        setTitle("Travel and Tourism Management System");
        setBounds(350, 150, 900, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/LOGO.png"));
        setIconImage(icon.getImage());

        // Background Image
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/tent-4558240_1.jpg"));
        Image bgImage = bgIcon.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(bgImage));
        background.setBounds(0, 0, 900, 600);
        add(background);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(50, 50, 780, 450);
        panel.setBackground(new Color(255, 255, 255, 200)); // Semi-transparent panel
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        background.add(panel);

        JLabel title = new JLabel("Customer Details");
        title.setFont(new Font("Serif", Font.BOLD, 24));
        title.setBounds(300, 20, 300, 30);
        panel.add(title);

        String[] labels = {"Username", "ID", "Number", "Name", "Gender", "Country", "Address", "Phone", "Email"};
        int y = 70;
        JLabel[] valueLabels = new JLabel[labels.length];

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i] + ":");
            label.setFont(new Font("SansSerif", Font.BOLD, 16));
            label.setBounds(50, y, 150, 30);
            panel.add(label);

            valueLabels[i] = new JLabel();
            valueLabels[i].setFont(new Font("SansSerif", Font.PLAIN, 16));
            valueLabels[i].setBounds(220, y, 300, 30);
            panel.add(valueLabels[i]);

            if (i == 4) y += 40; // Adjust spacing for alignment
            else y += 50;
        }

        // Fetch data from database
        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM customer WHERE username='" + username + "'";
            ResultSet rs = conn.s.executeQuery(query);
            if (rs.next()) {
                for (int i = 0; i < labels.length; i++) {
                    valueLabels[i].setText(rs.getString(labels[i].toLowerCase()));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading data", "Error", JOptionPane.ERROR_MESSAGE);
        }

        back = new JButton("Back");
        back.setFont(new Font("SansSerif", Font.BOLD, 14));
        back.setBounds(460, 400, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFocusable(false);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(this);
        panel.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new ViewCustomer("");
    }
}


