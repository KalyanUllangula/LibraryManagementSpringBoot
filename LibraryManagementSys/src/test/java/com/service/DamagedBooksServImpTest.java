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

import com.entites.DamagedBooks;
import com.repository.DamagedBooksRepository;

@SpringBootTest
class DamagedBooksServImpTest {
	@Autowired
	DamagedBooksServImp damagedbookserv;
	
	@MockBean
	DamagedBooksRepository repo;


	@Test
	void testAddDamagedBooks() {
		DamagedBooks db = new DamagedBooks();
		db.setId(1);
		db.setDescription("Book Damaged");
		db.setQuantity(2);
		Mockito.when(repo.save(db)).thenReturn(db);
		assertThat(damagedbookserv.addDamagedBooks(db)).isEqualTo(db);
		
		
	}

	@Test
	void testUpdateDamagedBookDetails() throws Throwable {
		DamagedBooks db = new DamagedBooks();
		db.setId(1);
		db.setDescription("Book Damaged");
		db.setQuantity(2);
		Optional<DamagedBooks> c2 =  Optional.of(db);
		Mockito.when(repo.findById(1)).thenReturn(c2);
		Mockito.when(repo.save(db)).thenReturn(db);
		
		assertThat(damagedbookserv.updateDamagedBookDetails(db)).isEqualTo(db);
	}

	@Test
	void testViewDamagedBooksList() {
		DamagedBooks db = new DamagedBooks();
		db.setId(1);
		db.setDescription("Book Damaged");
		db.setQuantity(2);
		
		DamagedBooks db1 = new DamagedBooks();
		db1.setId(2);
		db1.setDescription("Book fully");
		db1.setQuantity(2);
		
		List<DamagedBooks> damagedList = new ArrayList<DamagedBooks>();
		damagedList.add(db);
		damagedList.add(db1);
		
		Mockito.when(repo.findAll()).thenReturn(damagedList);
		assertThat(damagedbookserv.viewDamagedBooksList()).isEqualTo(damagedList);
		
	}

	@Test
	void testViewDamagedBookById() throws Throwable {
		DamagedBooks db = new DamagedBooks();
		db.setId(1);
		db.setDescription("Book Damaged");
		db.setQuantity(2);
		Optional<DamagedBooks> c2 = Optional.of(db);
		Mockito.when(repo.findById(1)).thenReturn(c2);
		assertThat(damagedbookserv.viewDamagedBookById(1)).isEqualTo(db);
	
	}

}
