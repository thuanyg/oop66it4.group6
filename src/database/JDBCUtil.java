/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import com.sun.tools.javac.resources.compiler;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class JDBCUtil {

    public static Connection getConnection() {
        Connection c = null;
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            String url = "jdbc:sqlserver://192.168.88.105:1433;databaseName=AccountQLTV;encrypt=false";
            String user = "thuanyghg";
            String password = "12345";
            c = DriverManager.getConnection(url, user, password);
//            System.out.println(c);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return c;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printInfo(Connection c) {
        try {
            if (c != null) {
                DatabaseMetaData dbmd = c.getMetaData();
                System.out.println(dbmd.getDatabaseProductName());
                System.out.println(dbmd.getDatabaseProductVersion());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
