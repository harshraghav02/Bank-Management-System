package Bank_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup_three extends JFrame implements ActionListener {
    JRadioButton current,saving,recurring,fdaccount;
    JCheckBox atm,intbank,mobbank,email,cheque,estatement,check;
    JButton submit,cancel;
    String FormNumer;

    public Signup_three(String form_no){
        FormNumer = form_no;
        setLayout(null);

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,28));
        l1.setBounds(250,40,400,40);
        add(l1);

        JLabel type = new JLabel("Account Type: ");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(90,130,200,40);
        add(type);

        saving = new JRadioButton("Saving Account");
        saving.setBackground(Color.WHITE);
        saving.setFont(new Font("Raleway",Font.BOLD,16));
        saving.setForeground(Color.BLACK);
        saving.setBounds(300,140,200,30);
        add(saving);

        current = new JRadioButton("Current Account");
        current.setBackground(Color.WHITE);
        current.setFont(new Font("Raleway",Font.BOLD,16));
        current.setForeground(Color.BLACK);
        current.setBounds(500,140,200,30);
        add(current);

        recurring = new JRadioButton("Recurring Account");
        recurring.setBackground(Color.WHITE);
        recurring.setFont(new Font("Raleway",Font.BOLD,16));
        recurring.setForeground(Color.BLACK);
        recurring.setBounds(300,180,200,30);
        add(recurring);

        fdaccount = new JRadioButton("Fixed Deposit Account");
        fdaccount.setBackground(Color.WHITE);
        fdaccount.setFont(new Font("Raleway",Font.BOLD,16));
        fdaccount.setForeground(Color.BLACK);
        fdaccount.setBounds(500,180,200,30);
        add(fdaccount);

        ButtonGroup button = new ButtonGroup();
        button.add(saving);
        button.add(current);
        button.add(recurring);
        button.add(fdaccount);

        JLabel card = new JLabel("Card Number: ");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(90,240,200,40);
        add(card);

        JLabel carddetails = new JLabel("Your 16 Digit Card Number");
        carddetails.setFont(new Font("Raleway",Font.BOLD,12));
        carddetails.setBounds(90,280,200,15);
        add(carddetails);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(300,240,300,40);
        add(number);

        JLabel PIN = new JLabel("PIN Number: ");
        PIN.setFont(new Font("Raleway",Font.BOLD,22));
        PIN.setBounds(90,320,200,40);
        add(PIN);

        JLabel pindetails = new JLabel("Your 4 Digit Pin Number");
        pindetails.setFont(new Font("Raleway",Font.BOLD,12));
        pindetails.setBounds(90,360,200,15);
        add(pindetails);

        JLabel PINNO = new JLabel("XXXX");
        PINNO.setFont(new Font("Raleway",Font.BOLD,22));
        PINNO.setBounds(300,320,300,40);
        add(PINNO);

        JLabel services = new JLabel("Services Required: ");
        services.setFont(new Font("Raleway",Font.BOLD,20));
        services.setBounds(90,400,200,40);
        add(services);

        atm = new JCheckBox("ATM CARD");
        atm.setBackground(Color.white);
        atm.setFont(new Font("Raleway",Font.BOLD,16));
        atm.setBounds(90,460,200,30);
        add(atm);

        intbank = new JCheckBox("Internet Banking");
        intbank.setBackground(Color.white);
        intbank.setFont(new Font("Raleway",Font.BOLD,16));
        intbank.setBounds(350,460,200,30);
        add(intbank);

        mobbank = new JCheckBox("Mobile Banking");
        mobbank.setBackground(Color.white);
        mobbank.setFont(new Font("Raleway",Font.BOLD,16));
        mobbank.setBounds(90,510,200,30);
        add(mobbank);

        email = new JCheckBox("Email & SMS Alerts");
        email.setBackground(Color.white);
        email.setFont(new Font("Raleway",Font.BOLD,16));
        email.setBounds(350,510,250,30);
        add(email);

        cheque = new JCheckBox("Cheque");
        cheque.setBackground(Color.white);
        cheque.setFont(new Font("Raleway",Font.BOLD,16));
        cheque.setBounds(90,560,200,30);
        add(cheque);

        estatement = new JCheckBox("E-Statement");
        estatement.setBackground(Color.white);
        estatement.setFont(new Font("Raleway",Font.BOLD,16));
        estatement.setBounds(350,560,200,30);
        add(estatement);

        check = new JCheckBox("I Here by delare that the above entered details are correct to the best of my knowledge");
        check.setBackground(Color.white);
        check.setFont(new Font("Raleway",Font.BOLD,12));
        check.setBounds(90,630,600,30);
        add(check);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setFont(new Font("Raleway",Font.BOLD,15));
        submit.setForeground(Color.white);
        submit.setBounds(520,680,100,30);
        add(submit);
        submit.addActionListener(this);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setFont(new Font("Raleway",Font.BOLD,15));
        cancel.setForeground(Color.white);
        cancel.setBounds(650,680,100,30);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setSize(850,800);
        setLocation(350,10);
        getContentPane().setBackground(Color.WHITE);


    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == submit){
            String fno = FormNumer;
            String type = "";
            if(saving.isSelected()) type = "Saving Account";
            else if(current.isSelected()) type = "Current Account";
            else if(recurring.isSelected()) type = "Recurring Account";
            else type = "Fixed Deposit Account";

            Random ran = new Random();
            String cardno = "" + (Math.abs((ran.nextLong()%90000000l)) + 8820291200000000l);
            String pinno = "" +  (Math.abs(ran.nextLong()%9000l)+1000l);

            String services = "";
            if(atm.isSelected()) services += "ATM Card";
            if(intbank.isSelected()) services += " Internet Banking";
            if(mobbank.isSelected()) services += " Mobile Banking";
            if(email.isSelected()) services += " Email & SMS Alerts";
            if(cheque.isSelected()) services += " heque Book";
            if(estatement.isSelected()) services += " E - Statement";

            try{
                if(type.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Empty");
                }
                else if(!check.isSelected()){
                    JOptionPane.showMessageDialog(null,"Please Tick check box");
                }
                else{
                    conn c = new conn();
                    String query = "insert into signup_page3 values('"+fno+"','"+type+"','"+cardno+"','"+pinno+"','"+services+"')";
                    String query2 = "insert into login values('"+fno+"','"+cardno+"','"+pinno+"')";
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null ,"Card Number: "+ cardno + "\n Pin: "+ pinno+"\n You are redirected to Deposit page,please deposit atleast Rs 500");
                    setVisible(false);
                    new Deposit(pinno).setVisible(true);


                }
            }
            catch (Exception ex){
                System.out.println(ex);
            }
        }
        else if(e.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Signup_three("");
    }
}
