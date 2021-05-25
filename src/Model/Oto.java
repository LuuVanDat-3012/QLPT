/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.UUID;

/**
 *
 * @author Dat
 */
public class Oto extends PhuongTien{
    private String maOto;
    private int soChoNgoi;
    private String kieuDongCo;

    public String getMaOto() {
        return maOto;
    }

    public void setMaOto(String maOto) {
        this.maOto = maOto;
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public String getKieuDongCo() {
        return kieuDongCo;
    }

    public void setKieuDongCo(String kieuDongCo) {
        this.kieuDongCo = kieuDongCo;
    }
    
    
}
