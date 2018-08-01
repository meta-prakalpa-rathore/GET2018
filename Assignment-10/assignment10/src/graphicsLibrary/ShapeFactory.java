package graphicsLibrary;

import java.util.List;

/**
 * this class creates objects of various shape types
 * @author Prakalpa-Rathore
 *
 */
public class ShapeFactory {
    
    /**
     * method to create the object of specified shape type
     * @param shapeType
     * @param origin
     * @param parameters, list of parameters vary according to shape type
     * @return
     */
    public static Shape createShape(ShapeType shapeType, Point origin, List<Double> parameters)
    {
        Shape shapeObject = null;
        
        switch(shapeType)
        {
        // parameters contains radius
        case CIRCLE:          shapeObject = new Circle(parameters.get(0), origin);
                              break;
                              
        // parameters contains length, breadth
        case RECTANGLE:       shapeObject = new Rectangle(parameters.get(0), parameters.get(1), origin);
                              break;
                              
        // parameters contains width
        case SQUARE:          shapeObject = new Square(parameters.get(0), origin);
                              break;
                              
        // parameters contains length of side1, length of side2, length of side3, height
        case TRIANGLE:        shapeObject = new Triangle(parameters.get(0), parameters.get(1), parameters.get(2), parameters.get(3), origin);
                              break;
                              
        // parameters contains no. of sides, length of side   
        case REGULAR_POLYGON: shapeObject = new RegularPolygon(parameters.get(0), parameters.get(1), origin);
                              break;
        }
        
        return shapeObject;
    }
}
