package Bean;

public class ReAskTeacher extends CompareTea{
    private String rAskTea_id;
    private String teaA_id;
    private String rAskTea_content;
    private String rAskTea_time;

    public ReAskTeacher() {
        super();
    }

    public ReAskTeacher(String rAskTea_id, String teaA_id, String rAskTea_content, String rAskTea_time) {
        super(rAskTea_time);
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

    public String getrAskTea_time() {
        return rAskTea_time;
    }

    public void setrAskTea_time(String rAskTea_time) {
        super.setDate(rAskTea_time);
        this.rAskTea_time = rAskTea_time;
    }
}
