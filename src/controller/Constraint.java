/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JOptionPane;
import view.Home;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class Constraint {

    private Home home;

    public Constraint(Home home) {
        this.home = home;
    }

    // Validation for jtextfield - Sach
    public boolean SachValidate() {
        boolean flag = true;
        String maSach = home.getTxtIdBook().getText().trim();
        String tenSach = home.getTxtBookName().getText().trim();
        String tacGia = home.getTxtAuthor().getText().trim();
        String theLoai = home.getTxtTypeOfBook().getText().trim();
        String nhaXB = home.getTxtPublisher().getText().trim();
        String namXb = home.getTxtPublishYear().getText().trim();
        int soLuong = (int) home.getSpiner_bookQuantity().getValue();
        String gia = home.getTxtPrice().getText().trim();

        if (maSach.isEmpty()) {
            JOptionPane.showMessageDialog(home, "Mã sách không được để trống!", "Please enter ID Book", JOptionPane.WARNING_MESSAGE);
            flag = false;
        } else if (!maSach.matches("\\d+")) {
            JOptionPane.showMessageDialog(home, "Mã sách định dạng là kiểu số!", "Please enter ID Book", JOptionPane.WARNING_MESSAGE);
            flag = false;
        } else if (tenSach.isEmpty()) {
            JOptionPane.showMessageDialog(home, "Tên sách không được để trống!", "Please enter name", JOptionPane.WARNING_MESSAGE);
            flag = false;
        } else if (soLuong == 0) {
            JOptionPane.showMessageDialog(home, "Hãy nhập số lượng sách", "NhapSL", JOptionPane.WARNING_MESSAGE);
            flag = false;
        }
        return flag;
    }
}
