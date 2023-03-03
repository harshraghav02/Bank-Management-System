package Bank_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pinchange extends JFrame implements ActionListener {
    String Pin_Number;
    JButton change,back;
    JPasswordField pintext,repintext;
    pinchange(String pin){
        Pin_Number = pin;
        setLayout(null);


        ImageIcon i1 = new ImageIcon("C:/Users/ragha/Downloads/atmm_page-0005.jpg");
        Image i2 =i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,900,900);
        add(img);

        JLabel text = new JLabel("Change you PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(260,320,700,35);
        img.add(text);

        JLabel newpin = new JLabel("NEW PIN: ");
        newpin.setForeground(Color.white);
        newpin.setFont(new Font("System",Font.BOLD,16));
        newpin.setBounds(180,380,700,30);
        img.add(newpin);

        pintext = new JPasswordField();
        pintext.setBounds(330,390,150,20);
        img.add(pintext);

        JLabel repin = new JLabel("RE-ENTER PIN: ");
        repin.setForeground(Color.white);
        repin.setFont(new Font("System",Font.BOLD,16));
        repin.setBounds(180,420,700,30);
        img.add(repin);

        repintext = new JPasswordField();
        repintext.setBounds(330,430,150,20);
        img.add(repintext);

        change = new JButton("Change");
        change.setBounds(430,490,90,25);
        change.setBackground(Color.BLACK);
        change.setForeground(Color.WHITE);
        change.addActionListener(this);
        img.add(change);

        back = new JButton("Back");
        back.setBounds(430,520,90,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        img.add(back);

        setSize(900,830);
        setUndecorated(true);
        setLocation(300,0);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == back){
            setVisible(false);
            new Transaction(Pin_Number).setVisible(true);
        }
        else{
            try{
                String npin = pintext.getText();
                String rpin = repintext.getText();

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"PIN does not match");
                    return;
                }
                if(npin.equals("") || rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"PIN Field should not me empty!!");
                    return;
                }
                if(npin.equals(rpin)){

                    String q1 = "update bank set Pin = '"+rpin+"' where Pin = '"+Pin_Number+"'";
                    String q2 = "update login set Pin = '"+rpin+"' where Pin = '"+Pin_Number+"'";
                    String q3 = "update signup_page3 set Pin_Number = '"+rpin+"' where Pin_Number = '"+Pin_Number+"'";

                    conn c = new conn();
                    c.s.executeUpdate(q1);
                    c.s.executeUpdate(q2);
                    c.s.executeUpdate(q3);

                    JOptionPane.showMessageDialog(null,"PIN Successfully Changed!");
                    setVisible(false);
                    new Transaction(rpin).setVisible(true);
                }
            }
            catch(Exception ex){
                System.out.println(ex);
            }
        }
    }
    public static void main(String[] args) {
        new pinchange("");
    }
}
