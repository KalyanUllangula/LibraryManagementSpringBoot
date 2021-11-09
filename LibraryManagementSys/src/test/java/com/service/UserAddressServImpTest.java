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
import com.entites.UserAddress;
import com.repository.UserAdressRepository;
@SpringBootTest
class UserAddressServImpTest {
	@Autowired
	UserAddressServImp useraddressserv;
	
	@MockBean
	UserAdressRepository repo;

	@Test
	void testAddUserAddress() {
		UserAddress ua = new UserAddress();
		ua.setAddressId(1);
		ua.setAddress("Venigandla");
		ua.setUsers(null);
		ua.setCity("Guntur");
		ua.setState("Andhra");
		ua.setPincode(522509);
		Mockito.when(repo.save(ua)).thenReturn(ua);
		assertThat(useraddressserv.addUserAddress(ua)).isEqualTo(ua);
	
	}

	@Test
	void testUpdateUserAddressDetails() {
		
		UserAddress ua = new UserAddress();
		ua.setAddressId(1);
		ua.setAddress("Venigandla");
		ua.setUsers(null);
		ua.setCity("Guntur");
		ua.setState("Andhra");
		ua.setPincode(522509);
		
		Optional<UserAddress> b2 =  Optional.of(ua);
		Mockito.when(repo.findById(1)).thenReturn(b2);
		Mockito.when(repo.save(ua)).thenReturn(ua);
		ua.setAddress("Venigan");
		ua.setUsers(null);
		ua.setCity("Gunt");
		ua.setState("Andh");
		ua.setPincode(522508);
		assertThat(useraddressserv.updateUserAddressDetails(ua)).isEqualTo(ua);
		
	}

	@Test
	void testDeleteUserAddress() {
		UserAddress ua = new UserAddress();
		ua.setAddressId(1);
		ua.setAddress("Venigandla");
		ua.setUsers(null);
		ua.setCity("Guntur");
		ua.setState("Andhra");
		ua.setPincode(522509);
		Optional<UserAddress> b2=Optional.of(ua);
		Mockito.when(repo.findById(null)).thenReturn(b2);
		Mockito.when(repo.existsById(ua.getAddressId())).thenReturn(false);
		assertFalse(repo.existsById(ua.getAddressId()));
	}

	@Test
	void testViewAddressByUserId() {
		UserAddress ua = new UserAddress();
		ua.setAddressId(1);
		ua.setAddress("Venigandla");
		ua.setUsers(null);
		ua.setCity("Guntur");
		ua.setState("Andhra");
		ua.setPincode(522509);
		Optional<UserAddress> c2 = Optional.of(ua);
		Mockito.when(repo.findById(1)).thenReturn(c2);
		assertThat(useraddressserv.viewAddressByUserId(1)).isEqualTo(ua);
		
	}

	@Test
	void testViewUserAddressList() {
		UserAddress ua = new UserAddress();
		ua.setAddressId(1);
		ua.setAddress("Venigandla");
		ua.setUsers(null);
		ua.setCity("Guntur");
		ua.setState("Andhra");
		ua.setPincode(522509);
		
		UserAddress ua1 = new UserAddress();
		ua1.setAddressId(1);
		ua1.setAddress("Venig");
		ua1.setUsers(null);
		ua1.setCity("Guntu");
		ua1.setState("Andhr");
		ua1.setPincode(522580);
		
		List<UserAddress> addressList = new ArrayList<UserAddress>();
		addressList.add(ua);
		addressList.add(ua1);
		
		Mockito.when(repo.findAll()).thenReturn(addressList);
		assertThat(useraddressserv.viewUserAddressList()).isEqualTo(addressList);
	}

	@Test
	void testGetPinCode() {
		 UserAddress ua = new UserAddress();
			ua.setAddressId(1);
			ua.setAddress("Venigandla");
			ua.setUsers(null);
			ua.setCity("Guntur");
			ua.setState("Andhra");
			ua.setPincode(522509);
			Mockito.when(useraddressserv.getPinCode("522509")).thenReturn(ua);
			assertThat(useraddressserv.getPinCode("522509")).isEqualTo(ua);
		
	}

	@Test
	void testGetState() {

		  UserAddress ua = new UserAddress();
			ua.setAddressId(1);
			ua.setAddress("Venigandla");
			ua.setUsers(null);
			ua.setCity("Guntur");
			ua.setState("Andhra");
			ua.setPincode(522509);
			List<UserAddress> addressList = new ArrayList<UserAddress>();
			addressList.add(ua);
			Mockito.when(useraddressserv.getState("Andhra")).thenReturn(addressList);
			assertThat(useraddressserv.getState("Andhra")).isEqualTo(addressList);
	
	}

}
