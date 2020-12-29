package Bean;

import java.sql.Date;

public class teaAnswer {
    private String teaA_id;
    private String q_id;
    private String tea_id;
    private String teaA_content;
    private int teaA_nice;
    private int teaA_tread;
    private Date teaA_time;

    public teaAnswer() {}

    public teaAnswer(String teaA_id, String q_id, String tea_id, String teaA_content, int teaA_nice, int teaA_tread, Date teaA_time) {
        this.teaA_id = teaA_id;
        this.q_id = q_id;
        this.tea_id = tea_id;
        this.teaA_content = teaA_content;
        this.teaA_nice = teaA_nice;
        this.teaA_tread = teaA_tread;
        this.teaA_time = teaA_time;
    }

    public String getTeaA_id() {
        return teaA_id;
    }

    public void setTeaA_id(String teaA_id) {
        this.teaA_id = teaA_id;
    }

    public String getQ_id() {
        return q_id;
    }

    public void setQ_id(String q_id) {
        this.q_id = q_id;
    }

    public String getTea_id() {
        return tea_id;
    }

    public void setTea_id(String tea_id) {
        this.tea_id = tea_id;
    }

    public String getTeaA_content() {
        return teaA_content;
    }

    public void setTeaA_content(String teaA_content) {
        this.teaA_content = teaA_content;
    }

    public int getTeaA_nice() {
        return teaA_nice;
    }

    public void setTeaA_nice(int teaA_nice) {
        this.teaA_nice = teaA_nice;
    }

    public int getTeaA_tread() {
        return teaA_tread;
    }

    public void setTeaA_tread(int teaA_tread) {
        this.teaA_tread = teaA_tread;
    }

    public Date getTeaA_time() {
        return teaA_time;
    }

    public void setTeaA_time(Date teaA_time) {
        this.teaA_time = teaA_time;
    }
}
