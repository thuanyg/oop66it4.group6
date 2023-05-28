/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.DocGia;
import model.Sach;
import view.Home;
/**
 *
 * @author ACER
 */
public class DocGiaDAO implements DAOInterface<DocGia>{

    public static DocGiaDAO getInstant() {
        return new DocGiaDAO();
    }

    @Override
    public int Insert(DocGia t) {
        
        int check = 0;
        try {
            // Tạo kết nối
            Connection connection = JDBCUtil.getConnection();
            JDBCUtil.printInfo(connection);
            String sql = "INSERT INTO Doc_Gia "
                    + "VALUES ( "+ t.getMDG() + ",N'" + t.getHo_Ten() + "'," + t.getCCCD() + "," + t.getSDT() + ",'" + t.getNgay_SInh() + "'," + t.getGioi_Tinh()+")";
            System.out.println(sql);
            Statement st = connection.createStatement();
            check = st.executeUpdate(sql);
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    

    }

    @Override
    public int Update(DocGia t) {
        int rs = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            JDBCUtil.printInfo(connection);
            String sql = "UPDATE Doc_Gia SET Ma_Doc_Gia = ?, Ho_Ten = ?, CCCD = ?, SDT = ?, Ngay_Sinh = ?,"
                    + "Gioi_Tinh = ?" + " WHERE Ma_Doc_Gia = " + t.getMDG();
            System.out.println(sql);
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, t.getMDG());
            pst.setString(2, t.getHo_Ten());
            pst.setString(3, t.getCCCD());
            pst.setString(4, t.getSDT());
            pst.setDate(5, t.getNgay_SInh());
            pst.setInt(6, t.getGioi_Tinh());
            rs = pst.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;    }

    @Override
    public int Delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<DocGia> selectAll() {
        ArrayList<DocGia> ketQua = new ArrayList<>();
        try {
            //B1: Tạo kết nối
            Connection connection = JDBCUtil.getConnection();
//            JDBCUtil.printInfo(connection);
            //B2: Tạo đối tượng Statement
            Statement st = connection.createStatement();
            //B3: Thực thi câu lệnh SQL
            String sql = "SELECT * FROM Doc_Gia";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("Ma_Doc_Gia");
                String hoTen = rs.getString("Ho_Ten");
                String CCCD = rs.getString("CCCD");
                String SDT = rs.getString("SDT");
                Date Ngay_Sinh = rs.getDate("Ngay_Sinh");
                int gt = rs.getInt("Gioi_Tinh");
                DocGia t = new DocGia(id, gt, hoTen, CCCD, SDT, Ngay_Sinh);
                ketQua.add(t);
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public DocGia selectById(DocGia t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<DocGia> Search(String s) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
