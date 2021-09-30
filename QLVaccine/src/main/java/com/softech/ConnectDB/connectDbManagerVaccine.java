/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author admin
 */
public class connectDbManagerVaccine {
        public static Connection OpenConnection() throws SQLException{
        String connectionUrl = "jdbc:sqlserver://LONG:1433; databaseName = ManagerVaccine; user=demo; password=123";
        Connection con = DriverManager.getConnection(connectionUrl);
        Statement stmt = con.createStatement();
        return con;
    }
}
