package postfixExpressionEvaluation;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostfixEvaluationTest {

    /**
     * test case to evaluate the postfix expression
     */
    @Test
    public void evaluatePostfixExpressionTest1() {
        
        String postfixExpression = "10 5 2 + *";
        assertEquals(70, PostfixEvaluation.evaluatePostfixExpression(postfixExpression), 0.001);
    }

    
    /**
     * test case when the input is null
     */
    @Test(expected = AssertionError.class)
    public void evaluatePostfixExpressionTest2() {
        
        PostfixEvaluation.evaluatePostfixExpression(null);
    }
    
    
    /**
     * test case when the input is empty
     */
    @Test(expected = AssertionError.class)
    public void evaluatePostfixExpressionTest3() {
        
        PostfixEvaluation.evaluatePostfixExpression("");
    }
    
    
    /**
     * test case when the input expression contains a constant of another type(double in this case)
     */
    @Test(expected = AssertionError.class)
    public void evaluatePostfixExpressionTest4() {
        
        PostfixEvaluation.evaluatePostfixExpression("2.5 8 +");
    }
    
    
    /**
     * test case when the input is improper
     */
    @Test(expected = AssertionError.class)
    public void evaluatePostfixExpressionTest5() {
        
        PostfixEvaluation.evaluatePostfixExpression("+");
    }
    
    
    /**
     * test case when the expression tries to divide by 0
     */
    @Test(expected = AssertionError.class)
    public void evaluatePostfixExpressionTest6() {
        
        PostfixEvaluation.evaluatePostfixExpression("10 0 /");
    }
}
