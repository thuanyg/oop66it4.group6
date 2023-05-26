/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import analysService.BarChart;
import controller.Dashboard;
import controller.ShowBooks;
import global.Username;
import dao.SachDAO;
import java.awt.BorderLayout;
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
import javax.swing.JInternalFrame;
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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import static analysService.BarChart.createChart;
import controller.Constraint;
import controller.InsertBookController;
import java.awt.Point;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class Home extends javax.swing.JFrame {

    DefaultTableModel SachTableModel, SachMuonTableModel;
    List<String> listSachMuon = new ArrayList<>();
    List<Integer> listSoLuongMuon = new ArrayList<>();

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
//        ShowBook();
        ShowBookOnCombobox();
        // Add placeholder
        AddPlaceHolderStyle(txtSearchBook);
        AddPlaceHolderStyle(txtSearchDocGia);
        // Add style for table
        AddTableStyle(tbl_Sach);
        AddTableStyle(tbl_DocGia);
        AddTableStyle(tbl_PhieuMuon);
        SetTableHeaderStyle();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/logo.png")));
        setVisibleFalse();
        Home.setVisible(true);
        getViTri();
    }

//    public void showPieChart() {
//
//        //create dataset
//        DefaultPieDataset barDataset = new DefaultPieDataset();
//        barDataset.setValue("IPhone 5s", new Double(20));
//        barDataset.setValue("SamSung Grand", new Double(20));
//        barDataset.setValue("MotoG", new Double(40));
//        barDataset.setValue("Nokia Lumia", new Double(10));
//
//        //create chart
//        JFreeChart piechart = ChartFactory.createPieChart("mobile sales", barDataset, false, true, false);//explain
//
//        PiePlot piePlot = (PiePlot) piechart.getPlot();
//
//        //changing pie chart blocks colors
//        piePlot.setSectionPaint("IPhone 5s", new Color(255, 255, 102));
//        piePlot.setSectionPaint("SamSung Grand", new Color(102, 255, 102));
//        piePlot.setSectionPaint("MotoG", new Color(255, 102, 153));
//        piePlot.setSectionPaint("Nokia Lumia", new Color(0, 204, 204));
//
//        piePlot.setBackgroundPaint(Color.white);
//
//        //create chartPanel to display chart(graph)
//        ChartPanel barChartPanel = new ChartPanel(piechart);
//        panelBarChart.removeAll();
//        panelBarChart.add(barChartPanel, BorderLayout.CENTER);
//        panelBarChart.validate();
//    }

    /*=============================================================================*/
//    public void showLineChart() {
//        //create dataset for the graph
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        dataset.setValue(200, "Amoun", "january");
//        dataset.setValue(150, "Amoun", "february");
//        dataset.setValue(18, "Amount", "march");
//        dataset.setValue(100, "Amount", "april");
//        dataset.setValue(80, "Amount", "may");
//        dataset.setValue(250, "Amount", "june");
//
//        //create chart
//        JFreeChart linechart = ChartFactory.createLineChart("contribution", "monthly", "amount",
//                dataset, PlotOrientation.VERTICAL, false, true, false);
//
//        //create plot object
//        CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
//        // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
//        lineCategoryPlot.setBackgroundPaint(Color.white);
//
//        //create render object to change the moficy the line properties like color
//        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
//        Color lineChartColor = new Color(204, 0, 51);
//        lineRenderer.setSeriesPaint(0, lineChartColor);
//
//        //create chartPanel to display chart(graph)
//        ChartPanel lineChartPanel = new ChartPanel(linechart);
//        
//        panelBarChart.add(lineChartPanel, BorderLayout.CENTER);
//        panelBarChart.validate();
//    }

    /*========================================================================================*/
//    public void showHistogram() {
//
//        double[] values = {95, 49, 14, 59, 50, 66, 47, 40, 1, 67,
//            12, 58, 28, 63, 14, 9, 31, 17, 94, 71,
//            49, 64, 73, 97, 15, 63, 10, 12, 31, 62,
//            93, 49, 74, 90, 59, 14, 15, 88, 26, 57,
//            77, 44, 58, 91, 10, 67, 57, 19, 88, 84
//        };
//
//        HistogramDataset dataset = new HistogramDataset();
//        dataset.addSeries("key", values, 20);
//
//        JFreeChart chart = ChartFactory.createHistogram("JFreeChart Histogram", "Data", "Frequency", dataset, PlotOrientation.VERTICAL, false, true, false);
//        XYPlot plot = chart.getXYPlot();
//        plot.setBackgroundPaint(Color.WHITE);
//
//        ChartPanel barpChartPanel2 = new ChartPanel(chart);
//        jPanel3.removeAll();
//        jPanel3.add(barpChartPanel2, BorderLayout.CENTER);
//        jPanel3.validate();
//    }

    /*========================================================================================*/
