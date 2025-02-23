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
    JLabel lblelusername,lblelid,lblenumber,lbleprice,lblephone;
    JButton checkprice,bookpackage,back;

    public BookPackage(String username)
    {
        this.username=username;
        setTitle("Travel and Tourism Management System");

        setBounds(350,200,1100,500);
        setResizable(false);

        setLayout(null);
        getContentPane().setBackground(Color.white);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/LOGO.png"));
        setIconImage(icon.getImage());

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(450,50,700,300);
        add(la1);


        JLabel text=new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("SansSerif",Font.BOLD,20));


        JLabel lblusername = new JLabel("Username :");
        lblusername.setBounds(40, 70, 100, 20);
        lblusername.setFont(new Font("SansSerif",Font.BOLD,16));
        add(lblusername);

         lblelusername = new JLabel();
        lblelusername.setFont(new Font("SansSerif",Font.BOLD,16));
        lblelusername.setBounds(250,70,200,20);
        add(lblelusername);

        JLabel lblpacakge = new JLabel("Select Package");
        lblpacakge.setBounds(40, 110, 150, 20);
        lblpacakge.setFont(new Font("SansSerif",Font.BOLD,16));
        add(lblpacakge);

       cpackage=new Choice();
       cpackage.add("Gold Package");
       cpackage.add("Silver Package");
       cpackage.add("Bronze Package");
       cpackage.setFont(new Font("SansSerif",Font.BOLD,13));
       cpackage.setBounds(250,110,200,25);
       add(cpackage);


        JLabel lbltotalpacakge = new JLabel("Total Persons");
        lbltotalpacakge.setBounds(40, 150, 150, 20);
        lbltotalpacakge.setFont(new Font("SansSerif",Font.BOLD,16));
        add(lbltotalpacakge);

        tfpersons=new JTextField();
        tfpersons.setFont(new Font("SansSerif",Font.BOLD,13));
        tfpersons.setBounds(250,150,200,25);
        add(tfpersons);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(40, 190, 150, 20);
        lblid.setFont(new Font("SansSerif",Font.BOLD,16));
        add(lblid);

         lblelid = new JLabel();
        lblelid.setFont(new Font("SansSerif",Font.BOLD,16));
        lblelid.setBounds(250,190,200,25);
        add(lblelid);


        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(40, 230, 150, 25);
        lblnumber.setFont(new Font("SansSerif",Font.BOLD,16));
        add(lblnumber);

        lblenumber = new JLabel();
        lblenumber.setFont(new Font("SansSerif",Font.BOLD,16));
        lblenumber.setBounds(250,230,200,25);
        add(lblenumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40, 270, 150, 20);
        lblphone.setFont(new Font("SansSerif",Font.BOLD,16));
        add(lblphone);

        lblephone = new JLabel();
        lblephone.setFont(new Font("SansSerif",Font.BOLD,16));
        lblephone.setBounds(250,270,200,25);
        add(lblephone);


        JLabel lblprice = new JLabel("Total Price");
        lblprice.setBounds(40, 310, 150, 25);
        lblprice.setFont(new Font("SansSerif",Font.BOLD,16));
        add(lblprice);

        lbleprice = new JLabel();
        lbleprice.setFont(new Font("SansSerif",Font.BOLD,16));
        lbleprice.setBounds(250,310,200,25);
        add(lbleprice);


        try
        {
            Conn conn=new Conn();
            String query="select * from customer where username='"+username+"'";
            ResultSet rs=conn.s.executeQuery(query);
            while (rs.next())
            {
                lblelusername.setText(rs.getString("username"));
                lblelid.setText(rs.getString("Id"));
                lblenumber.setText(rs.getString("number"));
                lblephone.setText(rs.getString("phone"));



            }


        }catch (Exception e)
        {
            e.printStackTrace();
        }

        checkprice=new JButton("Check Package");
        checkprice.setBounds(60,380,120,25);
        checkprice.setBackground(new Color(173, 216, 230));
        checkprice.setForeground(Color.black);
        checkprice.setFont(new Font("SAN SERIR",Font.BOLD,13));
        checkprice.setBorder(new LineBorder(new Color(85, 62, 46)));
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage=new JButton("Book Package");
        bookpackage.setBounds(200,380,120,25);
        bookpackage.setBackground(new Color(173, 216, 230));
        bookpackage.setForeground(Color.black);
        bookpackage.setFont(new Font("SAN SERIR",Font.BOLD,13));
        bookpackage.setBorder(new LineBorder(new Color(85, 62, 46)));
        bookpackage.addActionListener(this);
        add(bookpackage);

        back=new JButton("Back");
        back.setBounds(340,380,120,25);
        back.setBackground(new Color(173, 216, 230));
        back.setForeground(Color.black);
        back.setFont(new Font("SAN SERIR",Font.BOLD,13));
        back.setBorder(new LineBorder(new Color(85, 62, 46)));
        back.addActionListener(this);
        add(back);





        setVisible(true);

    }
    public   void    actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkprice)
        {
            String pack=cpackage.getSelectedItem();
            int cost=0;
            if(pack.equals("Gold Package")){
                cost=32000;
            }else if(pack.equals("Silver Package"))
            {
               cost+=25000;

            }else {
                cost+=12000;

            }
            int person=Integer.parseInt(tfpersons.getText());
            cost *=person;
            lbleprice.setText("Rs"+cost);


        }else if(ae.getSource()==bookpackage){
          try{
              Conn c=new Conn();
              c.s.executeUpdate("insert into bookPackage values('"+lblelusername.getText()+"','"+cpackage.getSelectedItem()+"'," +
                      "'"+tfpersons.getText()+"'," + "'"+lblelid.getText()+"','"+lblenumber.getText()+"','"+lblephone.getText()+"','"+lbleprice.getText()+"')");

              JOptionPane.showMessageDialog(null,"Package Book Successfully");
              setVisible(false);
              new Dashboard(username);
          }catch (Exception e)
          {
              e.printStackTrace();
          }

        }else {
            setVisible(false);
            new Dashboard(username);
        }
    }


    public static void main(String[] args) {
        new BookPackage("Ashish12");
    }
}
