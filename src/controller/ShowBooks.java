/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.SachDAO;
import java.util.ArrayList;
import java.util.List;
import model.Sach;
import view.Home;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class ShowBooks {

    List<Sach> listSach = SachDAO.getInstant().selectAll();

    public void ShowOnTable() {
        Home h = new Home();
        h.getTableModel().setRowCount(0);
        listSach.forEach((sach) -> {
            h.getTableModel().addRow(new Object[]{sach.getId(),
                sach.getTenSach(), sach.getTacGia(), sach.getNamXB(),
                sach.getNhaXB(), sach.getSoLuong(), sach.getGiaSach()
            });
        });
        }
    }
