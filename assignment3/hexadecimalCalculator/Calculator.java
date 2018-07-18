package hexadecimalCalculator;

public interface Calculator {

	public String add(String number1, String number2);
	
	public String subtract(String number1, String number2);
	
	public String multiply(String number1, String number2);
	
	public String divide(String number1, String number2);
	
	public boolean equal(String number1, String number2);
	
	public boolean greaterThan(String number1, String number2);
	
	public boolean lessThan(String number1, String number2);
}
