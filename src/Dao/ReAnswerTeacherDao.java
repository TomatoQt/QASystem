package Dao;

import Bean.ReAnswerStudent;
import Bean.ReAnswerTeacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReAnswerTeacherDao extends BaseDao{
    public boolean addReAnsTea(ReAnswerTeacher reAnswerTeacher) {
        String sql="INSERT INTO ReAnswerTeacher(rAnsTea_id, teaA_id, rAnsTea_content, rAnsTea_time, rAnsTea_nice, rAnsTea_tread) VALUES(?,?,?,?,?,?)";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,reAnswerTeacher.getrAnsTea_id());
            pstmt.setString(2,reAnswerTeacher.getTeaA_id());
            pstmt.setString(3,reAnswerTeacher.getrAnsTea_content());
            pstmt.setDate(4,reAnswerTeacher.getrAnsTea_time());
            pstmt.setInt(5,reAnswerTeacher.getrAnsTea_nice());
            pstmt.setInt(6,reAnswerTeacher.getrAnsTea_tread());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public boolean deleteReAnsTea(String id){
        String sql="DELETE FROM ReAnswerTeacher WHERE rAnsTea_id=?";
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

    public boolean updateReAnsTea(ReAnswerTeacher reAnswerTeacher){
        String sql="UPDATE ReAnswerTeacher SET teaA_id=?,rAnsTea_content=?,rAnsTea_time=?,rAnsTea_nice=?,rAnsTea_tread=? WHERE rAnsTea_id=?";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,reAnswerTeacher.getTeaA_id());
            pstmt.setString(2,reAnswerTeacher.getrAnsTea_content());
            pstmt.setDate(3,reAnswerTeacher.getrAnsTea_time());
            pstmt.setInt(4,reAnswerTeacher.getrAnsTea_nice());
            pstmt.setInt(5,reAnswerTeacher.getrAnsTea_tread());
            pstmt.setString(6,reAnswerTeacher.getrAnsTea_id());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public ReAnswerTeacher findById(String id){
        String sql="SELECT * FROM ReAnswerTeacher WHERE rAnsTea_id=?";
        ReAnswerTeacher reAnswerTeacher=new ReAnswerTeacher();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,id);
            ResultSet rst=pstmt.executeQuery();
            if (rst.next()) {
                reAnswerTeacher.setrAnsTea_id(rst.getString("rAnsTea_id"));
                reAnswerTeacher.setTeaA_id(rst.getString("teaA_id"));
                reAnswerTeacher.setrAnsTea_content(rst.getString("rAnsTea_content"));
                reAnswerTeacher.setrAnsTea_time(rst.getDate("rAnsTea_time"));
                reAnswerTeacher.setrAnsTea_nice(rst.getInt("rAnsTea_nice"));
                reAnswerTeacher.setrAnsTea_tread(rst.getInt("rAnsTea_tread"));
            }
            connection.close();
            return reAnswerTeacher;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    public ArrayList<ReAnswerTeacher> findByTeaAnswerId(String teaA_id){
        String sql="SELECT * FROM ReAnswerTeacher WHERE teaA_id=?";
        ArrayList<ReAnswerTeacher> rAnsTeaList=new ArrayList<ReAnswerTeacher>();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,teaA_id);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()) {
                ReAnswerTeacher reAnswerTeacher=new ReAnswerTeacher();
                reAnswerTeacher.setrAnsTea_id(rst.getString("rAnsTea_id"));
                reAnswerTeacher.setTeaA_id(rst.getString("teaA_id"));
                reAnswerTeacher.setrAnsTea_content(rst.getString("rAnsTea_content"));
                reAnswerTeacher.setrAnsTea_time(rst.getDate("rAnsTea_time"));
                reAnswerTeacher.setrAnsTea_nice(rst.getInt("rAnsTea_nice"));
                reAnswerTeacher.setrAnsTea_tread(rst.getInt("rAnsTea_tread"));
                rAnsTeaList.add(reAnswerTeacher);
            }
            connection.close();
            return rAnsTeaList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    public int getBigId(){
        String sql="SELECT * FROM ReAnswerTeacher";
        ArrayList<ReAnswerTeacher> ratList=new ArrayList<ReAnswerTeacher>();
        int big=-1;
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                ReAnswerTeacher rat=new ReAnswerTeacher();
                rat.setrAnsTea_id(rst.getString("rAnsTea_id"));
                ratList.add(rat);
            }
            connection.close();
            if (ratList.size()==0){//问题库中没有问题
                return 0;
            }else {
                for (ReAnswerTeacher item : ratList) {
                    int temp = Integer.parseInt(item.getrAnsTea_id().substring(3));
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
