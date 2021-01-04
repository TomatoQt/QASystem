package Dao;

import Bean.Notice;
import Bean.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NoticeDao extends BaseDao{
    public boolean addNotice(Notice notice){
        String sql="INSERT INTO Notice(notice_id,notice_title,notice_content,notice_time,adm_id) VALUES(?,?,?,?,?)";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,notice.getId());
            pstmt.setString(2,notice.getTitle());
            pstmt.setString(3,notice.getContent());
            pstmt.setDate(4,notice.getTime());
            pstmt.setString(5,notice.getAdm_id());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public boolean deleteNotice(String id){
        String sql="DELETE FROM Notice WHERE notice_id=?";
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

    public boolean updateNotice(Notice notice){
        String sql="UPDATE Notice SET notice_title=?,notice_content=?,notice_time=?,adm_id=? WHERE notice_id=?";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,notice.getTitle());
            pstmt.setString(2,notice.getContent());
            pstmt.setDate(3,notice.getTime());
            pstmt.setString(4,notice.getAdm_id());
            pstmt.setString(5,notice.getId());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public Notice findById(String id){
        String sql="SELECT * FROM Notice WHERE notice_id=?";
        try{
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            Notice notice=new Notice();
            pstmt.setString(1,id);
            ResultSet rst=pstmt.executeQuery();
            if (rst.next()) {
                notice.setId(rst.getString("notice_id"));
                notice.setTitle(rst.getString("notice_title"));
                notice.setContent(rst.getString("notice_content"));
                notice.setTime(rst.getDate("notice_time"));
                notice.setAdm_id(rst.getString("adm_id"));
            }
            connection.close();
            return notice;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    public ArrayList<Notice> findAllNotice(){
        String sql="SELECT * FROM Notice";
        ArrayList<Notice> noticeList=new ArrayList<Notice>();
        try{
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                Notice notice=new Notice();
                notice.setId(rst.getString("notice_id"));
                notice.setTitle(rst.getString("notice_title"));
                notice.setContent(rst.getString("notice_content"));
                notice.setTime(rst.getDate("notice_time"));
                notice.setAdm_id(rst.getString("adm_id"));
                noticeList.add(notice);
            }
            connection.close();
            return noticeList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    //获取最大的notice 编号
    public int getBigId(){
        String sql="SELECT * FROM Notice";
        ArrayList<Notice> noticeList=new ArrayList<Notice>();
        int big=-1;
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                Notice notice=new Notice();
                notice.setId(rst.getString("notice_id"));
                noticeList.add(notice);
            }
            connection.close();
            if (noticeList.size()==0){//问题库中没有问题
                return 0;
            }else {
                for (Notice notice : noticeList) {
                    int temp = Integer.parseInt(notice.getId().substring(1));//跳过第一个字符,如N1
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
