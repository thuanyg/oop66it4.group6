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
import javax.swing.RowFilter;
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
            String sql = "INSERT INTO Sach "
                    + "VALUES (" + s.getId() + ",N'" + s.getTenSach() + "',N'" + s.getTheLoai() + "',N'" + s.getTacGia() + "'," + s.getNamXB() + ",N'" + s.getNhaXB() + "'," + s.getSoLuong() + "," + s.getGiaSach() + ")";
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
    public int Update(Sach s) {
        int rs = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            JDBCUtil.printInfo(connection);
            String sql = "UPDATE Sach SET Ma_Sach = ?, Ten_Sach = ?, The_Loai = ?, Ten_TG = ?, NamXB = ?,"
                    + "NhaXB = ?, SL = ?, Gia_Sach = ?" + " WHERE Ma_Sach = " + s.getId();
            System.out.println(sql);
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, s.getId());
            pst.setString(2, s.getTenSach());
            pst.setString(3, s.getTheLoai());
            pst.setString(4, s.getTacGia());
            pst.setInt(5, s.getNamXB());
            pst.setString(6, s.getNhaXB());
            pst.setInt(7, s.getSoLuong());
            pst.setFloat(8, s.getGiaSach());
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
            String sql = "DELETE FROM Sach WHERE Ma_Sach = ?";
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
            while (rs.next()) {
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
    public ArrayList<Sach> Search(String s) {
        ArrayList<Sach> ketQua = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            // Tìm kiếm theo mã hoặc tên
            String sql = "SELECT * FROM Sach WHERE Ma_Sach LIKE Concat('%',?,'%') Or Ten_Sach LIKE Concat('%',?,'%') Or The_Loai LIKE Concat('%',?,'%') Or Ten_TG LIKE Concat('%',?,'%') Or NamXB LIKE Concat('%',?,'%') Or NhaXB LIKE Concat('%',?,'%') Or Gia_Sach LIKE Concat('%',?,'%')";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, s);
            pst.setString(2, s);
            pst.setString(3, s);
            pst.setString(4, s);
            pst.setString(5, s);
            pst.setString(6, s);
            pst.setString(7, s);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
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

    public void SearchWithoutDB(Home home, String c) {
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(home.getSachTableModel());
        home.getTbl_Sach().setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(c));
    }

    public ArrayList<Sach> SortByName() {
        ArrayList<Sach> results = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM Sach ORDER BY Ten_Sach ASC";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("Ma_Sach");
                String tenSach = rs.getString("Ten_Sach");
                String theLoai = rs.getString("The_Loai");
                String tacGia = rs.getString("Ten_TG");
                int namXB = rs.getInt("NamXB");
                String nhaXB = rs.getString("NhaXB");
                int soL = rs.getInt("SL");
                float gia = rs.getFloat("Gia_Sach");
                Sach sach = new Sach(id, tenSach, theLoai, tacGia, namXB, nhaXB, soL, gia);
                results.add(sach);
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public ArrayList<Sach> SortByMaSach() {
        ArrayList<Sach> SMaSach = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            Statement st = connection.createStatement();
            String sql = "SELECT*from Sach order by Ma_Sach asc";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("Ma_Sach");
                String tenSach = rs.getString("Ten_Sach");
                String theLoai = rs.getString("The_Loai");
                String tacGia = rs.getString("Ten_TG");
                int namXB = rs.getInt("NamXB");
                String nhaXB = rs.getString("NhaXB");
                int soL = rs.getInt("SL");
                float gia = rs.getFloat("Gia_Sach");
                Sach sach = new Sach(id, tenSach, theLoai, tacGia, namXB, nhaXB, soL, gia);
                SMaSach.add(sach);
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return SMaSach;
    }

    public ArrayList<Sach> SortBySoLuong() {
        ArrayList<Sach> Ssoluong = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            Statement st = connection.createStatement();
            String sql = "SELECT*from Sach order by SL asc";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("Ma_Sach");
                String tenSach = rs.getString("Ten_Sach");
                String theLoai = rs.getString("The_Loai");
                String tacGia = rs.getString("Ten_TG");
                int namXB = rs.getInt("NamXB");
                String nhaXB = rs.getString("NhaXB");
                int soL = rs.getInt("SL");
                float gia = rs.getFloat("Gia_Sach");
                Sach sach = new Sach(id, tenSach, theLoai, tacGia, namXB, nhaXB, soL, gia);
                Ssoluong.add(sach);
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Ssoluong;
    }

    public ArrayList<Sach> SortByGia() {
        ArrayList<Sach> SGia = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            Statement st = connection.createStatement();
                String sql = "SELECT*from Sach order by Gia_Sach asc";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("Ma_Sach");
                String tenSach = rs.getString("Ten_Sach");
                String theLoai = rs.getString("The_Loai");
                String tacGia = rs.getString("Ten_TG");
                int namXB = rs.getInt("NamXB");
                String nhaXB = rs.getString("NhaXB");
                int soL = rs.getInt("SL");
                float gia = rs.getFloat("Gia_Sach");
                Sach sach = new Sach(id, tenSach, theLoai, tacGia, namXB, nhaXB, soL, gia);
                SGia.add(sach);
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return SGia;
    }

    public ArrayList<Sach> SortByTheLoai() {
        ArrayList<Sach> STheLoai = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            Statement st = connection.createStatement();
            String sql = "SELECT*from Sach order by The_Loai asc";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("Ma_Sach");
                String tenSach = rs.getString("Ten_Sach");
                String theLoai = rs.getString("The_Loai");
                String tacGia = rs.getString("Ten_TG");
                int namXB = rs.getInt("NamXB");
                String nhaXB = rs.getString("NhaXB");
                int soL = rs.getInt("SL");
                float gia = rs.getFloat("Gia_Sach");
                Sach sach = new Sach(id, tenSach, theLoai, tacGia, namXB, nhaXB, soL, gia);
                STheLoai.add(sach);
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return STheLoai;
    }

    public ArrayList<Sach> SortByTacGia() {
        ArrayList<Sach> STacGia = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            Statement st = connection.createStatement();
            String sql = "SELECT*from Sach order by Ten_TG asc";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("Ma_Sach");
                String tenSach = rs.getString("Ten_Sach");
                String theLoai = rs.getString("The_Loai");
                String tacGia = rs.getString("Ten_TG");
                int namXB = rs.getInt("NamXB");
                String nhaXB = rs.getString("NhaXB");
                int soL = rs.getInt("SL");
                float gia = rs.getFloat("Gia_Sach");
                Sach sach = new Sach(id, tenSach, theLoai, tacGia, namXB, nhaXB, soL, gia);
                STacGia.add(sach);
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return STacGia;
    }

    public ArrayList<Sach> SortByNhaXb() {
        ArrayList<Sach> SNhaXB = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            Statement st = connection.createStatement();
            String sql = "SELECT*from Sach order by NhaXB asc";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("Ma_Sach");
                String tenSach = rs.getString("Ten_Sach");
                String theLoai = rs.getString("The_Loai");
                String tacGia = rs.getString("Ten_TG");
                int namXB = rs.getInt("NamXB");
                String nhaXB = rs.getString("NhaXB");
                int soL = rs.getInt("SL");
                float gia = rs.getFloat("Gia_Sach");
                Sach sach = new Sach(id, tenSach, theLoai, tacGia, namXB, nhaXB, soL, gia);
                SNhaXB.add(sach);
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return SNhaXB;
    }

    @Override
    public Sach selectById(int id) {
        Sach ss = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "SELECT * FROM Sach WHERE Ma_Sach = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int idS = rs.getInt("Ma_Sach");
                String tenSach = rs.getString("Ten_Sach");
                String theLoai = rs.getString("The_Loai");
                String tacGia = rs.getString("Ten_TG");
                int namXB = rs.getInt("NamXB");
                String nhaXB = rs.getString("NhaXB");
                int soL = rs.getInt("SL");
                float gia = rs.getFloat("Gia_Sach");
                Sach s = new Sach(idS, tenSach, theLoai, tacGia, namXB, nhaXB, soL, gia);
                ss = s;
            }

            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ss;
    }
}
