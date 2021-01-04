package Dao;

import Bean.Notice;
import Bean.ReAnswerStudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReAnswerStudentDao extends BaseDao{
    public boolean addReAnsStu(ReAnswerStudent reAnswerStudent){
        String sql="INSERT INTO ReAnswerStudent(rAnsStu_id, stuA_id, rAnsStu_content, rAnsStu_time, rAnsStu_nice, rAnsStu_tread) VALUES(?,?,?,?,?,?)";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,reAnswerStudent.getrAnsStu_id());
            pstmt.setString(2,reAnswerStudent.getStuA_id());
            pstmt.setString(3,reAnswerStudent.getrAnsStu_content());
            pstmt.setDate(4,reAnswerStudent.getrAnsStu_time());
            pstmt.setInt(5,reAnswerStudent.getrAnsStu_nice());
            pstmt.setInt(6,reAnswerStudent.getrAnsStu_tread());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public boolean deleteReAnsStu(String id){
        String sql="DELETE FROM ReAnswerStudent WHERE rAnsStu_id=?";
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

    public boolean updateReAnsStu(ReAnswerStudent reAnswerStudent){
        String sql="UPDATE ReAnswerStudent SET stuA_id=?,rAnsStu_content=?,rAnsStu_time=?,rAnsStu_nice=?,rAnsStu_tread=? WHERE rAnsStu_id=?";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,reAnswerStudent.getStuA_id());
            pstmt.setString(2,reAnswerStudent.getrAnsStu_content());
            pstmt.setDate(3,reAnswerStudent.getrAnsStu_time());
            pstmt.setInt(4,reAnswerStudent.getrAnsStu_nice());
            pstmt.setInt(5,reAnswerStudent.getrAnsStu_tread());
            pstmt.setString(6,reAnswerStudent.getrAnsStu_id());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public ReAnswerStudent findById(String id){
        String sql="SELECT * FROM ReAnswerStudent WHERE rAnsStu_id=?";
        ReAnswerStudent reAnswerStudent=new ReAnswerStudent();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,id);
            ResultSet rst=pstmt.executeQuery();
            if(rst.next()){
                reAnswerStudent.setrAnsStu_id(rst.getString("rAnsStu_id"));
                reAnswerStudent.setStuA_id(rst.getString("stuA_id"));
                reAnswerStudent.setrAnsStu_content(rst.getString("rAnsStu_content"));
                reAnswerStudent.setrAnsStu_time(rst.getDate("rAnsStu_time"));
                reAnswerStudent.setrAnsStu_nice(rst.getInt("rAnsStu_nice"));
                reAnswerStudent.setrAnsStu_tread(rst.getInt("rAnsStu_tread"));
            }
            connection.close();
            return reAnswerStudent;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    //找出某学生回答下所有的学生复答
    public ArrayList<ReAnswerStudent> findByStuAnsId(String stuA_id){
        String sql="SELECT * FROM ReAnswerStudent WHERE stuA_id=?";
        ArrayList<ReAnswerStudent> reAnsStuList=new ArrayList<ReAnswerStudent>();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,stuA_id);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                ReAnswerStudent reAnswerStudent=new ReAnswerStudent();
                reAnswerStudent.setrAnsStu_id(rst.getString("rAnsStu_id"));
                reAnswerStudent.setStuA_id(rst.getString("stuA_id"));
                reAnswerStudent.setrAnsStu_content(rst.getString("rAnsStu_content"));
                reAnswerStudent.setrAnsStu_time(rst.getDate("rAnsStu_time"));
                reAnswerStudent.setrAnsStu_nice(rst.getInt("rAnsStu_nice"));
                reAnswerStudent.setrAnsStu_tread(rst.getInt("rAnsStu_tread"));
                reAnsStuList.add(reAnswerStudent);
            }
            connection.close();
            return reAnsStuList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    public int getBigId(){
        String sql="SELECT * FROM ReAnswerStudent";
        ArrayList<ReAnswerStudent> rasList=new ArrayList<ReAnswerStudent>();
        int big=-1;
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                ReAnswerStudent ras=new ReAnswerStudent();
                ras.setrAnsStu_id(rst.getString("rAnsStu_id"));
                rasList.add(ras);
            }
            connection.close();
            if (rasList.size()==0){//问题库中没有问题
                return 0;
            }else {
                for (ReAnswerStudent item : rasList) {
                    int temp = Integer.parseInt(item.getrAnsStu_id().substring(3));//跳过前三个字符,如RAS1
                    if (temp > big)
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
