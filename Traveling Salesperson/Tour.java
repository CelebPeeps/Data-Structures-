    import java.util.*;
import java.awt.Graphics;

/**
 * This class is a specialized Linked List of Points that represents a
 * Tour of locations attempting to solve the Traveling Salesperson Problem
 * 
 * @author Caleb Wang
 * @version 11/27/2023
 */

public class Tour implements TourInterface
{
    // instance variables
    private int size = 0;
    ListNode front;
    // constructor
    public Tour()
    {
    }
        
    //return the number of points (nodes) in the list   
    public int size()
    {
        return size;
    }

    // append Point p to the end of the list
    public void add(Point p)
    {
        if (size == 0) {
            front = new ListNode(p, null);
        }
        else {
            int index = 0;
            ListNode temp = front;
            while (temp != null && index < size) {
                if (temp.next == null) {
                    temp.next = new ListNode(p, null);
                }
                temp = temp.next;
                index++;
            }
        }
        size++;
    } 
    
    // print every node in the list 
    public void print()
    {   
        if(size != 0) {
            int i = 0;
            ListNode temp = front;
            while (temp != null && i < size) {
                System.out.println(temp.data.toString());
                if (temp.next != null) {
                    temp = temp.next;
                }
                i++;
            }
        }
    }
    
    // draw the tour using the given graphics context
    public void draw(Graphics g)
    {
        if(size != 0) {
            ListNode temp = front;
            ListNode last1 = front;
            while (temp != null) {
                double tempx = temp.data.getX();
                double tempy = temp.data.getY();
                double lastx = last1.data.getX();
                double lasty = last1.data.getY();
                g.fillOval( (int)tempx - 2, (int)tempy - 2, 5, 5);
                g.drawLine((int)tempx, (int)tempy, (int)lastx, (int)lasty);
                last1 = temp;
                temp = temp.next;
            }
            g.drawLine((int) last1.data.getX(), (int) last1.data.getY(), (int) front.data.getX(), (int) front.data.getY());
        }
    }
    
    //calculate the distance of the Tour, but summing up the distance between adjacent points
    //NOTE p.distance(p2) gives the distance where p and p2 are of type Point
    public double distance()
    {
        double dist = 0;
        if(size != 0) {
            ListNode last1 = front;
            ListNode temp = front;
            while (temp != null) {
                dist += temp.data.distance(last1.data);
                last1 = temp;
                temp = temp.next;
            }
            dist+= front.data.distance(last1.data);
        }
        return dist;
    }

    // add Point p to the list according to the NearestNeighbor heuristic
    public void insertNearest(Point p)
    {   
        if(size != 0) {
            ListNode temp = front;
            ListNode last1 = front.next;
            double shortest = p.distance(front.data);
            ListNode closestNode = front;
                while (temp != null) {
                double tempshortest = p.distance(temp.data);
                if (tempshortest <= shortest ) 
                {
                shortest = tempshortest;
                closestNode = temp;
                }
                temp = temp.next;
            }
            temp = closestNode.next;
            closestNode.next = new ListNode(p, temp);
            size++;
        }
        else {
            front = new ListNode(p, null);
            size++;
        }
    }
        
    // add Point p to the list according to the InsertSmallest heuristic
    public void insertSmallest(Point p)
    { 
        if (size > 2) 
        {
            ListNode temp = front;
            ListNode insertNode = temp;
            double oldDistance = -1.0; //temp.data.distance(temp.next.data);
            double changeInDistance = 0.0; //(temp.data.distance(p) + temp.next.data.distance(p)) - temp.data.distance(temp.next.data);
            ListNode tempP = new ListNode(p);
            
            while(temp.next != null)
            {
                changeInDistance = (temp.data.distance(p) + temp.next.data.distance(p)) - temp.data.distance(temp.next.data);
                if(changeInDistance < oldDistance || oldDistance < 0)
                {
                    insertNode = temp;
                    oldDistance = changeInDistance;
                }
                temp = temp.next;
            }
            changeInDistance = front.data.distance(tempP.data) + temp.data.distance(tempP.data) - temp.data.distance(front.data);
            if (changeInDistance < oldDistance) {
            temp.next = tempP;
            }
            else {
                tempP.next = insertNode.next;
                insertNode.next = tempP;
            }
            size++;
        }
        else if (size == 0)
        {
            front = new ListNode(p);
            size++;
        }
        else if (size == 1) {
            front.next = new ListNode(p);
            size++;
        }
        else {
            front.next.next = new ListNode(p);
            size++;
        }
    }
    
    // This is a private inner class, which is a separate class within a class.
    private class ListNode
    {
        private Point data;
        private ListNode next;
        public ListNode(Point p, ListNode n)
        {
            this.data = p;
            this.next = n;
        }
        
        public ListNode(Point p)
        {
            this(p, null);
        }        
    }
    
    
  

}