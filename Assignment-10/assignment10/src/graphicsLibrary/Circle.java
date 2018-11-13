package graphicsLibrary;

import java.util.Date;

/**
 * this class implements the Shape class to make objects of ShapeType Circle
 * @author Prakalpa-Rathore
 *
 */
public class Circle implements Shape{
    
    public Date timestamp = null; //time at which object is added to screen
    double radius;
    Point origin;
    double originDistance; //distance between origin of the shape and origin of the screen
    
    //constructor of class
    public Circle(double radius, Point origin) {
        this.radius = radius;
        this.origin = origin;
        this.originDistance = Math.sqrt(Math.pow(origin.getX(), 2) + Math.pow(origin.getY(), 2));
    }
    
    @Override
    public ShapeType getShapeType() {
        return ShapeType.CIRCLE;
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
     * calculates the area of the circle
     * @return area
     */
    @Override
    public double getArea() {
   
        return Math.PI * radius * radius;
    }
    

    /**
     * calculates the perimeter of the circle
     * @return perimeter
     */
    @Override
    public double getPerimeter() {
        
        return 2 * Math.PI * radius;
    }

    
    @Override
    public Point getOrigin() {
        return origin;
    }

    
    /**
     * checks if the given point lies inside the circle or not
     */
    @Override
    public boolean isPointEnclosed(Point point) {
        
        boolean enclosed = false;
        double slope = origin.getY() / origin.getX();
        double theta = Math.atan(slope);
        double height = slope * Math.sin(theta);
        double base = slope * Math.cos(theta);
        
        Point centre = new Point(origin.getX() + base, origin.getY() + height);
        double distance = Math.sqrt(Math.pow(point.getX() - centre.getX(), 2) + Math.pow(point.getY() - centre.getY(), 2));
        
        if(distance <= radius)
            enclosed = true;
        return enclosed;
    }

}
