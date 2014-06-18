
/**
 * Class which provides additional help methods.
 * 
 * @author Dulia
 *
 */

public class Utils {
	
	/**
	 * Checks of the given string is a number.
	 * 
	 * @param s String which will be tested
	 * @return Boolean true is the string given is a number otherwise it returns false
	 */
	 public static boolean isNumber(String s)
		{
			for(int x = 0; x < s.length(); x++)
			{	
				int charnum = (int)(s.charAt(x));
				if(x==0 && charnum==45 && s.length()>1){}              //if at 0 the value is '-' the the string is ok
				else if(charnum < 48 || charnum > 57){return false;}   //if there is a char which is not a number the whole strong is not a number
			}
			return true;
		}
	    
	 /**
	  * Checks whether number is too big to be taken by the program
	  * 
	  * @param s String which will be tested
	  * @return Boolean true if it is too big and false if it is not.
	  */
	    public static boolean isTooBig(String s)
	   	{
	    	if(s.startsWith("-")&&s.length()>10){return true;}
	    	else if(s.startsWith("-")){return false;}
	        else if(s.length()>9){return true;}
	   		return false;
	   	}
	    

}
