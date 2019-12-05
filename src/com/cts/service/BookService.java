package com.cts.service;

import com.cts.Entity.Book;

public interface BookService {
	
	public String addBook(Book book);
	public String viewBook(String bookType);
	public String editBook(String bookCode);

}
