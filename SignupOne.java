package Bank_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import com.toedter.calendar.JDateChooser;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

public class SignupOne extends JFrame implements ActionListener {
    Random ran;
    JTextField ntf,ftf,mtf,atf,stf,ctf,ptf;

    JDateChooser datechooser;
    JButton next;
    JRadioButton male,female,married,unmarried;
    long random;
    SignupOne(){
        setLayout(null);
        ran = new Random();
        random = Math.abs((ran.nextLong()%9000l)+1000l);

        JLabel formno = new JLabel("Application Form No: " + random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(160,29 ,600,40);

        JLabel personaldetails = new JLabel("Page 1: Personal Details");
        personaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        personaldetails.setBounds(290,80 ,400,30);

        JLabel name = new JLabel("NAME: ");
        name.setFont(new Font("Raleway",Font.BOLD,16));
        name.setBounds(100,150 ,100,20);

        ntf = new JTextField();
        ntf.setFont(new Font("Raleway",Font.BOLD,14));
        ntf.setBounds(300,150,300,28);
        add(ntf);

        JLabel fname = new JLabel("FATHER NAME: ");
        fname.setFont(new Font("Raleway",Font.BOLD,16));
        fname.setBounds(100,200 ,160,20);

        ftf = new JTextField();
        ftf.setFont(new Font("Raleway",Font.BOLD,14));
        ftf.setBounds(300,200,300,28);
        add(ftf);

        JLabel dob = new JLabel("DATE OF BIRTH: ");
        dob.setFont(new Font("Raleway",Font.BOLD,16));
        dob.setBounds(100,250 ,160,20);

        datechooser = new JDateChooser();
        datechooser.setBounds(300,250,300,28);
        datechooser.setForeground(Color.BLACK);
        datechooser.setFont(new Font("Raleway",Font.BOLD,14));
        add(datechooser);

        JLabel gender = new JLabel("GENDER: ");
        gender.setFont(new Font("Raleway",Font.BOLD,16));
        gender.setBounds(100,300 ,130,20);

        male = new JRadioButton("Male");
        male.setBounds(300,297,60,30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(400,297,90,30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup gendergrp = new ButtonGroup();
        gendergrp.add(male);
        gendergrp.add(female);

        JLabel email = new JLabel("EMAIL ADDRESS: ");
        email.setFont(new Font("Raleway",Font.BOLD,16));
        email.setBounds(100,350 ,170,20);

        mtf = new JTextField();
        mtf.setFont(new Font("Raleway",Font.BOLD,14));
        mtf.setBounds(300,350,300,28);
        add(mtf);

        JLabel marital = new JLabel("MARITAL STATUS: ");
        marital.setFont(new Font("Raleway",Font.BOLD,16));
        marital.setBounds(100,400 ,170,20);

        married = new JRadioButton("Married");
        married.setBounds(300,397,90,30);
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(410,397,90,30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        ButtonGroup marrital = new ButtonGroup();
        marrital.add(married);
        marrital.add(unmarried);

        JLabel address = new JLabel("ADDRESS: ");
        address.setFont(new Font("Raleway",Font.BOLD,16));
        address.setBounds(100,450 ,170,20);

        atf = new JTextField();
        atf.setFont(new Font("Raleway",Font.BOLD,14));
        atf.setBounds(300,450,300,28);
        add(atf);

        JLabel city = new JLabel("CITY: ");
        city.setFont(new Font("Raleway",Font.BOLD,16));
        city.setBounds(100,500 ,170,20);

        ctf = new JTextField();
        ctf.setFont(new Font("Raleway",Font.BOLD,14));
        ctf.setBounds(300,500,300,28);
        add(ctf);

        JLabel state = new JLabel("STATE: ");
        state.setFont(new Font("Raleway",Font.BOLD,16));
        state.setBounds(100,550 ,170,20);

        stf = new JTextField();
        stf.setFont(new Font("Raleway",Font.BOLD,14));
        stf.setBounds(300,550,300,28);
        add(stf);

        JLabel pincode = new JLabel("PIN CODE: ");
        pincode.setFont(new Font("Raleway",Font.BOLD,16));
        pincode.setBounds(100,600 ,170,20);

        ptf = new JTextField();
        ptf.setFont(new Font("Raleway",Font.BOLD,14));
        ptf.setBounds(300,600,300,28);
        add(ptf);

        next = new JButton("Next");
        next.setBounds(650,680,90,28);
        next.setFont(new Font("Raleway",Font.BOLD,18));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        add(next);
        next.addActionListener(this);

        add(dob);
        add(pincode);
        add(state);
        add(city);
        add(address);
        add(marital);
        add(email);
        add(gender);
        add(fname);
        add(name);
        add(personaldetails);
        add(formno);
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);



    }
    public void actionPerformed(ActionEvent e){
        String formno = "" + random ;
        String name = ntf.getText();
        String fathename = ftf.getText();
        String dob = ((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
        String gender = "";
        gender = male.isSelected()?"Male":"Female";
        String email = mtf.getText();
        String marrital = null;
        marrital = married.isSelected()?"Married":"Unmarried";
        String address = atf.getText();
        String city = ctf.getText();
        String state = stf.getText();
        String pincode = ptf.getText();

        try{
            if(name.equals("") || formno.equals("")  || fathename.equals("")|| dob.equals("")|| gender.equals("") || email.equals("") || marrital.equals("") || address.equals("") || city.equals("")|| state.equals("")|| pincode.equals("")){
                JOptionPane.showMessageDialog(null,"All Fields are Mandatory");

            }
            else{
                conn c = new conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fathename+"','"+dob+"','"+gender+"','"+email+"','"+marrital+"','"+address+"','"+city+"','"+state+"','"+pincode+"');";
                c.s.executeUpdate(query);

                setVisible(false);
                new signupTwo(formno).setVisible(true);

            }
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }
    public static void main(String[] args) {
        new SignupOne();
    }
}
