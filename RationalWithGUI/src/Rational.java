import java.math.BigInteger;
import java.util.Scanner;

// add javadoc for the class and methods
public class Rational {

	private final BigInteger myN;       //Numerator
	private final BigInteger myD;	   //Denominator


	public Rational() {             
		myN = BigInteger.valueOf(0);
		myD = BigInteger.valueOf(1);
	}
	
	public Rational(int n) {        
		myN = BigInteger.valueOf(n);                    
		myD = BigInteger.valueOf(1);
	}

	// how can u use Rational(BigInteger numerator, BigInteger denominator) here 
	// to avoid code duplication
	public Rational(int numerator, int denominator) {    //Takes 2 inputs 1 for the numerator and 1 for the denominator
		myN = BigInteger.valueOf(numerator);
		if (denominator != 0) {
			myD = BigInteger.valueOf(denominator);
		} else {    
			throw new IllegalArgumentException("Denominator could not be 0.");
		}
		
	}
	
	// what happen if D is "0"
	// how can u use Rational(BigInteger numerator, BigInteger denominator) here 
	public Rational(String N, String D) {
		Integer intn = null;
		Integer intd = null;
		intn=intn.parseInt(N);
		intd=intd.parseInt(D);
		myN = BigInteger.valueOf(intn);                    
		myD = BigInteger.valueOf(intd);
		
	}
	
	private Rational(BigInteger numerator, BigInteger denominator) {    //Takes 2 inputs 1 for the numerator and 1 for the denominator
		myN = numerator;
		if (!denominator.toString().equals("0")) {
			myD = denominator;
		} else {    
			throw new IllegalArgumentException("Denominator can not be 0.");
		}
		
	}

	public Rational(Rational other) {   //copy class
		this.myN = other.myN;
		this.myD = other.myD;
	}
	
	private Rational createSimplifiedRational(BigInteger N, BigInteger D) {
	 	Rational temp = new Rational(N, D);
		 	return temp.simplify();
		 }
	

	public Rational simplify() {              //Simplifies the fraction
		BigInteger diviser=BigInteger.valueOf(0);
		BigInteger tempN = myN;
		BigInteger tempD = myD;
		while ( ! diviser.toString().equals("1")) {
			diviser = tempN.gcd(tempD);
			tempN = tempN.divide(diviser);
			tempD = tempD.divide(diviser);
		}
		
		
		if(tempN.compareTo(BigInteger.valueOf(0))<0 && tempD.compareTo(BigInteger.valueOf(0))<0)
		{
			tempN=tempN.multiply(BigInteger.valueOf(-1));
			tempD=tempD.multiply(BigInteger.valueOf(-1));
		}
		else if(tempN.compareTo(BigInteger.valueOf(0))>0 && tempD.compareTo(BigInteger.valueOf(0))<0)
		{
			tempN=tempN.multiply(BigInteger.valueOf(-1));
			tempD=tempD.multiply(BigInteger.valueOf(-1));
		}
		
		return new Rational(tempN, tempD);
	}


	public Rational subtract(Rational other) {                                //Finds the difference
		BigInteger D = this.myD.multiply(other.myD);
		BigInteger N = (this.myN.multiply(other.myD)).subtract(other.myN.multiply(this.myD));  

		return createSimplifiedRational(N,D);
	}
	
	
	public Rational add(Rational other) {                     //Adds the 2 fractions together
		BigInteger D = this.myD.multiply(other.myD);
		BigInteger N = (this.myN.multiply(other.myD)).add(other.myN.multiply(this.myD));

		return createSimplifiedRational(N,D);
	}

	public Rational multiply(Rational other) {                //Gets the product of the fraction
		BigInteger D = this.myD.multiply(other.myD);
		BigInteger N = this.myN.multiply(other.myN);

		return createSimplifiedRational(N,D);
	}
	
	
	public Rational divide(Rational other) {            //Finds the quotient of 2 fractions
		BigInteger D = this.myD.multiply(other.myN);
		BigInteger N = this.myN.multiply(other.myD);

		return createSimplifiedRational(N,D);
	}

	// can u change signature to standard java equals method
	// see http://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#equals%28java.lang.Object%29
	public boolean isEqual(Rational other)
	{
		return ((this.myD.equals(other.myD))&&(this.myN.equals(other.myN)));
	}
	
	public String toString() {                           //how a fraction is displayed in the Program main
		if ( ! myD.toString().equals("1")) {
			return (myN + "/" + myD);
		} else {
			return myN + "";
		}
	}
	
	
}

