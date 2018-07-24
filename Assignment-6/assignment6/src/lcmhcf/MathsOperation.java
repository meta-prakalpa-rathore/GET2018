package lcmhcf;

public class MathsOperation {

	/**
	 * calculates the lcm of two numbers
	 * @param x a positive integer
	 * @param y a positive integer
	 * @return lcm of x & y
	 */
	public int LCM (int x, int y)
	{		
		return (x * y) / HCF(x, y);
	}
	
	
	/**
	 * calculates the hcf of two numbers
	 * @param x a positive integer
	 * @param y a positive integer
	 * @return hcf of x & y
	 */
	public int HCF(int x, int y)
	{
		if(y != 0)
			return HCF(y, x % y);
		else
			return x;
	}
	
}
