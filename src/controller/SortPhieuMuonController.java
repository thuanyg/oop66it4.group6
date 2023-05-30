package controller;

import dao.PhieuMuonDAO;
import java.util.ArrayList;
import model.PhieuMuon;
import view.Home;

/**
 *
 * @author hungm
 */
public class SortPhieuMuonController {

    private Home home;

    public SortPhieuMuonController(Home home) {
        this.home = home;
    }

    public void Sort() {

        int idex = home.getCbxSortPhieuMuon().getSelectedIndex();

        switch (idex) {
            case 0:
                ArrayList<PhieuMuon> listPhieu = PhieuMuonDAO.getInstant().SortMaPhieu();
                home.getPhieuMuonTableModel().setRowCount(0);
                listPhieu.forEach((pm) -> {
                    home.getPhieuMuonTableModel().addRow(new Object[]{pm.getMa_PM(), pm.getMa_Doc_Gia(), pm.getNgay_Muon(), pm.getNgay_Hen_Tra(), pm.getNgay_Tra()});
                });
                break;
            case 1:
                ArrayList<PhieuMuon> listPhieu1 = PhieuMuonDAO.getInstant().SortMaDocGia();
                home.getPhieuMuonTableModel().setRowCount(0);
                listPhieu1.forEach((pm) -> {
                    home.getPhieuMuonTableModel().addRow(new Object[]{pm.getMa_PM(), pm.getMa_Doc_Gia(), pm.getNgay_Muon(), pm.getNgay_Hen_Tra(), pm.getNgay_Tra()});
                });
                break;
            case 2:
                ArrayList<PhieuMuon> listPhieu2 = PhieuMuonDAO.getInstant().SortNgayMuon();
                home.getPhieuMuonTableModel().setRowCount(0);
                listPhieu2.forEach((pm) -> {
                    home.getPhieuMuonTableModel().addRow(new Object[]{pm.getMa_PM(), pm.getMa_Doc_Gia(), pm.getNgay_Muon(), pm.getNgay_Hen_Tra(), pm.getNgay_Tra()});
                });
                break;
            case 3:
                ArrayList<PhieuMuon> listPhieu3 = PhieuMuonDAO.getInstant().SortNgayHenTra();
                home.getPhieuMuonTableModel().setRowCount(0);
                listPhieu3.forEach((pm) -> {
                    home.getPhieuMuonTableModel().addRow(new Object[]{pm.getMa_PM(), pm.getMa_Doc_Gia(), pm.getNgay_Muon(), pm.getNgay_Hen_Tra(), pm.getNgay_Tra()});
                });
                break;
            case 4:
                ArrayList<PhieuMuon> listPhieu4 = PhieuMuonDAO.getInstant().SortNgayTra();
                home.getPhieuMuonTableModel().setRowCount(0);
                listPhieu4.forEach((pm) -> {
                    home.getPhieuMuonTableModel().addRow(new Object[]{pm.getMa_PM(), pm.getMa_Doc_Gia(), pm.getNgay_Muon(), pm.getNgay_Hen_Tra(), pm.getNgay_Tra()});
                });
                break;
            default:
                throw new AssertionError();
        }

    }
}
