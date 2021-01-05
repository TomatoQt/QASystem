package Bean;

public class stuSuggestionFeedback {
    private String stuSugFd_id;
    private String stuS_id;
    private String adm_id;
    private String stuSugFd_content;
    private String stuSugFd_time;

    public stuSuggestionFeedback() {}

    public stuSuggestionFeedback(String stuSugFd_id, String stuS_id, String adm_id, String stuSugFd_content, String stuSugFd_time) {
        this.stuSugFd_id = stuSugFd_id;
        this.stuS_id = stuS_id;
        this.adm_id = adm_id;
        this.stuSugFd_content = stuSugFd_content;
        this.stuSugFd_time = stuSugFd_time;
    }

    public String getStuSugFd_id() {
        return stuSugFd_id;
    }

    public void setStuSugFd_id(String stuSugFd_id) {
        this.stuSugFd_id = stuSugFd_id;
    }

    public String getStuS_id() {
        return stuS_id;
    }

    public void setStuS_id(String stuS_id) {
        this.stuS_id = stuS_id;
    }

    public String getAdm_id() {
        return adm_id;
    }

    public void setAdm_id(String adm_id) {
        this.adm_id = adm_id;
    }

    public String getStuSugFd_content() {
        return stuSugFd_content;
    }

    public void setStuSugFd_content(String stuSugFd_content) {
        this.stuSugFd_content = stuSugFd_content;
    }

    public String getStuSugFd_time() {
        return stuSugFd_time;
    }

    public void setStuSugFd_time(String stuSugFd_time) {
        this.stuSugFd_time = stuSugFd_time;
    }
}
