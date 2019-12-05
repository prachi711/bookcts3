package com.cts.Dao;

import com.cts.Entity.Book;

public interface BookDao {
	
	public String addBook(Book book);
	 public String viewBook(String bookType);
	public String editBook(String bookCode) ;

}
