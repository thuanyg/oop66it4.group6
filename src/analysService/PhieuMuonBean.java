/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analysService;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class PhieuMuonBean {
    private String date;
    private int soluong;

    public PhieuMuonBean() {
    }

    public PhieuMuonBean(String date, int soluong) {
        this.date = date;
        this.soluong = soluong;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    
}
