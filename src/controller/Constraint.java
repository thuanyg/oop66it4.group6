/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DocGiaDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.DocGia;
import view.Home;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class Constraint {

    private Home home;

    public Constraint(Home home) {
        this.home = home;
    }

    // Validation for jtextfield - Sach
    public boolean SachValidate() {
        boolean flag = true;
        String maSach = home.getTxtIdBook().getText().trim();
        String tenSach = home.getTxtBookName().getText().trim();
        String tacGia = home.getTxtAuthor().getText().trim();
        String theLoai = home.getTxtTypeOfBook().getText().trim();
        String nhaXB = home.getTxtPublisher().getText().trim();
        String namXb = home.getTxtPublishYear().getText().trim();
        int soLuong = (int) home.getSpiner_bookQuantity().getValue();
        String gia = home.getTxtPrice().getText().trim();
        // lấy năm hiện tại
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy");
        String cur_year = simpleDateFormat.format(date);
        if (maSach.isBlank() && tenSach.isEmpty() && tacGia.isEmpty()
                && theLoai.isEmpty() && nhaXB.isEmpty() && namXb.isEmpty() && gia.isEmpty()) {
            JOptionPane.showMessageDialog(home, "Hãy nhập thông tin sách!");
            flag = false;
        } else if (maSach.isEmpty()) {
            JOptionPane.showMessageDialog(home, "Mã sách không được để trống!");
            flag = false;
        } else if (!maSach.matches("\\d+")) {
            JOptionPane.showMessageDialog(home, "Mã sách định dạng là kiểu số!");
            flag = false;
        } else if (tenSach.isEmpty()) {
            JOptionPane.showMessageDialog(home, "Tên sách không được để trống!");
            flag = false;
        } else if (soLuong == 0) {
            JOptionPane.showMessageDialog(home, "Hãy nhập số lượng sách");
            flag = false;
        } else if (!namXb.matches("\\d+") && !namXb.isEmpty()) {
            JOptionPane.showMessageDialog(home, "Năm xuất bản là định dạng số");
            flag = false;
        } else if (!namXb.isEmpty()) {
            if (Integer.parseInt(namXb) > Integer.parseInt(cur_year) || Integer.parseInt(namXb) < 1000) {
                JOptionPane.showMessageDialog(home, "Năm xuất bản không hợp lệ!");
                flag = false;
            }
        }
        if (flag && !gia.isEmpty() && !gia.matches("[\\d\\.]+")) {
            JOptionPane.showMessageDialog(home, "Giá sách không hợp lệ!");
            flag = false;
        }
        return flag;
    }

    public boolean DocGiaValidate() {
        boolean flag = true;
        boolean flag_id = true;
        boolean flag_cccd = true;
        String Ma_DG = home.getTxtIdDocGia().getText().trim();
        List<DocGia> list = DocGiaDAO.getInstant().selectAll();
        String Ho_Ten = home.getTxtTenDocGia().getText().trim();
        String CCCD = home.getTxtCCCD().getText().trim();
        String SDT = home.getTxtSDT().getText().trim();

        Date date = new Date();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String Ngay_Sinh = sdf.format(home.getDateChoose().getDate());
        } catch (Exception e) {
        }
        if (Ma_DG.isEmpty() && Ho_Ten.isEmpty() && CCCD.isEmpty() && SDT.isEmpty()) {
            JOptionPane.showMessageDialog(home, "Hãy nhập thông tin độc giả để thêm!");
            flag = false;
        } else if (!Ma_DG.matches("\\d+")) {
            JOptionPane.showMessageDialog(home, "ID có định dạng là số!");
            flag = false;
        } else if (Ho_Ten.isEmpty()) {
            JOptionPane.showMessageDialog(home, "Hãy nhập họ tên Độc giả!");
            flag = false;
        } else if (home.getButtonGroupGender().getSelection() == null) {
            JOptionPane.showMessageDialog(home, "Hãy chọn giới tính!");
            flag = false;
        } else if (date.compareTo(home.getDateChoose().getDate()) < 0) {
            JOptionPane.showMessageDialog(home, "Ngày sinh không hợp lệ!");
            flag = false;
        } else if (CCCD.isEmpty()) {
            JOptionPane.showMessageDialog(home, "Hãy nhập CCCD!");
            flag = false;
        } else if (!CCCD.matches("\\d+")) {
            JOptionPane.showMessageDialog(home, "CCCD có định dạng là số!");
            flag = false;
        } else if (!SDT.matches("\\d+") && !SDT.isEmpty()) {
            JOptionPane.showMessageDialog(home, "SDT có định dạng kiểu số!");
            flag = false;
        }
        return flag;
    }

    // Check trùng id và cccd khi insert
    public boolean DocGiaCheckForDuplicates() {
        boolean flag_id = true;
        boolean flag_cccd = true;
        String Ma_DG = home.getTxtIdDocGia().getText().trim();
        String CCCD = home.getTxtCCCD().getText().trim();
        List<DocGia> list = DocGiaDAO.getInstant().selectAll();
        for (int i = 0; i < list.size() && list.size() != 0; i++) {
            if (list.get(i).getMDG() == Integer.parseInt(Ma_DG)) {
                flag_id = false;
                JOptionPane.showMessageDialog(home, "ID đã tồn tại!");
                break;
            }
        }
        if (flag_id == true) {
            for (int i = 0; i < list.size() && list.size() != 0; i++) {
                if (list.get(i).getCCCD().equals(CCCD)) {
                    flag_cccd = false;
                    JOptionPane.showMessageDialog(home, "CCCD đã tồn tại!");
                    break;
                }
            }
        }
        return flag_id && flag_cccd;
    }

    public boolean DocGiaCheckForDuplicatesUpdate() {
        boolean flag_cccd = true;
        String CCCD = home.getTxtCCCD().getText().trim();
        List<DocGia> list = DocGiaDAO.getInstant().selectAllWithoutID(Integer.parseInt(home.getTxtIdDocGia().getText().trim()));
        for (int i = 0; i < list.size() && list.size() != 0; i++) {
            if (list.get(i).getCCCD().equals(CCCD)) {
                flag_cccd = false;
                JOptionPane.showMessageDialog(home, "CCCD đã tồn tại!");
                break;
            }
        }

        return flag_cccd;
    }

    // Check input PhieuMuon
    public boolean PhieuMuonValidate() {
        boolean flag = true;
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String MaPM = home.getTxtMaPhieuMuon().getText().trim();
        String MaDG = home.getTxtIdBook2().getText().trim();
        Date cur = new Date();
        Date ngayMuon = null;
        Date ngayHenTra = null;
        Date ngayTra = null;
        try {
            ngayMuon = home.getDateChooseNgayMuon().getDate();
            ngayHenTra = home.getDateChooseNgayHenTra().getDate();
            ngayTra = home.getDateChooseNgayTra().getDate();
        } catch (Exception e) {
        }
        if (ngayMuon == null) {
            cur.setHours(0);
            cur.setMinutes(0);
            cur.setSeconds(0);
            home.getDateChooseNgayMuon().setDate(cur);
            ngayMuon = home.getDateChooseNgayMuon().getDate();
        }
        System.out.println("Ngay muon: " + ngayMuon);
        if (MaPM.isEmpty()) {
            JOptionPane.showMessageDialog(home, "Chưa nhập mã Phiếu Mượn!");
            flag = false;
        } else if (MaDG.isEmpty() || home.getCbx_DocGia().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(home, "Chưa chọn Độc Giả!");
            flag = false;
        } else if (home.getListSachMuon().isEmpty()) {
            JOptionPane.showMessageDialog(home, "Chưa chọn Sách!");
            flag = false;
        } else if (ngayHenTra == null) {
            JOptionPane.showMessageDialog(home, "Chưa chọn ngày hẹn trả");
            flag = false;
        } else if (ngayHenTra != null && ngayHenTra.compareTo(ngayMuon) < 0) {
            JOptionPane.showMessageDialog(home, "Ngày hẹn trả không hợp lệ");
            flag = false;
        } else if (ngayTra != null && ngayTra.compareTo(ngayMuon) < 0) {
            JOptionPane.showMessageDialog(home, "Ngày trả không hợp lệ");
            flag = false;
        }

        return flag;
    }
}
