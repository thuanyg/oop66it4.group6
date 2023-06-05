/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import view.Home;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class TopDocGiaController {
    private Home home;
    public static int optionPaneCount = 0;
    public TopDocGiaController(Home home) {
        this.home = home;
    }
    public void ActionButtonDocGia() {
        MouseListener mouse = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                home.setTitle("Readers - Library Management System");
                home.setVisibleFalse();
                home.getRightPanelDocGia().setVisible(true);
                home.resetFontColor();
                home.getLb_QuanLyDocGia().setForeground(Color.BLACK);
                if (home.getTbl_DocGia().getRowCount() == 0) {
                    ShowDocGia.getInstance().showDocGia(home.getDocGTableModel());
                }
                int rowSelected_TK = home.getTbl_topDocGia().getSelectedRow();
                String maDG = home.getTbl_topDocGia().getValueAt(rowSelected_TK, 0).toString();
                for (int i = 0; i < home.getDocGTableModel().getRowCount() && home.getDocGTableModel().getRowCount() != 0; i++) {
                    if (maDG.equals(home.getDocGTableModel().getValueAt(i, 0).toString())) {
                        home.getTbl_DocGia().setRowSelectionInterval(i, i);
                        break;
                    }
                }
                home.getMenu2_topDocGia().setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
        home.getBtn_thongtindocgia1().addMouseListener(mouse);
    }
    
    public void ActionButtonLienHe() {
        MouseListener mouse = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (home.getTbl_DocGia().getRowCount() == 0) {
                    ShowDocGia.getInstance().showDocGia(home.getDocGTableModel());
                }
                int rowSelected_TK = home.getTbl_topDocGia().getSelectedRow();
                String maDG = home.getTbl_topDocGia().getValueAt(rowSelected_TK, 0).toString();
                for (int i = 0; i < home.getDocGTableModel().getRowCount() && home.getDocGTableModel().getRowCount() != 0; i++) {
                    if (maDG.equals(home.getDocGTableModel().getValueAt(i, 0).toString())) {
                        String sdt = home.getDocGTableModel().getValueAt(i, 5).toString();
                        if (!sdt.equals("")) {
                            StringSelection stringSelection = new StringSelection(sdt);
                            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                            clipboard.setContents(stringSelection, null);
                            if (optionPaneCount == 0) {
                                JOptionPane.showMessageDialog(home, "Đã lưu SĐT vào clipboard!");
                                optionPaneCount++;
                            }
                        } else {
                            if (optionPaneCount == 0) {
                                JOptionPane.showMessageDialog(home, "SĐT độc giả này không hiện không có trên hệ thống!");
                                optionPaneCount++;
                            }
                        }

                        break;
                    }
                }
                home.getMenu().setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        };
        home.getBtn_sdtTopDG().addMouseListener(mouse);
    }
    

}
