package com.Ashish.wayachal;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Dashboard extends JFrame implements ActionListener{

    JButton addpersonaldetails,upadatepersonaldetails,viewpersonaldetails,deletepersonaldetails,checkpackages,bookpackages,viewpackages,viewhotel,
            bookhotel,viewbookhotel,destinations,payments,calculater,notepad,about;

    String username;
    public Dashboard(String username)
    {

        this.username=username;
        setTitle("TRAVEL AND TOURISM MANAGEMENT SYSTEM");

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/LOGO.png"));
        setIconImage(icon.getImage()); // Add logo to the window icon

        setResizable(false);
        // setBounds(0,0,1600,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0, 0, 1600, 65);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2=i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(5,0,70,70);
        p1.add(image);


        JLabel heading = new JLabel("Dashboard");
        heading.setFont(new Font("SAN SERIF", Font.BOLD, 30));
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.white);
        p1.add(heading);

        JLabel text = new JLabel("WELCOME TO FREE TRAVEL");
        text.setFont(new Font("SAN SERIF", Font.BOLD, 30));
        text.setBounds(700, 10, 800, 40);
        text.setForeground(Color.WHITE);
        p1.add(text);


        JPanel p2 = new JPanel();
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0, 65, 300, 900);
        p2.setLayout(null);
        add(p2);

        addpersonaldetails=new JButton("Add Personal Details");
        addpersonaldetails.setBounds(0,0,300,50);
        addpersonaldetails.setBackground(new Color(0,0,102));
        addpersonaldetails.setForeground(Color.white);
        addpersonaldetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        addpersonaldetails.setBorder(new LineBorder(new Color(0,0,102)));
        addpersonaldetails.setMargin(new Insets(0,0,0,60));
        addpersonaldetails.addActionListener(this);
        p2.add(addpersonaldetails);

        upadatepersonaldetails=new JButton("Update Personal Details");
        upadatepersonaldetails.setBounds(0,50,300,50);
        upadatepersonaldetails.setBackground(new Color(0,0,102));
        upadatepersonaldetails.setForeground(Color.white);
        upadatepersonaldetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        upadatepersonaldetails.setBorder(new LineBorder(new Color(0,0,102)));
        upadatepersonaldetails.setMargin(new Insets(0,0,0,30));
        upadatepersonaldetails.addActionListener(this);
        p2.add(upadatepersonaldetails);


        viewpersonaldetails=new JButton("View  Details");
        viewpersonaldetails.setBounds(0,100,300,50);
        viewpersonaldetails.setBackground(new Color(0,0,102));
        viewpersonaldetails.setForeground(Color.white);
        viewpersonaldetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewpersonaldetails.setBorder(new LineBorder(new Color(0,0,102)));
        viewpersonaldetails.setMargin(new Insets(0,0,0,30));
        viewpersonaldetails.addActionListener(this);
        p2.add(viewpersonaldetails);

        deletepersonaldetails=new JButton("Delete Personal Details");
        deletepersonaldetails.setBounds(0,150,300,50);
        deletepersonaldetails.setBackground(new Color(0,0,102));
        deletepersonaldetails.setForeground(Color.white);
        deletepersonaldetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        deletepersonaldetails.setBorder(new LineBorder(new Color(0, 0, 102)));
        deletepersonaldetails.setMargin(new Insets(0,0,0,40));
        deletepersonaldetails.addActionListener(this);
        p2.add(deletepersonaldetails);

        checkpackages=new JButton("Check Packages");
        checkpackages.setBounds(0,200,300,50);
        checkpackages.setBackground(new Color(0,0,102));
        checkpackages.setForeground(Color.white);
        checkpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        checkpackages.setBorder(new LineBorder(new Color(0,0,102)));
        checkpackages.setMargin(new Insets(0,0,0,110));
        checkpackages.addActionListener(this);
        p2.add(checkpackages);

        bookpackages=new JButton("Book Package");
        bookpackages.setBounds(0,250,300,50);
        bookpackages.setBackground(new Color(0,0,102));
        bookpackages.setForeground(Color.white);
        bookpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookpackages.setBorder(new LineBorder(new Color(0,0,102)));
        bookpackages.setMargin(new Insets(0,0,0,120));
        bookpackages.addActionListener(this);
        p2.add(bookpackages);

        viewpackages=new JButton("View Package");
        viewpackages.setBounds(0,300,300,50);
        viewpackages.setBackground(new Color(0,0,102));
        viewpackages.setForeground(Color.white);
        viewpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewpackages.setBorder(new LineBorder(new Color(0,0,102)));
        viewpackages.setMargin(new Insets(0,0,0,120));
        viewpackages.addActionListener(this);
        p2.add(viewpackages);

        viewhotel=new JButton("View Hotels");
        viewhotel.setBounds(0,350,300,50);
        viewhotel.setBackground(new Color(0,0,102));
        viewhotel.setForeground(Color.white);
        viewhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewhotel.setBorder(new LineBorder(new Color(0,0,102)));
        viewhotel.setMargin(new Insets(0,0,0,130));
        viewhotel.addActionListener(this);
        p2.add(viewhotel);

        bookhotel=new JButton("Book Hotel");
        bookhotel.setBounds(0,400,300,50);
        bookhotel.setBackground(new Color(0,0,102));
        bookhotel.setForeground(Color.white);
        bookhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookhotel.setBorder(new LineBorder(new Color(0,0,102)));
        bookhotel.setMargin(new Insets(0,0,0,140));
        bookhotel.addActionListener(this);
        p2.add(bookhotel);

        viewbookhotel=new JButton("View Booked Hotel");
        viewbookhotel.setBounds(0,450,300,50);
        viewbookhotel.setBackground(new Color(0,0,102));
        viewbookhotel.setForeground(Color.white);
        viewbookhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewbookhotel.setBorder(new LineBorder(new Color(0,0,102)));
        viewbookhotel.setMargin(new Insets(0,0,0,70));
        viewbookhotel.addActionListener(this);
        p2.add(viewbookhotel);

        destinations=new JButton("Destination");
        destinations.setBounds(0,500,300,50);
        destinations.setBackground(new Color(0,0,102));
        destinations.setForeground(Color.white);
        destinations.setFont(new Font("Tahoma",Font.PLAIN,20));
        destinations.setBorder(new LineBorder(new Color(0,0,102)));
        destinations.setMargin(new Insets(0,0,0,125));
        destinations.addActionListener(this);
        p2.add(destinations);

        payments=new JButton("Payment");
        payments.setBounds(0,550,300,50);
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.white);
        payments.setFont(new Font("Tahoma",Font.PLAIN,20));
        payments.setBorder(new LineBorder(new Color(0,0,102)));
        payments.setMargin(new Insets(0,0,0,155));
        payments.addActionListener(this);
        p2.add(payments);

        calculater=new JButton("Claculater");
        calculater.setBounds(0,600,300,50);
        calculater.setBackground(new Color(0,0,102));
        calculater.setForeground(Color.white);
        calculater.setFont(new Font("Tahoma",Font.PLAIN,20));
        calculater.setBorder(new LineBorder(new Color(0,0,102)));
        calculater.setMargin(new Insets(0,0,0,145));
        calculater.addActionListener(this);
        p2.add(calculater);

        notepad=new JButton("NotePad");
        notepad.setBounds(0,650,300,50);
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.white);
        notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
        notepad.setBorder(new LineBorder(new Color(0,0,102)));
        notepad.setMargin(new Insets(0,0,0,70));
        notepad.addActionListener(this);
        p2.add(notepad);

        about=new JButton("About");
        about.setBounds(0,700,300,50);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.white);
        about.setFont(new Font("Tahoma",Font.PLAIN,20));
        about.setBorder(new LineBorder(new Color(0,0,102)));
        about.setMargin(new Insets(0,0,0,175));
        about.addActionListener(this);
        p2.add(about);

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/dest8.jpg"));
        Image i5=i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel Image=new JLabel(i6);
        Image.setBounds(0,0,1650,1000);
        add(Image);





        setVisible(true);
    }

    public   void    actionPerformed(ActionEvent ae)
    {

        if(ae.getSource()==addpersonaldetails)
        {
            setVisible (false);
            new AddCustomer(username);


        }else if(ae.getSource()==upadatepersonaldetails)
        {
            setVisible (false);
            new UpdatePersonalDetails(username);


        }else if(ae.getSource()==viewpersonaldetails)
        {
            setVisible (true);
            new ViewCustomer(username);


        }else if(ae.getSource()==deletepersonaldetails)
        {
            setVisible (false);
//          new ViewCustomer(username);

        }else if(ae.getSource()==checkpackages)
        {
            setVisible (true);
             new CheckPackage(username);

        }else if(ae.getSource()==bookpackages)
        {
            setVisible (false);
         //    new BookPackage(username);

        }else if(ae.getSource()==viewpackages)
        {
            setVisible (false);
            // new AddCustomer();

        }else if(ae.getSource()==viewhotel)
        {
            setVisible (false);
            // new AddCustomer();

        }else if(ae.getSource()==bookhotel)
        {
            setVisible (false);
            // new AddCustomer();

        }else if(ae.getSource()==viewbookhotel)
        {
            setVisible (false);
            // new AddCustomer();

        }else if(ae.getSource()==destinations)
        {
            setVisible (false);
            // new AddCustomer();

        }else if(ae.getSource()==payments)
        {
            setVisible (false);
            // new AddCustomer();

        }else if(ae.getSource()==calculater)
        {
            setVisible (false);
            // new AddCustomer();

        }else if(ae.getSource()==notepad)
        {
            setVisible (true);
             new Notepad();

        }else if(ae.getSource()==about)
        {
            setVisible (true);
             new About();

        }

    }



    public static void main(String[]args)
    {
        new Dashboard("");
    }
}


