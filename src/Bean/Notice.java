package Bean;

public class Notice {
    private String id;
    private String title;
    private String content;
    private String time;
    private String adm_id;

    public Notice() {}

    public Notice(String id, String title, String content, String time, String adm_id) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.time = time;
        this.adm_id = adm_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAdm_id() {
        return adm_id;
    }

    public void setAdm_id(String adm_id) {
        this.adm_id = adm_id;
    }
}
