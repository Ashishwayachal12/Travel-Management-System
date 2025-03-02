package com.Ashish.wayachal;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener{

    Choice cpackage;
    JTextField tfpersons;
    String username;
    JLabel lblelusername, lblelid, lblenumber, lbleprice, lblephone;
    JButton checkprice, bookpackage, back;

    public BookPackage(String username) {
        this.username = username;
        setTitle("Travel and Tourism Management System");

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/LOGO.png"));
        setIconImage(icon.getImage());

        setBounds(350, 200, 1100, 500);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting background image (Half Frame)
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image bgImg = bgIcon.getImage().getScaledInstance(550, 500, Image.SCALE_DEFAULT);
        ImageIcon scaledBgIcon = new ImageIcon(bgImg);
        JLabel background = new JLabel(scaledBgIcon);
        background.setBounds(0, 0, 550, 500);
        add(background);

        // Foreground Components (Placed on the right)
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(550, 0, 550, 500);
        add(formPanel);

        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("SansSerif", Font.BOLD, 20));
        formPanel.add(text);

        JLabel lblusername = new JLabel("Username:");
        lblusername.setBounds(40, 70, 100, 20);
        lblusername.setFont(new Font("SansSerif", Font.BOLD, 16));
        formPanel.add(lblusername);

        lblelusername = new JLabel(username);
        lblelusername.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblelusername.setBounds(200, 70, 200, 20);
        formPanel.add(lblelusername);

        JLabel lblpackage = new JLabel("Select Package:");
        lblpackage.setBounds(40, 110, 150, 20);
        lblpackage.setFont(new Font("SansSerif", Font.BOLD, 16));
        formPanel.add(lblpackage);

        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setFont(new Font("SansSerif", Font.BOLD, 13));
        cpackage.setBounds(200, 110, 200, 25);
        formPanel.add(cpackage);

        JLabel lbltotalpackage = new JLabel("Total Persons:");
        lbltotalpackage.setBounds(40, 150, 150, 20);
        lbltotalpackage.setFont(new Font("SansSerif", Font.BOLD, 16));
        formPanel.add(lbltotalpackage);

        tfpersons = new JTextField();
        tfpersons.setFont(new Font("SansSerif", Font.BOLD, 13));
        tfpersons.setBounds(200, 150, 200, 25);
        formPanel.add(tfpersons);

        JLabel lblid = new JLabel("Id:");
        lblid.setBounds(40, 190, 150, 20);
        lblid.setFont(new Font("SansSerif", Font.BOLD, 16));
        formPanel.add(lblid);

        lblelid = new JLabel();
        lblelid.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblelid.setBounds(200, 190, 200, 25);
        formPanel.add(lblelid);

        JLabel lblnumber = new JLabel("Number:");
        lblnumber.setBounds(40, 230, 150, 25);
        lblnumber.setFont(new Font("SansSerif", Font.BOLD, 16));
        formPanel.add(lblnumber);

        lblenumber = new JLabel();
        lblenumber.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblenumber.setBounds(200, 230, 200, 25);
        formPanel.add(lblenumber);

        JLabel lblphone = new JLabel("Phone:");
        lblphone.setBounds(40, 270, 150, 20);
        lblphone.setFont(new Font("SansSerif", Font.BOLD, 16));
        formPanel.add(lblphone);

        lblephone = new JLabel();
        lblephone.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblephone.setBounds(200, 270, 200, 25);
        formPanel.add(lblephone);

        JLabel lblprice = new JLabel("Total Price:");
        lblprice.setBounds(40, 310, 150, 25);
        lblprice.setFont(new Font("SansSerif", Font.BOLD, 16));
        formPanel.add(lblprice);

        lbleprice = new JLabel();
        lbleprice.setFont(new Font("SansSerif", Font.BOLD, 16));
        lbleprice.setBounds(200, 310, 200, 25);
        lbleprice.setForeground(Color.red);
        formPanel.add(lbleprice);

        // Fetch user details
        try {
            Conn conn = new Conn();
            String query = "select * from customer where username='" + username + "'";
            ResultSet rs = conn.s.executeQuery(query);
            if (rs.next()) {
                lblelusername.setText(rs.getString("username"));
                lblelid.setText(rs.getString("Id"));
                lblenumber.setText(rs.getString("number"));
                lblephone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Buttons
        checkprice = new JButton("Check Price");
        checkprice.setBounds(60, 380, 120, 25);
        checkprice.setBackground(new Color(173, 216, 230));
        checkprice.setForeground(Color.black);
        checkprice.setFont(new Font("SAN SERIF", Font.BOLD, 13));
        checkprice.setBorder(new LineBorder(new Color(85, 62, 46)));
        checkprice.addActionListener(this);
        formPanel.add(checkprice);

        bookpackage = new JButton("Book Package");
        bookpackage.setBounds(200, 380, 120, 25);
        bookpackage.setBackground(new Color(173, 216, 230));
        bookpackage.setForeground(Color.black);
        bookpackage.setFont(new Font("SAN SERIF", Font.BOLD, 13));
        bookpackage.setBorder(new LineBorder(new Color(85, 62, 46)));
        bookpackage.addActionListener(this);
        formPanel.add(bookpackage);

        back = new JButton("Back");
        back.setBounds(340, 380, 120, 25);
        back.setBackground(new Color(173, 216, 230));
        back.setForeground(Color.black);
        back.setFont(new Font("SAN SERIF", Font.BOLD, 13));
        back.setBorder(new LineBorder(new Color(85, 62, 46)));
        back.addActionListener(this);
        formPanel.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            String pack = cpackage.getSelectedItem();
            int cost = switch (pack) {
                case "Gold Package" -> 32000;
                case "Silver Package" -> 25000;
                default -> 12000;
            };
            int person = Integer.parseInt(tfpersons.getText());
            cost *= person;
            lbleprice.setText("Rs " + cost);
        } else if (ae.getSource() == bookpackage) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("INSERT INTO bookPackage VALUES ('" + lblelusername.getText() + "', '" + cpackage.getSelectedItem() + "', '" + tfpersons.getText() + "', '" + lblelid.getText() + "', '" + lblenumber.getText() + "', '" + lblephone.getText() + "', '" + lbleprice.getText() + "')");

                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);
                new Dashboard(username);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Dashboard(username);
        }
    }

    public static void main(String[] args) {
        new BookPackage("Ashish12");
    }
}
