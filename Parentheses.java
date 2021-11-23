import java.util.Scanner;

public class Parentheses
{
    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args)
    {
        Parentheses pair;
        pair = new Parentheses();
        pair.go();
    }

    public void go()
    {
        System.out.println("Enter a string to check its parenthesis matching: ");
        String s = keyboard.nextLine();

        boolean result = balanced(s);

        System.out.println("");

        if (result)
        {
            System.out.println("The parentheses in the string are balanced");
        }
        else
        {
            System.out.println("The parentheses in the string are not balanced");
        }
    }

    public boolean balanced(String s)
    {
        CS112Stack<Character> stack = new CS112Stack<Character>();

        for (int i = 0; i < s.length(); i++)
        {
            if ((s.charAt(i) == '(') || (s.charAt(i) == '[') || (s.charAt(i) == '{'))
            {
                stack.push(s.charAt(i));
            }
            else if (s.charAt(i) == ')')
            {
                if(stack.isEmpty())
                {
                    return false;
                }
                else if ((stack.top() == '[') || (stack.top() == '{'))
                {
                    return false;
                }
                else if (stack.top() == '(')
                {
                    stack.pop();
                }
            }
            else if (s.charAt(i) == ']')
            {
                if(stack.isEmpty())
                {
                    return false;
                }
                else if ((stack.top() == '(') || (stack.top() == '{'))
                {
                    return false;
                }
                else if (stack.top() == '[')
                {
                    stack.pop();
                }
            }
            else if (s.charAt(i) == '}')
            {
                if(stack.isEmpty())
                {
                    return false;
                }
                else if ((stack.top() == '(') || (stack.top() == '['))
                {
                    return false;
                }
                else if (stack.top() == '{')
                {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}