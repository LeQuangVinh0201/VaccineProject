/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.user.dao;

import com.softech.ConnectDB.connectDbManagerVaccine;
import com.softech.FrameApp.ui.Login_Register.Login;
import com.softech.user.model.NguoiDan;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author PC
 */
public class NguoiDanDao {

    
    public boolean update(NguoiDan nd)
            throws Exception {
        String sql = "UPDATE dbo.NguoiTiem"+ " SET name = ?,gender = ?,dateOfBirth = ?,identification_ID = ?, bhyt_number = ?, email= ?, address = ?, image = ?"
                + " WHERE userName_phoneNumber = ?";
        try (
                 Connection con = connectDbManagerVaccine.OpenConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, nd.getName());
            pstmt.setInt(2, nd.getGender());
            pstmt.setString(3, nd.getDateOfBirth());
            pstmt.setString(4, nd.getIdentification_ID());
            pstmt.setString(5, nd.getBhyt_number());
            pstmt.setString(6, nd.getEmail());
            pstmt.setString(7, nd.getAddress());
            pstmt.setString(9, nd.getUserName_phoneNumber());
            
            if (nd.getImage()!= null) {
                Blob hinh = new SerialBlob(nd.getImage());
                pstmt.setBlob(8, hinh);
            } else {
                Blob hinh = null;
                pstmt.setBlob(8, hinh);
            }
            

            return pstmt.executeUpdate() > 0; // neu lon hon 0 return true, nguoc lai return false

        }
    }
    
    public boolean delete(String userName_phoneNumber)
            throws Exception {
         // phai co 1 khoang trang sau "  , khong thoi se loi sql
        String sql = "delete from VaccineApp" +
                     " where userName_phoneNumber = ?";
        try (
                 Connection con = connectDbManagerVaccine.OpenConnection(); 
                PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1, userName_phoneNumber);
           
            return pstmt.executeUpdate() > 0; // neu lon hon 0 return true, nguoc lai return false

        }
    }
    
    public NguoiDan findByUserName(String userName)
            throws Exception {
         // phai co 1 khoang trang sau "  , khong thoi se loi sql
        String sql = "select *, CONVERT(varchar,NguoiTiem.dateOfBirth,103) as newDateOfBirth"
                + " from NguoiTiem where UserName_phoneNumber = ?";
        
        try (
                 Connection con = connectDbManagerVaccine.OpenConnection(); 
                PreparedStatement pstmt = con.prepareStatement(sql);
                
            ){
            pstmt.setString(1, userName);
            
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                   NguoiDan nd = new NguoiDan();
                   
                    nd.setName(rs.getString("name"));
                    nd.setDateOfBirth(rs.getString("newDateOfBirth"));
                    nd.setIdentification_ID(rs.getString("identification_ID"));
                    nd.setEmail(rs.getString("email"));
                    nd.setAddress(rs.getString("address"));
                    nd.setGender(rs.getInt("gender"));
                    nd.setBhyt_number(rs.getString("bhyt_number"));
                    Blob blob =rs.getBlob("image");
                    if(blob != null){
                    nd.setImage(blob.getBytes(1, (int) blob.length()));
        }
                   
                   return nd;
                }
            
            }
            return null;
        }
    }
    
    public int getCertificattion(String userName)
            throws Exception {
         // phai co 1 khoang trang sau "  , khong thoi se loi sql
        String sql = "select * from NguoiTiem, LichTiem where UserName_phoneNumber = ?";
        
        try (
                 Connection con = connectDbManagerVaccine.OpenConnection(); 
                PreparedStatement pstmt = con.prepareStatement(sql);
                
            ){
            pstmt.setString(1, userName);
            
            try(ResultSet rs = pstmt.executeQuery()){
                int max = 0;
                while (rs.next()) {
                    if (rs.getInt("confirmation") == 0) {
                        if (max > 0) {
                            return max;
                        } else {
                            max = 0;
                        }
                    } else {
                        if (rs.getInt("shot") == 1) {
                            max = 1;
                        } else {
                            max = 2;
                            break;
                        }

                    }
                }
                return max;
            }

        }
         
      }
        
        
}
    
    
    
