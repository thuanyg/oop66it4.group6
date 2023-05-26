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
public class InsertBookController{
    List<Sach> listSach = new ArrayList<>();
    public InsertBookController() {
    }
    public void Insert(Home home){
        int maSach = Integer.parseInt(home.getTxtIdBook().getText().trim());
        String tenSach = home.getTxtBookName().getText().trim();
        String tacGia = home.getTxtAuthor().getText().trim();
        String theLoai = home.getTxtTypeOfBook().getText().trim();
        String nhaXB = home.getTxtPublisher().getText().trim();
        int namXb = Integer.parseInt( home.getTxtPublishYear().getText().trim());
        int soLuong = (int) home.getSpiner_bookQuantity().getValue();
        float gia = Float.parseFloat( home.getTxtPrice().getText().trim());
        Sach sach = new Sach(maSach, tenSach, theLoai, tacGia, namXb, nhaXB, soLuong, gia);
//        listSach.add(sach);
        SachDAO.getInstant().Insert(sach);
        ShowBooks show = new ShowBooks();
        show.ShowOnTblSach(home.getSachTableModel());
    }
}
