package infixToPostfix;

import static org.junit.Assert.*;

import org.junit.Test;

public class InfixToPostfixTest {

    /**
     * test case for converting an infix expression without paranthesis to postfix
     */
    @Test
    public void infixToPostfixTest1() {
        
        String postfixExpression = InfixToPostfix.infixToPostfix("a + b * c");
        assertEquals("abc*+", postfixExpression);
    }
    
    
    /**
     * test case for converting an infix expression with paranthesis to postfix
     */
    @Test
    public void infixToPostfixTest2() {
        
        String postfixExpression = InfixToPostfix.infixToPostfix("( a + b ) * c");
        assertEquals("ab+c*", postfixExpression);
    }

    
    /**
     * test case when input is null
     */
    @Test(expected = AssertionError.class)
    public void infixToPostfixTest3() {
        
        InfixToPostfix.infixToPostfix(null);
    }
    
}
