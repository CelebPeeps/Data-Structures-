import java.util.Scanner;

public class BarringtonExceptionDriver
{
    public static void main(String[] args) throws BarringtonException
    {
        Scanner keyboard = new Scanner(System.in);
        while(true)
        {
            System.out.print("Input a string (or \"quit\" to exit) > ");
            String string = keyboard.nextLine();
            if(string.equals("quit"))
                break;
            if(!checkString(string))
                System.out.println("That string does not contain \"Barrington\""+ ".");
        }
    }

    public static boolean checkString(String string) throws BarringtonException
    {
        if(string.contains("Barrington"))
            throw new BarringtonException("Rah for the red and white! Fight! Fight! Fight!"); // throw a BarringtonException here instead with the folowing message
                         // "Rah for the red and white! Fight! Fight! Fight!"
        return false;
    }
}
