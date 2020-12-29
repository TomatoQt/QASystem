package Bean;

import java.sql.Date;

public class Question {
    private String id;
    private String stu_id;
    private String title;
    private String content;
    private int click;
    private Date time;

    public Question() {}

    public Question(String id, String stu_id, String title, String content, int click, Date time) {
        this.id = id;
        this.stu_id = stu_id;
        this.title = title;
        this.content = content;
        this.click = click;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
