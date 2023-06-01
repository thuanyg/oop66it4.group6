/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.SachDAO;
import dao.SachPhieuMuonDAO;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.PhieuMuon;
import model.Sach;
import view.Home;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class InsertSachPhieuMuon {

    private Home home;

    public InsertSachPhieuMuon(Home home) {
        this.home = home;
    }

    public void Insert() {
        int rs = 0;
        for (int i = 0; i < home.getTbl_sachMuon().getRowCount() && home.getTbl_sachMuon().getRowCount() != 0; i++) {
            String id_tenSach = home.getTbl_sachMuon().getValueAt(i, 0).toString();
            int soLuongSachMuon = Integer.parseInt(home.getTbl_sachMuon().getValueAt(i, 1).toString());
            String str[] = id_tenSach.split("\\s|[A-Za-z]+");
            Sach s = new Sach();
            s.setId(Integer.parseInt(str[0]));
            PhieuMuon pm = new PhieuMuon();
            pm.setMa_PM(Integer.parseInt(home.getTxtMaPhieuMuon().getText().trim()));
            rs = SachPhieuMuonDAO.getInstant().Insert(s, pm, soLuongSachMuon);
        }
//        if (rs > 0) {
//            JOptionPane.showMessageDialog(home, "Dữ liệu tbl.Sach_PhieuMuon đã được cập nhật!");
//        } else {
//            JOptionPane.showMessageDialog(home, "Thêm thất bại, hãy kiểm tra lại!");
//        }
    }

}
