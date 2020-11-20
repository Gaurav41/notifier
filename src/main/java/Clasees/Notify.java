package Clasees;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import notifier.MainUI;
public class Notify {
 
    public ArrayList<notiDao> SendNoti()
    {   //System.out.println("in notify.java sendnoti fun");
        String msg="",notitype="";
        ArrayList<notiDao> arry= new ArrayList<>(); 
        ArrayList<notiDao> arry2= new ArrayList<>(); 
        boolean flag=false; int count=0; 
    try{    
    Connection con = new ConnectionFactory().getConnection();
    Statement stmt = con.createStatement();
    String query = "SELECT * FROM products where (days_remaning=0 or days_remaning =1 or days_remaning =2 or days_remaning =5 or days_remaning = -1 or days_remaning =-2) AND notification_status='ON' ";
    ResultSet rs=stmt.executeQuery(query);
    while(rs.next())
        {
        notiDao n=new notiDao();
        msg="";
        notitype=rs.getString("notification_type");
        int days=rs.getInt("days_remaning");
        System.out.println("name:"+rs.getString("name")+" ,days: "+ days);
        int id=rs.getInt("id");
        String Status=rs.getString("notification_status");
        n.setId(id);
        n.setNoti_no(days);
        flag=noticheck(days,id);
        switch(days)
            {
            case 0 :msg="Hey... Your Product-"+rs.getString("name")+" "+rs.getString("type")+" is going to Expire Today, Renew it asap ";
                    n.setMsg(msg);
            break;
            case 1:msg="One day to go... Your Product-"+rs.getString("name")+" "+rs.getString("type")+" is going to Expire Tomorrow, Renew it asap ";
                    n.setMsg(msg);
            break;
            case 2:msg="Two days to go... Your Product-"+rs.getString("name")+" "+rs.getString("type")+" will be Expired on: "+rs.getString("expiry_date");
                    n.setMsg(msg);
            break;
            case 5:msg="Your Product-"+rs.getString("name")+" "+rs.getString("type")+" will Expire on: "+rs.getString("expiry_date");
                    n.setMsg(msg);
                    break;
            case -1:msg="Your Product-"+rs.getString("name")+" "+rs.getString("type")+" is Expired ...";
                     n.setMsg(msg);
                     break;
            case -2: msg="Your Product-"+rs.getString("name")+" "+rs.getString("type")+" is Expired ...";              
                     n.setMsg(msg);
             break;             
            }
            
            if(notitype.equals("OnApp")|| notitype.equals("Both"))
                arry.add(n);
            if(flag==true && (notitype.equals("Email")|| notitype.equals("Both")))
            {
                arry2.add(n);
            }
            }rs.close();
        }catch(Exception e){e.printStackTrace();}
           /* if(count>0)
            {
             sendMail(arry2);
             updateNotiNo(arry2);
            }
    */  
            if(flag){
                if(sendMail(arry2)==1)
                {
                    updateNotiNo(arry2);
                }
            }
            arry2.clear();
            
      /*  System.out.println("arry contains:");
       for(notiDao i:arry)
        {
            System.out.println("notify.java "+i.getId()+","+i.getMsg());
        } 
        System.out.println("returning arry");
        */
        return arry;
    }
    
    public void showNotiFication(String msg){
        System.out.println("0000: "+msg);
    }

    private void updateNotiNo(ArrayList<notiDao> arry) {
        arry.forEach(n -> {
            try {
                 String col="";
                int num=n.getNoti_no();
                if(num==-1)
                {   
                    num=01;
                    col =num+"A"; 
                }else if(num==-2)
                {   
                    num=02;
                    col =num+"A"; 
                }else
                col =num+"A";
                int id=n.getId();
                Connection con = new ConnectionFactory().getConnection();
                String query="INSERT INTO noti_count (id,"+col+") VALUES ("+id+",1) ON DUPLICATE KEY UPDATE "+col+"=1";
                PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(query);                
                pstmt.executeUpdate();
                System.out.print("Noti update succesfull for id:"+n.getId()+",");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(n.getNoti_no()==-2)
            {
                turnOffNoti(n.getId());
            }
        });
        System.out.println("");
      
    }

    private void turnOffNoti(int id) {
        try{
        Connection con = new ConnectionFactory().getConnection();
        String query1 = "UPDATE  products SET notification_status='OFF' WHERE id=?";
        PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(query1);
        pstmt.setInt(1, id);        
        pstmt.executeUpdate();
        }catch(SQLException s)
        {
        }
    }
   
    private boolean noticheck(int days, int id) {
        int i = 0;
        if(days==-1)
        {
            days=01;
        }else if(days==-2){
            days=02;
        }
         String col=null;
        try{   
        Connection con =  new ConnectionFactory().getConnection();
        col=days+"A";
        System.out.println("Col:-"+col);
        Statement stmt=con.createStatement();
        String query=" select * from noti_count where id="+id;
        
        ResultSet rs=stmt.executeQuery(query);
        if(rs.next()){
                    i=Integer.parseInt(rs.getString(col));

                        }
        }catch(SQLException e)
        {   
            e.printStackTrace();
        }
        if(i==1)
        {
            System.out.println("mail already sent");   
            return false;            
        }
       // System.out.println("sending noti mail ID:"+id+" col:"+col);   

        return true;   
    }
     
    public void deletNotify_Days_status(int id) {
        try{
            System.out.println("iddddddddddddddddddddddddddd:"+id);
            Connection con = new ConnectionFactory().getConnection();
            Statement stmt = con.createStatement();
            String query1 = "DELETE FROM noti_count WHERE id="+id;
            stmt.execute(query1);
            System.out.println("\n*****DELETE FROM noti_count after updation\n");
            }catch(SQLException s)
            {
            s.printStackTrace();
            }
    }
    
    public int sendMail(ArrayList<notiDao> arry)
    {   if(!arry.isEmpty())
    {
        SendEmail se=new SendEmail();
        return(se.sendNotiMail(arry));
    }else{
        return 0;
    }
        
    }
}
