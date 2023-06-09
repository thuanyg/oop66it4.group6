/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.desktop.SystemEventListener;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class SplashScreen extends javax.swing.JFrame {

    /**
     * Creates new form SplashScreen
     */
    public SplashScreen() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
        setIconApplication();
        initComponents();
    }

    public void setIconApplication() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/logo.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundPanel = new javax.swing.JPanel();
        version = new javax.swing.JLabel();
        heading = new javax.swing.JLabel();
        LibraryTeam = new javax.swing.JLabel();
        loadingBar = new javax.swing.JProgressBar();
        loadingValue = new javax.swing.JLabel();
        backgroundImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Launching...");
        setUndecorated(true);

        BackgroundPanel.setBackground(new java.awt.Color(255, 102, 102));
        BackgroundPanel.setPreferredSize(new java.awt.Dimension(900, 500));
        BackgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        version.setForeground(new java.awt.Color(255, 255, 255));
        version.setText("ver: 1.0");
        BackgroundPanel.add(version, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 470, 60, -1));

        heading.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        heading.setForeground(new java.awt.Color(255, 255, 255));
        heading.setText("Library Management System");
        BackgroundPanel.add(heading, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, -1, -1));

        LibraryTeam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/bgSpl.png"))); // NOI18N
        BackgroundPanel.add(LibraryTeam, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 490, 340));

        loadingBar.setBackground(new java.awt.Color(0, 153, 153));
        loadingBar.setForeground(new java.awt.Color(204, 204, 204));
        loadingBar.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        BackgroundPanel.add(loadingBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 488, 900, 20));

        loadingValue.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        loadingValue.setForeground(new java.awt.Color(255, 255, 255));
        loadingValue.setText("Loading...");
        BackgroundPanel.add(loadingValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 451, 270, 50));

        backgroundImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/splashBG.jpg"))); // NOI18N
        backgroundImage.setPreferredSize(new java.awt.Dimension(900, 500));
        BackgroundPanel.add(backgroundImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -7, 900, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException {
        SplashScreen mySplash = new SplashScreen();
        mySplash.setVisible(true);
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(25);
                mySplash.loadingValue.setText(i + "%");
                if (i == 10) {
                    mySplash.loadingValue.setText("Welcome!");
                }
                if (i == 20) {
                    mySplash.loadingValue.setText("Turning on modules...");
                }
                if (i == 50) {
                    mySplash.loadingValue.setText("Connecting to Database...");
                }
                if (i == 70) {
                    mySplash.loadingValue.setText("Connected Successful!");
                }
                if (i == 80) {
                    mySplash.loadingValue.setText("Launching Application...");
                }
                mySplash.loadingBar.setValue(i);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        mySplash.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        mySplash.loadingValue.setText("Please wait...");
        Thread.sleep(1500);
        mySplash.dispose();
        Login l = new Login();
        l.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackgroundPanel;
    private javax.swing.JLabel LibraryTeam;
    private javax.swing.JLabel backgroundImage;
    private javax.swing.JLabel heading;
    private javax.swing.JProgressBar loadingBar;
    private javax.swing.JLabel loadingValue;
    private javax.swing.JLabel version;
    // End of variables declaration//GEN-END:variables
}
