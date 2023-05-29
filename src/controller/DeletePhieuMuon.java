/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.PhieuMuonDAO;
import dao.SachDAO;
import javax.swing.JOptionPane;
import view.Home;

/**
 *
 * @author ACER
 */
public class DeletePhieuMuon {
    private Home home;

    public DeletePhieuMuon(Home home) {
        this.home = home;
    }

    public void Delete() {
        int c = JOptionPane.showConfirmDialog(home, "Bạn chắc chắn muốn xóa sách? [ID = "
                + home.getTxtMaPhieuMuon().getText().trim() + ", Name = "
                , "Delele confirm", JOptionPane.YES_NO_OPTION);
        // c = 0 -> yes, c = 1 -> no
        if (c == 0) {
            int id = Integer.parseInt(home.getTxtMaPhieuMuon().getText());
            int rs = PhieuMuonDAO.getInstant().Delete(id);
            //rs = 1 nếu xóa thành công
            if (rs == 1) {
                JOptionPane.showMessageDialog(home, "Xóa thành công! [ID = " + home.getTxtIdBook().getText().trim()
                        + ", Name = " + home.getTxtBookName().getText().trim() + "]");
                home.getTxtIdBook().setEditable(true);
            } else {
                JOptionPane.showMessageDialog(home, "Xảy ra lỗi khi xóa!!!");
            }
        }
    }
}
