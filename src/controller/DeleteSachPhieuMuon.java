/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.SachPhieuMuonDAO;
import javax.swing.JOptionPane;
import model.PhieuMuon;
import model.Sach;
import view.Home;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class DeleteSachPhieuMuon {

    private Home home;

    public DeleteSachPhieuMuon(Home home) {
        this.home = home;
    }

    public void Delete() {
        int count = 0;
        for (int i = 0; i < home.getTbl_sachMuonTemp().getRowCount() && home.getTbl_sachMuonTemp().getRowCount() != 0; i++) {
            Sach s = new Sach();
            PhieuMuon pm2 = new PhieuMuon();
            String id_tenSach = home.getTbl_sachMuonTemp().getValueAt(i, 0).toString();
            String str[] = id_tenSach.split("\\s|[A-Za-z]+");
            s.setId(Integer.parseInt(str[0]));
            pm2.setMa_Doc_Gia(Integer.parseInt(home.getTxtIdBook2().getText().trim()));
            pm2.setMa_PM(Integer.parseInt(home.getTxtMaPhieuMuon().getText().trim()));
            int soL = Integer.parseInt(home.getTbl_sachMuonTemp().getValueAt(i, 1).toString());
            int rs = SachPhieuMuonDAO.getInstant().Delete(s, pm2, soL);
//            if (rs > 0) {
//                count++;
//            }
        }
//        if () {
//            JOptionPane.showMessageDialog(home, "Delete tblSachPhieuMuon success!");
//        } else {
//            JOptionPane.showMessageDialog(home, "Lỗi khi xóa ở tblSachPhieuMuon ");
//        }
    }
}
