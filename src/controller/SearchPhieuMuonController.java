/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.PhieuMuonDAO;
import java.util.ArrayList;
import model.PhieuMuon;
import view.Home;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class SearchPhieuMuonController {

    private Home a;

    public SearchPhieuMuonController(Home a) {
        this.a = a;
    }

    public void Search() {
        ShowPhieuMuon q = new ShowPhieuMuon();
        String p = a.getTxtSearchPhieuMuon().getText().trim();
        if (!p.equals(null)) {
            ArrayList<PhieuMuon> list = PhieuMuonDAO.getInstant().Search(p);
            // Đổ dữ liệu
            q.ShowOnTblPhieuMuonWhileSearching(list, a.getPhieuMuonTableModel());
        }
    }
}
