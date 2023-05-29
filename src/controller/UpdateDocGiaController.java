/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DocGiaDAO;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import model.DocGia;
import view.Home;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class UpdateDocGiaController {

    private Home home;

    public UpdateDocGiaController(Home home) {
        this.home = home;
    }

    public void Update() {
        int ma = 0;
        String hoTen = null;
        String cccd = null;
        String sdt = null;
        String NgaySinh = null;
        try {
            ma = Integer.parseInt(home.getTxtIdDocGia().getText().trim());
            hoTen = home.getTxtTenDocGia().getText().trim();
            cccd = home.getTxtCCCD().getText().trim();
            sdt = home.getTxtSDT().getText().trim();
            if (home.getDateChoose().getDate() == null) {
                NgaySinh = null;
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                NgaySinh = sdf.format(home.getDateChoose().getDate());
            }
        } catch (NumberFormatException numberFormatException) {
        }
        int gioiTinh = home.getRdNam().isSelected() ? 1 : 0;
        DocGia docGia = new DocGia(ma, gioiTinh, hoTen, cccd, sdt, NgaySinh);
        int rs = DocGiaDAO.getInstant().Update(docGia);
        if (rs > 0) {
            JOptionPane.showMessageDialog(home, "Update thành công! [ID = " + ma + ", Name = " + hoTen + "]");
            ShowDocGia.getInstance().showDocGia(home.getDocGTableModel());
        } else {
            JOptionPane.showMessageDialog(home, "Update thất bại, hãy kiểm tra lại!");
        }
    }
}
