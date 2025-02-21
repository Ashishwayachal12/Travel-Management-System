package com.Ashish.wayachal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About extends JFrame implements ActionListener {

    JButton exitButton;
    JLabel titleLabel;
    JTextArea infoText;

    public About() {
        setTitle("TRAVEL AND TOURISM MANAGEMENT SYSTEM");
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/LOGO.png"));
        setIconImage(icon.getImage()); // Set window icon



        setSize(500, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(240, 240, 240));

        // Title Label
        titleLabel = new JLabel("About Project", JLabel.CENTER);
        titleLabel.setBounds(100, 20, 300, 40);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setForeground(new Color(255, 69, 0)); // Orange-red color
        mainPanel.add(titleLabel);

        // Project Info
        String aboutText = """
            The objective of the Travel and Tourism Management System project is 
            to develop a system that automates processes and activities of a travel agency.
            
            This application helps users access travel-related information 
            effortlessly and track tour details efficiently.
            
            ✦ Advantages of Project:
            ✅ Provides accurate information
            ✅ Simplifies manual work
            ✅ Reduces documentation efforts
            ✅ Keeps data up-to-date
            ✅ User-friendly with warning messages
            ✅ Traveler details are easily accessible
            ✅ Booking confirmation notifications
            """;


        infoText = new JTextArea(aboutText);
        infoText.setBounds(20, 80, 440, 300);
        infoText.setFont(new Font("Arial", Font.PLAIN, 14));
        infoText.setWrapStyleWord(true);
        infoText.setLineWrap(true);
        infoText.setEditable(false);
        infoText.setBackground(new Color(255, 250, 250));
        infoText.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        // Scroll Pane
        JScrollPane scrollPane = new JScrollPane(infoText);
        scrollPane.setBounds(20, 80, 440, 300);
        mainPanel.add(scrollPane);

        // Exit Button
        exitButton = new JButton("Exit");
        exitButton.setBounds(180, 420, 120, 30);
        exitButton.setFont(new Font("Arial", Font.BOLD, 14));
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(new Color(220, 20, 60)); // Crimson
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(this);
        mainPanel.add(exitButton);

        add(mainPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
    }

    public static void main(String[] args) {
        new About();
    }
}
