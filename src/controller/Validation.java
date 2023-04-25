/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.JDBCUtil;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import model.Account;
import view.Home;
import view.Login;
import view.Register;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class Validation implements ActionListener, MouseListener, KeyListener {

    private Login login;
    private Register reg;

    public Validation(Login login) {
        this.login = login;
    }

    public Validation(Register reg) {
        this.reg = reg;
    }

    // ------------------------------------------------------------------------------------------------------------------
    // Validate for Login section
    @Override
    public void actionPerformed(ActionEvent e) {
        String txtUsername = login.getTxtUsername().getText();
        String txtPassword = new String(login.getTxtPassword().getPassword());
        boolean check_Username = txtUsername.trim().matches("[\\w\\d]+");
        boolean check = true;
        if (!check_Username) {
            login.getErrorUsername().setText("Invalid username!");
//            JOptionPane.showMessageDialog(, "Invalid username or password!!!", "Login failed", JOptionPane.ERROR_MESSAGE);
            check = false;
        } else {
            login.getErrorUsername().setText("");
        }
        if ("".equals(txtPassword)) {
            login.getErrorPassword().setText("You have not entered your password!");
//            JOptionPane.showMessageDialog(, "You have not entered your password!!!", "Login failed", JOptionPane.ERROR_MESSAGE);
            check = false;
        } else {
            login.getErrorPassword().setText("");
        }
        if (check == true) {
            try {
                Connection connection = JDBCUtil.getConnection();
                try {
                    if (connection == null) {
                        JOptionPane.showMessageDialog(reg, "Không thể kết nối đến Database");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(reg, "Không thể kết nối đến Database");
                    ex.printStackTrace();
                }
                PreparedStatement pst = connection.prepareStatement("Select * from Accounts where username=? and password=?");
                pst.setString(1, txtUsername.trim());
                pst.setString(2, login.getTxtPassword().getText());
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    try {
                        login.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Validation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    login.dispose();
                    Home home = new Home();
                    home.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(login, "Sai tài khoản hoặc mật khẩu!", "Login failed", JOptionPane.ERROR_MESSAGE);
                    check = false;
                    return;
                }
                JDBCUtil.closeConnection(connection);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(login, ex);
                ex.printStackTrace();
            }
            System.out.println("Login state: " + check + " Username:" + txtUsername + " Password:" + txtPassword);
        }

    }

    // Block 2 -------------------------------------------------------------------------------------------------------------------
    // Validate for Register
    @Override
    public void mouseClicked(MouseEvent e) {
        String txtUsername = reg.getTxtUsername().getText();
        String txtPassword = new String(reg.getTxtPassword().getPassword());
        boolean check_Username = txtUsername.trim().matches("[\\w\\d]+");
        boolean check = true;
        if (!check_Username) {
            reg.getErrorUsername().setText("Invalid username!");
            check = false;
        } else {
            reg.getErrorUsername().setText("");
        }
        if ("".equals(txtPassword)) {
            reg.getErrorPassword().setText("You have not entered your password!");
            check = false;
        } else {
            reg.getErrorPassword().setText("");
        }

        System.out.println(check);
        if (check == true) {
            try {
                Connection connection = JDBCUtil.getConnection();
                try {
                    if (connection == null) {
                        JOptionPane.showMessageDialog(reg, "Không thể kết nối đến Database");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(reg, "Không thể kết nối đến Database");
                    ex.printStackTrace();
                }
                Statement st = connection.createStatement();
                String sql = "INSERT INTO Accounts (username, password)"
                        + " VALUES ('" + reg.getTxtUsername().getText().trim() + "', '" + reg.getTxtPassword().getText() + "')";
                int ck = st.executeUpdate(sql);
                if (ck > 0) {
                    JOptionPane.showMessageDialog(reg, "Đăng ký thành công!");
                    try {
                        reg.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                        Thread.sleep(1500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Validation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    reg.dispose();
                    Login login = new Login();
                    login.setVisible(true);
                    System.out.println("Register state: " + check + " Username:" + txtUsername + " Password:" + txtPassword);
                }
                JDBCUtil.closeConnection(connection);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(reg, "Tài khoản đã tồn tại");
                ex.printStackTrace();
            }
            System.out.println("Register state: " + check + " Username:" + txtUsername + " Password:" + txtPassword);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            String txtUsername = reg.getTxtUsername().getText();
            String txtPassword = new String(reg.getTxtPassword().getPassword());
            boolean check_Username = txtUsername.trim().matches("[\\w\\d]+");
            boolean check = true;
            if (!check_Username) {
                reg.getErrorUsername().setText("Invalid username!");
                check = false;
            } else {
                reg.getErrorUsername().setText("");
            }
            if ("".equals(txtPassword)) {
                reg.getErrorPassword().setText("You have not entered your password!");
                check = false;
            } else {
                reg.getErrorPassword().setText("");
            }

            System.out.println(check);
            if (check == true) {
                try {
                    Connection connection = JDBCUtil.getConnection();
                    try {
                        if (connection == null) {
                            JOptionPane.showMessageDialog(reg, "Không thể kết nối đến Database");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(reg, "Không thể kết nối đến Database");
                        ex.printStackTrace();
                    }
                    Statement st = connection.createStatement();
                    String sql = "INSERT INTO Accounts (username, password)"
                            + " VALUES ('" + reg.getTxtUsername().getText().trim() + "', '" + reg.getTxtPassword().getText() + "')";
                    int ck = st.executeUpdate(sql);
                    if (ck > 0) {
                        JOptionPane.showMessageDialog(reg, "Đăng ký thành công!");
                        try {
                            reg.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                            Thread.sleep(1500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Validation.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        reg.dispose();
                        Login login = new Login();
                        login.setVisible(true);
                        System.out.println("Register state: " + check + " Username:" + txtUsername + " Password:" + txtPassword);
                    }
                    JDBCUtil.closeConnection(connection);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(reg, "Tài khoản đã tồn tại");
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
