package Bank_Management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Transaction extends JFrame implements ActionListener {
    JButton deposit,withdrawl,minstatement,pinchange,balance,exit;
    String Pin_Number;
    public Transaction(String pin){
        Pin_Number = pin;
        setLayout(null);


        ImageIcon i1 = new ImageIcon("C:/Users/ragha/Downloads/atmm_page-0005.jpg");
        Image i2 =i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,900,900);
        add(img);

        JLabel text = new JLabel("Please Select your Transaction");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(220,320,700,35);
        img.add(text);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(160,420,150,30);
        deposit.setForeground(Color.white);
        deposit.setBackground(Color.BLACK);
        deposit.setFont(new Font("Raleway",Font.BOLD,12));
        deposit.addActionListener(this);
        img.add(deposit);

        withdrawl  = new JButton("CASH WITHDRAWL");
        withdrawl.setBounds(350,420,160,30);
        withdrawl.setForeground(Color.white);
        withdrawl.setBackground(Color.BLACK);
        withdrawl.setFont(new Font("Raleway",Font.BOLD,12));
        withdrawl.addActionListener(this);
        img.add(withdrawl);


        minstatement = new JButton("MINI STATEMENT");
        minstatement.setBounds(350,453,160,30);
        minstatement.setForeground(Color.white);
        minstatement.setBackground(Color.BLACK);
        minstatement.setFont(new Font("Raleway",Font.BOLD,12));
        minstatement.addActionListener(this);
        img.add(minstatement);

        pinchange = new JButton("PIN CHANGE");
        pinchange.setBounds(160,453,150,30);

        pinchange.setForeground(Color.white);
        pinchange.setBackground(Color.BLACK);
        pinchange.setFont(new Font("Raleway",Font.BOLD,12));
        pinchange.addActionListener(this);
        img.add(pinchange);

        balance = new JButton("BALANCE ENQUIRY");
        balance.setBounds(160,491,150,30);

        balance.setForeground(Color.white);
        balance.setBackground(Color.BLACK);
        balance.setFont(new Font("Raleway",Font.BOLD,12));
        balance.addActionListener(this);
        img.add(balance);

        exit = new JButton("EXIT");
        exit.setBounds(350,491,160,30);

        exit.setForeground(Color.white);
        exit.setBackground(Color.BLACK);
        exit.setFont(new Font("Raleway",Font.BOLD,12));
        exit.addActionListener(this);
        img.add(exit);


        setSize(900,830);
        setLocation(300,0);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setVisible(true);



    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == exit){
            System.exit(0);
        }
        else if(e.getSource() == deposit){
            setVisible(false);
            new Deposit(Pin_Number).setVisible(true);
        }
        else if(e.getSource() == withdrawl){
            setVisible(false);
            new withdrawl(Pin_Number).setVisible(true);
        }

        else if(e.getSource() == pinchange){
            setVisible(false);
            new pinchange(Pin_Number).setVisible(true);
        }
        else if(e.getSource() == balance){
            setVisible(false);
            new BalanceEnquiry(Pin_Number).setVisible(true);
        }
        else if(e.getSource() == minstatement){
            new miniStatement(Pin_Number).setVisible(true);

        }
    }

    public static void main(String[] args) {
        new Transaction("");
    }
}
