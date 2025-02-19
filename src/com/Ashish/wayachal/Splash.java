package com.Ashish.wayachal;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {

    Thread thread;

    public Splash() {

        setTitle("TRAVEL AND TOURISM MANAGEMENT SYSTEM");


        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/LOGO.png"));
        setIconImage(icon.getImage());

        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);


        setVisible(true);


        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        try {

            Thread.sleep(3000);
            new Login();
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Splash frame = new Splash();
        int x = 1;


        for (int i = 1; i <= 500; x += 7, i += 6) {
            frame.setLocation(750 - (x + i) / 2, 350 - (i / 2));
            frame.setSize(x + i, 600);

            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

