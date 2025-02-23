package com.Ashish.wayachal;

//import java.awt.*;
//import javax.swing.*;
//import javax.swing.border.*;
//import java.awt.event.*;
//import java.sql.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.border.LineBorder;

import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{

    JButton password,signup,login;
    JPasswordField tfpassword;
    JTextField tfusername;

    public Login()
    {

        setTitle("TRAVEL AND TOURISM MANAGEMENT SYSTEM");
        setSize(900,400);
        setLocation(350,200);
        setLayout(null);
        setResizable(false);
//     setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/LOGO.png"));
        setIconImage(icon.getImage()); // Add logo to the window icon

        getContentPane().setBackground(Color.white);

        JPanel p1=new JPanel();
        p1.setBackground(new Color(173, 216, 230));
        // p1.setBackground(Color.white);
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/travel.jpg"));
        Image i2=i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,400,400);
        p1.add(image);

        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30, 450,300);
        p2.setBackground(Color.white);
        add(p2);

        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(60, 20,100,25);
        lblusername.setFont(new Font("SAN SERIR",Font.BOLD,20));
        p2.add(lblusername);

        tfusername=new JTextField();
        tfusername.setBounds(60,60,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        tfusername.setFont(new Font("SAN SERIR",Font.BOLD,17));
        tfusername.setBackground(new Color(173, 216, 230));
        p2.add(tfusername);


        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(60, 110,100,25);
        lblpassword.setFont(new Font("SAN SERIR",Font.BOLD,20));
        p2.add(lblpassword);

        tfpassword=new JPasswordField();
        tfpassword.setBounds(60,150,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        tfpassword.setFont(new Font("SAN SERIR",Font.BOLD,17));
        tfpassword.setBackground(new Color(173, 216, 230));
        p2.add(tfpassword);

        login=new JButton("Login");
        login.setBounds(20,200,130,30);
        login.setBackground(new Color(173, 216, 230));
        login.setForeground(Color.black);
        login.setFont(new Font("SAN SERIR",Font.BOLD,15));
        login.setBorder(new LineBorder(new Color(85, 62, 46)));
        login.addActionListener(this);
        p2.add(login);

        signup=new JButton("Signup");
        signup.setBounds(230,200,130,30);
        signup.setBackground(new Color(173, 216, 230));
        signup.setForeground(Color.black);
        signup.setFont(new Font("SAN SERIR",Font.BOLD,15));
        signup.setBorder(new LineBorder(new Color(85, 62, 46)));
        signup.addActionListener(this);
        p2.add(signup);

        password=new JButton("Forget Password");
        password.setBounds(130,250,130,30);
        password.setBackground(new Color(173, 216, 230));
        password.setForeground(Color.black);
        password.setFont(new Font("SAN SERIR",Font.BOLD,12));
        password.setBorder(new LineBorder(new Color(85, 62, 46)));
        password.addActionListener(this);
        p2.add(password);

        JLabel text=new JLabel("Trouble in login...");
        text.setBounds(300,250,150,20);
        text.setFont(new Font("SAN SERIR",Font.BOLD,15));
        text.setForeground(Color.red);
        p2.add(text);

        setVisible(true);

    }

    public   void    actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==login)
        {
            try{
                String username=tfusername.getText();
                String pass=tfpassword.getText();

                String query="select * from account where username='"+username+"' AND password= '"+pass+"'";
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Loading(username);
                }else
                {
                    JOptionPane.showMessageDialog(null,"Incorrect UPI Number and PIN");
                }

            } catch(Exception e)
            {
                e.printStackTrace();
            }

        }else if(ae.getSource()==signup)
        {
            setVisible(false);
            new Signup();
        }else
        {
            setVisible(false);
            new ForgetPassword();
        }
    }
    public static void main(String[]args)
    {
        new Login();
    }

}

