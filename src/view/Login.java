/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.Validation;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/logo.png")));
//        txtUsername.setBackground(new Color(0, 0, 0, 1));
//        txtPassword.setBackground(new Color(0, 0, 0, 1));
        txtUsername.setBorder(BorderFactory.createCompoundBorder(
                txtUsername.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        txtPassword.setBorder(BorderFactory.createCompoundBorder(
                txtPassword.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        txtPassword.setEchoChar('\u25CF');
        iconHide.setVisible(false);
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
        RightPanel = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnExitLogin = new javax.swing.JLabel();
        HeadingLogin = new javax.swing.JLabel();
        lb_Register = new javax.swing.JLabel();
        lbCreateAcc = new javax.swing.JLabel();
        lbPass = new javax.swing.JLabel();
        lbtemp1 = new javax.swing.JLabel();
        lbtemp2 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        lbUser = new javax.swing.JLabel();
        iconUser24 = new javax.swing.JLabel();
        iconEye24 = new javax.swing.JLabel();
        iconHide = new javax.swing.JLabel();
        errorPassword = new javax.swing.JLabel();
        errorUsername = new javax.swing.JLabel();
        AroundBG2 = new javax.swing.JLabel();
        LeftPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        AroundBG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login - LMS");
        setUndecorated(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        BackgroundPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BackgroundPanelKeyPressed(evt);
            }
        });
        BackgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RightPanel.setBackground(new java.awt.Color(255, 255, 255));
        RightPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsername.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(0, 204, 51));
        txtUsername.setActionCommand("<Not Set>");
        txtUsername.setBorder(null);
        txtUsername.setDisabledTextColor(new java.awt.Color(255, 102, 102));
        txtUsername.setOpaque(true);
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameKeyPressed(evt);
            }
        });
        RightPanel.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 310, 30));

        txtPassword.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(0, 204, 0));
        txtPassword.setBorder(null);
        txtPassword.setEchoChar('\'');
        txtPassword.setOpaque(true);
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });
        RightPanel.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 310, 30));

        btnExitLogin.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnExitLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnExitLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExitLogin.setText("x");
        btnExitLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExitLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitLoginMouseClicked(evt);
            }
        });
        RightPanel.add(btnExitLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, -10, 30, 40));

        HeadingLogin.setFont(new java.awt.Font("Segoe UI", 1, 45)); // NOI18N
        HeadingLogin.setForeground(new java.awt.Color(255, 255, 255));
        HeadingLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HeadingLogin.setText("Login");
        RightPanel.add(HeadingLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 400, -1));

        lb_Register.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        lb_Register.setForeground(new java.awt.Color(0, 0, 255));
        lb_Register.setText("Create an account.");
        lb_Register.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_Register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_RegisterMouseClicked(evt);
            }
        });
        RightPanel.add(lb_Register, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 510, 150, -1));

        lbCreateAcc.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        lbCreateAcc.setForeground(new java.awt.Color(255, 255, 255));
        lbCreateAcc.setText("New to LMS?");
        RightPanel.add(lbCreateAcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 510, 110, -1));

        lbPass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbPass.setForeground(new java.awt.Color(255, 255, 255));
        lbPass.setText("Password");
        RightPanel.add(lbPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 370, -1));

        lbtemp1.setForeground(new java.awt.Color(255, 255, 255));
        lbtemp1.setText("____________________________________________");
        RightPanel.add(lbtemp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 340, 30));

        lbtemp2.setForeground(new java.awt.Color(255, 255, 255));
        lbtemp2.setText("____________________________________________");
        RightPanel.add(lbtemp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 350, 30));

        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(0, 204, 51));
        btnLogin.setText("LOGIN");
        btnLogin.setBorder(null);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        RightPanel.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 330, 60));

        lbUser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbUser.setForeground(new java.awt.Color(255, 255, 255));
        lbUser.setText("Username");
        RightPanel.add(lbUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 370, -1));

        iconUser24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/eye-2-24.png"))); // NOI18N
        iconUser24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconUser24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconUser24MouseClicked(evt);
            }
        });
        RightPanel.add(iconUser24, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 30, 30));

        iconEye24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/user-24.png"))); // NOI18N
        RightPanel.add(iconEye24, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 30, 30));

        iconHide.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        iconHide.setForeground(new java.awt.Color(255, 255, 255));
        iconHide.setText("/");
        iconHide.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RightPanel.add(iconHide, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 315, 30, 30));

        errorPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        errorPassword.setForeground(new java.awt.Color(255, 0, 0));
        RightPanel.add(errorPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 330, 30));

        errorUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        errorUsername.setForeground(new java.awt.Color(255, 0, 0));
        RightPanel.add(errorUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 330, 30));

        AroundBG2.setBackground(new java.awt.Color(204, 255, 204));
        AroundBG2.setForeground(new java.awt.Color(204, 255, 204));
        AroundBG2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Magic.jpg"))); // NOI18N
        RightPanel.add(AroundBG2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 0, -1, -1));

        BackgroundPanel.add(RightPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 410, 600));

        LeftPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Welcome to the library management system");
        LeftPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 500, 110));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Escaping...");
        LeftPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 550, -1, -1));
        jLabel2.setVisible(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Please login to continue using");
        LeftPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 490, -1, -1));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/loginSystemBG (1) (1).jpg"))); // NOI18N
        LeftPanel.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 400, 510));

        AroundBG.setBackground(new java.awt.Color(255, 255, 255));
        AroundBG.setForeground(new java.awt.Color(255, 255, 255));
        AroundBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/white_BG.png"))); // NOI18N
        LeftPanel.add(AroundBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -4, 610, 610));

        BackgroundPanel.add(LeftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitLoginMouseClicked
         int c = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit the application?", "Exit", JOptionPane.YES_NO_OPTION);
        if (c == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnExitLoginMouseClicked

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void iconUser24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconUser24MouseClicked
        boolean isHide;
        if (txtPassword.getEchoChar() == '\u25CF') {
            isHide = true;
        } else {
            isHide = false;
        }
        if (isHide) {
            txtPassword.setEchoChar((char) 0);
            iconHide.setVisible(true);
        } else {
            txtPassword.setEchoChar('\u25CF');
            iconHide.setVisible(false);
        }

    }//GEN-LAST:event_iconUser24MouseClicked

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        ActionListener ac = new Validation(this);
        ac.actionPerformed(evt);
    }//GEN-LAST:event_btnLoginActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnLogin.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.dispose();;
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnLogin.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            int c = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit the application?","Exit", JOptionPane.YES_NO_OPTION);
            switch (c) {
                case 0:
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.dispose();
            }

        }
    }//GEN-LAST:event_txtUsernameKeyPressed

    private void BackgroundPanelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BackgroundPanelKeyPressed

    }//GEN-LAST:event_BackgroundPanelKeyPressed

    private void lb_RegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_RegisterMouseClicked
        this.dispose();
        Register reg = new Register();
        reg.setVisible(true);
    }//GEN-LAST:event_lb_RegisterMouseClicked

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
                if ("Nimbus".equals(info.getName())) {
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
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AroundBG;
    private javax.swing.JLabel AroundBG2;
    private javax.swing.JLabel Background;
    private javax.swing.JPanel BackgroundPanel;
    private javax.swing.JLabel HeadingLogin;
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JPanel RightPanel;
    private javax.swing.JLabel btnExitLogin;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel errorPassword;
    private javax.swing.JLabel errorUsername;
    private javax.swing.JLabel iconEye24;
    private javax.swing.JLabel iconHide;
    private javax.swing.JLabel iconUser24;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbCreateAcc;
    private javax.swing.JLabel lbPass;
    private javax.swing.JLabel lbUser;
    private javax.swing.JLabel lb_Register;
    private javax.swing.JLabel lbtemp1;
    private javax.swing.JLabel lbtemp2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    public JLabel getAroundBG() {
        return AroundBG;
    }

    public JLabel getAroundBG2() {
        return AroundBG2;
    }

    public JPanel getBackgroundPanel() {
        return BackgroundPanel;
    }

    public JLabel getHeadingLogin() {
        return HeadingLogin;
    }

    public JPanel getLeftPanel() {
        return LeftPanel;
    }

    public JPanel getRightPanel() {
        return RightPanel;
    }

    public JLabel getBtnExitLogin() {
        return btnExitLogin;
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JLabel getErrorPassword() {
        return errorPassword;
    }

    public JLabel getErrorUsername() {
        return errorUsername;
    }

    public JLabel getIconEye24() {
        return iconEye24;
    }

    public JLabel getIconHide() {
        return iconHide;
    }

    public JLabel getIconUser24() {
        return iconUser24;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public JLabel getLbPass() {
        return lbPass;
    }

    public JLabel getLbUser() {
        return lbUser;
    }

    public JLabel getLbtemp1() {
        return lbtemp1;
    }

    public JLabel getLbtemp2() {
        return lbtemp2;
    }

    public JPasswordField getTxtPassword() {
        return txtPassword;
    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }
   
}
