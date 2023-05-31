/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.PhieuMuonDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.PhieuMuon;

/**
 *
 * @author ACER
 */
public class ShowPhieuMuon {

    List<PhieuMuon> list = PhieuMuonDAO.getInstant().selectAll();

    public ShowPhieuMuon() {
    }

    public void ShowOnTablePM(DefaultTableModel tableModel) {
        tableModel.setRowCount(0);
        list.forEach((pm) -> {
            tableModel.addRow(new Object[]{pm.getMa_PM(), pm.getMa_Doc_Gia(), pm.getNgay_Muon(), pm.getNgay_Hen_Tra(), pm.getNgay_Tra()});
        });
    }

    public void ShowOnTblPhieuMuonWhileSearching(ArrayList<PhieuMuon> list, DefaultTableModel tableModel) {
        tableModel.setRowCount(0);
        list.forEach((pm) -> {
            tableModel.addRow(new Object[]{pm.getMa_PM(), pm.getMa_Doc_Gia(), pm.getNgay_Muon(), pm.getNgay_Hen_Tra(), pm.getNgay_Tra()});
        });
    }
}
