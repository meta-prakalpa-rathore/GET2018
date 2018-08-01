package graphicsLibrary;

import java.util.Date;

/**
 * this class implements the Shape class to make objects of ShapeType Regular Polygon
 * @author Prakalpa-Rathore
 *
 */
public class RegularPolygon implements Shape{
    
    public Date timestamp = null; //time at which object is added to screen
    int noOfSides;
    double lengthOfSide;
    Point origin;
    double originDistance; //distance between origin of the shape and origin of the screen
    
    //constructor of class
    public RegularPolygon(double noOfSides, double lengthOfSide, Point origin) {
        this.noOfSides = (int)noOfSides;
        this.lengthOfSide = lengthOfSide;
        this.origin = origin;
        this.originDistance = Math.sqrt(Math.pow(origin.getX(), 2) + Math.pow(origin.getY(), 2));
    }
    
    public ShapeType getShapeType() {
        return ShapeType.REGULAR_POLYGON;
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
     * calculates the area of the Regular Polygon
     * @return area
     */
    @Override
    public double getArea() {
        
        double apothem = lengthOfSide / (2 * Math.tan(Math.toRadians(180 / noOfSides)));
        
        return (getPerimeter() * apothem / 2);
    }

    
    /**
     * calculates the perimeter of the Regular Polygon
     * @return perimeter
     */
    @Override
    public double getPerimeter() {
        
        return noOfSides * lengthOfSide;
    }

    
    @Override
    public Point getOrigin() {
        return origin;
    }

    
    /**
     * checks if the given point lies inside the Regular Polygon or not
     */
    @Override
    public boolean isPointEnclosed(Point point) {
        
        boolean enclosed = false;
        
        
        return enclosed;
    }    
}
