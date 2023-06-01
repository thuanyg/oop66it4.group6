/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DocGiaDAO;
import dao.SachDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.DocGia;
import model.Sach;
import view.Home;

/**
 *
 * @author ACER
 */
public class ShowDocGia extends Home {

    List<DocGia> listDocGia = DocGiaDAO.getInstant().selectAll();

    public ShowDocGia() {

    }

    public static ShowDocGia getInstance() {
        return new ShowDocGia();
    }

    public void showDocGia(DefaultTableModel tableModel) {
        tableModel.setRowCount(0);
        listDocGia.forEach((t) -> {
            tableModel.addRow(new Object[]{t.getMDG(),
                t.getHo_Ten(), t.getGioi_Tinh(), t.getNgay_SInh(), t.getCCCD(), t.getSDT()
            });
        });
    }
    
    public void ShowOnTblDocGiaWhileSearching(ArrayList<DocGia> list, DefaultTableModel tableModel){
        tableModel.setRowCount(0);
        list.forEach((t) -> {
            tableModel.addRow(new Object[]{t.getMDG(),
                t.getHo_Ten(), t.getGioi_Tinh(), t.getNgay_SInh(), t.getCCCD(), t.getSDT()
            });
        });
    }

}
