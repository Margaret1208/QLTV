/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTV;

import java.sql.ResultSet;


/**
 *
 * @author trung
 */
//ResultSet là đối tượng tạo con trỏ để chỉ một hàng của bảng
public class Filter {
    //Viết các hàm tìm kiếm sách 
    public ResultSet FilterSach(String[] stringsSQL, String TenSach){
        String sql = "SELECT * FROM SACH "
                + "WHERE TenSach LIKE N'%" + TenSach +"%'";
        return DbConnect.helper.GET(sql);
    }
//    public ResultSet ExcuteSQLThongKe(){
//        String sql = "SELECT SUM(SoLuong) FROM SACH";
//        return DbConnect.helper.GET(sql);
//    }  
    //Viết các hàm tìm kiếm đọc giả
    public ResultSet FilterDocGia(String[] stringsSQL, String TenDG){
        String sql = "SELECT * FROM DOCGIA "
                + "WHERE TenDG LIKE N'%" + TenDG +"%'";
        return DbConnect.helper.GET(sql);
    }   
    //Viết các hàm tìm kiếm phiếu mượn 
    public ResultSet FilterPM(String[] stringsSQL, String MaDG){
        String sql = "SELECT * FROM PHIEUMUON "
                + "WHERE MaDG LIKE N'%" + MaDG +"%'";
        return DbConnect.helper.GET(sql);
    } 
}
