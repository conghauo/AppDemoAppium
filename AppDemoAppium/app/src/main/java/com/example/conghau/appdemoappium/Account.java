package com.example.conghau.appdemoappium;

import java.io.Serializable;

/**
 * Created by CongHau on 11/3/2017.
 */

public class Account implements Serializable {
    private int ID_acc;
    private String mail;
    private String UserName;
    private String Pass;
    public  Account (int ID_acc,String mail, String UserName, String Pass )
    {   this.ID_acc= ID_acc;
        this.mail = mail;
        this.UserName= UserName;
        this.Pass = Pass;
    }
    public Account()
    {};

    public int getID_acc() {
        return ID_acc;
    }

    public void setID_acc(int ID_acc) {
        this.ID_acc = ID_acc;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }
}
