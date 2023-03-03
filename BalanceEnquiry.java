package Bank_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pinno;
    BalanceEnquiry(String pin){
        pinno = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon("C:/Users/ragha/Downloads/atmm_page-0005.jpg");
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel img = new JLabel(i3);
        img.setBounds(0,0,900,900);
        add(img);

        back = new JButton("Back");
        back.setBounds(410,490,100,30);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.setFont(new Font("Raleway",Font.BOLD,14));
        back.addActionListener(this);
        img.add(back);

        conn c = new conn();
        try{
            ResultSet rs = c.s.executeQuery("select * from bank where Pin = '"+pinno+"' ");
            int balance = 0;

            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

            JLabel text = new JLabel("Your Available Balance is :");
            text.setBounds(220,310,300,30);
            text.setFont(new Font("Raleway",Font.BOLD,20));
            text.setForeground(Color.white);
            img.add(text);

            JLabel bal = new JLabel("Rs "+balance);
            bal.setBounds(280,360,300,30);
            bal.setFont(new Font("Raleway",Font.BOLD,20));
            bal.setForeground(Color.white);
            img.add(bal);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

        setSize(900,830);
        setLocation(300,0);
        setUndecorated(true);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
            setVisible(false);
            new Transaction(pinno).setVisible(true);
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
