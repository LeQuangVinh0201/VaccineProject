/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.user.dao;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author PC
 */
public class DataValidator {
    public static void validateEmpty(JTextField field, StringBuilder sb, String errorMessage){
        if (field.getText().equals("")){
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();//chi con tro nhap lieu ve cho dang loi
        }else{
            field.setBackground(Color.white);
        }
    }
    
    public static void validateEmpty(JPasswordField field, StringBuilder sb, String errorMessage){
        String password = new String(field.getPassword());// lay du lieu dac biet cho password
        if (password.equals("")){
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();//chi con tro nhap lieu ve cho dang loi
        }else{
            field.setBackground(Color.white);
        }
    }
}
