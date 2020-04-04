package com.example.SDao;

import com.example.SDao.ISDao.ISUserDao;
import com.example.entity.UserInfo;
import org.springframework.stereotype.Component;
import util.DBTool;

import java.sql.*;

@Component
public class SUserDao implements ISUserDao {
    @Override
    public UserInfo selectUserInfoByTelePhone(String telePhone) {
        UserInfo userInfo = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "" +
                "select userName,password,image from user where telePhone ='"+telePhone+"'";
        try {
            stmt = DBTool.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                String userName  = rs.getString(1);
                String password  = rs.getString(2);
                String image  = rs.getString(3);
                userInfo = new UserInfo(telePhone,userName,password,image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                if(stmt != null)
                    stmt.close();
                if(rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userInfo;
    }

    @Override
    public Boolean insertUserInfo(UserInfo userInfo) {
        PreparedStatement stmt = null;
        boolean insertResult = false;
        try {
            String sql = "insert into user (telePhone,userName,password,image) values (?,?,?,?)";
            stmt = DBTool.getConnection().prepareStatement(sql);
            stmt.setString(1, userInfo.getTelePhone());
            stmt.setString(2, userInfo.getUserName());
            stmt.setString(3, userInfo.getPassWord());
            stmt.setString(4, userInfo.getImage());
            if(stmt.executeUpdate()>0){
                insertResult =true;
            }

        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally{
            try {
                if(stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return insertResult;
    }

    @Override
    public Boolean selectUserByTele(String userTele) {
        Statement stmt = null;
        ResultSet rs = null;
        String userName = null;
        String sql = "select userName,password,image from user where telePhone ='"+userTele+"'";
        try {
            stmt = DBTool.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                 userName  = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                if(stmt != null)
                    stmt.close();
                if(rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (userName == null)
            return false;
        return true;
    }

    @Override
    public Boolean updatePasswordByTele(UserInfo userInfo) {
        PreparedStatement ps = null;
        String sql = "update user set password=? where telePhone=?";		//sql语句
        try {
            ps  = DBTool.getConnection().prepareStatement(sql);
            ps.setString(1, userInfo.getPassWord());
            ps.setString(2, userInfo.getTelePhone());
            if (ps.executeUpdate()>0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            if(ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        SUserDao sUserDao = new SUserDao();
        UserInfo userInfo = new UserInfo("17865577553","张三","!@#123","");
        System.out.println(sUserDao.updatePasswordByTele(userInfo));

    }
}
