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
    }
}
