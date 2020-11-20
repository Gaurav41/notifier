
package Clasees;
public class notiDao {
    int id;
    int noti_no;
    String msg;
    String emial;
    boolean flag;
    String nStatus;

    public String getnStatus() {
        return nStatus;
    }

    public void setnStatus(String nStatus) {
        this.nStatus = nStatus;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "notiDao{" + "id=" + id + ", noti_no=" + noti_no + ", msg=" + msg + ", emial=" + emial + '}';
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }
    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNoti_no() {
        return noti_no;
    }

    public void setNoti_no(int noti_no) {
        this.noti_no = noti_no;
    }

    void setMsg(String msg) {
        this.msg=msg;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String getMsg(){
        return msg;
    }
    
       
}
