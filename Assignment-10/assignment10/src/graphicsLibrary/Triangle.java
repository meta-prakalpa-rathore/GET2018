package graphicsLibrary;

import java.util.Date;

/**
 * this class implements the Shape class to make objects of ShapeType triangle
 * @author Prakalpa-Rathore
 *
 */
public class Triangle implements Shape {

    public Date timestamp = null; //time at which object is added to screen
    double firstSide, secondSide, thirdSide, height;
    Point origin;
    double originDistance; //distance between origin of the shape and origin of the screen
    
    //constructor of class
    public Triangle(double firstSide, double secondSide, double thirdSide, double height, Point origin) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
        this.height = height;
        this.origin = origin;
        this.originDistance = Math.sqrt(Math.pow(origin.getX(), 2) + Math.pow(origin.getY(), 2));
    }
    
    @Override
    public ShapeType getShapeType() {
        return ShapeType.TRIANGLE;
    }
    
    @Override
    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    public double getOriginDistance() {
        return originDistance;
    }

    
    /**
     * calculates the area of the triangle, assumes firstSide to be the base
     * @return area
     */
    @Override
    public double getArea() {
        
        return 0.5 * firstSide * height;
    }

    
    /**
     * calculates the perimeter of the triangle
     * @return perimeter
     */
    @Override
    public double getPerimeter() {
        
        return firstSide + secondSide + thirdSide;
    }

    
    @Override
    public Point getOrigin() {
        return origin;
    }

    
    /**
     * checks if the given point lies inside the triangle or not
     */
    @Override
    public boolean isPointEnclosed(Point point) {
        
        boolean enclosed = false;
        double base = Math.sqrt(Math.pow(thirdSide, 2) - Math.pow(height, 2));
        Point b = new Point(origin.getX() + firstSide, origin.getY());
        Point c = new Point(origin.getX() + base, origin.getY() + height);
                
        if(Math.abs(getArea() - ((getAreaByVertices(point, origin, b)) + getAreaByVertices(point, b, c) + getAreaByVertices(point, origin, c))) <= 0.001)
            enclosed = true;        
        
        return enclosed;
    }
    
    public double getAreaByVertices(Point a, Point b, Point c)
    {
        return Math.abs((a.getX() * (b.getY() - c.getY()) + b.getX() * (c.getY() - a.getY()) + c.getX() * (a.getY() - b.getY())) / 2.0);
    } 
}
