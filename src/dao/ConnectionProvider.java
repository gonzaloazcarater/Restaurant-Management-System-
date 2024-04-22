/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Paula
 */
public class ConnectionProvider {
    public static Connection getCon() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/23c55f4fe1084dec820b8f986032706e", "system", "ORACLE");
            return con;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
