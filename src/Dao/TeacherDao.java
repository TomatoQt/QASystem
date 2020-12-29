package Dao;

import Bean.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherDao extends BaseDao{
    public boolean addTeacher(Teacher teacher){
        String sql="INSERT INTO Teacher(tea_id,tea_nickname,tea_password,tea_name,tea_sex,tea_phone,tea_email,tea_idCard) VALUES(?,?,?,?,?,?,?,?)";
        try{
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,teacher.getId());
            pstmt.setString(2,teacher.getNickname());
            pstmt.setString(3,teacher.getPassword());
            pstmt.setString(4,teacher.getName());
            pstmt.setInt(5,teacher.getSex()?1:0);
            pstmt.setString(6,teacher.getPhone());
            pstmt.setString(7,teacher.getEmail());
            pstmt.setString(8,teacher.getIdCard());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public boolean deleteTeacher(String id){
        String sql="DELETE FROM Teacher WHERE tea_id=?";
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

    public boolean updateTeacher(Teacher teacher){
        String sql="UPDATE Teacher SET tea_nickname=?,tea_password=?,tea_name=?,tea_sex=?,tea_phone=?,tea_email=?,tea_idCard=? WHERE tea_id=?";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,teacher.getNickname());
            pstmt.setString(2,teacher.getPassword());
            pstmt.setString(3,teacher.getName());
            pstmt.setInt(4,teacher.getSex()?1:0);
            pstmt.setString(5,teacher.getPhone());
            pstmt.setString(6,teacher.getEmail());
            pstmt.setString(7,teacher.getIdCard());
            pstmt.setString(8,teacher.getId());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public Teacher findById(String id){
        String sql="SELECT * FROM Teacher WHERE tea_id=?";
        Teacher teacher=new Teacher();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,id);
            ResultSet rst=pstmt.executeQuery();
            if (rst.next()){
                teacher.setId(rst.getString("tea_id"));
                teacher.setNickname(rst.getString("tea_nickname"));
                teacher.setPassword(rst.getString("tea_password"));
                teacher.setName(rst.getString("tea_name"));
                teacher.setSex(rst.getBoolean("tea_sex"));//可能有问题
                teacher.setPhone(rst.getString("tea_phone"));
                teacher.setEmail(rst.getString("tea_email"));
                teacher.setIdCard(rst.getString("tea_idCard"));
            }
            connection.close();
            return teacher;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    public ArrayList<Teacher> findAllTeacher(){
        String sql="SELECT * FROM Teacher";
        ArrayList<Teacher> teacherList=new ArrayList<Teacher>();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()) {
                Teacher teacher=new Teacher();
                teacher.setId(rst.getString("tea_id"));
                teacher.setNickname(rst.getString("tea_nickname"));
                teacher.setPassword(rst.getString("tea_password"));
                teacher.setName(rst.getString("tea_name"));
                teacher.setSex(rst.getBoolean("tea_sex"));//可能有问题
                teacher.setPhone(rst.getString("tea_phone"));
                teacher.setEmail(rst.getString("tea_email"));
                teacher.setIdCard(rst.getString("tea_idCard"));
                teacherList.add(teacher);
            }
            connection.close();
            return teacherList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    public boolean login(String id,String password){
        String sql="SELECT * FROM Teacher WHERE tea_id=?";
        boolean result=false;
        try{
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,id);
            ResultSet rst=pstmt.executeQuery();
            if(rst.next()){
                if (rst.getString("tea_password").equals(password))
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
