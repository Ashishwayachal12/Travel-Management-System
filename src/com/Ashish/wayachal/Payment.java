package com.Ashish.wayachal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Payment extends JFrame {

    public Payment() {
        setTitle("TRAVEL AND TOURISM MANAGEMENT SYSTEM");

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/LOGO.png"));
        setIconImage(icon.getImage());
        setResizable(false);
        setLayout(null);
        setBounds(500, 200, 850, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(null);
        headerPanel.setBounds(0, 0, 850, 80);
        headerPanel.setBackground(new Color(0, 102, 204));
        add(headerPanel);

        JLabel label = new JLabel("Pay Using Paytm");
        label.setFont(new Font("Raleway", Font.BOLD, 30));
        label.setForeground(Color.WHITE);
        label.setBounds(280, 20, 400, 40);
        headerPanel.add(label);

        // Payment Image (Reduced Size)
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i8 = i7.getImage().getScaledInstance(650, 300, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(i8));
        imageLabel.setBounds(100, 100, 650, 300);
        add(imageLabel);

        // Button Panel (Moved Higher)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(0, 430, 850, 80);
        buttonPanel.setBackground(new Color(245, 245, 245));
        add(buttonPanel);

        JButton pay = new JButton("Pay Now");
        pay.setFont(new Font("SansSerif", Font.BOLD, 16));
        pay.setBounds(310, 20, 120, 40);
        pay.setBackground(new Color(34, 177, 76));
        pay.setForeground(Color.WHITE);
        pay.setFocusPainted(false);
        pay.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        pay.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openPaymentWebsite("https://pay.google.com/"); // Change URL as needed
            }
        });
        buttonPanel.add(pay);

        JButton back = new JButton("Back");
        back.setFont(new Font("SansSerif", Font.BOLD, 16));
        back.setBounds(450, 20, 120, 40);
        back.setBackground(new Color(200, 0, 0));
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                // new Dashboard("");
            }
        });
        buttonPanel.add(back);

        setVisible(true);
    }

    // Function to open payment website in the default browser
    private void openPaymentWebsite(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            JOptionPane.showMessageDialog(this, "Error opening website", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Payment();
    }
}
