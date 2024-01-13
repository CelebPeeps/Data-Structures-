/**
 * This FizzBuzz class represents . . .
 *
 * @Caleb Wang  (your name)
 * @8/22/23 (todays date)
 */
public class FizzBuzz
{
    public static void printer () {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                System.out.println(i);
                continue;
            }
            if (i % 3 == 0) {
                if(i % 5 == 0) {
                    System.out.println("Fizz-Buzz");
                    continue;
                }
                System.out.println("Fizz");
                continue;
            }
            System.out.println("Buzz");
        }
    }
}


