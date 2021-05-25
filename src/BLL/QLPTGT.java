/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Connector;
import Model.XeMay;
import Model.XeTai;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dat
 */
public class QLPTGT {
//   private String hangSX;
//    private int namSX;
//    private double giaBan;
//    private String mauSac;

    Connection conn;

    public QLPTGT() {
        conn = Connector.getConnection();
    }

    // Lấy danh sách xe máy
    public ArrayList<XeTai> GetXeTai() throws SQLException {
        ArrayList<XeTai> listXeTai = new ArrayList<>();
        String sql = "select * from XeTai";
        Statement stmt = (Statement) conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            XeTai xm = new XeTai();
            xm.setMaXeTai(rs.getString("maXeTai"));
            xm.setHangSX(rs.getString("hangSX"));
            xm.setNamSX(rs.getInt("namSX"));
            xm.setGiaBan(rs.getDouble("giaBan"));
            xm.setMauSac(rs.getString("mauSac"));
            xm.setCongSuat(rs.getFloat("congSuat"));
            listXeTai.add(xm);
            System.out.println(xm.getGiaBan());
        }
        return listXeTai;
    }
    // Thêm mới xe máy

    public int AddXeTai(XeTai XeTai) {
        String sql = " INSERT INTO XeTai (maXeTai, hangSX, namSX, giaBan, mauSac, congSuat)\n"
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, XeTai.getMaXeTai());
            ps.setString(2, XeTai.getHangSX());
            ps.setInt(3, XeTai.getNamSX());
            ps.setDouble(4, XeTai.getGiaBan());
            ps.setString(5, XeTai.getMaXeTai());
            ps.setDouble(6, XeTai.getGiaBan());
            ps.execute();
            return 1;
        } catch (SQLException ex) {
            if (ex.getMessage().contains("primary key")) {
                System.out.println("Trung khoa chinh");
            }
            Logger.getLogger(QLPTGT.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    // Xoá xe máy

    public int DeleteXeTai(String maXeTai) {
        String sql = " delete from XeTai where maXeTai = '" + maXeTai + "'";
        try {
            Statement st = (Statement) conn.createStatement();
            st.execute(sql);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
// Sửa xe máy

    public int UpdateXeTai(XeTai XeTai) {
        try {
            String sql = "update MeMay set hangSX = ?, namSX = ?, giaBan = ?, mauSac = ?, congSuat = ? where maXeTai = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(6, XeTai.getMaXeTai());
            ps.setString(1, XeTai.getHangSX());
            ps.setInt(2, XeTai.getNamSX());
            ps.setDouble(3, XeTai.getGiaBan());
            ps.setString(4, XeTai.getMaXeTai());
            ps.setDouble(5, XeTai.getGiaBan());
            ps.execute();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

}
