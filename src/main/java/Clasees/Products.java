/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasees;


public class Products {
    
    private String name,type,vendor,Description,notification_type;
    private String created_date,last_modified_on,last_modified_by,expiry_date;
    private int days_reamaning,id;
    String  notification_status,exp_status;
    private String CreatedBy;

    public String getExp_status() {
        return exp_status;
    }

    public void setExp_status(String exp_status) {
        this.exp_status = exp_status;
    }

     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLast_modified_on() {
        return last_modified_on;
    }

    public void setLast_modified_on(String last_modified_on) {
        this.last_modified_on = last_modified_on;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getNotification_type() {
        return notification_type;
    }

    public void setNotification_type(String notification_type) {
        this.notification_type = notification_type;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getLast_modified_by() {
        return last_modified_by;
    }

    public void setLast_modified_by(String last_modified_by) {
        this.last_modified_by = last_modified_by;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }

    public int getDays_reamaning() {
        return days_reamaning;
    }

    public void setDays_reamaning(int days_reamaning) {
        this.days_reamaning = days_reamaning;
    }

    public String getNotification_status() {
        return notification_status;
    }

    public void setNotification_status(String notification_status) {
        this.notification_status = notification_status;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String CreatedBy) {
        this.CreatedBy = CreatedBy;
    }
   

    @Override
    public String toString() {
        return "Products{" + "name=" + name + ", type=" + type + ", vendor=" + vendor + ", Description=" + Description + ", notification_type=" + notification_type + ", created_date=" + created_date + ", last_modified_by=" + last_modified_by + ", expiry_date=" + expiry_date + ", days_reamaning=" + days_reamaning + ", id=" + id + ", notification_status=" + notification_status + '}';
    }

   
   
    
    
    
}
