/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.SachDAO;
import java.util.ArrayList;
import model.Sach;
import view.Home;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class SearchBookController {

    private Home h;

    public SearchBookController(Home h) {
        this.h = h;
    }

    public void Search() {
        String s = h.getTxtSearchBook().getText().trim();
        if (!s.equals(null)) {
            ArrayList<Sach> listSach = SachDAO.getInstant().Search(s);
            // Đổ dữ liệu
            ShowBooks.getInstance().ShowOnTblSachWhileSearching(listSach, h.getSachTableModel());
        }
    }
}
