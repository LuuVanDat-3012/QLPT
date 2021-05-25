/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Connector;
import Model.XeMay;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dat
 */
public class QLPTGT{
//   private String hangSX;
//    private int namSX;
//    private double giaBan;
//    private String mauSac;
    Connection conn;

    public QLPTGT() {
        conn = Connector.getConnection();
    }
    // Lấy danh sách xe máy
   public  ArrayList<XeMay> GetXeMay() throws SQLException{
       ArrayList<XeMay> listXeMay = new ArrayList<>();
       String sql = "select * from XeMay";
       Statement stmt = (Statement) conn.createStatement();
       ResultSet rs = stmt.executeQuery(sql);
       while(rs.next()){
           XeMay xm = new XeMay();
           xm.setMaXeMAy(rs.getString("maXeMay"));
           xm.setHangSX(rs.getString("hangSX"));
           xm.setNamSX(rs.getInt("namSX"));
           xm.setGiaBan(rs.getDouble("giaBan"));
           xm.setMauSac(rs.getString("mauSac"));
           xm.setCongSuat(rs.getFloat("congSuat"));
           listXeMay.add(xm);
           System.out.println(xm.getGiaBan());
       }
       return listXeMay;       
   }
   // Thêm mới xe máy
   public int AddXeMay(XeMay xeMay){
       return 0;
   }
   
   
    
}
