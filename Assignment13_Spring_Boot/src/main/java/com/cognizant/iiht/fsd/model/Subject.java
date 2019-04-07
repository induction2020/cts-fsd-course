package com.cognizant.iiht.fsd.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SUBJECT")
public class Subject{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="subject_seq_gen")
	@SequenceGenerator(name="subject_seq_gen", sequenceName="SUBJECT_SEQ")
	@Column(name="SUB_ID", nullable = false, updatable= false)
	private long subjectId;

	@Column(name="TITLE")
	private String subtitle;
	
	@Column(name="DURATION")
	private int durationInHours;
	
	@OneToMany(mappedBy ="subjectItem", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Book> references ;
	

	public Subject() {
	}


	public Subject(String subtitle, int durationInHours) {
		super();
		this.subtitle = subtitle;
		this.durationInHours = durationInHours;
	}
	
	
	public long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public int getDurationInHours() {
		return durationInHours;
	}
	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}
	public Set<Book> getReferences() {
		return references;
	}
	public void setReferences(Set<Book> references) {
		this.references = references;
	}
	
	
	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subtitle=" + subtitle + ", durationInHours=" + durationInHours +" ]";
	}
	
	
}
