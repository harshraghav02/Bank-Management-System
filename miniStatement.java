package Bank_Management;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class miniStatement extends JFrame {
    String pinnumber;
    miniStatement(String pin){
        pinnumber = pin;
        setLayout(null);

        JLabel mini = new JLabel();
        add(mini);

        JLabel bank = new JLabel("Union Bank");
        bank.setBounds(150,20,100,20);
        bank.setFont(new Font("Raleway",Font.BOLD,14));
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,400,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,700,400,20);
        add(balance);

        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select Card_Number from login where Pin='"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number : "+rs.getString("Card_number").substring(0,4) + "- XXXX - XXXX - "+ rs.getString("Card_Number").substring(12));
            }
            card.setFont(new Font("Raleway",Font.BOLD,14));
        }
        catch(Exception ex){
            System.out.println(ex);
        }

        try{
            conn c = new conn();
            int bal = 0;
            ResultSet rs = c.s.executeQuery("select * from bank where Pin = '"+pinnumber+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }

                mini.setText(mini.getText() + "<html>"+ rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount")+ "<br><br><html>") ;
            }
            balance.setText("Available Balance: "+bal);
            balance.setFont(new Font("Raleway",Font.BOLD,14));
            mini.setBounds(20,80,400,500);
        }
        catch(Exception ex){
            System.out.println(ex);
        }


        setSize(400,800);
        setLocation(20,20);
        setResizable(false);
        setTitle("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        //setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new miniStatement("");
    }
}
