package com.Ashish.wayachal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class ViewPackage extends JFrame implements ActionListener {
    private JButton back;
    private JPanel panel;
    private JLabel[] valueLabels;

    public ViewPackage(String username) {
        setTitle("Travel and Tourism Management System");
        setBounds(350, 150, 900, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting application icon
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/LOGO.png"));
        setIconImage(icon.getImage());

        // Background Image
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image bgImage = bgIcon.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(bgImage));
        background.setBounds(0, 0, 900, 600);
        add(background);

        // Panel for details
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(50, 50, 780, 450);
        panel.setBackground(new Color(255, 255, 255, 200));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        background.add(panel);

        JLabel title = new JLabel("Booked Details");
        title.setFont(new Font("Serif", Font.BOLD, 24));
        title.setBounds(300, 20, 300, 30);
        panel.add(title);

        // Label names for details
        String[] labels = {"Username", "Package", "Person", "Id", "Number", "Phone", "Price"};
        valueLabels = new JLabel[labels.length];

        int y = 70;
        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i] + ":");
            label.setFont(new Font("SansSerif", Font.BOLD, 16));
            label.setBounds(50, y, 150, 30);
            panel.add(label);

            valueLabels[i] = new JLabel();
            valueLabels[i].setFont(new Font("SansSerif", Font.PLAIN, 16));
            valueLabels[i].setBounds(220, y, 300, 30);
            panel.add(valueLabels[i]);

            y += 50;
        }

        // Fetch data from the database securely
        fetchData(username);

        // Back button
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

    private void fetchData(String username) {
        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM bookpackage WHERE username = ?";
            PreparedStatement pstmt = conn.c.prepareStatement(query);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String[] dbColumns = {"username", "package", "persons", "id", "number", "phone", "price"};
                for (int i = 0; i < dbColumns.length; i++) {
                    valueLabels[i].setText(rs.getString(dbColumns[i]));
                }
            } else {
                JOptionPane.showMessageDialog(this, "No booking found for user: " + username, "Info", JOptionPane.INFORMATION_MESSAGE);
            }

            rs.close();
            pstmt.close();
            conn.c.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading data from database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(true);
        dispose(); // Ensure proper memory cleanup
    }

    public static void main(String[] args) {
        new ViewPackage("");
    }
}
