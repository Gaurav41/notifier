package notifier;

import Clasees.Notify;
import Clasees.ProductDao;
import Clasees.Products;
import Clasees.User;
import Clasees.notiDao;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.contentobjects.jnotify.JNotify;


/**
 *
 * @author Gaurav
 */
public class MainUI extends javax.swing.JFrame {

   public static String LoggedInUser="";
    String msg;
    ProductDao pd = new ProductDao();
    Products p = new Products();
    Notify nt =new Notify();
    DefaultTableModel model,model2;
    static boolean update=false;
    public MainUI() 
    {
      
    pd.updateAll();
    initComponents();
    model=(DefaultTableModel)jTable.getModel();
    ShowData();
    ShowNoti1();
    }
/*
    MainUI(String username) {
        this();
        this.LoggedInUser=username;
    }
    */
     MainUI(int updateBit) {
         refresh();
    }
public void ShowData()
    {   
        ArrayList<Products> data_array=new ArrayList<>();
        data_array=pd.ShowData();
        for(Products pr:data_array)
        {
         model.insertRow(jTable.getRowCount(),new Object[]{
    
         pr.getId(),
         pr.getName(),
         pr.getType(),
         pr.getCreated_date(),
         pr.getExpiry_date(),
         pr.getExp_status(),
         pr.getVendor(),
         pr.getDescription(),
         

         //pr.getNotification_status(),
        // pr.getNotification_type(),
         //pr.getLast_modified_on(),
         //pr.getLast_modified_by(),
         //pr.getVendor(),
        
        });
        } 
    }
/*    public void ShowData()
    {
        
           try{
            pd.updateAll();
            Connection con = new ConnectionFactory().getConnection();
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM products";
            ResultSet rs=stmt.executeQuery(query);
           while(rs.next())
           { String days="";
               if(rs.getInt("days_remaning")<=-1)
               {
                   days="Expired";
               }else{
                   days =""+rs.getInt("days_remaning");
               }

     model.insertRow(jTable.getRowCount(),new Object[]{
    
        rs.getInt("id"),
        rs.getString("name"),
        rs.getString("type"),
        rs.getString("created_date"),
        rs.getString("last_modified_on"),
        rs.getString("last_modified_by"),
        rs.getString("expiry_date"),
        //rs.getInt("days_remaning"),
        days,
        rs.getString("vendor"),
        rs.getString("description"),
        rs.getString("notification_status"),
        rs.getString("notification_type"),
        
    });
           }
      }catch(Exception e){
                e.printStackTrace();
        }
    }
    */
    /* public void ShowNoti1(ArrayList<notiDao> arry)
    {   //notiDao n=new notiDao();
        System.out.println("In shownoti1");
        model2=(DefaultTableModel)tblNotification.getModel();
        tblNotification.setRowHeight(80);
        for(notiDao i:arry){
         model2.insertRow(tblNotification.getRowCount(),new Object[]{
        i.getId(),
        i.getMsg(),  
        // "122",
         //"kdgjhdgfj",
        });
         System.out.println("9 "+i);
       }
    }
    */
    public void ShowNoti1()
    {   txtnotification_pannel.setText("");
        notiDao n=new notiDao();
        ArrayList<notiDao> arry= nt.SendNoti();
        System.out.println("In shownoti1");
        int index=1;
        for(notiDao i:arry)
        {
        String msg=+index+"|"+i.getMsg()+"\nProduct ID:"+i.getId()+"\n";
        txtnotification_pannel.append(msg);
        index++;
        }
        arry.clear();
     }     
   /* public void ShowNoti(String msg)
    {   
        if(!("".equals(msg)))
            txtnotifications.setText(msg);
        else{
            txtnotifications.setText("No any Notification");
        }
    }*/
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnrefresh = new javax.swing.JButton();
        btnView1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtnotification_pannel = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main");
        setPreferredSize(new java.awt.Dimension(1370, 786));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gaurav\\Documents\\NetBeansProjects\\notifier\\src\\main\\img\\MainTitle1.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(389, 389, 389)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnAdd.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gaurav\\Documents\\NetBeansProjects\\notifier\\src\\main\\img\\Addicon.png")); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gaurav\\Documents\\NetBeansProjects\\notifier\\src\\main\\img\\update.png")); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnRemove.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gaurav\\Documents\\NetBeansProjects\\notifier\\src\\main\\img\\remove2.png")); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnView.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gaurav\\Documents\\NetBeansProjects\\notifier\\src\\main\\img\\view.png")); // NOI18N
        btnView.setText("View ");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnLogout.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gaurav\\Documents\\NetBeansProjects\\notifier\\src\\main\\img\\logout.png")); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnrefresh.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gaurav\\Documents\\NetBeansProjects\\notifier\\src\\main\\img\\refersh.png")); // NOI18N
        btnrefresh.setText("Refresh");
        btnrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefreshActionPerformed(evt);
            }
        });

        btnView1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gaurav\\Documents\\NetBeansProjects\\notifier\\src\\main\\img\\view.png")); // NOI18N
        btnView1.setText("View ALL");
        btnView1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnView1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gaurav\\Documents\\NetBeansProjects\\notifier\\src\\main\\img\\Title3.png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnView1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnrefresh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnrefresh)
                .addGap(36, 36, 36)
                .addComponent(btnAdd)
                .addGap(27, 27, 27)
                .addComponent(btnRemove)
                .addGap(31, 31, 31)
                .addComponent(btnUpdate)
                .addGap(32, 32, 32)
                .addComponent(btnView)
                .addGap(31, 31, 31)
                .addComponent(btnView1)
                .addGap(27, 27, 27)
                .addComponent(btnLogout)
                .addGap(38, 38, 38))
        );

        jTable.setAutoCreateRowSorter(true);
        jTable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Type", "created date", "Expiery date", "day remaning", "Vendor", "Description"
            }
        ));
        jTable.setFocusCycleRoot(true);
        jScrollPane1.setViewportView(jTable);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtnotification_pannel.setColumns(20);
        txtnotification_pannel.setRows(5);
        jScrollPane5.setViewportView(txtnotification_pannel);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gaurav\\Documents\\NetBeansProjects\\notifier\\src\\main\\img\\NP.jpg")); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gaurav\\Documents\\NetBeansProjects\\notifier\\src\\main\\img\\clear1.png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1))
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void refresh(){
         int rowCount = model.getRowCount();
//Remove rows one by one from the end of the table
for (int i = rowCount - 1; i >= 0; i--) {
    model.removeRow(i);
}
       // msg= nt.SendNoti();
       //ShowNoti(msg);    
       ShowData();
       ShowNoti1();
    
    }
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        jTable.clearSelection();
    }//GEN-LAST:event_formMouseClicked

    private void btnView1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnView1ActionPerformed
         new ViewAll().setVisible(true);
    }//GEN-LAST:event_btnView1ActionPerformed

    private void btnrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_btnrefreshActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null,"Sure? Do u want Logout?","Logout",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION){
            LoggedInUser="";
            dispose();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        if(jTable.getSelectedRow()==-1)
        {
            JOptionPane.showMessageDialog(null,"select item");
        }
        else{

            Products p = new Products();
            p.setId((int)model.getValueAt(jTable.getSelectedRow(),0));

            new View(p).setVisible(true);
        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed

        if(jTable.getSelectedRow()==-1)
        {
            JOptionPane.showMessageDialog(null,"select item");
        }
        else{
            //JOptionPane.showConfirmDialog(null, "Do u want to remove ");

            int result = JOptionPane.showConfirmDialog(null,"Sure? Do u want to remove?","Deletion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){

                int i=(int)model.getValueAt(jTable.getSelectedRow(),0);
                int status =  pd.deleteProduct(i);
                if(status==1){
                    model.removeRow(jTable.getSelectedRow());
                    //JOptionPane.showMessageDialog(null,"Product Deleted");
                }
            }
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(jTable.getSelectedRow()==-1)
        {
            JOptionPane.showMessageDialog(null,"select item");
        }
        else{

            Products p = new Products();
            p.setId((int)model.getValueAt(jTable.getSelectedRow(),0));
            ProductDao pd = new ProductDao();
            p=pd.getProduct(p.getId());
           /* int i=jTable.getSelectedRow();
            p.setName(model.getValueAt(i,1).toString());
            p.setType(model.getValueAt(i,2).toString());
            p.setExpiry_date(model.getValueAt(i,4).toString());
            p.setDescription(model.getValueAt(i,6).toString());
            p.setNotification_status(model.getValueAt(i,7).toString());
            p.setNotification_type(model.getValueAt(i,8).toString());
            p.setVendor(model.getValueAt(i,9).toString());
            */
            Update_Product1 u = new Update_Product1(p);
            new Update_Product1(p).setVisible(true);

            if(update)
            {
                System.out.println("REFRESH");
                refresh();
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        new Add_Product().setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        txtnotification_pannel.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JButton btnView1;
    private javax.swing.JButton btnrefresh;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable;
    private javax.swing.JTextArea txtnotification_pannel;
    // End of variables declaration//GEN-END:variables
}
