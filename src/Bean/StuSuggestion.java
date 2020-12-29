package Bean;

import java.sql.Date;

public class StuSuggestion {
    private String stuS_id;
    private String stu_id;
    private String stuS_title;
    private String stuS_content;
    private Date stuS_time;

    public StuSuggestion() {}

    public StuSuggestion(String stuS_id, String stu_id, String stuS_title, String stuS_content, Date stuS_time) {
        this.stuS_id = stuS_id;
        this.stu_id = stu_id;
        this.stuS_title = stuS_title;
        this.stuS_content = stuS_content;
        this.stuS_time = stuS_time;
    }

    public String getStuS_id() {
        return stuS_id;
    }

    public void setStuS_id(String stuS_id) {
        this.stuS_id = stuS_id;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getStuS_title() {
        return stuS_title;
    }

    public void setStuS_title(String stuS_title) {
        this.stuS_title = stuS_title;
    }

    public String getStuS_content() {
        return stuS_content;
    }

    public void setStuS_content(String stuS_content) {
        this.stuS_content = stuS_content;
    }

    public Date getStuS_time() {
        return stuS_time;
    }

    public void setStuS_time(Date stuS_time) {
        this.stuS_time = stuS_time;
    }
}
