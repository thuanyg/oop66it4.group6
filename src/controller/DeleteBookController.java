/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.SachDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Sach;
import view.Home;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class DeleteBookController {

    private Home home;

    public DeleteBookController(Home home) {
        this.home = home;
    }

    public void Delete() {
        int c = JOptionPane.showConfirmDialog(home, "Bạn chắc chắn muốn xóa sách? [ID = "
                + home.getTxtIdBook().getText().trim() + ", Name = "
                + home.getTxtBookName().getText().trim() + "]", "Delele confirm", JOptionPane.YES_NO_OPTION);
        // c = 0 -> yes, c = 1 -> no
        if (c == 0) {
            int id = Integer.parseInt(home.getTxtIdBook().getText());
            int rs = SachDAO.getInstant().Delete(id);
            //rs = 1 nếu xóa thành công
            if (rs == 1) {
                JOptionPane.showMessageDialog(home, "Xóa thành công! [ID = " + home.getTxtIdBook().getText().trim()
                        + ", Name = " + home.getTxtBookName().getText().trim() + "]");
                home.getTxtIdBook().setEditable(true);
            } else {
                JOptionPane.showMessageDialog(home, "Xảy ra lỗi khi xóa!!!");
            }
        }
    }
}
