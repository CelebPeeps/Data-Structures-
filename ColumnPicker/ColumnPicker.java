import kareltherobot.*;
/**
 * Counts the number of beepers in a column and puts the same
 * number of beepers at the base of the column
 * 
 * @author 
 * @version 
 */
public class ColumnPicker extends Robot
{
    public ColumnPicker(int street, int avenue,
    Direction direction, int beepers){
        super(street, avenue, direction, beepers);
    }
    
    public int countBeeper() {
        if(!nextToABeeper()) {
            return 0;
        }
        pickBeeper();
        return 1 + countBeeper();
    }
    
    public void putBeepers(int count) {
        if (count == 0) {
            return;
        }
        else {
            putBeeper();
            putBeepers(count - 1);
        }
    }
    
    private int countColumn(int streets) {
        int count;
        int putBack;
        if(streets == 0) {
            turnLeft();
            turnLeft();
            return 0;
        }
        else {
            move();
            putBack = countBeeper();
            putBeepers(putBack);
            count = putBack + countColumn(streets - 1);
            move();
            return count;
        }
    }
    
    private void countAndPlacePile()
    {
          int total = countColumn(8);
          putBeepers(total);
    }
   
    public void countAll() {
        if (nextToABeeper()) {
            turnOff();
            return;
        }
        countAndPlacePile();
        turnLeft();
        move();
        turnLeft();
        countAll();
    }
}