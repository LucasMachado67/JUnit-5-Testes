package br.com.lucas.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import org.junit.jupiter.api.TestInfo;

import math.SimpleMath;

class DemoRepeatedTest {

	
	SimpleMath math;
	@BeforeEach
    void beforeEachMethod() {
        math = new SimpleMath();
        System.out.println("Running @BeforeEach method!");
    }
	
	@RepeatedTest(3)
    @DisplayName("Test Division by Zero")
    void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException(
    			RepetitionInfo repetioInfo,
    			TestInfo testInfo
    		) {
        
		System.out.println("Repetition Nº " + repetioInfo.getCurrentRepetition() + 
				" of " + repetioInfo.getTotalRepetitions());
		
		System.out.println("Runnig " + testInfo.getTestMethod().get().getName());
        //given
        double firstNumber = 6.2D;
        double secondNumber = 0D;
        
        var expectedMessage = "Impossible to divide by zero!";
        
        //when & then
        ArithmeticException actual = assertThrows(
            ArithmeticException.class, () -> {
                //when & then
                math.division(firstNumber, secondNumber);
            }, () -> "Division by zero should throw an ArithmeticException");
        
        assertEquals(expectedMessage, actual.getMessage(),
            () -> "Unexpected exception message!");
    }

}
