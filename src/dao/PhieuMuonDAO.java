/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.PhieuMuon;

/**
 *
 * @author ACER
 */
public class PhieuMuonDAO implements DAOInterface<PhieuMuon> {

    public static PhieuMuonDAO getInstant() {
        return new PhieuMuonDAO();
    }

    @Override
    public int Insert(PhieuMuon t) {
        int check = 0;
        try {
            // Tạo kết nối
            Connection connection = JDBCUtil.getConnection();
            JDBCUtil.printInfo(connection);
            String sql = "INSERT INTO Phieu_Muon VALUES (?,?,?,?,?)";
            System.out.println(sql);
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, t.getMa_PM());
            pst.setInt(2, t.getMa_Doc_Gia());
            pst.setString(3, t.getNgay_Muon());
            pst.setString(4, t.getNgay_Hen_Tra());
            pst.setString(5, t.getNgay_Tra());
            check = pst.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;

    }

    @Override
    public int Update(PhieuMuon t) {
        int rs = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            JDBCUtil.printInfo(connection);
            String sql = "UPDATE Phieu_Muon SET Ma_PM = ?, Ma_Doc_Gia = ?, Ngay_Muon = ?, Ngay_Hen_Tra = ?, Ngay_Tra=?"
                    + " WHERE Ma_PM = " + t.getMa_PM();
            System.out.println(sql);
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, t.getMa_PM());
            pst.setInt(2, t.getMa_Doc_Gia());
            pst.setString(3, t.getNgay_Muon());
            pst.setString(4, t.getNgay_Hen_Tra());
            pst.setString(5, t.getNgay_Tra());
            rs = pst.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public int Delete(int id) {
        int check = 0;
        try {
            // Tạo kết nối
            Connection connection = JDBCUtil.getConnection();
            JDBCUtil.printInfo(connection);
            String sql = "DELETE FROM Phieu_Muon WHERE Ma_PM = ?";
            System.out.println(sql);
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            check = pst.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public ArrayList<PhieuMuon> selectAll() {
        ArrayList<PhieuMuon> list = new ArrayList<>();
        Connection c = null;
        try {
            c = JDBCUtil.getConnection();
            String sql = "SELECT * FROM Phieu_Muon";
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("Ma_PM");
                String NgayMuon = rs.getString("Ngay_Muon");
                String NgayHenTra = rs.getString("Ngay_Hen_Tra");
                String NgayTra = rs.getString("Ngay_Tra");
                int Ma_DG = rs.getInt("Ma_Doc_Gia");
                PhieuMuon pm = new PhieuMuon(id, Ma_DG, NgayMuon, NgayHenTra, NgayTra);
                list.add(pm);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public PhieuMuon selectById(PhieuMuon t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<PhieuMuon> Search(String s) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}