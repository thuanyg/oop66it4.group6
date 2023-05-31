/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.SachDAO;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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

    public int Update() {
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

    public void UpdateSoLuongInsertPM() {
        JTable tbl = home.getTbl_sachMuon();
        for (int i = 0; i < tbl.getRowCount() && tbl.getRowCount() != 0; i++) {
            int soSachMuon = Integer.parseInt(tbl.getValueAt(i, 1).toString());
            String id_Ten = tbl.getValueAt(i, 0).toString();
            String[] idArray = id_Ten.split("\\s|[A-Za-z]+");
            int id = Integer.parseInt(idArray[0]);
//            System.out.println("ID sach = "+id);
            Sach s = SachDAO.getInstant().selectById(id);
//            System.out.println(s.getId() + "-" + s.getTenSach() + "-" + s.getTacGia());
            // Số lượng = số sách còn - số lượng sách mượn
            int sL = s.getSoLuong() - soSachMuon;
            s.setSoLuong(sL);
            int rs = SachDAO.getInstant().Update(s);
        }
    }

    public void UpdateSoLuongKhiTraSach(){
        JTable tbl_SachMuonCu = home.getTbl_sachMuonTemp();
        // Số sách còn lại (s) = số sách ban đầu (s_bd) + số sách trả (s_t) - số sách mượn mới (s_m)
        // s = s_bd + s_t - s_m
        // s_sauTra = s_bd + s_t
        // s = s_sauTra - s_m
        int s_sauTra = 0;
        for (int i = 0; i < tbl_SachMuonCu.getRowCount() && tbl_SachMuonCu.getRowCount() != 0; i++) {
            int s_t = Integer.parseInt(tbl_SachMuonCu.getValueAt(i, 1).toString());
            String id_Ten = tbl_SachMuonCu.getValueAt(i, 0).toString();
            String[] idArray = id_Ten.split("\\s|[A-Za-z]+");
            int id = Integer.parseInt(idArray[0]);
            Sach s = SachDAO.getInstant().selectById(id);
            int s_bd = s.getSoLuong();
            s_sauTra = s_bd + s_t;
            // Cập nhật table
            s.setSoLuong(s_sauTra);
            SachDAO.getInstant().Update(s);
        }
    }
    
    public void UpdateSoLuongUpdatePM() {
        // Trả -> Mượn
        UpdateSoLuongKhiTraSach();
        UpdateSoLuongInsertPM();
    }
    
}
