
/**
 * This LinkedStack object represents a Stack ADT implemented as
 * a LinkedList using the StackInterface.
 * 
 * @author
 * @version
 */
public class LinkedStack<T> implements StackInterface<T>
{
    private LLNode<T> top;
    private int size;

    public LinkedStack()
    {
        size = 0;
        top = null;
    }

    // returns the logical size of the stack
    public int size()    
    {
        return size;
    }

    // tests if this stack is empty
    public boolean empty()
    {
        return (size == 0);
    }

    // looks at the object at the top of this stack
    // without removing it from the stack
    public T peek()
    {
        if(empty()){
            throw new StackUnderflowException();
        }
        return top.getInfo();
    }

    // removes the object at the top of this stack 
    // and returns that object as the value of this function
    public T pop()
    {
        if(empty()){
            throw new StackUnderflowException();
        }
        T returned = top.getInfo();
        top = top.getLink();
        size--;
        return returned;
    }

    // pushes an item onto the top of this stack
    public T push(T item)
    {
        LLNode<T> temp = new LLNode<T>(item);
        temp.setLink(top);
        top = temp;
        size++;
        return item;
    }

    // removes all of the elements from this stack
    public void clear()
    {
        while(size > 0){
            pop();
        }
    }

    // returns the 1 based position where an object is on this stack
    // note: when the method ends, the stack is the same as it was at the start
    public int search(Object o)
    {
        LLNode<T> temp = top;
        int count = 1;
        while (count <= size){
            if(temp.getInfo().equals(o)){
                return count;
            }
            count++;
            temp = temp.getLink();
        }
        return -1;
    }
}
