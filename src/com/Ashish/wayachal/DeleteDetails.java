package com.Ashish.wayachal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

public class DeleteDetails extends JFrame implements ActionListener {
    JButton delete, back;
    JPanel panel;
    String username;

    public DeleteDetails(String username) {
        this.username = username;
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

        JLabel title = new JLabel("Personal Details");
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

        // Delete Button
        delete = new JButton("Delete");
        delete.setFont(new Font("SansSerif", Font.BOLD, 14));
        delete.setBounds(460, 400, 100, 30);
        delete.setBackground(Color.RED);
        delete.setForeground(Color.WHITE);
        delete.setFocusable(false);
        delete.setBorder(BorderFactory.createEmptyBorder());
        delete.addActionListener(this);
        panel.add(delete);

        // Back Button
        back = new JButton("Back");
        back.setFont(new Font("SansSerif", Font.BOLD, 14));
        back.setBounds(320, 400, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFocusable(false);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(e -> setVisible(false));
        panel.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete your details?", "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                try {
                    Conn c = new Conn();
                    c.s.executeUpdate("DELETE FROM account WHERE username='" + username + "'");
                    c.s.executeUpdate("DELETE FROM customer WHERE username='" + username + "'");
                    c.s.executeUpdate("DELETE FROM bookpackage WHERE username='" + username + "'");
                    c.s.executeUpdate("DELETE FROM bookhotel WHERE username='" + username + "'");

                    JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error deleting data", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public static void main(String[] args) {
        new DeleteDetails("");
    }
}
