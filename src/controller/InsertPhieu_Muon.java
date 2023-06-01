/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DocGiaDAO;
import dao.PhieuMuonDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import model.DocGia;
import model.PhieuMuon;
import view.Home;

/**
 *
 * @author Admin
 */
public class InsertPhieu_Muon {

    private Home home;

    public InsertPhieu_Muon(Home home) {
        this.home = home;
    }

    public void InsertPhieu_Muon() throws ParseException {
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
        int rs = PhieuMuonDAO.getInstant().Insert(pm);
        System.out.println(rs);
        if (rs > 0) {
            JOptionPane.showMessageDialog(home, "Thêm thành công! ID = " + Ma_PM);
            InsertSachPhieuMuon ins2 = new InsertSachPhieuMuon(home);
            ins2.Insert();
            // Cap nhat so l sach
            UpdateBookController update = new UpdateBookController(home);
            update.UpdateSoLuongInsertPM();
            home.getBtn_clear().doClick();
            ShowPhieuMuon s = new ShowPhieuMuon();
            s.ShowOnTablePM(home.getPhieuMuonTableModel());
        } else {
            JOptionPane.showMessageDialog(home, "Thêm thất bại, hãy kiểm tra lại!");
        }
    }
}
