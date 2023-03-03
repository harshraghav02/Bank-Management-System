package Bank_Management;

import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener{
    JButton deposit,back;
    JTextField amount;
    String pin_no;
    Deposit(String pin){
        pin_no = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon("C:/Users/ragha/Downloads/atmm_page-0005.jpg");
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter Amount to Deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,300,200,30);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(210,360,270,30);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(415,490,100,25);
        deposit.setBackground(Color.BLACK);
        deposit.setForeground(Color.white);
        deposit.addActionListener(this);
        image.add(deposit);
        back = new JButton("Back");
        back.setBounds(415,520,100,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setUndecorated(true);
        setLocation(300,0);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == deposit){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter valid amount");
            }
            else{
                try {
                    conn c = new conn();
                    String query = "insert into bank values('" + pin_no + "','" + date + "','Deposit','" + number + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+ number + "Deposited Successesfully.");
                    setVisible(false);
                    new Transaction(pin_no).setVisible(true);

                }
                catch (Exception ex){
                    System.out.println(ex);
                }

            }
        }
        else if(e.getSource() == back){
            setVisible(false);
            new Transaction(pin_no).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Deposit("");
    }
}
