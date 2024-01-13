import kareltherobot.*;

public class BreadCrumbFollower extends Robot
{
    public BreadCrumbFollower(int s, int a, Direction d, int b)
    {
        super(s,a,d,b);
    }

    // complete the following method (plus others as needed)
    public void travel()
    {
        if(nextToABeeper() && frontIsClear()){
            move();
            travel();
        }
        if(!nextToABeeper()) {
            turnAround();
            move();
            turnAround();
            turnLeft();
            move();
            if(!nextToABeeper()) {
                turnAround();
                move();
                turnAround();
                turnAround();
                if(frontIsClear()) {
                    move();
                    travel();
                }
                else {
                    turnOff();
                }
            }
            else {
                travel();
            }
        }
        else if(nextToABeeper()) {
            turnLeft();
            move();
            travel();
        }
    }
    
    public void turnAround() {
        turnLeft();
        turnLeft();
    }
    
    public void move()
    {
        if(frontIsClear()) {
            super.move();
        }
    }
}