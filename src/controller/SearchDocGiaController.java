/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DocGiaDAO;
import java.util.ArrayList;
import model.DocGia;
import view.Home;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class SearchDocGiaController {
    private Home d;

    public SearchDocGiaController(Home d) {
        this.d = d;
    }
    
    public void Search() {
        String s = d.getTxtSearchDocGia().getText().trim();
        if (!s.equals(null)) {
            ArrayList<DocGia> listDocGia = DocGiaDAO.getInstant().Search(s);
            // Đổ dữ liệu
            ShowDocGia.getInstance().ShowOnTblDocGiaWhileSearching(listDocGia, d.getDocGTableModel());
        }
    }
}
