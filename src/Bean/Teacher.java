package Bean;

public class Teacher {
    private String id;
    private String nickname;
    private String password;
    private String name;
    private Boolean sex;
    private String phone;
    private String email;
    private String idCard;

    public Teacher() {}

    public Teacher(String id, String nickname, String password, String name, Boolean sex, String phone, String email, String idCard) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.idCard = idCard;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
