/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasees;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import notifier.MainUI;

public class ProductDao {
    Connection con = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;
    public ProductDao() {
        try {
            Connection con = new ConnectionFactory().getConnection();
            stmt = con.createStatement();
        } catch (Exception e) {
            System.err.println("con");
            e.printStackTrace();
        }
    }
        public int addProducts(Products p) {
          try{
            
            Connection conn = new ConnectionFactory().getConnection();
            Statement stm = conn.createStatement();
            String query = "SELECT * FROM products where name='"+p.getName()+"'";
            
            ResultSet rs1=stm.executeQuery(query);
           if(rs1.next())
           {
           return -1;
           }
          }catch(SQLException e)
            {
                e.printStackTrace();
            }
        try{
            Connection con = new ConnectionFactory().getConnection();
            stmt = con.createStatement();
            int Days_reamaning= days_calculator(p.getExpiry_date());
           // String last_modified="abc";
            String query = "INSERT INTO products (name,type,created_date,last_modified_on,last_modified_by,expiry_date,days_remaning,vendor,description,notification_status,notification_type,created_by) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setString(1,p.getName());
            pstmt.setString(2,p.getType());
            pstmt.setString(3,p.getCreated_date());
            pstmt.setString(4,p.getLast_modified_on());
            pstmt.setString(5,p.getLast_modified_by());
            pstmt.setString(6, p.getExpiry_date());
            pstmt.setInt(7, Days_reamaning);
            pstmt.setString(8, p.getVendor());
            pstmt.setString(9, p.getDescription());
            pstmt.setString(10, p.getNotification_status());
            pstmt.setString(11, p.getNotification_type());
            pstmt.setString(12, p.getCreatedBy());
            pstmt.executeUpdate();
            return 1;
            //JOptionPane.showMessageDialog(null, "Product is ADDED");
           }catch(Exception e){
            e.printStackTrace();
        }
            
          return 0;          
    }
        
        public int deleteProduct(int id)
        {
          try{
            Connection con = new ConnectionFactory().getConnection();
            stmt = con.createStatement();
            String query="delete from products where id=?";
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            Notify n =new Notify();
            n.deletNotify_Days_status(id);
            JOptionPane.showMessageDialog(null, "Item Deleted..");
            
            return 1;
        }catch(SQLException  e){
            e.printStackTrace();
            return 0;
        }
       }
         public int UpdateProduct(Products p,boolean flag) {
        try {
            int days=days_calculator(p.getExpiry_date());
            Connection con = new ConnectionFactory().getConnection();
            //stmt = con.createStatement();
                String query = "UPDATE products SET name=?,type=?,expiry_date=?,vendor=?,description=?,notification_status=?,notification_type=?,days_remaning=?,Last_modified_on=?,Last_modified_by=? WHERE id=?";
                pstmt = (PreparedStatement) con.prepareStatement(query);
                pstmt.setString(1, p.getName());
                pstmt.setString(2, p.getType());
                pstmt.setString(3, p.getExpiry_date());               
                pstmt.setString(4, p.getVendor());
                pstmt.setString(5, p.getDescription());
                pstmt.setString(6, p.getNotification_status());
                pstmt.setString(7, p.getNotification_type());
                pstmt.setInt(8,days );
                pstmt.setString(9, p.getLast_modified_on());
                pstmt.setString(10, p.getLast_modified_by());
                pstmt.setInt(11, p.getId());

                pstmt.executeUpdate();
                                Notify n = new Notify();
                if(days >5)
                {
                n.deletNotify_Days_status(p.getId());
                }
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }  
       
    }
 
 public int days_calculator(String expiry)
{       
    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
    Date currDate=new Date();
    String dateStart =(format.format(currDate));
    String dateStop =expiry;
    Date d1 = null;
    Date d2 = null;
    try {
        d1 = format.parse(dateStart);
        d2 = format.parse(dateStop);
    } catch (ParseException e) {
        e.printStackTrace();
    }

    long difference = d2.getTime() - d1.getTime();
    int daysBetween = (int)(difference / (1000*60*60*24));
    return daysBetween; 

}
 
 
 public void updateAll()
    {
        
           try{
            PreparedStatement pst;
            Connection conn = new ConnectionFactory().getConnection();
            Statement stm = conn.createStatement();
            String query = "SELECT * FROM products";
            ResultSet rs1=stm.executeQuery(query);
           while(rs1.next())
           {
            int id=rs1.getInt("id");
            String exp=rs1.getString("expiry_date");
            int day =days_calculator(exp);
           /* if(day>0)
            {
                
            }else
            {
                day=-1;
            }*/
            String query2 = "UPDATE products SET days_remaning=?  WHERE id=?";
            pst = (PreparedStatement) conn.prepareStatement(query2);
            pst.setInt(1, day);
            pst.setInt(2, id); 
            pst.executeUpdate();
           }System.out.println("Updateall done");

      }catch(Exception e){
                e.printStackTrace();
        }
    }
 public Products getProduct(int id)
 {  
     Products p = new Products();
     try{
            Connection con = new ConnectionFactory().getConnection();
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM products where id="+id;
            ResultSet rs=stmt.executeQuery(query);
           while(rs.next())
           { 
        p.setId(rs.getInt("id"));
        p.setName(rs.getString("name"));
        p.setType(rs.getString("type"));
        p.setCreated_date(rs.getString("created_date"));
        p.setCreatedBy("created_by");
        p.setLast_modified_on(rs.getString("last_modified_on"));
        p.setLast_modified_by(rs.getString("last_modified_by"));
        p.setExpiry_date(rs.getString("expiry_date"));
        //rs.getInt("days_remaning"),
        p.setExp_status("days_remaning");
        p.setVendor(rs.getString("vendor"));
        p.setDescription(rs.getString("description"));
        p.setNotification_status(rs.getString("notification_status"));
        p.setNotification_type(rs.getString("notification_type"));
           }
      }catch(Exception e){
                e.printStackTrace();
        }
             return p;

     
 }
 public ArrayList<Products> ShowData()
    {
        ArrayList<Products> dataArray= new ArrayList();
       // Products p = new Products();
 
           try{
            Connection con = new ConnectionFactory().getConnection();
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM products";
            ResultSet rs=stmt.executeQuery(query);
           while(rs.next())
           { 
              Products p = new Products();
               String days="";
               if(rs.getInt("days_remaning")<=-1)
               {
                   days="Expired";
               }else{
                   days =""+rs.getInt("days_remaning");
               }
        p.setId(rs.getInt("id"));
        p.setName(rs.getString("name"));
        p.setType(rs.getString("type"));
        p.setCreated_date(rs.getString("created_date"));
        p.setLast_modified_on(rs.getString("last_modified_on"));
        p.setLast_modified_by(rs.getString("last_modified_by"));
        p.setExpiry_date(rs.getString("expiry_date"));
        p.setDays_reamaning(rs.getInt("days_remaning"));
        p.setExp_status(days);
        p.setVendor(rs.getString("vendor"));
        p.setDescription(rs.getString("description"));
        p.setNotification_status(rs.getString("notification_status"));
        p.setNotification_type(rs.getString("notification_type"));
        dataArray.add(p);
           }
      }catch(Exception e){
                e.printStackTrace();
        }
           for(Products pr:dataArray)
           {
               System.out.println(pr);
           }
           return dataArray;
    }   
}
