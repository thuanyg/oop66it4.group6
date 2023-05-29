/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.PhieuMuon;
import model.Sach;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class SachPhieuMuonDAO{

    public static SachPhieuMuonDAO getInstant() {
        return new SachPhieuMuonDAO();
    }

    public int Insert(Sach s, PhieuMuon pm,int soLuong) {
        int check = 0;
        try {
            // Tạo kết nối
            Connection connection = JDBCUtil.getConnection();
            JDBCUtil.printInfo(connection);
            String sql = "INSERT INTO Sach_PhieuMuon VALUES (?,?,?,?)";
            System.out.println(sql);
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, 0);
            pst.setInt(2, s.getId());
            pst.setInt(3, pm.getMa_PM());
            pst.setInt(4, soLuong);
            check = pst.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    
}
