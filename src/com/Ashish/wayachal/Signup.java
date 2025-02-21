package com.Ashish.wayachal;



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
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.border.LineBorder;
import java.awt.Choice;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Signup extends JFrame implements ActionListener {

    JButton create,back;
    JTextField tfusername,tfname,tfpassword,tfanswer;
    Choice security;

    public Signup() {

        setTitle("TRAVEL AND TOURISM MANAGEMENT SYSTEM");

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/LOGO.png"));
        setIconImage(icon.getImage()); // Add logo to the window icon

        setResizable(false);

        setBounds(350, 200, 900, 360);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(173, 216, 230));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);


        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        lblusername.setBounds(50, 20, 125, 25);
        p1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(190, 20, 180, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        tfusername.setFont(new Font("SAN SERIR",Font.BOLD,17));
        tfusername.setBackground(Color.white);
        p1.add(tfusername);


        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        lblname.setBounds(50, 60, 125, 25);
        p1.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(190, 60, 180, 30);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        tfname.setFont(new Font("SAN SERIR",Font.BOLD,17));
        tfname.setBackground(Color.white);
        p1.add(tfname);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        lblpassword.setBounds(50, 100, 125, 25);
        p1.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(190, 100, 180, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        tfpassword.setFont(new Font("SAN SERIR",Font.BOLD,17));
        tfpassword.setBackground(Color.white);
        p1.add(tfpassword);

        JLabel lblsecurity = new JLabel("Security Question");
        lblsecurity.setFont(new Font("SAN SERIF", Font.PLAIN, 18));
        lblsecurity.setBounds(50, 140, 125, 30);
        p1.add(lblsecurity);

        security=new Choice();
        security.add("What is your pet's name?");
        security.add("What was the name of your first school?");
        security.add("What is your mother's maiden name?");
        security.add("What is the name of your favorite book?");
        security.add("What was the name of your first car?");
        security.setBounds(190, 140, 250, 30);
        p1.add(security);



        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        lblanswer.setBounds(50, 180, 125, 25);
        p1.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(190, 180, 180, 30);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        tfanswer.setFont(new Font("SAN SERIR",Font.BOLD,17));
        tfanswer.setBackground(Color.white);
        p1.add(tfanswer);

        create=new JButton("Create");
        create.setBounds(80,250,100,30);
        create.setBackground(Color.white);
        create.setForeground(new Color(133, 193, 233));
        create.setFont(new Font("SAN SERIR",Font.BOLD,15));
        create.setBorder(new LineBorder(new Color(85, 62, 46)));
        create.addActionListener(this);
        p1.add(create);

        back=new JButton("Back");
        back.setBounds(250,250,100,30);
        back.setBackground(Color.white);
        back.setForeground(new Color(133, 193, 233));
        back.setFont(new Font("SAN SERIR",Font.BOLD,15));
        back.setBorder(new LineBorder(new Color(85, 62, 46)));
        back.addActionListener(this);
        p1.add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(580,50,250,250);
        add(image);
        tfpassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    create.doClick(); // Simulate a button click
                }
            }
        });


        setVisible(true);
    }
    public   void    actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() ==create)
        {
            String username=tfusername.getText();
            String name=tfname.getText();
            String password=tfpassword.getText();
            String security_question=security.getSelectedItem();
            String answer=tfanswer.getText();

            String query= "insert into account values('"+username+"','"+name+"','"+password+"','"+security_question+"','"+answer+"')";


            try
            {

                Conn c=new Conn();

                c.s.executeUpdate(query);


                JOptionPane.showMessageDialog(null,"Account Created Succesfully");

                setVisible(false);

                new Login();

            }catch(Exception e)
            {
                e.printStackTrace();
            }

        }else if(ae.getSource()==back)
        {
            setVisible(false);
            new Login();
        }
    }


    public static void main(String[] args) {
        new Signup();
    }
}

