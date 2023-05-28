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
    public void Update(){
        int ma = Integer.parseInt(home.getTxtIdDocGia().getText().trim());
        String hoTen = home.getTxtTenDocGia().getText().trim();
        String cccd = home.getTxtCCCD().getText().trim();
        String sdt = home.getTxtSDT().getText().trim();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String NgaySinh = sdf.format(home.getDateChoose().getDate());
        int gioiTinh = home.getRdNam().isSelected()?1:0;
        DocGia docGia = new DocGia(ma, gioiTinh, hoTen, cccd, sdt, NgaySinh);
//        docGia.setMDG(Integer.parseInt(ma));
//        docGia.setHo_Ten(hoTen);
//        docGia.setCCCD(cccd);
//        docGia.setSDT(sdt);
//        docGia.setGioi_Tinh((gioiTinh));
//        docGia.setNgay_SInh(NgaySinh);
        int rs = DocGiaDAO.getInstant().Update(docGia);
        if (rs > 0) {
            JOptionPane.showMessageDialog(home, "Update thành công! [ID = " + ma + ", Name = " + hoTen + "]");
            showDocGia.getInstance().showDocGia(home.getDocGTableModel());
        } else {
            JOptionPane.showMessageDialog(home, "Update thất bại, hãy kiểm tra lại!");
        }
    }
}
