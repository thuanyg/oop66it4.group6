/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analysService;

import database.JDBCUtil;
import java.awt.Point;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import view.Home;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class BarChart {

    private Home home;

    public static JFreeChart createChart() {
        JFreeChart barChart = ChartFactory.createBarChart(
                "BIỂU ĐỒ SỐ LƯỢNG ĐỘC GIẢ THEO THỜI GIAN",
                "Tháng", "Số người mượn",
                createDataset(), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }

    private static CategoryDataset createDataset() {
        ArrayList<PhieuMuonBean> dates = new ArrayList<>();
        Connection connection = null;
        try {
            connection = JDBCUtil.getConnection();
            PreparedStatement pst = connection.prepareStatement(" Select Ngay_Muon, COUNT(*) as 'sol' From Phieu_Muon Group by Ngay_Muon");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String date = rs.getString("Ngay_Muon") == null ? "No have" : rs.getString("Ngay_Muon");
                int sl = rs.getInt("sol");
                PhieuMuonBean pm = new PhieuMuonBean(date, sl);
                dates.add(pm);
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0;dates.size() != 0 && i < dates.size(); i++) {
            System.out.println(dates.get(i).getDate());
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
