/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproyect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Sergio
 */
public class DBConnection {
    public Connection get_connection(){
        Connection connection= null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/maindb?autoReconnect=true&useSSL=false", "root", "root");
            System.out.println("connected");
        }catch(Exception e){
            System.out.println(e);
        }
        
        return connection;
    }
}
