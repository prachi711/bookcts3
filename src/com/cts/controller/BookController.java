package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.Entity.Book;
import com.cts.Entity.User;
import com.cts.service.BookService;
import com.cts.service.UserService;

@Controller
public class BookController {

	
	
	@Autowired
	BookService bookService;
	
	
	
	
	@RequestMapping(value="addBook")
	private String addBookPage() {
		return "addBook";
	}
	
	@RequestMapping(value="viewBook")
	private String viewBookPage() {
		return "viewBook";
	}
	
	@RequestMapping(value="added")
	private String addedBookPage() {
		return "added";
	}
	
	@RequestMapping(value="addBookdata",method=RequestMethod.POST)
	private ModelAndView addBook(@RequestParam("bcode")String bookCode,@RequestParam("bname")String bookName,@RequestParam("btype") String bookType,@RequestParam("price") String price,@RequestParam("description")String description) throws Exception
	{
		Book book=new Book(bookCode,bookName,bookType,price,description);
		
		
		
		 String result = bookService.addBook(book);
	
	System.out.println(result);
	ModelAndView mv=new ModelAndView();
	
		mv.setViewName("added");
		return mv;
	
	}
		
	@RequestMapping(value="viewBookdata", method=RequestMethod.GET)	
	private ModelAndView viewBook(@RequestParam("bType") String bookType )
	{    
		String result=bookService.viewBook(bookType);
		System.out.println(result);
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("viewBook");
		return mv;
	}
		
		
	
	
}
