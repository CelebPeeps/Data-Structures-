
/**
 * This BasicPair class represents . . .
 *
 * @author  (your name)
 * @version (todays date)
 */
public class BasicPair<T> implements  PairInterface<T>
{
    private T first;
    private T second;
    public BasicPair(T first, T second){
        this.first = first;
        this.second = second;
    }
    public void setFirst(T x){
        first = x;
    }
    public void setSecond(T x){
        second = x;
    }
    public T getFirst(){
        return first;
    }
    public T getSecond(){
        return second;
    }
}
