package com.Ashish.wayachal;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddCustomer extends JFrame implements ActionListener{

    JLabel lblusername,labelusername,labelname,lablname,gender,country,address,email,phonenumber;

    JComboBox comboid;
    JTextField  tfnumber,tfcountry,tfaddress,tfemail,tfphonenumber;
    JRadioButton rmale,rfemale;
    JButton add,back;
    String username;



    public AddCustomer(String username)
    {
        this.username=username;
        setTitle("TRAVEL AND TOURISM MANAGEMENT SYSTEM");

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/LOGO.png"));
        setIconImage(icon.getImage()); // Add logo to the window icon

        setResizable(false);
        setBounds(450,200,850,550);
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0, 0, 425, 550);
        p1.setLayout(null);
        add(p1);

        lblusername = new JLabel("Username");
        lblusername.setFont(new Font("SAN SERIF", Font.BOLD, 15));
        lblusername.setBounds(30, 50, 150, 25);
        lblusername.setForeground(Color.white);
        p1.add(lblusername);

        labelusername = new JLabel();
        labelusername.setFont(new Font("SAN SERIF", Font.BOLD, 15));
        labelusername.setBounds(215,50,150,30);
        labelusername.setForeground(Color.white);
        p1.add(labelusername);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dest1.jpg"));
        Image i2=i1.getImage().getScaledInstance(850,550,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(60,0,850,550);
        add(image);

        JLabel lablid = new JLabel("Id");
        lablid.setFont(new Font("SAN SERIF", Font.BOLD, 15));
        lablid.setBounds(30, 90, 220, 25);
        lablid.setForeground(Color.white);
        p1.add(lablid);


        comboid=new JComboBox(new String[]{"Passport","Aadhar Card","Pan card","Ration Card","Girlfriend Phone Number"});
        comboid.setBounds(215,90,150,25);
        comboid.setForeground(Color.blue);
        comboid.setBackground(Color.white);
        p1.add(comboid);

        JLabel labnuber = new JLabel("Number");
        labnuber.setFont(new Font("SAN SERIF", Font.BOLD, 15));
        labnuber.setBounds(30, 130, 220, 25);
        labnuber.setForeground(Color.white);
        p1.add(labnuber);

        tfnumber=new JTextField();
        tfnumber.setBounds(215,130,150,30);
        tfnumber.setBorder(BorderFactory.createEmptyBorder());
        tfnumber.setFont(new Font("SAN SERIR",Font.BOLD,17));
        tfnumber.setBackground(Color.white);
        p1.add(tfnumber);

        lablname = new JLabel("Name");
        lablname.setFont(new Font("SAN SERIF", Font.BOLD, 15));
        lablname.setBounds(30, 170, 150, 25);
        lablname.setForeground(Color.white);
        p1.add(lablname);

        labelname = new JLabel();
        labelname.setFont(new Font("SAN SERIF", Font.BOLD, 15));
        labelname.setBounds(215,170,150,30);
        labelname.setForeground(Color.white);
        p1.add(labelname);

        gender = new JLabel("Gender");
        gender.setFont(new Font("SAN SERIF", Font.BOLD, 15));
        gender.setBounds(30, 210, 150, 25);
        gender.setForeground(Color.white);
        p1.add(gender);

        rmale=new JRadioButton("Male");
        rmale.setBounds(215,210,70,25);
        rmale.setFont(new Font("SAN SERIR",Font.BOLD,14));
        rmale.setBackground(Color.white);
        rmale.setForeground(Color.blue);
        p1.add(rmale);

        rfemale=new JRadioButton("Female");
        rfemale.setBounds(290,210,80,25);
        rfemale.setFont(new Font("SAN SERIR",Font.BOLD,14));
        rfemale.setBackground(Color.white);
        rfemale.setForeground(Color.blue);
        p1.add(rfemale);

        ButtonGroup bg=new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);

        country = new JLabel("Country");
        country.setFont(new Font("SAN SERIF", Font.BOLD, 15));
        country.setBounds(30, 250, 220, 25);
        country.setForeground(Color.white);
        p1.add(country);

        tfcountry=new JTextField();
        tfcountry.setBounds(215,250,150,30);
        tfcountry.setBorder(BorderFactory.createEmptyBorder());
        tfcountry.setFont(new Font("SAN SERIR",Font.BOLD,17));
        tfcountry.setBackground(Color.white);
        p1.add(tfcountry);

        address = new JLabel("Address");
        address.setFont(new Font("SAN SERIF", Font.BOLD, 15));
        address.setBounds(30, 290, 220, 25);
        address.setForeground(Color.white);
        p1.add(address);

        tfaddress=new JTextField();
        tfaddress.setBounds(215,290,150,30);
        tfaddress.setBorder(BorderFactory.createEmptyBorder());
        tfaddress.setFont(new Font("SAN SERIR",Font.BOLD,17));
        tfaddress.setBackground(Color.white);
        p1.add(tfaddress);

        email = new JLabel("Email_Id");
        email.setFont(new Font("SAN SERIF", Font.BOLD, 15));
        email.setBounds(30, 330, 220, 25);
        email.setForeground(Color.white);
        p1.add(email);

        tfemail=new JTextField();
        tfemail.setBounds(215,330,150,30);
        tfemail.setBorder(BorderFactory.createEmptyBorder());
        tfemail.setFont(new Font("SAN SERIR",Font.BOLD,17));
        tfemail.setBackground(Color.white);
        p1.add(tfemail);

        phonenumber = new JLabel("Phone Number");
        phonenumber.setFont(new Font("SAN SERIF", Font.BOLD, 15));
        phonenumber.setBounds(30, 370, 220, 25);
        phonenumber.setForeground(Color.white);
        p1.add(phonenumber);

        tfphonenumber=new JTextField();
        tfphonenumber.setBounds(215,370,150,30);
        tfphonenumber.setBorder(BorderFactory.createEmptyBorder());
        tfphonenumber.setFont(new Font("SAN SERIR",Font.BOLD,17));
        tfphonenumber.setBackground(Color.white);
        p1.add(tfphonenumber);

        add=new JButton("Add");
        add.setBounds(80,450,100,30);
        add.setBackground(Color.white);
        add.setForeground( Color.BLUE);
        add.setFont(new Font("SAN SERIR",Font.BOLD,15));
        add.setBorder(new LineBorder(new Color(85, 62, 46)));
        add.addActionListener(this);
        p1.add(add);

        back=new JButton("Back");
        back.setBounds(250,450,100,30);
        back.setBackground(Color.white);
        back.setForeground(Color.BLUE);
        back.setFont(new Font("SAN SERIR",Font.BOLD,15));
        back.setBorder(new LineBorder(new Color(85, 62, 46)));
        back.addActionListener(this);
        p1.add(back);


        try
        {
            Conn c=new Conn();
            ResultSet rs= c.s.executeQuery("select * from account where username='"+username+"'");
            while(rs.next())
            {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }


        setVisible(true);
    }

    public   void    actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        {
            setVisible (false);
            String username=labelusername.getText();
            String id=(String)comboid.getSelectedItem();
            String number=tfnumber.getText();
            String name=labelname.getText();
            String gender=null;
            if(rmale.isSelected())
            {
                gender="Male";

            }else
            {
                gender="Female";
            }
            String country=tfcountry.getText();
            String address=tfaddress.getText();
            String phone=tfphonenumber.getText();
            String email=tfemail.getText();

            try {
                Conn c = new Conn();
                String query = "INSERT INTO customer (username, id, number, name, gender, country, address, phone, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = c.c.prepareStatement(query);

                pstmt.setString(1, username);
                pstmt.setString(2, id);
                pstmt.setString(3, number);
                pstmt.setString(4, name);
                pstmt.setString(5, gender);
                pstmt.setString(6, country);
                pstmt.setString(7, address);
                pstmt.setString(8, phone);
                pstmt.setString(9, email);

                int rowsInserted = pstmt.executeUpdate();

                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                    setVisible(false);
                    new Dashboard(username);
                } else {
                    JOptionPane.showMessageDialog(null, "Error adding customer. Try again.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }else if(ae.getSource()==back)
        {
            setVisible (false);
            new Dashboard(username);

        }

    }

    public static void main(String[]args)
    {
        new AddCustomer("");
    }

}

