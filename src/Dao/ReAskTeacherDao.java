package Dao;

import Bean.ReAskStudent;
import Bean.ReAskTeacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReAskTeacherDao extends BaseDao{
    public boolean addRAskTea(ReAskTeacher reAskTeacher){
        String sql="INSERT INTO ReAskTeacher(rAskTea_id, teaA_id, rAskTea_content, rAskTea_time) VALUES(?,?,?,?)";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,reAskTeacher.getrAskTea_id());
            pstmt.setString(2,reAskTeacher.getTeaA_id());
            pstmt.setString(3,reAskTeacher.getrAskTea_content());
            pstmt.setDate(4,reAskTeacher.getrAskTea_time());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public boolean deleteRAskTea(String rAskTea_id){
        String sql="DELETE FROM ReAskTeacher WHERE rAskTea_id=?";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,rAskTea_id);
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public boolean updateRAskTea(ReAskTeacher reAskTeacher){
        String sql="UPDATE ReAskTeacher SET teaA_id=?,rAskTea_content=?,rAskTea_time=? WHERE rAskTea_id=?";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,reAskTeacher.getTeaA_id());
            pstmt.setString(2,reAskTeacher.getrAskTea_content());
            pstmt.setDate(3,reAskTeacher.getrAskTea_time());
            pstmt.setString(4,reAskTeacher.getrAskTea_id());
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public ReAskTeacher findById(String rAskTea_id){
        String sql="SELECT * FROM ReAskTeacher WHERE rAskTea_id=?";
        ReAskTeacher reAskTeacher=new ReAskTeacher();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,rAskTea_id);
            ResultSet rst=pstmt.executeQuery();
            if (rst.next()) {
                reAskTeacher.setrAskTea_id(rst.getString("rAskTea_id"));
                reAskTeacher.setTeaA_id(rst.getString("teaA_id"));
                reAskTeacher.setrAskTea_content(rst.getString("rAskTea_content"));
                reAskTeacher.setrAskTea_time(rst.getDate("rAskTea_time"));
            }
            connection.close();
            return reAskTeacher;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    public ArrayList<ReAskTeacher> findByTeaA_id(String teaA_id){
        String sql="SELECT * FROM ReAskTeacher WHERE teaA_id=?";
        ArrayList<ReAskTeacher> rAskTeaList=new ArrayList<ReAskTeacher>();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,teaA_id);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()) {
                ReAskTeacher reAskTeacher=new ReAskTeacher();
                reAskTeacher.setrAskTea_id(rst.getString("rAskTea_id"));
                reAskTeacher.setTeaA_id(rst.getString("teaA_id"));
                reAskTeacher.setrAskTea_content(rst.getString("rAskTea_content"));
                reAskTeacher.setrAskTea_time(rst.getDate("rAskTea_time"));
            }
            connection.close();
            return rAskTeaList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    public int getBigId(){
        String sql="SELECT * FROM ReAskTeacher";
        ArrayList<ReAskTeacher> reAskTeachers=new ArrayList<ReAskTeacher>();
        int big=-1;
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                ReAskTeacher reAskTeacher=new ReAskTeacher();
                reAskTeacher.setrAskTea_id(rst.getString("rAskTea_id"));
                reAskTeachers.add(reAskTeacher);
            }
            connection.close();
            if (reAskTeachers.size()==0){//问题库中没有问题
                return 0;
            }else {
                for (ReAskTeacher item : reAskTeachers) {
                    int temp = Integer.parseInt(item.getrAskTea_id().substring(3));
                        big = temp;
                }
                return big;
            }
        }catch (SQLException se){
            se.printStackTrace();
            return big;
        }
    }
}
