import java.util.Scanner;

public class PostFixEval
{
    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args)
    {
        PostFixEval postfix;
        postfix = new PostFixEval();
        postfix.go();
    }

    public void go()
    {
        System.out.println("Please enter the postfix expression: ");
        String s = keyboard.nextLine();

        Scanner scanner = new Scanner(s);

        int result = value(scanner);

        System.out.println("The result of the postfix expression is: " + result);
    }

    public int value (Scanner s)
    {
        CS112Stack<Integer> stack = new CS112Stack<Integer>();
        String next = "";

        while(!next.equals("="))
        {
           if (s.hasNextInt())
           {
               stack.push(s.nextInt());
           }
           else
           {
               next = s.next();
               if (next.equals("+"))
               {
                   int b = stack.pop();
                   int a = stack.pop();
                   stack.push(a + b);
               }
               else if (next.equals("-"))
               {
                   int b = stack.pop();
                   int a = stack.pop();
                   stack.push(a - b);
               }
               else if (next.equals("*"))
               {
                   int b = stack.pop();
                   int a = stack.pop();
                   stack.push(a * b);
               }
               else if (next.equals("/"))
               {
                   int b = stack.pop();
                   int a = stack.pop();
                   stack.push(a / b);
               }
           }
        }

        return stack.top();
    }
}