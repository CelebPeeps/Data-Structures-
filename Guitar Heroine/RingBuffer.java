/**
 * This RingBuffer object . . .
 * 
 * @author  
 * @version 
 */
public class RingBuffer 
{
    private int size;
    private double [] RingBuffer;
    private int capacity;
    private int front;
    private int rear;
    public RingBuffer(int capacity)
    {
        RingBuffer = new double[capacity];
        this.capacity = capacity;
        front = 0;
        rear = capacity - 1;
    }

    public int size()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return (size == 0);
    }
    
    public boolean isFull()
    {
        return (size == capacity);
    }
    
    public void add(double value)
    {
        if (size == RingBuffer.length) {
            enlarge();
        }
        rear = (rear + 1) % RingBuffer.length;
        RingBuffer[rear] = value;
        size++;
    }
    
    public void enlarge() {
        double [] largerRingBuffer = new double [RingBuffer.length + capacity];
        int Smaller = front;
        for (int i = 0; i < size; i++) {
            largerRingBuffer[i] = RingBuffer[Smaller];
            Smaller = (Smaller + 1) % RingBuffer.length;
        }
        front = 0;
        rear = size - 1;
        RingBuffer = largerRingBuffer;
    }
    
    public double peek()
    {
        return RingBuffer[front];
    }
    
    public double remove()
    {
        double returned = RingBuffer[front];
        RingBuffer[front] = 0.0;
        front = (front + 1) % RingBuffer.length;
        size = size - 1;
        return returned;
    }
    
    // a simple test of the constructor and methods in RingBuffer
    public static void main(String[] args) 
    {
        int capacity = 100;
        RingBuffer buffer = new RingBuffer(capacity);  
        for (int i = 1; i <= capacity; i++) 
            buffer.add(i);
      
        double t = buffer.remove();
        buffer.add(t);
        System.out.println("Size after wrap-around is " + buffer.size());
        while (buffer.size() >= 2) 
        {
            double x = buffer.remove();
            double y = buffer.remove();
            buffer.add(x + y);
        }
        System.out.println(buffer.peek());
    }

}
