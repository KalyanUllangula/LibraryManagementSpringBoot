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
import com.entites.BooksReturned;
import com.repository.BooksReturnedRepository;
@SpringBootTest
class BooksReturnedServImpTest {
	@Autowired
	BooksReturnedServImp bookreturnservice;
	
	@MockBean
	BooksReturnedRepository repo;

	@Test
	void testReturnBooks() {
		BooksReturned br = new BooksReturned();
		br.setId(1);
		br.setReturnedDate(null);
		br.setPenalty(0);
		br.setPenaltyStatus("nill");
		br.setDelayedDays(0);
		Mockito.when(repo.save(br)).thenReturn(br);
		assertThat(bookreturnservice.returnBooks(br)).isEqualTo(br);
	}

	@Test
	void testUpdateReturnedBookDetails() throws Throwable {
		BooksReturned br = new BooksReturned();
		br.setId(1);
		br.setReturnedDate(null);
		br.setPenalty(0);
		br.setPenaltyStatus("nill");
		br.setDelayedDays(0);
	    br.setPenaltyStatus(null);
	    Optional<BooksReturned> c2 =  Optional.of(br);
		Mockito.when(repo.findById(1)).thenReturn(c2);
		Mockito.when(repo.save(br)).thenReturn(br);
		br.setId(1);
		br.setReturnedDate(null);
		br.setPenalty(0);
		br.setPenaltyStatus("nill");
		br.setDelayedDays(0);
		assertThat(bookreturnservice.updateReturnedBookDetails(br)).isEqualTo(br);
		
	}

	@Test
	void testViewReturnedBooksList() {
        BooksReturned br = new BooksReturned();
		
        br.setId(1);
		br.setReturnedDate(null);
		br.setPenalty(0);
		br.setPenaltyStatus("nill");
		br.setDelayedDays(0);
		
        BooksReturned br1 = new BooksReturned();
		
        br.setId(1);
		br.setReturnedDate(null);
		br.setPenalty(0);
		br.setPenaltyStatus("nill");
		br.setDelayedDays(0);
		List<BooksReturned> bookList = new ArrayList<BooksReturned>();
		bookList.add(br);
		bookList.add(br1);
		
		Mockito.when(repo.findAll()).thenReturn(bookList);
		assertThat(bookreturnservice.viewReturnedBooksList()).isEqualTo(bookList);
		
	}

	

}
