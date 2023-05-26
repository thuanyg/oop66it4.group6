/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.SachDAO;
import javax.swing.JOptionPane;
import model.Sach;
import view.Home;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class UpdateBookController {
    private Home home;

    public UpdateBookController(Home home) {
        this.home = home;
    }
    public int Update(){
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
        int rs = SachDAO.getInstant().Update(sach);
        System.out.println(rs);
        if (rs > 0) {
            JOptionPane.showMessageDialog(home, "Update thành công! [ID = " + maSach + ", Name = " + tenSach + "]");
            home.getTxtIdBook().setEditable(true);
        } else {
            JOptionPane.showMessageDialog(home, "Update thất bại, hãy kiểm tra lại!");
        }
        return rs;
    }
}
