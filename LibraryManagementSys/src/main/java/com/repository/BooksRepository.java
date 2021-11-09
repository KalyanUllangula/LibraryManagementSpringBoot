package com.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entites.Books;

public interface BooksRepository extends JpaRepository<Books,Long>{
	 Books findByTitle(String title);
		
		//@Query("Select book from Books book order by book.title ")
		Books findBookByTitle(String title);
		
	Books findBySubject(String subject);
		
		//@Query("Select book from Books book order by book.subject")
		Books findBookBySubject(String subject);
		

}