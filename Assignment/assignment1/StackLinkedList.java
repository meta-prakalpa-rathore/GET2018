package assignment1;

class Node {
	int value;
	Node link;
	
	public Node(int val)
	{
		value = val;
	}
	
}

public class StackLinkedList {
	
	Node top = null;
	
	public void push(int value)
	{ 
		if(top==null)
		{
			top = new Node(value);
			top.link = null;
		}
		else
		{
			Node newNode = new Node(value);
			newNode.link = top;
			top = newNode;
		}
	}
	
	public int pop()
	{
		if(top == null)
		{
			System.out.println("The Stack is empty! Cannot pop!");
			return -1;
		}
		
		int val = top.value;
		Node popNode=top;
		top=popNode.link;
		popNode.link=null;
		return val;
	}
	
	public int topValue()
	{
		int val=top.value;
		return val;
	}
	
	public boolean isEmpty()
	{
		if(top == null)
			return true;
		else
			return false;
	}
}


