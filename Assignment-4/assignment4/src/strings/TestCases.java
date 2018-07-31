package strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCases {

    MyString string = new MyString();
    
    /**
     * Test case to compare two equal strings
     */
    @Test
    public void compareStringTest1() {
       
        int result = string.compareString("Hello", "Hello");
        assertEquals(1, result);
    }
    
    
    /**
     * Test case to compare two unequal strings
     */
    @Test
    public void compareStringTest2() {
       
        int result = string.compareString("Hello", "hello");
        assertEquals(0, result);
    }
    
    
    /**
     * Test case to reverse a string
     */
    @Test
    public void reverseStringTest() {
       
        String result = string.reverseString("Prakalpa");
        assertEquals("aplakarP", result);
    }
    
    
    /**
     * Test case to convert uppercase letters to lowercase letters and vice versa in a string
     */
    @Test
    public void convertStringTest() {
       
        String result = string.convertString("Prakalpa Rathore");
        assertEquals("pRAKALPA rATHORE", result);
    }
    
    
    /**
     * Test case to find largest word in a string
     */
    @Test
    public void largestWordTest1() {
       
        String result = string.largestWord("My name is Prakalpa Rathore");
        assertEquals("Prakalpa", result);
    }
    
    
    /**
     * Test case to find largest word in a string when two words of equal length
     */
    @Test
    public void largestWordTest2() {
       
        String result = string.largestWord("Hello World");
        assertEquals("World", result);
    }

}
