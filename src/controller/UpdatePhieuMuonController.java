/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.PhieuMuonDAO;
import dao.SachPhieuMuonDAO;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import model.PhieuMuon;
import model.Sach;
import view.Home;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class UpdatePhieuMuonController {

    private Home home;

    public UpdatePhieuMuonController(Home home) {
        this.home = home;
    }

    public void Update() {
        int Ma_PM = 0;
        int Ma_DG = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String Ngay_Muon = null;
        String Ngay_Hen_Tra = null;
        String Ngay_Tra = null;
        try {
            Ma_PM = Integer.parseInt(home.getTxtMaPhieuMuon().getText().trim());
            Ma_DG = Integer.parseInt(home.getTxtIdBook2().getText().trim());
            if (home.getDateChooseNgayMuon().getDate() == null) {
                Ngay_Muon = null;
            } else {
                Ngay_Muon = sdf.format(home.getDateChooseNgayMuon().getDate());
            }
            if (home.getDateChooseNgayHenTra().getDate() == null) {
                Ngay_Hen_Tra = null;
            } else {
                Ngay_Hen_Tra = sdf.format(home.getDateChooseNgayHenTra().getDate());
            }
            if (home.getDateChooseNgayTra().getDate() == null) {
                Ngay_Tra = null;
            } else {
                Ngay_Tra = sdf.format(home.getDateChooseNgayTra().getDate());
            }
        } catch (NumberFormatException numberFormatException) {
        }
        PhieuMuon pm = new PhieuMuon(Ma_PM, Ma_DG, Ngay_Muon, Ngay_Hen_Tra, Ngay_Tra);
        System.out.println(pm.getMa_PM());
        int rs = PhieuMuonDAO.getInstant().Update(pm);
        System.out.println(rs);
        if (rs > 0) {
            JOptionPane.showMessageDialog(home, "Sửa thành công! ID = " + Ma_PM);
//            home.getBtn_clear().doClick();
            // Nếu Bảng sách mượn đang có dữ liệu.Xóa dữ liệu cũ->Lấy tất cả dữ liệu vừa sửa insert vào Sach_PhieuMuon.
            DeleteSachPhieuMuon del = new DeleteSachPhieuMuon(home);
            del.Delete();
            // Insert mới
            InsertSachPhieuMuon ins = new InsertSachPhieuMuon(home);
            ins.Insert();
            ShowPhieuMuon s = new ShowPhieuMuon();
            s.ShowOnTablePM(home.getPhieuMuonTableModel());
        } else {
            JOptionPane.showMessageDialog(home, "Sửa thất bại, hãy kiểm tra lại!");
        }
    }
}
