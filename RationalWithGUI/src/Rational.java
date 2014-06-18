import java.math.BigInteger;
import java.util.Scanner;

/**
 * Class which creates and performs operations with rational numbers.
 * 
 * 
 * @author Dulia
 *
 */
public class Rational {

	/**
	 * Numerator
	 */
	private final BigInteger myN;   
	/**
	 * Denominator
	 */
	private final BigInteger myD;	  


	/**
	 * Creates a basic rational with the value of 0 or 0/1.
	 */
	public Rational() {             
		myN = BigInteger.valueOf(0);
		myD = BigInteger.valueOf(1);
	}
	
	/**
	 * Creates a rational with the given numerator.
	 * 
	 * @param n int numerator
	 */
	public Rational(int n) {        
		myN = BigInteger.valueOf(n);                    
		myD = BigInteger.valueOf(1);
	}

	/**
	 * Creates a rational with the given numerator and denominator.
	 * 
	 * @param numerator int
	 * @param denominator int
	 */
	public Rational(int numerator, int denominator) {    //Takes 2 inputs 1 for the numerator and 1 for the denominator
		Rational temp = new Rational(BigInteger.valueOf(numerator),BigInteger.valueOf(denominator));
		myD = temp.myD;
		myN = temp.myN;
	}
	

	/**
	 * Creates a rational with the given Strings by first converting them to integers.
	 * 
	 * @param N String numerator
	 * @param D String denominator
	 */
	public Rational(String N, String D) {
		Integer intn = null;
		Integer intd = null;
		intn=intn.parseInt(N);
		intd=intd.parseInt(D);
		Rational temp = new Rational(intn,intd);
		myD = temp.myD;
		myN = temp.myN;
		
	}
	
	/**
	 * Creates a rational with the given numerator and denominator.
	 * 
	 * @param numerator BigInteger 
	 * @param denominator BigInteger 
	 * @throws IllegalArgumentException if denominator is 0
	 */
	public Rational(BigInteger numerator, BigInteger denominator) {    //Takes 2 inputs 1 for the numerator and 1 for the denominator
		myN = numerator;
		if (!denominator.toString().equals("0")) {
			myD = denominator;
		} else {    
			throw new IllegalArgumentException("Denominator can not be 0.");
		}
		
	}

	/**
	 * Clones a given rational object.
	 * 
	 * @param other Rational which will be copied
	 */
	public Rational(Rational other) {   //copy class
		this.myN = other.myN;
		this.myD = other.myD;
	}
	
	/**
	 * Creates a rational with the given numerator and denominator, than simplifies it.
	 * 
	 * @param N BigInteger numerator
	 * @param D BigInteger denominator
	 * @return Rational which is a simplified version of the one given the parameters for.
	 */
	private Rational createSimplifiedRational(BigInteger N, BigInteger D) {
	 	Rational temp = new Rational(N, D);
		 	return temp.simplify();
		 }
	

	/**
	 * Simplifies a rational
	 * 
	 * @return Rational which is a simplified version of this
	 */
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


	/**
	 * Subtracts one rational from another
	 * 
	 * @param other Rational which will be subtracted from this
	 * @return Rational which is this rational - other rational
	 */
	public Rational subtract(Rational other) {                                //Finds the difference
		BigInteger D = this.myD.multiply(other.myD);
		BigInteger N = (this.myN.multiply(other.myD)).subtract(other.myN.multiply(this.myD));  

		return createSimplifiedRational(N,D);
	}
	
	/**
	 * Adds two rational numbers together
	 * 
	 * @param other Rational which will be added to this
	 * @return Rational which is this rational + other rational
	 */
	public Rational add(Rational other) {                     //Adds the 2 fractions together
		BigInteger D = this.myD.multiply(other.myD);
		BigInteger N = (this.myN.multiply(other.myD)).add(other.myN.multiply(this.myD));

		return createSimplifiedRational(N,D);
	}

	/**
	 * Multiplies two rational numbers together
	 * 
	 * @param other Rational which will be multiplied by
	 * @return Rational which is this rational * other rational
	 */
	public Rational multiply(Rational other) {                //Gets the product of the fraction
		BigInteger D = this.myD.multiply(other.myD);
		BigInteger N = this.myN.multiply(other.myN);

		return createSimplifiedRational(N,D);
	}
	
	/**
	 * Divides one rational by another
	 * 
	 * @param other Rational which will be divided by
	 * @return Rational which is this rational / other rational
	 */
	public Rational divide(Rational other) {            //Finds the quotient of 2 fractions
		BigInteger D = this.myD.multiply(other.myN);
		BigInteger N = this.myN.multiply(other.myD);

		return createSimplifiedRational(N,D);
	}

	public boolean equals(Object obj)
	{
		Rational other;
		if(!(obj instanceof Rational))
		{
			throw new IllegalArgumentException("Rational can only be compared to another Rational.");
		}
		else
		{
			other = (Rational)obj;
		}
		Rational simple1 = createSimplifiedRational(myN,myD);
		Rational simple2 = createSimplifiedRational(other.myN,other.myD);
		
		return ((simple1.myD.equals(simple2.myD))&&(simple1.myN.equals(simple2.myN)));
	}
	
	public String toString() {                           //how a fraction is displayed in the Program main
		if ( ! myD.toString().equals("1")) {
			return (myN + "/" + myD);
		} else {
			return myN + "";
		}
	}
	
	
}

