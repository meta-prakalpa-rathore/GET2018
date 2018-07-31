package assignment1;

public class StackArray {
	
	private int[] stack= new int[10];
	int top;
	
	public StackArray()
	{
		top=-1;
	}

	public void push(int value)
	{
		if(top == 9)
		{
			System.out.println("The Stack is full! Cannot push!");
			return;
		}
		top++;
		stack[top]=value;
	}
	
	public int pop()
	{
		if(top == -1)
		{
			System.out.println("The Stack is empty! Cannot pop!");
			return -1;
		}
		int value=stack[top];
		top--;
		return value;
	}
	
	public int topValue()
	{
		int value=stack[top];
		return value;
	}
	
	public boolean isEmpty()
	{
		if(top==-1)
			return true;
		else
			return false;
	}
}


