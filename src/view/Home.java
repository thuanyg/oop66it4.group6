/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import analysService.BarChart;
import controller.ShowBooks;
import global.Username;
import dao.SachDAO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Sach;
import com.toedter.calendar.JDateChooser;
import analysService.AnalysisController;
import analysService.BarChartForSach;
import controller.Constraint;
import controller.DeleteBookController;
import controller.DeleteDocGiaController;
import controller.DeleteMultilLine;
import controller.DeletePhieuMuon;
import controller.InsertBookController;
import controller.InsertDocGiaController;
import controller.InsertPhieu_Muon;
import controller.PhieuMuonQuaHanController;
import controller.SearchDocGiaController;
import controller.SearchPhieuMuonController;
import controller.ShowPhieuMuon;
import controller.UpdateBookController;
import controller.UpdateDocGiaController;
import controller.ShowDocGia;
import controller.SortBookController;
import controller.SortDocGiaController;
import controller.SortPhieuMuonController;
import controller.TopDocGiaController;
import controller.UpdatePhieuMuonController;
import dao.DocGiaDAO;
import database.JDBCUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import model.DocGia;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class Home extends javax.swing.JFrame {

    DefaultTableModel SachTableModel, SachMuonTableModel, SachMuonTempTableModel,
            SachMuonMoiThemTableModel, DocGTableModel, PhieuMuonTableModel,
            PhieuMuonQHTableModel, TopDocGiaTableModel;
    List<String> listSachMuon = new ArrayList<>();
    List<String> listSachMuonMoiThem = new ArrayList<>();
    List<Integer> listSoLuongMuon = new ArrayList<>();
    List<Integer> listSoLuongMuonMoiThem = new ArrayList<>();
    private int indexSelectRow;

    public Home() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
        initComponents();
        SachTableModel = (DefaultTableModel) tbl_Sach.getModel();
        SachMuonTableModel = (DefaultTableModel) tbl_sachMuon.getModel();
        DocGTableModel = (DefaultTableModel) tbl_DocGia.getModel();
        PhieuMuonTableModel = (DefaultTableModel) tbl_PhieuMuon.getModel();
        SachMuonTempTableModel = (DefaultTableModel) tbl_sachMuonTemp.getModel();
        SachMuonMoiThemTableModel = (DefaultTableModel) tbl_sachMuonMoiThem.getModel();
        PhieuMuonQHTableModel = (DefaultTableModel) tbl_PhieuMuonQH.getModel();
        TopDocGiaTableModel = (DefaultTableModel) tbl_topDocGia.getModel();
        // Add placeholder
        AddPlaceHolderStyle(txtSearchBook);
        AddPlaceHolderStyle(txtSearchDocGia);
        // Add style for table
        AddTableStyle(tbl_Sach);
        AddTableStyle(tbl_DocGia);
        AddTableStyle(tbl_PhieuMuon);
        AddTableStyle(tbl_PhieuMuonQH);
        AddTableStyle(tbl_PhieuMuonQH);
        AddTableStyle(tbl_topDocGia);
        SetTableHeaderStyle();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/logo.png")));
        setVisibleFalse();
        Home.setVisible(true);

    }

    public void SetStatusButton(JButton btn) {
        if (tbl_Sach.getSelectedRow() != -1) {
            btn.setEnabled(true);
        } else {
            btn.setEnabled(false);
        }
    }

    public void AddTableStyle(JTable table) {
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(Color.decode("#159957"));
        table.getTableHeader().setForeground(new Color(255, 255, 255));
        table.setRowHeight(25);
    }

    public void SetTableHeaderStyle() {
        ((DefaultTableCellRenderer) tbl_sachMuon.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
//        ((DefaultTableCellRenderer) tbl_Sach.getTableHeader().getDefaultRenderer())
//                .setHorizontalAlignment(JLabel.CENTER);
//        ((DefaultTableCellRenderer) tbl_DocGia.getTableHeader().getDefaultRenderer())
//                .setHorizontalAlignment(JLabel.CENTER);
//        ((DefaultTableCellRenderer) tbl_PhieuMuon.getTableHeader().getDefaultRenderer())
//                .setHorizontalAlignment(JLabel.CENTER);
    }

    public void AddPlaceHolderStyle(JTextField jtf) {
        Font font = jtf.getFont();
        font = font.deriveFont(Font.ITALIC);
        jtf.setFont(font);
        jtf.setForeground(Color.GRAY);
    }

    public int TongSachMuon() {
        int sum = 0;
        try {
            for (int i = 0; i < tbl_sachMuon.getModel().getRowCount(); i++) {
                int temp = (int) tbl_sachMuon.getModel().getValueAt(i, 1); //get the all row values at column index 1
                sum += temp;
            }

        } catch (Exception e) {
            System.out.println("Tràn");
        }
        return sum;
    }

    public void RemovePlaceHolderStyle(JTextField jtf) {
        Font font = jtf.getFont();
        font = font.deriveFont(Font.PLAIN);
        jtf.setFont(font);
        jtf.setForeground(Color.BLACK);
    }

    public void UpdateBookOnCombobox() {
//        List<Sach> listSach = SachDAO.getInstant().selectAll();
//        String lastItem = "" + String.valueOf(listSach.get(listSach.size() - 1).getId()) + " | "
//                + listSach.get(listSach.size() - 1).getTenSach();
//        if (!cbx_Books.getItemAt(cbx_Books.getItemCount() - 1).toString().equals(lastItem)) {
//            cbx_Books.addItem(lastItem);
//        }
        cbx_Books.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbx_Books.setMaximumRowCount(26);

        cbx_Books.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"None"}));

        cbx_Books.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cbx_Books.setKeySelectionManager(null);
        ShowBookOnCombobox();
    }

    public void UpdateDocGiaOnCombobox() {
        cbx_DocGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbx_DocGia.setMaximumRowCount(26);

        cbx_DocGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"None"}));

        cbx_DocGia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cbx_DocGia.setKeySelectionManager(null);

        ShowDocGiaOnCombobox();
    }

    public void ShowBookOnCombobox() {
        List<Sach> listSach = SachDAO.getInstant().selectAll();
        listSach.forEach((sach) -> {
            cbx_Books.addItem("" + String.valueOf(sach.getId()) + " | " + sach.getTenSach());
        });
    }

    public void ShowDocGiaOnCombobox() {

        List<DocGia> listDocGia = DocGiaDAO.getInstant().selectAll();
        listDocGia.forEach((d) -> {
            cbx_DocGia.addItem("" + String.valueOf(d.getMDG()) + " | " + d.getHo_Ten());
        });
    }

    public void resetFontColor() {
        lb_QuanLySach.setForeground(Color.WHITE);
        lb_QuanLyDocGia.setForeground(Color.WHITE);
        lb_PhieuMuon.setForeground(Color.WHITE);
        lb_ThongKeBaoCao.setForeground(Color.WHITE);
        lb_info.setForeground(Color.WHITE);
    }

    public void setVisibleFalse() {
        Home.setVisible(false);
        rightPanelDocGia.setVisible(false);
        rightPanelSach.setVisible(false);
        rightPanelPhieuMuon.setVisible(false);
        rightPanelThongke.setVisible(false);
        rightPanelInfo.setVisible(false);
        about_us.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupGender = new javax.swing.ButtonGroup();
        barChart = new javax.swing.JFrame();
        DeleteSachMuon = new javax.swing.JPanel();
        btn_deleteSachMuon = new javax.swing.JButton();
        DeleteMulti = new javax.swing.JPanel();
        btn_deletemulti = new javax.swing.JButton();
        TopDocGiaControl = new javax.swing.JPanel();
        btn_thongtindocgia1 = new javax.swing.JButton();
        btn_sdtTopDG = new javax.swing.JButton();
        PhieuPhatControl = new javax.swing.JPanel();
        btn_thongtindocgia = new javax.swing.JButton();
        btn_thontinsachmuon = new javax.swing.JButton();
        btn_sdt = new javax.swing.JButton();
        btn_tienPhat = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl_sachMuonTemp = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_sachMuonMoiThem = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        menu = new javax.swing.JPopupMenu();
        menu2_topDocGia = new javax.swing.JPopupMenu();
        menu3_delete = new javax.swing.JPopupMenu();
        menu4_delSachMuon = new javax.swing.JPopupMenu();
        panelForChart = new javax.swing.JPanel();
        rightPanelThongke = new javax.swing.JPanel();
        DashbroadOnTop = new javax.swing.JPanel();
        btn_moreInfoBook = new javax.swing.JLabel();
        btn_moreInfoPM = new javax.swing.JLabel();
        btn_moreInfoDocGia = new javax.swing.JLabel();
        lb_tongSachCon = new javax.swing.JLabel();
        lb_product = new javax.swing.JLabel();
        lb_tongNguoiMuon = new javax.swing.JLabel();
        lb_tongSachDuocMuon = new javax.swing.JLabel();
        img_dashbroard = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanelForBarChart = new javax.swing.JPanel();
        panelPMQuaHan = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_PhieuMuonQH = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbl_topDocGia = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        rightPanelSach = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Sach = new javax.swing.JTable();
        lb_IdBook = new javax.swing.JLabel();
        txtBookName = new javax.swing.JTextField();
        lb_bookName = new javax.swing.JLabel();
        txtIdBook = new javax.swing.JTextField();
        lb_author = new javax.swing.JLabel();
        txtAuthor = new javax.swing.JTextField();
        lb_publisher = new javax.swing.JLabel();
        txtPublisher = new javax.swing.JTextField();
        lb_publishYear = new javax.swing.JLabel();
        txtPublishYear = new javax.swing.JTextField();
        lb_bookQuantity = new javax.swing.JLabel();
        lb_typeOfBook = new javax.swing.JLabel();
        txtTypeOfBook = new javax.swing.JTextField();
        lb_price = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        spiner_bookQuantity = new javax.swing.JSpinner();
        SearchBook = new javax.swing.JPanel();
        txtSearchBook = new javax.swing.JTextField();
        pnl = new javax.swing.JPanel();
        btn_insertBook = new javax.swing.JButton();
        btm_editBook = new javax.swing.JButton();
        btn_reseBook = new javax.swing.JButton();
        lb_SortBy = new javax.swing.JLabel();
        cbxSortBook = new javax.swing.JComboBox<>();
        btn_deleteBook = new javax.swing.JButton();
        rightPanelPhieuMuon = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_PhieuMuon = new javax.swing.JTable();
        cbx_DocGia = new javax.swing.JComboBox<>();
        cbx_Books = new javax.swing.JComboBox<>();
        lb_chooseBook = new javax.swing.JLabel();
        lb_search = new javax.swing.JLabel();
        lb_IdBook1 = new javax.swing.JLabel();
        lb_IdBook4 = new javax.swing.JLabel();
        txtMaPhieuMuon = new javax.swing.JTextField();
        lb_IdBook2 = new javax.swing.JLabel();
        txtIdBook2 = new javax.swing.JTextField();
        btn_insertBook2 = new javax.swing.JButton();
        btm_editPM = new javax.swing.JButton();
        btn_delBook2 = new javax.swing.JButton();
        lb_IdBook5 = new javax.swing.JLabel();
        btn_resetPM = new javax.swing.JButton();
        panel_sachMuon = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        lablelTongSach = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_sachMuon = new javax.swing.JTable();
        btn_clear = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        lb_IdBook6 = new javax.swing.JLabel();
        dateChooseNgayTra = new com.toedter.calendar.JDateChooser();
        dateChooseNgayMuon = new com.toedter.calendar.JDateChooser();
        dateChooseNgayHenTra = new com.toedter.calendar.JDateChooser();
        lb_SortBy2 = new javax.swing.JLabel();
        cbxSortPhieuMuon = new javax.swing.JComboBox<>();
        txtSearchPhieuMuon = new javax.swing.JTextField();
        leftPanel = new javax.swing.JPanel();
        HeadingHome = new javax.swing.JLabel();
        logOutIcon = new javax.swing.JLabel();
        copyright = new javax.swing.JLabel();
        lb_footer = new javax.swing.JLabel();
        pnl_QuanLySach = new javax.swing.JPanel();
        lb_QuanLySach = new javax.swing.JLabel();
        pnl_QuanLyDocGia = new javax.swing.JPanel();
        lb_QuanLyDocGia = new javax.swing.JLabel();
        pnl_PhieuMuon = new javax.swing.JPanel();
        lb_PhieuMuon = new javax.swing.JLabel();
        pnl_Thongkebaocao = new javax.swing.JPanel();
        lb_ThongKeBaoCao = new javax.swing.JLabel();
        pnl_ThongTin = new javax.swing.JPanel();
        lb_info = new javax.swing.JLabel();
        bground = new javax.swing.JLabel();
        Home = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        lb_HelloUser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rightPanelDocGia = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_DocGia = new javax.swing.JTable();
        btm_editDocGia = new javax.swing.JButton();
        lb_IdDocGia = new javax.swing.JLabel();
        txtTenDocGia = new javax.swing.JTextField();
        lb_TenDocGia = new javax.swing.JLabel();
        txtIdDocGia = new javax.swing.JTextField();
        lb_gender = new javax.swing.JLabel();
        lb_ngaySinh = new javax.swing.JLabel();
        lb_cccd = new javax.swing.JLabel();
        txtCCCD = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        lb_bookQuantity1 = new javax.swing.JLabel();
        btn_xoaDocGia = new javax.swing.JButton();
        btn_insertDocGia = new javax.swing.JButton();
        lb_SortBy1 = new javax.swing.JLabel();
        cbxSortDocGia = new javax.swing.JComboBox<>();
        SearchDocGia = new javax.swing.JPanel();
        txtSearchDocGia = new javax.swing.JTextField();
        btn_resetDocGia = new javax.swing.JButton();
        rdNu = new javax.swing.JRadioButton();
        rdNam = new javax.swing.JRadioButton();
        dateChoose = new com.toedter.calendar.JDateChooser();
        rightPanelInfo = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        lb_HelloUser1 = new javax.swing.JLabel();
        btn_github = new javax.swing.JLabel();
        btn_contact = new javax.swing.JLabel();
        btn_requestDemo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        about_us = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        avt_Vanh = new javax.swing.JLabel();
        avt_Hung = new javax.swing.JLabel();
        btn_hung = new javax.swing.JLabel();
        btn_vanh = new javax.swing.JLabel();
        btn_manh = new javax.swing.JLabel();
        btn_nam = new javax.swing.JLabel();
        btn_hieu = new javax.swing.JLabel();
        btn_thuan = new javax.swing.JLabel();
        avt_Thuan = new javax.swing.JLabel();
        avt_Hieu = new javax.swing.JLabel();
        avt_Nam = new javax.swing.JLabel();
        avt_Manh = new javax.swing.JLabel();
        lb_HelloUser3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        meber = new javax.swing.JLabel();

        barChart.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        barChart.setUndecorated(true);

        javax.swing.GroupLayout barChartLayout = new javax.swing.GroupLayout(barChart.getContentPane());
        barChart.getContentPane().setLayout(barChartLayout);
        barChartLayout.setHorizontalGroup(
            barChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 651, Short.MAX_VALUE)
        );
        barChartLayout.setVerticalGroup(
            barChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );

        DeleteSachMuon.setBackground(new java.awt.Color(153, 255, 153));

        btn_deleteSachMuon.setBackground(new java.awt.Color(204, 255, 153));
        btn_deleteSachMuon.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        btn_deleteSachMuon.setText("Delete");
        btn_deleteSachMuon.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 51)));
        btn_deleteSachMuon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout DeleteSachMuonLayout = new javax.swing.GroupLayout(DeleteSachMuon);
        DeleteSachMuon.setLayout(DeleteSachMuonLayout);
        DeleteSachMuonLayout.setHorizontalGroup(
            DeleteSachMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteSachMuonLayout.createSequentialGroup()
                .addComponent(btn_deleteSachMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        DeleteSachMuonLayout.setVerticalGroup(
            DeleteSachMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_deleteSachMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        DeleteMulti.setBackground(new java.awt.Color(153, 255, 153));

        btn_deletemulti.setBackground(new java.awt.Color(204, 255, 153));
        btn_deletemulti.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        btn_deletemulti.setText("Delete");
        btn_deletemulti.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 51)));
        btn_deletemulti.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout DeleteMultiLayout = new javax.swing.GroupLayout(DeleteMulti);
        DeleteMulti.setLayout(DeleteMultiLayout);
        DeleteMultiLayout.setHorizontalGroup(
            DeleteMultiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteMultiLayout.createSequentialGroup()
                .addComponent(btn_deletemulti, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        DeleteMultiLayout.setVerticalGroup(
            DeleteMultiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_deletemulti, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        TopDocGiaControl.setBackground(new java.awt.Color(153, 255, 153));

        btn_thongtindocgia1.setBackground(new java.awt.Color(204, 255, 153));
        btn_thongtindocgia1.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        btn_thongtindocgia1.setText("Thông tin độc giả");
        btn_thongtindocgia1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 51)));
        btn_thongtindocgia1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn_sdtTopDG.setBackground(new java.awt.Color(204, 255, 153));
        btn_sdtTopDG.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        btn_sdtTopDG.setText("Liên hệ");
        btn_sdtTopDG.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 51)));
        btn_sdtTopDG.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_sdtTopDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sdtTopDGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TopDocGiaControlLayout = new javax.swing.GroupLayout(TopDocGiaControl);
        TopDocGiaControl.setLayout(TopDocGiaControlLayout);
        TopDocGiaControlLayout.setHorizontalGroup(
            TopDocGiaControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_thongtindocgia1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(btn_sdtTopDG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        TopDocGiaControlLayout.setVerticalGroup(
            TopDocGiaControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopDocGiaControlLayout.createSequentialGroup()
                .addComponent(btn_thongtindocgia1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btn_sdtTopDG, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PhieuPhatControl.setBackground(new java.awt.Color(242, 247, 251));

        btn_thongtindocgia.setBackground(new java.awt.Color(204, 204, 255));
        btn_thongtindocgia.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        btn_thongtindocgia.setText("Thông tin độc giả");
        btn_thongtindocgia.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 51)));
        btn_thongtindocgia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_thongtindocgia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btn_thongtindocgiaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btn_thongtindocgiaFocusLost(evt);
            }
        });

        btn_thontinsachmuon.setBackground(new java.awt.Color(204, 204, 255));
        btn_thontinsachmuon.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        btn_thontinsachmuon.setText("Thông tin sách mượn");
        btn_thontinsachmuon.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 51)));
        btn_thontinsachmuon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn_sdt.setBackground(new java.awt.Color(204, 204, 255));
        btn_sdt.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        btn_sdt.setText("Liên hệ");
        btn_sdt.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 51)));
        btn_sdt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_sdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sdtActionPerformed(evt);
            }
        });

        btn_tienPhat.setBackground(new java.awt.Color(204, 204, 255));
        btn_tienPhat.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        btn_tienPhat.setText("Số tiền phạt");
        btn_tienPhat.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 51)));
        btn_tienPhat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_tienPhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tienPhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PhieuPhatControlLayout = new javax.swing.GroupLayout(PhieuPhatControl);
        PhieuPhatControl.setLayout(PhieuPhatControlLayout);
        PhieuPhatControlLayout.setHorizontalGroup(
            PhieuPhatControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_thontinsachmuon, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
            .addComponent(btn_thongtindocgia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_tienPhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_sdt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PhieuPhatControlLayout.setVerticalGroup(
            PhieuPhatControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PhieuPhatControlLayout.createSequentialGroup()
                .addComponent(btn_thongtindocgia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_thontinsachmuon, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_tienPhat, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tbl_sachMuonTemp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_sachMuonTemp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã - Tên Sách", "SL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_sachMuonTemp.setGridColor(new java.awt.Color(204, 204, 204));
        tbl_sachMuonTemp.setPreferredSize(new java.awt.Dimension(500, 300));
        tbl_sachMuonTemp.setSelectionBackground(new java.awt.Color(0, 204, 102));
        tbl_sachMuonTemp.setShowGrid(false);
        tbl_sachMuonTemp.setShowHorizontalLines(true);
        tbl_sachMuonTemp.setShowVerticalLines(true);
        tbl_sachMuonTemp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sachMuonTempMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbl_sachMuonTemp);
        if (tbl_sachMuonTemp.getColumnModel().getColumnCount() > 0) {
            tbl_sachMuonTemp.getColumnModel().getColumn(0).setPreferredWidth(455);
        }
        tbl_sachMuonTemp.setVisible(false);

        tbl_sachMuonMoiThem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_sachMuonMoiThem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã - Tên Sách", "SL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_sachMuonMoiThem.setGridColor(new java.awt.Color(204, 204, 204));
        tbl_sachMuonMoiThem.setPreferredSize(new java.awt.Dimension(500, 300));
        tbl_sachMuonMoiThem.setSelectionBackground(new java.awt.Color(0, 204, 102));
        tbl_sachMuonMoiThem.setShowGrid(false);
        tbl_sachMuonMoiThem.setShowHorizontalLines(true);
        tbl_sachMuonMoiThem.setShowVerticalLines(true);
        tbl_sachMuonMoiThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sachMuonMoiThemMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_sachMuonMoiThem);
        if (tbl_sachMuonMoiThem.getColumnModel().getColumnCount() > 0) {
            tbl_sachMuonMoiThem.getColumnModel().getColumn(0).setPreferredWidth(455);
        }

        jButton1.setText("Export");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        menu.add(PhieuPhatControl);

        menu2_topDocGia.add(TopDocGiaControl);

        menu3_delete.add(DeleteMulti);

        menu4_delSachMuon.add(DeleteSachMuon);

        panelForChart.setPreferredSize(new java.awt.Dimension(1169, 759));

        javax.swing.GroupLayout panelForChartLayout = new javax.swing.GroupLayout(panelForChart);
        panelForChart.setLayout(panelForChartLayout);
        panelForChartLayout.setHorizontalGroup(
            panelForChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1169, Short.MAX_VALUE)
        );
        panelForChartLayout.setVerticalGroup(
            panelForChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 814, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home - Library Management System");
        setBackground(new java.awt.Color(203, 228, 222));
        setResizable(false);
        addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                formAncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });

        rightPanelThongke.setBackground(new java.awt.Color(242, 247, 251));
        rightPanelThongke.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                rightPanelThongkeAncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });

        DashbroadOnTop.setBackground(new java.awt.Color(242, 247, 251));
        DashbroadOnTop.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_moreInfoBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_moreInfoBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_moreInfoBookMouseClicked(evt);
            }
        });
        DashbroadOnTop.add(btn_moreInfoBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 120, 20));

        btn_moreInfoPM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_moreInfoPM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_moreInfoPMMouseClicked(evt);
            }
        });
        DashbroadOnTop.add(btn_moreInfoPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 110, 20));

        btn_moreInfoDocGia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_moreInfoDocGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_moreInfoDocGiaMouseClicked(evt);
            }
        });
        DashbroadOnTop.add(btn_moreInfoDocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, 110, 20));

        lb_tongSachCon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lb_tongSachCon.setForeground(new java.awt.Color(255, 255, 255));
        lb_tongSachCon.setText("100");
        DashbroadOnTop.add(lb_tongSachCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 200, 120));

        lb_product.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lb_product.setForeground(new java.awt.Color(255, 255, 255));
        lb_product.setText("Nothing");
        DashbroadOnTop.add(lb_product, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 120, 200, 120));

        lb_tongNguoiMuon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lb_tongNguoiMuon.setForeground(new java.awt.Color(255, 255, 255));
        lb_tongNguoiMuon.setText("100");
        DashbroadOnTop.add(lb_tongNguoiMuon, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 200, 120));

        lb_tongSachDuocMuon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lb_tongSachDuocMuon.setForeground(new java.awt.Color(255, 255, 255));
        lb_tongSachDuocMuon.setText("100");
        DashbroadOnTop.add(lb_tongSachDuocMuon, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 200, 120));

        img_dashbroard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Dashbroard.png"))); // NOI18N
        DashbroadOnTop.add(img_dashbroard, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 1022, 278));

        jPanelForBarChart.setBackground(new java.awt.Color(242, 247, 251));
        jPanelForBarChart.setEnabled(false);
        jPanelForBarChart.setPreferredSize(new java.awt.Dimension(850, 450));
        jPanelForBarChart.setVerifyInputWhenFocusTarget(false);

        panelPMQuaHan.setBackground(new java.awt.Color(51, 255, 153));

        tbl_PhieuMuonQH.setBackground(new java.awt.Color(242, 247, 251));
        tbl_PhieuMuonQH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_PhieuMuonQH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã PM", "Mã ĐG", "Ngày Mượn", "Ngày Hẹn", "Ngày Trả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_PhieuMuonQH.setRowHeight(30);
        tbl_PhieuMuonQH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_PhieuMuonQHMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_PhieuMuonQH);
        if (tbl_PhieuMuonQH.getColumnModel().getColumnCount() > 0) {
            tbl_PhieuMuonQH.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbl_PhieuMuonQH.getColumnModel().getColumn(0).setMaxWidth(110);
            tbl_PhieuMuonQH.getColumnModel().getColumn(1).setPreferredWidth(70);
            tbl_PhieuMuonQH.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("DANH SÁCH PHIẾU MƯỢN QUÁ HẠN");

        javax.swing.GroupLayout panelPMQuaHanLayout = new javax.swing.GroupLayout(panelPMQuaHan);
        panelPMQuaHan.setLayout(panelPMQuaHanLayout);
        panelPMQuaHanLayout.setHorizontalGroup(
            panelPMQuaHanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelPMQuaHanLayout.setVerticalGroup(
            panelPMQuaHanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPMQuaHanLayout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        tbl_topDocGia.setBackground(new java.awt.Color(242, 247, 251));
        tbl_topDocGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_topDocGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã ĐG", "Họ và tên", "Tổng số sách mượn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_topDocGia.setRowHeight(30);
        tbl_topDocGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_topDocGiaMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tbl_topDocGia);
        if (tbl_topDocGia.getColumnModel().getColumnCount() > 0) {
            tbl_topDocGia.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbl_topDocGia.getColumnModel().getColumn(0).setMaxWidth(100);
            tbl_topDocGia.getColumnModel().getColumn(2).setPreferredWidth(120);
            tbl_topDocGia.getColumnModel().getColumn(2).setMaxWidth(200);
        }

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("TOP ĐỘC GIẢ ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanelForBarChartLayout = new javax.swing.GroupLayout(jPanelForBarChart);
        jPanelForBarChart.setLayout(jPanelForBarChartLayout);
        jPanelForBarChartLayout.setHorizontalGroup(
            jPanelForBarChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelForBarChartLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(panelPMQuaHan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelForBarChartLayout.setVerticalGroup(
            jPanelForBarChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelPMQuaHan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout rightPanelThongkeLayout = new javax.swing.GroupLayout(rightPanelThongke);
        rightPanelThongke.setLayout(rightPanelThongkeLayout);
        rightPanelThongkeLayout.setHorizontalGroup(
            rightPanelThongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelThongkeLayout.createSequentialGroup()
                .addGroup(rightPanelThongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DashbroadOnTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rightPanelThongkeLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jPanelForBarChart, javax.swing.GroupLayout.PREFERRED_SIZE, 935, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addComponent(jLabel7)))
                .addContainerGap())
        );
        rightPanelThongkeLayout.setVerticalGroup(
            rightPanelThongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelThongkeLayout.createSequentialGroup()
                .addComponent(DashbroadOnTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(rightPanelThongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightPanelThongkeLayout.createSequentialGroup()
                        .addGap(452, 452, 452)
                        .addComponent(jLabel7))
                    .addGroup(rightPanelThongkeLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanelForBarChart, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        rightPanelSach.setBackground(new java.awt.Color(242, 247, 251));
        rightPanelSach.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(203, 228, 222));

        tbl_Sach.setBackground(new java.awt.Color(203, 228, 222));
        tbl_Sach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_Sach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách", "Thể loại", "Tác giả", "Năm xuất bản", "Nhà xuất bản", "Số lượng", "Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Sach.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbl_Sach.setFocusable(false);
        tbl_Sach.setGridColor(new java.awt.Color(204, 204, 204));
        tbl_Sach.setRowHeight(23);
        tbl_Sach.setSelectionBackground(new java.awt.Color(0, 204, 102));
        tbl_Sach.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tbl_Sach.setShowGrid(false);
        tbl_Sach.setShowHorizontalLines(true);
        tbl_Sach.setSurrendersFocusOnKeystroke(true);
        tbl_Sach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SachMouseClicked(evt);
            }
        });
        tbl_Sach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_SachKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_SachKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Sach);
        if (tbl_Sach.getColumnModel().getColumnCount() > 0) {
            tbl_Sach.getColumnModel().getColumn(0).setPreferredWidth(10);
            tbl_Sach.getColumnModel().getColumn(1).setMinWidth(230);
        }

        rightPanelSach.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 1190, 424));

        lb_IdBook.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_IdBook.setText("Mã sách");
        rightPanelSach.add(lb_IdBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 100, 82, -1));

        txtBookName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBookName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtBookName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBookNameKeyReleased(evt);
            }
        });
        rightPanelSach.add(txtBookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 148, 195, 32));

        lb_bookName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_bookName.setText("Tên sách");
        rightPanelSach.add(lb_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 151, 82, -1));

        txtIdBook.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIdBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdBookActionPerformed(evt);
            }
        });
        txtIdBook.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdBookKeyReleased(evt);
            }
        });
        rightPanelSach.add(txtIdBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 98, 195, 32));

        lb_author.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_author.setText("Tác giả");
        rightPanelSach.add(lb_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 201, 82, -1));

        txtAuthor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAuthor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtAuthor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAuthorKeyReleased(evt);
            }
        });
        rightPanelSach.add(txtAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 198, 195, 32));

        lb_publisher.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_publisher.setText("Nhà xuất bản");
        rightPanelSach.add(lb_publisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 251, 106, -1));

        txtPublisher.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPublisher.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPublisher.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPublisherKeyReleased(evt);
            }
        });
        rightPanelSach.add(txtPublisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 248, 195, 32));

        lb_publishYear.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_publishYear.setText("Năm xuất bản");
        rightPanelSach.add(lb_publishYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 100, -1, -1));

        txtPublishYear.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtPublishYear.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPublishYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPublishYearKeyReleased(evt);
            }
        });
        rightPanelSach.add(txtPublishYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(833, 98, 195, 32));

        lb_bookQuantity.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_bookQuantity.setText("Số lượng");
        rightPanelSach.add(lb_bookQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 151, 97, 26));

        lb_typeOfBook.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_typeOfBook.setText("Thể loại");
        rightPanelSach.add(lb_typeOfBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 201, 82, -1));

        txtTypeOfBook.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTypeOfBook.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTypeOfBook.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTypeOfBookKeyReleased(evt);
            }
        });
        rightPanelSach.add(txtTypeOfBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(833, 198, 195, 32));

        lb_price.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_price.setText("Giá");
        rightPanelSach.add(lb_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 251, 100, -1));

        txtPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPrice.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPriceKeyReleased(evt);
            }
        });
        rightPanelSach.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(833, 248, 195, 32));

        spiner_bookQuantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        spiner_bookQuantity.setModel(new javax.swing.SpinnerNumberModel(1, 0, null, 1));
        spiner_bookQuantity.setPreferredSize(new java.awt.Dimension(60, 26));
        rightPanelSach.add(spiner_bookQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(833, 144, -1, 35));

        SearchBook.setBackground(new java.awt.Color(255, 204, 153));

        txtSearchBook.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearchBook.setText("Tìm kiếm sách");
        txtSearchBook.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchBookCaretUpdate(evt);
            }
        });
        txtSearchBook.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchBookFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchBookFocusLost(evt);
            }
        });
        txtSearchBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchBookActionPerformed(evt);
            }
        });
        txtSearchBook.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchBookKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout SearchBookLayout = new javax.swing.GroupLayout(SearchBook);
        SearchBook.setLayout(SearchBookLayout);
        SearchBookLayout.setHorizontalGroup(
            SearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        SearchBookLayout.setVerticalGroup(
            SearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        rightPanelSach.add(SearchBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 49, -1, -1));

        pnl.setBackground(new java.awt.Color(242, 247, 251));
        pnl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMouseClicked(evt);
            }
        });

        btn_insertBook.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_insertBook.setText("Insert");
        btn_insertBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_insertBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_insertBookMouseClicked(evt);
            }
        });
        btn_insertBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertBookActionPerformed(evt);
            }
        });

        btm_editBook.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btm_editBook.setText("Update");
        btm_editBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btm_editBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btm_editBookMouseClicked(evt);
            }
        });
        btm_editBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btm_editBookActionPerformed(evt);
            }
        });

        btn_reseBook.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_reseBook.setText("Reset");
        btn_reseBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_reseBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_reseBookMouseClicked(evt);
            }
        });
        btn_reseBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reseBookActionPerformed(evt);
            }
        });

        lb_SortBy.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_SortBy.setText("Sắp xếp theo: ");

        cbxSortBook.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxSortBook.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã sách", "Tên sách", "Tác giả", "Nhà xuất bản", "Số lượng", "Thể loại", "Giá" }));
        cbxSortBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxSortBookMouseClicked(evt);
            }
        });
        cbxSortBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSortBookActionPerformed(evt);
            }
        });

        btn_deleteBook.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_deleteBook.setText("Delete");
        btn_deleteBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_deleteBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_deleteBookMouseClicked(evt);
            }
        });
        btn_deleteBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl);
        pnl.setLayout(pnlLayout);
        pnlLayout.setHorizontalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(btn_insertBook, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(btm_editBook, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(btn_deleteBook, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(btn_reseBook, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(lb_SortBy)
                .addGap(42, 42, 42)
                .addComponent(cbxSortBook, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlLayout.setVerticalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addGap(314, 314, 314)
                .addComponent(btn_insertBook, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlLayout.createSequentialGroup()
                .addGap(314, 314, 314)
                .addComponent(btm_editBook, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlLayout.createSequentialGroup()
                .addGap(314, 314, 314)
                .addComponent(btn_deleteBook, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlLayout.createSequentialGroup()
                .addGap(314, 314, 314)
                .addComponent(btn_reseBook, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlLayout.createSequentialGroup()
                .addGap(314, 314, 314)
                .addComponent(lb_SortBy, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlLayout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(cbxSortBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        rightPanelSach.add(pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        rightPanelPhieuMuon.setBackground(new java.awt.Color(242, 247, 251));
        rightPanelPhieuMuon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBackground(new java.awt.Color(203, 228, 222));

        tbl_PhieuMuon.setBackground(new java.awt.Color(203, 228, 222));
        tbl_PhieuMuon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_PhieuMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã PM", "Mã độc giả", "Ngày mượn", "Ngày hẹn trả", "Ngày Trả"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_PhieuMuon.setRowHeight(23);
        tbl_PhieuMuon.setSelectionBackground(new java.awt.Color(0, 204, 102));
        tbl_PhieuMuon.setSurrendersFocusOnKeystroke(true);
        tbl_PhieuMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_PhieuMuonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_PhieuMuon);
        if (tbl_PhieuMuon.getColumnModel().getColumnCount() > 0) {
            tbl_PhieuMuon.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbl_PhieuMuon.getColumnModel().getColumn(0).setMaxWidth(100);
            tbl_PhieuMuon.getColumnModel().getColumn(1).setPreferredWidth(100);
            tbl_PhieuMuon.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        rightPanelPhieuMuon.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 389, 1190, 424));

        cbx_DocGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbx_DocGia.setMaximumRowCount(26);
        cbx_DocGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        cbx_DocGia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbx_DocGia.setKeySelectionManager(null);
        cbx_DocGia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbx_DocGiaItemStateChanged(evt);
            }
        });
        cbx_DocGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbx_DocGiaMouseClicked(evt);
            }
        });
        cbx_DocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_DocGiaActionPerformed(evt);
            }
        });
        cbx_DocGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_DocGiaKeyPressed(evt);
            }
        });
        rightPanelPhieuMuon.add(cbx_DocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 145, 195, 32));

        cbx_Books.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbx_Books.setMaximumRowCount(26);
        cbx_Books.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        cbx_Books.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbx_Books.setKeySelectionManager(null);
        cbx_Books.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbx_BooksItemStateChanged(evt);
            }
        });
        cbx_Books.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbx_BooksMouseClicked(evt);
            }
        });
        cbx_Books.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_BooksActionPerformed(evt);
            }
        });
        cbx_Books.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_BooksKeyPressed(evt);
            }
        });
        rightPanelPhieuMuon.add(cbx_Books, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 220, 195, 32));

        lb_chooseBook.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_chooseBook.setText("Chọn sách");
        rightPanelPhieuMuon.add(lb_chooseBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 80, 30));
        rightPanelPhieuMuon.add(lb_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 20, 20));

        lb_IdBook1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_IdBook1.setText("Mã PM");
        rightPanelPhieuMuon.add(lb_IdBook1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 70, -1));

        lb_IdBook4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_IdBook4.setText("Ngày Mượn");
        rightPanelPhieuMuon.add(lb_IdBook4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 90, 40));

        txtMaPhieuMuon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaPhieuMuon.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtMaPhieuMuonCaretUpdate(evt);
            }
        });
        txtMaPhieuMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPhieuMuonActionPerformed(evt);
            }
        });
        rightPanelPhieuMuon.add(txtMaPhieuMuon, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 76, 195, 32));

        lb_IdBook2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_IdBook2.setText("Độc Giả");
        rightPanelPhieuMuon.add(lb_IdBook2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 80, -1));

        txtIdBook2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIdBook2.setEnabled(false);
        txtIdBook2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdBook2ActionPerformed(evt);
            }
        });
        rightPanelPhieuMuon.add(txtIdBook2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 100, -1));
        txtIdBook2.setVisible(false);

        btn_insertBook2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_insertBook2.setText("Insert");
        btn_insertBook2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_insertBook2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_insertBook2MouseClicked(evt);
            }
        });
        btn_insertBook2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertBook2ActionPerformed(evt);
            }
        });
        rightPanelPhieuMuon.add(btn_insertBook2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 108, 39));

        btm_editPM.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btm_editPM.setText("Update");
        btm_editPM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btm_editPM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btm_editPMMouseClicked(evt);
            }
        });
        btm_editPM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btm_editPMKeyPressed(evt);
            }
        });
        rightPanelPhieuMuon.add(btm_editPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 108, 39));

        btn_delBook2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_delBook2.setText("Delete");
        btn_delBook2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_delBook2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_delBook2MouseClicked(evt);
            }
        });
        btn_delBook2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delBook2ActionPerformed(evt);
            }
        });
        rightPanelPhieuMuon.add(btn_delBook2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 108, 39));

        lb_IdBook5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_IdBook5.setText("Ngày hẹn trả");
        rightPanelPhieuMuon.add(lb_IdBook5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, -1, 40));

        btn_resetPM.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_resetPM.setText("Reset");
        btn_resetPM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_resetPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetPMActionPerformed(evt);
            }
        });
        rightPanelPhieuMuon.add(btn_resetPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 300, 108, 39));

        panel_sachMuon.setBackground(new java.awt.Color(242, 247, 251));
        panel_sachMuon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel_sachMuon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_sachMuon.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 43, 380, -1));

        lablelTongSach.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lablelTongSach.setForeground(new java.awt.Color(0, 102, 51));
        lablelTongSach.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lablelTongSach.setText("Tổng số sách mượn đã chọn: ");
        panel_sachMuon.add(lablelTongSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 270, 60));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thông tin sách mượn");
        panel_sachMuon.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 14, 390, -1));

        tbl_sachMuon.setBackground(new java.awt.Color(203, 228, 222));
        tbl_sachMuon.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tbl_sachMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã - Tên Sách", "SL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_sachMuon.setGridColor(new java.awt.Color(102, 102, 0));
        tbl_sachMuon.setPreferredSize(new java.awt.Dimension(500, 300));
        tbl_sachMuon.setRowHeight(23);
        tbl_sachMuon.setRowMargin(2);
        tbl_sachMuon.setSelectionBackground(new java.awt.Color(0, 204, 102));
        tbl_sachMuon.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_sachMuon.setShowGrid(false);
        tbl_sachMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sachMuonMouseClicked(evt);
            }
        });
        tbl_sachMuon.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tbl_sachMuonInputMethodTextChanged(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_sachMuon);
        if (tbl_sachMuon.getColumnModel().getColumnCount() > 0) {
            tbl_sachMuon.getColumnModel().getColumn(0).setPreferredWidth(455);
            tbl_sachMuon.getColumnModel().getColumn(1).setPreferredWidth(100);
        }
        tbl_sachMuon.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));

        panel_sachMuon.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 370, 260));

        btn_clear.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_clear.setText("Clear");
        btn_clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        panel_sachMuon.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, 80, 25));

        btn_save.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_save.setText("Save");
        btn_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        panel_sachMuon.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 322, 80, 25));

        rightPanelPhieuMuon.add(panel_sachMuon, new org.netbeans.lib.awtextra.AbsoluteConstraints(799, 2, 388, -1));
        panel_sachMuon.setVisible(false);

        lb_IdBook6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_IdBook6.setText("Ngày trả");
        rightPanelPhieuMuon.add(lb_IdBook6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 70, 30));

        dateChooseNgayTra.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dateChooseNgayTra.setMaxSelectableDate(new java.util.Date(253370743275000L));
        rightPanelPhieuMuon.add(dateChooseNgayTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 195, 32));

        dateChooseNgayMuon.setEnabled(false);
        dateChooseNgayMuon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rightPanelPhieuMuon.add(dateChooseNgayMuon, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 76, 195, 32));

        dateChooseNgayHenTra.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rightPanelPhieuMuon.add(dateChooseNgayHenTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 145, 195, 32));

        lb_SortBy2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_SortBy2.setText("Sắp xếp theo: ");
        rightPanelPhieuMuon.add(lb_SortBy2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        cbxSortPhieuMuon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxSortPhieuMuon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã phiếu mượn", "Mã độc giả", "Ngày mượn", "Ngày hẹn trả", "Ngày trả" }));
        cbxSortPhieuMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxSortPhieuMuonMouseClicked(evt);
            }
        });
        cbxSortPhieuMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSortPhieuMuonActionPerformed(evt);
            }
        });
        rightPanelPhieuMuon.add(cbxSortPhieuMuon, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        txtSearchPhieuMuon.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        txtSearchPhieuMuon.setForeground(new java.awt.Color(153, 153, 153));
        txtSearchPhieuMuon.setText("Tìm kiếm phiếu mượn");
        txtSearchPhieuMuon.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchPhieuMuonCaretUpdate(evt);
            }
        });
        txtSearchPhieuMuon.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchPhieuMuonFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchPhieuMuonFocusLost(evt);
            }
        });
        txtSearchPhieuMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchPhieuMuonActionPerformed(evt);
            }
        });
        txtSearchPhieuMuon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchPhieuMuonKeyReleased(evt);
            }
        });
        rightPanelPhieuMuon.add(txtSearchPhieuMuon, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 16, 280, 40));

        leftPanel.setBackground(new java.awt.Color(255, 255, 255));
        leftPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HeadingHome.setFont(new java.awt.Font("Segoe UI", 1, 45)); // NOI18N
        HeadingHome.setForeground(new java.awt.Color(255, 255, 255));
        HeadingHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HeadingHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_home_white_48dp.png"))); // NOI18N
        HeadingHome.setText(" LMS");
        HeadingHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HeadingHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HeadingHomeMouseClicked(evt);
            }
        });
        leftPanel.add(HeadingHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 160, 70));

        logOutIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_logout_white_24dp.png"))); // NOI18N
        logOutIcon.setToolTipText("Logout?");
        logOutIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logOutIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutIconMouseClicked(evt);
            }
        });
        leftPanel.add(logOutIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 770, -1, 30));

        copyright.setForeground(new java.awt.Color(204, 204, 204));
        copyright.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copyright.setText("Version 1.0.0");
        leftPanel.add(copyright, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 790, 70, 30));

        lb_footer.setForeground(new java.awt.Color(255, 255, 255));
        lb_footer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_footer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_account_circle_white_24dp.png"))); // NOI18N
        lb_footer.setText(" " + Username.getUsername());
        leftPanel.add(lb_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 760, 300, 40));

        pnl_QuanLySach.setBackground(new java.awt.Color(111, 153, 173));
        pnl_QuanLySach.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pnl_QuanLySachFocusGained(evt);
            }
        });

        lb_QuanLySach.setBackground(new java.awt.Color(153, 153, 153));
        lb_QuanLySach.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lb_QuanLySach.setForeground(new java.awt.Color(255, 255, 255));
        lb_QuanLySach.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_QuanLySach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_menu_book_white_48dp.png"))); // NOI18N
        lb_QuanLySach.setText("  Book Management");
        lb_QuanLySach.setToolTipText("Book management function");
        lb_QuanLySach.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lb_QuanLySach.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_QuanLySach.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lb_QuanLySachFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lb_QuanLySachFocusLost(evt);
            }
        });
        lb_QuanLySach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_QuanLySachMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_QuanLySachMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_QuanLySachMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnl_QuanLySachLayout = new javax.swing.GroupLayout(pnl_QuanLySach);
        pnl_QuanLySach.setLayout(pnl_QuanLySachLayout);
        pnl_QuanLySachLayout.setHorizontalGroup(
            pnl_QuanLySachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_QuanLySachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_QuanLySach, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_QuanLySachLayout.setVerticalGroup(
            pnl_QuanLySachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_QuanLySach, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        leftPanel.add(pnl_QuanLySach, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, -1));

        pnl_QuanLyDocGia.setBackground(new java.awt.Color(0, 204, 51));

        lb_QuanLyDocGia.setBackground(new java.awt.Color(111, 153, 173));
        lb_QuanLyDocGia.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lb_QuanLyDocGia.setForeground(new java.awt.Color(255, 255, 255));
        lb_QuanLyDocGia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_QuanLyDocGia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_manage_accounts_white_48dp.png"))); // NOI18N
        lb_QuanLyDocGia.setText("Reader Management");
        lb_QuanLyDocGia.setToolTipText("Poison management function");
        lb_QuanLyDocGia.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lb_QuanLyDocGia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_QuanLyDocGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_QuanLyDocGiaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_QuanLyDocGiaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_QuanLyDocGiaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnl_QuanLyDocGiaLayout = new javax.swing.GroupLayout(pnl_QuanLyDocGia);
        pnl_QuanLyDocGia.setLayout(pnl_QuanLyDocGiaLayout);
        pnl_QuanLyDocGiaLayout.setHorizontalGroup(
            pnl_QuanLyDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(pnl_QuanLyDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_QuanLyDocGiaLayout.createSequentialGroup()
                    .addGap(0, 6, Short.MAX_VALUE)
                    .addComponent(lb_QuanLyDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 6, Short.MAX_VALUE)))
        );
        pnl_QuanLyDocGiaLayout.setVerticalGroup(
            pnl_QuanLyDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(pnl_QuanLyDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_QuanLyDocGiaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lb_QuanLyDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        leftPanel.add(pnl_QuanLyDocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, -1, -1));

        pnl_PhieuMuon.setBackground(new java.awt.Color(250, 210, 55));

        lb_PhieuMuon.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lb_PhieuMuon.setForeground(new java.awt.Color(255, 255, 255));
        lb_PhieuMuon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_PhieuMuon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_newspaper_white_48dp.png"))); // NOI18N
        lb_PhieuMuon.setText("  Loan Management");
        lb_PhieuMuon.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lb_PhieuMuon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_PhieuMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_PhieuMuonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_PhieuMuonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_PhieuMuonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnl_PhieuMuonLayout = new javax.swing.GroupLayout(pnl_PhieuMuon);
        pnl_PhieuMuon.setLayout(pnl_PhieuMuonLayout);
        pnl_PhieuMuonLayout.setHorizontalGroup(
            pnl_PhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_PhieuMuonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_PhieuMuon, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_PhieuMuonLayout.setVerticalGroup(
            pnl_PhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_PhieuMuonLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lb_PhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        leftPanel.add(pnl_PhieuMuon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, -1, -1));

        pnl_Thongkebaocao.setBackground(new java.awt.Color(255, 102, 102));

        lb_ThongKeBaoCao.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lb_ThongKeBaoCao.setForeground(new java.awt.Color(255, 255, 255));
        lb_ThongKeBaoCao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_ThongKeBaoCao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_analytics_white_48dp.png"))); // NOI18N
        lb_ThongKeBaoCao.setText("         Analysis");
        lb_ThongKeBaoCao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lb_ThongKeBaoCao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_ThongKeBaoCao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_ThongKeBaoCaoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_ThongKeBaoCaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_ThongKeBaoCaoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnl_ThongkebaocaoLayout = new javax.swing.GroupLayout(pnl_Thongkebaocao);
        pnl_Thongkebaocao.setLayout(pnl_ThongkebaocaoLayout);
        pnl_ThongkebaocaoLayout.setHorizontalGroup(
            pnl_ThongkebaocaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ThongkebaocaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_ThongKeBaoCao, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_ThongkebaocaoLayout.setVerticalGroup(
            pnl_ThongkebaocaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ThongkebaocaoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lb_ThongKeBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        leftPanel.add(pnl_Thongkebaocao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 512, -1, -1));

        pnl_ThongTin.setBackground(new java.awt.Color(111, 153, 173));

        lb_info.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lb_info.setForeground(new java.awt.Color(255, 255, 255));
        lb_info.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/outline_info_white_48dp.png"))); // NOI18N
        lb_info.setText("        About us");
        lb_info.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lb_info.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_infoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_infoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_infoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnl_ThongTinLayout = new javax.swing.GroupLayout(pnl_ThongTin);
        pnl_ThongTin.setLayout(pnl_ThongTinLayout);
        pnl_ThongTinLayout.setHorizontalGroup(
            pnl_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(pnl_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_ThongTinLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lb_info, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnl_ThongTinLayout.setVerticalGroup(
            pnl_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(pnl_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_ThongTinLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lb_info, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        leftPanel.add(pnl_ThongTin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 645, -1, -1));

        bground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/splashBG.jpg"))); // NOI18N
        leftPanel.add(bground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Home.setBackground(new java.awt.Color(255, 255, 255));
        Home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Home.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 101, 928, -1));

        jLabel6.setForeground(new java.awt.Color(64, 51, 134));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/HomeBackgroundLMS.png"))); // NOI18N
        jLabel6.setToolTipText("");
        Home.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, 210, 1550, 650));

        lb_HelloUser.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        lb_HelloUser.setForeground(new java.awt.Color(64, 51, 134));
        lb_HelloUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_HelloUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/outline_waving_hand_black_36dp.png"))); // NOI18N
        lb_HelloUser.setText(" Hi");
        Home.add(lb_HelloUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 35, 1168, -1));
        if(Username.getUsername() == null){
            lb_HelloUser.setText(" Hello");
        } else {
            lb_HelloUser.setText(" Hello, " + Username.getUsername());
            System.out.println("Name = " + Username.getUsername());
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(64, 51, 134));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome To The Library Management System");
        Home.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1180, 70));

        rightPanelDocGia.setBackground(new java.awt.Color(242, 247, 251));
        rightPanelDocGia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBackground(new java.awt.Color(242, 247, 251));

        tbl_DocGia.setBackground(new java.awt.Color(203, 228, 222));
        tbl_DocGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_DocGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đôc giả", "Họ tên", "Giói tính", "Ngày sinh", "CCCD/CMND", "Số điện thoại"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_DocGia.setGridColor(new java.awt.Color(204, 204, 204));
        tbl_DocGia.setRowHeight(23);
        tbl_DocGia.setSelectionBackground(new java.awt.Color(0, 204, 102));
        tbl_DocGia.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tbl_DocGia.setSurrendersFocusOnKeystroke(true);
        tbl_DocGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DocGiaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_DocGiaMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_DocGia);
        if (tbl_DocGia.getColumnModel().getColumnCount() > 0) {
            tbl_DocGia.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbl_DocGia.getColumnModel().getColumn(0).setMaxWidth(100);
            tbl_DocGia.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbl_DocGia.getColumnModel().getColumn(2).setMaxWidth(100);
            tbl_DocGia.getColumnModel().getColumn(3).setPreferredWidth(200);
            tbl_DocGia.getColumnModel().getColumn(3).setMaxWidth(200);
        }

        rightPanelDocGia.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 387, 1190, 424));

        btm_editDocGia.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btm_editDocGia.setText("Update");
        btm_editDocGia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btm_editDocGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btm_editDocGiaMouseClicked(evt);
            }
        });
        btm_editDocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btm_editDocGiaActionPerformed(evt);
            }
        });
        rightPanelDocGia.add(btm_editDocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 108, 39));

        lb_IdDocGia.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_IdDocGia.setText("Mã độc giả");
        rightPanelDocGia.add(lb_IdDocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 104, 82, -1));

        txtTenDocGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenDocGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTenDocGiaKeyReleased(evt);
            }
        });
        rightPanelDocGia.add(txtTenDocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 195, 32));

        lb_TenDocGia.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_TenDocGia.setText("Họ và tên");
        rightPanelDocGia.add(lb_TenDocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 154, 82, -1));

        txtIdDocGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIdDocGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdDocGiaKeyReleased(evt);
            }
        });
        rightPanelDocGia.add(txtIdDocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 195, 32));

        lb_gender.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_gender.setText("Giới tính");
        rightPanelDocGia.add(lb_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 198, 82, 40));

        lb_ngaySinh.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_ngaySinh.setText("Ngày sinh");
        rightPanelDocGia.add(lb_ngaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 254, 106, -1));

        lb_cccd.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_cccd.setText("Số CCCD");
        rightPanelDocGia.add(lb_cccd, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 104, -1, -1));

        txtCCCD.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtCCCD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCCCDKeyReleased(evt);
            }
        });
        rightPanelDocGia.add(txtCCCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, 195, 32));

        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSDTKeyReleased(evt);
            }
        });
        rightPanelDocGia.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 150, 195, 32));

        lb_bookQuantity1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_bookQuantity1.setText("Số điện thoại");
        rightPanelDocGia.add(lb_bookQuantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 154, 97, 26));

        btn_xoaDocGia.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_xoaDocGia.setText("Delete");
        btn_xoaDocGia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_xoaDocGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_xoaDocGiaMouseClicked(evt);
            }
        });
        rightPanelDocGia.add(btn_xoaDocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 108, 39));

        btn_insertDocGia.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_insertDocGia.setText("Insert");
        btn_insertDocGia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_insertDocGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_insertDocGiaMouseClicked(evt);
            }
        });
        btn_insertDocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertDocGiaActionPerformed(evt);
            }
        });
        rightPanelDocGia.add(btn_insertDocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 108, 39));

        lb_SortBy1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_SortBy1.setText("Sắp xếp theo: ");
        rightPanelDocGia.add(lb_SortBy1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 340, -1, -1));

        cbxSortDocGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxSortDocGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã", "Tên", "Giới tính" }));
        cbxSortDocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSortDocGiaActionPerformed(evt);
            }
        });
        rightPanelDocGia.add(cbxSortDocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 340, 117, -1));

        SearchDocGia.setBackground(new java.awt.Color(255, 255, 255));

        txtSearchDocGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearchDocGia.setText("Tìm kiếm độc giả");
        txtSearchDocGia.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchDocGiaCaretUpdate(evt);
            }
        });
        txtSearchDocGia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchDocGiaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchDocGiaFocusLost(evt);
            }
        });
        txtSearchDocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchDocGiaActionPerformed(evt);
            }
        });
        txtSearchDocGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchDocGiaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout SearchDocGiaLayout = new javax.swing.GroupLayout(SearchDocGia);
        SearchDocGia.setLayout(SearchDocGiaLayout);
        SearchDocGiaLayout.setHorizontalGroup(
            SearchDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSearchDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        SearchDocGiaLayout.setVerticalGroup(
            SearchDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSearchDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        rightPanelDocGia.add(SearchDocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

        btn_resetDocGia.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_resetDocGia.setText("Reset");
        btn_resetDocGia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_resetDocGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_resetDocGiaMouseClicked(evt);
            }
        });
        btn_resetDocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetDocGiaActionPerformed(evt);
            }
        });
        rightPanelDocGia.add(btn_resetDocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 330, 108, 39));

        rdNu.setBackground(new java.awt.Color(242, 247, 251));
        buttonGroupGender.add(rdNu);
        rdNu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdNu.setText("Nữ");
        rightPanelDocGia.add(rdNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 190, 60, 60));

        rdNam.setBackground(new java.awt.Color(242, 247, 251));
        buttonGroupGender.add(rdNam);
        rdNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdNam.setSelected(true);
        rdNam.setText("Nam");
        rightPanelDocGia.add(rdNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 200, 70, 40));

        dateChoose.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dateChoose.setMaxSelectableDate(new java.util.Date(253370743293000L));
        dateChoose.setMinSelectableDate(new java.util.Date(-62109611907000L));
        rightPanelDocGia.add(dateChoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 195, 32));

        rightPanelInfo.setBackground(new java.awt.Color(255, 255, 255));
        rightPanelInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        rightPanelInfo.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 101, 928, -1));

        lb_HelloUser1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lb_HelloUser1.setForeground(new java.awt.Color(0, 102, 51));
        lb_HelloUser1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_HelloUser1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_account_circle_white_48dp.png"))); // NOI18N
        lb_HelloUser1.setText("INFORMATION");
        rightPanelInfo.add(lb_HelloUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1180, 80));

        btn_github.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_github.png"))); // NOI18N
        btn_github.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_github.setPreferredSize(new java.awt.Dimension(156, 61));
        btn_github.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_githubMouseClicked(evt);
            }
        });
        rightPanelInfo.add(btn_github, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 630, 160, 45));

        btn_contact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/contact_us.png"))); // NOI18N
        btn_contact.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_contact.setPreferredSize(new java.awt.Dimension(156, 61));
        btn_contact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_contactMouseClicked(evt);
            }
        });
        rightPanelInfo.add(btn_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(937, 630, 160, 45));

        btn_requestDemo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_requestDemo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_requestDemoMouseClicked(evt);
            }
        });
        rightPanelInfo.add(btn_requestDemo, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 636, 148, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Library Management System Software");
        rightPanelInfo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1190, 61));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/section-heading.png"))); // NOI18N
        rightPanelInfo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 1180, 26));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/LMS_Infomation.png"))); // NOI18N
        rightPanelInfo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 1180, 560));

        about_us.setBackground(new java.awt.Color(255, 255, 255));
        about_us.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        about_us.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 101, 928, -1));

        avt_Vanh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/child-protection.png"))); // NOI18N
        avt_Vanh.setToolTipText("Click to redirect to Facebook");
        about_us.add(avt_Vanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 410, 70, 80));

        avt_Hung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/child-protection.png"))); // NOI18N
        avt_Hung.setToolTipText("Click to redirect to Facebook");
        about_us.add(avt_Hung, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 410, 70, 80));

        btn_hung.setToolTipText("Click to redirect to Facebook");
        btn_hung.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_hung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hungMouseClicked(evt);
            }
        });
        about_us.add(btn_hung, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 490, 70, 20));

        btn_vanh.setToolTipText("Click to redirect to Facebook");
        btn_vanh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_vanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_vanhMouseClicked(evt);
            }
        });
        about_us.add(btn_vanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 490, 60, 20));

        btn_manh.setToolTipText("Click to redirect to Facebook");
        btn_manh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_manh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_manhMouseClicked(evt);
            }
        });
        about_us.add(btn_manh, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 490, 70, 20));

        btn_nam.setToolTipText("Click to redirect to Facebook");
        btn_nam.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_nam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_namMouseClicked(evt);
            }
        });
        about_us.add(btn_nam, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 490, 70, 20));

        btn_hieu.setToolTipText("Click to redirect to Facebook");
        btn_hieu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_hieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hieuMouseClicked(evt);
            }
        });
        about_us.add(btn_hieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 490, 70, 20));

        btn_thuan.setToolTipText("Click to redirect to Facebook");
        btn_thuan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_thuan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_thuanMouseClicked(evt);
            }
        });
        about_us.add(btn_thuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 70, 20));

        avt_Thuan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/child-protection.png"))); // NOI18N
        avt_Thuan.setToolTipText("Click to redirect to Facebook");
        about_us.add(avt_Thuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 410, 70, 80));

        avt_Hieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/child-protection.png"))); // NOI18N
        avt_Hieu.setToolTipText("Click to redirect to Facebook");
        about_us.add(avt_Hieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, 70, 80));

        avt_Nam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/child-protection.png"))); // NOI18N
        avt_Nam.setToolTipText("Click to redirect to Facebook");
        about_us.add(avt_Nam, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 410, 70, 80));

        avt_Manh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/child-protection.png"))); // NOI18N
        avt_Manh.setToolTipText("Click to redirect to Facebook");
        about_us.add(avt_Manh, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 410, 70, 80));

        lb_HelloUser3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lb_HelloUser3.setForeground(new java.awt.Color(0, 102, 51));
        lb_HelloUser3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_HelloUser3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_account_circle_white_48dp.png"))); // NOI18N
        lb_HelloUser3.setText("About Us");
        about_us.add(lb_HelloUser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1150, 80));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Library Management System Software");
        about_us.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1190, 61));

        meber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        meber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/members.png"))); // NOI18N
        about_us.add(meber, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 147, 1050, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(about_us, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rightPanelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rightPanelThongke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rightPanelSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rightPanelDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 1190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rightPanelPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(about_us, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rightPanelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rightPanelSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rightPanelDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rightPanelPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rightPanelThongke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_insertBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_insertBookActionPerformed

    private void lb_QuanLySachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_QuanLySachMouseClicked
        this.setTitle("Books - Library Management System");
        setVisibleFalse();
        rightPanelSach.setVisible(true);
        resetFontColor();
        lb_QuanLySach.setForeground(Color.BLACK);
        ShowBooks show = new ShowBooks();
        show.ShowOnTblSach(SachTableModel);
        SetStatusButton(btn_deleteBook);
        SetStatusButton(btm_editBook);
    }//GEN-LAST:event_lb_QuanLySachMouseClicked

    private void lb_QuanLyDocGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_QuanLyDocGiaMouseClicked
        this.setTitle("Readers - Library Management System");
        setVisibleFalse();
        rightPanelDocGia.setVisible(true);
        resetFontColor();
        lb_QuanLyDocGia.setForeground(Color.BLACK);
        if (tbl_DocGia.getRowCount() == 0) {
            ShowDocGia.getInstance().showDocGia(DocGTableModel);
        }
    }//GEN-LAST:event_lb_QuanLyDocGiaMouseClicked

    private void lb_QuanLySachMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_QuanLySachMouseEntered
        pnl_QuanLySach.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_lb_QuanLySachMouseEntered

    private void txtIdBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdBookActionPerformed

    private void txtMaPhieuMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPhieuMuonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPhieuMuonActionPerformed

    private void txtIdBook2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdBook2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdBook2ActionPerformed

    private void btn_insertBook2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertBook2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_insertBook2ActionPerformed

    private void lb_PhieuMuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_PhieuMuonMouseClicked

        this.setTitle("Loan Slip - Library Management System");
        setVisibleFalse();
        rightPanelPhieuMuon.setVisible(true);
        resetFontColor();
        lb_PhieuMuon.setForeground(Color.BLACK);
        ShowPhieuMuon sh = new ShowPhieuMuon();
        sh.ShowOnTablePM(PhieuMuonTableModel);
        UpdateBookOnCombobox();
        UpdateDocGiaOnCombobox();
    }//GEN-LAST:event_lb_PhieuMuonMouseClicked

    private void lb_ThongKeBaoCaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ThongKeBaoCaoMouseClicked
        this.setTitle("Analysis - Library Management System");
        setVisibleFalse();
        rightPanelThongke.setVisible(true);
        resetFontColor();
        lb_ThongKeBaoCao.setForeground(Color.BLACK);
        AnalysisController anl = new AnalysisController(this);
        anl.setTotalBooks();
        anl.setTongNguoiMuon();
        anl.setTongSachMuon();
        anl.setTablePMQuaHan();
        anl.setTableTopDocGia();
