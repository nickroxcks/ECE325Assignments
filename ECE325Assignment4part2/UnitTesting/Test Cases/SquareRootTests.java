import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for solving square roots
 */
public class SquareRootTests {

    // TODO: Assignment 4 Part 2 -- Checkpoint4
	 private Calculator calc;
	 
    @Before public void setUp() throws Exception {
    	calc = new Calculator();
    }

    @After public void tearDown() throws Exception {
    }

    @Test public void testRandomPositiveSquareRoot() {
        // You cannot use the Math.sqrt() function in the test!
        //once again, very unclear assignment specs. Can't use 
    	//Math.sqrt() in the test case, or the calc method?
        double a = (Math.random() - 0.5) * 200000000;
        if(a<0.0) {
        	a = a*-1;
        }
        assertTrue(0.0 < calc.findroot(a));
    }

    @Test public void testRandomNegitiveSquareRoot() {
        // The result should be a complex number i.e. Double.isNaN()
        double a = (Math.random() - 0.5) * 200000000;
        if(a>0.0) {
        	a = a*-1;
        }
        assertTrue(Double.isNaN(calc.findroot(a)));
    }

    @Test public void testSquareRootofZero() {
        // You cannot use the Math.sqrt() function in the test!
        double a = 0.0;
        assertTrue(calc.findroot(a) == 0.0);
    }

    @Test public void testSquareRootofOne() {
        // You cannot use the Math.sqrt() function in the test!
        double a = 1;
        assertTrue(calc.findroot(a) == 1.0);
    }

}
