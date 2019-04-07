package com.cognizant.iiht.fsd.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="BOOK")
public class Book{
	
	public Book() {
		super();
	}

	
	public Book(String title, double price, int volume, String publishDate) {
		super();
		this.title = title;
		this.price = price;
		this.volume = volume;
		this.publishDate = publishDate;
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="book_seq_gen")
	@SequenceGenerator(name="book_seq_gen", sequenceName="BOOK_SEQ")
	@Column(name="BOOK_ID", nullable=false, updatable=false)
	private long bookId;
	
	@Column(name="TITLE")
	private String title;
	
	@ManyToOne
	@JoinColumn( name="SUB_ID " , nullable=false )
	private Subject subjectItem;

	@Column(name="PRICE")
	private double price;
	
	@Column(name="VOLUME")
	private int volume;
	
	@Column(name="PUBLISH_DATE")
	private String publishDate;
	
	@Transient
	private long subjectId;
	
	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	
	public long getBookId() {
		return bookId;
	}


	public void setBookId(long bookId) {
		this.bookId = bookId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getVolume() {
		return volume;
	}


	public void setVolume(int volume) {
		this.volume = volume;
	}


	public String getPublishDate() {
		return publishDate;
	}


	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	
	public Subject getSubjectItem() {
		return subjectItem;
	}

	public void setSubjectItem(Subject subjectItem) {
		this.subjectItem = subjectItem;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", subjectItem=" + subjectItem + ", price=" + price
				+ ", volume=" + volume + ", publishDate=" + publishDate + "]";
	}

	


	
}
