package com.Ashish.wayachal;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckPackage extends JFrame implements ActionListener {
    private String username;

    public CheckPackage(String username) {
        this.username = username; // Store username

        setTitle("TRAVEL AND TOURISM MANAGEMENT SYSTEM");
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/LOGO.png"));
        setIconImage(icon.getImage()); // Set window icon

        setResizable(false);
        setBounds(350, 150, 1000, 700);
        getContentPane().setBackground(Color.white);

        // Package details
        String[][] packages = {
                {"icons/package1.jpg", "GOLD PACKAGE", "6 days and 7 Nights", "Airport Assistance at Airport",
                        "Half Day City Tour", "Welcome drinks on Arrival", "Daily Buffet", "Full Day 3 Island Cruise",
                        "English Speaking Guide", "BOOK NOW", "Summer Special", "Rs 32,000 only"},
                {"icons/package2.jpg", "SILVER PACKAGE", "5 days and 5 Nights", "Toll Free and Entrance Free Tickets",
                        "Meet and Greet at Airport", "Welcome drinks on Arrival", "Night Safari", "Full Day 3 Island Cruise",
                        "Cruise with Dinner", "BOOK NOW", "Winter Special", "Rs 25,000 only"},
                {"icons/package3.jpg", "BRONZE PACKAGE", "4 days and 5 Nights", "Return Airfare",
                        "Free Clubbing, Horse Riding & other Games", "Welcome drinks on Arrival", "Daily Buffet",
                        "Stay in 5 Star Hotel", "BBQ Dinner", "BOOK NOW", "Winter Special", "Rs 12,000 only"}
        };

        // Tabbed Pane for packages
        JTabbedPane tabbedPane = new JTabbedPane();
        Color[] colors = {new Color(255, 215, 0), new Color(192, 192, 192), new Color(205, 127, 50)};

        for (int i = 0; i < packages.length; i++) {
            tabbedPane.addTab(packages[i][1], null, createPackagePanel(packages[i], colors[i]));
        }

        add(tabbedPane);
        setVisible(true);
    }

    // Method to create package panels dynamically
    private JPanel createPackagePanel(String[] pack, Color titleColor) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.white);
        panel.setBorder(new LineBorder(Color.BLACK, 2, true));

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(titleColor);
        JLabel titleLabel = new JLabel(pack[1], SwingConstants.CENTER);
        titleLabel.setFont(new Font("SAN SERIF", Font.BOLD, 28));
        titleLabel.setForeground(Color.BLACK);
        headerPanel.add(titleLabel);
        panel.add(headerPanel, BorderLayout.NORTH);

        // Content Panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.white);

        // Package Image
        ImageIcon packageIcon = new ImageIcon(ClassLoader.getSystemResource(pack[0]));
        Image packageImage = packageIcon.getImage().getScaledInstance(450, 300, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(packageImage));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(imageLabel);

        // Details
        for (int i = 2; i <= 8; i++) {
            JLabel detailLabel = new JLabel("• " + pack[i], SwingConstants.CENTER);
            detailLabel.setFont(new Font("SAN SERIF", Font.PLAIN, 18));
            detailLabel.setForeground(i % 2 == 0 ? Color.BLUE : Color.DARK_GRAY);
            detailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            contentPanel.add(detailLabel);
        }

        // Special Offer & Price
        JLabel specialLabel = new JLabel(pack[10], SwingConstants.CENTER);
        specialLabel.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        specialLabel.setForeground(Color.MAGENTA);
        specialLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(specialLabel);

        JLabel priceLabel = new JLabel(pack[11], SwingConstants.CENTER);
        priceLabel.setFont(new Font("SAN SERIF", Font.BOLD, 30));
        priceLabel.setForeground(Color.RED);
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(priceLabel);

//        // Book Now Button
//        JButton bookNowButton = new JButton(pack[9]);
//        bookNowButton.setFont(new Font("SAN SERIF", Font.BOLD, 20));
//        bookNowButton.setForeground(Color.WHITE);
//        bookNowButton.setBackground(Color.BLACK);
//        bookNowButton.setFocusPainted(false);
//        bookNowButton.setBorder(new LineBorder(Color.YELLOW, 2, true));
//        bookNowButton.setAlignmentX(Component.CENTER_ALIGNMENT);
//        bookNowButton.addActionListener(this);
//        bookNowButton.setActionCommand(pack[1]); // Set action command as package name
//
//        contentPanel.add(Box.createVerticalStrut(10)); // Spacing
//        contentPanel.add(bookNowButton);

        panel.add(contentPanel, BorderLayout.CENTER);
        return panel;
    }

    // Handling button click
    public void actionPerformed(ActionEvent ae) {
        String selectedPackage = ae.getActionCommand();
        setVisible(false);
        new BookPackage(username);
    }

    public static void main(String[] args) {
        new CheckPackage("Ashish12"); // Example username
    }
}
