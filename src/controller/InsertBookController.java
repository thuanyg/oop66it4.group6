/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.SachDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Sach;
import view.Home;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class InsertBookController {

    private Home home;
    List<Sach> listSach = new ArrayList<>();

    public InsertBookController(Home home) {
        this.home = home;
    }

    public void Insert() {
        String theLoai = null;
        String tacGia = null;
        int namXb = 0;
        String nhaXB = null;
        float gia = 0;
        int maSach = Integer.parseInt(home.getTxtIdBook().getText().trim());
        String tenSach = home.getTxtBookName().getText().trim();
        int soLuong = (int) home.getSpiner_bookQuantity().getValue();
        try {
            tacGia = home.getTxtAuthor().getText().trim();
            theLoai = home.getTxtTypeOfBook().getText().trim();
            nhaXB = home.getTxtPublisher().getText().trim();
            namXb = Integer.parseInt(home.getTxtPublishYear().getText().trim());
            gia = Float.parseFloat(home.getTxtPrice().getText().trim());
        } catch (NumberFormatException numberFormatException) {
        }
        Sach sach = new Sach(maSach, tenSach, theLoai, tacGia, namXb, nhaXB, soLuong, gia);
//        listSach.add(sach);
        int rs = SachDAO.getInstant().Insert(sach);
        System.out.println(rs);
        if (rs > 0) {
            JOptionPane.showMessageDialog(home, "Thêm thành công!");
            ShowBooks show = new ShowBooks();
            show.ShowOnTblSach(home.getSachTableModel());
        } else {
            JOptionPane.showMessageDialog(home, "Thêm thất bại, hãy kiểm tra lại!");
        }
    }
}
