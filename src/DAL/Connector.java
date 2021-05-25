/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Dat
 */
public class Connector {
   
    public static Connection getConnection() {
        String dbUrl = "jdbc:mysql://localhost:3306/quanlyphuongtien";
        String username = "root";
        String password = "luudet0512ld";
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return conn;
    }
    
}
