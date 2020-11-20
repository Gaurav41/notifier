/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Clasees.User;
import connection.ConnectionFactory;


public class UserDao {
    Connection con = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;
    public UserDao() {
        try {
            Connection con = new ConnectionFactory().getConnection();
            stmt = con.createStatement();
        } catch (Exception e) {
            System.err.println("con");
            e.printStackTrace();
        }
    }
        public void addUser(User u) {
        try{
            Connection con = new ConnectionFactory().getConnection();
            stmt = con.createStatement();
            String query = "SELECT * FROM users WHERE full_name='"+u.getFull_Name()+"' AND username ='"+u.getUsername()+"' AND mobile_no='"+u.getMobile_no()+"'";
            rs=stmt.executeQuery(query);
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Same User has already been added!");
            }else{
                addFunction(u);
            }
        }catch(Exception e){
                e.printStackTrace();
        }   
    }//end of method addUserDTO
     public void addFunction(User u){
        try{
             Connection con = new ConnectionFactory().getConnection();
            stmt = con.createStatement();

           // String user=u.getCategory();
           
            System.out.println("in addFunction "+u.getUsername()+ ","+u.getFull_Name()+","+u.getMobile_no()+","+u.getEmail()+","+u.getPassword()+".");
            
            String query = "INSERT INTO users (username,full_name,email,mobile_no, password) VALUES(?,?,?,?,?)";
            pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setString(1, u.getUsername());
            pstmt.setString(2, u.getFull_Name());
            pstmt.setString(3, u.getEmail());
            pstmt.setString(4, u.getMobile_no());
            pstmt.setString(5, u.getPassword());
            //pstmt.setString(6, u.getCategory());
            pstmt.executeUpdate();
            
                JOptionPane.showMessageDialog(null, "You are ADDED");
           }catch(Exception e){
            e.printStackTrace();
        }
                    
    }
}
