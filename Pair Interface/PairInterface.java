
/**
 * Write a description of interface PairInterface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface PairInterface<T>
{
     public abstract T getFirst();
     public abstract T getSecond();
     public abstract void setFirst(T x);
     public abstract void setSecond(T x);
}
