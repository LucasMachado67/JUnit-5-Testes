package br.com.lucas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MethodOrderedByOrder {

	@Test
	@Order(1)
	void testA() {
		System.out.println("Running test A");
	}
	
	@Test
	@Order(4)
	void testB() {
		System.out.println("Running test B");
	}
	
	@Test
	@Order(3)
	void testC() {
		System.out.println("Running test C");
	}
	
	@Test
	@Order(2)
	void testD() {
		System.out.println("Running test D");
	}

}
