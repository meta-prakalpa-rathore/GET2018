package graphicsLibrary;

import java.util.Date;

/**
 * this class implements the Shape class to make objects of ShapeType Rectangle
 * @author Prakalpa-Rathore
 *
 */
public class Rectangle implements Shape
{
    public Date timestamp = null; //time at which object is added to screen
    double length, breadth;
    Point origin;
    double originDistance; //distance between origin of the shape and origin of the screen
    
    //constructor of class
    public Rectangle(double length, double breadth, Point origin) {
        this.length = length;
        this.breadth = breadth;
        this.origin = origin;
        this.originDistance = Math.sqrt(Math.pow(origin.getX(), 2) + Math.pow(origin.getY(), 2));
    }
    
    @Override
    public ShapeType getShapeType() {
        return ShapeType.RECTANGLE;
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
     * calculates the area of the rectangle
     * @return area
     */
    @Override
    public double getArea() {
        
        return length * breadth;
    }

    
    /**
     * calculates the perimeter of the rectangle
     * @return perimeter
     */
    @Override
    public double getPerimeter() {
        
        return 2 * (length + breadth);
    }

    
    @Override
    public Point getOrigin() {
        return origin;
    }

    
    /**
     * checks if the given point lies inside the rectangle or not
     */
    @Override
    public boolean isPointEnclosed(Point point) {
        
        boolean enclosed = false;
        
        if(point.getX() >= origin.getX() && point.getX() <= length && point.getY() >= origin.getY() && point.getY() <= breadth)
            enclosed = true;
        
        return enclosed;
    }

}
