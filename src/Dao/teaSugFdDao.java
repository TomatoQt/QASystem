package Dao;

import Bean.teaSuggestion;
import Bean.teaSuggestionFeedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class teaSugFdDao extends BaseDao{
    public boolean addTeaSugFd(teaSuggestionFeedback tSFd){
        String sql="INSERT INTO teaSuggestionFeedback(teaSugFd_id, teaS_id, adm_id, teaSugFd_content, teaSugFd_time) VALUES(?,?,?,?,?)";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1, tSFd.getTeaSugFd_id());
            pstmt.setString(2, tSFd.getTeaS_id());
            pstmt.setString(3, tSFd.getAdm_id());
            pstmt.setString(4, tSFd.getTeaSugFd_content());
            pstmt.setDate(5, tSFd.getTeaSugFd_time());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public boolean deleteTeaSugFd(String teaSugFd_id){
        String sql="DELETE FROM teaSuggestionFeedback WHERE teaSugFd_id=?";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,teaSugFd_id);
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public boolean updateTeaSugFd(teaSuggestionFeedback tSFd){
        String sql="UPDATE teaSuggestionFeedback SET teaS_id=?,adm_id=?,teaSugFd_content=?,teaSugFd_time=? WHERE teaSugFd_id=?";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1, tSFd.getTeaS_id());
            pstmt.setString(2, tSFd.getAdm_id());
            pstmt.setString(3, tSFd.getTeaSugFd_content());
            pstmt.setDate(4, tSFd.getTeaSugFd_time());
            pstmt.setString(5, tSFd.getTeaSugFd_id());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public teaSuggestionFeedback findById(String teaSugFd_id){
        String sql="SELECT * FROM teaSuggestionFeedback WHERE teaSugFd_id=?";
        teaSuggestionFeedback tSFd=new teaSuggestionFeedback();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,teaSugFd_id);
            ResultSet rst=pstmt.executeQuery();
            if (rst.next()){
                tSFd.setTeaSugFd_id(rst.getString("teaSugFd_id"));
                tSFd.setTeaS_id(rst.getString("teaS_id"));
                tSFd.setAdm_id(rst.getString("adm_id"));
                tSFd.setTeaSugFd_content(rst.getString("teaSugFd_content"));
                tSFd.setTeaSugFd_time(rst.getDate("teaSugFd_time"));
            }
            connection.close();
            return tSFd;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    public ArrayList<teaSuggestionFeedback> findByTeaS_id(String teaS_id){
        String sql="SELECT * FROM teaSuggestionFeedback WHERE teaS_id=?";
        ArrayList<teaSuggestionFeedback> tSFdList=new ArrayList<teaSuggestionFeedback>();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,teaS_id);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                teaSuggestionFeedback tSFd=new teaSuggestionFeedback();
                tSFd.setTeaSugFd_id(rst.getString("teaSugFd_id"));
                tSFd.setTeaS_id(rst.getString("teaS_id"));
                tSFd.setAdm_id(rst.getString("adm_id"));
                tSFd.setTeaSugFd_content(rst.getString("teaSugFd_content"));
                tSFd.setTeaSugFd_time(rst.getDate("teaSugFd_time"));
                tSFdList.add(tSFd);
            }
            connection.close();
            return tSFdList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    public ArrayList<teaSuggestionFeedback> findByAdm_id(String adm_id){
        String sql="SELECT * FROM teaSuggestionFeedback WHERE adm_id=?";
        ArrayList<teaSuggestionFeedback> tSFdList=new ArrayList<teaSuggestionFeedback>();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,adm_id);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                teaSuggestionFeedback tSFd=new teaSuggestionFeedback();
                tSFd.setTeaSugFd_id(rst.getString("teaSugFd_id"));
                tSFd.setTeaS_id(rst.getString("teaS_id"));
                tSFd.setAdm_id(rst.getString("adm_id"));
                tSFd.setTeaSugFd_content(rst.getString("teaSugFd_content"));
                tSFd.setTeaSugFd_time(rst.getDate("teaSugFd_time"));
                tSFdList.add(tSFd);
            }
            connection.close();
            return tSFdList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    public int getBigId(){
        String sql="SELECT * FROM teaSuggestionFeedback";
        ArrayList<teaSuggestionFeedback> teaSuggestionFeedbacks=new ArrayList<teaSuggestionFeedback>();
        int big=-1;
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                teaSuggestionFeedback tsfd=new teaSuggestionFeedback();
                tsfd.setTeaSugFd_id(rst.getString("teaSugFd_id"));
                teaSuggestionFeedbacks.add(tsfd);
            }
            connection.close();
            if (teaSuggestionFeedbacks.size()==0){//问题库中没有问题
                return 0;
            }else {
                for (teaSuggestionFeedback item : teaSuggestionFeedbacks) {
                    int temp = Integer.parseInt(item.getTeaSugFd_id().substring(3));
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
