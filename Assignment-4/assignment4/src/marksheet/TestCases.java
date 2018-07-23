package marksheet;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCases {

    Marksheet marksheet = new Marksheet();
    
    @Test
    public void testAverage() {
        
        double average = marksheet.average(5, new double[]{80, 67, 57, 40, 85});
        assertEquals(65.8, average, 0.001);
    }
    
    @Test
    public void testMaxGrade() {
        
        double maxGrade = marksheet.maxGrade(5, new double[]{80, 67, 57, 40, 85});
        assertEquals(85, maxGrade, 0.001);
    }

    @Test
    public void testMinGrade() {
        
        double minGrade = marksheet.minGrade(5, new double[]{80, 67, 57, 40, 85});
        assertEquals(40, minGrade, 0.001);
    }
    
    @Test
    public void testStudentsPassedPercent() {
        
        double studentsPassed = marksheet.studentsPassedPercent(5, new double[]{80, 67, 37, 40, 85});
        assertEquals(80, studentsPassed, 0.001);
    }
}
