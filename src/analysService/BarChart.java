/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analysService;

import controller.Validation;
import database.JDBCUtil;
import global.Username;
import java.awt.Cursor;
import java.awt.Point;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Hour;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class BarChart {

    public static Point location;

    public static JFreeChart createChart() {
        JFreeChart barChart = ChartFactory.createBarChart(
                "BIỂU ĐỒ SỐ LƯỢNG ĐỘC GIẢ THEO THỜI GIAN",
                "Tháng", "Số người mượn",
                createDataset(), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }

    private static CategoryDataset createDataset() {
        List<PhieuMuonBean> dates = new ArrayList<>();
        Connection connection = null;
        try {
            connection = JDBCUtil.getConnection();
            PreparedStatement pst = connection.prepareStatement(" Select Ngay_Muon, COUNT(*) as 'sol' From Phieu_Muon Group by Ngay_Muon");

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                PhieuMuonBean pm = new PhieuMuonBean();
                pm.setDate(rs.getString("Ngay_Muon"));
                pm.setSoluong(rs.getInt("sol"));
                dates.add(pm);
            }

//            PreparedStatement pst2 = connection.prepareStatement("SELECT COUNT(Ma_Doc_Gia) From Phieu_Muon WHERE Ngay_Muon = '"+ dates.get(0) +"'");
//            for (int i = 0; i < dates.size(); i++) {
//                PreparedStatement pst2 = connection.prepareStatement("SELECT COUNT(Ma_Doc_Gia) as 'soluong' From Phieu_Muon WHERE Ngay_Muon = '" + dates.get(i) + "'");
//                System.out.println("SELECT COUNT(Ma_Doc_Gia) as 'soluong' From Phieu_Muon WHERE Ngay_Muon = '" + dates.get(i) + "'");
//                ResultSet rs2 = pst.executeQuery();
//                
//            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < dates.size(); i++) {
            dataset.addValue(dates.get(i).getSoluong(), "Số người", dates.get(i).getDate());
        }

        return dataset;
    }

    public static void Show(JPanel root) {
        ChartPanel chartPanel = new ChartPanel(createChart());
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        JFrame h = new JFrame();
        h.add(chartPanel);
        h.setTitle("Biểu đồ số người mượn sách");
        h.setSize(900, 500);
        h.setResizable(false);
//        h.setUndecorated(true);
        h.setLocationRelativeTo(root);
        h.setVisible(true); 
    }
}
