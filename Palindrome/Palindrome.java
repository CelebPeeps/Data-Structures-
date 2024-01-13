
/**
 * This Palindrome class represents . . .
 *
 * @author  (your name)
 * @version (todays date)
 */
public class Palindrome
{
    public static boolean isPalindrome(String str) {
        str = str.replaceAll("[^A-Za-z]+", "").toLowerCase();
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            temp += str.substring(str.length() - i - 1, str.length() - i);
        }
        return str.equals(temp);
    }
}
