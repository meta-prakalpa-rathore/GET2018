package postfixExpressionEvaluation;

import stack.Stack;
import stack.StackLinkedList;

/**
 * this class evaluates the given postfix expression
 * @author Prakalpa-Rathore
 *
 */
public class PostfixEvaluation {

    /**
     * this method evaluates the given postfix expression assuming that the given postfix expression has only integer constants
     * @param postfixExpression
     * @return result of evaluation
     * @throws AssertionError if input is null or invalid or if at some point the denominator is 0
     */
    public static double evaluatePostfixExpression(String postfixExpression) throws AssertionError
    {
        Stack<Double> stack = new StackLinkedList<Double>();
        
        if(postfixExpression == null)
            throw new AssertionError("Invalid Input!");
        
        String[] expressionTokens = postfixExpression.split(" ");
        
        for(String token: expressionTokens)
        {
            if(isInteger(token))
                stack.push((double)Integer.parseInt(token));
            else if(isOperator(token))
            {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                
                switch(token)
                {
                    case "+": stack.push(operand1 + operand2);
                              break;
                              
                    case "-": stack.push(operand1 - operand2);
                              break;
                    
                    case "*": stack.push(operand1 * operand2);
                              break;
                    
                    case "/": if(operand2 == 0)
                                throw new AssertionError("Divide by zero exception");
                              stack.push(operand1 / operand2);
                              break;
                }
            }
            else
                throw new AssertionError("Invalid expresion! Expression must contain only integers and operators!"); 
        }
        
        double result = stack.pop();
        
        if(stack.isEmpty())
            return result;
        else
            throw new AssertionError("Missing operator!");
    }
    
    
    /**
     * helper method to check if the given token is an integer or not
     * @param token
     * @return boolean value
     */
    private static boolean isInteger(String token)
    {
        try
        {
            Integer.parseInt(token);
            return true;
        }
        catch(NumberFormatException exception)
        {
            return false;
        }
    }
    
    
    /**
     * helper method to check if the given token is an operator or not
     * @param token
     * @return boolean value
     */
    private static boolean isOperator(String token)
    {
        boolean isOperator = false;
        
        if("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token))
            isOperator = true;
        
        return isOperator;
    }
}
