package Bean;

import java.sql.Date;

public class ReAnswerStudent {
    private String rAnsStu_id;
    private String stuA_id;
    private String rAnsStu_content;
    private Date rAnsStu_time;
    private int rAnsStu_nice;
    private int rAnsStu_tread;

    public ReAnswerStudent() {}

    public ReAnswerStudent(String rAnsStu_id, String stuA_id, String rAnsStu_content, Date rAnsStu_time, int rAnsStu_nice, int rAnsStu_tread) {
        this.rAnsStu_id = rAnsStu_id;
        this.stuA_id = stuA_id;
        this.rAnsStu_content = rAnsStu_content;
        this.rAnsStu_time = rAnsStu_time;
        this.rAnsStu_nice = rAnsStu_nice;
        this.rAnsStu_tread = rAnsStu_tread;
    }

    public String getrAnsStu_id() {
        return rAnsStu_id;
    }

    public void setrAnsStu_id(String rAnsStu_id) {
        this.rAnsStu_id = rAnsStu_id;
    }

    public String getStuA_id() {
        return stuA_id;
    }

    public void setStuA_id(String stuA_id) {
        this.stuA_id = stuA_id;
    }

    public String getrAnsStu_content() {
        return rAnsStu_content;
    }

    public void setrAnsStu_content(String rAnsStu_content) {
        this.rAnsStu_content = rAnsStu_content;
    }

    public Date getrAnsStu_time() {
        return rAnsStu_time;
    }

    public void setrAnsStu_time(Date rAnsStu_time) {
        this.rAnsStu_time = rAnsStu_time;
    }

    public int getrAnsStu_nice() {
        return rAnsStu_nice;
    }

    public void setrAnsStu_nice(int rAnsStu_nice) {
        this.rAnsStu_nice = rAnsStu_nice;
    }

    public int getrAnsStu_tread() {
        return rAnsStu_tread;
    }

    public void setrAnsStu_tread(int rAnsStu_tread) {
        this.rAnsStu_tread = rAnsStu_tread;
    }
}
