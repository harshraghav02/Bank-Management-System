package Bank_Management;

//import javax.swing.plaf.nimbus.State;
import java.sql.*;
public class conn {
    Connection c ;
    Statement s;
    public conn(){
        try {

            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Raghav@2533");
            s = c.createStatement();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
