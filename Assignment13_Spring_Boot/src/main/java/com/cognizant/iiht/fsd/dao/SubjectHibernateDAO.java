package com.cognizant.iiht.fsd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.cognizant.iiht.fsd.hibernate.HibernateUtil;
import com.cognizant.iiht.fsd.model.Book;
import com.cognizant.iiht.fsd.model.Subject;

@Repository
public class SubjectHibernateDAO {
	
	public static SubjectHibernateDAO subjectDAO = null;
	private static SessionFactory sessionFactory = null;
	
	public SubjectHibernateDAO(){
	}
	
	/**
	 * 
	 * @return
	 */
	public void getSessionFactory(){
			sessionFactory = HibernateUtil.getSessionFactory();
	}

	/**
	 * 
	 * This method is used to add Subject
	 * @param subject
	 */
	public void addSubject( Subject subject){
		
		try{
			if(sessionFactory == null){
				getSessionFactory();
			}
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			System.out.println("addSubject-subject:"+subject);
			System.out.println("addSubject-subject.getReferences :"+subject.getReferences());
			session.save(subject);
			
			//Saving child object separetly
			if(subject.getReferences()!=null){
				for (Iterator iterator = subject.getReferences().iterator(); iterator.hasNext();) {
					session.save(  iterator.next() );
					
				}
			}
			
			System.out.println("addSubject-subject.id:"+subject.getSubjectId());
			System.out.println("addSubject-subject.ref:"+subject.getReferences() );
			
			transaction.commit();
			session.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * This method is used to add Book
	 * @param book, subjectID
	 */
	public void addBook( Book book,String subjectID){
		try{
			if(sessionFactory == null){
				getSessionFactory();
			}
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			 
			//fetch Subject Object
			//session.createQuery( "from subject where sub_id="+subjectID );
			Subject subject = (Subject) session.get(Subject.class , Long.parseLong(subjectID));
			System.out.println("addBook-subject:"+subject);
			book.setSubjectItem(subject);
			System.out.println("book pub: "+book.getPublishDate());
			session.save(book);
			transaction.commit();
			session.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*
	 * search Book
	 * 
	 */
	public Book searchBook(String booktId){
		Book book = null;
		try{
			if(sessionFactory == null){
				getSessionFactory();
			}
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			book = (Book) session.get(Book.class, Long.parseLong(booktId));
			session.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return book;
	}
	
	
	/*
	 * search Book
	 * 
	 */
	public Subject searchSubject(String subjectId){
		Subject subject = null;
		Session session = null;
		try{
			if(sessionFactory == null){
				getSessionFactory();
			}
			session = sessionFactory.openSession();
			subject = (Subject) session.get(Subject.class, Long.parseLong(subjectId));
			//session.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return subject;
	}
	
	
	/**
	 * 
	 * 
	 * @param subjectId
	 * @return
	 */
	public List<Subject> listSubject(){
		List<Subject> subjectList = new ArrayList<>();
		try{
			if(sessionFactory == null){
				getSessionFactory();
			}
			Session session = sessionFactory.openSession();
			subjectList = (List<Subject>) session.createQuery(" from Subject order by title ").list();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return subjectList;
	}
	
	
	/**
	 * 
	 * 
	 * @param subjectID
	 * @return
	 */
	public List<Book> getReferencessortBooksbypubDt(){
		List<Book> references = new ArrayList();
		try{
			if(sessionFactory == null){
				getSessionFactory();
			}
			Session session = sessionFactory.openSession();
			references = (List<Book>) session.createQuery(" from Book order by publishDate asc").list();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return references;
	}
	
	/**
	 * 
	 * 
	 * @param subjectID
	 * @return
	 */
	public List<Book> getReferencesSortByTitle(){
		List<Book> references = new ArrayList();
		try{
			if(sessionFactory == null){
				getSessionFactory();
			}
			Session session = sessionFactory.openSession();
			references = (List<Book>) session.createQuery(" from Book order by title asc").list();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return references;
	}


	/*
	 * search Book
	 * 
	 */
	public void deleteBook(String booktId){
		try{
			if(sessionFactory == null){
				getSessionFactory();
			}
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Book book = (Book) session.get(Book.class, Long.parseLong(booktId));
			session.delete(book);
			transaction.commit();
			session.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/*
	 * search Book
	 * 
	 */
	public void deleteSubject(String subjectId){
		try{
			if(sessionFactory == null){
				getSessionFactory();
			}
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Subject subject = (Subject) session.get(Subject.class, Long.parseLong(subjectId));
			session.delete(subject);
			transaction.commit();
			session.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
