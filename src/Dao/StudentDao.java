package Dao;

import Bean.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao extends BaseDao{
    public boolean addStudent(Student student){
        String sql="INSERT INTO Student(stu_id,stu_nickname,stu_password,stu_name,stu_phone,stu_sex,stu_email,stu_idCard,stu_recentSpeak) VALUES(?,?,?,?,?,?,?,?,?)";
        try{
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,student.getId());
            pstmt.setString(2,student.getNickname());
            pstmt.setString(3,student.getPassword());
            pstmt.setString(4,student.getName());
            pstmt.setString(5,student.getPhone());
            pstmt.setInt(6,student.getSex()?1:0);
            pstmt.setString(7,student.getEmail());
            pstmt.setString(8,student.getIdCard());
            pstmt.setString(9,student.getRecentSpeak());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public boolean deleteStudent(String id){
        String sql="DELETE FROM Student WHERE stu_id=?";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,id);
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public boolean updateStudent(Student student){
        String sql="UPDATE Student SET stu_nickname=?,stu_password=?,stu_name=?,stu_phone=?,stu_sex=?,stu_email=?,stu_idCard=?,stu_recentSpeak=? WHERE stu_id=?";
        try{
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,student.getNickname());
            pstmt.setString(2,student.getPassword());
            pstmt.setString(3,student.getName());
            pstmt.setString(4,student.getPhone());
            pstmt.setInt(5,student.getSex()?1:0);
            pstmt.setString(6,student.getEmail());
            pstmt.setString(7,student.getIdCard());
            pstmt.setString(8,student.getRecentSpeak());
            pstmt.setString(9,student.getId());
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public Student findById(String id){
        String sql="SELECT * FROM Student WHERE stu_id=?";
        Student student = new Student();
        try{
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,id);
            ResultSet rst=pstmt.executeQuery();
            if(rst.next()){
                student.setId(rst.getString("stu_id"));
                student.setNickname(rst.getString("stu_nickname"));
                student.setPassword(rst.getString("stu_password"));
                student.setName(rst.getString("stu_name"));
                student.setPhone(rst.getString("stu_phone"));
                student.setSex(rst.getBoolean("stu_sex"));//可能有问题
                student.setEmail(rst.getString("stu_email"));
                student.setIdCard(rst.getString("stu_idCard"));
                student.setRecentSpeak(rst.getString("stu_recentSpeak"));
            }
            connection.close();
            return student;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    public ArrayList<Student> findAllStudent(){
        String sql="SELECT * FROM Student";
        ArrayList<Student> studentList = new ArrayList<Student>();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                Student student=new Student();
                student.setId(rst.getString("stu_id"));
                student.setNickname(rst.getString("stu_nickname"));
                student.setPassword(rst.getString("stu_password"));
                student.setName(rst.getString("stu_name"));
                student.setPhone(rst.getString("stu_phone"));
                student.setSex(rst.getBoolean("stu_sex"));//可能有问题
                student.setEmail(rst.getString("stu_email"));
                student.setIdCard(rst.getString("stu_idCard"));
                student.setRecentSpeak(rst.getString("stu_recentSpeak"));
                studentList.add(student);
            }
            connection.close();
            return studentList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    public boolean login(String id,String password){
        String sql="SELECT * FROM Student WHERE stu_id=?";
        boolean result=false;
        try{
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,id);
            ResultSet rst=pstmt.executeQuery();
            if(rst.next()){
                if (rst.getString("stu_password").equals(password))
                    result=true;
                else
                    result=false;
            }
            connection.close();
            return result;
        }catch (SQLException se){
            se.printStackTrace();
            return result;
        }
    }
}
