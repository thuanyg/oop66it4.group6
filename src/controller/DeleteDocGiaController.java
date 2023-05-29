package controller;

import dao.DocGiaDAO;
import javax.swing.JOptionPane;
import view.Home;

/**
 *
 * @author dangqhung
 */
public class DeleteDocGiaController {

    private Home home;

    public DeleteDocGiaController(Home home) {

        this.home = home;
    }

    public int Delete() {
        int rs = 0;
        int c = JOptionPane.showConfirmDialog(home, "Bạn chắc chắn muốn xóa Độc Giả này ? [ID = "
                + home.getTxtIdDocGia().getText().trim() + ", Name = "
                + home.getTxtTenDocGia().getText().trim() + "]", "Delele confirm", JOptionPane.YES_NO_OPTION);
        if (c == 0) {
            int id = Integer.parseInt(home.getTxtIdDocGia().getText());
            rs = DocGiaDAO.getInstant().Delete(id);
            //rs = 1 nếu xóa thành công
            if (rs == 1) {
                JOptionPane.showMessageDialog(home, "Xóa thành công! [ID = " + home.getTxtIdDocGia().getText().trim()
                        + ", Name = " + home.getTxtTenDocGia().getText().trim() + "]");
            } else {
                JOptionPane.showMessageDialog(home, "Xảy ra lỗi khi xóa!!!");
            }
        }
        return rs;
    }

}
