package Dao;

import Bean.StuAnswer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
            pstmt.setDate(7,stuAnswer.getStuA_time());
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
            pstmt.setDate(6,stuAnswer.getStuA_time());
            pstmt.setString(7,stuAnswer.getStuA_id());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
}
