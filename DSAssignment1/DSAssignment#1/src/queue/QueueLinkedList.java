package queue;

import node.Node;


/**
 * Class for the linked list implementation of the Queue class
 * @author Prakalpa-Rathore
 *
 * @param <E> defines the type of value to be stored in the queue
 */
public class QueueLinkedList<E> implements Queue<E> {

    private Node<E> front = null;
    private Node<E> rear = null;  
    
    
    /**
     * method to add a value at the rear of the queue
     * @param value
     * @return true if element is added to the queue
     */

    @Override
    public boolean add(E value) {
        
        if(front == null)
        {
            front = new Node<E>(value);
            front.setLink(null);
            rear = front;
        }
        else
        {
            Node<E> newNode = new Node<E>(value);
            front.setLink(newNode);
            newNode.setLink(null);
            front = newNode;
        }
        
        return true;
    }

    
    /**
     * method to remove a value from the front of the queue
     * @return value that is removed, and throws an AssertionError if queue is empty
     */
    @Override
    public E delete() {
        
        E val;
        
        if(!isEmpty())
        {
            if(rear == front)
            {
                val = rear.getValue();
                rear = null;
                front = null;
            }
            else
            {
                val = rear.getValue();
                Node<E> popNode = rear;
                rear = popNode.getLink();
                popNode.setLink(null);
            }
        }
        else
            throw new AssertionError("The queue is empty!");
        
        return val;
    }

    
    /**
     * method to check if the queue is empty
     * @return boolean value
     */
    @Override
    public boolean isEmpty() {
        
        return front == null;
    }

    
    /**
     * method to check if the queue is full
     * @return boolean value
     */
    @Override
    public boolean isFull() {
        
        return false;
    }

    
}
