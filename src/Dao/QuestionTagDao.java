package Dao;

import Bean.QuestionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuestionTagDao extends BaseDao{
    public boolean addQuestionTag(String q_id,String qType_id){
        String sql="INSERT INTO Question_Tag(q_id, qType_id) VALUES(?,?)";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,q_id);
            pstmt.setString(2,qType_id);
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public boolean deleteQuestionTag(String q_id,String qType_id){
        String sql="DELETE FROM Question_Tag WHERE q_id=? AND qType_id=?";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,q_id);
            pstmt.setString(2,qType_id);
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    //没有更新，没意义

    //根据问题id，返回问题的标签id
    public ArrayList<String> findTypeByQuestion(String questionId){
        String sql="SELECT * FROM Question_Tag WHERE q_id=?";
        ArrayList<String> questionTypeIdList=new ArrayList<String>();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,questionId);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                questionTypeIdList.add(rst.getString("qType_id"));
            }
            connection.close();
            return questionTypeIdList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    //根据标签id，返回标签下的问题id
    public ArrayList<String> findQuestionByType(String questionTypeId){
        String sql="SELECT * FROM Question_Tag WHERE qType_id=?";
        ArrayList<String> questionIdList=new ArrayList<String>();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,questionTypeId);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                questionIdList.add(rst.getString("q_id"));
            }
            connection.close();
            return questionIdList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }
}
