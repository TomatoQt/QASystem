package Dao;

import Bean.StuAnswer;
import Bean.teaAnswer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class teaAnsDao extends BaseDao{
    public boolean addTeaAns(teaAnswer tA){
        String sql="INSERT INTO teaAnswer(teaA_id, q_id, tea_id, teaA_content, teaA_nice, teaA_tread, teaA_time) VALUES(?,?,?,?,?,?,?)";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,tA.getTeaA_id());
            pstmt.setString(2,tA.getQ_id());
            pstmt.setString(3,tA.getTea_id());
            pstmt.setString(4,tA.getTeaA_content());
            pstmt.setInt(5,tA.getTeaA_nice());
            pstmt.setInt(6,tA.getTeaA_tread());
            pstmt.setString(7,tA.getTeaA_time());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public boolean deleteTeaAns(String teaA_id){
        String sql="DELETE FROM teaAnswer WHERE teaA_id=?";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,teaA_id);
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public boolean updateTeaAns(teaAnswer tA){
        String sql="UPDATE teaAnswer SET q_id=?,tea_id=?,teaA_content=?,teaA_nice=?,teaA_tread=?,teaA_time=? WHERE teaA_id=?";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,tA.getQ_id());
            pstmt.setString(2,tA.getTea_id());
            pstmt.setString(3,tA.getTeaA_content());
            pstmt.setInt(4,tA.getTeaA_nice());
            pstmt.setInt(5,tA.getTeaA_tread());
            pstmt.setString(6,tA.getTeaA_time());
            pstmt.setString(7,tA.getTeaA_id());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public teaAnswer findById(String teaA_id){
        String sql="SELECT * FROM teaAnswer WHERE teaA_id=?";
        teaAnswer tA=new teaAnswer();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,teaA_id);
            ResultSet rst=pstmt.executeQuery();
            if (rst.next()) {
                tA.setTeaA_id(rst.getString("teaA_id"));
                tA.setQ_id(rst.getString("q_id"));
                tA.setTea_id(rst.getString("tea_id"));
                tA.setTeaA_content(rst.getString("teaA_content"));
                tA.setTeaA_nice(rst.getInt("teaA_nice"));
                tA.setTeaA_tread(rst.getInt("teaA_tread"));
                tA.setTeaA_time(rst.getString("teaA_time"));
            }
            connection.close();
            return tA;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    //找某个问题q_id下的所有教师回答
    public ArrayList<teaAnswer> findByQstnId(String q_id){
        String sql="SELECT * FROM teaAnswer WHERE q_id=?";
        ArrayList<teaAnswer> tAList=new ArrayList<teaAnswer>();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,q_id);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()) {
                teaAnswer tA=new teaAnswer();
                tA.setTeaA_id(rst.getString("teaA_id"));
                tA.setQ_id(rst.getString("q_id"));
                tA.setTea_id(rst.getString("tea_id"));
                tA.setTeaA_content(rst.getString("teaA_content"));
                tA.setTeaA_nice(rst.getInt("teaA_nice"));
                tA.setTeaA_tread(rst.getInt("teaA_tread"));
                tA.setTeaA_time(rst.getString("teaA_time"));
                tAList.add(tA);
            }
            connection.close();
            return tAList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    //找某个教师tea_id下的所有回答
    public ArrayList<teaAnswer> findByTeaId(String tea_id){
        String sql="SELECT * FROM teaAnswer WHERE tea_id=?";
        ArrayList<teaAnswer> tAList=new ArrayList<teaAnswer>();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,tea_id);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()) {
                teaAnswer tA=new teaAnswer();
                tA.setTeaA_id(rst.getString("teaA_id"));
                tA.setQ_id(rst.getString("q_id"));
                tA.setTea_id(rst.getString("tea_id"));
                tA.setTeaA_content(rst.getString("teaA_content"));
                tA.setTeaA_nice(rst.getInt("teaA_nice"));
                tA.setTeaA_tread(rst.getInt("teaA_tread"));
                tA.setTeaA_time(rst.getString("teaA_time"));
                tAList.add(tA);
            }
            connection.close();
            return tAList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    //获取id最大的教师回答id
    public int getBigId(){
        String sql="SELECT * FROM teaAnswer";
        ArrayList<teaAnswer> tAList=new ArrayList<teaAnswer>();
        int big=-1;
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                teaAnswer tA=new teaAnswer();
                tA.setTeaA_id(rst.getString("teaA_id"));
                tA.setQ_id(rst.getString("q_id"));
                tA.setTea_id(rst.getString("tea_id"));
                tA.setTeaA_content(rst.getString("teaA_content"));
                tA.setTeaA_nice(rst.getInt("teaA_nice"));
                tA.setTeaA_tread(rst.getInt("teaA_tread"));
                tA.setTeaA_time(rst.getString("teaA_time"));
                tAList.add(tA);
            }
            connection.close();
            if (tAList.size()==0){//问题库中没有问题
                return 0;
            }else {
                for (teaAnswer TA : tAList) {
                    int temp = Integer.parseInt(TA.getTeaA_id().substring(2));
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
