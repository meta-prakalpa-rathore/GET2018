package node;


/**
 * this generic class is used to store a value and a link is used to reference another object of same class
 * @author Prakalpa-Rathore
 *
 * @param <E> defines the type of value to be stored 
 */
public class Node<E> {
    
    private E value;
    private Node<E> link;
    
    //constructor
    public Node(E val)
    {
        value = val;
    }  
    
    public E getValue() {
       
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getLink() {
        return link;
    }

    public void setLink(Node<E> link) {
        this.link = link;
    }
  
}
