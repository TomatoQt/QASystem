package Bean;

import java.sql.Date;

public class ReAskTeacher {
    private String rAskTea_id;
    private String teaA_id;
    private String rAskTea_content;
    private Date rAskTea_time;

    public ReAskTeacher() {}

    public ReAskTeacher(String rAskTea_id, String teaA_id, String rAskTea_content, Date rAskTea_time) {
        this.rAskTea_id = rAskTea_id;
        this.teaA_id = teaA_id;
        this.rAskTea_content = rAskTea_content;
        this.rAskTea_time = rAskTea_time;
    }

    public String getrAskTea_id() {
        return rAskTea_id;
    }

    public void setrAskTea_id(String rAskTea_id) {
        this.rAskTea_id = rAskTea_id;
    }

    public String getTeaA_id() {
        return teaA_id;
    }

    public void setTeaA_id(String teaA_id) {
        this.teaA_id = teaA_id;
    }

    public String getrAskTea_content() {
        return rAskTea_content;
    }

    public void setrAskTea_content(String rAskTea_content) {
        this.rAskTea_content = rAskTea_content;
    }

    public Date getrAskTea_time() {
        return rAskTea_time;
    }

    public void setrAskTea_time(Date rAskTea_time) {
        this.rAskTea_time = rAskTea_time;
    }
}
