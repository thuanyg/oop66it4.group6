/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class PhieuMuon {
    private int Ma_PM,Ma_Doc_Gia;
    private String Ngay_Muon,Ngay_Hen_Tra,Ngay_Tra;

    public PhieuMuon() {
    }

    public PhieuMuon(int Ma_PM, int Ma_Doc_Gia, String Ngay_Muon, String Ngay_Hen_Tra, String Ngay_Tra) {
        this.Ma_PM = Ma_PM;
        this.Ma_Doc_Gia = Ma_Doc_Gia;
        this.Ngay_Muon = Ngay_Muon;
        this.Ngay_Hen_Tra = Ngay_Hen_Tra;
        this.Ngay_Tra = Ngay_Tra;
    }

    public int getMa_PM() {
        return Ma_PM;
    }

    public void setMa_PM(int Ma_PM) {
        this.Ma_PM = Ma_PM;
    }

    public int getMa_Doc_Gia() {
        return Ma_Doc_Gia;
    }

    public void setMa_Doc_Gia(int Ma_Doc_Gia) {
        this.Ma_Doc_Gia = Ma_Doc_Gia;
    }

    public String getNgay_Muon() {
        return Ngay_Muon;
    }

    public void setNgay_Muon(String Ngay_Muon) {
        this.Ngay_Muon = Ngay_Muon;
    }

    public String getNgay_Hen_Tra() {
        return Ngay_Hen_Tra;
    }

    public void setNgay_Hen_Tra(String Ngay_Hen_Tra) {
        this.Ngay_Hen_Tra = Ngay_Hen_Tra;
    }

    public String getNgay_Tra() {
        return Ngay_Tra;
    }

    public void setNgay_Tra(String Ngay_Tra) {
        this.Ngay_Tra = Ngay_Tra;
    }
    
}
