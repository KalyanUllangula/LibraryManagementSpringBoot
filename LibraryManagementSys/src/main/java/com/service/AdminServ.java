package com.service;


import java.util.List;

import com.entites.Admin;
import com.entites.Books;
import com.entites.BooksOrder;
import com.entites.DamagedBooks;
import com.entites.Users;

public interface AdminServ {
	public Admin addAdminDetails(Admin ad);
	public Books addBooks(Books b);
	public Users validateUserDetails(Users user) throws Throwable;
	public Books updateBooks(Books books) throws Throwable;

	public Long removeBooks(Long bookid);

	public BooksOrder addBook(BooksOrder booksOrder);

	public BooksOrder updateBook(BooksOrder booksOrder) throws Throwable;

	public String removeBook(int orderId);

	public List<DamagedBooks> viewDamagedBooksList();

	public DamagedBooks viewDamagedBookById(int id)throws Throwable;
	public DamagedBooks addDamagedBooks( DamagedBooks  d);
	public Books searchBookByTitle(String title);
	
	public Books searchBookBySubject(String subject) ;


}


