package Dao;

import Bean.teaSuggestion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class teaSugDao extends BaseDao{
    public boolean addTeaSug(teaSuggestion tS){
        String sql="INSERT INTO teaSuggestion(teaS_id, tea_id, teaS_title, teaS_content, teaS_time) VALUES(?,?,?,?,?)";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,tS.getTeaS_id());
            pstmt.setString(2,tS.getTea_id());
            pstmt.setString(3,tS.getTeaS_title());
            pstmt.setString(4,tS.getTeaS_content());
            pstmt.setDate(5,tS.getTeaS_time());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public boolean deleteTeaSug(String teaS_id){
        String sql="DELETE FROM teaSuggestion WHERE teaS_id=?";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,teaS_id);
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public boolean updateTeaSug(teaSuggestion tS){
        String sql="UPDATE teaSuggestion SET tea_id=?,teaS_title=?,teaS_content=?,teaS_time=? WHERE teaS_id=?";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1, tS.getTea_id());
            pstmt.setString(2,tS.getTeaS_title());
            pstmt.setString(3,tS.getTeaS_content());
            pstmt.setDate(4,tS.getTeaS_time());
            pstmt.setString(5, tS.getTeaS_id());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public teaSuggestion findById(String teaS_id){
        String sql="SELECT * FROM teaSuggestion WHERE teaS_id=?";
        teaSuggestion tS=new teaSuggestion();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,teaS_id);
            ResultSet rst=pstmt.executeQuery();
            if (rst.next()){
                tS.setTeaS_id(rst.getString("teaS_id"));
                tS.setTea_id(rst.getString("tea_id"));
                tS.setTeaS_title(rst.getString("teaS_title"));
                tS.setTeaS_content(rst.getString("teaS_content"));
                tS.setTeaS_time(rst.getDate("teaS_time"));
            }
            connection.close();
            return tS;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    public ArrayList<teaSuggestion> findByTea_id(String tea_id){
        String sql="SELECT * FROM teaSuggestion WHERE tea_id=?";
        ArrayList<teaSuggestion> tSList=new ArrayList<teaSuggestion>();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,tea_id);
            ResultSet rst=pstmt.executeQuery();
            if (rst.next()){
                teaSuggestion tS=new teaSuggestion();
                tS.setTeaS_id(rst.getString("teaS_id"));
                tS.setTea_id(rst.getString("tea_id"));
                tS.setTeaS_title(rst.getString("teaS_title"));
                tS.setTeaS_content(rst.getString("teaS_content"));
                tS.setTeaS_time(rst.getDate("teaS_time"));
                tSList.add(tS);
            }
            connection.close();
            return tSList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }
}