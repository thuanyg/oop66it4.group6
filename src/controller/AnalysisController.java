/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.Home;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class AnalysisController extends Home {

    public AnalysisController() {
        
    }

    public void setTotalBooks() {
        Dashboard ds = new Dashboard();
        int s = ds.TongSachCon();
        getLb_tongSachCon().setText("10320");
        getLb_tongSachCon().setText(String.valueOf(s));
        System.out.println("So sach con lai: " + String.valueOf(s));
    }
}
