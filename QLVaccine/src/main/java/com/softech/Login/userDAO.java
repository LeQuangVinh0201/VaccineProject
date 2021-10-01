/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.Login;

import com.softech.ConnectDB.connectDbManagerVaccine;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class userDAO {

    private ArrayList<userLogin> list = new ArrayList<>();

    public boolean insert(userLogin admin) throws SQLException {
        String sql = "insert into NguoiTiem (userNumber_phonenumber,password,fullname,email) values (?,?,?,?)";

        Connection con = connectDbManagerVaccine.OpenConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);

        pstmt.setString(1, admin.getUsername());
        pstmt.setString(2, admin.getPassword());
        pstmt.setString(3, admin.getFullname());
        pstmt.setString(4, admin.getEmail());

        return pstmt.executeUpdate() > 0;
    }

    public userLogin findbyUser(String username) throws SQLException {
        String sql = "select userNumber_phonenumber, password from NguoiTiem where userNumber_phonenumber = ?";
        Connection con = connectDbManagerVaccine.OpenConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, username);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            userLogin user = new userLogin();

            user.setUsername(rs.getString("userNumber_phonenumber"));
            user.setPassword(rs.getString("password"));
            return user;
        }
        return null;
    }

    public userLogin findbyAdmin(String username) throws SQLException {
        String sql = "select userName, password from QuanTriVien where userName = ?";
        Connection con = connectDbManagerVaccine.OpenConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, username);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            userLogin admin = new userLogin();
            admin.setUsername(rs.getString("userName"));
            admin.setPassword(rs.getString("password"));
            return admin;
        }
        return null;
    }

    public userLogin findByEmail(String username, String email) throws SQLException {
        String sql = "select password,email,userNumber_phonenumber from NguoiTiem where userNumber_phonenumber = ? and email = ? ";
        Connection con = connectDbManagerVaccine.OpenConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, email);
         ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            userLogin user = new userLogin();
            user.setUsername(rs.getString("userNumber_phonenumber"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            return user;
        }
        return null;
    }
    
    public boolean updatePassword(userLogin user) throws SQLException{
        String sql = "update NguoiTiem set password = ? where userNumber_phonenumber = ? ";
        Connection con = connectDbManagerVaccine.OpenConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        
         pstmt.setString(2, user.getUsername());
         pstmt.setString(1, user.getPassword());
         
         return pstmt.executeUpdate() >0;
    }
}
