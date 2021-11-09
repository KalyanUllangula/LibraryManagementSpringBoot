package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entites.Books;
import com.repository.BooksRepository;




@SpringBootTest
class BooksServImpTest {
	
	@Autowired
	BooksServImp bookservice;
	
	@MockBean
	BooksRepository repo;

	@Test
	void testAddBook() {
		Books b1 = new Books();
		b1.setBookid(null);
		b1.setTitle("GameofThrones");
		b1.setSubject("fhfh");
		b1.setPublishedyear(2007);
		b1.setIsbncode(null);
		b1.setQuantity(0);
		b1.setBookcost(0);
		b1.setAuthors(null);
		b1.setShelfdetails(null);
		Mockito.when(repo.save(b1)).thenReturn(b1);
		assertThat(bookservice.addBook(b1)).isEqualTo(b1);
	}

	@Test
	void testUpdateBookDetails() throws Throwable {
		Books b1 = new Books();
		b1.setBookid((long) 1);
		b1.setTitle("FairyTales");
		b1.setSubject("Cindrella");
		b1.setPublishedyear(2007);
		b1.setIsbncode("8974764348397");
		b1.setQuantity(1);
		b1.setBookcost(500);
		b1.setShelfdetails("row1");
		
		Optional<Books> b2 =  Optional.of(b1);
		Mockito.when(repo.findById((long) 1)).thenReturn(b2);
		Mockito.when(repo.save(b1)).thenReturn(b1);
		b1.setBookid((long) 1);
		b1.setTitle("History");
		b1.setSubject("World History");
		b1.setPublishedyear(2005);
		b1.setIsbncode("8978964508397");
		b1.setQuantity(1);
		b1.setBookcost(1000);
		b1.setShelfdetails("row2");
		
		assertThat(bookservice.updateBookDetails(b1)).isEqualTo(b1);
	}

	@Test
	void testRemoveBook() {
		Books b1 = new Books();
		b1.setBookid(null);
		b1.setTitle("GameofThrones");
		b1.setSubject("fhfh");
		b1.setPublishedyear(2007);
		b1.setIsbncode(null);
		b1.setQuantity(0);
		b1.setBookcost(0);
		b1.setAuthors(null);
		b1.setShelfdetails(null);
		Optional<Books> b2=Optional.of(b1);
		Mockito.when(repo.findById(null)).thenReturn(b2);
		Mockito.when(repo.existsById(b1.getBookid())).thenReturn(false);
		assertFalse(repo.existsById(b1.getBookid()));
		
	}

	@Test
	void testSearchBookByTitle() {
		Books b1 = new Books(); 
		  b1.setBookid((long)1); 
		  b1.setTitle("FairyTales"); 
		  b1.setSubject("Cindrella");
	      b1.setPublishedyear(2007); 
	      b1.setIsbncode("8974764348397");
	      b1.setQuantity(1); 
	      b1.setBookcost(500); 
	      b1.setShelfdetails("row1");
	      
	      Mockito.when(repo.findBookByTitle("FairyTales")).thenReturn(b1);
	      assertThat(bookservice.searchBookByTitle("FairyTales")).isEqualTo(b1); 
	
	}

	@Test
	void testSearchBookBySubject() {
		 Books b1 = new Books();
	      b1.setBookid((long) 1); 
	      b1.setTitle("FairyTales");
	      b1.setSubject("Cindrella");
	      b1.setPublishedyear(2007);
	      b1.setIsbncode("8974764348397");
	      b1.setQuantity(1); b1.setBookcost(500);
	      b1.setShelfdetails("row1");
	    
	      Mockito.when(repo.findBookBySubject("Cindrella")).thenReturn(b1);
	      assertThat(bookservice.searchBookBySubject("Cindrella")).isEqualTo(b1); 
	}

	@Test
	void testViewAllBooks() {
		Books b1 = new Books();
		b1.setBookid(null);
		b1.setTitle("GameofThrones");
		b1.setSubject("fhfh");
		
		b1.setPublishedyear(2007);
		b1.setIsbncode(null);
		b1.setQuantity(0);
		b1.setBookcost(0);
		b1.setAuthors(null);
		b1.setShelfdetails(null);
		
		Books b2 = new Books();
		b2.setBookid(null);
		b2.setTitle("GameofThrones");
		b2.setSubject("fhfh");
	
		b2.setPublishedyear(2007);
		b2.setIsbncode(null);
		b2.setQuantity(0);
		b2.setBookcost(0);
		b2.setAuthors(null);
		b2.setShelfdetails(null);
		
		List<Books> bookList = new ArrayList<Books>();
		bookList.add(b1);
		bookList.add(b2);
		
		Mockito.when(repo.findAll()).thenReturn(bookList);
		assertThat(bookservice.viewAllBooks()).isEqualTo(bookList);
		
	}

}
