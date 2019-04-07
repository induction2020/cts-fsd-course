package com.cognizant.iiht.fsd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.iiht.fsd.dao.SubjectHibernateDAO;
import com.cognizant.iiht.fsd.model.Book;
import com.cognizant.iiht.fsd.model.Subject;


@Service
public class BookService {

	
	private SubjectHibernateDAO subjectDAO = null;
	
	@Autowired
	public void setSubjectDAO(SubjectHibernateDAO subjectDAO) {
		this.subjectDAO = subjectDAO;
	}

	public BookService() {
	}

	public String addSubject(Subject subject){
		subjectDAO.addSubject(subject);
		return "Subject is added successfully";
	}
	
	public  String addBookUnderSubject(long subjectId, Book book){
		subjectDAO.addBook(book, String.valueOf(subjectId));
		return "Book "+book.getBookId()+" added under Subject: "+subjectId;
		
	}

	public Subject searchSubject(long subjectId){
		Subject subject = subjectDAO.searchSubject( String.valueOf(subjectId) );
		return subject;
	}
	
	public  Book searchBook(long bookId){
		Book book = subjectDAO.searchBook(  String.valueOf(bookId) );
		return book;
	}
	
	
	public  String deleteBook(long bookId){
		System.out.println("deleteBook: bookId: "+bookId);
		subjectDAO.deleteBook( String.valueOf(bookId) );
		return "Book is Deleted";
	}
	
	
	public  String deleteSubject(long subjectId){
		subjectDAO.deleteSubject(String.valueOf(subjectId));
		return "Subject deleted successfully";
	}
	
}
