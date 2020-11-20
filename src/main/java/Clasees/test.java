/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasees;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gaurav
 */
public class test {
 public static void delete(){
     try{
            System.out.println("iddddddddddddddddddddddddddd:");
            Connection con = new ConnectionFactory().getConnection();
            Statement stmt = con.createStatement();
            String query1 = "truncate table noti_count";
            stmt.execute(query1);
            System.out.println("\n*****DELETE FROM noti_count after updation\n");
            }catch(SQLException s)
            {
            s.printStackTrace();
            }
 }
            public static void main(String args[])
            {
               test.delete();
            }
}
