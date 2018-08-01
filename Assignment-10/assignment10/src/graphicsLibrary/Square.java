package graphicsLibrary;

import java.util.Date;

/**
 * this class implements the Shape class to make objects of ShapeType square
 * @author Prakalpa-Rathore
 *
 */
public class Square implements Shape{

    public Date timestamp = null; //time at which object is added to screen
    double width;
    Point origin;
    double originDistance; //distance between origin of the shape and origin of the screen
    
    //constructor of class
    public Square(double width, Point origin) {
        this.width = width;
        this.origin = origin;
        this.originDistance = Math.sqrt(Math.pow(origin.getX(), 2) + Math.pow(origin.getY(), 2));
    }
    
    @Override
    public ShapeType getShapeType() {
        return ShapeType.SQUARE;
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
     * calculates the area of the square
     * @return area
     */
    @Override
    public double getArea() {
        
        return width * width;
    }

    
    /**
     * calculates the perimeter of the square
     * @return perimeter
     */
    @Override
    public double getPerimeter() {
        
        return 4 * width;
    }

    
    @Override
    public Point getOrigin() {
        return origin;
    }

    
    /**
     * checks if the given point lies inside the square or not
     */
    @Override
    public boolean isPointEnclosed(Point point) {
        
        boolean enclosed = false;
        
        if(point.getX() >= origin.getX() && point.getX() <= width && point.getY() >= origin.getY() && point.getY() <= width)
            enclosed = true;
        
        return enclosed;
    }
    
}
