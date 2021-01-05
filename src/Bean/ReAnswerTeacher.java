package Bean;

public class ReAnswerTeacher extends CompareTea{
    private String rAnsTea_id;
    private String teaA_id;
    private String rAnsTea_content;
    private String rAnsTea_time;
    private int rAnsTea_nice;
    private int rAnsTea_tread;

    public ReAnswerTeacher() {
        super();
    }

    public ReAnswerTeacher(String rAnsTea_id, String teaA_id, String rAnsTea_content, String rAnsTea_time, int rAnsTea_nice, int rAnsTea_tread) {
        super(rAnsTea_time);
        this.rAnsTea_id = rAnsTea_id;
        this.teaA_id = teaA_id;
        this.rAnsTea_content = rAnsTea_content;
        this.rAnsTea_time = rAnsTea_time;
        this.rAnsTea_nice = rAnsTea_nice;
        this.rAnsTea_tread = rAnsTea_tread;
    }

    public String getrAnsTea_id() {
        return rAnsTea_id;
    }

    public void setrAnsTea_id(String rAnsTea_id) {
        this.rAnsTea_id = rAnsTea_id;
    }

    public String getTeaA_id() {
        return teaA_id;
    }

    public void setTeaA_id(String teaA_id) {
        this.teaA_id = teaA_id;
    }

    public String getrAnsTea_content() {
        return rAnsTea_content;
    }

    public void setrAnsTea_content(String rAnsTea_content) {
        this.rAnsTea_content = rAnsTea_content;
    }

    public String getrAnsTea_time() {
        return rAnsTea_time;
    }

    public void setrAnsTea_time(String rAnsTea_time) {
        super.setDate(rAnsTea_time);
        this.rAnsTea_time = rAnsTea_time;
    }

    public int getrAnsTea_nice() {
        return rAnsTea_nice;
    }

    public void setrAnsTea_nice(int rAnsTea_nice) {
        this.rAnsTea_nice = rAnsTea_nice;
    }

    public int getrAnsTea_tread() {
        return rAnsTea_tread;
    }

    public void setrAnsTea_tread(int rAnsTea_tread) {
        this.rAnsTea_tread = rAnsTea_tread;
    }
}
