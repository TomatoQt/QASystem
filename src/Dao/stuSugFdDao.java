package Dao;

import Bean.StuSuggestion;
import Bean.stuSuggestionFeedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.WeakHashMap;

public class stuSugFdDao extends BaseDao{
    public boolean addStuSugFd(stuSuggestionFeedback stuSugFd){
        String sql="INSERT INTO stuSuggestionFeedback(stuSugFd_id, stuS_id, adm_id, stuSugFd_content, stuSugFd_time) VALUES(?,?,?,?,?)";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,stuSugFd.getStuSugFd_id());
            pstmt.setString(2,stuSugFd.getStuS_id());
            pstmt.setString(3,stuSugFd.getAdm_id());
            pstmt.setString(4,stuSugFd.getStuSugFd_content());
            pstmt.setString(5,stuSugFd.getStuSugFd_time());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public boolean deleteStuSugFd(String stuSugFd_id){
        String sql="DELETE FROM stuSuggestionFeedback WHERE stuSugFd_id=?";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,stuSugFd_id);
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public boolean updateStuSugFd(stuSuggestionFeedback stuSugFd){
        String sql="UPDATE stuSuggestionFeedback SET stuS_id=?,adm_id=?,stuSugFd_content=?,stuSugFd_time=? WHERE stuSugFd_id=?";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,stuSugFd.getStuS_id());
            pstmt.setString(2,stuSugFd.getAdm_id());
            pstmt.setString(3,stuSugFd.getStuSugFd_content());
            pstmt.setString(4,stuSugFd.getStuSugFd_time());
            pstmt.setString(5,stuSugFd.getStuSugFd_id());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public stuSuggestionFeedback findById(String stuSugFd_id){
        String sql="SELECT * FROM stuSuggestionFeedback WHERE stuSugFd_id=?";
        stuSuggestionFeedback stuSugFd=new stuSuggestionFeedback();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,stuSugFd_id);
            ResultSet rst=pstmt.executeQuery();
            if (rst.next()) {
                stuSugFd.setStuSugFd_id(rst.getString("stuSugFd_id"));
                stuSugFd.setStuS_id(rst.getString("stuS_id"));
                stuSugFd.setAdm_id(rst.getString("adm_id"));
                stuSugFd.setStuSugFd_content(rst.getString("stuSugFd_content"));
                stuSugFd.setStuSugFd_time(rst.getString("stuSugFd_time"));
            }
            connection.close();
            return stuSugFd;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    //根据学生的投诉建议来查找对应的反馈
    public ArrayList<stuSuggestionFeedback> findByStuSug_id(String stuSug_id){
        String sql="SELECT * FROM stuSuggestionFeedback WHERE stuS_id=?";
        ArrayList<stuSuggestionFeedback> stuSugFdList=new ArrayList<stuSuggestionFeedback>();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,stuSug_id);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                stuSuggestionFeedback stuSugFd=new stuSuggestionFeedback();
                stuSugFd.setStuSugFd_id(rst.getString("stuSugFd_id"));
                stuSugFd.setStuS_id(rst.getString("stuS_id"));
                stuSugFd.setAdm_id(rst.getString("adm_id"));
                stuSugFd.setStuSugFd_content(rst.getString("stuSugFd_content"));
                stuSugFd.setStuSugFd_time(rst.getString("stuSugFd_time"));
                stuSugFdList.add(stuSugFd);
            }
            connection.close();
            return stuSugFdList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    //根据管理员id来查找反馈
    public ArrayList<stuSuggestionFeedback> findByAdm_id(String adm_id){
        String sql="SELECT * FROM stuSuggestionFeedback WHERE adm_id=?";
        ArrayList<stuSuggestionFeedback> stuSugFdList=new ArrayList<stuSuggestionFeedback>();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,adm_id);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                stuSuggestionFeedback stuSugFd=new stuSuggestionFeedback();
                stuSugFd.setStuSugFd_id(rst.getString("stuSugFd_id"));
                stuSugFd.setStuS_id(rst.getString("stuS_id"));
                stuSugFd.setAdm_id(rst.getString("adm_id"));
                stuSugFd.setStuSugFd_content(rst.getString("stuSugFd_content"));
                stuSugFd.setStuSugFd_time(rst.getString("stuSugFd_time"));
                stuSugFdList.add(stuSugFd);
            }
            connection.close();
            return stuSugFdList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    public int getBigId(){
        String sql="SELECT * FROM stuSuggestionFeedback";
        ArrayList<stuSuggestionFeedback> stuSuggestionFeedbacks=new ArrayList<stuSuggestionFeedback>();
        int big=-1;
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                stuSuggestionFeedback ssfd=new stuSuggestionFeedback();
                ssfd.setStuSugFd_id(rst.getString("stuSugFd_id"));
                stuSuggestionFeedbacks.add(ssfd);
            }
            connection.close();
            if (stuSuggestionFeedbacks.size()==0){//问题库中没有问题
                return 0;
            }else {
                for (stuSuggestionFeedback item : stuSuggestionFeedbacks) {
                    int temp = Integer.parseInt(item.getStuSugFd_id().substring(3));
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
