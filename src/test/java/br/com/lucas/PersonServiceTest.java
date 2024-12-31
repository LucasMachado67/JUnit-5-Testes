package br.com.lucas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.lucas.model.Person;
import br.com.lucas.service.IPersonService;
import br.com.lucas.service.PersonService;

public class PersonServiceTest {
	
	
	Person person;
	IPersonService service;
	@BeforeEach
	void setup() {
		service = new PersonService();
		person = new Person(
				
				"Keith",
				"Moon",
				"Kmoon@erudio.com.br",
				"Wembley - UK",
				"Male"
		);
	}
	
	@DisplayName("When create a person with Success Should return a person Object")
	@Test
	void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {
		// Given / Arrange
		
		// When / Act
		
		Person actual = service.createPerson(person);
		// then / Assert
		
		assertNotNull(actual, () -> "The createPerson() Should not have returned null!");
	}
	
	@DisplayName("When create a person with Success Should contains first name in returned person Object")
	@Test
	void testCreatePerson_WhenSuccess_ShouldContainsFirstNameInReturnedPersonObject() {
		// Given / Arrange
		
		// When / Act
		
		Person actual = service.createPerson(person);
		// then / Assert
		
		assertEquals(person.getFirstName(), actual.getFirstName(), () -> "The FirstName is different!");
	}
	
	@DisplayName("When create a person with Success Should contains all attributes in returned person Object")
	@Test
	void testCreatePerson_WhenSuccess_ShouldContainsAllAttributesInReturnedPersonObject() {
		// Given / Arrange
		IPersonService service = new PersonService();
		
		// When / Act
		
		Person actual = service.createPerson(person);
		// then / Assert
		
		assertNotNull(person.getId(), ()-> "Person ID is Missing!");
		assertAll(				
			() -> assertTrue(person.getFirstName() != null),
			() -> assertTrue(person.getLastName() != null),
			() -> assertTrue(person.getEmail() != null),
			() -> assertTrue(person.getAddress() != null),
			() -> assertTrue(person.getGender() != null),
			() -> assertEquals(person.getFirstName(), actual.getFirstName(), () -> "The FirstName is different!"),	
			() -> assertEquals(person.getLastName(), actual.getLastName(), () -> "The LastName is different!"),
			() -> assertEquals(person.getEmail(), actual.getEmail(), () -> "The Email is different!"),	
			() -> assertEquals(person.getAddress(), actual.getAddress(), () -> "The Address is different!"),	
			() -> assertEquals(person.getGender(), actual.getGender(), () -> "The Gender is different!")
		);
		System.out.println("OK");
	}
	
	@DisplayName("When create a person with null email Should throw exception")
	@Test
	void testCreatePerson_WhitNullEmail_ShouldThrowIllegalArgumentException() {
		// Given / Arrange
		
		person.setEmail(null);
		
		var expectedMessage = "The person email is null or empty";	
		// When / Act
				
		// then / Assert
		IllegalArgumentException exception = assertThrows(
			IllegalArgumentException.class,
			()-> service.createPerson(person),
			()-> "Empty e-mail should have cause an illegal Argument exception"
			
		);
		// then / Assert
		assertEquals(expectedMessage,
				exception.getMessage(),
				() -> "Exception error message is incorrect!"
		);
	}
	
}