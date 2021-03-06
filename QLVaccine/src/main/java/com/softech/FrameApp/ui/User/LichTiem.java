/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.FrameApp.ui.User;

import com.softech.ConnectDB.connectDbManagerVaccine;
import com.softech.FrameApp.ui.Login_Register.Login;
import com.softech.user.dao.NguoiDanDao;
import com.softech.user.model.NguoiDan;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leduc
 */
public class LichTiem extends javax.swing.JPanel {
    private DefaultTableModel tblModel;
    /**
     * Creates new form LichTiem1
     */
    public LichTiem() {
        initComponents();
        initTable();
        loadSchedule();
    }
    
    private void initTable(){
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(new String[]{
            "Họ tên","Ngày sinh","Số ĐT","Số CMND","Mũi thứ","Loại vaccine","Nhà sản xuất","Lịch tiêm"
        });
        
        tblSchedule.setModel(tblModel);
    }
    
    private void loadSchedule(){
        try {

            String sql = "select NguoiTiem.name, CONVERT(varchar,NguoiTiem.dateOfBirth,103) as dateOfBirth, NguoiTiem.userName_phoneNumber," +
                         " NguoiTiem.identification_ID, LichTiem.shot, Vaccine.nameOfVaccine, Vaccine.manufacturer, CONVERT(varchar,LichTiem.schedule,103) as schedule from NguoiTiem, LichTiem, Vaccine where NguoiTiem.userName_phoneNumber = LichTiem.phoneNumber_ID" +
                         " and LichTiem.vaccine_ID = Vaccine.vaccine_ID and NguoiTiem.userName_phoneNumber = ?";
        
        try (
                 Connection con = connectDbManagerVaccine.OpenConnection(); 
                PreparedStatement pstmt = con.prepareStatement(sql);
                
            ){
            Login lg = new Login();
            String userName = lg.username_verified;
            pstmt.setString(1, userName);
            
            try(ResultSet rs = pstmt.executeQuery()){
                tblModel.setRowCount(0);
                
                boolean result = rs.next();
                if(!result){
                    NguoiDanDao dao = new NguoiDanDao();
                    NguoiDan nd = dao.findByUserName(userName);
                    
                    tblModel.addRow(new Object[]{
                    nd.getName(), nd.getDateOfBirth(),userName,
                    nd.getIdentification_ID(), " ", " "," ", " "});
                }
                while(result){
                   tblModel.addRow(new Object[]{
                   rs.getString("name"), rs.getString("dateOfBirth"),rs.getString("userName_phoneNumber"),
                   rs.getString("identification_ID"), rs.getInt("shot"), rs.getString("nameOfVaccine"),
                   rs.getString("manufacturer"), rs.getString("schedule")
                        }); 
                   result = rs.next();
                }
                
               
            
            }
            
        }

            tblModel.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
  
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSchedule = new javax.swing.JTable();

        tblSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Họ và tên", "Số điện thoại", "Ngày tiêm mũi 1", "Ngày tiêm mũi 2"
            }
        ));
        jScrollPane1.setViewportView(tblSchedule);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1269, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSchedule;
    // End of variables declaration//GEN-END:variables
}
