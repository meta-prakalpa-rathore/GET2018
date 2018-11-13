package graphicsLibrary;

/**
 * this class represents coordinates 
 * @author Prakalpa-Rathore
 *
 */
public class Point {

    private double x, y; //to store x and y coordinates
    
    //constructor of class
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
}
