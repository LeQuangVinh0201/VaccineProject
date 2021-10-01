/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.dao;

import com.softech.ConnectDB.connectDbManagerVaccine;
import com.softech.model.NguoiDan;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author PC
 */
public class NguoiDanDao {
    public boolean insert(NguoiDan nd)
            throws Exception {
        String sql = "INSERT INTO dbo.NguoiTiem(name,gender,dateOfBirth,identification_ID,"
                + "bhyt_number, email, address, image )"
                + "values(?,?,?,?,?,?,?,?)";
        try (
                 Connection con = connectDbManagerVaccine.OpenConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, nd.getName());
            pstmt.setInt(2, nd.getGender());
            pstmt.setString(3, nd.getDateOfBirth());
            pstmt.setString(4, nd.getIdentification_ID());
            pstmt.setString(5, nd.getBhyt_number());
            pstmt.setString(6, nd.getEmail());
            pstmt.setString(7, nd.getAddress());
            
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
    
    
    
}
