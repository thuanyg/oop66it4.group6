/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analysService;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import view.Home;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class Exam {

    private Home home;
    public Exam(Home home) {
        this.home=home;
    }
    
    public void createChartPanel() {
        // Tạo dữ liệu biểu đồ
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(5, "Series 1", "Category 1");
        dataset.setValue(10, "Series 1", "Category 2");
        dataset.setValue(8, "Series 1", "Category 3");
        dataset.setValue(12, "Series 1", "Category 4");
        dataset.setValue(6, "Series 1", "Category 5");

        // Tạo biểu đồ cột
        JFreeChart chart = ChartFactory.createBarChart(
                "Biểu đồ cột",      // Tiêu đề biểu đồ
                "Thể loại",         // Trục x
                "Giá trị",          // Trục y
                dataset,            // Dữ liệu biểu đồ
                PlotOrientation.VERTICAL,
                true,               // Hiển thị legend
                true,               // Hiển thị tooltips
                false               // Không hiển thị URLs
        );

        // Tạo JPanel chứa biểu đồ
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(300, 200));
        home.getjPanelForBarChart().add(chartPanel);
//        home.getjPanelForBarChart().setVisible(true);
    }
}
