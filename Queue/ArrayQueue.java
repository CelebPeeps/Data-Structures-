
/**
 * This ArrayQueue class represents . . .
 *
 * @author  (your name)
 * @version (todays date)
 */
public class ArrayQueue<T> implements QueueInterface<T>
{
    private int defaultCap = 100;
    private int size = 0;
    private T[] Queue;
    private int front;
    private int rear;
    private int origCap;
    public ArrayQueue() {
        Queue = (T[]) new Object[defaultCap];
        rear = defaultCap - 1;
        origCap = defaultCap;
    }
    
    public int size() {
        return size;
    }
    
    public boolean empty() {
       return (size == 0);
    }
    
    public void enlarge() {
        T[] largerQueue = (T[]) new Object[Queue.length + origCap];
        int Smaller = front;
        for (int i = 0; i < size; i++) {
            largerQueue[i] = Queue[Smaller];
            Smaller = (Smaller + 1) % Queue.length;
        }
        front = 0;
        rear = size - 1;
        Queue = largerQueue;
    }
    
    public T add(T item) {
        if (size == Queue.length) {
            enlarge();
        }
        rear = (rear + 1) % Queue.length;
        Queue[rear] = item;
        size = size + 1;
        return item;
    }
    
    public T peek() throws QueueUnderflowException {
        if (empty()) {
            throw new QueueUnderflowException();
        }
        return Queue[front];
    }
    
    public T remove() throws QueueUnderflowException {
        if (empty()) {
            throw new QueueUnderflowException();
        }
        T returned = Queue[front];
        Queue[front] = null;
        front = (front + 1) % Queue.length;
        size = size - 1;
        return returned;
    }
    
    public void clear() {
        for (int i = 0; i < Queue.length; i++) {
            if (Queue[i] != null) {
                Queue[i] = null;
            }
        }
        size = 0;
    }
}
