
/**
 * This PostfixEvaluator class represents . . .
 *
 * @author  (your name)
 * @version (todays date)
 */
import java.util.Scanner;
import java.util.Stack;
public class PostfixEvaluator
{
    public static int evaluate (String expression) throws PostfixException
    {
        Scanner reader = new Scanner (expression);
        Stack<Integer> stack = new Stack <Integer>();
        int value;
        String operator = "";
        int operator1, operator2;
        int result = 0;

        while (reader.hasNext()){
            if(reader.hasNextInt()){
               value = reader.nextInt();
               stack.push(value);
            }
            else{
                operator = reader.next();
                if (!((operator.equals("/")) || (operator.equals("*")) || (operator.equals("+")) || (operator.equals("-")))){
                    throw new PostfixException ("An illegal symbol was used in the expression. Symbol: " + operator);
                }
                if(!(stack.isEmpty())){
                    operator2 = stack.peek();
                    stack.pop();
                }
                else{
                    throw new PostfixException ("The Stack is empty");
                }
                if(!(stack.isEmpty())){
                    operator1 = stack.peek();
                    stack.pop(); 
                }
                else{
                    throw new PostfixException ("The Stack is empty");
                }
                if (operator.equals ("/" )){
                    result = operator1 / operator2;
                }
                else if (operator.equals("*")){
                    result = operator1 * operator2;
                }
                else if (operator.equals("+")){
                    result = operator1 + operator2;
                }
                else if (operator.equals("-")){
                    result = operator1 - operator2;
                }
                stack.push(result);
            }
        }
        if (stack.isEmpty()){
            throw new PostfixException ("Stack is empty");
        }
        result = stack.peek();
        stack.pop();
        if (!stack.isEmpty()){
            throw new PostfixException ("There are leftover operators");
        }
        return result;
    }
}