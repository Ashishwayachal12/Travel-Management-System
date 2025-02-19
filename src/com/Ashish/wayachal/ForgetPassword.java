package com.Ashish.wayachal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener {

    JTextField tfusername, tfname, tfsecurity, tfanswer, tfpassword;
    JButton search, retrieve, back;

    public ForgetPassword() {
        setTitle("TRAVEL AND TOURISM MANAGEMENT SYSTEM");

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/LOGO.png"));
        setIconImage(icon.getImage()); // Add logo to the window icon

        setResizable(false);

        setBounds(350, 200, 850, 380);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 70, 200, 200);
        add(image);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(173, 216, 230));
        p1.setBounds(30, 30, 500, 280);
        p1.setLayout(null);
        add(p1);

        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        lblusername.setBounds(50, 20, 125, 25);
        p1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(220, 20, 150, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        tfusername.setFont(new Font("SAN SERIR", Font.BOLD, 17));
        tfusername.setBackground(Color.white);
        p1.add(tfusername);

        search = new JButton("Search");
        search.setBounds(380, 20, 100, 30);
        search.setBackground(Color.white);
        search.setForeground(new Color(133, 193, 233));
        search.setFont(new Font("SAN SERIR", Font.BOLD, 15));
        search.setBorder(new LineBorder(new Color(85, 62, 46)));
        search.addActionListener(this);
        p1.add(search);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        lblname.setBounds(50, 60, 150, 30);
        p1.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(220, 60, 150, 30);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        tfname.setFont(new Font("SAN SERIR", Font.BOLD, 17));
        tfname.setBackground(Color.white);
        p1.add(tfname);

        JLabel lblsecurity = new JLabel("Security Question");
        lblsecurity.setFont(new Font("SAN SERIF", Font.PLAIN, 18));
        lblsecurity.setBounds(50, 100, 150, 30);
        p1.add(lblsecurity);

        tfsecurity = new JTextField();
        tfsecurity.setBounds(220, 100, 150, 30);
        tfsecurity.setBorder(BorderFactory.createEmptyBorder());
        tfsecurity.setFont(new Font("SAN SERIR", Font.BOLD, 17));
        tfsecurity.setBackground(Color.white);
        p1.add(tfsecurity);

        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        lblanswer.setBounds(50, 140, 150, 30);
        p1.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(220, 140, 150, 30);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        tfanswer.setFont(new Font("SAN SERIR", Font.BOLD, 17));
        tfanswer.setBackground(Color.white);
        p1.add(tfanswer);

        retrieve = new JButton("Retrieve");
        retrieve.setBounds(380, 140, 100, 30);
        retrieve.setBackground(Color.white);
        retrieve.setForeground(new Color(133, 193, 233));
        retrieve.setFont(new Font("SAN SERIR", Font.BOLD, 15));
        retrieve.setBorder(new LineBorder(new Color(85, 62, 46)));
        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        lblpassword.setBounds(50, 180, 150, 25);
        p1.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(220, 180, 150, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        tfpassword.setFont(new Font("SAN SERIR", Font.BOLD, 17));
        tfpassword.setBackground(Color.white);
        p1.add(tfpassword);

        back = new JButton("Back");
        back.setBounds(150, 230, 150, 30);
        back.setBackground(Color.white);
        back.setForeground(new Color(133, 193, 233));
        back.setFont(new Font("SAN SERIR", Font.BOLD, 15));
        back.setBorder(new LineBorder(new Color(85, 62, 46)));
        back.addActionListener(this);
        p1.add(back);

        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            try {
                if (true) {

                    String query = "select * from account where username='" + tfusername.getText() + "'";
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery(query);

                    while (rs.next()) {
                        tfname.setText(rs.getString("name"));
                        tfsecurity.setText(rs.getString("security_question"));

                    }
                } else {

                    JOptionPane.showMessageDialog(null, "Enter Valid Username plz...");

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == retrieve) {
            try {
                if (true) {

                    String query = "select * from account where answer='" + tfanswer.getText() + "' AND username='"
                            + tfusername.getText() + "' ";
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery(query);

                    while (rs.next()) {
                        tfpassword.setText(rs.getString("password"));

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Enter Valid Answer...");

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new ForgetPassword();
    }

}

