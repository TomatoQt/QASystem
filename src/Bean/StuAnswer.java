package Bean;

import java.sql.Date;

public class StuAnswer {
    private String stuA_id;
    private String q_id;
    private String stu_id;
    private String stuA_content;
    private int stuA_nice;
    private int stuA_tread;
    private Date stuA_time;

    public StuAnswer() {}

    public StuAnswer(String stuA_id, String q_id, String stu_id, String stuA_content, int stuA_nice, int stuA_tread, Date stuA_time) {
        this.stuA_id = stuA_id;
        this.q_id = q_id;
        this.stu_id = stu_id;
        this.stuA_content = stuA_content;
        this.stuA_nice = stuA_nice;
        this.stuA_tread = stuA_tread;
        this.stuA_time = stuA_time;
    }

    public String getStuA_id() {
        return stuA_id;
    }

    public void setStuA_id(String stuA_id) {
        this.stuA_id = stuA_id;
    }

    public String getQ_id() {
        return q_id;
    }

    public void setQ_id(String q_id) {
        this.q_id = q_id;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getStuA_content() {
        return stuA_content;
    }

    public void setStuA_content(String stuA_content) {
        this.stuA_content = stuA_content;
    }

    public int getStuA_nice() {
        return stuA_nice;
    }

    public void setStuA_nice(int stuA_nice) {
        this.stuA_nice = stuA_nice;
    }

    public int getStuA_tread() {
        return stuA_tread;
    }

    public void setStuA_tread(int stuA_tread) {
        this.stuA_tread = stuA_tread;
    }

    public Date getStuA_time() {
        return stuA_time;
    }

    public void setStuA_time(Date stuA_time) {
        this.stuA_time = stuA_time;
    }
}
