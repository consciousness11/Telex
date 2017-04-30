/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.model.Customer;
import com.util.Teledbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Plus
 */
public class CustomerDAO {
    
     public void insertMember(Customer customer){
        try{
            Connection con=Teledbc.connector();
            String qry="insert into customer(customerName,customerAddress,customerNumber) values(?,?,?)";
            PreparedStatement pst=con.prepareStatement(qry);
            pst.setString(1,customer.getCustomerName());
            pst.setString(2,customer.getCustomerAddress());
            pst.setString(3,customer.getCustomerNumber());
            pst.execute();
            con.close();
        }catch(Exception e){e.printStackTrace();}
    }
     
    public List<Customer> getMemberInfo(){
        try{
            List<Customer> customer=new ArrayList<Customer>();
            Connection con=Teledbc.connector();
            String qry="Select * from customer";
            PreparedStatement pst= con.prepareStatement(qry);
            ResultSet rs=pst.executeQuery();
            
            while(rs.next()){
                Customer m=new Customer();
                m.setCustomerName(rs.getString("customerName"));
                m.setCustomerNumber(rs.getString("customerNumber"));
                m.setCustomerAddress(rs.getString("customerAddress"));
                m.setCustomerID(rs.getInt("CsID"));
                customer.add(m);
            }
            con.close();
            return customer;
            
        }
        
        
    catch(Exception e){    e.printStackTrace();}
        return null;
} 
        public Customer getCustomer(int customerID){
        try{
            Connection con=Teledbc.connector();
            String qry="Select * from customer where CsID=?";
            PreparedStatement pst= con.prepareStatement(qry);
            pst.setInt(1, customerID);
            ResultSet rs=pst.executeQuery();
            
            while(rs.next()){
                Customer m=new Customer();
                m.setCustomerName(rs.getString("customerName"));
                m.setCustomerNumber(rs.getString("customerNumber"));
                m.setCustomerAddress(rs.getString("customerAddress"));
                m.setCustomerID(rs.getInt("CsID"));
                return m;
            }
            con.close();
                       
        }
      catch(Exception e){    e.printStackTrace();}
        return null;
}
        public void deleteCustomer(int customerID){
        try{
            Connection con=Teledbc.connector();
            String qry="delete from customer where CsID=?";
            PreparedStatement pst=con.prepareStatement(qry);
            pst.setInt(1,customerID);
            pst.executeUpdate();
            con.close();
        }catch(Exception e){e.printStackTrace();}
        
    }
        public void updateCustomer(Customer customer){
         try{
            Connection con=Teledbc.connector();
            String qry="update customer set customerName=? ,customerAddress=?,customerNumber=? where CsID=?";
            PreparedStatement pst=con.prepareStatement(qry);
            pst.setString(1,customer.getCustomerName());
            pst.setString(2,customer.getCustomerAddress());
            pst.setString(3,customer.getCustomerNumber());
            pst.setInt(4,customer.getCustomerID());
            pst.executeUpdate();
            con.close();
        }catch(Exception e){e.printStackTrace();}
        
    }
    
}
