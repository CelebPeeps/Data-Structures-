
/**
 * This IncDate class represents . . .
 *
 * @author  (your name)
 * @version (todays date)
 */
public class IncDate extends Date
{
    public IncDate(int newMonth, int newDay, int newYear) {
        super(newMonth, newDay, newYear);
    }
    public void increment() {
        int yes = this.lilian() + 1;
        year=this.inverseLilian(yes).getYear();
        month=this.inverseLilian(yes).getMonth();
        day=this.inverseLilian(yes).getDay();
    }
    public void increment(int x) {
        int no = this.lilian() + x;
        year=this.inverseLilian(no).getYear();
        month=this.inverseLilian(no).getMonth();
        day=this.inverseLilian(no).getDay();
    }
}
