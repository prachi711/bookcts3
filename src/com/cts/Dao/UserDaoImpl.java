package com.cts.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.Entity.User;

import com.cts.helper.JdbcConnector;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {
	
JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    }

	public int registerUser(User user)
	{
		String sql="insert into user(userName,name,password,dob,address) values('"+user.getUserName()+"',"+user.getName()+"',"+user.getPassword()+"',"+user.getDob()+"',"+user.getAddress()+"')";    
	    return template.update(sql); 
	}

	@Autowired
	private JdbcConnector jdbcConnector;
	
	/*public String registerUser(User user) {
		
		String query="insert into user(userName,name,password,dob,address) values (?,?,?,?,?)";
		Connection connection=null;
		PreparedStatement preparedstatement=null;
		
		connection =JdbcConnector.getConnection();
		
		try {
			
			preparedstatement=connection.prepareStatement(query);
			 preparedstatement.setString(1, user.getUserName());
			 preparedstatement.setString(2,user.getName());
			 preparedstatement.setString(3,user.getPassword());
			 preparedstatement.setString(4, user.getDob());
			 preparedstatement.setString(5, user.getAddress());
			 
			int result=preparedstatement.executeUpdate();
			System.out.println(result);
			connection.commit();
			return "success";
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		
		try {
			connection.rollback();
			
		} catch (Exception e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
		}
		return null;*/
		
         
		  
		
	

	@Override
	public String loginUser(User user)  {
		Connection con=jdbcConnector.getConnection();
		String username=user.getUserName();
		String password=user.getPassword();
		
		
		String query="Select * from user where username=username and password= password";
		 //Statement st = con.createStatement();    
		 ResultSet rs = null;
        // int m = st.executeUpdate(query); 
        // while ( rs.next() ) {
           // String userName=rs.getString(username);
          //  if(userName.equalsIgnoreCase(username))
            //{
            	//return "true";
           // }
         //}
		return "false";
		
		/*if(username.equals("a")&&password.equals("a"))
		return "true";
		else
			return "false";*/
	}
}






	