//    public void showBarChart() {
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        dataset.setValue(200, "Amount", "january");
//        dataset.setValue(150, "Amount", "february");
//        dataset.setValue(18, "Amount", "march");
//        dataset.setValue(100, "Amount", "april");
//        dataset.setValue(80, "Amount", "may");
//        dataset.setValue(250, "Amount", "june");
//
//        JFreeChart chart = ChartFactory.createBarChart("contribution", "monthly", "amount",
//                dataset, PlotOrientation.VERTICAL, false, true, false);
//
//        CategoryPlot categoryPlot = chart.getCategoryPlot();
//        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
//        categoryPlot.setBackgroundPaint(Color.WHITE);
//        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
//        Color clr3 = new Color(204, 0, 51);
//        renderer.setSeriesPaint(0, clr3);
//
//        ChartPanel barpChartPanel = new ChartPanel(chart);
//        panelBarChart.removeAll();
//        panelBarChart.add(barpChartPanel, BorderLayout.CENTER);
//        panelBarChart.validate();
//
//    }
    public void AddTableStyle(JTable table) {
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
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

//    public void ShowBook() {
//        List<Sach> listSach = SachDAO.getInstant().selectAll();
//        SachTableModel.setRowCount(0);
//        listSach.forEach((sach) -> {
//            SachTableModel.addRow(new Object[]{sach.getId(),
//                sach.getTenSach(), sach.getTheLoai(), sach.getTacGia(), sach.getNamXB(),
//                sach.getNhaXB(), sach.getSoLuong(), sach.getGiaSach()});
//        });
//        
//    }
    public void ShowBookOnCombobox() {
        List<Sach> listSach = SachDAO.getInstant().selectAll();
        listSach.forEach((sach) -> {
            cbx_Books.addItem("" + String.valueOf(sach.getId()) + " | " + sach.getTenSach());
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
        rightPanelThongke = new javax.swing.JPanel();
        DashbroadOnTop = new javax.swing.JPanel();
        btn_moreInfoBook = new javax.swing.JLabel();
        btn_moreInfoPM = new javax.swing.JLabel();
        btn_moreInfoDocGia = new javax.swing.JLabel();
        lb_tongSachCon = new javax.swing.JLabel();
        lb_tongNguoiMuon = new javax.swing.JLabel();
        lb_tongSachDuocMuon = new javax.swing.JLabel();
        img_dashbroard = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanelForBarChart = new javax.swing.JPanel();
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
        btn_reseBook = new javax.swing.JButton();
        btn_delBook = new javax.swing.JButton();
        btn_insertBook = new javax.swing.JButton();
        lb_SortBy = new javax.swing.JLabel();
        cbxSortBook = new javax.swing.JComboBox<>();
        SearchBook = new javax.swing.JPanel();
        txtSearchBook = new javax.swing.JTextField();
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
        btn_resetDocGia = new javax.swing.JButton();
        rdNu = new javax.swing.JRadioButton();
        rdNam = new javax.swing.JRadioButton();
        rightPanelPhieuMuon = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_PhieuMuon = new javax.swing.JTable();
        cbx_Books = new javax.swing.JComboBox<>();
        lb_chooseBook = new javax.swing.JLabel();
        lb_search = new javax.swing.JLabel();
        lb_IdBook1 = new javax.swing.JLabel();
        txtNgayMuon = new javax.swing.JTextField();
        lb_IdBook4 = new javax.swing.JLabel();
        txtMaPhieuMuon = new javax.swing.JTextField();
        lb_IdBook2 = new javax.swing.JLabel();
        txtIdBook2 = new javax.swing.JTextField();
        btn_insertBook2 = new javax.swing.JButton();
        btm_editBook1 = new javax.swing.JButton();
        btn_delBook2 = new javax.swing.JButton();
        lb_IdBook5 = new javax.swing.JLabel();
        txtNgayMuon1 = new javax.swing.JTextField();
        btn_resetPM = new javax.swing.JButton();
        panel_sachMuon = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        lablelTongSach = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_sachMuon = new javax.swing.JTable();
        btn_save = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home - Library Management System");
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
        DashbroadOnTop.add(btn_moreInfoDocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, 110, 20));

        lb_tongSachCon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lb_tongSachCon.setForeground(new java.awt.Color(255, 255, 255));
        lb_tongSachCon.setText("100");
        DashbroadOnTop.add(lb_tongSachCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 200, 120));

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
        jPanelForBarChart.setPreferredSize(new java.awt.Dimension(850, 450));

        javax.swing.GroupLayout jPanelForBarChartLayout = new javax.swing.GroupLayout(jPanelForBarChart);
        jPanelForBarChart.setLayout(jPanelForBarChartLayout);
        jPanelForBarChartLayout.setHorizontalGroup(
            jPanelForBarChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        jPanelForBarChartLayout.setVerticalGroup(
            jPanelForBarChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout rightPanelThongkeLayout = new javax.swing.GroupLayout(rightPanelThongke);
        rightPanelThongke.setLayout(rightPanelThongkeLayout);
        rightPanelThongkeLayout.setHorizontalGroup(
            rightPanelThongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelThongkeLayout.createSequentialGroup()
                .addGroup(rightPanelThongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DashbroadOnTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rightPanelThongkeLayout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jPanelForBarChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141)
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
                        .addComponent(jPanelForBarChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        rightPanelSach.setBackground(new java.awt.Color(242, 247, 251));

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
        tbl_Sach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Sach);
        if (tbl_Sach.getColumnModel().getColumnCount() > 0) {
            tbl_Sach.getColumnModel().getColumn(0).setMinWidth(15);
            tbl_Sach.getColumnModel().getColumn(1).setMinWidth(230);
        }

        btm_editBook.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btm_editBook.setText("Update");
        btm_editBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btm_editBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btm_editBookActionPerformed(evt);
            }
        });

        lb_IdBook.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_IdBook.setText("Mã sách");

        txtBookName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBookName.setHorizontalAlignment(javax.swing.JTextField.LEFT);

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
        txtAuthor.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        lb_publisher.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_publisher.setText("Nhà xuất bản");

        txtPublisher.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPublisher.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        lb_publishYear.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_publishYear.setText("Năm xuất bản");

        txtPublishYear.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtPublishYear.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        lb_bookQuantity.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_bookQuantity.setText("Số lượng");

        lb_typeOfBook.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_typeOfBook.setText("Thể loại");

        txtTypeOfBook.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTypeOfBook.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        lb_price.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_price.setText("Giá");

        txtPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPrice.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        spiner_bookQuantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        spiner_bookQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spiner_bookQuantity.setPreferredSize(new java.awt.Dimension(60, 26));

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

        btn_delBook.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_delBook.setText("Delete");
        btn_delBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_delBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delBookActionPerformed(evt);
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

        javax.swing.GroupLayout rightPanelSachLayout = new javax.swing.GroupLayout(rightPanelSach);
        rightPanelSach.setLayout(rightPanelSachLayout);
        rightPanelSachLayout.setHorizontalGroup(
            rightPanelSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelSachLayout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(SearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(rightPanelSachLayout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(lb_IdBook, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(txtIdBook, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161)
                .addComponent(lb_publishYear)
                .addGap(90, 90, 90)
                .addComponent(txtPublishYear, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(rightPanelSachLayout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(lb_bookName, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(txtBookName, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161)
                .addComponent(lb_bookQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(spiner_bookQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(rightPanelSachLayout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(lb_author, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161)
                .addComponent(lb_typeOfBook, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(txtTypeOfBook, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(rightPanelSachLayout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(lb_publisher, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161)
                .addComponent(lb_price, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(rightPanelSachLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(btn_insertBook, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(btm_editBook, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(btn_delBook, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(btn_reseBook, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(lb_SortBy)
                .addGap(42, 42, 42)
                .addComponent(cbxSortBook, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1190, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        rightPanelSachLayout.setVerticalGroup(
            rightPanelSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelSachLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(SearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(rightPanelSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightPanelSachLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lb_IdBook))
                    .addComponent(txtIdBook, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rightPanelSachLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lb_publishYear))
                    .addComponent(txtPublishYear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(50, 50, 50)
                .addGroup(rightPanelSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_insertBook, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btm_editBook, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delBook, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reseBook, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rightPanelSachLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lb_SortBy))
                    .addGroup(rightPanelSachLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(cbxSortBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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

        btm_editDocGia.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btm_editDocGia.setText("Update");
        btm_editDocGia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btm_editDocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btm_editDocGiaActionPerformed(evt);
            }
        });

        lb_IdDocGia.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_IdDocGia.setText("Mã độc giả");

        txtTenDocGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lb_TenDocGia.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_TenDocGia.setText("Họ và tên");

        txtIdDocGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lb_gender.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_gender.setText("Giới tính");

        lb_ngaySinh.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_ngaySinh.setText("Ngày sinh");

        txtNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lb_cccd.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_cccd.setText("Số CCCD");

        txtCCCD.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        lb_bookQuantity1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_bookQuantity1.setText("Số điện thoại");

        lb_email.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_email.setText("Email");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        btn_delBook1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_delBook1.setText("Delete");
        btn_delBook1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn_insertBook1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_insertBook1.setText("Insert");
        btn_insertBook1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_insertBook1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertBook1ActionPerformed(evt);
            }
        });

        lb_SortBy1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_SortBy1.setText("Sắp xếp theo: ");

        cbxSortDocGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxSortDocGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã", "Tên", "Giới tính" }));

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

        rdNu.setBackground(new java.awt.Color(242, 247, 251));
        buttonGroupGender.add(rdNu);
        rdNu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdNu.setText("Nữ");

        rdNam.setBackground(new java.awt.Color(242, 247, 251));
        buttonGroupGender.add(rdNam);
        rdNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdNam.setSelected(true);
        rdNam.setText("Nam");

        javax.swing.GroupLayout rightPanelDocGiaLayout = new javax.swing.GroupLayout(rightPanelDocGia);
        rightPanelDocGia.setLayout(rightPanelDocGiaLayout);
        rightPanelDocGiaLayout.setHorizontalGroup(
            rightPanelDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelDocGiaLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(SearchDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(rightPanelDocGiaLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(lb_IdDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtIdDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165)
                .addComponent(lb_cccd)
                .addGap(127, 127, 127)
                .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1190, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(rightPanelDocGiaLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(btn_insertBook1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(rightPanelDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rightPanelDocGiaLayout.createSequentialGroup()
                        .addComponent(btm_editDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(btn_delBook1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(btn_resetDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(lb_SortBy1)
                        .addGap(14, 14, 14)
                        .addComponent(cbxSortDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(rightPanelDocGiaLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addGroup(rightPanelDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightPanelDocGiaLayout.createSequentialGroup()
                        .addComponent(lb_TenDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rightPanelDocGiaLayout.createSequentialGroup()
                        .addGroup(rightPanelDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdNam, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(rdNu, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(165, 165, 165)
                .addGroup(rightPanelDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_bookQuantity1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_email, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addGroup(rightPanelDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        rightPanelDocGiaLayout.setVerticalGroup(
            rightPanelDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelDocGiaLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(SearchDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(rightPanelDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightPanelDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_IdDocGia))
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rightPanelDocGiaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lb_cccd)))
                .addGap(18, 18, 18)
                .addGroup(rightPanelDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightPanelDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTenDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_TenDocGia))
                    .addComponent(lb_bookQuantity1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(rightPanelDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightPanelDocGiaLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(rightPanelDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rightPanelDocGiaLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(rightPanelDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdNam, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(rdNu, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(rightPanelDocGiaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(rightPanelDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))))
                .addGroup(rightPanelDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_ngaySinh))
                .addGap(48, 48, 48)
                .addGroup(rightPanelDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_insertBook1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btm_editDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delBook1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_resetDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rightPanelDocGiaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(rightPanelDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_SortBy1)
                            .addComponent(cbxSortDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        rightPanelPhieuMuon.setBackground(new java.awt.Color(242, 247, 251));
        rightPanelPhieuMuon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_PhieuMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã PM", "Mã độc giả", "Ngày mượn", "Ngày hẹn trả", "Sách mượn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
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

        rightPanelPhieuMuon.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 419, 1190, 390));

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
        rightPanelPhieuMuon.add(cbx_Books, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 220, 360, 30));

        lb_chooseBook.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_chooseBook.setText("Chọn sách");
        rightPanelPhieuMuon.add(lb_chooseBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 80, 30));
        rightPanelPhieuMuon.add(lb_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 20, 20));

        lb_IdBook1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_IdBook1.setText("Mã PM");
        rightPanelPhieuMuon.add(lb_IdBook1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 70, -1));

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
        rightPanelPhieuMuon.add(txtNgayMuon, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 195, 32));

        lb_IdBook4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_IdBook4.setText("Ngày Mượn");
        rightPanelPhieuMuon.add(lb_IdBook4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 90, 30));

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
        lb_IdBook2.setText("Mã ĐG");
        rightPanelPhieuMuon.add(lb_IdBook2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 80, -1));

        txtIdBook2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIdBook2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdBook2ActionPerformed(evt);
            }
        });
        rightPanelPhieuMuon.add(txtIdBook2, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 146, 195, 32));

        btn_insertBook2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_insertBook2.setText("Insert");
        btn_insertBook2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_insertBook2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertBook2ActionPerformed(evt);
            }
        });
        rightPanelPhieuMuon.add(btn_insertBook2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 108, 39));

        btm_editBook1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btm_editBook1.setText("Update");
        btm_editBook1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rightPanelPhieuMuon.add(btm_editBook1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 108, 39));

        btn_delBook2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_delBook2.setText("Delete");
        btn_delBook2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_delBook2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delBook2ActionPerformed(evt);
            }
        });
        rightPanelPhieuMuon.add(btn_delBook2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 108, 39));

        lb_IdBook5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_IdBook5.setText("Ngày hẹn trả");
        rightPanelPhieuMuon.add(lb_IdBook5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, -1, 30));

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
        rightPanelPhieuMuon.add(txtNgayMuon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 195, 32));

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
        lablelTongSach.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lablelTongSach.setText("Tổng số sách mượn: ");
        panel_sachMuon.add(lablelTongSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 380, 360, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thông tin sách mượn");
        panel_sachMuon.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 14, 390, -1));

        tbl_sachMuon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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
        tbl_sachMuon.setGridColor(new java.awt.Color(51, 51, 51));
        tbl_sachMuon.setPreferredSize(new java.awt.Dimension(500, 300));
        tbl_sachMuon.setSelectionBackground(new java.awt.Color(0, 204, 102));
        tbl_sachMuon.setShowGrid(false);
        tbl_sachMuon.setShowHorizontalLines(true);
        tbl_sachMuon.setShowVerticalLines(true);
        tbl_sachMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sachMuonMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_sachMuon);
        if (tbl_sachMuon.getColumnModel().getColumnCount() > 0) {
            tbl_sachMuon.getColumnModel().getColumn(0).setPreferredWidth(455);
        }
        tbl_sachMuon.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));

        panel_sachMuon.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 370, 310));

        btn_save.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_save.setText("Save");
        btn_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        panel_sachMuon.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, 80, 30));

        rightPanelPhieuMuon.add(panel_sachMuon, new org.netbeans.lib.awtextra.AbsoluteConstraints(799, 2, 388, 416));
        panel_sachMuon.setVisible(false);

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
            .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(about_us, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(rightPanelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(rightPanelThongke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(rightPanelSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(rightPanelDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(rightPanelPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    }//GEN-LAST:event_lb_QuanLySachMouseClicked

    private void lb_QuanLyDocGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_QuanLyDocGiaMouseClicked
        this.setTitle("Readers - Library Management System");
        setVisibleFalse();
        rightPanelDocGia.setVisible(true);
        resetFontColor();
        lb_QuanLyDocGia.setForeground(Color.BLACK);
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
    }//GEN-LAST:event_lb_PhieuMuonMouseClicked

    private void lb_ThongKeBaoCaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ThongKeBaoCaoMouseClicked
        this.setTitle("Analysis - Library Management System");
        setVisibleFalse();
        rightPanelThongke.setVisible(true);
        resetFontColor();
        lb_ThongKeBaoCao.setForeground(Color.BLACK);
        Dashboard ds = new Dashboard();
        lb_tongSachCon.setText("" + ds.TongSachCon());
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
        pnl_ThongTin.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_lb_infoMouseEntered

    private void lb_infoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_infoMouseExited
        pnl_ThongTin.setBackground(new Color(0, 153, 153));
    }//GEN-LAST:event_lb_infoMouseExited

    private void btn_delBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_delBookActionPerformed

    private void btm_editBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btm_editBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btm_editBookActionPerformed

    private void btn_reseBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reseBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_reseBookActionPerformed

    private void btn_resetDocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetDocGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_resetDocGiaActionPerformed

    private void btm_editDocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btm_editDocGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btm_editDocGiaActionPerformed

    private void btn_resetPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetPMActionPerformed
        Component[] children = rightPanelPhieuMuon.getComponents();
        for (int i = 0, j = 1; i < children.length; i++) {
            if (children[i] instanceof JTextField) {
                ((JTextField) children[i]).setText("");
            }
        }
        listSachMuon.clear();
        listSoLuongMuon.clear();
        panel_sachMuon.setVisible(false);
    }//GEN-LAST:event_btn_resetPMActionPerformed

    private void btn_delBook2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delBook2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_delBook2ActionPerformed

    private void btn_reseBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reseBookMouseClicked
        Component[] children = rightPanelSach.getComponents();
        for (int i = 0, j = 1; i < children.length; i++) {
            if (children[i] instanceof JTextField) {
                ((JTextField) children[i]).setText("");
            }
        }
        spiner_bookQuantity.setValue(0);
        txtSearchBook.setText("");
        ShowBooks.getInstance().ShowOnTblSach(SachTableModel);
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
        Component[] children = rightPanelDocGia.getComponents();
        for (int i = 0, j = 1; i < children.length; i++) {
            if (children[i] instanceof JTextField) {
                ((JTextField) children[i]).setText("");
            }
        }
        buttonGroupGender.clearSelection();
    }//GEN-LAST:event_btn_resetDocGiaMouseClicked

    private void cbx_BooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_BooksActionPerformed
        boolean check = true;
        if (cbx_Books.getSelectedIndex() == 0) {
            check = false;
        }
        Object item = cbx_Books.getItemAt(cbx_Books.getSelectedIndex());
        System.out.println("Bạn vừa chọn vị trí: " + cbx_Books.getSelectedIndex());
        for (String string : listSachMuon) {
            if (string == (item)) {
                check = false;
            }
        }
        String c = null;
        if (check == true) {
            c = JOptionPane.showInputDialog(rightPanelPhieuMuon, "Nhập số lượng sách: " + item.toString(), "0");

        }
        while (!c.matches("\\d+")) {
            JOptionPane.showMessageDialog(rightPanelPhieuMuon, "Chỉ nhập số!!!");
            c = JOptionPane.showInputDialog(rightPanelPhieuMuon, "Nhập số lượng sách: " + item.toString(), "0");
        }
        if (check == true) {
            listSachMuon.add((String) item);
            listSoLuongMuon.add(Integer.parseInt(c));
            panel_sachMuon.setVisible(true);
        }
        SachMuonTableModel.setRowCount(0);
        listSachMuon.forEach((list) -> {
            SachMuonTableModel.addRow(new Object[]{list, listSoLuongMuon.get(listSachMuon.indexOf(list))});
        });
        lablelTongSach.setText("Tổng số sách: " + TongSachMuon());
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

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        listSoLuongMuon.clear();
        for (int i = 0; i < SachMuonTableModel.getRowCount(); i++) {
            int num = (int) SachMuonTableModel.getValueAt(i, 1);
            listSoLuongMuon.add(num);
        }
        // Check listSoLMuon
        for (Integer integer : listSoLuongMuon) {
            System.out.println(integer);
        }
        // Update Table 
        for (int i = 0; i < SachMuonTableModel.getRowCount(); i++) {
            SachMuonTableModel.setValueAt(listSoLuongMuon.get(i), i, 1);
        }

    }//GEN-LAST:event_btn_saveActionPerformed

    private void tbl_sachMuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sachMuonMouseClicked

//        int row = tbl_sachMuon.rowAtPoint(evt.getPoint());
//        int col = tbl_sachMuon.columnAtPoint(evt.getPoint());
//        if (row >= 0 && col >= col) {
//            JOptionPane.showMessageDialog(this, "Row = " + row + "Col = " + col);
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
        txtBookName.setText(name);
        txtTypeOfBook.setText(theloai);
        txtAuthor.setText(tacgia);
        txtPublishYear.setText(namxb);
        txtPublisher.setText(nhaxb);
        spiner_bookQuantity.setValue(soluong);
        txtPrice.setText(gia);
    }//GEN-LAST:event_tbl_SachMouseClicked

    private void txtSearchBookKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBookKeyReleased
        if (txtSearchBook.getText() != null) {
            ArrayList<Sach> listBookSearched = SachDAO.getInstant().Search(txtSearchBook.getText());
            ShowBooks.getInstance().ShowOnTblSachWhileSearching(listBookSearched, SachTableModel);
        }
    }//GEN-LAST:event_txtSearchBookKeyReleased

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btn_moreInfoBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_moreInfoBookMouseClicked
        this.setTitle("Books - Library Management System");
        setVisibleFalse();
        rightPanelSach.setVisible(true);
        ShowBooks show = new ShowBooks();
        show.ShowOnTblSach(SachTableModel);
    }//GEN-LAST:event_btn_moreInfoBookMouseClicked

    private void btn_moreInfoPMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_moreInfoPMMouseClicked
        BarChart.Show(jPanelForBarChart);
    }//GEN-LAST:event_btn_moreInfoPMMouseClicked

    private void formAncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorMoved

    }//GEN-LAST:event_formAncestorMoved

    private void rightPanelThongkeAncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_rightPanelThongkeAncestorMoved

    }//GEN-LAST:event_rightPanelThongkeAncestorMoved

    private void btn_insertBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_insertBookMouseClicked
        Constraint st = new Constraint(this);
        if (st.SachValidate() == true) {
            InsertBookController ins = new InsertBookController(this);
            ins.Insert();
        }
    }//GEN-LAST:event_btn_insertBookMouseClicked

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
        return SachTableModel;
    }

    public void getViTri() {
        System.out.println(this.getLocation());
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

    public JButton getBtm_editBook1() {
        return btm_editBook1;
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

    public JLabel getBtn_requestDemo() {
        return btn_requestDemo;
    }

    public JButton getBtn_reseBook() {
        return btn_reseBook;
    }

    public JButton getBtn_resetDocGia() {
        return btn_resetDocGia;
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

    public JTextField getTxtNgayMuon() {
        return txtNgayMuon;
    }

    public JTextField getTxtNgayMuon1() {
        return txtNgayMuon1;
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

    public DefaultTableModel getSachMuonTableModel() {
        return SachMuonTableModel;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DashbroadOnTop;
    private javax.swing.JLabel HeadingHome;
    private javax.swing.JPanel Home;
    private javax.swing.JPanel SearchBook;
    private javax.swing.JPanel SearchDocGia;
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
    private javax.swing.JButton btm_editBook1;
    private javax.swing.JButton btm_editDocGia;
    private javax.swing.JLabel btn_contact;
    private javax.swing.JButton btn_delBook;
    private javax.swing.JButton btn_delBook1;
    private javax.swing.JButton btn_delBook2;
    private javax.swing.JLabel btn_github;
    private javax.swing.JLabel btn_hieu;
    private javax.swing.JLabel btn_hung;
    private javax.swing.JButton btn_insertBook;
    private javax.swing.JButton btn_insertBook1;
    private javax.swing.JButton btn_insertBook2;
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
    private javax.swing.JLabel btn_thuan;
    private javax.swing.JLabel btn_vanh;
    private javax.swing.ButtonGroup buttonGroupGender;
    private javax.swing.JComboBox<String> cbxSortBook;
    private javax.swing.JComboBox<String> cbxSortDocGia;
    private javax.swing.JComboBox<String> cbx_Books;
    private javax.swing.JLabel copyright;
    private javax.swing.JLabel img_dashbroard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanelForBarChart;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
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
    private javax.swing.JLabel lb_chooseBook;
    private javax.swing.JLabel lb_email;
    private javax.swing.JLabel lb_footer;
    private javax.swing.JLabel lb_gender;
    private javax.swing.JLabel lb_info;
    private javax.swing.JLabel lb_ngaySinh;
    private javax.swing.JLabel lb_price;
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
    private javax.swing.JPanel panel_sachMuon;
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
    private javax.swing.JTable tbl_Sach;
    private javax.swing.JTable tbl_sachMuon;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtBookName;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtEmail;
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
