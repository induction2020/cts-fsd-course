package com.cognizant.iiht.fsd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.iiht.fsd.model.Book;
import com.cognizant.iiht.fsd.model.Subject;
import com.cognizant.iiht.fsd.service.BookService;


@Controller
public class BookManagementController {
	BookService bookService = null;
	
	@Autowired
	public void setbookService(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping( value="showmenu.htm", method = RequestMethod.GET )
	public String showmenu(){
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("bookService DI : "+bookService);
		return "home";
	}
	
	@RequestMapping( value="addBook.htm", method = RequestMethod.GET )
	public ModelAndView addBook(@ModelAttribute Book book){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addBook");
		return modelAndView;
	}
	
	
	@RequestMapping( value="addSubject.htm", method = RequestMethod.GET )
	public ModelAndView addSubject(@ModelAttribute Subject subject){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addSubject");
		return modelAndView;
	}
	
	
	@RequestMapping( value="deleteBook.htm", method = RequestMethod.GET )
	public ModelAndView deleteBook( @ModelAttribute Book book ){ 
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("deleteBook");
		modelAndView.addObject("book",book);
		
		return modelAndView;
	}

	@RequestMapping( value="deleteSubject.htm", method = RequestMethod.GET )
	public ModelAndView deleteSubject(@ModelAttribute Subject subject){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("deleteSubject");
		return modelAndView;
	}
	
	@RequestMapping( value="searchBook.htm", method = RequestMethod.GET )
	public ModelAndView searchBook(@ModelAttribute Book book){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("searchBook");
		modelAndView.addObject("book",book);
		return modelAndView;
	}
	
	@RequestMapping( value="searchSubject.htm", method = RequestMethod.GET )
	public ModelAndView searchSubject(@ModelAttribute Subject subject){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("searchSubject");
		modelAndView.addObject("subject",subject);
		return modelAndView;
	}
	
	/*
	 *Submit methods
	 * 
	 */
	
	@RequestMapping( value="addBook.htm", method = RequestMethod.POST )
	public ModelAndView addBookSubmit(@ModelAttribute Book book){
		ModelAndView modelAndView = new ModelAndView();
		
		String response = bookService.addBookUnderSubject(book.getSubjectId(), book);
		
		modelAndView.setViewName("addBook");
		modelAndView.addObject("response", response);
		return modelAndView;
	}
	
	
	@RequestMapping( value="addSubject.htm", method = RequestMethod.POST )
	public ModelAndView addSubjectSubmit(@ModelAttribute Subject subject){
		System.out.println("addSubject : subject : "+subject);
		String response = bookService.addSubject(subject);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addSubject");
		modelAndView.addObject("response", response);
		return modelAndView;
	}
	
	@RequestMapping( value="searchBook.htm", method = RequestMethod.POST )
	public ModelAndView searchBookSubmit(@ModelAttribute Book book ){
		
		Book bookNew = bookService.searchBook(book.getBookId());
		System.out.println("searchBook-book: "+book);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("bookResults", bookNew);
		modelAndView.setViewName("searchBook");
		return modelAndView;
	}
	
	@RequestMapping( value="searchSubject.htm", method = RequestMethod.POST )
	public ModelAndView searchSubjectSubmit(@ModelAttribute Subject subject){

		Subject subjectNew = bookService.searchSubject(subject.getSubjectId());
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("subjectResults", subjectNew);
		modelAndView.setViewName("searchSubject");
		return modelAndView;
	}
	

	@RequestMapping( value="deleteBook.htm", method = RequestMethod.POST )
	public ModelAndView deleteBookSubmit(@ModelAttribute Book book){
	
		System.out.println("book.id: "+book.getBookId());
		String responseMsg = bookService.deleteBook(book.getBookId());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("deleteBook");
		modelAndView.addObject("response", responseMsg);
		modelAndView.addObject("book",book);
		return modelAndView;
	}
	
	@RequestMapping( value="deleteSubject.htm", method = RequestMethod.POST )
	public ModelAndView deleteSubjectSubmit(@ModelAttribute Subject subject){
		ModelAndView modelAndView = new ModelAndView();
		String responseMsg = bookService.deleteSubject(subject.getSubjectId());
		System.out.println("deleteSubjectSubmit");
		modelAndView.setViewName("deleteSubject");
		modelAndView.addObject("response", responseMsg);
		return modelAndView;
	}
	
}
