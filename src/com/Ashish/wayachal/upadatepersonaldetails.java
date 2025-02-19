package com.Ashish.wayachal;


import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.event.*;

public class upadatepersonaldetails extends JFrame implements ActionListener{

    JLabel lblusername,labelusername,labelname,lablname,gender,country,address,email,phonenumber,lbltext,lablid;


    JComboBox comboid;
    JTextField  tfnumber,tfcountry,tfaddress,tfemail,tfphonenumber,tfid,tfgender;
    JRadioButton rmale,rfemale;
    JButton add,back;
    String username;


    public upadatepersonaldetails(String username)
    {

        this.username=username;
        setTitle("TRAVEL AND TOURISM MANAGEMENT SYSTEM");

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/LOGO.png"));
        setIconImage(icon.getImage()); // Add logo to the window icon

        setResizable(false);
        setBounds(500,200,850,550);
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0, 0, 425, 550);
        p1.setLayout(null);
        add(p1);

        lbltext = new JLabel("Update Customer Details.");
        lbltext.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        lbltext.setBounds(50, 0, 300, 25);
        lbltext.setForeground(Color.white);
        p1.add(lbltext);

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

        lablid = new JLabel("Id");
        lablid.setFont(new Font("SAN SERIF", Font.BOLD, 15));
        lablid.setBounds(30, 90, 220, 25);
        lablid.setForeground(Color.white);
        p1.add(lablid);


        tfid=new JTextField();
        tfid.setBounds(215,90,150,30);
        tfid.setBorder(BorderFactory.createEmptyBorder());
        tfid.setFont(new Font("SAN SERIR",Font.BOLD,17));
        tfid.setBackground(Color.white);
        p1.add(tfid);

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

        tfgender=new JTextField();
        tfgender.setBounds(215,210,150,30);
        tfgender.setBorder(BorderFactory.createEmptyBorder());
        tfgender.setFont(new Font("SAN SERIR",Font.BOLD,17));
        tfgender.setBackground(Color.white);
        p1.add(tfgender);


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

        add=new JButton("Upadate");
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
            ResultSet rs= c.s.executeQuery("select * from customer where username='"+username+"'");
            while(rs.next())
            {
                labelusername.setText(rs.getString("username"));
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphonenumber.setText(rs.getString("Phone"));
                tfemail.setText(rs.getString("email"));
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
            String id=tfid.getText();
            String number=tfnumber.getText();
            String name=labelname.getText();
            String gender=tfgender.getText();
            String country=tfcountry.getText();
            String address=tfaddress.getText();
            String phone=tfphonenumber.getText();
            String email=tfemail.getText();

            try
            {

                if(true)
                {
                    Conn c=new Conn();
                    String query="update  customer set username='"+username+"',id='"+id+"',number='"+number+"',name='"+name+"',gender='"+gender+"',country='"+country+"',address='"+address+"',phone='"+phone+"',email='"+email+"'" ;
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null,"Customer Details Updated Successfull");
                    setVisible(false);
                    new Dashboard(username);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Fill All The details...");
                    setVisible(true);
                }

            }catch(Exception e)
            {
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
        new upadatepersonaldetails("");
    }

}


