package com.entites;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Entity
@Table(name="books")
public class Books {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bookid;
	 @Column(name="title",length=250,nullable=false)
	 @NotNull(message="title cannot be null")
	private String title;
	/*
	 * @Column(name="isbncode",length=250,nullable=false)
	 * 
	 * @Pattern(regexp ="^[0-9]+$")
	 * 
	 * @NotNull(message="isbncode cannot be null")
	 */
	 private String isbncode;
	 
	 @Column(name="subject",length=250,nullable=false)
	 @NotNull(message="subject cannot be null")
	private String subject;
	 @Column(name="quantity",nullable=false)
	 @NotNull(message = "quantity Should Not Be Null") 
	private int quantity;

	@NotNull(message = "Bookcost should not be blank")
	@DecimalMin(value = "100.0", message = "Bookcost must be a number at least 100")
	private double bookcost;
	//@Column(name="shelfdetails",length=250,nullable=false)
	@NotNull
	private String shelfdetails;
	//@Column(name="publishedyear",length=250,nullable=false)
	@NotNull
	private int publishedyear;
	
	 
	
	  @ManyToOne
	  @JoinColumn(name="author_id")
	  private Author authors;

		 
	@ManyToOne(cascade=CascadeType.ALL)
	private Admin admin;

	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Long getBookid() {
		return bookid;
	}
	public void setBookid(Long bookid)
	{
		this.bookid = bookid;
	}
	  public Author getAuthors()
	  { 
		  return authors; 
		}
	  public void setAuthors(Author authors) 
	  {
		  this.authors = authors; 
	 }	
	 
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getIsbncode() {
		return isbncode;
	}
	public void setIsbncode(String isbncode) {
		this.isbncode = isbncode;
	}
	public double getBookcost() {
		return bookcost;
	}
	public void setBookcost(double bookcost) {
		this.bookcost = bookcost;
	}
	public String getShelfdetails() {
		return shelfdetails;
	}
	public void setShelfdetails(String shelfdetails) {
		this.shelfdetails = shelfdetails;
	}
	public int getPublishedyear() {
		return publishedyear;
	}
	public void setPublishedyear(int publishedyear) {
		this.publishedyear = publishedyear;
	}
}