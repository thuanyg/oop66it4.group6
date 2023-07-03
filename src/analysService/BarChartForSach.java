/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analysService;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class BarChartForSach {
    private Home home;

    public static JFreeChart createChart() {
        JFreeChart barChart = ChartFactory.createBarChart(
                "BIỂU ĐỒ SỐ LƯỢNG SÁCH THEO THỂ LOẠI",
                "Thể loại", "Số lượng",
                createDataset(), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }

    private static CategoryDataset createDataset() {
        ArrayList<SachBean> list = new ArrayList<>();
        Connection connection = null;
        try {
            connection = JDBCUtil.getConnection();
            PreparedStatement pst = connection.prepareStatement("SELECT SUM(SL) as 'soluong' , The_Loai FROM Sach GROUP BY The_Loai");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int soLuong = rs.getInt("soluong");
                String theLoai = rs.getString("The_Loai");
                SachBean sb = new SachBean(soLuong, theLoai);
                list.add(sb);
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; list.size() != 0 && i < list.size(); i++) {
            dataset.addValue(list.get(i).getSoL(), "Số lượng", list.get(i).getTheLoai());
        }

        return dataset;
    }

    public static void Show(JPanel root) {
        ChartPanel chartPanel = new ChartPanel(createChart());
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        JFrame h = new JFrame();
        h.add(chartPanel);
        h.setTitle("Biểu đồ số người mượn sách");
        h.setSize(1169, 759);
        h.setResizable(false);
//        h.setUndecorated(true);
        h.setLocationRelativeTo(root);
        h.setVisible(true);
    }
}
