/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.JDBCUtil;
import database.JDBCUtil;
import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Sach;
import view.Home;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class SachDAO implements DAOInterface<Sach> {

    public static SachDAO getInstant() {
        return new SachDAO();
    }

    @Override
    public int Insert(Sach s) {
        int check = 0;
        try {
            // Tạo kết nối
            Connection connection = JDBCUtil.getConnection();
            JDBCUtil.printInfo(connection);
            String sql = "INSERT INTO Sach "
                    + "VALUES (" + s.getId() + ",N'" + s.getTenSach() + "',N'" + s.getTheLoai() + "',N'" + s.getTacGia() + "'," + s.getNamXB() + ",N'" + s.getNhaXB() + "'," + s.getSoLuong() + "," + s.getGiaSach() + ")";
            System.out.println(sql);
            Statement st = connection.createStatement();
            check = st.executeUpdate(sql);
            
//            pst.setInt(1, s.getId());
//            pst.setString(2, s.getTenSach());
//            pst.setString(3, s.getTheLoai());
//            pst.setString(4, s.getTacGia());
//            pst.setInt(5, s.getNamXB());
//            pst.setString(6, s.getNhaXB());
//            pst.setInt(7, s.getSoLuong());
//            pst.setFloat(8, s.getGiaSach());
//            pst.execute();
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int Update(Sach t) {
        return 0;
    }

    @Override
    public int Delete(Sach t) {
        return 0;
    }

    @Override
    public ArrayList<Sach> selectAll() {
        ArrayList<Sach> ketQua = new ArrayList<>();
        try {
            //B1: Tạo kết nối
            Connection connection = JDBCUtil.getConnection();
//            JDBCUtil.printInfo(connection);
            //B2: Tạo đối tượng Statement
            Statement st = connection.createStatement();
            //B3: Thực thi câu lệnh SQL
            String sql = "SELECT * FROM Sach";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("Ma_Sach");
                String tenSach = rs.getString("Ten_Sach");
                String theLoai = rs.getString("The_Loai");
                String tacGia = rs.getString("Ten_TG");
                int namXB = rs.getInt("NamXB");
                String nhaXB = rs.getString("NhaXB");
                int soL = rs.getInt("SL");
                float gia = rs.getFloat("Gia_Sach");
                Sach sach = new Sach(id, tenSach, theLoai, tacGia, namXB, nhaXB, soL, gia);
                ketQua.add(sach);
            }
            
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public Sach selectById(Sach t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Sach> Search(String s) {
        ArrayList<Sach> arr = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
//            JDBCUtil.printInfo(connection);
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM Sach WHERE Ten_Sach like N'%" + s + "%'";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("Ma_Sach");
                String tenSach = rs.getString("Ten_Sach");
                String theLoai = rs.getString("The_Loai");
                String tacGia = rs.getString("Ten_TG");
                int namXB = rs.getInt("NamXB");
                String nhaXB = rs.getString("NhaXB");
                int soL = rs.getInt("SL");
                float gia = rs.getFloat("Gia_Sach");
                Sach sach = new Sach(id, tenSach, theLoai, tacGia, namXB, nhaXB, soL, gia);
                arr.add(sach);
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arr;
    }
    public void SearchWithoutDB(String c){
        Home home = new Home();
        DefaultTableModel model = home.getSachTableModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        home.getTbl_Sach().setRowSorter(trs);
//        trs.setRowFilter(RowFilters.regexFilter(c));
    }

}