//        GraphsCode graph = new GraphsCode(this);
//        graph.showBarChart();
//        Exam e = new Exam(this);
//        e.createChartPanel();
    }//GEN-LAST:event_lb_ThongKeBaoCaoMouseClicked

    private void txtSearchBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchBookActionPerformed

    private void txtSearchBookCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchBookCaretUpdate

    }//GEN-LAST:event_txtSearchBookCaretUpdate

    private void txtSearchDocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchDocGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchDocGiaActionPerformed

    private void txtSearchDocGiaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchDocGiaCaretUpdate

    }//GEN-LAST:event_txtSearchDocGiaCaretUpdate

    private void btn_insertDocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertDocGiaActionPerformed
        // TODO add your handling code here:ss
    }//GEN-LAST:event_btn_insertDocGiaActionPerformed

    private void txtSearchDocGiaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchDocGiaFocusGained
        if (txtSearchDocGia.getText().equals("Tìm kiếm độc giả")) {
            txtSearchDocGia.setText(null);
            txtSearchDocGia.requestFocus();
            RemovePlaceHolderStyle(txtSearchDocGia);
        }
    }//GEN-LAST:event_txtSearchDocGiaFocusGained

    private void txtSearchDocGiaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchDocGiaFocusLost
        if (txtSearchDocGia.getText().length() == 0) {
            AddPlaceHolderStyle(txtSearchDocGia);
            txtSearchDocGia.setText("Tìm kiếm độc giả");
        }
    }//GEN-LAST:event_txtSearchDocGiaFocusLost

    private void txtMaPhieuMuonCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtMaPhieuMuonCaretUpdate

    }//GEN-LAST:event_txtMaPhieuMuonCaretUpdate

    private void txtSearchBookFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchBookFocusGained
        if (txtSearchBook.getText().equals("Tìm kiếm sách")) {
            txtSearchBook.setText(null);
            txtSearchBook.requestFocus();
            RemovePlaceHolderStyle(txtSearchBook);
        }
    }//GEN-LAST:event_txtSearchBookFocusGained

    private void txtSearchBookFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchBookFocusLost
        if (txtSearchBook.getText().length() == 0) {
            AddPlaceHolderStyle(txtSearchBook);
            txtSearchBook.setText("Tìm kiếm sách");
        }
    }//GEN-LAST:event_txtSearchBookFocusLost

    private void logOutIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutIconMouseClicked
        int c = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn đăng xuất?", "Logout", JOptionPane.YES_NO_OPTION);
        System.out.println(c);
        if (c == 0) {
            Login login = new Login();
            login.setVisible(true);
            login.getTxtUsername().setText(Username.getUsername());
            this.dispose();
        }
    }//GEN-LAST:event_logOutIconMouseClicked

    private void HeadingHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeadingHomeMouseClicked
        this.setTitle("Home");
        setVisibleFalse();
        Home.setVisible(true);
        resetFontColor();
    }//GEN-LAST:event_HeadingHomeMouseClicked

    private void lb_QuanLySachFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lb_QuanLySachFocusGained

    }//GEN-LAST:event_lb_QuanLySachFocusGained

    private void lb_QuanLySachFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lb_QuanLySachFocusLost

    }//GEN-LAST:event_lb_QuanLySachFocusLost

    private void pnl_QuanLySachFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pnl_QuanLySachFocusGained


    }//GEN-LAST:event_pnl_QuanLySachFocusGained

    private void lb_QuanLySachMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_QuanLySachMouseExited
        pnl_QuanLySach.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_lb_QuanLySachMouseExited

    private void lb_QuanLyDocGiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_QuanLyDocGiaMouseEntered
        pnl_QuanLyDocGia.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_lb_QuanLyDocGiaMouseEntered

    private void lb_QuanLyDocGiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_QuanLyDocGiaMouseExited
        pnl_QuanLyDocGia.setBackground(new Color(0, 204, 51));
    }//GEN-LAST:event_lb_QuanLyDocGiaMouseExited

    private void lb_PhieuMuonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_PhieuMuonMouseEntered
        pnl_PhieuMuon.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_lb_PhieuMuonMouseEntered

    private void lb_PhieuMuonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_PhieuMuonMouseExited
        pnl_PhieuMuon.setBackground(new Color(255, 204, 51));
    }//GEN-LAST:event_lb_PhieuMuonMouseExited

    private void lb_ThongKeBaoCaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ThongKeBaoCaoMouseEntered
        pnl_Thongkebaocao.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_lb_ThongKeBaoCaoMouseEntered

    private void lb_ThongKeBaoCaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ThongKeBaoCaoMouseExited
        pnl_Thongkebaocao.setBackground(new Color(255, 102, 102));
    }//GEN-LAST:event_lb_ThongKeBaoCaoMouseExited

    private void lb_infoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_infoMouseClicked
        this.setTitle("About");
        setVisibleFalse();
        rightPanelInfo.setVisible(true);
        resetFontColor();
        lb_info.setForeground(Color.BLACK);
    }//GEN-LAST:event_lb_infoMouseClicked

    private void lb_infoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_infoMouseEntered
        pnl_ThongTin.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_lb_infoMouseEntered

    private void lb_infoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_infoMouseExited
        pnl_ThongTin.setBackground(new Color(0, 153, 153));
    }//GEN-LAST:event_lb_infoMouseExited

    private void btm_editBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btm_editBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btm_editBookActionPerformed

    private void btn_reseBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reseBookActionPerformed
        Component[] children = rightPanelSach.getComponents();
        for (int i = 0, j = 1; i < children.length; i++) {
            if (children[i] instanceof JTextField) {
                ((JTextField) children[i]).setText("");
            }
        }
        txtIdBook.setEditable(true);
        spiner_bookQuantity.setValue(0);
        AddPlaceHolderStyle(txtSearchBook);
        txtSearchBook.setText("Tìm kiếm sách");
        ShowBooks.getInstance().ShowOnTblSach(SachTableModel);
        SetStatusButton(btm_editBook);
        SetStatusButton(btn_deleteBook);
    }//GEN-LAST:event_btn_reseBookActionPerformed

    private void btn_resetDocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetDocGiaActionPerformed
        Component[] children = rightPanelDocGia.getComponents();
        for (int i = 0, j = 1; i < children.length; i++) {
            if (children[i] instanceof JTextField) {
                ((JTextField) children[i]).setText("");
            }
        }
        buttonGroupGender.clearSelection();
        dateChoose.setDate(null);
        txtIdDocGia.setEditable(true);
    }//GEN-LAST:event_btn_resetDocGiaActionPerformed

    private void btm_editDocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btm_editDocGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btm_editDocGiaActionPerformed

    private void btn_resetPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetPMActionPerformed
        txtMaPhieuMuon.setText("");
        txtMaPhieuMuon.setEditable(true);
        txtIdBook2.setText("");

        try {
            cbx_DocGia.setSelectedIndex(0);
            cbx_Books.setSelectedIndex(0);
        } catch (Exception e) {
        }
        dateChooseNgayMuon.setDate(null);
        dateChooseNgayHenTra.setDate(null);
        dateChooseNgayTra.setDate(null);
        btn_clear.doClick();
        panel_sachMuon.setVisible(false);
    }//GEN-LAST:event_btn_resetPMActionPerformed

    private void btn_delBook2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delBook2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_delBook2ActionPerformed

    private void btn_reseBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reseBookMouseClicked

    }//GEN-LAST:event_btn_reseBookMouseClicked

    private void btn_requestDemoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_requestDemoMouseClicked
        this.setTitle("Home");
        setVisibleFalse();
        Home.setVisible(true);
        resetFontColor();
    }//GEN-LAST:event_btn_requestDemoMouseClicked

    private void btn_contactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_contactMouseClicked
        this.setTitle("About us");
        setVisibleFalse();
        about_us.setVisible(true);
    }//GEN-LAST:event_btn_contactMouseClicked

    private void btn_thuanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_thuanMouseClicked
        try {
            Desktop.getDesktop().browse(new URL("http://facebook.com/htt268").toURI());
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btn_thuanMouseClicked

    private void btn_hieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hieuMouseClicked
        try {
            Desktop.getDesktop().browse(new URL("https://www.facebook.com/profile.php?id=100018980305945").toURI());
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btn_hieuMouseClicked

    private void btn_namMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_namMouseClicked
        try {
            Desktop.getDesktop().browse(new URL("https://www.facebook.com/vu.nam.7315720").toURI());
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btn_namMouseClicked

    private void btn_manhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_manhMouseClicked
        try {
            Desktop.getDesktop().browse(new URL("https://www.facebook.com/profile.php?id=100029052751004").toURI());
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btn_manhMouseClicked

    private void btn_vanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_vanhMouseClicked
        try {
            Desktop.getDesktop().browse(new URL("https://www.facebook.com/em.nguyenviet.9").toURI());
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btn_vanhMouseClicked

    private void btn_hungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hungMouseClicked
        try {
            Desktop.getDesktop().browse(new URL("https://www.facebook.com/profile.php?id=100035778735665").toURI());
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btn_hungMouseClicked

    private void btn_githubMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_githubMouseClicked
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/thuanyg/oop66it4.group6.git").toURI());
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btn_githubMouseClicked

    private void btn_resetDocGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_resetDocGiaMouseClicked

    }//GEN-LAST:event_btn_resetDocGiaMouseClicked

    private void cbx_BooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_BooksActionPerformed

        boolean check = true;
        if (cbx_Books.getSelectedIndex() == 0) {
            check = false;
        }
        Object item = cbx_Books.getItemAt(cbx_Books.getSelectedIndex());
        for (String string : listSachMuon) {
            if (string == (item)) {
                check = false;
            }
        }

        for (int i = 0; i < tbl_sachMuon.getRowCount() && listSachMuon.size() != 0; i++) {
            if (tbl_sachMuon.getValueAt(i, 0).equals(item.toString())) {
                check = false;
                JOptionPane.showMessageDialog(this, "Sách này đã được thêm trước đó!");
                break;
            }
        }
        String c = null;
        List<Sach> listSach = SachDAO.getInstant().selectAll();
        if (check == true) {
            int soL = 0;
            String[] idSach_cbx = item.toString().split("\\s|[A-Za-z]+");
            for (int i = 0; i < listSach.size() && !listSach.isEmpty(); i++) {
                if (Integer.parseInt(idSach_cbx[0]) == listSach.get(i).getId()) {
                    soL = listSach.get(i).getSoLuong();
                    break;
                }
            }
            c = JOptionPane.showInputDialog(rightPanelPhieuMuon, "Nhập số lượng sách: "
                    + item.toString() + " (Hiện còn " + soL + ")", "1");
        }
        while (!c.matches("\\d+") || c.equals("0")) {
            JOptionPane.showMessageDialog(rightPanelPhieuMuon, "Chỉ nhập số và số sách phải lớn hơn 0 cuốn!");
            c = JOptionPane.showInputDialog(rightPanelPhieuMuon, "Nhập số lượng sách: " + item.toString(), "1");
        }

        String[] idSach_cbx = item.toString().split("\\s|[A-Za-z]+");
        for (int i = 0; i < listSach.size() && !listSach.isEmpty(); i++) {
            if (Integer.parseInt(idSach_cbx[0]) == listSach.get(i).getId()) {
                if (Integer.parseInt(c) > listSach.get(i).getSoLuong()) {
                    JOptionPane.showMessageDialog(rightPanelPhieuMuon, "Vượt quá số sách hiện có! (Hiện có "
                            + listSach.get(i).getSoLuong() + " cuốn " + item.toString() + ")");
                    check = false;
                    break;
                }
            }
        }

        if (check == true) {
            listSachMuon.add((String) item);
            listSachMuonMoiThem.add((String) item);
            listSoLuongMuon.add(Integer.parseInt(c));
            listSoLuongMuonMoiThem.add(Integer.parseInt(c));
            panel_sachMuon.setVisible(true);
        }
        SachMuonTableModel.setRowCount(0);
        listSachMuon.forEach((list) -> {
            SachMuonTableModel.addRow(new Object[]{list, listSoLuongMuon.get(listSachMuon.indexOf(list))});
        });
        /// Copy dữ liệu mới thêm vào bảng tạm để Cập nhật số lượng sách
        SachMuonMoiThemTableModel.setRowCount(0);
        listSachMuonMoiThem.forEach((list) -> {
            SachMuonMoiThemTableModel.addRow(new Object[]{list, listSoLuongMuonMoiThem.get(listSachMuonMoiThem.indexOf(list))});
        });
        lablelTongSach.setText("Tổng số sách đã chọn: " + TongSachMuon());
    }//GEN-LAST:event_cbx_BooksActionPerformed

    private void cbx_BooksItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbx_BooksItemStateChanged

    }//GEN-LAST:event_cbx_BooksItemStateChanged

    private void cbx_BooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbx_BooksMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_BooksMouseClicked

    private void cbx_BooksKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_BooksKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_BooksKeyPressed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
//        listSoLuongMuon.clear();
//        for (int i = 0; i < SachMuonTableModel.getRowCount(); i++) {
//            int num = (int) SachMuonTableModel.getValueAt(i, 1);
//            listSoLuongMuon.add(num);
//        }
//        // Check listSoLMuon
//        for (Integer integer : listSoLuongMuon) {
//            System.out.println(integer);
//        }

        listSachMuon.clear();
        listSoLuongMuon.clear();
        // Update Table 
        tbl_sachMuon.removeAll();
        SachMuonTableModel.setRowCount(0);
        lablelTongSach.setText("Tổng số sách đã chọn: " + TongSachMuon());
//        JOptionPane.showMessageDialog(this, "Removed All");


    }//GEN-LAST:event_btn_clearActionPerformed

    private void tbl_sachMuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sachMuonMouseClicked
//        if (tbl_sachMuon.getSelectedRowCount() >= 1) {
//            int row = tbl_sachMuon.rowAtPoint(evt.getPoint());
//            menu4_delSachMuon.show(tbl_sachMuon, - (111) , 23 * row);
//        }
    }//GEN-LAST:event_tbl_sachMuonMouseClicked

    private void tbl_SachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SachMouseClicked

        String id = null;
        String name = null;
        String theloai = null;
        String tacgia = null;
        String namxb = null;
        String nhaxb = null;
        int soluong = 0;
        String gia = null;
        try {
            id = SachTableModel.getValueAt(tbl_Sach.getSelectedRow(), 0).toString();
            name = SachTableModel.getValueAt(tbl_Sach.getSelectedRow(), 1).toString();
            theloai = SachTableModel.getValueAt(tbl_Sach.getSelectedRow(), 2).toString();
            tacgia = SachTableModel.getValueAt(tbl_Sach.getSelectedRow(), 3).toString();
            namxb = SachTableModel.getValueAt(tbl_Sach.getSelectedRow(), 4).toString();
            nhaxb = SachTableModel.getValueAt(tbl_Sach.getSelectedRow(), 5).toString();
            soluong = Integer.parseInt(SachTableModel.getValueAt(tbl_Sach.getSelectedRow(), 6).toString());
            gia = SachTableModel.getValueAt(tbl_Sach.getSelectedRow(), 7).toString();
        } catch (Exception e) {
        }
        txtIdBook.setText(id);
        txtIdBook.setEditable(false);
        txtBookName.setText(name);
        txtTypeOfBook.setText(theloai);
        txtAuthor.setText(tacgia);
        txtPublishYear.setText(namxb);
        txtPublisher.setText(nhaxb);
        spiner_bookQuantity.setValue(soluong);
        txtPrice.setText(gia);
        SetStatusButton(btm_editBook);
        SetStatusButton(btn_deleteBook);

        if (tbl_Sach.getSelectedRowCount() > 1) {
            int row = tbl_Sach.rowAtPoint(evt.getPoint());
            menu3_delete.show(tbl_Sach, tbl_Sach.getWidth(), 25 * row);
            DeleteMultilLine del = new DeleteMultilLine(this);
            DeleteMultilLine.optionPaneCount = 0;
            del.ActionButtonDelete();
            btn_reseBook.doClick();
        }
    }//GEN-LAST:event_tbl_SachMouseClicked

    private void txtSearchBookKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBookKeyReleased
        if (txtSearchBook.getText() != null) {
            ArrayList<Sach> listBookSearched = SachDAO.getInstant().Search(txtSearchBook.getText());
            ShowBooks.getInstance().ShowOnTblSachWhileSearching(listBookSearched, SachTableModel);
//              SachDAO.getInstant().SearchWithoutDB(this, txtSearchBook.getText());
        }
    }//GEN-LAST:event_txtSearchBookKeyReleased

    private void formAncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorMoved

    }//GEN-LAST:event_formAncestorMoved

    private void btn_insertBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_insertBookMouseClicked
        Constraint st = new Constraint(this);
        if (st.SachValidate()) {
            InsertBookController ins = new InsertBookController(this);
            ins.Insert();
            ShowBooks show = new ShowBooks();
            show.ShowOnTblSach(SachTableModel);
        }
    }//GEN-LAST:event_btn_insertBookMouseClicked

    private void pnlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMouseClicked
        tbl_Sach.clearSelection();
    }//GEN-LAST:event_pnlMouseClicked

    private void btm_editBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btm_editBookMouseClicked
        Constraint c = new Constraint(this);
        if (c.SachValidate()) {
            UpdateBookController update = new UpdateBookController(this);
            update.Update();
            ShowBooks show = new ShowBooks();
            show.ShowOnTblSach(SachTableModel);
            SetStatusButton(btn_deleteBook);
            SetStatusButton(btm_editBook);
            btn_reseBook.doClick();
        }
    }//GEN-LAST:event_btm_editBookMouseClicked

    private void tbl_SachKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_SachKeyPressed

    }//GEN-LAST:event_tbl_SachKeyPressed

    private void tbl_SachKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_SachKeyReleased

    }//GEN-LAST:event_tbl_SachKeyReleased

    private void btn_insertDocGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_insertDocGiaMouseClicked
        Constraint c = new Constraint(this);
        if (c.DocGiaValidate() && c.DocGiaCheckForDuplicates()) {
            InsertDocGiaController ins = new InsertDocGiaController(this);
            try {
                ins.InsertDocGia();
            } catch (ParseException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ShowDocGia.getInstance().showDocGia(DocGTableModel);
    }//GEN-LAST:event_btn_insertDocGiaMouseClicked

    private void tbl_DocGiaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DocGiaMousePressed

    }//GEN-LAST:event_tbl_DocGiaMousePressed

    private void btm_editDocGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btm_editDocGiaMouseClicked

        Constraint c = new Constraint(this);
        if (c.DocGiaValidate() && c.DocGiaCheckForDuplicatesUpdate()) {
            UpdateDocGiaController upd = new UpdateDocGiaController(this);
            upd.Update();
            ShowDocGia.getInstance().showDocGia(DocGTableModel);
        }
    }//GEN-LAST:event_btm_editDocGiaMouseClicked

    private void btn_xoaDocGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xoaDocGiaMouseClicked
        DeleteDocGiaController del = new DeleteDocGiaController(this);
        if (del.Delete() != 0) {
            ShowDocGia.getInstance().showDocGia(DocGTableModel);
            btn_resetDocGia.doClick();
        }
    }//GEN-LAST:event_btn_xoaDocGiaMouseClicked

    private void tbl_PhieuMuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_PhieuMuonMouseClicked

        String id = null;
        String Ma_DG = null;
        String Ngay_Muon = null;
        String Ngay_Hen_Tra = null;
        try {
            id = PhieuMuonTableModel.getValueAt(tbl_PhieuMuon.getSelectedRow(), 0).toString();
            Ma_DG = PhieuMuonTableModel.getValueAt(tbl_PhieuMuon.getSelectedRow(), 1).toString();
            if (PhieuMuonTableModel.getValueAt(tbl_PhieuMuon.getSelectedRow(), 2) == null) {
                dateChooseNgayMuon.setDate(null);
            } else {
                Date NgayMuon = new SimpleDateFormat("yyyy-MM-dd").parse(PhieuMuonTableModel.getValueAt(tbl_PhieuMuon.getSelectedRow(), 2).toString());
                dateChooseNgayMuon.setDate(NgayMuon);
            }

            if (PhieuMuonTableModel.getValueAt(tbl_PhieuMuon.getSelectedRow(), 3) == null) {
                dateChooseNgayHenTra.setDate(null);
            } else {
                Date NgayHenTra = new SimpleDateFormat("yyyy-MM-dd").parse(PhieuMuonTableModel.getValueAt(tbl_PhieuMuon.getSelectedRow(), 3).toString());
                dateChooseNgayHenTra.setDate(NgayHenTra);
            }

            if (PhieuMuonTableModel.getValueAt(tbl_PhieuMuon.getSelectedRow(), 4) == null) {
                dateChooseNgayTra.setDate(null);
            } else {
                Date NgayTra = new SimpleDateFormat("yyyy-MM-dd").parse(PhieuMuonTableModel.getValueAt(tbl_PhieuMuon.getSelectedRow(), 4).toString());
                dateChooseNgayTra.setDate(NgayTra);
            }
        } catch (Exception e) {
        }

        txtMaPhieuMuon.setText(id);
        txtMaPhieuMuon.setEditable(false);
        txtIdBook2.setText(Ma_DG);
        for (int i = 0; i < cbx_DocGia.getItemCount() && cbx_DocGia.getItemCount() != 0; i++) {
            String item = cbx_DocGia.getItemAt(i + 1).toString();
            String[] DocG = item.split("\\s|[A-Za-z]+");
            if (DocG[0].equals(Ma_DG)) {
                cbx_DocGia.setSelectedItem(item);
                break;
            }
        }

        panel_sachMuon.setVisible(true);
        listSachMuon.clear();
        listSoLuongMuon.clear();
        // add item from tables to Table Sach_PM while click
        int idSach = 0, soLuong = 0;
        String tenSach = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            Statement st = connection.createStatement();
            String sql = "Select Sach.Ma_Sach, Sach.Ten_Sach, Sach_PhieuMuon.SoLuong From (Sach\n"
                    + "  Join Sach_PhieuMuon ON Sach.Ma_Sach = Sach_PhieuMuon.Ma_Sach\n"
                    + "  Join Phieu_Muon ON Sach_PhieuMuon.Ma_PM = Phieu_Muon.Ma_PM)\n"
                    + "  WHERE Phieu_Muon.Ma_Doc_Gia = " + Ma_DG + " and Phieu_Muon.Ma_PM = " + id;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idSach = rs.getInt("Ma_Sach");
                tenSach = rs.getString("Ten_Sach");
                soLuong = rs.getInt("SoLuong");
                String str = String.valueOf(idSach) + " | " + String.valueOf(tenSach);
                listSachMuon.add(str);
                listSoLuongMuon.add(soLuong);
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SachMuonTableModel.setRowCount(0);
        listSachMuon.forEach((list) -> {
            SachMuonTableModel.addRow(new Object[]{list, listSoLuongMuon.get(listSachMuon.indexOf(list))});
        });
        /// Copy dữ liệu vào bảng tạm để xóa
        SachMuonTempTableModel.setRowCount(0);
        listSachMuon.forEach((list) -> {
            SachMuonTempTableModel.addRow(new Object[]{list, listSoLuongMuon.get(listSachMuon.indexOf(list))});
        });
        lablelTongSach.setText("Tổng số sách đã chọn: " + TongSachMuon());

        if (tbl_PhieuMuon.getSelectedRowCount() > 1) {
            int row = tbl_PhieuMuon.rowAtPoint(evt.getPoint());
            menu3_delete.show(tbl_PhieuMuon, tbl_PhieuMuon.getWidth() - 300, 25 * row);
            DeleteMultilLine del = new DeleteMultilLine(this);
            DeleteMultilLine.optionPaneCount = 0;
            del.ActionButtonDeletePM();
            btn_resetPM.doClick();
        }

    }//GEN-LAST:event_tbl_PhieuMuonMouseClicked

    private void btn_delBook2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_delBook2MouseClicked
        DeletePhieuMuon del = new DeletePhieuMuon(this);
        UpdateBookController upd = new UpdateBookController(this);
        upd.UpdateSoLuongKhiTraSach();
        del.Delete();
        ShowPhieuMuon show = new ShowPhieuMuon();
        show.ShowOnTablePM(PhieuMuonTableModel);
    }//GEN-LAST:event_btn_delBook2MouseClicked

    private void btn_insertBook2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_insertBook2MouseClicked
        Constraint c = new Constraint(this);
        if (c.PhieuMuonValidate()) {
            InsertPhieu_Muon ins = new InsertPhieu_Muon(this);
            try {
                ins.InsertPhieu_Muon();
            } catch (ParseException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btn_insertBook2MouseClicked

    private void cbx_DocGiaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbx_DocGiaItemStateChanged

    }//GEN-LAST:event_cbx_DocGiaItemStateChanged

    private void cbx_DocGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbx_DocGiaMouseClicked

    }//GEN-LAST:event_cbx_DocGiaMouseClicked

    private void cbx_DocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_DocGiaActionPerformed

        boolean check = true;
        if (cbx_DocGia.getSelectedIndex() == 0) {
            check = false;
        }
        Object item = cbx_DocGia.getItemAt(cbx_DocGia.getSelectedIndex());
