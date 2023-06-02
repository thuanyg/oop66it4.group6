/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analysService;

import database.JDBCUtil;
import view.Home;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class AnalysisController  {
    private Home home;
    public AnalysisController(Home home) {
        this.home = home;
    }

    public void setTotalBooks() {
        Dashboard ds = new Dashboard();
        int s = ds.TongSachCon();
        home.getLb_tongSachCon().setText("" + String.valueOf(s));
    }
    
    public void setTongNguoiMuon(){
        Dashboard ds = new Dashboard();
        int s = ds.TongNguoiMuon();
        home.getLb_tongNguoiMuon().setText("" + String.valueOf(s));
    }
    
    public void setTongSachMuon(){
        Dashboard ds = new Dashboard();
        int s = ds.TongSachMuon();
        home.getLb_tongSachDuocMuon().setText("" + String.valueOf(s));
    }
}
