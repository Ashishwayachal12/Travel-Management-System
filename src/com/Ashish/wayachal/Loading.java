package com.Ashish.wayachal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;


public class Loading extends JFrame implements Runnable,ActionListener{
    Thread t;
    JProgressBar bar;
    String username;

    public void run()
    {
        try
        {
            for(int i=1;i<=101;i++)
            {
                int max=bar.getMaximum();//100
                int value=bar.getValue();

                if(value<max)
                {
                    bar.setValue(bar.getValue()+1);
                }else
                {
                    setVisible(false);

                    new Dashboard(username);
                    break;

                }
                Thread.sleep(50);
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public Loading(String username)
    {
        this.username=username;
        t=new Thread(this);
        setTitle("TRAVEL AND TOURISM MANAGEMENT SYSTEM");

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/LOGO.png"));
        setIconImage(icon.getImage()); // Add logo to the window icon

        setResizable(false);

        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text=new JLabel("Tavel and Tourism Application");
        text.setBounds(50,20,600,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("SAN SERIF", Font.BOLD, 35));
        add(text);


        bar=new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);

        JLabel loding=new JLabel("Loading,Please wait...");
        loding.setBounds(180,130,180,30);
        loding.setForeground(Color.red);
        loding.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(loding);

        JLabel lblusername=new JLabel("Welcome "+username);
        lblusername.setBounds(20,310,400,40);
        lblusername.setForeground(Color.red);
        lblusername.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        add(lblusername);

        t.start();
        setVisible(true);
    }
    public   void    actionPerformed(ActionEvent ae)
    {

    }
    public static void main(String[]args)
    {
        new Loading("");
    }
}
