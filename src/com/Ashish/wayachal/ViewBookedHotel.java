package com.Ashish.wayachal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

public class ViewBookedHotel extends JFrame implements ActionListener {
    JButton back;
    JPanel panel;

    public ViewBookedHotel(String username) {
        setTitle("Booked Hotel Details");
        setBounds(350, 150, 900, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/LOGO.png"));
        setIconImage(icon.getImage());

        // Background Image
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/hotel1.jpg"));
        Image bgImage = bgIcon.getImage().getScaledInstance(900, 500, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(bgImage));
        background.setBounds(0, 0, 900, 500);
        add(background);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(50, 50, 780, 350);
        panel.setBackground(new Color(255, 255, 255, 200)); // Semi-transparent panel
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        background.add(panel);

        JLabel title = new JLabel("Hotel Booking Details");
        title.setFont(new Font("Serif", Font.BOLD, 24));
        title.setBounds(280, 20, 300, 30);
        panel.add(title);

        // Booking Details Labels (Updated to match table columns)
        String[] labels = {
                "Username", "Hotel", "Persons", "Days", "Total Price"
        };

        int y = 70;
        JLabel[] valueLabels = new JLabel[labels.length];

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i] + ":");
            label.setFont(new Font("SansSerif", Font.BOLD, 16));
            label.setBounds(50, y, 200, 30);
            panel.add(label);

            valueLabels[i] = new JLabel();
            valueLabels[i].setFont(new Font("SansSerif", Font.PLAIN, 16));
            valueLabels[i].setBounds(260, y, 300, 30);
            panel.add(valueLabels[i]);

            y += 50; // Maintain spacing
        }

        // Fetch data from database (Corrected query)
        try {
            Conn conn = new Conn();
            String query = "SELECT username, hotel, persons, days, total_price FROM bookHotel WHERE username='" + username + "'";
            ResultSet rs = conn.s.executeQuery(query);
            if (rs.next()) {
                for (int i = 0; i < labels.length; i++) {
                    valueLabels[i].setText(rs.getString(i + 1)); // Fetch data dynamically
                }
            } else {
                JOptionPane.showMessageDialog(null, "No bookings found for " + username, "No Data", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading data", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Back Button
        back = new JButton("Back");
        back.setFont(new Font("SansSerif", Font.BOLD, 14));
        back.setBounds(460, 280, 100, 30);
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
        new ViewBookedHotel("Ashish12");
    }
}
