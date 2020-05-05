/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program.pemesanan;

import java.sql.Connection;
import javax.swing.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author HP
 */
class KoneksiDatabase {

    private static Connection MySQLConfig;
    public static Connection getKoneksi() throws SQLException{
        try{
            String url="jdbc:mysql://localhost:3306/pemesanan";
            String user="root";
            String pass="";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            MySQLConfig = DriverManager.getConnection(url, user, pass);
        } catch(SQLException e){
            System.out.println("Komeksi ke database gagal "+e.getMessage());
        }
        return MySQLConfig;
    }
    
}
