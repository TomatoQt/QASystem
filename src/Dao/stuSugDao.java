package Dao;

import Bean.ReAskTeacher;
import Bean.StuSuggestion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class stuSugDao extends BaseDao{
    public boolean addStuSug(StuSuggestion stuSuggestion){
        String sql="INSERT INTO stuSuggestion(stuS_id, stu_id, stuS_title, stuS_content, stuS_time) VALUES(?,?,?,?,?)";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,stuSuggestion.getStuS_id());
            pstmt.setString(2,stuSuggestion.getStu_id());
            pstmt.setString(3,stuSuggestion.getStuS_title());
            pstmt.setString(4,stuSuggestion.getStuS_content());
            pstmt.setDate(5,stuSuggestion.getStuS_time());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public boolean deleteStuSug(String stuS_id){
        String sql="DELETE FROM stuSuggestion WHERE stuS_id=?";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,stuS_id);
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public boolean updateStuSug(StuSuggestion stuSuggestion){
        String sql="UPDATE stuSuggestion SET stu_id=?,stuS_title=?,stuS_content=?,stuS_time=? WHERE stuS_id=?";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,stuSuggestion.getStu_id());
            pstmt.setString(2,stuSuggestion.getStuS_title());
            pstmt.setString(3,stuSuggestion.getStuS_content());
            pstmt.setDate(4,stuSuggestion.getStuS_time());
            pstmt.setString(5,stuSuggestion.getStuS_id());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public StuSuggestion findById(String stuS_Id){
        String sql="SELECT * FROM stuSuggestion WHERE stuS_id=?";
        StuSuggestion stuSuggestion=new StuSuggestion();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,stuS_Id);
            ResultSet rst=pstmt.executeQuery();
            if (rst.next()) {
                stuSuggestion.setStuS_id(rst.getString("stuS_id"));
                stuSuggestion.setStu_id(rst.getString("stu_id"));
                stuSuggestion.setStuS_title(rst.getString("stuS_title"));
                stuSuggestion.setStuS_content(rst.getString("stuS_content"));
                stuSuggestion.setStuS_time(rst.getDate("stuS_time"));
            }
            connection.close();
            return stuSuggestion;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    public ArrayList<StuSuggestion> findByStuS_id(String stuS_id){
        String sql="SELECT * FROM stuSuggestion WHERE stuS_id=?";
        ArrayList<StuSuggestion> stuSugList=new ArrayList<StuSuggestion>();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,stuS_id);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()) {
                StuSuggestion stuSuggestion=new StuSuggestion();
                stuSuggestion.setStuS_id(rst.getString("stuS_id"));
                stuSuggestion.setStu_id(rst.getString("stu_id"));
                stuSuggestion.setStuS_title(rst.getString("stuS_title"));
                stuSuggestion.setStuS_content(rst.getString("stuS_content"));
                stuSuggestion.setStuS_time(rst.getDate("stuS_time"));
                stuSugList.add(stuSuggestion);
            }
            connection.close();
            return stuSugList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    public int getBigId(){
        String sql="SELECT * FROM stuSuggestion";
        ArrayList<StuSuggestion> stuSuggestions=new ArrayList<StuSuggestion>();
        int big=-1;
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                StuSuggestion stuSuggestion=new StuSuggestion();
                stuSuggestion.setStuS_id(rst.getString("stuS_id"));
                stuSuggestions.add(stuSuggestion);
            }
            connection.close();
            if (stuSuggestions.size()==0){//问题库中没有问题
                return 0;
            }else {
                for (StuSuggestion item : stuSuggestions) {
                    int temp = Integer.parseInt(item.getStuS_id().substring(2));
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
