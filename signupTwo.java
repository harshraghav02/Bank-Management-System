package Bank_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

public class signupTwo extends JFrame implements ActionListener {
    JTextField atf,pantf,ptf;

    JButton next;
    JComboBox rcbox,catbox,incbox,qcbox,occbox;
    JRadioButton yes1,no1,yes,no;
    String form_no;



    signupTwo(String form_no){
        this.form_no = form_no;
        setLayout(null);
        setTitle("NEW ACCOUNT FORM - PAGE 2");

        JLabel adddetails = new JLabel("Page 2: Additional Details");
        adddetails.setFont(new Font("Raleway",Font.BOLD,22));
        adddetails.setBounds(290,80 ,400,30);

        JLabel religion = new JLabel("RELIGION: ");
        religion.setFont(new Font("Raleway",Font.BOLD,16));
        religion.setBounds(100,150 ,100,20);


        String valreligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        rcbox = new JComboBox(valreligion);
        rcbox.setBounds(300,150,300,28);
        rcbox.setBackground(Color.white);
        add(rcbox);

        JLabel category = new JLabel("CATEGORY: ");
        category.setFont(new Font("Raleway",Font.BOLD,16));
        category.setBounds(100,200 ,160,20);

        String valcatbox[] = {"General","OBC","SC","ST","Other"};
        catbox = new JComboBox(valcatbox);
        catbox.setBounds(300,200,300,28);
        catbox.setBackground(Color.white);
        add(catbox);

        JLabel income = new JLabel("INCOME: ");
        income.setFont(new Font("Raleway",Font.BOLD,16));
        income.setBounds(100,250 ,160,20);

        String valincome[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        incbox = new JComboBox(valincome);
        incbox.setBounds(300,250,300,28);
        incbox.setBackground(Color.white);
        add(incbox);

        JLabel education = new JLabel("EDUCATIONAL");
        education.setFont(new Font("Raleway",Font.BOLD,16));
        education.setBounds(100,300 ,130,20);


        JLabel qualification = new JLabel("QUALIFICATION: ");
        qualification.setFont(new Font("Raleway",Font.BOLD,16));
        qualification.setBounds(100,330 ,170,20);

        String valuequalification[] = {"Non - Graduate","Graduate","Post- Graduate","Doctrate","other"};
        qcbox = new JComboBox(valuequalification);
        qcbox.setBounds(300,320,300,28);
        qcbox.setBackground(Color.white);
        add(qcbox);


        JLabel occupation = new JLabel("OCCUPATION: ");
        occupation.setFont(new Font("Raleway",Font.BOLD,16));
        occupation.setBounds(100,390 ,170,20);

        String valueocc[] = {"Salaried","Self- Employed","Bussiness","Student","Retired","Other"};
        occbox = new JComboBox(valueocc);
        occbox.setBounds(300,390,300,28);
        occbox.setBackground(Color.white);
        add(occbox);

        JLabel pannumber = new JLabel("PAN NUMBER: ");
        pannumber.setFont(new Font("Raleway",Font.BOLD,16));
        pannumber.setBounds(100,450 ,170,20);

        pantf = new JTextField();
        pantf.setFont(new Font("Raleway",Font.BOLD,14));
        pantf.setBounds(300,450,300,28);
        add(pantf);

        JLabel aadhar = new JLabel("AADHAR NUMBER: ");
        aadhar.setFont(new Font("Raleway",Font.BOLD,16));
        aadhar.setBounds(100,500 ,170,20);

        atf = new JTextField();
        atf.setFont(new Font("Raleway",Font.BOLD,14));
        atf.setBounds(300,500,300,28);
        add(atf);

        JLabel sc = new JLabel("SENIOR CITIZEN: ");
        sc.setFont(new Font("Raleway",Font.BOLD,16));
        sc.setBounds(100,550 ,170,20);

        yes = new JRadioButton("YES");
        yes.setBounds(300,550,90,30);
        yes.setBackground(Color.white);
        add(yes);

        no = new JRadioButton("NO");
        no.setBounds(450,550,90,30);
        no.setBackground(Color.white);
        add(no);

        ButtonGroup scbutton = new ButtonGroup();
        scbutton.add(yes);
        scbutton.add(no);


        JLabel exacc = new JLabel("EXISTING ACCOUNT: ");
        exacc.setFont(new Font("Raleway",Font.BOLD,16));
        exacc.setBounds(100,600 ,170,20);

        yes1 = new JRadioButton("YES");
        yes1.setBounds(300,600,90,30);
        yes1.setBackground(Color.white);
        add(yes1);

        no1 = new JRadioButton("NO");
        no1.setBounds(450,600,90,30);
        no1.setBackground(Color.white);
        add(no1);

        ButtonGroup exbutton = new ButtonGroup();
        exbutton.add(yes1);
        exbutton.add(no1);

        next = new JButton("Next");
        next.setBounds(650,680,90,28);
        next.setFont(new Font("Raleway",Font.BOLD,18));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        add(next);
        next.addActionListener(this);

        add(qualification);
        add(exacc);
        add(sc);
        add(aadhar);
        add(pannumber);
        add(occupation);
        add(income);
        add(education);
        add(category);
        add(religion);
        add(adddetails);
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(false);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);



    }
    public void actionPerformed(ActionEvent e){

        String formno = form_no;
        String religion = (String)rcbox.getSelectedItem();
        String category = (String)catbox.getSelectedItem();
        String income = (String)incbox.getSelectedItem();
        String eduqualification = (String)qcbox.getSelectedItem();
        String occupation = (String)occbox.getSelectedItem();
        String panno = pantf.getText();
        String aadharno = atf.getText();
        String sencitizen = "";
        if(yes.isSelected()) sencitizen = "YES";
        else sencitizen = "NO";
        String exacc = "";
        if(yes1.isSelected()) exacc = "YES";
        else exacc = "NO";

        try{
            if(religion.equals("") || category.equals("")  || income.equals("")|| eduqualification.equals("")|| occupation.equals("") || panno.equals("") || aadharno.equals("") || sencitizen.equals("") || exacc.equals("")){
                JOptionPane.showMessageDialog(null,"All Fields are Mandatory");

            }
            else{
                conn c = new conn();
                String query = "insert into Signup_Page2 values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+eduqualification+"','"+occupation+"','"+panno+"','"+aadharno+"','"+sencitizen+"','"+exacc+"');";
                c.s.executeUpdate(query);

                setVisible(false);
                new Signup_three(formno).setVisible(true);
            }
        }
        catch (Exception ex){
            System.out.println(ex);
        }



    }

}
