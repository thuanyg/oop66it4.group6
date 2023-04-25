/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Account;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class CheckLogin {

    public static ArrayList<Account> getData() {
        ArrayList<Account> KetQua = new ArrayList<>();
        try {
            //B1: Tạo kết nối
            Connection connection = JDBCUtil.getConnection();
            //B2: Tạo đối tượng Statement
            Statement st = connection.createStatement();
            //B3: Thực thi câu lệnh SQL
            String sql = "SELECT * FROM Accounts";
            // Lấy dữ liệu từ DB, trả về đối tượng ResutlSet
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {                
                String username = rs.getString("username");
                String password = rs.getString("password");
                Account acc = new Account(username, password);
                KetQua.add(acc);
            }
            //B4: Xử lý kết quả
            //B5: Ngắt kết nối
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return KetQua;
    }
}
