package com.Ashish.wayachal;

import javax.swing.*;
import java.awt.*;

public class Destination extends JFrame implements Runnable {

    public void run() {
        String[] text = new String[]{"JW Marriott Hotel", "Mandarin Oriental Hotel", "Four Seasons Hotel",
                "Radisson Hotel", "Classio Hotel", "The Bay Club Hotel", "Happy Mornings Motel"};
        try {
            for (int i = 0; i < text.length; i++) {
                label[i].setVisible(true);
              //  caption.setText(text[i]);
                Thread.sleep(2500);
                label[i].setVisible(false);
            }
            // Close only the CheckHotels frame
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Thread t1;
    JLabel[] label = new JLabel[10];
    JLabel caption;

    public Destination() {
        caption = new JLabel();
        caption.setBounds(50, 500, 1000, 70);
        caption.setFont(new Font("SAN SERIF", Font.BOLD, 40));
        caption.setForeground(Color.white);
        add(caption);

        ImageIcon[] image = new ImageIcon[10];
        Image[] jimage = new Image[10];
        ImageIcon[] kimage = new ImageIcon[10];

        setBounds(400, 150, 800, 600);
        setTitle("TRAVEL AND TOURISM MANAGEMENT SYSTEM");

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/LOGO.png"));
        setIconImage(icon.getImage());
        setResizable(false);

        for (int i = 0; i < 9; i++) {
            image[i] = new ImageIcon(ClassLoader.getSystemResource("icons/dest" + (i + 1) + ".jpg"));
            jimage[i] = image[i].getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
            kimage[i] = new ImageIcon(jimage[i]);
            label[i] = new JLabel(kimage[i]);
            label[i].setBounds(0, 0, 800, 600);
            add(label[i]);
            label[i].setVisible(false);
        }

        t1 = new Thread(this);
        t1.start();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Destination();
    }
}
