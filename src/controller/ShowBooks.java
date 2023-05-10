/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.SachDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Sach;
import view.Home;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class ShowBooks extends Home {

    List<Sach> listSach = SachDAO.getInstant().selectAll();
    
    
    public ShowBooks() {
        
    }

    public static ShowBooks getInstance(){
        return new ShowBooks();
    }
    
    public void ShowOnTblSach(DefaultTableModel tableModel) {
        tableModel.setRowCount(0);
        listSach.forEach((sach) -> {
            tableModel.addRow(new Object[]{sach.getId(),
                sach.getTenSach(), sach.getTheLoai(), sach.getTacGia(), sach.getNamXB(),
                sach.getNhaXB(), sach.getSoLuong(), sach.getGiaSach()});
        });
    }
    
    public void ShowOnTblSachWhileSearching(ArrayList<Sach> list, DefaultTableModel tableModel){
        tableModel.setRowCount(0);
        list.forEach((sach) -> {
            tableModel.addRow(new Object[]{sach.getId(),
                sach.getTenSach(), sach.getTheLoai(), sach.getTacGia(), sach.getNamXB(),
                sach.getNhaXB(), sach.getSoLuong(), sach.getGiaSach()});
        });
    }
}
