/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class DocGia {
    private int MDG,Gioi_Tinh;
    private String Ho_Ten,CCCD,SDT;
    private String Ngay_SInh;
    
    public DocGia(){
        
    }

    public DocGia(int MDG, int Gioi_Tinh, String Ho_Ten, String CCCD, String SDT, String Ngay_SInh) {
        this.MDG = MDG;
        this.Gioi_Tinh = Gioi_Tinh;
        this.Ho_Ten = Ho_Ten;
        this.CCCD = CCCD;
        this.SDT = SDT;
        this.Ngay_SInh = Ngay_SInh;
    }
    
    public int getMDG() {
        return MDG;
    }

    public void setMDG(int MDG) {
        this.MDG = MDG;
    }

    public int getGioi_Tinh() {
        return Gioi_Tinh;
    }

    public void setGioi_Tinh(int Gioi_Tinh) {
        this.Gioi_Tinh = Gioi_Tinh;
    }

    public String getHo_Ten() {
        return Ho_Ten;
    }

    public void setHo_Ten(String Ho_Ten) {
        this.Ho_Ten = Ho_Ten;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    public void setNgay_SInh(String Ngay_SInh) {
        this.Ngay_SInh = this.Ngay_SInh;
    }

    public String getNgay_SInh() {
        return Ngay_SInh;
    }

    
}
