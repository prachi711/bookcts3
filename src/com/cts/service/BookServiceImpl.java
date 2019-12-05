package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.Dao.BookDao;
import com.cts.Entity.Book;
@Service("BookService")
public class BookServiceImpl implements BookService {
    
	@Autowired
	BookDao bookDao;
	
	@Override
	public String addBook(Book book)  {
		
		return bookDao.addBook(book);
	}

	@Override
	public String viewBook(String bookType) {
		// TODO Auto-generated method stub
		return bookDao.viewBook(bookType);
	}

	@Override
	public String editBook(String bookCode) {
		// TODO Auto-generated method stub
		return bookDao.editBook(bookCode);
	}

}
