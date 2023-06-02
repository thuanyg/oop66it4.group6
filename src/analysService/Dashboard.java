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
import java.util.List;
import model.Sach;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class Dashboard{

    public Dashboard() {
    }
    
    public int TongSachCon(){
        List<Sach> listSach = SachDAO.getInstant().selectAll();
        return listSach.size();
    }
    
    public int TongNguoiMuon(){
        int rs = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            JDBCUtil.printInfo(connection);
            String sql = "Select count(Distinct Ma_Doc_Gia)as 'sol' From Phieu_Muon";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet kq = pst.executeQuery();
            if(kq.next()){
                rs = kq.getInt("sol");
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public int TongSachMuon(){
        int rs = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            JDBCUtil.printInfo(connection);
            String sql = "Select Sum(SoLuong)as 'sol' From Sach_PhieuMuon";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet kq = pst.executeQuery();
            if(kq.next()){
                rs = kq.getInt("sol");
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
}