//        System.out.println("Bạn vừa chọn combobox DocGia vị trí: " + cbx_DocGia.getSelectedIndex());
        if (check == true) {
            String[] DocG = item.toString().split("\\s|[A-Za-z]+");
            System.out.println(DocG[0]);
            txtIdBook2.setText(DocG[0]);
        }
    }//GEN-LAST:event_cbx_DocGiaActionPerformed

    private void cbx_DocGiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_DocGiaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_DocGiaKeyPressed

    private void btm_editPMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btm_editPMKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btm_editPMKeyPressed

    private void btm_editPMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btm_editPMMouseClicked
        Constraint c = new Constraint(this);
        if (c.PhieuMuonValidate()) {
            UpdatePhieuMuonController upd = new UpdatePhieuMuonController(this);
            UpdateBookController upd2 = new UpdateBookController(this);
            upd.Update();
            upd2.UpdateSoLuongUpdatePM();
        }
    }//GEN-LAST:event_btm_editPMMouseClicked

    private void tbl_sachMuonTempMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sachMuonTempMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_sachMuonTempMouseClicked

    private void btn_deleteBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteBookMouseClicked
        DeleteBookController del = new DeleteBookController(this);
        del.Delete();
        ShowBooks show = new ShowBooks();
        show.ShowOnTblSach(SachTableModel);
        SetStatusButton(btn_deleteBook);
        SetStatusButton(btm_editBook);
    }//GEN-LAST:event_btn_deleteBookMouseClicked

    private void btn_deleteBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_deleteBookActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        boolean flag = true;
        
        // Kiểm tra bảng sách mượn khi người dùng sửa số lượng sách
        for (int i = 0; i < SachMuonTableModel.getRowCount() && SachMuonTableModel.getRowCount() != 0; i++) {
            int num = Integer.parseInt(tbl_sachMuon.getValueAt(i, 1).toString());
            if (num <= 0) {
                JOptionPane.showMessageDialog(this, "Hãy nhập số lượng sách > 0");
                // Update lại bảng
                SachMuonTableModel.setRowCount(0);
                listSachMuon.forEach((list) -> {
                    SachMuonTableModel.addRow(new Object[]{list, listSoLuongMuon.get(listSachMuon.indexOf(list))});
                });
                flag = false;
                break;
            }
            String id_Ten = tbl_sachMuon.getValueAt(i, 0).toString();
            String[] idArray = id_Ten.split("\\s|[A-Za-z]+");
            int id = Integer.parseInt(idArray[0]);
            Sach s = SachDAO.getInstant().selectById(id);
            int sl_cu = 0; // Lấy số lượng sách cũ trước khi sửa
            if (SachMuonTempTableModel.getRowCount() <= i) {
                sl_cu = 0;
            } else {
                try {
                    sl_cu = Integer.parseInt(SachMuonTempTableModel.getValueAt(i, 1).toString());
                } catch (Exception e) {
                }
            }
            // Gán tổng số lượng sách hiện còn ( = số sách hiện tại + số sách nhập lúc trước)
            int sl = s.getSoLuong() + sl_cu;
            if (num > sl) {
                JOptionPane.showMessageDialog(this, "Sách " + id_Ten + " hiện chỉ còn "
                        + sl + " cuốn! Hãy nhập lại số lượng.");
                // Update lại bảng
                SachMuonTableModel.setRowCount(0);
                listSachMuon.forEach((list) -> {
                    SachMuonTableModel.addRow(new Object[]{list, listSoLuongMuon.get(listSachMuon.indexOf(list))});
                });
                flag = false;
            }
        }
        
        if (flag) {
            listSoLuongMuon.clear();
            listSoLuongMuonMoiThem.clear();
            for (int i = 0; i < SachMuonTableModel.getRowCount(); i++) {
                int num = Integer.parseInt(SachMuonTableModel.getValueAt(i, 1).toString());
                listSoLuongMuon.add(num);
            }
            // Cập nhật số lượng mới sửa của các sách
            for (int i = SachMuonTableModel.getRowCount() - SachMuonMoiThemTableModel.getRowCount(); i < SachMuonTableModel.getRowCount() && i >= 0; i++) {
                try {
                    int num = Integer.parseInt(tbl_sachMuon.getValueAt(i, 1).toString());
                    listSoLuongMuonMoiThem.add(num);
                } catch (NumberFormatException numberFormatException) {
                }
            }
            // Update bảng tạm sách mới thêm
            SachMuonMoiThemTableModel.setRowCount(0);
            listSachMuonMoiThem.forEach((list) -> {
                SachMuonMoiThemTableModel.addRow(new Object[]{list, listSoLuongMuonMoiThem.get(listSachMuonMoiThem.indexOf(list))});
            });
            // Update bảng sách cũ bảng SachMuon sang bảng Temp
//        SachMuonTempTableModel.setRowCount(0);
//        listSachMuon.forEach((list) -> {
//            SachMuonTempTableModel.addRow(new Object[]{list, listSoLuongMuon.get(listSachMuon.indexOf(list))});
//        });
            // Update bảng Sách Mượn 
            SachMuonTableModel.setRowCount(0);
            listSachMuon.forEach((list) -> {
                SachMuonTableModel.addRow(new Object[]{list, listSoLuongMuon.get(listSachMuon.indexOf(list))});
            });
            JOptionPane.showMessageDialog(this, "Saved");
        }
        lablelTongSach.setText("Tổng số sách đã chọn: " + TongSachMuon());

    }//GEN-LAST:event_btn_saveActionPerformed

    private void cbxSortBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxSortBookMouseClicked

    }//GEN-LAST:event_cbxSortBookMouseClicked

    private void cbxSortBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSortBookActionPerformed
        SortBookController sort = new SortBookController(this);
        sort.Sort();
    }//GEN-LAST:event_cbxSortBookActionPerformed

    private void cbxSortPhieuMuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxSortPhieuMuonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSortPhieuMuonMouseClicked

    private void cbxSortPhieuMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSortPhieuMuonActionPerformed
        SortPhieuMuonController sp = new SortPhieuMuonController(this);
        sp.Sort();
    }//GEN-LAST:event_cbxSortPhieuMuonActionPerformed

    private void txtSearchPhieuMuonCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchPhieuMuonCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchPhieuMuonCaretUpdate

    private void txtSearchPhieuMuonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchPhieuMuonFocusGained
        if (txtSearchPhieuMuon.getText().equals("Tìm kiếm phiếu mượn")) {
            txtSearchPhieuMuon.setText(null);
            txtSearchPhieuMuon.requestFocus();
            RemovePlaceHolderStyle(txtSearchPhieuMuon);
        }
    }//GEN-LAST:event_txtSearchPhieuMuonFocusGained

    private void txtSearchPhieuMuonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchPhieuMuonFocusLost
        if (txtSearchPhieuMuon.getText().length() == 0) {
            AddPlaceHolderStyle(txtSearchPhieuMuon);
            txtSearchPhieuMuon.setText("Tìm kiếm phiếu mượn");
        }
    }//GEN-LAST:event_txtSearchPhieuMuonFocusLost

    private void txtSearchPhieuMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchPhieuMuonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchPhieuMuonActionPerformed

    private void txtSearchPhieuMuonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchPhieuMuonKeyReleased
        SearchPhieuMuonController s = new SearchPhieuMuonController(this);
        s.Search();
    }//GEN-LAST:event_txtSearchPhieuMuonKeyReleased

    private void tbl_sachMuonMoiThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sachMuonMoiThemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_sachMuonMoiThemMouseClicked

    private void tbl_sachMuonInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tbl_sachMuonInputMethodTextChanged
