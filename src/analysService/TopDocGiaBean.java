/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analysService;

/**
 *
 * @author HOANG TIEN THUAN
 */
public class TopDocGiaBean {
    private int id, soL;
    private String hoten;

    public TopDocGiaBean(int id, int soL, String hoten) {
        this.id = id;
        this.soL = soL;
        this.hoten = hoten;
    }

    public TopDocGiaBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSoL() {
        return soL;
    }

    public void setSoL(int soL) {
        this.soL = soL;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }
    
}
