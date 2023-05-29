/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.sun.source.doctree.SerialDataTree;
import dao.DocGiaDAO;
import dao.SachDAO;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import model.DocGia;
import model.Sach;
import view.Home;

/**
 *
 * @author ACER
 */
public class InsertDocGiaController {

    private Home home;

    public InsertDocGiaController(Home home) {
        this.home = home;
    }

    public void InsertDocGia() throws ParseException {
        int Ma_DG = 0;
        String Ho_Ten = null;
        String CCCD = null;
        String Ngay_Sinh = null;
        String SDT = null;
        try {
            Ma_DG = Integer.parseInt(home.getTxtIdDocGia().getText().trim());
            Ho_Ten = home.getTxtTenDocGia().getText().trim();
            CCCD = home.getTxtCCCD().getText().trim();
            SDT = home.getTxtSDT().getText().trim();
            if (home.getDateChoose().getDate() == null) {
                Ngay_Sinh = null;
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Ngay_Sinh = sdf.format(home.getDateChoose().getDate());
            }
        } catch (NumberFormatException numberFormatException) {
        }
        int GT = 0;
        if (home.getRdNam().isSelected()) {
            GT = 1;
        } else {
            GT = 0;
        }
        DocGia t = new DocGia(Ma_DG, GT, Ho_Ten, CCCD, SDT, Ngay_Sinh);
//        listSach.add(sach);
        int rs = DocGiaDAO.getInstant().Insert(t);
        System.out.println(rs);
        if (rs > 0) {
            JOptionPane.showMessageDialog(home, "Thêm thành công! [ID = " + Ma_DG + ", Name = " + Ho_Ten + "]");
            showDocGia.getInstance().showDocGia(home.getDocGTableModel());
        } else {
            JOptionPane.showMessageDialog(home, "Thêm thất bại, hãy kiểm tra lại!");
        }
    }
}
