package Bank_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {
    JButton login,clear,signup;
    JTextField cardtext;
    JPasswordField password;
    Login()  {
        setTitle("Automated Teller Machine");
        setLayout(null);
        ImageIcon img = new ImageIcon("C:\\Users\\ragha\\IdeaProjects\\study\\src\\Bank_Management\\icon\\bank2.png");
        Image i2 = img.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel label = new JLabel(i3);
        label.setBounds(70,20,100,100);

        JLabel text = new JLabel("Welcome to ATM");
        text.setBounds(230,45,400,40);
        text.setFont(new Font("Osward",Font.BOLD,38));

        JLabel cardNo = new JLabel("CARD NO: ");
        cardNo.setBounds(200,150,400,100);
        cardNo.setFont(new Font("Raleway",Font.BOLD,20));

        cardtext = new JTextField();
        cardtext.setFont(new Font("Raleway",Font.BOLD,16));
        cardtext.setBounds(320,190,230,30);


        JLabel pin = new JLabel("PIN: ");
        pin.setBounds(200,210,400,100);
        pin.setFont(new Font("Raleway",Font.BOLD,20));

        password = new JPasswordField();
        cardtext.setFont(new Font("Raleway",Font.BOLD,15));
        password.setBounds(320,250,230,30);


        login = new JButton("SIGN IN");
        login.setForeground(Color.white);
        login.setBounds(320,310,80,30);
        login.setBackground(Color.BLACK);
        login.addActionListener(this);

        clear = new JButton("CLEAR");
        clear.setForeground(Color.white);
        clear.setBounds(460,310,90,30);
        clear.setBackground(Color.BLACK);
        clear.addActionListener(this);

        signup = new JButton("SIGN UP");
        signup.setForeground(Color.white);
        signup.setBounds(320,360,230,30);
        signup.setBackground(Color.BLACK);
        signup.addActionListener(this);

        add(signup);
        add(clear);
        add(login);
        add(password);
        add(cardtext);
        add(cardNo);
        add(pin);
        add(text);
        add(label);
        setSize(800,480);
        setLocation(265,160);
        setVisible(true);
        setResizable(false);

        getContentPane().setBackground(Color.white);


        setDefaultCloseOperation(this.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent a){
        if(a.getSource()== clear){
            cardtext.setText("");
            password.setText("");
        }
        else if(a.getSource()== login){
            conn c= new conn();
            String cardno = cardtext.getText();
            String pin = password.getText();
            String query = "select * from login where Card_Number = '"+cardno+"'  and pin='"+pin+"'";
            try{
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number Or PIN");
                }
            }
            catch (Exception ex){
                System.out.println(ex);
            }

        }
        else if(a.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
