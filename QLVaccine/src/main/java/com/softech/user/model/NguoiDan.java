/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.user.model;


/**
 *
 * @author PC
 */
public class NguoiDan {
    private String userName_phoneNumber, passWord, name, identification_ID, bhyt_number, email, address;
    private String dateOfBirth, vaccine1_schedule, vaccine2_schedule;
    private int gender;
    private byte[] image;

    public NguoiDan() {
    }

    public NguoiDan(String userName_phoneNumber, String passWord, String name, String identification_ID, String bhyt_number, String email, String address, String dateOfBirth, String vaccine1_schedule, String vaccine2_schedule, int gender, byte[] image) {
        this.userName_phoneNumber = userName_phoneNumber;
        this.passWord = passWord;
        this.name = name;
        this.identification_ID = identification_ID;
        this.bhyt_number = bhyt_number;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.vaccine1_schedule = vaccine1_schedule;
        this.vaccine2_schedule = vaccine2_schedule;
        this.gender = gender;
        this.image = image;
    }

    

    public String getUserName_phoneNumber() {
        return userName_phoneNumber;
    }

    public void setUserName_phoneNumber(String userName_phoneNumber) {
        this.userName_phoneNumber = userName_phoneNumber;
    }

    

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentification_ID() {
        return identification_ID;
    }

    public void setIdentification_ID(String identification_ID) {
        this.identification_ID = identification_ID;
    }

    public String getBhyt_number() {
        return bhyt_number;
    }

    public void setBhyt_number(String bhyt_number) {
        this.bhyt_number = bhyt_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getVaccine1_schedule() {
        return vaccine1_schedule;
    }

    public void setVaccine1_schedule(String vaccine1_schedule) {
        this.vaccine1_schedule = vaccine1_schedule;
    }

    public String getVaccine2_schedule() {
        return vaccine2_schedule;
    }

    public void setVaccine2_schedule(String vaccine2_schedule) {
        this.vaccine2_schedule = vaccine2_schedule;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    
    
    
    
}
