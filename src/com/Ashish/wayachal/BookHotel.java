package com.Ashish.wayachal;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BookHotel extends JFrame implements ActionListener {

    Choice chotel;
    JTextField tfpersons, tfdays;
    JLabel lblusername, lblid, lblnumber, lblphone, lblprice;
    JButton checkprice, bookhotel, back;
    String username;

    public BookHotel(String username) {
        this.username = username;
        setTitle("TRAVEL AND TOURISM MANAGEMENT SYSTEM");

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/LOGO.png"));
        setIconImage(icon.getImage());

        setBounds(350, 200, 1100, 500);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting background image (Half Frame)
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/hotel10.jpg"));
        Image bgImg = bgIcon.getImage().getScaledInstance(550, 500, Image.SCALE_DEFAULT);
        JLabel background = new JLabel(new ImageIcon(bgImg));
        background.setBounds(0, 0, 550, 500);
        add(background);

        // Foreground Components (Placed on the right)
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(550, 0, 550, 500);
        add(formPanel);

        JLabel text = new JLabel("BOOK HOTEL");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("SansSerif", Font.BOLD, 20));
        formPanel.add(text);

        JLabel lbluser = new JLabel("Username:");
        lbluser.setBounds(40, 70, 100, 20);
        lbluser.setFont(new Font("SansSerif", Font.BOLD, 16));
        formPanel.add(lbluser);

        lblusername = new JLabel(username);
        lblusername.setBounds(200, 70, 200, 20);
        lblusername.setFont(new Font("SansSerif", Font.BOLD, 16));
        formPanel.add(lblusername);

        JLabel lblhotel = new JLabel("Select Hotel:");
        lblhotel.setBounds(40, 110, 150, 20);
        lblhotel.setFont(new Font("SansSerif", Font.BOLD, 16));
        formPanel.add(lblhotel);

        chotel = new Choice();
        chotel.add("Taj Hotel");
        chotel.add("Oberoi Hotel");
        chotel.add("Marriott Hotel");
        chotel.setBounds(200, 110, 200, 30);
        chotel.setFont(new Font("SansSerif", Font.BOLD, 13));
        formPanel.add(chotel);

        JLabel lblpersons = new JLabel("Total Persons:");
        lblpersons.setBounds(40, 150, 150, 20);
        lblpersons.setFont(new Font("SansSerif", Font.BOLD, 16));
        formPanel.add(lblpersons);

        tfpersons = new JTextField();
        tfpersons.setBounds(200, 150, 200, 25);
        tfpersons.setFont(new Font("SansSerif", Font.BOLD, 13));
        formPanel.add(tfpersons);

        JLabel lbldays = new JLabel("Total Days:");
        lbldays.setBounds(40, 190, 150, 20);
        lbldays.setFont(new Font("SansSerif", Font.BOLD, 16));
        formPanel.add(lbldays);

        tfdays = new JTextField();
        tfdays.setBounds(200, 190, 200, 25);
        tfdays.setFont(new Font("SansSerif", Font.BOLD, 13));
        formPanel.add(tfdays);

        JLabel lbltotalprice = new JLabel("Total Price:");
        lbltotalprice.setBounds(40, 230, 150, 25);
        lbltotalprice.setFont(new Font("SansSerif", Font.BOLD, 16));
        formPanel.add(lbltotalprice);

        lblprice = new JLabel();
        lblprice.setBounds(200, 230, 200, 25);
        lblprice.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblprice.setForeground(Color.red);
        formPanel.add(lblprice);



        checkprice=new JButton("Check Price");
        checkprice.setBounds(60, 300, 120, 25);
        checkprice.setBackground(Color.white);
        checkprice.setForeground(Color.BLUE);
        checkprice.setFont(new Font("SAN SERIR",Font.BOLD,15));
        checkprice.setBorder(new LineBorder(new Color(85, 62, 46)));
        checkprice.addActionListener(this);
        formPanel.add(checkprice);


        bookhotel=new JButton("BookHotel");
        bookhotel.setBounds(200, 300, 120, 25);
        bookhotel.setBackground(Color.white);
        bookhotel.setForeground(Color.BLUE);
        bookhotel.setFont(new Font("SAN SERIR",Font.BOLD,15));
        bookhotel.setBorder(new LineBorder(new Color(85, 62, 46)));
        bookhotel.addActionListener(this);
        formPanel.add(bookhotel);

        back=new JButton("Back");
        back.setBounds(340, 300, 120, 25);
        back.setBackground(Color.white);
        back.setForeground(Color.BLUE);
        back.setFont(new Font("SAN SERIR",Font.BOLD,15));
        back.setBorder(new LineBorder(new Color(85, 62, 46)));
        back.addActionListener(this);
        formPanel.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            String hotel = chotel.getSelectedItem();
            int cost = switch (hotel) {
                case "Taj Hotel" -> 5000;
                case "Oberoi Hotel" -> 4000;
                default -> 3000;
            };
            int persons = Integer.parseInt(tfpersons.getText());
            int days = Integer.parseInt(tfdays.getText());
            cost *= persons * days;
            lblprice.setText("Rs " + cost);
        } else if (ae.getSource() == bookhotel) {
            try {
                Conn c = new Conn();


                String priceText = lblprice.getText().replace("Rs ", "").trim();
                int price = Integer.parseInt(priceText);


                String query = "INSERT INTO bookHotel (username, hotel, persons, days, total_price) VALUES ('"
                        + lblusername.getText() + "', '"
                        + chotel.getSelectedItem() + "', '"
                        + tfpersons.getText() + "', '"
                        + tfdays.getText() + "', '"
                        + price + "')";

                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
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
        new BookHotel("Ashish12");
    }
}