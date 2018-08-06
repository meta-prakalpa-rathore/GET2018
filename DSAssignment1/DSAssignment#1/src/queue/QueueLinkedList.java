package queue;

import node.Node;


/**
 * Class for the linked list implementation of the Queue class
 * @author Prakalpa-Rathore
 *
 * @param <E> defines the type of value to be stored in the queue
 */
public class QueueLinkedList<E> implements Queue<E> {

    private Node<E> rear = null;
    private Node<E> front = null;  
    
    
    /**
     * method to add a value at the rear of the queue
     * @param value
     * @return true if element is added to the queue
     */

    @Override
    public boolean enQueue(E value) {
        
        if(rear == null)
        {
            rear = new Node<E>(value);
            rear.setLink(null);
            front = rear;
        }
        else
        {
            Node<E> newNode = new Node<E>(value);
            rear.setLink(newNode);
            newNode.setLink(null);
            rear = newNode;
        }
        
        return true;
    }

    
    /**
     * method to remove a value from the front of the queue
     * @return value that is removed, and throws an AssertionError if queue is empty
     */
    @Override
    public E deQueue() {
        
        E val;
        
        if(!isEmpty())
        {
            if(front == rear)
            {
                val = front.getValue();
                front = null;
                rear = null;
            }
            else
            {
                val = front.getValue();
                Node<E> popNode = front;
                front = popNode.getLink();
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
        
        return rear == null;
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
