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
    private String year, month;
    private int soluong;

    public PhieuMuonBean(String year, String month, int soluong) {
        this.year = year;
        this.month = month;
        this.soluong = soluong;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    
}

    