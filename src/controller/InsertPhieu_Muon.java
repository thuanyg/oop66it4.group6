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
        String Ngay_Muon  = null;
        String Ngay_Hen_Tra = null;
        String Ngay_Tra = null;
        try {
            Ma_PM = Integer.parseInt(home.getTxtMaPhieuMuon().getText().trim());
            Ma_DG = Integer.parseInt(home.getTxtIdBook2().getText().trim());
            Ngay_Muon = home.getTxtNgayMuon().getText().trim();
            Ngay_Hen_Tra = home.getTxtNgayMuon1().getText().trim();
            Ngay_Tra = home.getTxtNgayMuon2().getText().trim();
        } catch (NumberFormatException numberFormatException) {
        }
        PhieuMuon t = new PhieuMuon(Ma_PM, Ma_DG, Ngay_Muon, Ngay_Hen_Tra, Ngay_Tra);
//        listSach.add(sach);
        int rs = PhieuMuonDAO.getInstant().Insert(t);
        System.out.println(rs);
        if (rs > 0) {
            JOptionPane.showMessageDialog(home, "Thêm thành công! [ID = " + Ma_PM);
            ShowPhieuMuon s = new ShowPhieuMuon();
            s.ShowOnTablePM(home.getPhieuMuonTableModel());
        } else {
            JOptionPane.showMessageDialog(home, "Thêm thất bại, hãy kiểm tra lại!");
        }
    }
}


