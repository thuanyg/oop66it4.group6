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

        if(maSach.isBlank() && tenSach.isEmpty() && tacGia.isEmpty() && 
           theLoai.isEmpty() && nhaXB.isEmpty() && namXb.isEmpty() && gia.isEmpty()){
           JOptionPane.showMessageDialog(home, "Hãy nhập thông tin sách để thêm!");
           flag = false;
        } else if (maSach.isEmpty()) {
            JOptionPane.showMessageDialog(home, "Mã sách không được để trống!");
            flag = false;
        } else if (!maSach.matches("\\d+")) {
            JOptionPane.showMessageDialog(home, "Mã sách định dạng là kiểu số!");
            flag = false;
        } else if (tenSach.isEmpty()) {
            JOptionPane.showMessageDialog(home, "Tên sách không được để trống!");
            flag = false;
        } else if (soLuong == 0) {
            JOptionPane.showMessageDialog(home, "Hãy nhập số lượng sách");
            flag = false;
        }
        return flag;
    }
}
