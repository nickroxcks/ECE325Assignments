/**
 * Assignment 4 Part 2: Unit Testing <br />
 * The calculator to run the test cases
 */
// TODO: Assignment 4 Part 2 -- Create the Calculator here
//Nicholas Serrano
//ECE 325 Assignment 4
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Calculator{
	
public Double add(Double val1, Double val2) {
	

	return (Double.valueOf(val1 + val2));
	
}	
public Double add(int val1, int val2) {
	

	return (Double.valueOf(val1 + val2));
	
}	

public Double subtract(double val1, double val2) {
	
	
	return(Double.valueOf(val1-val2));
}

public Double multiply(double val1, double val2) {
	
	
	return(Double.valueOf(val1*val2));
}
public Double divide(double val1, double val2) {
	
	
	return(Double.valueOf(val1/val2));
}
public Double[] getRoots(Double a, Double b, Double c)
{
	double val1 = b*b - 4*a*c;
	
	Double val2 = Math.sqrt(val1);
	Double x1 = (b*-1.0 + val2)/(2*a);
	Double x2 = (b*-1.0 - val2)/(2*a);
	Double[] finalval = {x1,x2};
	return finalval;
}

public double findroot(double a) {
	
	double finalans = Math.pow(a, 0.5);
	return finalans;
}




}