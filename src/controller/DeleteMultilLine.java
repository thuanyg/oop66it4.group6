/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DocGiaDAO;
import dao.PhieuMuonDAO;
import dao.SachDAO;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import view.Home;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class DeleteMultilLine {
    
    private Home home;
    public static int optionPaneCount = 0;
    
    public DeleteMultilLine(Home home) {
        this.home = home;
    }
    
    public void ActionButtonDelete() {
        MouseListener mouse = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                if (optionPaneCount == 0) {
                    int c = JOptionPane.showConfirmDialog(home, "Bạn chắc chắn muốn xóa", "Delete", JOptionPane.YES_NO_OPTION);
                    if (c == 0) {
                        int[] arr = home.getTbl_Sach().getSelectedRows();
                        int n = arr.length;
                        int count = 0;
                        int idx = 0;
                        for (int i = arr[idx]; idx < n; idx = idx + 1) {
//                            i = i == 0 ? 0 : --i;
                            String maSach = home.getSachTableModel().getValueAt(arr[idx], 0).toString();
                            int rs = SachDAO.getInstant().Delete(Integer.parseInt(maSach));
                            count = rs > 0 ? count + 1 : count;
//                            System.out.println("VT = " + arr[idx]);
                        }
                        if (count > 1) {
                            JOptionPane.showMessageDialog(home, "Xóa thành công");
                            ShowBooks.getInstance().ShowOnTblSach(home.getSachTableModel());
                        }
                    }
                }
                optionPaneCount++;
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
        home.getBtn_deletemulti().addMouseListener(mouse);
    }
    
    public void ActionButtonDeleteDocGia() {
        MouseListener mouse = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                if (optionPaneCount == 0) {
                    int c = JOptionPane.showConfirmDialog(home, "Bạn chắc chắn muốn xóa", "Delete", JOptionPane.YES_NO_OPTION);
                    if (c == 0) {
                        int[] arr = home.getTbl_DocGia().getSelectedRows();
                        int n = arr.length;
                        int count = 0;
                        int idx = 0;
                        for (int i = arr[idx]; idx < n; idx = idx + 1) {
//                            i = i == 0 ? 0 : --i;
                            String maDG = home.getDocGTableModel().getValueAt(arr[idx], 0).toString();
                            int rs = DocGiaDAO.getInstant().Delete(Integer.parseInt(maDG));
                            count = rs > 0 ? count + 1 : count;
//                            System.out.println("VT = " + arr[idx]);
                        }
                        if (count > 1) {
                            JOptionPane.showMessageDialog(home, "Xóa thành công");
                            ShowDocGia.getInstance().showDocGia(home.getDocGTableModel());
                        }
                    }
                }
                optionPaneCount++;
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
        home.getBtn_deletemulti().addMouseListener(mouse);
    }
    
    public void ActionButtonDeletePM() {
        MouseListener mouse = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                if (optionPaneCount == 0) {
                    int c = JOptionPane.showConfirmDialog(home, "Bạn chắc chắn muốn xóa", "Delete", JOptionPane.YES_NO_OPTION);
                    if (c == 0) {
                        int[] arr = home.getTbl_PhieuMuon().getSelectedRows();
                        int n = arr.length;
                        int count = 0;
                        int idx = 0;
                        for (int i = arr[idx]; idx < n; idx = idx + 1) {
//                            i = i == 0 ? 0 : --i;
                            String maPM = home.getPhieuMuonTableModel().getValueAt(arr[idx], 0).toString();
                            int rs = PhieuMuonDAO.getInstant().Delete(Integer.parseInt(maPM));
                            count = rs > 0 ? count + 1 : count;
//                            System.out.println("VT = " + arr[idx]);
                        }
                        if (count > 1) {
                            JOptionPane.showMessageDialog(home, "Xóa thành công");
                            ShowPhieuMuon s = new ShowPhieuMuon();
                            s.ShowOnTablePM(home.getPhieuMuonTableModel());
                        }
                    }
                }
                optionPaneCount++;
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
        home.getBtn_deletemulti().addMouseListener(mouse);
    }
    
}
