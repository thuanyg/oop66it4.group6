/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analysService;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.PhieuMuon;
import view.Home;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class AnalysisController {
    private Home home;
    DashboardJDBC ds = new DashboardJDBC();
    public AnalysisController(Home home) {
        this.home = home;
    }

    public void setTotalBooks() {
//        DashboardJDBC ds = new DashboardJDBC();
        int s = ds.TongSachCon();
        home.getLb_tongSachCon().setText("" + String.valueOf(s));
    }

    public void setTongNguoiMuon() {
//        DashboardJDBC ds = new DashboardJDBC();
        int s = ds.TongNguoiMuon();
        home.getLb_tongNguoiMuon().setText("" + String.valueOf(s));
    }

    public void setTongSachMuon() {
//        DashboardJDBC ds = new DashboardJDBC();
        int s = ds.TongSachMuon();
        home.getLb_tongSachDuocMuon().setText("" + String.valueOf(s));
    }
    
    public void setTablePMQuaHan() {
        ArrayList<PhieuMuon> list = ds.PhieuMuonQuaHan();
        if(!list.isEmpty()){
            home.getPhieuMuonQHTableModel().setRowCount(0);
            list.forEach((pm) -> {
                home.getPhieuMuonQHTableModel().addRow(new Object[]{pm.getMa_PM(), pm.getMa_Doc_Gia(), pm.getNgay_Muon(), pm.getNgay_Hen_Tra(), pm.getNgay_Tra()});
            });      
        }
    }
    
    public void ShowTienPhat(){
        String maPM = home.getPhieuMuonQHTableModel().getValueAt(home.getTbl_PhieuMuonQH().getSelectedRow(), 0).toString();
        float tienphat = ds.TinhTienPhat(Integer.parseInt(maPM));
        JOptionPane.showMessageDialog(home, "Số tiền phạt của phiếu mượn mã " + maPM + " là " + tienphat + " (VND).");
    }

}
