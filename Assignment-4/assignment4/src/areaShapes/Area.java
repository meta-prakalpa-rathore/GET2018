package areaShapes;

/**
 * this class calculates the area of different shapes
 * @author Prakalpa-Rathore
 *
 */
public class Area {

	private final double PI = 3.14;
	
	/**
	 * calculates area of triangle
	 * @param base of triangle, assumes base > 0
	 * @param height of triangle, assumes height > 0
	 * @return area of triangle
	 */
	public double areaOfTriangle(double base, double height) throws ArithmeticException
	{
		return 0.5 * base * height;
	}
	
	
	/**
	 * calculates area of rectangle
	 * @param width of rectangle, assumes width > 0
	 * @param height of rectangle, assumes height > 0
	 * @return area of rectangle
	 */
	public double areaOfRectangle(double width, double height) throws ArithmeticException
	{
		return width * height;
	}
	
	
	/**
	 * calculates area of square
	 * @param width of square, assumes width > 0
	 * @return area of square
	 */
	public double areaOfSquare(double width) throws ArithmeticException
	{
		return width * width;
	}
	
	
	/**
	 * calculates area of circle
	 * @param radius of circle, assumes radius > 0
	 * @return area of circle
	 */
	public double areaOfCircle(double radius) throws ArithmeticException
	{
		return PI * radius * radius;
	}
}
