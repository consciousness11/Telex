/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.model.User;
import com.util.Teledbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Plus
 */
public class UserDAO {
    public User ValidUser(User user){
        try{
            Connection con=Teledbc.connector();
            String qry="Select * from user where userName=? and userPassword=?";
            PreparedStatement pst= con.prepareStatement(qry);
            pst.setString(1, user.getUserName());
            pst.setString(2, user.getUserPassword());
            ResultSet rs=pst.executeQuery();
            
            while(rs.next()){
                User users=new User();
                users.setUserID(rs.getInt("userId"));
                users.setUserName(rs.getString("userName"));
                users.setUserPassword(rs.getString("userPassword"));
                 return users;
                
            }
           
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
      return null;  
    }
    
}
