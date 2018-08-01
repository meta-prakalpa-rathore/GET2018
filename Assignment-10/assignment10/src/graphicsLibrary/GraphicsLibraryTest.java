package graphicsLibrary;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GraphicsLibraryTest {

    /**
     * test case for testing the various methods in Rectangle class
     */
    @Test
    public void rectangleTest()
    {
        Shape rectangle = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        
        assertEquals(8.0, rectangle.getArea(), 0.01);
        assertEquals(12.0, rectangle.getPerimeter(), 0.01);
        assertTrue(rectangle.isPointEnclosed(new Point(2, 1)));
        assertFalse(rectangle.isPointEnclosed(new Point(5, 5)));
    }
    
    
    /**
     * test case for testing the various methods in Square class
     */
    @Test
    public void squareTest()
    {
        Shape square = ShapeFactory.createShape(ShapeType.SQUARE, new Point(1, 1), new ArrayList<Double>(){{add(4.0);}});
        
        assertEquals(16.0, square.getArea(), 0.01);
        assertEquals(16.0, square.getPerimeter(), 0.01);
        assertTrue(square.isPointEnclosed(new Point(2, 1)));
        assertFalse(square.isPointEnclosed(new Point(5, 5)));
    }
    
    
    /**
     * test case for testing the various methods in Triangle class
     */
    @Test
    public void triangleTest()
    {
        Shape triangle = ShapeFactory.createShape(ShapeType.TRIANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(3.0); add(2.0); add(1.452);}});
        
        assertEquals(2.904, triangle.getArea(), 0.001);
        assertEquals(9.0, triangle.getPerimeter(), 0.001);
        assertTrue(triangle.isPointEnclosed(new Point(2, 1)));
        assertFalse(triangle.isPointEnclosed(new Point(5, 5)));
    }
    
    
    /**
     * test case for testing the various methods in Circle class
     */
    @Test
    public void circleTest()
    {
        Shape circle = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0);}});
        
        assertEquals(50.265, circle.getArea(), 0.001);
        assertEquals(25.133, circle.getPerimeter(), 0.001);
        assertTrue(circle.isPointEnclosed(new Point(2, 1)));
        assertFalse(circle.isPointEnclosed(new Point(10, 5)));
    }
    
    
    /**
     * test case to add an object to screen
     */
    @Test
    public void addShapeTest1() {
        
        Screen screen = new Screen(100, 100);
        Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        assertTrue(screen.addShape(shape1));
    }
    
    
    /**
     * test case to add an object to screen when object is null
     */
    @Test
    public void addShapeTest2() {
        Screen screen = new Screen(100, 100);
        assertFalse(screen.addShape(null));
    }

    
    /**
     * test case to add an object to screen when shape lies outside the screen
     */
    @Test
    public void addShapeTest3() {
        
        Screen screen = new Screen(100, 100);
        Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(120, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        assertFalse(screen.addShape(shape1));
    }
    
    
    /**
     * test case to remove a shape from screen when shape is present
     */
    @Test
    public void deleteShapeTest1() {
        
        Screen screen = new Screen(100, 100);
        Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        screen.addShape(shape1);
        
        assertTrue(screen.deleteShape(shape1));
    }
    
    
    /**
     * test case to remove a shape from screen when shape is not present
     */
    @Test
    public void deleteShapeTest2() {
        
        Screen screen = new Screen(100, 100);
        Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        screen.addShape(shape1);
        
        Shape shape2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 3), new ArrayList<Double>(){{add(5.0); add(2.0);}});        
        
        assertFalse(screen.deleteShape(shape2));
        assertFalse(screen.deleteShape(null));
    }

    
    /**
     * test case to remove all shapes of a particular type from the screen when objects of that type are present
     */
    @Test
    public void deleteShapeTypeTest1() {
        
        Screen screen = new Screen(100, 100);
        Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        screen.addShape(shape1);
        
        Shape shape2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 3), new ArrayList<Double>(){{add(5.0); add(2.0);}});        
        screen.addShape(shape2);
        
        Shape shape3 = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0);}});
        screen.addShape(shape3);
        
        assertTrue(screen.deleteShapeType(ShapeType.RECTANGLE));
    }
    
    
    /**
     * test case to remove all shapes of a particular type from the screen when no object of that type are present
     */
    @Test
    public void deleteShapeTypeTest2() {
        
        Screen screen = new Screen(100, 100);
        Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        screen.addShape(shape1);
        
        Shape shape2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 3), new ArrayList<Double>(){{add(5.0); add(2.0);}});        
        screen.addShape(shape2);
        
        Shape shape3 = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0);}});
        screen.addShape(shape3);
        
        assertFalse(screen.deleteShapeType(ShapeType.SQUARE));
        assertFalse(screen.deleteShapeType(null));
    }
    
    
    /**
     * test case to sort the shapes on screen according to area
     */
    @Test
    public void sortByAreaTest1() {
        
        Screen screen = new Screen(100, 100);
        Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        screen.addShape(shape1);
        
        Shape shape2 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(1, 1), new ArrayList<Double>(){{add(2.0);}});
        screen.addShape(shape2);
        
        List<Shape> sortedShapeByArea = screen.sortByArea();
        assertEquals(sortedShapeByArea, new ArrayList<Shape>(){{add(shape2); add(shape1);}}); 
    }
    
    
    /**
     * test case to sort the shapes on screen according to area when no object is present on screen
     */
    @Test(expected = AssertionError.class)
    public void sortByAreaTest2() {
        
        Screen screen = new Screen(100, 100);
        
        screen.sortByArea();
    }
    
    
    /**
     * test case to sort the shapes on screen according to Perimeter
     */
    @Test
    public void sortByPerimeterTest1() {
        
        Screen screen = new Screen(100, 100);
        Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        screen.addShape(shape1);
        
        Shape shape2 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(1, 1), new ArrayList<Double>(){{add(2.0);}});
        screen.addShape(shape2);
        
        List<Shape> sortedShapeByPerimeter = screen.sortByPerimeter();
        assertEquals(sortedShapeByPerimeter, new ArrayList<Shape>(){{add(shape2); add(shape1);}}); 
    }
    
    
    /**
     * test case to sort the shapes on screen according to Perimeter when no object is present on screen
     */
    @Test(expected = AssertionError.class)
    public void sortByPerimeterTest2() {
        
        Screen screen = new Screen(100, 100);
        
        screen.sortByPerimeter();
    }
    
    
    /**
     * test case to sort the shapes on screen according to OriginDistance
     */
    @Test
    public void sortByOriginDistanceTest1() {
        
        Screen screen = new Screen(100, 100);
        Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        screen.addShape(shape1);
        
        Shape shape2 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(2, 1), new ArrayList<Double>(){{add(2.0);}});
        screen.addShape(shape2);
        
        Shape shape3 = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(0, 0), new ArrayList<Double>(){{add(4.0);}});
        screen.addShape(shape3);
        
        List<Shape> sortedShapeByOriginDistance = screen.sortByOriginDistance();
        assertEquals(sortedShapeByOriginDistance, new ArrayList<Shape>(){{add(shape3); add(shape1); add(shape2);}}); 
    }
    
    
    /**
     * test case to sort the shapes on screen according to OriginDistance when no object is present on screen
     */
    @Test(expected = AssertionError.class)
    public void sortByOriginDistanceTest2() {
        
        Screen screen = new Screen(100, 100);
        
        screen.sortByOriginDistance();
    }
    
    
    /**
     * test case to sort the shapes on screen according to Timestamp
     */
    @Test
    public void sortByTimestampTest1() {
        
        Screen screen = new Screen(100, 100);
        Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        screen.addShape(shape1);
        
        Shape shape2 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(2, 1), new ArrayList<Double>(){{add(2.0);}});
        screen.addShape(shape2);
        
        Shape shape3 = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(0, 0), new ArrayList<Double>(){{add(4.0);}});
        screen.addShape(shape3);
        
        List<Shape> sortedShapeByTimestamp = screen.sortByTimestamp();
        assertEquals(sortedShapeByTimestamp, new ArrayList<Shape>(){{add(shape1); add(shape2); add(shape3);}}); 
    }
    
    
    /**
     * test case to sort the shapes on screen according to Timestamp when no object is present on screen
     */
    @Test(expected = AssertionError.class)
    public void sortByTimestampTest2() {
        
        Screen screen = new Screen(100, 100);
        
        screen.sortByTimestamp();
    }
    
    /**
     * test case for shapesEnclosingPoint 
     */
    @Test
    public void shapesEnclosingPointTest1() {
        
        Screen screen = new Screen(100, 100);
        Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        screen.addShape(shape1);
        
        Shape shape2 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(2, 1), new ArrayList<Double>(){{add(2.0);}});
        screen.addShape(shape2);
        
        Shape shape3 = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(0, 0), new ArrayList<Double>(){{add(4.0);}});
        screen.addShape(shape3);
        
        List<Shape> shapesEnclosingPoint = screen.shapesEnclosingPoint(new Point(2, 1));
        assertEquals(shapesEnclosingPoint, new ArrayList<Shape>(){{add(shape1); add(shape2);}}); 
    }
    
    
    /**
     * test case for shapesEnclosingPoint when list of shapes is empty 
     */
    @Test
    public void shapesEnclosingPointTest2() {
        
        Screen screen = new Screen(100, 100);
        
        screen.shapesEnclosingPoint(new Point(2, 1));
    }

}
