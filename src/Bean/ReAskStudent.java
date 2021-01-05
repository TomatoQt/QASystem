package Bean;

public class ReAskStudent extends CompareStu{
    private String rAskStu_id;
    private String stuA_id;
    private String rAskStu_content;
    private String rAskStu_time;

    public ReAskStudent(){
        super();
    }

    public ReAskStudent(String rAskStu_id, String stuA_id, String rAskStu_content, String rAskStu_time) {
        super(rAskStu_time);
        this.rAskStu_id = rAskStu_id;
        this.stuA_id = stuA_id;
        this.rAskStu_content = rAskStu_content;
        this.rAskStu_time = rAskStu_time;
    }

    public String getrAskStu_id() {
        return rAskStu_id;
    }

    public void setrAskStu_id(String rAskStu_id) {
        this.rAskStu_id = rAskStu_id;
    }

    public String getStuA_id() {
        return stuA_id;
    }

    public void setStuA_id(String stuA_id) {
        this.stuA_id = stuA_id;
    }

    public String getrAskStu_content() {
        return rAskStu_content;
    }

    public void setrAskStu_content(String rAskStu_content) {
        this.rAskStu_content = rAskStu_content;
    }

    public String getrAskStu_time() {
        return rAskStu_time;
    }

    public void setrAskStu_time(String rAskStu_time) {
        this.rAskStu_time = rAskStu_time;
        super.setDate(rAskStu_time);
    }
}
