package Bean;

import java.sql.Date;

public class teaSuggestion {
    private String teaS_id;
    private String tea_id;
    private String teaS_title;
    private String teaS_content;
    private Date teaS_time;

    public teaSuggestion() {}

    public teaSuggestion(String teaS_id, String tea_id, String teaS_title, String teaS_content, Date teaS_time) {
        this.teaS_id = teaS_id;
        this.tea_id = tea_id;
        this.teaS_title = teaS_title;
        this.teaS_content = teaS_content;
        this.teaS_time = teaS_time;
    }

    public String getTeaS_id() {
        return teaS_id;
    }

    public void setTeaS_id(String teaS_id) {
        this.teaS_id = teaS_id;
    }

    public String getTea_id() {
        return tea_id;
    }

    public void setTea_id(String tea_id) {
        this.tea_id = tea_id;
    }

    public String getTeaS_title() {
        return teaS_title;
    }

    public void setTeaS_title(String teaS_title) {
        this.teaS_title = teaS_title;
    }

    public String getTeaS_content() {
        return teaS_content;
    }

    public void setTeaS_content(String teaS_content) {
        this.teaS_content = teaS_content;
    }

    public Date getTeaS_time() {
        return teaS_time;
    }

    public void setTeaS_time(Date teaS_time) {
        this.teaS_time = teaS_time;
    }
}
