package Dao;

import Bean.Question;
import Bean.StuAnswer;
import Bean.teaAnswer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class stuAnswerDao extends BaseDao{
    public boolean addStuAnswer(StuAnswer stuAnswer){
        String sql="INSERT INTO stuAnswer(stuA_id, q_id, stu_id, stuA_content, stuA_nice, stuA_tread, stuA_time) VALUES(?,?,?,?,?,?,?)";
        try{
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,stuAnswer.getStuA_id());
            pstmt.setString(2,stuAnswer.getQ_id());
            pstmt.setString(3,stuAnswer.getStu_id());
            pstmt.setString(4,stuAnswer.getStuA_content());
            pstmt.setInt(5,stuAnswer.getStuA_nice());
            pstmt.setInt(6,stuAnswer.getStuA_tread());
            pstmt.setString(7,stuAnswer.getStuA_time());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public boolean deleteStuAnswer(String id){
        String sql="DELETE FROM stuAnswer WHERE stuA_id=?";
        try{
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

    public boolean updateStuAnswer(StuAnswer stuAnswer){
        String sql="UPDATE stuAnswer SET q_id=?,stu_id=?,stuA_content=?,stuA_nice=?,stuA_tread=?,stuA_time=? WHERE stuA_id=?";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,stuAnswer.getQ_id());
            pstmt.setString(2,stuAnswer.getStu_id());
            pstmt.setString(3,stuAnswer.getStuA_content());
            pstmt.setInt(4,stuAnswer.getStuA_nice());
            pstmt.setInt(5,stuAnswer.getStuA_tread());
            pstmt.setString(6,stuAnswer.getStuA_time());
            pstmt.setString(7,stuAnswer.getStuA_id());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    //找某个问题q_id下的所有学生回答
    public ArrayList<StuAnswer> findByQstnId(String q_id){
        String sql="SELECT * FROM stuAnswer WHERE q_id=?";
        ArrayList<StuAnswer> sAList=new ArrayList<StuAnswer>();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,q_id);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()) {
                StuAnswer sA=new StuAnswer();
                sA.setStuA_id(rst.getString("stuA_id"));
                sA.setQ_id(rst.getString("q_id"));
                sA.setStu_id(rst.getString("stu_id"));
                sA.setStuA_content(rst.getString("stuA_content"));
                sA.setStuA_nice(rst.getInt("stuA_nice"));
                sA.setStuA_tread(rst.getInt("stuA_tread"));
                sA.setStuA_time(rst.getString("stuA_time"));
                sAList.add(sA);
            }
            connection.close();
            return sAList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    //找某个学生的所有回答
    public ArrayList<StuAnswer> findByStuId(String stu_id){
        String sql="SELECT * FROM stuAnswer WHERE stu_id=?";
        ArrayList<StuAnswer> sAList=new ArrayList<StuAnswer>();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,stu_id);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()) {
                StuAnswer sA=new StuAnswer();
                sA.setStuA_id(rst.getString("stuA_id"));
                sA.setQ_id(rst.getString("q_id"));
                sA.setStu_id(rst.getString("stu_id"));
                sA.setStuA_content(rst.getString("stuA_content"));
                sA.setStuA_nice(rst.getInt("stuA_nice"));
                sA.setStuA_tread(rst.getInt("stuA_tread"));
                sA.setStuA_time(rst.getString("stuA_time"));
                sAList.add(sA);
            }
            connection.close();
            return sAList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    //获取id最大的回答
    public int getBigId(){
        String sql="SELECT * FROM stuAnswer";
        ArrayList<StuAnswer> sAList=new ArrayList<StuAnswer>();
        int big=-1;
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                StuAnswer sA=new StuAnswer();
                sA.setStuA_id(rst.getString("stuA_id"));
                sA.setQ_id(rst.getString("q_id"));
                sA.setStu_id(rst.getString("stu_id"));
                sA.setStuA_content(rst.getString("stuA_content"));
                sA.setStuA_nice(rst.getInt("stuA_nice"));
                sA.setStuA_tread(rst.getInt("stuA_tread"));
                sA.setStuA_time(rst.getString("stuA_time"));
                sAList.add(sA);
            }
            connection.close();
            if (sAList.size()==0){//问题库中没有问题
                return 0;
            }else {
                for (StuAnswer SA : sAList) {
                    int temp = Integer.parseInt(SA.getStuA_id().substring(2));
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
