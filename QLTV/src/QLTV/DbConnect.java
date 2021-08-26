/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTV;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trung
 */
public class DbConnect {
    public static final String stringcon = "jdbc:sqlserver://DESKTOP-BL6QJ75\\SQLEXPRESS:1433;databaseName=QLTV";
    public static final DbConnect helper = new DbConnect();
    private Connection con;
    
    // Hàm kết nối với SQL
    private DbConnect() {
         try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception ex){
            System.out.println("Chưa có driver !!" + ex.toString());
        }
        try{
            con = DriverManager.getConnection(stringcon, "sa", "24112001");
        } catch (Exception ex){
            //Lỗi tên dăng nhập và mật khẩu
            System.out.println("Lỗi connect" + ex.toString());
        }
    }
    public Connection getDbConnect(){
        return con;
    }
    
    // hàm thực thi lệnh
    public ResultSet GET(String sql) {
            try {
                // tạo con trỏ thực thi lệnh SQL
                Statement state = con.createStatement();
                return state.executeQuery(sql);
            } catch (SQLException ex) {
                Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
            }
        return null;
    }
    
    // Viết hàm insert dữ liệu
    public int INSERT(String sql, String[] stringsSQL, int tbsize) throws SQLException {
            
                PreparedStatement statement = con.prepareStatement(sql);
                // tạo vòng lặp để điền thông tin vào bảng
                for (int i = 0; i <= tbsize; i++){ 
                    statement.setString(i+1, stringsSQL[i]);
                }
                return statement.executeUpdate();
    }

    // Hàm update dữ liệu
    public int UPDATE(String sql, String[] stringsSQL, int tbsize) throws SQLException {
            
                PreparedStatement statement = con.prepareStatement(sql); 
                for (int i = 0; i <= tbsize; i++){ 
                    statement.setString(i+1, stringsSQL[i]);
                }
                return statement.executeUpdate();
    }
    
    // Hàm delete dữ liệu
    public int DELETE(String sql, String id) {
        PreparedStatement statement;
            try {
                statement = con.prepareStatement(sql);;
                statement.setString(1, id);
                return statement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
            }
        return 0;
    }

}
