/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class JDBCUtil {
    ///NAM BLUE CODE
    private static final String url = "jdbc:sqlserver://localhost:1433;databaseName=DB_Library;encrypt=false;integratedSecurity=true";
    private static final String user = "hieubeo0017";
    private static final String password = "123456";

    public static Connection getConnection() {
        Connection c = null;
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            c = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            // Xu ly cac loi cho Class.forName
            e.printStackTrace();
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
