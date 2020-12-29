package Dao;

import Bean.ReAskStudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReAskStudentDao extends BaseDao{
    public boolean addRAskStu(ReAskStudent reAskStudent){
        String sql="INSERT INTO ReAskStudent(rAskStu_id, stuA_id, rAskStu_content, rAskStu_time) VALUES(?,?,?,?)";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,reAskStudent.getrAskStu_id());
            pstmt.setString(2,reAskStudent.getStuA_id());
            pstmt.setString(3,reAskStudent.getrAskStu_content());
            pstmt.setDate(4,reAskStudent.getrAskStu_time());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public boolean deleteRAskStu(String rAskStu_id){
        String sql="DELETE FROM ReAskStudent WHERE rAskStu_id=?";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,rAskStu_id);
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public boolean updateRAskStu(ReAskStudent reAskStudent){
        String sql="UPDATE ReAskStudent SET stuA_id=?,rAskStu_content=?,rAskStu_time=? WHERE rAskStu_id=?";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,reAskStudent.getStuA_id());
            pstmt.setString(2,reAskStudent.getrAskStu_content());
            pstmt.setDate(3,reAskStudent.getrAskStu_time());
            pstmt.setString(4,reAskStudent.getrAskStu_id());
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public ReAskStudent findById(String rAskStu_id){
        String sql="SELECT * FROM ReAskStudent WHERE rAskStu_id=?";
        ReAskStudent reAskStudent=new ReAskStudent();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,rAskStu_id);
            ResultSet rst=pstmt.executeQuery();
            if (rst.next()) {
                reAskStudent.setrAskStu_id(rst.getString("rAskStu_id"));
                reAskStudent.setStuA_id(rst.getString("stuA_id"));
                reAskStudent.setrAskStu_content(rst.getString("rAskStu_content"));
                reAskStudent.setrAskStu_time(rst.getDate("rAskStu_time"));
            }
            connection.close();
            return reAskStudent;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    public ArrayList<ReAskStudent> findByStuA_id(String stuA_id){
        String sql="SELECT * FROM ReAskStudent WHERE stuA_id=?";
        ArrayList<ReAskStudent> rAskStuList=new ArrayList<ReAskStudent>();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,stuA_id);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()) {
                ReAskStudent reAskStudent=new ReAskStudent();
                reAskStudent.setrAskStu_id(rst.getString("rAskStu_id"));
                reAskStudent.setStuA_id(rst.getString("stuA_id"));
                reAskStudent.setrAskStu_content(rst.getString("rAskStu_content"));
                reAskStudent.setrAskStu_time(rst.getDate("rAskStu_time"));
                rAskStuList.add(reAskStudent);
            }
            connection.close();
            return rAskStuList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }
}
