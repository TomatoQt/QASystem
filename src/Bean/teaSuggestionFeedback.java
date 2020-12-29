package Bean;

import java.sql.Date;

public class teaSuggestionFeedback {
    private String teaSugFd_id;
    private String teaS_id;
    private String adm_id;
    private String teaSugFd_content;
    private Date teaSugFd_time;

    public teaSuggestionFeedback() {}

    public teaSuggestionFeedback(String teaSugFd_id, String teaS_id, String adm_id, String teaSugFd_content, Date teaSugFd_time) {
        this.teaSugFd_id = teaSugFd_id;
        this.teaS_id = teaS_id;
        this.adm_id = adm_id;
        this.teaSugFd_content = teaSugFd_content;
        this.teaSugFd_time = teaSugFd_time;
    }

    public String getTeaSugFd_id() {
        return teaSugFd_id;
    }

    public void setTeaSugFd_id(String teaSugFd_id) {
        this.teaSugFd_id = teaSugFd_id;
    }

    public String getTeaS_id() {
        return teaS_id;
    }

    public void setTeaS_id(String teaS_id) {
        this.teaS_id = teaS_id;
    }

    public String getAdm_id() {
        return adm_id;
    }

    public void setAdm_id(String adm_id) {
        this.adm_id = adm_id;
    }

    public String getTeaSugFd_content() {
        return teaSugFd_content;
    }

    public void setTeaSugFd_content(String teaSugFd_content) {
        this.teaSugFd_content = teaSugFd_content;
    }

    public Date getTeaSugFd_time() {
        return teaSugFd_time;
    }

    public void setTeaSugFd_time(Date teaSugFd_time) {
        this.teaSugFd_time = teaSugFd_time;
    }
}
