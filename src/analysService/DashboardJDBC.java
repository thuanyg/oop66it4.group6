/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analysService;

import dao.SachDAO;
import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.PhieuMuon;
import model.Sach;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class DashboardJDBC {

    private Connection connection = null;

    public DashboardJDBC() {
        connection = JDBCUtil.getConnection();
    }

    public int TongSachCon() {
        List<Sach> listSach = SachDAO.getInstant().selectAll();
        return listSach.size();
    }

    public int TongNguoiMuon() {
        int rs = 0;
        try {
            String sql = "Select count(Distinct Ma_Doc_Gia)as 'sol' From Phieu_Muon";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet kq = pst.executeQuery();
            if (kq.next()) {
                rs = kq.getInt("sol");
            }
//            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public int TongSachMuon() {
        int rs = 0;
        try {
            String sql = "Select Sum(SoLuong)as 'sol' From Sach_PhieuMuon";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet kq = pst.executeQuery();
            if (kq.next()) {
                rs = kq.getInt("sol");
            }
//            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ArrayList<PhieuMuon> PhieuMuonQuaHan() {
        ArrayList<PhieuMuon> listPM = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Phieu_Muon WHERE Ngay_Tra > Ngay_Hen_Tra";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet kq = pst.executeQuery();
            while (kq.next()) {
                int id = kq.getInt("Ma_PM");
                String NgayMuon = kq.getString("Ngay_Muon");
                String NgayHenTra = kq.getString("Ngay_Hen_Tra");
                String NgayTra = kq.getString("Ngay_Tra");
                int Ma_DG = kq.getInt("Ma_Doc_Gia");
                PhieuMuon pm = new PhieuMuon(id, Ma_DG, NgayMuon, NgayHenTra, NgayTra);
                listPM.add(pm);
            }
//            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPM;
    }

    public float TinhTienPhat(int maPM) {
        float tienPhat = 0;
        try {
            String sql = "  Select SUM(SoLuong*Gia_Sach*0.5) as 'tienphat' from"
                    + "  Sach_PhieuMuon Join Sach ON Sach_PhieuMuon.Ma_Sach = Sach.Ma_Sach"
                    + "  WHERE Sach_PhieuMuon.Ma_PM = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, maPM);
            ResultSet kq = pst.executeQuery();
            if(kq.next()){
                tienPhat = kq.getFloat("tienphat");
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
       return tienPhat;
    }

}
