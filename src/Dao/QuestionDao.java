package Dao;

import Bean.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuestionDao extends BaseDao{
    public boolean addQuestion(Question question){
        String sql="INSERT INTO Question(q_id, stu_id, q_title, q_content, q_click, q_time) VALUES (?,?,?,?,?,?)";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,question.getId());
            pstmt.setString(2,question.getStu_id());
            pstmt.setString(3,question.getTitle());
            pstmt.setString(4,question.getContent());
            pstmt.setInt(5,question.getClick());
            pstmt.setDate(6,question.getTime());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public boolean deleteQuestion(String id){
        String sql="DELETE FROM Question WHERE q_id=?";
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

    public boolean updateQuestion(Question question){
        String sql="UPDATE Question SET stu_id=?,q_title=?,q_content=?,q_click=?,q_time=? WHERE q_id=?";
        try{
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,question.getStu_id());
            pstmt.setString(2,question.getTitle());
            pstmt.setString(3,question.getContent());
            pstmt.setInt(4,question.getClick());
            pstmt.setDate(5,question.getTime());
            pstmt.setString(6,question.getId());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    public Question findById(String id){
        String sql="SELECT * FROM Question WHERE q_id=?";
        Question question=new Question();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,id);
            ResultSet rst=pstmt.executeQuery();
            if(rst.next()){
                question.setId(rst.getString("q_id"));
                question.setStu_id(rst.getString("stu_id"));
                question.setTitle(rst.getString("q_title"));
                question.setContent(rst.getString("q_content"));
                question.setClick(rst.getInt("q_click"));
                question.setTime(rst.getDate("q_time"));
            }
            connection.close();
            return question;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    public ArrayList<Question> findAllQuestion(){
        String sql="SELECT * FROM Question";
        ArrayList<Question> questionList=new ArrayList<Question>();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                Question question=new Question();
                question.setId(rst.getString("q_id"));
                question.setStu_id(rst.getString("stu_id"));
                question.setTitle(rst.getString("q_title"));
                question.setContent(rst.getString("q_content"));
                question.setClick(rst.getInt("q_click"));
                question.setTime(rst.getDate("q_time"));
                questionList.add(question);
            }
            connection.close();
            return questionList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    public ArrayList<Question> findQuestionByStu(String stu_id){
        String sql="SELECT * FROM Question WHERE stu_id=?";
        ArrayList<Question> questionList=new ArrayList<Question>();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,stu_id);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                Question question=new Question();
                question.setId(rst.getString("q_id"));
                question.setStu_id(rst.getString("stu_id"));
                question.setTitle(rst.getString("q_title"));
                question.setContent(rst.getString("q_content"));
                question.setClick(rst.getInt("q_click"));
                question.setTime(rst.getDate("q_time"));
                questionList.add(question);
            }
            connection.close();
            return questionList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    public int getBigId(){
        String sql="SELECT * FROM Question";
        ArrayList<Question> questionList=new ArrayList<Question>();
        int big=-1;
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                Question question=new Question();
                question.setId(rst.getString("q_id"));
                question.setStu_id(rst.getString("stu_id"));
                question.setTitle(rst.getString("q_title"));
                question.setContent(rst.getString("q_content"));
                question.setClick(rst.getInt("q_click"));
                question.setTime(rst.getDate("q_time"));
                questionList.add(question);
            }
            connection.close();
            if (questionList.size()==0){//问题库中没有问题
                return 0;
            }else {
                for (Question question : questionList) {
                    int temp = Integer.parseInt(question.getId().substring(1));//跳过第一个字符,如Q1
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
