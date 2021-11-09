package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.BookNotFoundException;
import com.entites.Books;
import com.entites.BooksIssued;
import com.repository.BooksRepository;
@Service
public class BooksServImp implements BooksServ {
    @Autowired 
    BooksRepository repo;
	@Override
	public Books addBook(Books book) {
		repo.save(book);
		return book ;
	}

	@Override
	public Books updateBookDetails(Books book) throws Throwable
	{
		Long bookid = book.getBookid();
		Supplier s1 = ()-> new BookNotFoundException("Book Does Not Exist in the Database");
		Books b1 = repo.findById((long) bookid).orElseThrow(s1);
		b1.setTitle(book.getTitle());
		b1.setSubject(book.getSubject());
		//b1.setAuthors(book.getAuthors());
		b1.setPublishedyear(book.getPublishedyear());
		b1.setIsbncode(book.getIsbncode());
		b1.setQuantity(book.getQuantity());
		b1.setBookcost(book.getBookcost());
		b1.setShelfdetails(book.getShelfdetails());
		repo.save(b1);
		return b1;
		
		
	}

	@Override
	public String removeBook(Books bookid) {
		Long bid = bookid.getBookid();
		  Supplier s1= ()->new BookNotFoundException("Book Does not exist in the database");		
		repo.delete(bookid);
		return "deleted";
		
		
	}

	@Override
	public Books searchBookByTitle(String title) 
	{
		
		Books lb =  repo.findBookByTitle(title);
		
		return lb;
		
	}

	@Override
	public Books searchBookBySubject(String subject) {
		Books lb1 = repo.findBookBySubject(subject);
		return lb1;
	}

	@Override
	public List<Books> viewAllBooks() {
     List<Books> lb2 = repo.findAll();
		
		return lb2;
		
	}

}
