/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import global.Username;
import dao.SachDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import model.Sach;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class Home extends javax.swing.JFrame {

    DefaultTableModel tableModel;
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
        tableModel = (DefaultTableModel) tbl_Sach.getModel();
        ShowBook();
        // Add placeholder
        AddPlaceHolderStyle(txtSearchBook);
        AddPlaceHolderStyle(txtSearchDocGia);
        // Add style for table
        AddTableStyle(tbl_Sach);
        AddTableStyle(tbl_DocGia);
        AddTableStyle(tbl_PhieuMuon);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/logo.png")));
        setVisibleFalse();
        Home.setVisible(true);
    }
    public void AddTableStyle(JTable table) {
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(new Color(32, 136, 203));
        table.getTableHeader().setForeground(new Color(255, 255, 255));
        table.setRowHeight(25);
    }

    public void AddPlaceHolderStyle(JTextField jtf) {
        Font font = jtf.getFont();
        font = font.deriveFont(Font.ITALIC);
        jtf.setFont(font);
        jtf.setForeground(Color.GRAY);
    }

    public void RemovePlaceHolderStyle(JTextField jtf) {
        Font font = jtf.getFont();
        font = font.deriveFont(Font.PLAIN);
        jtf.setFont(font);
        jtf.setForeground(Color.BLACK);
    }

    public void ShowBook() {
        List<Sach> listSach = SachDAO.getInstant().selectAll();
        tableModel.setRowCount(0);
        listSach.forEach((sach) -> {
            tableModel.addRow(new Object[]{sach.getId(),
                sach.getTenSach(), sach.getTheLoai(), sach.getTacGia(), sach.getNamXB(),
                sach.getNhaXB(), sach.getSoLuong(), sach.getGiaSach()});
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
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
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
        rightPanelSach = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Sach = new javax.swing.JTable();
        btm_editBook = new javax.swing.JButton();
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
        btn_delBook = new javax.swing.JButton();
        btn_insertBook = new javax.swing.JButton();
        lb_SortBy = new javax.swing.JLabel();
        cbxSortBook = new javax.swing.JComboBox<>();
        SearchBook = new javax.swing.JPanel();
        txtSearchBook = new javax.swing.JTextField();
        rightPanelDocGia = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_DocGia = new javax.swing.JTable();
        btm_editDocGia = new javax.swing.JButton();
        lb_IdDocGia = new javax.swing.JLabel();
        txtTenDocGia = new javax.swing.JTextField();
        lb_TenDocGia = new javax.swing.JLabel();
        txtIdDocGia = new javax.swing.JTextField();
        lb_gender = new javax.swing.JLabel();
        txtGender = new javax.swing.JTextField();
        lb_ngaySinh = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        lb_cccd = new javax.swing.JLabel();
        txtCCCD = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        lb_bookQuantity1 = new javax.swing.JLabel();
        lb_email = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btn_delBook1 = new javax.swing.JButton();
        btn_insertBook1 = new javax.swing.JButton();
        lb_SortBy1 = new javax.swing.JLabel();
        cbxSortDocGia = new javax.swing.JComboBox<>();
        SearchDocGia = new javax.swing.JPanel();
        txtSearchDocGia = new javax.swing.JTextField();
        rightPanelPhieuMuon = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_PhieuMuon = new javax.swing.JTable();
        lb_search = new javax.swing.JLabel();
        lb_IdBook1 = new javax.swing.JLabel();
        txtNgayMuon = new javax.swing.JTextField();
        lb_IdBook4 = new javax.swing.JLabel();
        txtMaPhieuMuon = new javax.swing.JTextField();
        lb_IdBook2 = new javax.swing.JLabel();
        txtIdBook2 = new javax.swing.JTextField();
        lb_IdBook3 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        btn_insertBook2 = new javax.swing.JButton();
        btm_editBook1 = new javax.swing.JButton();
        btn_delBook2 = new javax.swing.JButton();
        lb_IdBook5 = new javax.swing.JLabel();
        txtNgayMuon1 = new javax.swing.JTextField();
        rightPanelThongke = new javax.swing.JPanel();
        rightPanelInfo = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        lb_HelloUser1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jPanel1.setPreferredSize(new java.awt.Dimension(785, 475));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Video/introduction_app.gif"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 520));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home - Library Management System");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        copyright.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        copyright.setForeground(new java.awt.Color(204, 204, 204));
        copyright.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copyright.setText("@HUCE 2023");
        leftPanel.add(copyright, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 790, 300, 20));

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

        pnl_QuanLyDocGia.setBackground(new java.awt.Color(111, 153, 173));

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

        pnl_PhieuMuon.setBackground(new java.awt.Color(111, 153, 173));

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

        pnl_Thongkebaocao.setBackground(new java.awt.Color(111, 153, 173));

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

        getContentPane().add(leftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 810));

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

        getContentPane().add(Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 0, 1190, 810));

        rightPanelSach.setBackground(new java.awt.Color(255, 255, 255));

        tbl_Sach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_Sach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
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
        tbl_Sach.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_Sach.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_Sach.setShowGrid(false);
        tbl_Sach.setShowHorizontalLines(true);
        tbl_Sach.setSurrendersFocusOnKeystroke(true);
        jScrollPane1.setViewportView(tbl_Sach);
        if (tbl_Sach.getColumnModel().getColumnCount() > 0) {
            tbl_Sach.getColumnModel().getColumn(0).setMinWidth(15);
            tbl_Sach.getColumnModel().getColumn(1).setMinWidth(230);
        }

        btm_editBook.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btm_editBook.setText("Sửa");

        lb_IdBook.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_IdBook.setText("Mã sách");

        txtBookName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lb_bookName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_bookName.setText("Tên sách");

        txtIdBook.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIdBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdBookActionPerformed(evt);
            }
        });

        lb_author.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_author.setText("Tác giả");

        txtAuthor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lb_publisher.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_publisher.setText("Nhà xuất bản");

        txtPublisher.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lb_publishYear.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_publishYear.setText("Năm xuất bản");

        txtPublishYear.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        lb_bookQuantity.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_bookQuantity.setText("Số lượng");

        lb_typeOfBook.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_typeOfBook.setText("Thể loại");

        txtTypeOfBook.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lb_price.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_price.setText("Giá");

        txtPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        spiner_bookQuantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        spiner_bookQuantity.setPreferredSize(new java.awt.Dimension(60, 26));

        btn_delBook.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_delBook.setText("Xóa");

        btn_insertBook.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_insertBook.setText("Thêm");
        btn_insertBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertBookActionPerformed(evt);
            }
        });

        lb_SortBy.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_SortBy.setText("Sắp xếp theo: ");

        cbxSortBook.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxSortBook.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã sách", "Tên sách", "Tác giả", "Nhà xuất bản", "Số lượng", "Thể loại", "Giá" }));

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

        javax.swing.GroupLayout rightPanelSachLayout = new javax.swing.GroupLayout(rightPanelSach);
        rightPanelSach.setLayout(rightPanelSachLayout);
        rightPanelSachLayout.setHorizontalGroup(
            rightPanelSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelSachLayout.createSequentialGroup()
                .addContainerGap(184, Short.MAX_VALUE)
                .addGroup(rightPanelSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(rightPanelSachLayout.createSequentialGroup()
                        .addComponent(lb_author, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161)
                        .addComponent(lb_typeOfBook, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(txtTypeOfBook, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rightPanelSachLayout.createSequentialGroup()
                        .addComponent(lb_publisher, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161)
                        .addComponent(lb_price, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rightPanelSachLayout.createSequentialGroup()
                        .addComponent(btn_insertBook, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addComponent(btm_editBook, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(btn_delBook, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(lb_SortBy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxSortBook, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rightPanelSachLayout.createSequentialGroup()
                        .addComponent(lb_bookName, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(txtBookName, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161)
                        .addGroup(rightPanelSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_bookQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_publishYear))
                        .addGap(90, 90, 90)
                        .addGroup(rightPanelSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPublishYear, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spiner_bookQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(rightPanelSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(rightPanelSachLayout.createSequentialGroup()
                            .addComponent(lb_IdBook, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addComponent(txtIdBook, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(SearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(162, 162, 162))
        );
        rightPanelSachLayout.setVerticalGroup(
            rightPanelSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelSachLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(SearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rightPanelSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdBook, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rightPanelSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPublishYear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_publishYear))
                    .addGroup(rightPanelSachLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lb_IdBook)))
                .addGap(18, 18, 18)
                .addGroup(rightPanelSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightPanelSachLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lb_bookName))
                    .addComponent(txtBookName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_bookQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spiner_bookQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(rightPanelSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTypeOfBook, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rightPanelSachLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(rightPanelSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_author)
                            .addComponent(lb_typeOfBook))))
                .addGap(18, 18, 18)
                .addGroup(rightPanelSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rightPanelSachLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(rightPanelSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_publisher)
                            .addComponent(lb_price))))
                .addGap(47, 47, 47)
                .addGroup(rightPanelSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_insertBook, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btm_editBook, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delBook, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rightPanelSachLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(rightPanelSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxSortBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_SortBy))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(rightPanelSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 0, 1190, 810));

        rightPanelDocGia.setBackground(new java.awt.Color(255, 255, 255));
        rightPanelDocGia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_DocGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_DocGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đôc giả", "Họ tên", "Giói tính", "Ngày sinh", "CCCD/CMND", "Số điện thoại", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_DocGia.setGridColor(new java.awt.Color(0, 51, 51));
        tbl_DocGia.setRowHeight(23);
        tbl_DocGia.setSelectionBackground(new java.awt.Color(0, 204, 102));
        tbl_DocGia.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(tbl_DocGia);

        rightPanelDocGia.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 417, 1190, 400));

        btm_editDocGia.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btm_editDocGia.setText("Sửa");
        rightPanelDocGia.add(btm_editDocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 108, 39));

        lb_IdDocGia.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_IdDocGia.setText("Mã độc giả");
        rightPanelDocGia.add(lb_IdDocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 82, -1));

        txtTenDocGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rightPanelDocGia.add(txtTenDocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 195, 32));

        lb_TenDocGia.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_TenDocGia.setText("Họ và tên");
        rightPanelDocGia.add(lb_TenDocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 82, -1));

        txtIdDocGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rightPanelDocGia.add(txtIdDocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 195, 32));

        lb_gender.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_gender.setText("Giới tính");
        rightPanelDocGia.add(lb_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 82, -1));

        txtGender.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rightPanelDocGia.add(txtGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 195, 32));

        lb_ngaySinh.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_ngaySinh.setText("Ngày sinh");
        rightPanelDocGia.add(lb_ngaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 106, -1));

        txtNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rightPanelDocGia.add(txtNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 195, 32));

        lb_cccd.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_cccd.setText("Số CCCD");
        rightPanelDocGia.add(lb_cccd, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, -1, -1));

        txtCCCD.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        rightPanelDocGia.add(txtCCCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, 195, 32));

        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        rightPanelDocGia.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 150, 195, 32));

        lb_bookQuantity1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_bookQuantity1.setText("Số điện thoại");
        rightPanelDocGia.add(lb_bookQuantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 150, 97, 26));

        lb_email.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_email.setText("Email");
        rightPanelDocGia.add(lb_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 82, -1));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rightPanelDocGia.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 200, 195, 32));

        btn_delBook1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_delBook1.setText("Xóa");
        rightPanelDocGia.add(btn_delBook1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, 108, 39));

        btn_insertBook1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_insertBook1.setText("Thêm");
        btn_insertBook1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertBook1ActionPerformed(evt);
            }
        });
        rightPanelDocGia.add(btn_insertBook1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 108, 39));

        lb_SortBy1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_SortBy1.setText("Sắp xếp theo: ");
        rightPanelDocGia.add(lb_SortBy1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 340, -1, -1));

        cbxSortDocGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxSortDocGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã", "Tên", "Giới tính" }));
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

        getContentPane().add(rightPanelDocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 0, 1190, 810));

        tbl_PhieuMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma PM", "Mã độc giả", "Ngày mượn", "Ngày hẹn trả", "Số lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class
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
        tbl_PhieuMuon.setSelectionBackground(new java.awt.Color(0, 204, 102));
        tbl_PhieuMuon.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(tbl_PhieuMuon);

        lb_IdBook1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_IdBook1.setText("Mã PM");

        txtNgayMuon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNgayMuon.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNgayMuonCaretUpdate(evt);
            }
        });
        txtNgayMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayMuonActionPerformed(evt);
            }
        });

        lb_IdBook4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_IdBook4.setText("Ngày Mượn");

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

        lb_IdBook2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_IdBook2.setText("Mã DG");

        txtIdBook2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIdBook2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdBook2ActionPerformed(evt);
            }
        });

        lb_IdBook3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_IdBook3.setText("Số lượng");

        jSpinner1.setPreferredSize(new java.awt.Dimension(70, 25));

        btn_insertBook2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_insertBook2.setText("Thêm");
        btn_insertBook2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertBook2ActionPerformed(evt);
            }
        });

        btm_editBook1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btm_editBook1.setText("Sửa");

        btn_delBook2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_delBook2.setText("Xóa");

        lb_IdBook5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_IdBook5.setText("Ngày hẹn trả");

        txtNgayMuon1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNgayMuon1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNgayMuon1CaretUpdate(evt);
            }
        });
        txtNgayMuon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayMuon1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rightPanelPhieuMuonLayout = new javax.swing.GroupLayout(rightPanelPhieuMuon);
        rightPanelPhieuMuon.setLayout(rightPanelPhieuMuonLayout);
        rightPanelPhieuMuonLayout.setHorizontalGroup(
            rightPanelPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelPhieuMuonLayout.createSequentialGroup()
                .addGroup(rightPanelPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightPanelPhieuMuonLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(lb_IdBook3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rightPanelPhieuMuonLayout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(btn_insertBook2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addComponent(btm_editBook1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(btn_delBook2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rightPanelPhieuMuonLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(rightPanelPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(rightPanelPhieuMuonLayout.createSequentialGroup()
                                .addComponent(lb_IdBook2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(txtIdBook2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(139, 139, 139)
                                .addComponent(lb_IdBook5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNgayMuon1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(rightPanelPhieuMuonLayout.createSequentialGroup()
                                .addComponent(lb_IdBook1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addGroup(rightPanelPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(rightPanelPhieuMuonLayout.createSequentialGroup()
                                        .addGap(174, 174, 174)
                                        .addComponent(lb_search, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(139, 139, 139)
                                .addComponent(lb_IdBook4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(txtNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane3)
        );
        rightPanelPhieuMuonLayout.setVerticalGroup(
            rightPanelPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelPhieuMuonLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(rightPanelPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightPanelPhieuMuonLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lb_IdBook1))
                    .addGroup(rightPanelPhieuMuonLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(rightPanelPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rightPanelPhieuMuonLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(lb_search, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lb_IdBook4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(rightPanelPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdBook2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rightPanelPhieuMuonLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(rightPanelPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_IdBook2)
                            .addGroup(rightPanelPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_IdBook5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNgayMuon1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(34, 34, 34)
                .addGroup(rightPanelPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_IdBook3)
                    .addGroup(rightPanelPhieuMuonLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55)
                .addGroup(rightPanelPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_insertBook2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btm_editBook1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delBook2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(rightPanelPhieuMuon, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 0, 1190, 810));

        rightPanelThongke.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout rightPanelThongkeLayout = new javax.swing.GroupLayout(rightPanelThongke);
        rightPanelThongke.setLayout(rightPanelThongkeLayout);
        rightPanelThongkeLayout.setHorizontalGroup(
            rightPanelThongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
        );
        rightPanelThongkeLayout.setVerticalGroup(
            rightPanelThongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );

        getContentPane().add(rightPanelThongke, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 0, 1190, 810));

        rightPanelInfo.setBackground(new java.awt.Color(255, 255, 255));

        lb_HelloUser1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lb_HelloUser1.setForeground(new java.awt.Color(0, 102, 51));
        lb_HelloUser1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_HelloUser1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_account_circle_white_48dp.png"))); // NOI18N
        lb_HelloUser1.setText("INFORMATION");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Library Management System Software");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/section-heading.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/LMS_Infomation.png"))); // NOI18N

        javax.swing.GroupLayout rightPanelInfoLayout = new javax.swing.GroupLayout(rightPanelInfo);
        rightPanelInfo.setLayout(rightPanelInfoLayout);
        rightPanelInfoLayout.setHorizontalGroup(
            rightPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_HelloUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(rightPanelInfoLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 928, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1174, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        rightPanelInfoLayout.setVerticalGroup(
            rightPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelInfoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_HelloUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(rightPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightPanelInfoLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rightPanelInfoLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(rightPanelInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 0, 1190, 810));

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
    }//GEN-LAST:event_lb_QuanLySachMouseClicked

    private void lb_QuanLyDocGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_QuanLyDocGiaMouseClicked
        this.setTitle("Readers - Library Management System");
        setVisibleFalse();
        rightPanelDocGia.setVisible(true);
        resetFontColor();
        lb_QuanLyDocGia.setForeground(Color.BLACK);
    }//GEN-LAST:event_lb_QuanLyDocGiaMouseClicked

    private void lb_QuanLySachMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_QuanLySachMouseEntered
        pnl_QuanLySach.setBackground(new Color(102,102,102));
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
    }//GEN-LAST:event_lb_PhieuMuonMouseClicked

    private void lb_ThongKeBaoCaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ThongKeBaoCaoMouseClicked
        this.setTitle("Analysis - Library Management System");
        setVisibleFalse();
        rightPanelThongke.setVisible(true);
        resetFontColor();
        lb_ThongKeBaoCao.setForeground(Color.BLACK);
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

    private void btn_insertBook1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertBook1ActionPerformed
        // TODO add your handling code here:ss
    }//GEN-LAST:event_btn_insertBook1ActionPerformed

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
        pnl_QuanLySach.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_lb_QuanLySachMouseExited

    private void lb_QuanLyDocGiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_QuanLyDocGiaMouseEntered
        pnl_QuanLyDocGia.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_lb_QuanLyDocGiaMouseEntered

    private void lb_QuanLyDocGiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_QuanLyDocGiaMouseExited
        pnl_QuanLyDocGia.setBackground(new Color(0,204,51));
    }//GEN-LAST:event_lb_QuanLyDocGiaMouseExited

    private void lb_PhieuMuonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_PhieuMuonMouseEntered
        pnl_PhieuMuon.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_lb_PhieuMuonMouseEntered

    private void lb_PhieuMuonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_PhieuMuonMouseExited
        pnl_PhieuMuon.setBackground(new Color(255,204,51));
    }//GEN-LAST:event_lb_PhieuMuonMouseExited

    private void lb_ThongKeBaoCaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ThongKeBaoCaoMouseEntered
        pnl_Thongkebaocao.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_lb_ThongKeBaoCaoMouseEntered

    private void lb_ThongKeBaoCaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ThongKeBaoCaoMouseExited
        pnl_Thongkebaocao.setBackground(new Color(255,102,102));
    }//GEN-LAST:event_lb_ThongKeBaoCaoMouseExited

    private void txtNgayMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayMuonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayMuonActionPerformed

    private void txtNgayMuonCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNgayMuonCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayMuonCaretUpdate

    private void txtNgayMuon1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNgayMuon1CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayMuon1CaretUpdate

    private void txtNgayMuon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayMuon1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayMuon1ActionPerformed

    private void lb_infoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_infoMouseClicked
        this.setTitle("About");
        setVisibleFalse();
        rightPanelInfo.setVisible(true);
        resetFontColor();
        lb_info.setForeground(Color.BLACK);
    }//GEN-LAST:event_lb_infoMouseClicked

    private void lb_infoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_infoMouseEntered
        pnl_ThongTin.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_lb_infoMouseEntered

    private void lb_infoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_infoMouseExited
         pnl_ThongTin.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_lb_infoMouseExited

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

    public JButton getBtn_delBook() {
        return btn_delBook;
    }

    public JButton getBtn_delBook1() {
        return btn_delBook1;
    }

    public JButton getBtn_insertBook() {
        return btn_insertBook;
    }

    public JButton getBtn_insertBook1() {
        return btn_insertBook1;
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

    public JLabel getLb_email() {
        return lb_email;
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

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JTextField getTxtGender() {
        return txtGender;
    }

    public JTextField getTxtIdBook() {
        return txtIdBook;
    }

    public JTextField getTxtIdDocGia() {
        return txtIdDocGia;
    }

    public JTextField getTxtNgaySinh() {
        return txtNgaySinh;
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
        return tableModel;
    }

    public JLabel getLb_HelloUser() {
        return lb_HelloUser;
    }

    public void setLb_HelloUser(JLabel lb_HelloUser) {
        this.lb_HelloUser = lb_HelloUser;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HeadingHome;
    private javax.swing.JPanel Home;
    private javax.swing.JPanel SearchBook;
    private javax.swing.JPanel SearchDocGia;
    private javax.swing.JLabel bground;
    private javax.swing.JButton btm_editBook;
    private javax.swing.JButton btm_editBook1;
    private javax.swing.JButton btm_editDocGia;
    private javax.swing.JButton btn_delBook;
    private javax.swing.JButton btn_delBook1;
    private javax.swing.JButton btn_delBook2;
    private javax.swing.JButton btn_insertBook;
    private javax.swing.JButton btn_insertBook1;
    private javax.swing.JButton btn_insertBook2;
    private javax.swing.JComboBox<String> cbxSortBook;
    private javax.swing.JComboBox<String> cbxSortDocGia;
    private javax.swing.JLabel copyright;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lb_HelloUser;
    private javax.swing.JLabel lb_HelloUser1;
    private javax.swing.JLabel lb_IdBook;
    private javax.swing.JLabel lb_IdBook1;
    private javax.swing.JLabel lb_IdBook2;
    private javax.swing.JLabel lb_IdBook3;
    private javax.swing.JLabel lb_IdBook4;
    private javax.swing.JLabel lb_IdBook5;
    private javax.swing.JLabel lb_IdDocGia;
    private javax.swing.JLabel lb_PhieuMuon;
    private javax.swing.JLabel lb_QuanLyDocGia;
    private javax.swing.JLabel lb_QuanLySach;
    private javax.swing.JLabel lb_SortBy;
    private javax.swing.JLabel lb_SortBy1;
    private javax.swing.JLabel lb_TenDocGia;
    private javax.swing.JLabel lb_ThongKeBaoCao;
    private javax.swing.JLabel lb_author;
    private javax.swing.JLabel lb_bookName;
    private javax.swing.JLabel lb_bookQuantity;
    private javax.swing.JLabel lb_bookQuantity1;
    private javax.swing.JLabel lb_cccd;
    private javax.swing.JLabel lb_email;
    private javax.swing.JLabel lb_footer;
    private javax.swing.JLabel lb_gender;
    private javax.swing.JLabel lb_info;
    private javax.swing.JLabel lb_ngaySinh;
    private javax.swing.JLabel lb_price;
    private javax.swing.JLabel lb_publishYear;
    private javax.swing.JLabel lb_publisher;
    private javax.swing.JLabel lb_search;
    private javax.swing.JLabel lb_typeOfBook;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JLabel logOutIcon;
    private javax.swing.JPanel pnl_PhieuMuon;
    private javax.swing.JPanel pnl_QuanLyDocGia;
    private javax.swing.JPanel pnl_QuanLySach;
    private javax.swing.JPanel pnl_ThongTin;
    private javax.swing.JPanel pnl_Thongkebaocao;
    private javax.swing.JPanel rightPanelDocGia;
    private javax.swing.JPanel rightPanelInfo;
    private javax.swing.JPanel rightPanelPhieuMuon;
    private javax.swing.JPanel rightPanelSach;
    private javax.swing.JPanel rightPanelThongke;
    private javax.swing.JSpinner spiner_bookQuantity;
    private javax.swing.JTable tbl_DocGia;
    private javax.swing.JTable tbl_PhieuMuon;
    private javax.swing.JTable tbl_Sach;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtBookName;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtIdBook;
    private javax.swing.JTextField txtIdBook2;
    private javax.swing.JTextField txtIdDocGia;
    private javax.swing.JTextField txtMaPhieuMuon;
    private javax.swing.JTextField txtNgayMuon;
    private javax.swing.JTextField txtNgayMuon1;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtPublishYear;
    private javax.swing.JTextField txtPublisher;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearchBook;
    private javax.swing.JTextField txtSearchDocGia;
    private javax.swing.JTextField txtTenDocGia;
    private javax.swing.JTextField txtTypeOfBook;
    // End of variables declaration//GEN-END:variables
}
