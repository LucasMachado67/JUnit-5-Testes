package br.com.lucas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.Random.class)
class MethodOrderedRandonlyTest {

	@Test
	void testA() {
		System.out.println("Running test A");
	}
	
	@Test
	void testB() {
		System.out.println("Running test B");
	}
	
	@Test
	void testC() {
		System.out.println("Running test C");
	}
	
	@Test
	void testD() {
		System.out.println("Running test D");
	}

}
