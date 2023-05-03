/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.SachDAO;
import java.util.List;
import model.Sach;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class Dashboard{

    public Dashboard() {
    }
    
    public int TongSachCon(){
        List<Sach> listSach = SachDAO.getInstant().selectAll();
        return listSach.size();
    }
    
    public int TongNguoiMuon(){
        return 0;
    }
    
}
