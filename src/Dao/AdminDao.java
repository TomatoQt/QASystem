package Dao;

import Bean.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao extends BaseDao{
    public Admin findById(String id){
        String sql="SELECT * FROM Administrator WHERE adm_id=?";
        Admin admin=new Admin();
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,id);
            ResultSet rst=pstmt.executeQuery();
            if(rst.next()){
                admin.setId(rst.getString("adm_id"));
                admin.setNickname(rst.getString("adm_nickname"));
                admin.setPassword(rst.getString("adm_password"));
                admin.setName(rst.getString("adm_name"));
                admin.setSex(rst.getBoolean("adm_sex"));//可能有问题
                admin.setPhone(rst.getString("adm_phone"));
            }
            connection.close();
            return admin;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }

    public boolean login(String id,String password){
        String sql="SELECT * FROM Administrator WHERE adm_id=?";
        boolean result=false;
        try{
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,id);
            ResultSet rst=pstmt.executeQuery();
            if(rst.next()){
                if (rst.getString("adm_password").equals(password))
                    result=true;
                else
                    result=false;
            }
            connection.close();
            return result;
        }catch (SQLException se){
            se.printStackTrace();
            return result;
        }
    }

    public boolean updateAdmin(Admin admin){
        String sql="UPDATE Administrator SET adm_nickname=?,adm_password=?,adm_name=?,adm_sex=?,adm_phone=? WHERE adm_id=?";
        try {
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,admin.getNickname());
            pstmt.setString(2,admin.getPassword());
            pstmt.setString(3,admin.getName());
            pstmt.setInt(4,admin.getSex()?1:0);
            pstmt.setString(5,admin.getPhone());
            pstmt.setString(6,admin.getId());
            pstmt.executeUpdate();
            connection.close();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
}
