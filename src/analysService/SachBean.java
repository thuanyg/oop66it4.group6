/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analysService;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class SachBean {
    private int soL;
    private String theLoai;

    public SachBean(int soL, String theLoai) {
        this.soL = soL;
        this.theLoai = theLoai;
    }

    public int getSoL() {
        return soL;
    }

    public void setSoL(int soL) {
        this.soL = soL;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }
    
}
