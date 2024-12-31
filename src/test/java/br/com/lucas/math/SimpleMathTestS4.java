package br.com.lucas.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import math.SimpleMath;

@DisplayName("Test Math Operations in SimpleMath Class")
class SimpleMathTestS4 {

    SimpleMath math;
    
    @BeforeEach
    void beforeEachMethod() {
        math = new SimpleMath();
        System.out.println("Running @BeforeEach method!");
    }
    
    @AfterEach
    void afterEachMethod() {
        System.out.println("Running @AfterEach method!");
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"Pelé", "Senna" , "Keith Moon"})
    void testValueSource(String firstName) {
    	System.out.println(firstName);
    	assertNotNull(firstName);
    }
    
//    @MethodSource("testDivisionInputParameters")
//    @DisplayName("Test 6.2 / 2 = 3.1")
    @ParameterizedTest
    /**@CsvSource({
    	"6.2, 2, 3.1",	
		"71, 14, 5.07",	
		"18.3, 3.1, 5.90"
    })**/
    @CsvFileSource(resources = "/testDivision.csv")
    void testDivision(double firstNumber,double secondNumber,double expected) {
        
        Double actual = math.division(firstNumber, secondNumber);
        
        assertEquals(expected, actual, 2D,
                () -> firstNumber + "/" + secondNumber +
                " did not produce " + expected + "!");
    }
    
//    public static Stream<Arguments> testDivisionInputParameters(){
//    	return Stream.of(
//    		Arguments.of(6.2D, 2D, 3.1D),	
//    		Arguments.of(71D, 14D, 5.07D),	
//    		Arguments.of(18.3D, 3.1D, 5.90D)	
//    	);
//    }
}