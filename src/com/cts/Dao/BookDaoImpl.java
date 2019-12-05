package com.cts.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.Entity.Book;
import com.cts.helper.JdbcConnector;

@Repository
public class BookDaoImpl implements BookDao {

	
	@Autowired
	private JdbcConnector jdbcConnector;
	
	@Override
	public String addBook(Book book) {
		
		String query="insert into book(bookCode,bookName,bookType,price,description) values (?,?,?,?,?)";
		Connection connection=null;
		PreparedStatement preparedstatement=null;
		
		connection =JdbcConnector.getConnection();
		
		try {
			
			preparedstatement=connection.prepareStatement(query);
			 preparedstatement.setString(1, book.getBookCode());
			 preparedstatement.setString(2,book.getBookName());
			 preparedstatement.setString(3,book.getBookType());
			 preparedstatement.setString(4, book.getPrice());
			 preparedstatement.setString(5, book.getDescription());
			 
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
		return null;
		
	}

	@Override
	public String viewBook(String bookType)  {
		
		//Book book= new Book();
		String query="select bookCode, bookName, price, description from book where bookType=?";
		
		Connection connection=JdbcConnector.getConnection();
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement =  connection.prepareStatement(query);
			preparedStatement.setString(1, bookType);
			ResultSet result = preparedStatement.executeQuery();
			if(result.next())
			{
				System.out.println(result.getString(1)+","+result.getString(2)+","+result.getString(3)+","+result.getString(4)+",");
				return "true";
			}
			
			else
			{
				System.out.println("Record Not Found...");
				
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} ;
		 
		return "true";
		
}
	

	@Override
	public String editBook(String bookCode) {
		 
		Connection con=jdbcConnector.getConnection();
		String query="update book set bookName=?, price=?, descrition=? where bookCode=? ";
		//Statement st= con.createStatement();
		//ResultSet rs = st.executeQuery(query);
        return "true";
	}

}
