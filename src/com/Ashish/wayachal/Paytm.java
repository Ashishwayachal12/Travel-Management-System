package com.Ashish.wayachal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Paytm extends JFrame {

    public Paytm() {
        setTitle("TRAVEL AND TOURISM MANAGEMENT SYSTEM");

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/LOGO.png"));
        setIconImage(icon.getImage());
        setSize(800, 600);
        setLocation(500, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // JEditorPane to load Paytm website
        JEditorPane j = new JEditorPane();
        j.setEditable(false);

        try {
            j.setPage("https://paytm.com/electricity-bill-payment");
        } catch (IOException e) {
            j.setContentType("text/html");
            j.setText("<html><h2 style='color:red; text-align:center;'>⚠ Could not load Paytm page.</h2></html>");

        }

        JScrollPane scrollPane = new JScrollPane(j);
        add(scrollPane, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.setPreferredSize(new Dimension(800, 50));
        add(buttonPanel, BorderLayout.SOUTH);

        JButton back = new JButton("Back");
        back.setFont(new Font("SansSerif", Font.BOLD, 14));
        back.setBackground(new Color(200, 0, 0));
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        buttonPanel.add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Paytm();
    }
}
