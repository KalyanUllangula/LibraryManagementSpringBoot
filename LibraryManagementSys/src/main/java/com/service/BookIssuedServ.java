package com.service;

import java.util.List;

import com.entites.BooksIssued;

public interface BookIssuedServ  {
	public BooksIssued addIssuedBook(BooksIssued issued);
	public BooksIssued updateIssuedBookDetails(BooksIssued booksIssued) throws Throwable;
	
	public List<BooksIssued> viewBooksIssuedList();
	
	
	
	List<BooksIssued> findByQuantitySorted(int quantity);
	BooksIssued getByIssueId(int issueId);
	
	public String deleteIssuedBooks(BooksIssued bookid) throws Throwable;
	

}
