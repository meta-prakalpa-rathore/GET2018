package hexadecimalCalculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCases {

    HexCalc hexCalc = new HexCalc();
    
    @Test
    public void testAdd() {
        
        String result = hexCalc.add("a12b4", "2b87c4");
        assertEquals("359A78", result);
    }

    @Test
    public void testSubtract1() {
        
        String result = hexCalc.subtract("a12b4", "2b87c4");
        assertEquals("-217510", result);
    }
    
    @Test
    public void testSubtract2() {
        
        String result = hexCalc.subtract("2b87c4", "a12b4");
        assertEquals("217510", result);
    }
    
    @Test
    public void testMultiply() {
        
        String result = hexCalc.multiply("a12b4", "2b87c4");
        assertEquals("7BCF3DD0", result);
    }
    
    @Test
    public void testDivide1() {
        
        String result = hexCalc.divide("2b87c4", "a12b4");
        assertEquals("4", result);
    }
    
    @Test(expected = AssertionError.class)
    public void testDivide2() {
        
        String result = hexCalc.divide("2b87c4", "0");
    }
    
    @Test
    public void testEqual1() {
        
        boolean result = hexCalc.equal("2b87c4", "a12b4");
        assertFalse(result);
    }
    
    @Test
    public void testEqual2() {
        
        boolean result = hexCalc.equal("00a12b4", "a12b4");
        assertTrue(result);
    }
    
    @Test
    public void testGreaterThan1() {
        
        boolean result = hexCalc.greaterThan("2b87c4", "a12b4");
        assertTrue(result);
    }
    
    @Test
    public void testGreaterThan2() {
        
        boolean result = hexCalc.greaterThan("a12b4", "2b87c4");
        assertFalse(result);
    }
    
    @Test
    public void testLessThan1() {
        
        boolean result = hexCalc.lessThan("2b87c4", "a12b4");
        assertFalse(result);
    }
    
    @Test
    public void testLessThan2() {
        
        boolean result = hexCalc.lessThan("a12b4", "2b87c4");
        assertTrue(result);
    }
    
    @Test
    public void testhexaToDecimal() {
        
        int result = hexCalc.hexaToDecimal("a12b4");
        assertEquals(660148, result);
    }
    
    @Test
    public void testDecimalToHexa() {
        
        String result = hexCalc.decimalToHexa(127654);
        assertEquals("1F2A6", result);
    }
}
