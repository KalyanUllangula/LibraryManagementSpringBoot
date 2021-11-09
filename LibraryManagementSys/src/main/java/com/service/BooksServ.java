package com.service;

import java.util.List;

import com.entites.Books;

public interface BooksServ {
	public Books addBook(Books book);
	public Books updateBookDetails(Books book) throws Throwable;
	public String removeBook(Books bookid);
	public Books searchBookByTitle(String title);
	public Books searchBookBySubject(String subject);
	public List<Books> viewAllBooks();
	

}
