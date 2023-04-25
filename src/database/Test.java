/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Account;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class Test {

    public static void main(String[] args) {
//        try {
//            //B1: Tạo kết nối
//            Connection connection = JDBCUtil.getConnection();
//            JDBCUtil.printInfo(connection);
//            //B2: Tạo đối tượng Statement
//            Statement st = connection.createStatement();
//            //B3: Thực thi câu lệnh SQL
//            String sql = "INSERT INTO Accounts\n" +
//                          "VALUES ('admin','12345')";
//                 // Insert dữ liệu vào DB
//            int check = st.executeUpdate(sql);
//            //B4: Xử lý kết quả
//            if(check > 0){
//                System.out.println("Insert complete!");
//            } else {
//                System.out.println("Error: Cannot insert data!!!");
//            }
//            //B5: Ngắt kết nối
//            JDBCUtil.closeConnection(connection);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        ArrayList<Account> listAcc = CheckLogin.getData();
        for (Account account : listAcc) {
            System.out.println(account.toString());
        }
    }
}
