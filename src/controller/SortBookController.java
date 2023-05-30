/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.SachDAO;
import java.util.ArrayList;
import model.Sach;
import view.Home;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class SortBookController {

    private Home home;

    public SortBookController(Home home) {
        this.home = home;
    }

    public void Sort() {
        int idx = home.getCbxSortBook().getSelectedIndex();
        // Nếu index = 1 ( Chọn ô Tên  Sách)  -> Sort
        if (idx == 1) {
            ArrayList<Sach> listSach = SachDAO.getInstant().SortByName();
            // Đổ dữ liệu ra bảng
            home.getSachTableModel().setRowCount(0);
            listSach.forEach((sach) -> {
                home.getSachTableModel().addRow(new Object[]{sach.getId(),
                    sach.getTenSach(), sach.getTheLoai(), sach.getTacGia(), sach.getNamXB(),
                    sach.getNhaXB(), sach.getSoLuong(), sach.getGiaSach()});
            });
        } 
         if (idx == 0) {
            ArrayList<Sach> listSach = SachDAO.getInstant().SortByMaSach();
            // Mã sách
            home.getSachTableModel().setRowCount(0);
            listSach.forEach((sach) -> {
                home.getSachTableModel().addRow(new Object[]{sach.getId(),
                    sach.getTenSach(), sach.getTheLoai(), sach.getTacGia(), sach.getNamXB(),
                    sach.getNhaXB(), sach.getSoLuong(), sach.getGiaSach()});
            });
        }if (idx == 2) {
            ArrayList<Sach> listSach = SachDAO.getInstant().SortByTacGia();
            // TacGia
            home.getSachTableModel().setRowCount(0);
            listSach.forEach((sach) -> {
                home.getSachTableModel().addRow(new Object[]{sach.getId(),
                    sach.getTenSach(), sach.getTheLoai(), sach.getTacGia(), sach.getNamXB(),
                    sach.getNhaXB(), sach.getSoLuong(), sach.getGiaSach()});
            });
        }
        if (idx == 3) {
            ArrayList<Sach> listSach = SachDAO.getInstant().SortByNhaXb();
            // NhaXB
            home.getSachTableModel().setRowCount(0);
            listSach.forEach((sach) -> {
                home.getSachTableModel().addRow(new Object[]{sach.getId(),
                    sach.getTenSach(), sach.getTheLoai(), sach.getTacGia(), sach.getNamXB(),
                    sach.getNhaXB(), sach.getSoLuong(), sach.getGiaSach()});
            });
        }
       
        if (idx == 5) {
            ArrayList<Sach> listSach = SachDAO.getInstant().SortByTheLoai();
            // TheLoai
            home.getSachTableModel().setRowCount(0);
            listSach.forEach((sach) -> {
                home.getSachTableModel().addRow(new Object[]{sach.getId(),
                    sach.getTenSach(), sach.getTheLoai(), sach.getTacGia(), sach.getNamXB(),
                    sach.getNhaXB(), sach.getSoLuong(), sach.getGiaSach()});
            });
        }
          if (idx == 4) {
            ArrayList<Sach> listSach = SachDAO.getInstant().SortBySoLuong();
            // Số lượng
            home.getSachTableModel().setRowCount(0);
            listSach.forEach((sach) -> {
                home.getSachTableModel().addRow(new Object[]{sach.getId(),
                    sach.getTenSach(), sach.getTheLoai(), sach.getTacGia(), sach.getNamXB(),
                    sach.getNhaXB(), sach.getSoLuong(), sach.getGiaSach()});
            });
        }
          
          
           if (idx == 6) {
            ArrayList<Sach> listSach = SachDAO.getInstant().SortByGia();
            // Giá
            home.getSachTableModel().setRowCount(0);
            listSach.forEach((sach) -> {
                home.getSachTableModel().addRow(new Object[]{sach.getId(),
                    sach.getTenSach(), sach.getTheLoai(), sach.getTacGia(), sach.getNamXB(),
                    sach.getNhaXB(), sach.getSoLuong(), sach.getGiaSach()});
            });
        }
    }
}
