package javaclasses;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectionPro {

    private static Connection con;
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housing?useSSL=false","root","Wakeuptoreality123");
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }

}
