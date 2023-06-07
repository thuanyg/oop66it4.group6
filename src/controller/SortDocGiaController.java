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
 * @author ACER
 */
public class SortDocGiaController {
    private Home home;

    public SortDocGiaController(Home home) {
        this.home = home;
    }
    public void Sort(){
        int idx = home.getCbxSortDocGia().getSelectedIndex();
        if(idx==0){
            ArrayList<DocGia> listDocGia = DocGiaDAO.getInstant().SortByMa();
            // Đổ dữ liệu ra bảng
            home.getDocGTableModel().setRowCount(0);
            listDocGia.forEach((t) -> {
            home.getDocGTableModel().addRow(new Object[]{t.getMDG(),
                t.getHo_Ten(), t.getGioi_Tinh(), t.getNgay_SInh(), t.getCCCD(), t.getSDT()
            });
        });
        }else if(idx==1){
            ArrayList<DocGia> listDocGia = DocGiaDAO.getInstant().SortByName();
            // Đổ dữ liệu ra bảng
            home.getDocGTableModel().setRowCount(0);
            listDocGia.forEach((t) -> {
            home.getDocGTableModel().addRow(new Object[]{t.getMDG(),
                t.getHo_Ten(), t.getGioi_Tinh(), t.getNgay_SInh(), t.getCCCD(), t.getSDT()
            });
        });
        }else if(idx==2){
                ArrayList<DocGia> listDocGia = DocGiaDAO.getInstant().SortByGT();
            // Đổ dữ liệu ra bảng
            home.getDocGTableModel().setRowCount(0);
            listDocGia.forEach((t) -> {
            home.getDocGTableModel().addRow(new Object[]{t.getMDG(),
                t.getHo_Ten(), t.getGioi_Tinh(), t.getNgay_SInh(), t.getCCCD(), t.getSDT()
            });
        });
                }
    }
}
