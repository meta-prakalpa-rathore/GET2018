package assignment1;

import java.util.Stack;

public class Palindrom {
	
	private Stack<Character> stack = new Stack<Character>();
	
	public boolean checkPalindrom(String string)
	{
		for(int i = 0; i < string.length(); i++)
		{
		    stack.push(string.charAt(i));
		}
		
		String reverseStack = "";
		for(int i = string.length()-1; i >= 0 ; i--)
		{
			reverseStack = reverseStack + stack.pop();
		}
		
		if(string.equals(reverseStack))
			return true;
		else 
			return false;
	}
}
