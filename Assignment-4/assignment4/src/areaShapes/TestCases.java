package areaShapes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCases {

    Area area = new Area();
    
    @Test
    public void testAreaOfTriangle() {
        
        double areaOfTriangle = area.areaOfTriangle(10, 6);
        assertEquals(30, areaOfTriangle, 0.001);
    }

    @Test
    public void testAreaOfRectangle() {
        
        double areaOfRectangle = area.areaOfRectangle(10, 6);
        assertEquals(60, areaOfRectangle, 0.001);
    }
    
    @Test
    public void testAreaOfSquare() {
        
        double areaOfSquare = area.areaOfSquare(6);
        assertEquals(36, areaOfSquare, 0.001);
    }
    
    @Test
    public void testAreaOfCircle() {
        
        double areaOfCircle = area.areaOfCircle(6);
        assertEquals(113.04, areaOfCircle, 0.001);
    }
}
