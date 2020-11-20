/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasees;

import java.io.File;

/**
 *
 * @author Gaurav
 */
public class User {
    
   public static String login_user;
    private int id;
    private String full_Name;
    private String username;
    private String email;
    private String mobile_no;
    private String password;
    private String category;
    private File file;

    public static String getLogin_user() {
        return login_user;
    }

    public static void setLogin_user(String login_user) {
        login_user = login_user;
    }

    
    
    
    public int getId() {
        return id;
    }

   

    public String getFull_Name() {
        return full_Name;
    }

    public void setFull_Name(String full_Name) {
        this.full_Name = full_Name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
    
    
}
