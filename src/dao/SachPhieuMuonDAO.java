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
public class SachPhieuMuonDAO {

    public static SachPhieuMuonDAO getInstant() {
        return new SachPhieuMuonDAO();
    }

    public int Insert(Sach s, PhieuMuon pm, int soLuong) {
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

    public int Update(Sach s, int SoLuong) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            JDBCUtil.printInfo(connection);
            String sql = "UPDATE Sach_PhieuMuon SET Ma_Sach = ?, SoLuong = ? WHERE Ma_Sach = ?";
            System.out.println(sql);
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, s.getId());
            pst.setInt(2, SoLuong);
            pst.setInt(3, s.getId());
            check = pst.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public int Delete(Sach s, PhieuMuon pm, int SoLuong) {
        int check = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            JDBCUtil.printInfo(connection);
            String sql = "  DELETE FROM Sach_PhieuMuon From Sach"
                    + "  Join Sach_PhieuMuon ON Sach.Ma_Sach = Sach_PhieuMuon.Ma_Sach"
                    + "  Join Phieu_Muon ON Sach_PhieuMuon.Ma_PM = Phieu_Muon.Ma_PM"
                    + "  WHERE Sach.Ma_Sach = ? and Phieu_Muon.Ma_Doc_Gia = ? and Phieu_Muon.Ma_PM = ? and Sach_PhieuMuon.SoLuong = ?";
            System.out.println(sql);
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, s.getId());
            pst.setInt(2, pm.getMa_Doc_Gia());
            pst.setInt(3, pm.getMa_PM());
            pst.setInt(4, SoLuong);
            check = pst.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

}
