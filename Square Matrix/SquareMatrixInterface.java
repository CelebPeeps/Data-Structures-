
/**
 * Write a description of interface SquareMatrixInterface here.
 *
 * @Caleb Wang (your name)
 * @12/03/2023 (a version number or a date)
 */
public interface SquareMatrixInterface
{
    public abstract int getSize();
    public abstract void setValue(int row, int column, int value);
    public abstract int getValue (int row, int column);
    public abstract void fillValue (int value);
    public abstract void makeZero();
    public abstract String toString();
    public abstract SquareMatrix subtract(SquareMatrix s);
    public abstract SquareMatrix copy();
    public abstract SquareMatrix add(SquareMatrix random);
    
}
