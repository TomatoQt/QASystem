package Dao;

import Bean.Question;
import Bean.QuestionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class questionTypeDao extends BaseDao{
    public boolean addQuestionType(QuestionType questionType){
        String sql="INSERT INTO QuestionType(qType_id, qType_name) VALUES (?,?)";
        try{
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,questionType.getId());
            pstmt.setString(2,questionType.getName());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public boolean deleteQuestionType(String id){
        String sql="DELETE FROM QuestionType WHERE qType_id=?";
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

    public boolean updateQuestionType(QuestionType questionType){
        String sql="UPDATE QuestionType SET qType_name=? WHERE qType_id=?";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,questionType.getName());
            pstmt.setString(2,questionType.getId());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public QuestionType findById(String id){
        String sql="SELECT * FROM QuestionType WHERE qType_id=?";
        QuestionType questionType=new QuestionType();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,id);
            ResultSet rst=pstmt.executeQuery();
            if (rst.next()){
                questionType.setId(rst.getString("qType_id"));
                questionType.setName(rst.getString("qType_name"));
            }
            connection.close();
            return questionType;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    public ArrayList<QuestionType> findAllQuestionType(){
        String sql="SELECT * FROM QuestionType";
        ArrayList<QuestionType> questionTypeList=new ArrayList<QuestionType>();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                QuestionType questionType=new QuestionType();
                questionType.setId(rst.getString("qType_id"));
                questionType.setName(rst.getString("qType_name"));
                questionTypeList.add(questionType);
            }
            connection.close();
            return questionTypeList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }
}