//        if(tbl_sachMuon.getValueAt(tbl_sachMuon.getSelectedRow(), 1).toString()){
//            
//        }
    }//GEN-LAST:event_tbl_sachMuonInputMethodTextChanged

    private void txtSearchDocGiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchDocGiaKeyReleased
        SearchDocGiaController s = new SearchDocGiaController(this);
        s.Search();
    }//GEN-LAST:event_txtSearchDocGiaKeyReleased

    private void txtCCCDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCCCDKeyReleased
        if (txtCCCD.getText().trim().length() > 12) {
            JOptionPane.showMessageDialog(this, "CCCD/CMT không quá 12 số!");
            txtCCCD.setText(txtCCCD.getText().substring(0, 12));
        }
        if (!txtCCCD.getText().trim().matches("\\d+") && txtCCCD.getText().trim() != null) {
            txtCCCD.setForeground(Color.red);
        } else {
            txtCCCD.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtCCCDKeyReleased

    private void txtIdBookKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdBookKeyReleased
        if (!txtIdBook.getText().trim().matches("\\d+") && txtIdBook.getText().trim() != null) {
            txtIdBook.setForeground(Color.red);
        } else {
            txtIdBook.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtIdBookKeyReleased

    private void txtBookNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBookNameKeyReleased
        if (!txtBookName.getText().trim().matches("[0-9A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéếêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+")
                && txtBookName.getText().trim() != null) {
            txtBookName.setForeground(Color.red);
        } else {
            txtBookName.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtBookNameKeyReleased

    private void txtAuthorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAuthorKeyReleased
        if (!txtAuthor.getText().trim().matches("[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéếêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+")
                && txtAuthor.getText().trim() != null) {
            txtAuthor.setForeground(Color.red);
        } else {
            txtAuthor.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtAuthorKeyReleased

    private void txtPublisherKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPublisherKeyReleased
        if (!txtPublisher.getText().trim().matches("[0-9A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéếêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+")
                && txtPublisher.getText().trim() != null) {
            txtPublisher.setForeground(Color.red);
        } else {
            txtPublisher.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtPublisherKeyReleased

    private void txtPublishYearKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPublishYearKeyReleased
        if (!txtPublishYear.getText().trim().matches("\\d{4}")
                && txtPublishYear.getText().trim() != null) {
            txtPublishYear.setForeground(Color.red);
        } else {
            txtPublishYear.setForeground(Color.black);
        }
        try {
            if (Integer.parseInt(txtPublishYear.getText().trim()) < 1000) {
                txtPublishYear.setForeground(Color.red);
            }
        } catch (NumberFormatException numberFormatException) {
        }
    }//GEN-LAST:event_txtPublishYearKeyReleased

    private void txtTypeOfBookKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTypeOfBookKeyReleased
        if (!txtTypeOfBook.getText().trim().matches("[0-9A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéếêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+")
                && txtTypeOfBook.getText().trim() != null) {
            txtTypeOfBook.setForeground(Color.red);
        } else {
            txtTypeOfBook.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtTypeOfBookKeyReleased

    private void txtPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyReleased
        if (!txtPrice.getText().trim().matches("\\d+")
                && txtPrice.getText().trim() != null) {
            txtPrice.setForeground(Color.red);
        } else {
            txtPrice.setForeground(Color.black);
        }
//        if(Integer.parseInt(txtPublishYear.getText().trim()) > Float.MAX_VALUE){
//            txtPublishYear.setForeground(Color.red);
//        }
    }//GEN-LAST:event_txtPriceKeyReleased

    private void txtIdDocGiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdDocGiaKeyReleased
        if (!txtIdDocGia.getText().trim().matches("\\d+") && txtIdDocGia.getText().trim() != null) {
            txtIdDocGia.setForeground(Color.red);
        } else {
            txtIdDocGia.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtIdDocGiaKeyReleased

    private void txtTenDocGiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenDocGiaKeyReleased
        if (!txtTenDocGia.getText().trim().matches("[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéếêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+")
                && txtTenDocGia.getText().trim() != null) {
            txtTenDocGia.setForeground(Color.red);
        } else {
            txtTenDocGia.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtTenDocGiaKeyReleased

    private void txtSDTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSDTKeyReleased
        if (!txtSDT.getText().trim().matches("\\d{0,10}") && txtSDT.getText().trim() != null) {
            txtSDT.setForeground(Color.red);
        } else {
            txtSDT.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtSDTKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        String path = "";
//        JFileChooser j = new JFileChooser();
//        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//        int x = j.showSaveDialog(this);
//        if (x == JFileChooser.APPROVE_OPTION) {
//            path = j.getSelectedFile().getPath();
//        }
//        Document doc = new Document();
//        try {
//            PdfWriter.getInstance(doc, new FileOutputStream(path + "\\List_Sach.pdf"));
//            doc.open();
//            Paragraph para = new Paragraph("THONG KE NHUNG SACH HIEN CO TRONG THU VIEN");
//            doc.add(para);
//            para = new Paragraph("----------------------------------------------------------------");
//            doc.add(para);
//            PdfPTable tbl = new PdfPTable(8);
//            PdfPCell c1 = new PdfPCell(new Phrase("ID"));
//            tbl.addCell(c1);
//            PdfPCell c2 = new PdfPCell(new Phrase("Ten Sach"));
//            tbl.addCell(c2);
//
//            PdfPCell c3 = new PdfPCell(new Phrase("The Loai"));
//            tbl.addCell(c3);
//
//            PdfPCell c4 = new PdfPCell(new Phrase("Tac Gia"));
//            tbl.addCell(c4);
//
//            PdfPCell c5 = new PdfPCell(new Phrase("Nam Xuat Ban"));
//            tbl.addCell(c5);
//
//            PdfPCell c6 = new PdfPCell(new Phrase("Nha Xuat Ban"));
//            tbl.addCell(c6);
//
//            PdfPCell c7 = new PdfPCell(new Phrase("So Luong"));
//            tbl.addCell(c7);
//
//            PdfPCell c8 = new PdfPCell(new Phrase("Gia"));
//            tbl.addCell(c8);
//            tbl.setHeaderRows(1);
//            ArrayList<Sach> listSach = SachDAO.getInstant().selectAll();
//            listSach.forEach((s) -> {
//                tbl.addCell(String.valueOf(s.getId()));
//                tbl.addCell(s.getTenSach());
//                tbl.addCell(s.getTheLoai());
//                tbl.addCell(s.getTacGia());
//                tbl.addCell(String.valueOf(s.getNamXB()));
//                tbl.addCell(s.getNhaXB());
//                tbl.addCell(String.valueOf(s.getSoLuong()));
//                tbl.addCell(String.valueOf(s.getGiaSach()));
//            });
//            doc.add(tbl);
//            JOptionPane.showMessageDialog(this, "PDF Generated!");
//            doc.close();
//        } catch (Exception e) {
//        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rightPanelThongkeAncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_rightPanelThongkeAncestorMoved

    }//GEN-LAST:event_rightPanelThongkeAncestorMoved

    private void btn_moreInfoDocGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_moreInfoDocGiaMouseClicked
        BarChart.Show(panelForChart);
    }//GEN-LAST:event_btn_moreInfoDocGiaMouseClicked

    private void btn_moreInfoPMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_moreInfoPMMouseClicked

    }//GEN-LAST:event_btn_moreInfoPMMouseClicked

    private void btn_moreInfoBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_moreInfoBookMouseClicked
//        this.setTitle("Books - Library Management System");
//        setVisibleFalse();
//        rightPanelSach.setVisible(true);
//        ShowBooks show = new ShowBooks();
//        show.ShowOnTblSach(SachTableModel);
          BarChartForSach.Show(panelForChart);
    }//GEN-LAST:event_btn_moreInfoBookMouseClicked

    private void tbl_PhieuMuonQHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_PhieuMuonQHMouseClicked
        int row = tbl_PhieuMuonQH.rowAtPoint(evt.getPoint());
        menu.show(tbl_PhieuMuonQH, tbl_PhieuMuonQH.getWidth(), 25 * row);
        PhieuMuonQuaHanController pmqh = new PhieuMuonQuaHanController(this);
        pmqh.optionPaneCount = 0;
        pmqh.ActionButtonSachMuon();
        pmqh.ActionButtonTienPhat();
        pmqh.ActionButtonDocGia();
        pmqh.ActionButtonLienHe();
    }//GEN-LAST:event_tbl_PhieuMuonQHMouseClicked

    private void btn_tienPhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tienPhatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tienPhatActionPerformed

    private void tbl_topDocGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_topDocGiaMouseClicked
        int row = tbl_topDocGia.rowAtPoint(evt.getPoint());
        menu2_topDocGia.show(tbl_topDocGia, tbl_topDocGia.getWidth() - 50, 25 * row);
        TopDocGiaController topDG = new TopDocGiaController(this);
        topDG.optionPaneCount = 0;
        topDG.ActionButtonDocGia();
        topDG.ActionButtonLienHe();
    }//GEN-LAST:event_tbl_topDocGiaMouseClicked

    private void btn_sdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_sdtActionPerformed

    private void btn_sdtTopDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sdtTopDGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_sdtTopDGActionPerformed

    private void cbxSortDocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSortDocGiaActionPerformed
        // TODO add your handling code here:
        SortDocGiaController Sort = new SortDocGiaController(this);
        Sort.Sort();
    }//GEN-LAST:event_cbxSortDocGiaActionPerformed

    private void btn_thongtindocgiaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_thongtindocgiaFocusGained
    }//GEN-LAST:event_btn_thongtindocgiaFocusGained

    private void btn_thongtindocgiaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_thongtindocgiaFocusLost
    }//GEN-LAST:event_btn_thongtindocgiaFocusLost

    private void tbl_DocGiaMouseClicked(java.awt.event.MouseEvent evt) {
        String madg = null;
        String hoten = null;
        String cccd = null;
        String gioitinh = null;
        String sdt = null;
        madg = DocGTableModel.getValueAt(tbl_DocGia.getSelectedRow(), 0).toString();
        hoten = DocGTableModel.getValueAt(tbl_DocGia.getSelectedRow(), 1).toString();
        cccd = DocGTableModel.getValueAt(tbl_DocGia.getSelectedRow(), 4).toString();
        sdt = DocGTableModel.getValueAt(tbl_DocGia.getSelectedRow(), 5).toString();
        if (tbl_DocGia.getValueAt(tbl_DocGia.getSelectedRow(), 2).toString().equals("1")) {
            rdNam.setSelected(true);
        } else {
            rdNu.setSelected(true);
        }
        try {
            if (DocGTableModel.getValueAt(tbl_DocGia.getSelectedRow(), 3) == null) {
                dateChoose.setDate(null);
            } else {
                Date NgaySinh = new SimpleDateFormat("yyyy-MM-dd").parse(DocGTableModel.getValueAt(tbl_DocGia.getSelectedRow(), 3).toString());
                dateChoose.setDate(NgaySinh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtIdDocGia.setText(madg);
        txtIdDocGia.setEditable(false);
        txtTenDocGia.setText(hoten);
        txtCCCD.setText(cccd);

        txtSDT.setText(sdt);

        if (tbl_DocGia.getSelectedRowCount() > 1) {
            int row = tbl_DocGia.rowAtPoint(evt.getPoint());
            menu3_delete.show(tbl_DocGia, tbl_DocGia.getWidth(), 25 * row);
            DeleteMultilLine del = new DeleteMultilLine(this);
            DeleteMultilLine.optionPaneCount = 0;
            del.ActionButtonDeleteDocGia();
            btn_resetDocGia.doClick();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    public JLabel getHeadingHome() {
        return HeadingHome;
    }

    public JLabel getBground() {
        return bground;
    }

    public JButton getBtm_editBook() {
        return btm_editBook;
    }

    public JButton getBtm_editDocGia() {
        return btm_editDocGia;
    }

    public JButton getBtn_delBook1() {
        return btn_xoaDocGia;
    }

    public JButton getBtn_insertBook() {
        return btn_insertBook;
    }

    public JButton getBtn_insertBook1() {
        return btn_insertDocGia;
    }

    public JComboBox<String> getCbxSortBook() {
        return cbxSortBook;
    }

    public JComboBox<String> getCbxSortDocGia() {
        return cbxSortDocGia;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public JLabel getLb_IdBook() {
        return lb_IdBook;
    }

    public JLabel getLb_IdDocGia() {
        return lb_IdDocGia;
    }

    public JLabel getLb_QuanLyDocGia() {
        return lb_QuanLyDocGia;
    }

    public JLabel getLb_QuanLySach() {
        return lb_QuanLySach;
    }

    public JLabel getLb_SortBy() {
        return lb_SortBy;
    }

    public JLabel getLb_SortBy1() {
        return lb_SortBy1;
    }

    public JLabel getLb_TenDocGia() {
        return lb_TenDocGia;
    }

    public JLabel getLb_ThongKeBaoCao() {
        return lb_ThongKeBaoCao;
    }

    public JLabel getLb_author() {
        return lb_author;
    }

    public JLabel getLb_bookName() {
        return lb_bookName;
    }

    public JLabel getLb_bookQuantity() {
        return lb_bookQuantity;
    }

    public JLabel getLb_bookQuantity1() {
        return lb_bookQuantity1;
    }

    public JLabel getLb_cccd() {
        return lb_cccd;
    }

    public JLabel getLb_gender() {
        return lb_gender;
    }

    public JLabel getLb_ngaySinh() {
        return lb_ngaySinh;
    }

    public JLabel getLb_price() {
        return lb_price;
    }

    public JLabel getLb_publishYear() {
        return lb_publishYear;
    }

    public JLabel getLb_publisher() {
        return lb_publisher;
    }

    public JLabel getLb_typeOfBook() {
        return lb_typeOfBook;
    }

    public JPanel getLeftPanel() {
        return leftPanel;
    }

    public JLabel getLogOutIcon() {
        return logOutIcon;
    }

    public JPanel getPnl_QuanLyDocGia() {
        return pnl_QuanLyDocGia;
    }

    public JPanel getPnl_QuanLySach() {
        return pnl_QuanLySach;
    }

    public JPanel getPnl_Thongkebaocao() {
        return pnl_Thongkebaocao;
    }

    public JPanel getRightPanelDocGia() {
        return rightPanelDocGia;
    }

    public JPanel getRightPanelSach() {
        return rightPanelSach;
    }

    public JSpinner getSpiner_bookQuantity() {
        return spiner_bookQuantity;
    }

    public JTable getTbl_DocGia() {
        return tbl_DocGia;
    }

    public JTable getTbl_Sach() {
        return tbl_Sach;
    }

    public JTextField getTxtAuthor() {
        return txtAuthor;
    }

    public JTextField getTxtBookName() {
        return txtBookName;
    }

    public JTextField getTxtCCCD() {
        return txtCCCD;
    }

    public JTextField getTxtIdBook() {
        return txtIdBook;
    }

    public JTextField getTxtIdDocGia() {
        return txtIdDocGia;
    }

    public JTextField getTxtPrice() {
        return txtPrice;
    }

    public JTextField getTxtPublishYear() {
        return txtPublishYear;
    }

    public JTextField getTxtPublisher() {
        return txtPublisher;
    }

    public JTextField getTxtSDT() {
        return txtSDT;
    }

    public JTextField getTxtTenDocGia() {
        return txtTenDocGia;
    }

    public JTextField getTxtTypeOfBook() {
        return txtTypeOfBook;
    }

    public DefaultTableModel getTableModel() {
        return SachTableModel;
    }

    public JDateChooser getDateChoose() {
        return dateChoose;
    }

    public JDateChooser getDateChooseNgayHenTra() {
        return dateChooseNgayHenTra;
    }

    public JDateChooser getDateChooseNgayMuon() {
        return dateChooseNgayMuon;
    }

    public JDateChooser getDateChooseNgayTra() {
        return dateChooseNgayTra;
    }

    public JLabel getLb_HelloUser() {
        return lb_HelloUser;
    }

    public void setLb_HelloUser(JLabel lb_HelloUser) {
        this.lb_HelloUser = lb_HelloUser;
    }

    public DefaultTableModel getModel() {
        return SachMuonTableModel;
    }

    public List<String> getList() {
        return listSachMuon;
    }

    public JPanel getDashbroadOnTop() {
        return DashbroadOnTop;
    }

    public JPanel getHome() {
        return Home;
    }

    public JPanel getSearchBook() {
        return SearchBook;
    }

    public JPanel getSearchDocGia() {
        return SearchDocGia;
    }

    public JPanel getAbout_us() {
        return about_us;
    }

    public JLabel getAvt_Hieu() {
        return avt_Hieu;
    }

    public JLabel getAvt_Hung() {
        return avt_Hung;
    }

    public JLabel getAvt_Manh() {
        return avt_Manh;
    }

    public JLabel getAvt_Nam() {
        return avt_Nam;
    }

    public JLabel getAvt_Thuan() {
        return avt_Thuan;
    }

    public JLabel getAvt_Vanh() {
        return avt_Vanh;
    }

    public DefaultTableModel getDocGTableModel() {
        return DocGTableModel;
    }

    public List<String> getListSachMuon() {
        return listSachMuon;
    }

    public List<Integer> getListSoLuongMuon() {
        return listSoLuongMuon;
    }

    public int getIndexSelectRow() {
        return indexSelectRow;
    }

    public JFrame getBarChart() {
        return barChart;
    }

    public JButton getBtn_save() {
        return btn_clear;
    }

    public ButtonGroup getButtonGroupGender() {
        return buttonGroupGender;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public JPanel getjPanelForBarChart() {
        return jPanelForBarChart;
    }

    public JLabel getLablelTongSach() {
        return lablelTongSach;
    }

    public JPanel getPnl() {
        return pnl;
    }

    public JRadioButton getRdNam() {
        return rdNam;
    }

    public JRadioButton getRdNu() {
        return rdNu;
    }

    public JButton getBtm_editBook1() {
        return btm_editPM;
    }

    public JLabel getBtn_contact() {
        return btn_contact;
    }

    public JButton getBtn_delBook2() {
        return btn_delBook2;
    }

    public JLabel getBtn_github() {
        return btn_github;
    }

    public JLabel getBtn_hieu() {
        return btn_hieu;
    }

    public JLabel getBtn_hung() {
        return btn_hung;
    }

    public JButton getBtn_insertBook2() {
        return btn_insertBook2;
    }

    public JLabel getBtn_manh() {
        return btn_manh;
    }

    public JLabel getBtn_moreInfoBook() {
        return btn_moreInfoBook;
    }

    public JLabel getBtn_moreInfoDocGia() {
        return btn_moreInfoDocGia;
    }

    public JLabel getBtn_moreInfoPM() {
        return btn_moreInfoPM;
    }

    public JLabel getBtn_nam() {
        return btn_nam;
    }

    public JPanel getPhieuPhatControl() {
        return PhieuPhatControl;
    }

    public JButton getBtn_thongtindocgia() {
        return btn_thongtindocgia;
    }

    public JButton getBtn_thontinsachmuon() {
        return btn_thontinsachmuon;
    }

    public JButton getBtn_tienPhat() {
        return btn_tienPhat;
    }

    public JPopupMenu getMenu() {
        return menu;
    }

    public JLabel getBtn_requestDemo() {
        return btn_requestDemo;
    }

    public JButton getBtn_reseBook() {
        return btn_reseBook;
    }

    public JButton getBtm_editPM() {
        return btm_editPM;
    }

    public JButton getBtn_clear() {
        return btn_clear;
    }

    public JComboBox<String> getCbx_DocGia() {
        return cbx_DocGia;
    }

    public JButton getBtn_resetDocGia() {
        return btn_resetDocGia;
    }

    public DefaultTableModel getPhieuMuonQHTableModel() {
        return PhieuMuonQHTableModel;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public JScrollPane getjScrollPane4() {
        return jScrollPane4;
    }

    public JTable getjTable1() {
        return tbl_PhieuMuonQH;
    }

    public JTable getTbl_PhieuMuonQH() {
        return tbl_PhieuMuonQH;
    }

    public JLabel getLb_product() {
        return lb_product;
    }

    public JPanel getPanelPMQuaHan() {
        return panelPMQuaHan;
    }

    public JPanel getDeleteMulti() {
        return DeleteMulti;
    }

    public JButton getBtn_thongtindocgia2() {
        return btn_deletemulti;
    }

    public JPopupMenu getMenu3_delete() {
        return menu3_delete;
    }

    public JButton getBtn_resetPM() {
        return btn_resetPM;
    }

    public JLabel getBtn_thuan() {
        return btn_thuan;
    }

    public JLabel getBtn_vanh() {
        return btn_vanh;
    }

    public JComboBox<String> getCbx_Books() {
        return cbx_Books;
    }

    public JLabel getCopyright() {
        return copyright;
    }

    public JLabel getImg_dashbroard() {
        return img_dashbroard;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    public JScrollPane getjScrollPane5() {
        return jScrollPane5;
    }

    public JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public JSeparator getjSeparator2() {
        return jSeparator2;
    }

    public JSeparator getjSeparator3() {
        return jSeparator3;
    }

    public JSeparator getjSeparator4() {
        return jSeparator4;
    }

    public JLabel getLablelforTongSach() {
        return lablelTongSach;
    }

    public JLabel getLb_HelloUser1() {
        return lb_HelloUser1;
    }

    public JLabel getLb_HelloUser3() {
        return lb_HelloUser3;
    }

    public JLabel getLb_IdBook1() {
        return lb_IdBook1;
    }

    public JTextField getTxtSearchPhieuMuon() {
        return txtSearchPhieuMuon;
    }

    public DefaultTableModel getSachMuonMoiThemTableModel() {
        return SachMuonMoiThemTableModel;
    }

    public List<String> getListSachMuonMoiThem() {
        return listSachMuonMoiThem;
    }

    public List<Integer> getListSoLuongMuonMoiThem() {
        return listSoLuongMuonMoiThem;
    }

    public JButton getBtn_deleteBook() {
        return btn_deleteBook;
    }

    public JPanel getBtn_deleteControl() {
        return PhieuPhatControl;
    }

    public JScrollPane getjScrollPane6() {
        return jScrollPane6;
    }

    public JLabel getLb_SortBy2() {
        return lb_SortBy2;
    }

    public JTable getTbl_sachMuonMoiThem() {
        return tbl_sachMuonMoiThem;
    }

    public JLabel getLb_IdBook2() {
        return lb_IdBook2;
    }

    public JLabel getLb_IdBook4() {
        return lb_IdBook4;
    }

    public JLabel getLb_IdBook5() {
        return lb_IdBook5;
    }

    public JLabel getLb_PhieuMuon() {
        return lb_PhieuMuon;
    }

    public JLabel getLb_chooseBook() {
        return lb_chooseBook;
    }

    public JLabel getLb_footer() {
        return lb_footer;
    }

    public JLabel getLb_info() {
        return lb_info;
    }

    public JLabel getLb_search() {
        return lb_search;
    }

    public JLabel getLb_tongNguoiMuon() {
        return lb_tongNguoiMuon;
    }

    public JLabel getLb_tongSachCon() {
        return lb_tongSachCon;
    }

    public JLabel getLb_tongSachDuocMuon() {
        return lb_tongSachDuocMuon;
    }

    public JLabel getMeber() {
        return meber;
    }

    public JPanel getPanel_sachMuon() {
        return panel_sachMuon;
    }

    public JPanel getPnl_PhieuMuon() {
        return pnl_PhieuMuon;
    }

    public JPanel getPnl_ThongTin() {
        return pnl_ThongTin;
    }

    public JPanel getRightPanelInfo() {
        return rightPanelInfo;
    }

    public JPanel getRightPanelPhieuMuon() {
        return rightPanelPhieuMuon;
    }

    public JPanel getRightPanelThongke() {
        return rightPanelThongke;
    }

    public JTable getTbl_PhieuMuon() {
        return tbl_PhieuMuon;
    }

    public JTable getTbl_sachMuon() {
        return tbl_sachMuon;
    }

    public JTextField getTxtIdBook2() {
        return txtIdBook2;
    }

    public JTextField getTxtMaPhieuMuon() {
        return txtMaPhieuMuon;
    }

    public DefaultTableModel getPhieuMuonTableModel() {
        return PhieuMuonTableModel;
    }

    public JButton getBtn_insertDocGia() {
        return btn_insertDocGia;
    }

    public JButton getBtn_xoaDocGia() {
        return btn_xoaDocGia;
    }

    public JLabel getLb_IdBook6() {
        return lb_IdBook6;
    }

    public JPanel getTxt() {
        return rightPanelPhieuMuon;
    }

    public JTextField getTxtSearchBook() {
        return txtSearchBook;
    }

    public JTextField getTxtSearchDocGia() {
        return txtSearchDocGia;
    }

    public DefaultTableModel getSachTableModel() {
        return SachTableModel;
    }

    public DefaultTableModel getTopDocGiaTableModel() {
        return TopDocGiaTableModel;
    }

    public JPanel getTopDocGiaControl() {
        return TopDocGiaControl;
    }

    public JButton getBtn_sdt() {
        return btn_sdt;
    }

    public JButton getBtn_thongtindocgia1() {
        return btn_thongtindocgia1;
    }

    public JPopupMenu getMenu2_topDocGia() {
        return menu2_topDocGia;
    }

    public JButton getBtn_deletemulti() {
        return btn_deletemulti;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public JScrollPane getjScrollPane8() {
        return jScrollPane8;
    }

    public JTable getTbl_topDocGia() {
        return tbl_topDocGia;
    }

    public DefaultTableModel getSachMuonTableModel() {
        return SachMuonTableModel;
    }

    public DefaultTableModel getSachMuonTempTableModel() {
        return SachMuonTempTableModel;
    }

    public JScrollPane getjScrollPane7() {
        return jScrollPane7;
    }

    public JTable getTbl_sachMuonTemp() {
        return tbl_sachMuonTemp;
    }

    public JComboBox<String> getCbxSortPhieuMuon() {
        return cbxSortPhieuMuon;
    }

    public JButton getBtn_sdtTopDG() {
        return btn_sdtTopDG;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DashbroadOnTop;
    private javax.swing.JPanel DeleteMulti;
    private javax.swing.JPanel DeleteSachMuon;
    private javax.swing.JLabel HeadingHome;
    private javax.swing.JPanel Home;
    private javax.swing.JPanel PhieuPhatControl;
    private javax.swing.JPanel SearchBook;
    private javax.swing.JPanel SearchDocGia;
    private javax.swing.JPanel TopDocGiaControl;
    private javax.swing.JPanel about_us;
    private javax.swing.JLabel avt_Hieu;
    private javax.swing.JLabel avt_Hung;
    private javax.swing.JLabel avt_Manh;
    private javax.swing.JLabel avt_Nam;
    private javax.swing.JLabel avt_Thuan;
    private javax.swing.JLabel avt_Vanh;
    private javax.swing.JFrame barChart;
    private javax.swing.JLabel bground;
    private javax.swing.JButton btm_editBook;
    private javax.swing.JButton btm_editDocGia;
    private javax.swing.JButton btm_editPM;
    private javax.swing.JButton btn_clear;
    private javax.swing.JLabel btn_contact;
    private javax.swing.JButton btn_delBook2;
    private javax.swing.JButton btn_deleteBook;
    private javax.swing.JButton btn_deleteSachMuon;
    private javax.swing.JButton btn_deletemulti;
    private javax.swing.JLabel btn_github;
    private javax.swing.JLabel btn_hieu;
    private javax.swing.JLabel btn_hung;
    private javax.swing.JButton btn_insertBook;
    private javax.swing.JButton btn_insertBook2;
    private javax.swing.JButton btn_insertDocGia;
    private javax.swing.JLabel btn_manh;
    private javax.swing.JLabel btn_moreInfoBook;
    private javax.swing.JLabel btn_moreInfoDocGia;
    private javax.swing.JLabel btn_moreInfoPM;
    private javax.swing.JLabel btn_nam;
    private javax.swing.JLabel btn_requestDemo;
    private javax.swing.JButton btn_reseBook;
    private javax.swing.JButton btn_resetDocGia;
    private javax.swing.JButton btn_resetPM;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_sdt;
    private javax.swing.JButton btn_sdtTopDG;
    private javax.swing.JButton btn_thongtindocgia;
    private javax.swing.JButton btn_thongtindocgia1;
    private javax.swing.JButton btn_thontinsachmuon;
    private javax.swing.JLabel btn_thuan;
    private javax.swing.JButton btn_tienPhat;
    private javax.swing.JLabel btn_vanh;
    private javax.swing.JButton btn_xoaDocGia;
    private javax.swing.ButtonGroup buttonGroupGender;
    private javax.swing.JComboBox<String> cbxSortBook;
    private javax.swing.JComboBox<String> cbxSortDocGia;
    private javax.swing.JComboBox<String> cbxSortPhieuMuon;
    private javax.swing.JComboBox<String> cbx_Books;
    private javax.swing.JComboBox<String> cbx_DocGia;
    private javax.swing.JLabel copyright;
    private com.toedter.calendar.JDateChooser dateChoose;
    private com.toedter.calendar.JDateChooser dateChooseNgayHenTra;
    private com.toedter.calendar.JDateChooser dateChooseNgayMuon;
    private com.toedter.calendar.JDateChooser dateChooseNgayTra;
    private javax.swing.JLabel img_dashbroard;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelForBarChart;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lablelTongSach;
    private javax.swing.JLabel lb_HelloUser;
    private javax.swing.JLabel lb_HelloUser1;
    private javax.swing.JLabel lb_HelloUser3;
    private javax.swing.JLabel lb_IdBook;
    private javax.swing.JLabel lb_IdBook1;
    private javax.swing.JLabel lb_IdBook2;
    private javax.swing.JLabel lb_IdBook4;
    private javax.swing.JLabel lb_IdBook5;
    private javax.swing.JLabel lb_IdBook6;
    private javax.swing.JLabel lb_IdDocGia;
    private javax.swing.JLabel lb_PhieuMuon;
    private javax.swing.JLabel lb_QuanLyDocGia;
    private javax.swing.JLabel lb_QuanLySach;
    private javax.swing.JLabel lb_SortBy;
    private javax.swing.JLabel lb_SortBy1;
    private javax.swing.JLabel lb_SortBy2;
    private javax.swing.JLabel lb_TenDocGia;
    private javax.swing.JLabel lb_ThongKeBaoCao;
    private javax.swing.JLabel lb_author;
    private javax.swing.JLabel lb_bookName;
    private javax.swing.JLabel lb_bookQuantity;
    private javax.swing.JLabel lb_bookQuantity1;
    private javax.swing.JLabel lb_cccd;
    private javax.swing.JLabel lb_chooseBook;
    private javax.swing.JLabel lb_footer;
    private javax.swing.JLabel lb_gender;
    private javax.swing.JLabel lb_info;
    private javax.swing.JLabel lb_ngaySinh;
    private javax.swing.JLabel lb_price;
    private javax.swing.JLabel lb_product;
    private javax.swing.JLabel lb_publishYear;
    private javax.swing.JLabel lb_publisher;
    private javax.swing.JLabel lb_search;
    private javax.swing.JLabel lb_tongNguoiMuon;
    private javax.swing.JLabel lb_tongSachCon;
    private javax.swing.JLabel lb_tongSachDuocMuon;
    private javax.swing.JLabel lb_typeOfBook;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JLabel logOutIcon;
    private javax.swing.JLabel meber;
    private javax.swing.JPopupMenu menu;
    private javax.swing.JPopupMenu menu2_topDocGia;
    private javax.swing.JPopupMenu menu3_delete;
    private javax.swing.JPopupMenu menu4_delSachMuon;
    private javax.swing.JPanel panelForChart;
    private javax.swing.JPanel panelPMQuaHan;
    private javax.swing.JPanel panel_sachMuon;
    private javax.swing.JPanel pnl;
    private javax.swing.JPanel pnl_PhieuMuon;
    private javax.swing.JPanel pnl_QuanLyDocGia;
    private javax.swing.JPanel pnl_QuanLySach;
    private javax.swing.JPanel pnl_ThongTin;
    private javax.swing.JPanel pnl_Thongkebaocao;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JPanel rightPanelDocGia;
    private javax.swing.JPanel rightPanelInfo;
    private javax.swing.JPanel rightPanelPhieuMuon;
    private javax.swing.JPanel rightPanelSach;
    private javax.swing.JPanel rightPanelThongke;
    private javax.swing.JSpinner spiner_bookQuantity;
    private javax.swing.JTable tbl_DocGia;
    private javax.swing.JTable tbl_PhieuMuon;
    private javax.swing.JTable tbl_PhieuMuonQH;
    private javax.swing.JTable tbl_Sach;
    private javax.swing.JTable tbl_sachMuon;
    private javax.swing.JTable tbl_sachMuonMoiThem;
    private javax.swing.JTable tbl_sachMuonTemp;
    private javax.swing.JTable tbl_topDocGia;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtBookName;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtIdBook;
    private javax.swing.JTextField txtIdBook2;
    private javax.swing.JTextField txtIdDocGia;
    private javax.swing.JTextField txtMaPhieuMuon;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtPublishYear;
    private javax.swing.JTextField txtPublisher;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearchBook;
    private javax.swing.JTextField txtSearchDocGia;
    private javax.swing.JTextField txtSearchPhieuMuon;
    private javax.swing.JTextField txtTenDocGia;
    private javax.swing.JTextField txtTypeOfBook;
    // End of variables declaration//GEN-END:variables
}
