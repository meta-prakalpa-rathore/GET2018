package hexadecimalCalculator;

/**
 * this class performs different operations on hexadecimal numbers
 * @author Prakalpa-Rathore
 *
 */
public class HexCalc implements Calculator {

	
	/**
	 * adds two hexadecimal numbers
	 * @param two hexadecimal numbers
	 * @return addition result
	 */
	public String add(String hexNumber1, String hexNumber2)
	{
		int intNumber1 = hexaToDecimal(hexNumber1.toUpperCase());
		int intNumber2 = hexaToDecimal(hexNumber2.toUpperCase());
		
		int intAdd = intNumber1 + intNumber2;
		
		String hexAdd = decimalToHexa(intAdd);
		
		return hexAdd;
	}
	
	
	/**
	 * subtracts a hexadecimal number from another hexadecimal number
	 * @param two hexadecimal numbers
	 * @return subtraction result
	 */
	public String subtract(String hexNumber1, String hexNumber2)
	{
		int intNumber1 = hexaToDecimal(hexNumber1.toUpperCase());
		int intNumber2 = hexaToDecimal(hexNumber2.toUpperCase());
		int intSubtract;
		String hexSubtract;
		
		if(intNumber1 > intNumber2)
		{
			intSubtract = intNumber1 - intNumber2;
			hexSubtract = decimalToHexa(intSubtract);
		}
		else
		{
			intSubtract = intNumber2 - intNumber1;
			hexSubtract = decimalToHexa(intSubtract);
			hexSubtract = "-" + hexSubtract;
		}
		
		return hexSubtract;
	}
	
	
	/**
	 * multiplies two hexadecimal numbers
	 * @param two hexadecimal numbers
	 * @return multiplication result
	 */
	public String multiply(String hexNumber1, String hexNumber2)
	{
		int intNumber1 = hexaToDecimal(hexNumber1.toUpperCase());
		int intNumber2 = hexaToDecimal(hexNumber2.toUpperCase());
		
		int intMultiply = intNumber1 * intNumber2;
		
		String hexMultiply = decimalToHexa(intMultiply);
		
		return hexMultiply;
	}
	
	
	/**
	 * divides a hexadecimal number by another hexadecimal number
	 * throws an exception if denominator is 0
	 * @param two hexadecimal numbers
	 * @return division result
	 */
	public String divide(String hexNumber1, String hexNumber2)
	{
		int intNumber1 = hexaToDecimal(hexNumber1.toUpperCase());
		int intNumber2 = hexaToDecimal(hexNumber2.toUpperCase());
		int intDivide = 0;
		
		try 
		{
				intDivide = intNumber1 / intNumber2;
		}
		catch(Exception exception)
		{
			throw new AssertionError("Exception caught: Cannot divide by 0");
		}
		
		String hexDivide = decimalToHexa(intDivide);
		
		return hexDivide;
	}
	
	
	/**
	 * compares two hexadecimal numbers
	 * @param two hexadecimal numbers
	 * @return true if equal, false otherwise
	 */
	public boolean equal(String hexNumber1, String hexNumber2)
	{
		hexNumber1 = removeStartingZeroes(hexNumber1);
		hexNumber2 = removeStartingZeroes(hexNumber2);
		boolean result = hexNumber1.equals(hexNumber2);
		return result;
	}
	
	
	/**
	 * compares two hexadecimal numbers
	 * @param two hexadecimal numbers
	 * @return true if first number is greater, false otherwise
	 */
	public boolean greaterThan(String hexNumber1, String hexNumber2)
	{
		boolean greater = false;
		String hexDigits = "0123456789ABCDEF";
		hexNumber1 = removeStartingZeroes(hexNumber1.toUpperCase());
		hexNumber2 = removeStartingZeroes(hexNumber2.toUpperCase());
		
		if(hexNumber1.length() > hexNumber2.length())
		{
			greater = true;
		}
		else
			if(hexNumber1.length() == hexNumber2.length())
			{
				for(int i=0; i<hexNumber1.length(); i++)
				{
					if(hexDigits.indexOf(hexNumber1.charAt(i)) > hexDigits.indexOf(hexNumber2.charAt(i)))
					{
						greater = true;
						break;
					}
					else
						if(hexNumber1.charAt(i) == hexNumber2.charAt(i))
						{
							continue;
						}
						else
							break;
				}
			}
		
		return greater;		
	}
	
	
	/**
	 * compares two hexadecimal numbers
	 * @param two hexadecimal numbers
	 * @return true if first number is smaller, false otherwise
	 */
	public boolean lessThan(String hexNumber1, String hexNumber2)
	{
		boolean small = false;
		String hexDigits = "0123456789ABCDEF";
		hexNumber1 = removeStartingZeroes(hexNumber1.toUpperCase());
		hexNumber2 = removeStartingZeroes(hexNumber2.toUpperCase());
		
		if(hexNumber1.length() < hexNumber2.length())
		{
			small = true;
		}
		else
			if(hexNumber1.length() == hexNumber2.length())
			{
				for(int i=0; i<hexNumber1.length(); i++)
				{
					if(hexDigits.indexOf(hexNumber1.charAt(i)) < hexDigits.indexOf(hexNumber2.charAt(i)))
					{
						small = true;
						break;
					}
					else
						if(hexNumber1.charAt(i) == hexNumber2.charAt(i))
						{
							continue;
						}
						else
							break;
				}
			}
		
		return small;		
	}
	
	
	/**
	 * converts a hexadecimal number to decimal number
	 * @param hexNumber a hexadecimal number
	 * @return decimal equivalent of input
	 */
	public int hexaToDecimal(String hexNumber)
	{
	    hexNumber = hexNumber.toUpperCase();
		int intNumber = 0;
		int power = 0;
		String hexDigits = "0123456789ABCDEF";
		
		for(int i = hexNumber.length() - 1; i >= 0; i--)
		{	
			int valueOfCharacter = hexDigits.indexOf(hexNumber.charAt(i));
			intNumber = intNumber + valueOfCharacter * (int)Math.pow(16, power);
	  		power++;
		}
		
		return intNumber;
	}
	
	
	/**
	 * converts a decimal number to hexadecimal number
	 * @param number a decimal number
	 * @return hexadecimal equivalent of input
	 */
	public String decimalToHexa(int number)
	{
		String hexNumber = "", hexDigits = "0123456789ABCDEF";
		int intNumber = number;
		
		if(intNumber == 0)
			hexNumber = "0";
		while(intNumber != 0)
		{
			 int remainder = intNumber % 16;
			 hexNumber = hexDigits.charAt(remainder) + hexNumber;
			 intNumber = intNumber / 16;	 
		}
		
		return hexNumber;
	}
	
	
	/**
	 * removes the insignificant 0's from the hexadecimal number
	 * @param hexNumber a hexadecimal number
	 * @return hexadecimal number without insignificant 0's
	 */
	private String removeStartingZeroes(String hexNumber)
	{
		String result = "";
		int i = 0;
		
		while(hexNumber.charAt(i) == '0')
		{
			i++;
		}
		
		while(i < hexNumber.length())
		{
			result = result + hexNumber.charAt(i);
			i++;
		}
		
		return result;
	}
	
}
