
/**
 * This LinkedQueue class represents . . .
 *
 * @author  (your name)
 * @version (todays date)
 */
public class LinkedQueue<T> implements QueueInterface<T>
{
    private LLNode<T> rear;
    private LLNode<T> front;
    private int size = 0;
    
    public LinkedQueue() {
        front = null;
        rear = null;
    }
    
    public int size() {
        return size;
    }
    
    public boolean empty() {
        return (size == 0);
    }
    
    public T add(T item) {
        LLNode<T> newNode = new LLNode<T>(item);
        if (rear == null) {
        front = newNode;
        }
        else {
        rear.setLink(newNode);
        }
        rear = newNode;
        size++;
        return item;
    }
    
    public T peek() throws QueueUnderflowException {
        if (empty()) {
            throw new QueueUnderflowException();
        }
        return front.getInfo();
    }
    
    public T remove() throws QueueUnderflowException {
        if (empty()) {
        throw new QueueUnderflowException("Dequeue attempted on empty queue.");
         }
        else {
        T element;
        element = front.getInfo();
        front = front.getLink();
        if (front == null) {
        rear = null;
        }
        size--;
        return element;
        }
    }
    
    public void clear() {
        size = 0;
    }
}
